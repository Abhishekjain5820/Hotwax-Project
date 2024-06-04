package com.hotwax.order.services;

import java.util.List;

import com.hotwax.order.entities.PersonEntity;
import com.hotwax.order.exception.ServiceException;
import com.hotwax.order.model.Person;
import com.hotwax.order.model.ServiceResponse;

public interface PersonService {

	ServiceResponse<List<Person>> getAllPersons() throws ServiceException;

	ServiceResponse<Person> getPersonById(String id) throws ServiceException;

	ServiceResponse<Person> savePerson(Person person) throws ServiceException;

	ServiceResponse<Person> updatePersonById(String id, Person personDetails) throws ServiceException;

	ServiceResponse<Person> deletePerson(String id) throws ServiceException;

}
