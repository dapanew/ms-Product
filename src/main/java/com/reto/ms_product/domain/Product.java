package com.reto.ms_product.domain;

import java.time.LocalDate;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "product", schema="db_backend_users")   
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idproductos;
    private String nombre;
    private String descripcion;
    private int precio;
    private int stock;
    private  String estado;

    
     //@Column(name = "fechaPoblamiento") // Nombre EXACTO como en tu tabla MySQL
     @Column(name = "fechaPoblamiento", nullable = false, updatable = false,
     columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
     private LocalDate fechaPoblamiento;


    public int getIdproductos() {
        return idproductos;
    }
    public void setIdproductos(int idproductos) {
        this.idproductos = idproductos;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public int getPrecio() {
        return precio;
    }
    public void setPrecio(int precio) {
        this.precio = precio;
    }
    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public LocalDate getFechaPoblamiento() {
        return fechaPoblamiento;
    }
    public void setFechaPoblamiento(LocalDate fechaPoblamiento) {
        this.fechaPoblamiento = fechaPoblamiento;
    }

    

    


}
