package com.devhytz.mitiendaapp.controller;

import com.devhytz.mitiendaapp.model.*;

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
}
