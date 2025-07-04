package com.devhytz.mitiendaapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devhytz.mitiendaapp.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

}
