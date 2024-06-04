package com.hotwax.order.dao;

import java.util.List;

import com.hotwax.order.model.Party;

public interface PartyDao {

	List<Party> getAllParties();

	Party getPartyById(String id);

	Party saveAndUpdateParty(Party party);

	void delete(Party result);

}
