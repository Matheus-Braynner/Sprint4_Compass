package com.compass.politicians.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.compass.politicians.entities.Associate;
import com.compass.politicians.repositories.AssociateRepository;
import com.compass.politicians.services.exceptions.ResourceNotFoundException;

@Service
public class AssociateService {

	@Autowired
	private AssociateRepository repository;
	
	public Associate insert(Associate obj) {
		return repository.save(obj);
	}
	
	public List<Associate> findAll(Pageable pageable) {
		return repository.findAll();
	}
	
	public Associate findById(Long id) {
		Optional<Associate> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	
	
}