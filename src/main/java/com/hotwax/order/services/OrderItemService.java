package com.hotwax.order.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hotwax.order.exception.ServiceException;
import com.hotwax.order.model.OrderItem;
import com.hotwax.order.model.ServiceResponse;

@Service
public interface OrderItemService {

	ServiceResponse<List<OrderItem>> getAllOrderItems() throws ServiceException;

	ServiceResponse<OrderItem> getOrderItemById(String orderId) throws ServiceException;

	ServiceResponse<OrderItem> saveOrderItem(OrderItem orderItem) throws ServiceException;

	ServiceResponse<OrderItem> updateOrderItemById(String orderId, OrderItem updatedOrderItem) throws ServiceException;

	ServiceResponse<OrderItem> deleteOrderItem(String orderId, String orderItemSeqId) throws ServiceException;

}
