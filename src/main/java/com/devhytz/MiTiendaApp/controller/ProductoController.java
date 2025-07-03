package com.devhytz.mitiendaapp.controller;

import com.devhytz.mitiendaapp.model.*;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductoController {

    @GetMapping("/api/producto")
    public ResponseEntity<Producto> crearObjeto() {
        Producto productoCreado = new Producto("Camiseta", 29.99, 100);
        return ResponseEntity.ok(productoCreado);
    }

    @GetMapping("/api/productos")
    public ResponseEntity<List<Producto>> listaProductos() {
        List<Producto> lista = new ArrayList<>();

        Producto productoUno = new Producto("Camiseta", 29.99, 100);
        Producto productoDos = new Producto("Pantalon", 39.99, 50);
        Producto productoTres = new Producto("Zapatos", 99.99, 10);

        lista.add(productoUno);
        lista.add(productoDos);
        lista.add(productoTres);

        return ResponseEntity.ok(lista);
    }
}
