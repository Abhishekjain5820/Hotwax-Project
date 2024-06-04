package com.hotwax.order.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Party {

	private String partyId;
	private String partyEnumTypeId;
	private List<Person>  person;

}
