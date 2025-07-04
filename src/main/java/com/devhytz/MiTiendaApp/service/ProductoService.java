package com.devhytz.mitiendaapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.devhytz.mitiendaapp.model.Producto;
import com.devhytz.mitiendaapp.repository.ProductoRepository;

@Service
public class ProductoService {

    //* Inyectamos el repositorio de la clase Producto

    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    //* Definimos los metodos que componen la lógica del negocio

    public Producto guardarProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    public List<Producto> obtenerTodos() {
        return productoRepository.findAll();
    }
}
