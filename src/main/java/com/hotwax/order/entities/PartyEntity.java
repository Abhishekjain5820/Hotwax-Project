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
@Table(name = "party")
public class PartyEntity {
	@Id
	@Column(name = "party_id", length = 20)
	private String partyId;

	@Column(name = "party_enum_type_id", length = 20)
	private String partyEnumTypeId;

}
