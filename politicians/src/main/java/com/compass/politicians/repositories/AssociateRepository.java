package com.compass.politicians.repositories;

import java.util.List;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.compass.politicians.entities.Associate;
import com.compass.politicians.entities.PoliticalParty;
import com.compass.politicians.enums.PoliticalOffice;

@Transactional
@Repository
public interface AssociateRepository extends JpaRepository<Associate, Long>{

	Page<Associate> findAll(Pageable pageable);

	List<Associate> findByPoliticalOffice(PoliticalOffice politicalOffice);

	List<Associate> findAllByPoliticalParty(PoliticalParty politicalParty);

}
