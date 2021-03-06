package com.compass.politicians.controllers;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.compass.politicians.dto.PoliticalPartyDTO;
import com.compass.politicians.entities.Associate;
import com.compass.politicians.entities.PoliticalParty;
import com.compass.politicians.repositories.PoliticalPartyRepository;
import com.compass.politicians.services.PoliticalPartyService;

@RestController
@RequestMapping(value = "/politicalparty")
public class PoliticalPartyController {

	@Autowired
	private PoliticalPartyRepository politicalPartyRepository;
	
	@Autowired
	private PoliticalPartyService politicalPartyService;
	
	
	@PostMapping
	@Transactional
	public ResponseEntity<PoliticalParty> insert(@RequestBody PoliticalParty obj) {
		obj = politicalPartyService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	
	}

	@GetMapping
	public Page<PoliticalPartyDTO> findAll(Pageable pagination) {
		Page<PoliticalParty> list = politicalPartyRepository.findAll(pagination);
		return PoliticalPartyDTO.convert(list);
	}
	
	@GetMapping(value = "/politicalparty/{ideology}")
	public ResponseEntity<List<PoliticalParty>> findByIdeology(@PathVariable String ideology) {
		return ResponseEntity.ok(politicalPartyService.findByIdeology(ideology));
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<PoliticalParty> findById(@PathVariable Long id) {
		PoliticalParty obj = politicalPartyService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PutMapping(value = "/{id}")
	@Transactional
	public ResponseEntity<PoliticalParty> update(@PathVariable Long id, @RequestBody PoliticalParty obj) {
		obj = politicalPartyService.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	@Transactional
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		politicalPartyService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping(value = "/{id}/associates")
	public ResponseEntity<List<Associate>> findAssociatesByPoliticalParty(@PathVariable Long id) {
		List<Associate> list = politicalPartyService.findAssociatesByPoliticalParty(id);
		return ResponseEntity.ok().body(list);
	}
	
}
