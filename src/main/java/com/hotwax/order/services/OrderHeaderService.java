package com.hotwax.order.services;

import java.util.List;

import com.hotwax.order.exception.ServiceException;
import com.hotwax.order.model.OrderHeader;
import com.hotwax.order.model.ServiceResponse;

public interface OrderHeaderService {

	ServiceResponse<List<OrderHeader>> getAllOrdersHeaders() throws ServiceException;

	ServiceResponse<OrderHeader> getOrdersHeadersById(String orderId) throws ServiceException;

	ServiceResponse<OrderHeader> saveOrdersHeaders(OrderHeader orderHeader) throws ServiceException;

	ServiceResponse<OrderHeader> updateOrdersHeadersById(String orderId,
			OrderHeader updatedOrderHeader) throws ServiceException;

	ServiceResponse<OrderHeader> deleteOrdersHeaders(String orderId) throws ServiceException;

}
