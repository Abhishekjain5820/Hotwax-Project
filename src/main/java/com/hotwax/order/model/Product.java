package com.hotwax.order.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {

	private String productId;
	private String partyId;
	private String productName;
	private String description;
	private String chargeShipping;
	private String returnable;

}
