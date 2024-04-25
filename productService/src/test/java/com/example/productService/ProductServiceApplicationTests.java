package com.example.productService;

//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import java.math.BigDecimal;
//
//import org.apache.tomcat.util.digester.SetPropertiesRule;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.DynamicPropertyRegistry;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.ResultActions;
//import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.testcontainers.containers.MongoDBContainer;
//import org.testcontainers.junit.jupiter.Testcontainers;
////import org.testcontainers.shaded.com.github.dockerjava.core.MediaType;
//import org.testcontainers.utility.DockerImageName;
//import org.springframework.http.MediaType;
//import com.example.productService.dto.ProductRequest;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//@SpringBootTest
//@Testcontainers
//@AutoConfigureMockMvc
//class ProductServiceApplicationTests {
//
//	static MongoDBContainer mongoDBContainer=new MongoDBContainer("mongo:4.4.2");//DockerImageName 
//	
//	@Autowired
//	private MockMvc mockMvc;
//	
//	@Autowired
//	private ObjectMapper objectMapper;
//	
//	static void SetProperties(DynamicPropertyRegistry dynamicPropertyRegistry) {
//		dynamicPropertyRegistry.add("spring.data.mongodb.uri", mongoDBContainer::getReplicaSetUrl);
//	}
//	
//	@Test
//	void shouldCreateProduct() throws Exception {
//		ProductRequest productRequest=getProductRequest();
//		String productRequestString=objectMapper.writeValueAsString(productRequest);
//		
//		 ((ResultActions) ((MockHttpServletRequestBuilder) mockMvc.perform(MockMvcRequestBuilders.post("/api/products")))
//		 .contentType(MediaType.APPLICATION_JSON)
//		.content(productRequestString))
//		.andExpect(status().isCreated());
//	}
//	private ProductRequest getProductRequest() {
//		return ProductRequest.builder()
//				.name("Iphone")
//				.description("test input")
//				.price(BigDecimal.valueOf(4444444))
//				.build();				
//	}
//
//}

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.productService.dto.ProductRequest;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
class ProductServiceApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;    

    @Test
    void shouldCreateProduct() throws Exception {
        // Create a ProductRequest object
        ProductRequest productRequest = getProductRequest();
        
        // Serialize ProductRequest object to JSON string
        String productRequestString = objectMapper.writeValueAsString(productRequest);

        // Perform POST request with JSON body
        mockMvc.perform(MockMvcRequestBuilders.post("/api/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content(productRequestString))
                .andExpect(status().isCreated()); // Expect HTTP 201 Created status
    }

    private ProductRequest getProductRequest() {
        return ProductRequest.builder()
                .name("Iphone")
                .description("test input")
                .price(BigDecimal.valueOf(4444444))
                .build();
    }
}

