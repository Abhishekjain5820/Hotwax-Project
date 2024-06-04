package com.hotwax.order.model;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItem {
	private String orderItemSeqId;
	private String orderId;
	private String productId;
	private String itemDescription;
	private BigDecimal quantity;
	private BigDecimal unitAmount;
	private String itemTypeEnumId;
}
