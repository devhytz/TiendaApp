package com.devhytz.mitiendaapp.controller;

import com.devhytz.mitiendaapp.dto.ProductoDTO;
import com.devhytz.mitiendaapp.model.*;
import com.devhytz.mitiendaapp.service.*;

import jakarta.validation.Valid;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
    this.productoService = productoService;
}
  
    @PostMapping("/api/producto/crear")
    public ResponseEntity<String> crearProducto(@Valid @RequestBody ProductoDTO producto, BindingResult resultado) {

    if (resultado.hasErrors()) {
        // Retornar 400 Bad Request con el mensaje del error
        return ResponseEntity
            .badRequest()
            .body(resultado.getFieldError().getDefaultMessage());
            //! DefaultMessage retornará el mensaje que se puso en la clase ProductoDTO
    }

    Producto nuevoProducto = new Producto(
        producto.getNombre(),
        producto.getPrecio(),
        producto.getStock()
    );

    productoService.guardarProducto(nuevoProducto);

    return ResponseEntity
        .ok(nuevoProducto.getNombre() + " agregado correctamente");
    }

    @GetMapping("/api/productos")
    public ResponseEntity<List<Producto>> mostrarProductos() {
        List<Producto> productos = productoService.obtenerTodos();
        return ResponseEntity.ok(productos);
    }

    @DeleteMapping("/api/producto/eliminar/{id}")
    public ResponseEntity<String> eliminarProductoPorId(@PathVariable Long id) {
        if (productoService.eliminarProductoPorId(id)) {
            return ResponseEntity.ok("Producto eliminado con éxito");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Producto no encontrado");
        }
    }

    @PutMapping("/api/producto/actualizar/{id}")
    public ResponseEntity<String> actualizarProducto(@PathVariable Long id, @RequestBody @Valid ProductoDTO productoDTO) {
        Producto productoActualizado = productoService.editarProducto(id, productoDTO);

        if (productoActualizado != null) {
            return ResponseEntity.ok("Producto actualizado correctamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Producto no encontrado");
        }
    }

}
