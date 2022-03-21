package com.compass.politicians.services;

import java.util.List;


import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.compass.politicians.dto.AssociateDTO;
import com.compass.politicians.entities.Associate;
import com.compass.politicians.entities.PoliticalParty;
import com.compass.politicians.enums.PoliticalOffice;
import com.compass.politicians.repositories.AssociateRepository;
import com.compass.politicians.repositories.PoliticalPartyRepository;
import com.compass.politicians.services.exceptions.DatabaseException;
import com.compass.politicians.services.exceptions.ResourceNotFoundException;

@Service
public class AssociateService {

	@Autowired
	private AssociateRepository repository;
	
	@Autowired
	private PoliticalPartyRepository politicalRepository;
	
	public Associate insert(AssociateDTO obj) {
		Optional<PoliticalParty> politicalParty = politicalRepository.findById(obj.getIdPoliticalParty());
		politicalParty.orElseThrow(() -> new ResourceNotFoundException(obj.getIdPoliticalParty()));	
		Associate associate = new Associate(obj);
		PoliticalParty politicalPartyGet = politicalParty.get();
		associate.setPoliticalParty(politicalPartyGet);
		Associate associateSaved = repository.save(associate);
		politicalPartyGet.addAssociate(associateSaved);
		politicalPartyGet = politicalRepository.save(politicalPartyGet);
		return associateSaved;
	}
	
	public List<Associate> findAll(Pageable pageable) {
		return repository.findAll();
	}
	
	public List<Associate> findByPoliticalOffice(String politicalOffice) {
		PoliticalOffice politicalOfficeEnum = PoliticalOffice.toEnum(politicalOffice.toUpperCase());
		return repository.findByPoliticalOffice(politicalOfficeEnum);
	}
	
	public Associate findById(Long id) {
		Optional<Associate> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	
	public Associate update(Long id, Associate obj) {
		try {
			Associate entity = repository.getById(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {	
			throw new ResourceNotFoundException(id);
		}
		
	}
	
	public void delete (Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}

	public void removeFromPoliticalParty(Long idAssociate, Long idPoliticalParty) {
		Optional<Associate> associate = repository.findById(idAssociate);
		associate.orElseThrow(() -> new ResourceNotFoundException("Id Associate not found: " + idAssociate));
		
		Optional<PoliticalParty> politicalParty = politicalRepository.findById(idPoliticalParty);
		politicalParty.orElseThrow(() -> new ResourceNotFoundException("Id Political Party not found: " + idPoliticalParty));	
		
		Associate associateGet = associate.get();
		associateGet.setPoliticalParty(null);
		repository.save(associateGet);
	}
	
	private void updateData(Associate entity, Associate obj) {
		entity.setName(obj.getName());
		entity.setPoliticalOffice(obj.getPoliticalOffice());
		entity.setBirthDate(obj.getBirthDate());
		entity.setGender(obj.getGender());
	}
	
}
