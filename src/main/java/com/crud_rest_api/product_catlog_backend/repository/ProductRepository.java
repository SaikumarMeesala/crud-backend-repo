package com.crud_rest_api.product_catlog_backend.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.crud_rest_api.product_catlog_backend.entity.Product;


public interface ProductRepository extends JpaRepository<Product,Integer> {

}
