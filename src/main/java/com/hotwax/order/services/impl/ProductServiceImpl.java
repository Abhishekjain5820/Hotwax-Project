package com.hotwax.order.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotwax.order.dao.PersonDao;
import com.hotwax.order.dao.ProductDao;
import com.hotwax.order.entities.ProductEntity;
import com.hotwax.order.exception.ServiceException;
import com.hotwax.order.model.Person;
import com.hotwax.order.model.Product;
import com.hotwax.order.model.ServiceResponse;
import com.hotwax.order.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;
	
	@Override
	public ServiceResponse<List<Product>> getAllProducts() throws ServiceException {
		String message = "Success";
		List<Product> result = new ArrayList<Product>(); 
		try {
			result = productDao.getAllProducts();
			if(result.isEmpty()) {
				message = "No Result";
			}
		} catch (Exception ex) {
			throw new ServiceException("");
		}
		return new ServiceResponse<List<Product>>(200, message, result);
	}

	@Override
	public ServiceResponse<Product> getProductById(String productId) throws ServiceException {
		String message = "Success";
		Product result = null; 
		try {
			result = productDao.getProductById(productId);
			if(result == null) {
				message = "No Result";
			}
		} catch (Exception ex) {
			throw new ServiceException(ex.getMessage());
		}
		return new ServiceResponse<Product>(200, message, result);
	}

	@Override
	public ServiceResponse<Product> saveProduct(Product product) throws ServiceException {
		String message = "Success";
		Product result = null; 
		try {
			result = productDao.saveAndUpdateProduct(product);
			if(result.getPartyId() == null) {
				message = "No Result";
			}
		} catch (Exception ex) {
			throw new ServiceException(ex.getMessage());
		}
		return new ServiceResponse<Product>(200, message, result);
	}

	@Override
	public ServiceResponse<Product> updateProductById(String productId, Product updatedProduct) throws ServiceException {
		String message = "Success";
		Product result = null; 
		try {
			updatedProduct.setPartyId(productId);
			result = productDao.saveAndUpdateProduct(updatedProduct);
		} catch (Exception ex) {
			throw new ServiceException(ex.getMessage());
		}
		return new ServiceResponse<Product>(200, message, result);
	}

	@Override
	public ServiceResponse<Product> deleteProduct(String productId) throws ServiceException {
		String message = "Success";
		Product result = null; 
		try {
			result = productDao.getProductById(productId);
			if(result == null) {
				message = "No Result";
			}
			productDao.delete(result);
		} catch (Exception ex) {
			throw new ServiceException(ex.getMessage());
		}
		return new ServiceResponse<Product>(200, message, result);
	}

}
