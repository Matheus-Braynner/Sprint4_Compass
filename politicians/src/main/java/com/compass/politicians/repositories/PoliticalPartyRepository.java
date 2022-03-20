package com.compass.politicians.repositories;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.compass.politicians.entities.PoliticalParty;
import com.compass.politicians.enums.Ideology;

@Transactional
@Repository
public interface PoliticalPartyRepository extends JpaRepository<PoliticalParty, Long> {

	List<PoliticalParty> findByIdeology(Ideology ideologyEnum);


}
