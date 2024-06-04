package com.hotwax.order.model;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ApiResponse {
	private Object body;
	private String message;
	private LocalDateTime startDateTime;
	private LocalDateTime endDateTime;
}
