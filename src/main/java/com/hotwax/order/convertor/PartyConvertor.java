package com.hotwax.order.convertor;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hotwax.order.entities.PartyEntity;
import com.hotwax.order.model.Party;
import com.hotwax.order.model.Person;

@Service
public class PartyConvertor {

	public Party partyEntityToParty(PartyEntity entity) {
		Party party = new Party();
		party.setPartyEnumTypeId(entity.getPartyEnumTypeId());
		party.setPartyId(entity.getPartyId());
		return party;
	}
	
	public PartyEntity partyToPartyEntity(Party party) {
		PartyEntity partyEntity = new PartyEntity();
		partyEntity.setPartyEnumTypeId(party.getPartyEnumTypeId());
		partyEntity.setPartyId(party.getPartyId());
		return partyEntity;
	}
	
	public Party prepareResponse(PartyEntity entity, List<Person> person) {
		Party party = partyEntityToParty(entity);
		party.setPerson(person);
		return party;
	}
}
