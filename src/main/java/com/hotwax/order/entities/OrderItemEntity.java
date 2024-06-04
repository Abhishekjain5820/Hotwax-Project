package com.hotwax.order.entities;

import java.math.BigDecimal;

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
@Table(name = "order_item")
public class OrderItemEntity {

	@Id
	@Column(name = "order_item_seq_id", length = 20)
	private String orderItemSeqId;

	@Column(name = "order_id", length = 20)
	private String orderId;

	@Column(name = "product_id", nullable = false)
	private String productId;

	@Column(name = "item_description", length = 255)
	private String itemDescription;

	@Column(name = "quantity", precision = 24, scale = 4)
	private BigDecimal quantity;

	@Column(name = "unit_amount", precision = 24, scale = 4)
	private BigDecimal unitAmount;

	@Column(name = "item_type_enum_id", length = 20)
	private String itemTypeEnumId;
}
