package com.hotwax.order.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotwax.order.dao.OrderItemsDao;
import com.hotwax.order.entities.OrderItemEntity;
import com.hotwax.order.exception.ServiceException;
import com.hotwax.order.model.OrderItem;
import com.hotwax.order.model.ServiceResponse;
import com.hotwax.order.services.OrderItemService;

@Service
public class OrderItemsServiceImpl implements OrderItemService {

	@Autowired
	private OrderItemsDao orderItemsDao;

	@Override
	public ServiceResponse<List<OrderItem>> getAllOrderItems() throws ServiceException {

		String message = "Success";
		List<OrderItem> result = new ArrayList<OrderItem>();
		try {
			result = orderItemsDao.getAllOrderItems();
			if (result.isEmpty()) {
				message = "No Result";
			}
		} catch (Exception ex) {
			throw new ServiceException(ex.getMessage());
		}
		return new ServiceResponse<List<OrderItem>>(200, message, result);
	}

	@Override
	public ServiceResponse<OrderItem> getOrderItemById(String orderId) throws ServiceException {
		String message = "Success";
		OrderItem result = null;
		try {
			result = orderItemsDao.getOrderItemById(orderId);
			if (result == null) {
				message = "No Result";
			}
		} catch (Exception ex) {
			throw new ServiceException(ex.getMessage());
		}
		return new ServiceResponse<OrderItem>(200, message, result);
	}

	@Override
	public ServiceResponse<OrderItem> saveOrderItem(OrderItem orderItem) throws ServiceException {
		String message = "Success";
		OrderItem result = null;
		try {
			result = orderItemsDao.saveAndUpdateOrderItem(orderItem);
			if (result.getOrderId() == null) {
				message = "No Result";
			}
		} catch (Exception ex) {
			throw new ServiceException(ex.getMessage());
		}
		return new ServiceResponse<OrderItem>(200, message, result);
	}

	@Override
	public ServiceResponse<OrderItem> updateOrderItemById(String orderId, OrderItem updatedOrderItem)
			throws ServiceException {
		String message = "Success";
		OrderItem result = null;
		try {
			updatedOrderItem.setOrderId(orderId);
			result = orderItemsDao.saveAndUpdateOrderItem(updatedOrderItem);
		} catch (Exception ex) {
			throw new ServiceException(ex.getMessage());
		}
		return new ServiceResponse<OrderItem>(200, message, result);
	}

	@Override
	public ServiceResponse<OrderItem> deleteOrderItem(String orderId, String orderItemSeqId) throws ServiceException {
		String message = "Success";
		OrderItem result = null;
		try {
			result = orderItemsDao.getOrderItemById(orderId, orderItemSeqId);
			if (result == null) {
				message = "No Result";
			}
			orderItemsDao.deleteOrderItem(result);
		} catch (Exception ex) {
			throw new ServiceException(ex.getMessage());
		}
		return new ServiceResponse<OrderItem>(200, message, result);
	}

}
