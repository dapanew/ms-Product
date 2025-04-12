package com.reto.ms_product.infra.rest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reto.ms_product.domain.Product;
import com.reto.ms_product.domain.Response;
import com.reto.ms_product.infra.rest.exception.ResourceNotFoundException;
import com.reto.ms_product.infra.rest.servicies.ProductService;


import static net.logstash.logback.argument.StructuredArguments.value;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;






@RestController
@RequestMapping("/api/products")
public class ProductController {
@Autowired
 private   ProductService service;
 private static final Logger log = LoggerFactory.getLogger(ProductController.class);

@GetMapping("/getAllProducts")
public List<Product> getAllProducts() {
    return  service.findAll();
}

@GetMapping("/{idProduct}")
public ResponseEntity<?> getProductId(@PathVariable Long idProduct) {
        log.info(null, value("path", "/api/products/{idProduct}"), value("msg", "consulta de producto por id " + idProduct));
        Optional<Product> userOptional = service.findById(idProduct);
        Product product = service.findById(idProduct)
                .orElseThrow(() -> new ResourceNotFoundException("Producto con ID " + idProduct + " no encontrado"));
        Response res = new Response();
        res.setRespuesta(product);
       return ResponseEntity.status(HttpStatus.OK).body(userOptional.orElseThrow());
    }
    @PostMapping("/saveProduct")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
        log.info(null, value("path", "/api/products/saveProduct"), value("msg", "guardando producto " + product.getIdproductos()));
        Product savedProduct = service.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
    }
  @PutMapping("/updateProduct/{idProduct}")
  public ResponseEntity <Product>updateProduct(@PathVariable Long idProduct, @RequestBody Product product) {
    Optional<Product> productOptional = service.findById(idProduct);
    if(productOptional.isPresent()){
        Product productBd= productOptional.get();
        productBd.setNombre(product.getNombre());
        productBd.setDescripcion(product.getDescripcion());
        productBd.setPrecio(product.getPrecio());  
        productBd.setStock(product.getStock());
        productBd.setEstado(product.getEstado());
        return ResponseEntity.ok(service.save(productBd));
    }
    return ResponseEntity.status(HttpStatus.NOT_FOUND).build() ;
}
@DeleteMapping("/deleteProduct/{idProduct}")
public ResponseEntity<?> deleteProduct(@PathVariable Long idProduct) {
    log.info(null, value("path", "/api/products/deleteProduct/{idProduct}"), value("msg", "eliminando producto " + idProduct));
    Optional<Product> productOptional = service.findById(idProduct);
    if (productOptional.isPresent()) {
        service.deleteById(idProduct);
        return ResponseEntity.status(HttpStatus.OK).body("Producto eliminado con exito");
    } else {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Producto no encontrado");
    }
}

  

  
    
}
