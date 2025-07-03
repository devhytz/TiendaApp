package com.devhytz.mitiendaapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaludoController {
    
    @GetMapping("/api/hola")
    public String saludo(){
        return "Hola desde Spring Boot!";
    }
}
