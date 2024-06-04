package com.hotwax.order.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ServiceResponse<T> {
	private Integer code;
	private String message;
	private T body;
}
