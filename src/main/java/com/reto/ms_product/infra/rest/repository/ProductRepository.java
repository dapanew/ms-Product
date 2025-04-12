package com.reto.ms_product.infra.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reto.ms_product.domain.Product;

public interface ProductRepository extends JpaRepository <Product, Integer> {
   
}
