package com.gestion.productos.repositorio;

import com.gestion.productos.entidades.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductoRepositorio extends JpaRepository <Producto, Long>{

    @Query("SELECT p from Producto p WHERE" +
            " CONCAT(p.id , p.nombre , p.marca, p.hechoEn , p.precio)"
            + "LIKE %?1%")

    public List<Producto> findAll(String palabraClave);
}
