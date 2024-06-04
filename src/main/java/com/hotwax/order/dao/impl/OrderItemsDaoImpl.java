package com.hotwax.order.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotwax.order.convertor.OrderItemConverter;
import com.hotwax.order.dao.OrderItemsDao;
import com.hotwax.order.entities.OrderItemEntity;
import com.hotwax.order.model.OrderItem;
import com.hotwax.order.repository.OrderItemRepository;

@Service
public class OrderItemsDaoImpl implements OrderItemsDao {

	@Autowired
	OrderItemRepository orderItemRepository;

	@Autowired
	OrderItemConverter orderItemConvertor;

	@Override
	public List<OrderItem> getAllOrderItems() {
		List<OrderItem> result = new ArrayList<>();
		List<OrderItemEntity> entities = orderItemRepository.findAll();
		for (OrderItemEntity entity : entities)
			result.add(this.orderItemConvertor.orderItemEntityToOrderItem(entity));
		return result;
	}

	@Override
	public OrderItem getOrderItemById(String orderItemId, String orderItemSeqId) {
		Optional<OrderItemEntity> entities = orderItemRepository.findByOrderItemSeqIdAndOrderId(orderItemSeqId,
				orderItemId);
		if (entities.isPresent())
			return this.orderItemConvertor.orderItemEntityToOrderItem(entities.get());
		return null;
	}

	@Override
	public OrderItem saveAndUpdateOrderItem(OrderItem orderItem) {
		OrderItemEntity entity = this.orderItemConvertor.orderItemToOrderItemEntity(orderItem);
		entity = this.orderItemRepository.save(entity);
		return this.orderItemConvertor.orderItemEntityToOrderItem(entity);
	}

	@Override
	public void deleteOrderItem(OrderItem result) {
		OrderItemEntity entity = this.orderItemConvertor.orderItemToOrderItemEntity(result);
		entity = this.orderItemRepository.save(entity);

	}

	@Override
	public OrderItem getOrderItemById(String orderId) {
		Optional<OrderItemEntity> entities = orderItemRepository.findById(orderId);
		if (entities.isPresent())
			return this.orderItemConvertor.orderItemEntityToOrderItem(entities.get());
		return null;
	}

	@Override
	public List<OrderItem> getAllOrdersItemsById(String orderId) {
		List<OrderItem> result = new ArrayList<>();
		List<OrderItemEntity> entities = orderItemRepository.findAll();
		for (OrderItemEntity entity : entities) {
			if (entity.getOrderId().equals(orderId))
				result.add(this.orderItemConvertor.orderItemEntityToOrderItem(entity));
		}
		return result;
	}

}
