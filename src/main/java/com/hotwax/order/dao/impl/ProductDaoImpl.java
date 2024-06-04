package com.hotwax.order.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotwax.order.convertor.ProductConvertor;
import com.hotwax.order.dao.ProductDao;
import com.hotwax.order.entities.ProductEntity;
import com.hotwax.order.model.Product;
import com.hotwax.order.repository.ProductRepository;

@Service
public class ProductDaoImpl implements ProductDao{

	
	@Autowired
	ProductRepository productRepository;

	@Autowired
	ProductConvertor productConvertor;

	
	@Override
	public List<Product> getAllProducts() {
		List<Product> result = new ArrayList<>();
		List<ProductEntity> entities = productRepository.findAll();
		for (ProductEntity entity : entities)
			result.add(this.productConvertor.productEntityToProduct(entity));
		return result;
	}

	@Override
	public Product getProductById(String productId) {
		Optional<ProductEntity> entities = productRepository.findById(productId);
		if (entities.isPresent())
			return this.productConvertor.productEntityToProduct(entities.get());
		return null;
	}

	@Override
	public Product saveAndUpdateProduct(Product product) {
		ProductEntity entity = this.productConvertor.productToProductEntity(product);
		entity = this.productRepository.save(entity);
		return this.productConvertor.productEntityToProduct(entity);
	}

	@Override
	public void delete(Product result) {
		ProductEntity entity = this.productConvertor.productToProductEntity(result);
		entity = this.productRepository.save(entity);
		
	}

	
}
