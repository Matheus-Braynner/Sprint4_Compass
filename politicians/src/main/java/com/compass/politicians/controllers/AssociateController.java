package com.compass.politicians.controllers;

import java.net.URI;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.compass.politicians.dto.AssociateDTO;
import com.compass.politicians.entities.Associate;
import com.compass.politicians.repositories.AssociateRepository;
import com.compass.politicians.services.AssociateService;

@RestController
@RequestMapping(value = "/associates")
public class AssociateController {

	@Autowired
	private AssociateRepository repository;

	@Autowired
	private AssociateService service;

	@PostMapping
	@Transactional
	public ResponseEntity<Associate> insert(@RequestBody Associate obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@GetMapping
	public Page<AssociateDTO> findAll(Pageable pagination) {
		
		Page<Associate> list = repository.findAll(pagination);
		return AssociateDTO.convert(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Associate> findById(@PathVariable Long id) {
		Associate obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}