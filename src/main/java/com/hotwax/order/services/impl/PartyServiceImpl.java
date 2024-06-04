package com.hotwax.order.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotwax.order.dao.PartyDao;
import com.hotwax.order.dao.PersonDao;
import com.hotwax.order.exception.ServiceException;
import com.hotwax.order.model.Party;
import com.hotwax.order.model.ServiceResponse;
import com.hotwax.order.services.PartyService;

@Service
public class PartyServiceImpl implements PartyService {
	@Autowired
	private PartyDao partyDao;
	

	@Override
	public ServiceResponse<List<Party>> getAllParties() throws ServiceException {
		String message = "Success";
		List<Party> result = new ArrayList<Party>(); 
		try {
			result = partyDao.getAllParties();
			if(result.isEmpty()) {
				message = "No Result";
			}
		} catch (Exception ex) {
			throw new ServiceException("");
		}
		return new ServiceResponse<List<Party>>(200, message, result);
	}

	@Override
	public ServiceResponse<Party> getPartyById(String id) throws ServiceException {
		String message = "Success";
		Party result = null; 
		try {
			result = partyDao.getPartyById(id);
			if(result == null) {
				message = "No Result";
			}
		} catch (Exception ex) {
			throw new ServiceException("");
		}
		return new ServiceResponse<Party>(200, message, result);
	}

	@Override
	public ServiceResponse<Party> saveParty(Party party) throws ServiceException {
		String message = "Success";
		Party result = null; 
		try {
			result = partyDao.saveAndUpdateParty(party);
			if(result.getPartyId() == null) {
				message = "No Result";
			}
		} catch (Exception ex) {
			throw new ServiceException("");
		}
		return new ServiceResponse<Party>(200, message, result);
	}

	@Override
	public ServiceResponse<Party> updatePartyById(String id, Party party) throws ServiceException {
		String message = "Success";
		Party result = null; 
		try {
			party.setPartyId(id);
			result = partyDao.saveAndUpdateParty(party);
		} catch (Exception ex) {
			throw new ServiceException("");
		}
		return new ServiceResponse<Party>(200, message, result);
	}

	@Override
	public ServiceResponse<Party> deleteParty(String id) throws ServiceException {
		String message = "Success";
		Party result = null; 
		try {
			result = partyDao.getPartyById(id);
			if(result == null) {
				message = "No Result";
			}
			partyDao.delete(result);
		} catch (Exception ex) {
			throw new ServiceException("");
		}
		return new ServiceResponse<Party>(200, message, result);
	}
}
