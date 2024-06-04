package com.hotwax.order.convertor;

import org.springframework.stereotype.Service;

import com.hotwax.order.entities.OrderItemEntity;
import com.hotwax.order.model.OrderItem;

@Service
public class OrderItemConverter {

	public OrderItem orderItemEntityToOrderItem(OrderItemEntity entity) {
		OrderItem orderItem=new OrderItem();
		orderItem.setItemDescription(entity.getItemDescription());
		orderItem.setItemTypeEnumId(entity.getItemTypeEnumId());
		orderItem.setOrderId(entity.getOrderId());
		orderItem.setOrderItemSeqId(entity.getOrderItemSeqId());
		orderItem.setProductId(entity.getProductId());
		orderItem.setQuantity(entity.getQuantity());
		orderItem.setUnitAmount(entity.getUnitAmount());
		
		return orderItem;
	}

	public OrderItemEntity orderItemToOrderItemEntity(OrderItem orderItem) {
		OrderItemEntity orderItemEntity=new OrderItemEntity();
		orderItemEntity.setItemDescription(orderItem.getItemDescription());
		orderItemEntity.setItemTypeEnumId(orderItem.getItemTypeEnumId());
		orderItemEntity.setOrderId(orderItem.getOrderId());
		orderItemEntity.setOrderItemSeqId(orderItem.getOrderItemSeqId());
		orderItemEntity.setProductId(orderItem.getProductId());
		orderItemEntity.setQuantity(orderItem.getQuantity());
		orderItemEntity.setUnitAmount(orderItem.getUnitAmount());
		
		return orderItemEntity;
	}

}
