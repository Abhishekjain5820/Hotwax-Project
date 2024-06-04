package com.hotwax.order.services;

import java.util.List;

import com.hotwax.order.exception.ServiceException;
import com.hotwax.order.model.Party;
import com.hotwax.order.model.ServiceResponse;

public interface PartyService {

	ServiceResponse<List<Party>> getAllParties() throws ServiceException;

	ServiceResponse<Party> getPartyById(String id) throws ServiceException;

	ServiceResponse<Party> saveParty(Party party) throws ServiceException;

	ServiceResponse<Party> deleteParty(String id) throws ServiceException;

	ServiceResponse<Party> updatePartyById(String id, Party party) throws ServiceException;

}
