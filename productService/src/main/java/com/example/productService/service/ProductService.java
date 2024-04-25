package com.example.productService.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.management.loading.PrivateClassLoader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.productService.ExceptionHandler.ProductServiceException;
import com.example.productService.dto.ProductRequest;
import com.example.productService.dto.ProductResponse;
import com.example.productService.modules.Product;
import com.example.productService.repo.ProductRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
	
	private final ProductRepository productRepository;
	
	public void createProduct(ProductRequest productRequest) {
		System.out.println("Name type: " + productRequest.getName().getClass());
	    System.out.println("Name value: " + productRequest.getName());
	    
	    if (productRequest.getName() == null || productRequest.getName().isEmpty()) {
	        throw new ProductServiceException("Product name is required");
	    }
		
		if (productRequest.getPrice() == null) {// || ((CharSequence) productRequest.getPrice()).isEmpty()) {
            throw new ProductServiceException("Product Price is required");
        }

		Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();
			//.((String)name(productRequest.getName()))
		productRepository.save(product);
	
		log.info("Product {} is saved", product.getId());
	}
	
	

	
	public List<ProductResponse> getAllProducts() {
		List<Product> products= productRepository.findAll();
//		log.info("You are getting response {}::::::", products);
//		//log.info("product response is :::::{}",products.stream().map(this::mapToProductResponse).collect(Collectors.toList()));;
//		return products.stream().map(this::mapToProductResponse).collect(Collectors.toList());
		
		List<ProductResponse> productResponses = products.stream()
	            .map(this::mapToProductResponse)
	            .collect(Collectors.toList());

	    log.info("Mapped ProductResponse list: {}", productResponses);
	    return productResponses;
	}



	private ProductResponse mapToProductResponse(Product product) {
		return ProductResponse.builder()
				.id(product.getId())
				.name(product.getName())
				.description(product.getDescription())
				.price(product.getPrice())
				.build();
		
	}
	 
}
