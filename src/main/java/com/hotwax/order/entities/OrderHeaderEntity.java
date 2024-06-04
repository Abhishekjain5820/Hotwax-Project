package com.hotwax.order.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "order_header")
public class OrderHeaderEntity {
	@Id
	@Column(name = "order_id", length = 20)
	private String orderId;

	@Column(name = "order_name", length = 255)
	private String orderName;

	@Column(name = "order_date")
	private LocalDateTime orderDate;

	@Column(name = "placed_date")
	private LocalDateTime placedDate;

	@Column(name = "approved_date")
	private LocalDateTime approvedDate;

	@Column(name = "status_id", length = 20)
	private String statusId;

	@Column(name = "party_id", nullable = false)
	private String partyId;

	@Column(name = "currency_uom_id", length = 20)
	private String currencyUomId;

	@Column(name = "product_store_id", length = 20)
	private String productStoreId;

	@Column(name = "sales_channel_enum_id", length = 20)
	private String salesChannelEnumId;

	@Column(name = "grand_total", precision = 24, scale = 4)
	private BigDecimal grandTotal;

	@Column(name = "completed_date")
	private LocalDateTime completedDate;

}
