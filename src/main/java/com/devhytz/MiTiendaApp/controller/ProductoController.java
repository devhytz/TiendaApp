package com.devhytz.mitiendaapp.controller;

import com.devhytz.mitiendaapp.model.*;
import com.devhytz.mitiendaapp.service.*;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
    this.productoService = productoService;
}

    @GetMapping("/api/producto/crear")
    public void crearObjeto() {
        Producto productoNuevo = new Producto("Camiseta", 29.99, 100);
        productoService.guardarProducto(productoNuevo);

    }

    @GetMapping("/api/productos")
    public List<Producto> listaProductos() {
        return productoService.obtenerTodos();
    }
}
