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
	public ResponseEntity<Associate> insert(@RequestBody AssociateDTO obj) {
		Associate associate = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(associate);
	}

	@GetMapping
	public Page<AssociateDTO> findAll(Pageable pagination) {

		Page<Associate> list = repository.findAll(pagination);
		return AssociateDTO.convert(list);
	}

	@GetMapping(value = "/politicaloffice/{politicalOffice}")
	public ResponseEntity<List<Associate>> findByPoliticalOffice(@PathVariable String politicalOffice) {
		return ResponseEntity.ok(service.findByPoliticalOffice(politicalOffice));
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Associate> findById(@PathVariable Long id) {
		Associate obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@PutMapping(value = "/{id}")
	@Transactional
	public ResponseEntity<Associate> update(@PathVariable Long id, @RequestBody Associate obj) {
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}

	@DeleteMapping(value = "/{id}")
	@Transactional
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping(value = "{idAssociate}/politicalparty/{idPoliticalParty}")
	@Transactional
	public ResponseEntity<Void> removeFromPoliticalParty(@PathVariable Long idAssociate,
																									@PathVariable Long idPoliticalParty) {
		service.removeFromPoliticalParty(idAssociate, idPoliticalParty);
		return ResponseEntity.noContent().build();
	}
}
