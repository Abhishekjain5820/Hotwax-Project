package com.hotwax.order.dao;

import java.util.List;

import com.hotwax.order.model.Product;

public interface ProductDao {

	List<Product> getAllProducts();

	Product getProductById(String productId);

	Product saveAndUpdateProduct(Product product);

	void delete(Product result);

}
