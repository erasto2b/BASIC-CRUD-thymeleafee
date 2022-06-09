package com.gestion.productos.entidades;

import javax.persistence.*;

@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id" ,nullable = false, length = 60 )
    private Long id ;

    @Column( name ="nombre",nullable = false, length = 60 )
    private String nombre ;

    @Column( name ="marca", nullable = false, length = 60 )
    private String marca ;

    @Column( name ="hecho_en" ,nullable = false, length = 60 )
    private String hechoEn ;

    @Column( name ="precio",nullable = false )
    private float precio ;

    public Producto() {
        super();
    }

    public Producto(Long id, String nombre, String marca, String hechoEn, float precio) {
        this.id = id;
        this.nombre = nombre;
        this.marca = marca;
        this.hechoEn = hechoEn;
        this.precio = precio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getHechoEn() {
        return hechoEn;
    }

    public void setHechoEn(String hechoEn) {
        this.hechoEn = hechoEn;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
}
