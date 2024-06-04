package com.hotwax.order.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotwax.order.dao.PartyDao;
import com.hotwax.order.dao.PersonDao;
import com.hotwax.order.entities.PersonEntity;
import com.hotwax.order.exception.ServiceException;
import com.hotwax.order.model.Party;
import com.hotwax.order.model.Person;
import com.hotwax.order.model.ServiceResponse;
import com.hotwax.order.services.PersonService;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonDao personDao;
	@Override
	public ServiceResponse<List<Person>> getAllPersons() throws ServiceException {
		String message = "Success";
		List<Person> result = new ArrayList<Person>(); 
		try {
			result = personDao.getAllPersons();
			if(result.isEmpty()) {
				message = "No Result";
			}
		} catch (Exception ex) {
			throw new ServiceException("");
		}
		return new ServiceResponse<List<Person>>(200, message, result);
	}

	@Override
	public ServiceResponse<Person> getPersonById(String id) throws ServiceException {
		String message = "Success";
		Person result = null; 
		try {
			result = personDao.getPersonById(id);
			if(result == null) {
				message = "No Result";
			}
		} catch (Exception ex) {
			throw new ServiceException("");
		}
		return new ServiceResponse<Person>(200, message, result);
	}

	@Override
	public ServiceResponse<Person> savePerson(Person person) throws ServiceException {
		String message = "Success";
		Person result = null; 
		try {
			result = personDao.saveAndUpdatePerson(person);
			if(result.getPartyId() == null) {
				message = "No Result";
			}
		} catch (Exception ex) {
			throw new ServiceException("");
		}
		return new ServiceResponse<Person>(200, message, result);
	}

	@Override
	public ServiceResponse<Person> updatePersonById(String id, Person personDetails) throws ServiceException {
		String message = "Success";
		Person result = null; 
		try {
			personDetails.setPartyId(id);
			result = personDao.saveAndUpdatePerson(personDetails);
		} catch (Exception ex) {
			throw new ServiceException("");
		}
		return new ServiceResponse<Person>(200, message, result);
	}

	@Override
	public ServiceResponse<Person> deletePerson(String id) throws ServiceException {
		String message = "Success";
		Person result = null; 
		try {
			result = personDao.getPersonById(id);
			if(result == null) {
				message = "No Result";
			}
			personDao.deletePerson(result);
		} catch (Exception ex) {
			throw new ServiceException("");
		}
		return new ServiceResponse<Person>(200, message, result);
	}

}
