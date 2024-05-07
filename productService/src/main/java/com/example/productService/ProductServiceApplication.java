package com.example.productService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

@SpringBootApplication
//@ComponentScan( basePackages = { "com.example.productService" } )
public class ProductServiceApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}
	
//	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        // Disable static resource handling
//        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
//    }

}
