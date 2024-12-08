package com.crud_rest_api.product_catlog_backend.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.crud_rest_api.product_catlog_backend.entity.Product;
import com.crud_rest_api.product_catlog_backend.repository.ProductRepository;
@CrossOrigin(origins = "http://localhost:3001")
@RestController
public class ProductController {
    @Autowired
    ProductRepository repo;
    @GetMapping("/products")
    public List<Product> getAllProducts(){
        List<Product> products = repo.findAll();
        return products;
    }
    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable int id){
        Product products=repo.findById(id).get();
        return products;
    }
    @PostMapping("/products/add")
    @ResponseStatus(code=HttpStatus.CREATED)
    public void createProduct(@RequestBody Product product){
        repo.save(product);
    }
    @PutMapping("/products/update/{id}")
    public Product updateProduct(@PathVariable int id,@RequestBody Product updatedProduct){
        Product product=repo.findById(id).get();
        product.setProductName(updatedProduct.getProductName());
        product.setProductPrice(updatedProduct.getProductPrice());
        product.setProductQuantity(updatedProduct.getProductQuantity());
        repo.save(product);
        return product;
    }
    @DeleteMapping("/products/delete/{id}")
    public Product deleteProduct(@PathVariable int id){
        Product product=repo.findById(id).get();
        repo.delete(product);
        return product;
    }
}
