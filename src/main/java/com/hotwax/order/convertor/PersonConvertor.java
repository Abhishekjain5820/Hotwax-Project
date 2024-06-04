package com.hotwax.order.convertor;

import org.springframework.stereotype.Service;

import com.hotwax.order.entities.PersonEntity;
import com.hotwax.order.model.Person;

@Service
public class PersonConvertor {

	public Person personEntityToPerson(PersonEntity entity) {
		Person person = new Person();
		person.setBirthDate(entity.getBirthDate());
		person.setEmploymentStatusEnumId(entity.getEmploymentStatusEnumId());
		person.setFirstName(entity.getFirstName());
		person.setGender(entity.getGender());
		person.setLastName(entity.getLastName());
		person.setMaritalStatusEnumId(entity.getMaritalStatusEnumId());
		person.setMiddleName(entity.getMiddleName());
		person.setOccupation(entity.getOccupation());
		person.setPartyId(entity.getPartyId());
		return person;
	}

	public PersonEntity personToPersonEntity(Person person) {
		PersonEntity entity = new PersonEntity();
		entity.setBirthDate(person.getBirthDate());
		entity.setEmploymentStatusEnumId(person.getEmploymentStatusEnumId());
		entity.setFirstName(person.getFirstName());
		entity.setGender(person.getGender());
		entity.setLastName(person.getLastName());
		entity.setMaritalStatusEnumId(person.getMaritalStatusEnumId());
		entity.setMiddleName(person.getMiddleName());
		entity.setOccupation(person.getOccupation());
		entity.setPartyId(person.getPartyId());
		return entity;
	}

}
