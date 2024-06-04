package com.hotwax.order.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotwax.order.convertor.PartyConvertor;
import com.hotwax.order.dao.PartyDao;
import com.hotwax.order.dao.PersonDao;
import com.hotwax.order.entities.PartyEntity;
import com.hotwax.order.model.Party;
import com.hotwax.order.model.Person;
import com.hotwax.order.repository.PartyRepository;

@Service
public class PartyDaoImpl implements PartyDao {

	@Autowired
	PartyRepository partyRepository;

	@Autowired
	PersonDao personDao;

	@Autowired
	PartyConvertor partyConvertor;

	@Override
	public List<Party> getAllParties() {
		List<Party> result = new ArrayList<>();
		List<PartyEntity> entities = partyRepository.findAll();
		
		for (PartyEntity entity : entities) {
			List<Person> persons = new ArrayList<Person>();
			persons = personDao.getAllPersonsById(entity.getPartyId());
				
					result.add(this.partyConvertor.prepareResponse(entity, persons));
		
		}
		return result;
	}

	@Override
	public Party getPartyById(String id) {
		Optional<PartyEntity> entities = partyRepository.findById(id);
		List<Person> person = new ArrayList<>();
		if (entities.isPresent()) {
			person = personDao.getAllPersonsById(entities.get().getPartyId());
			return this.partyConvertor.prepareResponse(entities.get(),person);
		}
		return null;
	}

	@Override
	public Party saveAndUpdateParty(Party party) {
		PartyEntity entity = this.partyConvertor.partyToPartyEntity(party);
		entity = this.partyRepository.save(entity);
		return this.partyConvertor.partyEntityToParty(entity);
	}

	@Override
	public void delete(Party result) {
		PartyEntity entity = this.partyConvertor.partyToPartyEntity(result);
		entity = this.partyRepository.save(entity);
	}

}
