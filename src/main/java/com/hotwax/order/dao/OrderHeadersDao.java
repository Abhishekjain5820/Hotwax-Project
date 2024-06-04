package com.hotwax.order.dao;

import java.util.List;

import com.hotwax.order.model.OrderHeader;

public interface OrderHeadersDao {

	List<OrderHeader> getAllOrdersHeaders();

	OrderHeader getOrdersHeaderById(String orderId);

	OrderHeader saveAndUpdateOrdersHeader(OrderHeader orderHeader);

	void deleteOrdersHeaders(OrderHeader result);

}
