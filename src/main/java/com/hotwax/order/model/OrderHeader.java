package com.hotwax.order.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderHeader {

	private String orderId;
	private String orderName;
	private LocalDateTime orderDate;
	private LocalDateTime placedDate;
	private LocalDateTime approvedDate;
	private String statusId;
	private String partyId;
	private String currencyUomId;
	private String productStoreId;
	private String salesChannelEnumId;
	private BigDecimal grandTotal;
	private LocalDateTime completedDate;
	private List<OrderItem> orderItem;
}
