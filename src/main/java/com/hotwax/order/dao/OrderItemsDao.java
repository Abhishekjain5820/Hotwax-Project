package com.hotwax.order.dao;

import java.util.List;

import com.hotwax.order.model.OrderItem;

public interface OrderItemsDao {

	

	OrderItem getOrderItemById(String orderId);

	OrderItem saveAndUpdateOrderItem(OrderItem orderItem);


	OrderItem getOrderItemById(String orderId, String orderItemSeqId);

	void deleteOrderItem(OrderItem result);

	List<OrderItem> getAllOrderItems();

	List<OrderItem> getAllOrdersItemsById(String orderId);

}
