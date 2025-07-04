package com.devhytz.mitiendaapp.service;

import java.util.List;

import java.util.Optional;
import org.springframework.stereotype.Service;

import com.devhytz.mitiendaapp.dto.ProductoDTO;
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

    public boolean eliminarProductoPorId(Long id) {
        if (productoRepository.existsById(id)) {
            productoRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public Producto editarProducto(Long id, ProductoDTO dto) {
        Optional<Producto> productoOptional = productoRepository.findById(id);

        if (productoOptional.isPresent()) {
            Producto productoExistente = productoOptional.get();
            productoExistente.setNombre(dto.getNombre());
            productoExistente.setPrecio(dto.getPrecio());
            productoExistente.setStock(dto.getStock());

            return productoRepository.save(productoExistente);
        }

        return null;
    }



}
