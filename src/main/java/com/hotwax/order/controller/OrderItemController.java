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
import com.hotwax.order.model.OrderItem;
import com.hotwax.order.model.ServiceResponse;
import com.hotwax.order.services.OrderItemService;

@RestController
@RequestMapping("/api/order-items")
public class OrderItemController {

	@Autowired
	private OrderItemService orderItemService;

	@GetMapping
	public ResponseEntity<ApiResponse> getAllOrderItems() throws ServiceException {
		LocalDateTime startApiDateTime = LocalDateTime.now();
		ServiceResponse<List<OrderItem>> serviceResponse = orderItemService.getAllOrderItems();
		return prepareResponse(serviceResponse, startApiDateTime);
	}

	@GetMapping("/{orderId}/{orderItemSeqId}")
	public ResponseEntity<ApiResponse> getOrderItemById(@PathVariable String orderId,
			@PathVariable String orderItemSeqId) throws ServiceException {
		LocalDateTime startApiDateTime = LocalDateTime.now();
		ServiceResponse<OrderItem> serviceResponse = orderItemService.getOrderItemById(orderId);
		return prepareResponse(serviceResponse, startApiDateTime);
	}

	@PostMapping
	public ResponseEntity<ApiResponse> createOrderItem(@RequestBody OrderItem orderItem) throws ServiceException {
		LocalDateTime startApiDateTime = LocalDateTime.now();
		ServiceResponse<OrderItem> serviceResponse = orderItemService.saveOrderItem(orderItem);
		return prepareResponse(serviceResponse, startApiDateTime);
	}

	@PutMapping("/{orderId}/{orderItemSeqId}")
	public ResponseEntity<ApiResponse> updateOrderItem(@PathVariable String orderId,
			@PathVariable String orderItemSeqId, @RequestBody OrderItem updatedOrderItem) throws ServiceException {
		LocalDateTime startApiDateTime = LocalDateTime.now();
		ServiceResponse<OrderItem> serviceResponse = orderItemService.updateOrderItemById(orderId, updatedOrderItem);
		return prepareResponse(serviceResponse, startApiDateTime);
	}

	@DeleteMapping("/{orderId}/{orderItemSeqId}")
	public ResponseEntity<ApiResponse> deleteOrderItem(@PathVariable String orderId,
			@PathVariable String orderItemSeqId) throws ServiceException {
		LocalDateTime startApiDateTime = LocalDateTime.now();
		ServiceResponse<OrderItem> serviceResponse = orderItemService.deleteOrderItem(orderId, orderItemSeqId);
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
