package com.hotwax.order.dao;

import java.util.List;

import com.hotwax.order.model.Person;

public interface PersonDao {

	List<Person> getAllPersons();

	Person getPersonById(String id);

	Person saveAndUpdatePerson(Person person);

	void deletePerson(Person result);

	List<Person> getAllPersonsById(String partyId);

	

}
