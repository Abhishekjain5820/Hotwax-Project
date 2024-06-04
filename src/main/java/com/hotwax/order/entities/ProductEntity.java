package com.hotwax.order.entities;

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
@Table(name = "product")
public class ProductEntity {
	@Id
	@Column(name = "product_id", length = 20)
	private String productId;

	@Column(name = "party_id", length = 20)
	private String partyId;

	@Column(name = "product_name", length = 255)
	private String productName;

	@Column(name = "description", length = 1000)
	private String description;

	@Column(name = "charge_shipping", length = 1)
	private String chargeShipping;

	@Column(name = "returnable", length = 1)
	private String returnable;

}
