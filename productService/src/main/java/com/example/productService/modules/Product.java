package com.example.productService.modules;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Builder
//@Data
//@Document//(value=product)
//@AllArgsConstructor
//@NoArgsConstructor
//public class Product {
//	@Id
//	private String id;
//	private String name;
//	private String description;
//	private BigDecimal price;
//	
//	public static ProductBuilder builder() {
//        return new ProductBuilder();
//    }
//	
//	
//}
	
@Document
@Data
	public class Product {
		@Id
		private String id;
	    private String name;
	    private String description;
	    private BigDecimal price;

	    // Private constructor to force usage of builder
	    private Product(String name, String description, BigDecimal price) {
	        this.name = name;
	        this.description = description;
	        this.price = price;
	    }

	    public static ProductBuilder builder() {
	        return new ProductBuilder();
	    }

	    public static class ProductBuilder {
	        private String name;
	        private String description;
	        private BigDecimal price;

	        public ProductBuilder name(String name) {
	            this.name = name;
	            return this;
	        }

	        public ProductBuilder description(String description) {
	            this.description = description;
	            return this;
	        }

	        public ProductBuilder price(BigDecimal price) {
	            this.price = price;
	            return this;
	        }

	        public Product build() {
	            return new Product(name, description, price);
	        }
	    }

	    // Getters and setters (omitted for brevity)
	}

