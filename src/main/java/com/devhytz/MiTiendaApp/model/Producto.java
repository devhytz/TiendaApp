package com.devhytz.mitiendaapp.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String nombre;
    private double precio;
    private int stock;

    
    public Producto() {
     //* Constructor vacío   
    }

    public Producto(String nombre, double precio, int stock) {
        //* Constructor parametrizado
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public Producto(Producto copia) {
        //* Constructor copia
        this.nombre = copia.nombre;
        this.precio = copia.precio;
        this.stock = copia.stock;
    }

    //* Getters para cada atributo de clase

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
