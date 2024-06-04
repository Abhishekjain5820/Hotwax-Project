package com.hotwax.order.entities;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "person")
public class PersonEntity {

	@Id
	@Column(name = "party_id")
	private String partyId;

	@Column(name = "first_name", length = 255)
	private String firstName;

	@Column(name = "middle_name", length = 255)
	private String middleName;

	@Column(name = "last_name", length = 255)
	private String lastName;

	@Column(name = "gender", length = 1)
	private String gender;

	@Column(name = "birth_date")
	private Date birthDate;

	@Column(name = "marital_status_enum_id", length = 20)
	private String maritalStatusEnumId;

	@Column(name = "employment_status_enum_id", length = 20)
	private String employmentStatusEnumId;

	@Column(name = "occupation", length = 255)
	private String occupation;

}
