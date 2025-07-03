package com.devhytz.mitiendaapp.model;

public class Producto {
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
}
