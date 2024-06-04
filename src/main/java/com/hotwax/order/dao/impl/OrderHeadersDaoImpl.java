package com.hotwax.order.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotwax.order.convertor.OrderHeaderConvertor;
import com.hotwax.order.dao.OrderHeadersDao;
import com.hotwax.order.dao.OrderItemsDao;
import com.hotwax.order.entities.OrderHeaderEntity;
import com.hotwax.order.model.OrderHeader;
import com.hotwax.order.model.OrderItem;
import com.hotwax.order.repository.OrderHeaderRepository;

@Service
public class OrderHeadersDaoImpl implements OrderHeadersDao {

	@Autowired
	OrderHeaderRepository orderHeaderRepository;

	@Autowired
	OrderItemsDao orderItemsDao;

	@Autowired
	OrderHeaderConvertor orderHeaderConvertor;

	@Override
	public List<OrderHeader> getAllOrdersHeaders() {
		List<OrderHeader> result = new ArrayList<>();
		List<OrderHeaderEntity> entities = orderHeaderRepository.findAll();
		for (OrderHeaderEntity entity : entities) {
			List<OrderItem> orderItems = new ArrayList<OrderItem>();
			orderItems = orderItemsDao.getAllOrdersItemsById(entity.getOrderId());
			result.add(this.orderHeaderConvertor.prepareResponse(entity, orderItems));

		}
		return result;
	}

	@Override
	public OrderHeader getOrdersHeaderById(String orderId) {
		Optional<OrderHeaderEntity> entities = orderHeaderRepository.findById(orderId);
		List<OrderItem> orderItem = new ArrayList<>();
		if (entities.isPresent()) {
			return this.orderHeaderConvertor.prepareResponse(entities.get(), orderItem);
		}
		return null;

	}

	@Override
	public OrderHeader saveAndUpdateOrdersHeader(OrderHeader orderHeader) {
		OrderHeaderEntity entity = this.orderHeaderConvertor.orderHeaderToOrderHeaderEntity(orderHeader);
		entity = this.orderHeaderRepository.save(entity);
		return this.orderHeaderConvertor.ordrHeaderEntityToOrderHeader(entity);
	}

	@Override
	public void deleteOrdersHeaders(OrderHeader result) {
		OrderHeaderEntity entity = this.orderHeaderConvertor.orderHeaderToOrderHeaderEntity(result);
		entity = this.orderHeaderRepository.save(entity);

	}

}
