package com.hotwax.order.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotwax.order.dao.OrderHeadersDao;
import com.hotwax.order.exception.ServiceException;
import com.hotwax.order.model.OrderHeader;
import com.hotwax.order.model.ServiceResponse;
import com.hotwax.order.services.OrderHeaderService;

@Service
public class OrderHeadersServiceImpl implements OrderHeaderService {

	@Autowired
	private OrderHeadersDao orderHeaderDao;

	@Override
	public ServiceResponse<List<OrderHeader>> getAllOrdersHeaders() throws ServiceException {
		String message = "Success";
		List<OrderHeader> result = new ArrayList<OrderHeader>();
		try {
			result = orderHeaderDao.getAllOrdersHeaders();
			if (result.isEmpty()) {
				message = "No Result";
			}
		} catch (Exception ex) {
			throw new ServiceException("");
		}
		return new ServiceResponse<List<OrderHeader>>(200, message, result);
	}

	@Override
	public ServiceResponse<OrderHeader> getOrdersHeadersById(String orderId) throws ServiceException {
		String message = "Success";
		OrderHeader result = null;
		try {
			result = orderHeaderDao.getOrdersHeaderById(orderId);
			if (result == null) {
				message = "No Result";
			}
		} catch (Exception ex) {
			throw new ServiceException("");
		}
		return new ServiceResponse<OrderHeader>(200, message, result);
	}

	@Override
	public ServiceResponse<OrderHeader> saveOrdersHeaders(OrderHeader orderHeader) throws ServiceException {
		String message = "Success";
		OrderHeader result = null;
		try {
			result = orderHeaderDao.saveAndUpdateOrdersHeader(orderHeader);
			if (result.getPartyId() == null) {
				message = "No Result";
			}
		} catch (Exception ex) {
			throw new ServiceException(ex.getMessage());
		}
		return new ServiceResponse<OrderHeader>(200, message, result);
	}

	@Override
	public ServiceResponse<OrderHeader> updateOrdersHeadersById(String orderId, OrderHeader updatedOrderHeader)
			throws ServiceException {
		String message = "Success";
		OrderHeader result = null;
		try {
			updatedOrderHeader.setPartyId(orderId);
			result = orderHeaderDao.saveAndUpdateOrdersHeader(updatedOrderHeader);
		} catch (Exception ex) {
			throw new ServiceException("");
		}
		return new ServiceResponse<OrderHeader>(200, message, result);
	}

	@Override
	public ServiceResponse<OrderHeader> deleteOrdersHeaders(String orderId) throws ServiceException {
		String message = "Success";
		OrderHeader result = null;
		try {
			result = orderHeaderDao.getOrdersHeaderById(orderId);
			if (result == null) {
				message = "No Result";
			}
			orderHeaderDao.deleteOrdersHeaders(result);
		} catch (Exception ex) {
			throw new ServiceException("");
		}
		return new ServiceResponse<OrderHeader>(200, message, result);
	}

}
