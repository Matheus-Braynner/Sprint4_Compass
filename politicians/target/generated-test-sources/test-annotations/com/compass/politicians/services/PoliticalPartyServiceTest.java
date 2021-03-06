package com.compass.politicians.services;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.compass.politicians.dto.AssociateDTO;
import com.compass.politicians.dto.PoliticalPartyDTO;
import com.compass.politicians.entities.Associate;
import com.compass.politicians.entities.PoliticalParty;
import com.compass.politicians.enums.Ideology;
import com.compass.politicians.repositories.AssociateRepository;
import com.compass.politicians.repositories.PoliticalPartyRepository;

class PoliticalPartyServiceTest {

	@InjectMocks
	private AssociateService associateService;
	@Mock
	private AssociateRepository associateRepository;
	@Mock
	private PoliticalPartyRepository politicalRepository;
	@Mock
	private Associate associate;
	@Mock
	private AssociateDTO associateDTO;
	@Mock
	private PoliticalParty politicalParty;
	@Mock
	private PoliticalPartyDTO politicalPartyDTO;
	
	@Test
	void test() {
		
	}
	

}
