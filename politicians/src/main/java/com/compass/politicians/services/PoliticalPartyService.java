package com.compass.politicians.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.compass.politicians.entities.Associate;
import com.compass.politicians.entities.PoliticalParty;
import com.compass.politicians.enums.Ideology;
import com.compass.politicians.repositories.AssociateRepository;
import com.compass.politicians.repositories.PoliticalPartyRepository;
import com.compass.politicians.services.exceptions.DatabaseException;
import com.compass.politicians.services.exceptions.ResourceNotFoundException;

@Service
public class PoliticalPartyService {

	@Autowired
	private PoliticalPartyRepository politicalPartyRepository;
	
	@Autowired
	private AssociateRepository associateRepository;
	
	public PoliticalParty insert(PoliticalParty obj) {
		return politicalPartyRepository.save(obj);
	}
	
	public List<PoliticalParty> findAll(Pageable pageable) {
		return politicalPartyRepository.findAll();
	}
	
	public List<PoliticalParty> findByIdeology(String ideology) {
		Ideology ideologyEnum = Ideology.toEnum(ideology.toUpperCase());
		return politicalPartyRepository.findByIdeology(ideologyEnum);
	}
	
	public PoliticalParty findById(Long id) {
		Optional<PoliticalParty> obj = politicalPartyRepository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public PoliticalParty update(Long id, PoliticalParty obj) {
		try {
			PoliticalParty entity = politicalPartyRepository.getById(id);
			updateData(entity, obj);
			return politicalPartyRepository.save(entity);
		} catch (EntityNotFoundException e) {	
			throw new ResourceNotFoundException(id);
		}
		
	}
	
	public void delete (Long id) {
		try {
			politicalPartyRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}

	public List<Associate> findAssociatesByPoliticalParty(Long id) {
		PoliticalParty politicalParty = this.findById(id);
		List<Associate> list = associateRepository.findAllByPoliticalParty(politicalParty);
		return list;
	}
	
	private void updateData(PoliticalParty entity, PoliticalParty obj) {
		entity.setName(obj.getName());
		entity.setAbbreviation(obj.getAbbreviation());
		entity.setIdeology(obj.getIdeology());
		entity.setFoundationDate(obj.getFoundationDate());
		entity.setAssociates(obj.getAssociates());
	}
	
}