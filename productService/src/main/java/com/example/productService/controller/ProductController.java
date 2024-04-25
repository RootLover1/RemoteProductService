package com.example.productService.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.productService.ExceptionHandler.ProductServiceException;
import com.example.productService.dto.ProductRequest;
import com.example.productService.dto.ProductResponse;
import com.example.productService.service.ProductService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    
	private final ProductService productService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void createProduct1(@RequestBody ProductRequest productRequest) {
		productService.createProduct(productRequest);
	}
	
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<ProductResponse>> getAllProducts(){
		System.out.println("you are in get controller");
//		List<ProductResponse> allresponseList=productService.getAllProducts();
//		System.out.println("Get controller response: "+ allresponseList);
//	    return allresponseList;    
	    
	    try {
            List<ProductResponse> allResponseList = productService.getAllProducts();
            System.out.println("in try block: "+ allResponseList);
           return ResponseEntity.ok(allResponseList); // Return 200 OK with the product list
          //(List<ProductResponse>)  
            
        } catch (Exception e) {
            // Handle exceptions and return appropriate HTTP status codes
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
	}
	
	 @ExceptionHandler(ProductServiceException.class)
	 @ResponseStatus(HttpStatus.BAD_REQUEST)
	 public String handleProductServiceException(ProductServiceException ex) {
	     return ex.getMessage();
	 }
}
