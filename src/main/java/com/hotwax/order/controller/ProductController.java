package com.hotwax.order.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotwax.order.exception.ServiceException;
import com.hotwax.order.model.ApiResponse;
import com.hotwax.order.model.Product;
import com.hotwax.order.model.ServiceResponse;
import com.hotwax.order.services.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	@Autowired
	private ProductService productService;

	@GetMapping
	public ResponseEntity<ApiResponse> getAllProducts() throws ServiceException {
		LocalDateTime startApiDateTime = LocalDateTime.now();
		ServiceResponse<List<Product>> serviceResponse = productService.getAllProducts();
		return prepareResponse(serviceResponse, startApiDateTime);
	}

	@GetMapping("/{productId}")
	public ResponseEntity<ApiResponse> getProductById(@PathVariable String productId) throws ServiceException {
		LocalDateTime startApiDateTime = LocalDateTime.now();
		ServiceResponse<Product> serviceResponse = productService.getProductById(productId);
		return prepareResponse(serviceResponse, startApiDateTime);
	}

	@PostMapping
	public ResponseEntity<ApiResponse> createProduct(@RequestBody Product product) throws ServiceException {
		LocalDateTime startApiDateTime = LocalDateTime.now();
		ServiceResponse<Product> serviceResponse = productService.saveProduct(product);
		return prepareResponse(serviceResponse, startApiDateTime);
	}

	@PutMapping("/{productId}")
	public ResponseEntity<ApiResponse> updateProduct(@PathVariable String productId,
			@RequestBody Product updatedProduct) throws ServiceException {
		LocalDateTime startApiDateTime = LocalDateTime.now();
		ServiceResponse<Product> serviceResponse = productService.updateProductById(productId, updatedProduct);
		return prepareResponse(serviceResponse, startApiDateTime);
	}

	@DeleteMapping("/{productId}")
	public ResponseEntity<ApiResponse> deleteProduct(@PathVariable String productId) throws ServiceException {
		LocalDateTime startApiDateTime = LocalDateTime.now();
		ServiceResponse<Product> serviceResponse = productService.deleteProduct(productId);
		return prepareResponse(serviceResponse, startApiDateTime);
	}

	private ResponseEntity<ApiResponse> prepareResponse(ServiceResponse<?> serviceResponse,
			LocalDateTime startApiDateTime) {
		ApiResponse apiResponse = new ApiResponse();
		apiResponse.setStartDateTime(startApiDateTime);
		apiResponse.setBody(serviceResponse.getBody());
		apiResponse.setMessage(serviceResponse.getMessage());
		apiResponse.setEndDateTime(LocalDateTime.now());
		return ResponseEntity.status(HttpStatusCode.valueOf(serviceResponse.getCode())).body(apiResponse);
	}
}
