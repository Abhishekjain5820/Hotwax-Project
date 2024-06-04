package com.hotwax.order.model;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person {

	private String partyId;
	private String firstName;
	private String middleName;
	private String lastName;
	private String gender;
	private Date birthDate;
	private String maritalStatusEnumId;
	private String employmentStatusEnumId;
	private String occupation;

}
