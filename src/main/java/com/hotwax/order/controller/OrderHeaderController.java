package com.hotwax.order.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotwax.order.exception.ServiceException;
import com.hotwax.order.model.ApiResponse;
import com.hotwax.order.model.OrderHeader;
import com.hotwax.order.model.ServiceResponse;
import com.hotwax.order.services.OrderHeaderService;

@RestController
@RequestMapping("/api/order-header")
public class OrderHeaderController {
	@Autowired
	private OrderHeaderService orderHeaderService;

	@GetMapping
	public ResponseEntity<ApiResponse> getAllOrderHeaders() throws ServiceException {
		LocalDateTime startApiDateTime = LocalDateTime.now();
		ServiceResponse<List<OrderHeader>> serviceResponse = orderHeaderService.getAllOrdersHeaders();
		return prepareResponse(serviceResponse, startApiDateTime);
	}

	@GetMapping("/{orderId}")
	public ResponseEntity<ApiResponse> getOrderHeaderById(@PathVariable String orderId) throws ServiceException {
		LocalDateTime startApiDateTime = LocalDateTime.now();
		ServiceResponse<OrderHeader> serviceResponse = orderHeaderService.getOrdersHeadersById(orderId);
		return prepareResponse(serviceResponse, startApiDateTime);
	}

	@PostMapping
	public ResponseEntity<ApiResponse> createOrderHeader(@RequestBody OrderHeader orderHeader)
			throws ServiceException {
		LocalDateTime startApiDateTime = LocalDateTime.now();
		ServiceResponse<OrderHeader> serviceResponse = orderHeaderService.saveOrdersHeaders(orderHeader);
		return prepareResponse(serviceResponse, startApiDateTime);
	}

	@PutMapping("/{orderId}")
	public ResponseEntity<ApiResponse> updateOrderHeader(@PathVariable String orderId,
			@RequestBody OrderHeader updatedOrderHeader) throws ServiceException {
		LocalDateTime startApiDateTime = LocalDateTime.now();
		ServiceResponse<OrderHeader> serviceResponse = orderHeaderService.updateOrdersHeadersById(orderId,
				updatedOrderHeader);
		return prepareResponse(serviceResponse, startApiDateTime);
	}

	@DeleteMapping("/{orderId}")
	public ResponseEntity<ApiResponse> deleteOrderHeader(@PathVariable String orderId) throws ServiceException {
		LocalDateTime startApiDateTime = LocalDateTime.now();
		ServiceResponse<OrderHeader> serviceResponse = orderHeaderService.deleteOrdersHeaders(orderId);
		return prepareResponse(serviceResponse, startApiDateTime);
	}

	private ResponseEntity<ApiResponse> prepareResponse(ServiceResponse<?> serviceResponse,
			LocalDateTime startApiDateTime) {
		ApiResponse apiResponse = new ApiResponse();
		apiResponse.setStartDateTime(startApiDateTime);
		apiResponse.setBody(serviceResponse.getBody());
		apiResponse.setMessage(serviceResponse.getMessage());
		apiResponse.setEndDateTime(LocalDateTime.now());
		return ResponseEntity.status(HttpStatusCode.valueOf(serviceResponse.getCode())).body(apiResponse);
	}
}
