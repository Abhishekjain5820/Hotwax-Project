package com.hotwax.order.services;

import java.util.List;

import com.hotwax.order.entities.ProductEntity;
import com.hotwax.order.exception.ServiceException;
import com.hotwax.order.model.Product;
import com.hotwax.order.model.ServiceResponse;

public interface ProductService {

	ServiceResponse<List<Product>> getAllProducts() throws ServiceException;

	ServiceResponse<Product> getProductById(String productId) throws ServiceException;

	ServiceResponse<Product> saveProduct(Product product) throws ServiceException;

	ServiceResponse<Product> updateProductById(String productId, Product updatedProduct) throws ServiceException;

	ServiceResponse<Product> deleteProduct(String productId) throws ServiceException;

}