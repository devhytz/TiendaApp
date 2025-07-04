package com.devhytz.mitiendaapp.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;


public class ProductoDTO {

    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombre;

    @Positive(message = "El precio debe ser mayor a 0")
    private double precio;

    @Min(value = 1, message = "El stock debe ser mínimo 1")
    private int stock;

    public ProductoDTO(){

    }

    //* Getters

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }
}
