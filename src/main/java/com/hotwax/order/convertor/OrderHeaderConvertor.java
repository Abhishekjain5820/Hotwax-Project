package com.hotwax.order.convertor;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hotwax.order.entities.OrderHeaderEntity;
import com.hotwax.order.model.OrderHeader;
import com.hotwax.order.model.OrderItem;

@Service
public class OrderHeaderConvertor {

	public OrderHeaderEntity orderHeaderToOrderHeaderEntity(OrderHeader result) {
		OrderHeaderEntity orderHeaderEntity = new OrderHeaderEntity();
		orderHeaderEntity.setApprovedDate(result.getApprovedDate());
		orderHeaderEntity.setCompletedDate(result.getCompletedDate());
		orderHeaderEntity.setCurrencyUomId(result.getCurrencyUomId());
		orderHeaderEntity.setGrandTotal(result.getGrandTotal());
		orderHeaderEntity.setOrderDate(result.getOrderDate());
		orderHeaderEntity.setOrderId(result.getOrderId());
		orderHeaderEntity.setOrderName(result.getOrderName());
		orderHeaderEntity.setPartyId(result.getPartyId());
		orderHeaderEntity.setPlacedDate(result.getPlacedDate());
		orderHeaderEntity.setProductStoreId(result.getProductStoreId());
		orderHeaderEntity.setSalesChannelEnumId(result.getSalesChannelEnumId());
		orderHeaderEntity.setStatusId(result.getStatusId());
		orderHeaderEntity.setSalesChannelEnumId(result.getSalesChannelEnumId());
		return orderHeaderEntity;
	}

	public OrderHeader ordrHeaderEntityToOrderHeader(OrderHeaderEntity entity) {
		OrderHeader orderHeader = new OrderHeader();
		orderHeader.setApprovedDate(entity.getApprovedDate());
		orderHeader.setCompletedDate(entity.getCompletedDate());
		orderHeader.setCurrencyUomId(entity.getCurrencyUomId());
		orderHeader.setGrandTotal(entity.getGrandTotal());
		orderHeader.setOrderDate(entity.getOrderDate());
		orderHeader.setOrderId(entity.getOrderId());
		orderHeader.setOrderName(entity.getOrderName());
		orderHeader.setPartyId(entity.getPartyId());
		orderHeader.setPlacedDate(entity.getPlacedDate());
		orderHeader.setProductStoreId(entity.getProductStoreId());
		orderHeader.setSalesChannelEnumId(entity.getSalesChannelEnumId());
		orderHeader.setStatusId(entity.getStatusId());
		orderHeader.setSalesChannelEnumId(entity.getSalesChannelEnumId());
		return orderHeader;
	}

	public OrderHeader prepareResponse(OrderHeaderEntity entity, List<OrderItem> orderItems) {
		OrderHeader header = ordrHeaderEntityToOrderHeader(entity);
		header.setOrderItem(orderItems);
		return header;
	}

}
