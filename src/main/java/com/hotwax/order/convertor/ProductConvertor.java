package com.hotwax.order.convertor;

import org.springframework.stereotype.Service;

import com.hotwax.order.entities.ProductEntity;
import com.hotwax.order.model.Product;

@Service
public class ProductConvertor {

	public Product productEntityToProduct(ProductEntity entity) {
		Product product = new Product();
		product.setProductId(entity.getProductId());
		product.setPartyId(entity.getPartyId());
		product.setProductName(entity.getProductName());
		product.setDescription(entity.getDescription());
		product.setChargeShipping(entity.getChargeShipping());
		product.setReturnable(entity.getReturnable());
		return product;
	}

	public ProductEntity productToProductEntity(Product product) {
		ProductEntity entity = new ProductEntity();
		entity.setProductId(product.getProductId());
		entity.setPartyId(product.getPartyId());
		entity.setProductName(product.getProductName());
		entity.setDescription(product.getDescription());
		entity.setChargeShipping(product.getChargeShipping());
		entity.setReturnable(product.getReturnable());
		return entity;
	}

}
