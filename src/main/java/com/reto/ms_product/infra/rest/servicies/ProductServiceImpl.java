package com.reto.ms_product.infra.rest.servicies;

import java.util.List;
import java.util.Optional;
 
import org.springframework.stereotype.Service;

import com.reto.ms_product.domain.Product;
import com.reto.ms_product.infra.rest.repository.ProductRepository;
@Service
public class ProductServiceImpl implements ProductService {
    // Inyeccion de dependencias
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long idProducto) {
        return productRepository.findById(idProducto.intValue());
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteById(long idProducto) {
        productRepository.deleteById((int) idProducto);
    }


}
