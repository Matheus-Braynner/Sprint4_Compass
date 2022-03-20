package com.compass.politicians.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.compass.politicians.entities.PoliticalParty;
import com.compass.politicians.enums.Ideology;

public interface PoliticalPartyRepository extends JpaRepository<PoliticalParty, Long> {

	List<PoliticalParty> findByIdeology(Ideology ideologyEnum);


}
