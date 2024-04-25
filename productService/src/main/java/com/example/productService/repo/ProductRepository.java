package com.example.productService.repo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.productService.modules.Product;
@Repository
public interface ProductRepository extends MongoRepository<Product, String>{
//testing
	
}
