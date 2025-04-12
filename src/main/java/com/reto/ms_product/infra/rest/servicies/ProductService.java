package com.reto.ms_product.infra.rest.servicies;

import java.util.List;
import java.util.Optional;

import com.reto.ms_product.domain.Product;

public interface ProductService {
List<Product> findAll();
    Optional <Product> findById(Long idProducto);
    Product save(Product product);
    void deleteById(long idProducto); 
}
