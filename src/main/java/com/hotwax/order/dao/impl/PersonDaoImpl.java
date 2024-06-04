package com.hotwax.order.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotwax.order.convertor.PersonConvertor;
import com.hotwax.order.dao.PersonDao;
import com.hotwax.order.entities.PersonEntity;
import com.hotwax.order.model.Person;
import com.hotwax.order.repository.PersonRepository;

@Service
public class PersonDaoImpl implements PersonDao {
	@Autowired
	PersonRepository personRepository;

	@Autowired
	PersonConvertor personConvertor;

	@Override
	public List<Person> getAllPersons() {
		List<Person> result = new ArrayList<>();
		List<PersonEntity> entities = personRepository.findAll();
		for (PersonEntity entity : entities)
			result.add(this.personConvertor.personEntityToPerson(entity));
		return result;
	}

	@Override
	public Person getPersonById(String id) {
		Optional<PersonEntity> entities = personRepository.findById(id);
		if (entities.isPresent())
			return this.personConvertor.personEntityToPerson(entities.get());
		return null;
	}

	@Override
	public Person saveAndUpdatePerson(Person person) {
		PersonEntity entity = this.personConvertor.personToPersonEntity(person);
		entity = this.personRepository.save(entity);
		return this.personConvertor.personEntityToPerson(entity);
	}

	@Override
	public void deletePerson(Person result) {
		PersonEntity entity = this.personConvertor.personToPersonEntity(result);
		this.personRepository.delete(entity);

	}

	@Override
	public List<Person> getAllPersonsById(String partyId) {
		List<Person> result = new ArrayList<>();
		List<PersonEntity> entities = personRepository.findAll();
		for (PersonEntity entity : entities) {
			if (entity.getPartyId().equals(partyId))
				result.add(this.personConvertor.personEntityToPerson(entity));
		}
		return result;
	}

}
