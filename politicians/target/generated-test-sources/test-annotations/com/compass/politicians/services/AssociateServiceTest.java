package com.compass.politicians.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.compass.politicians.dto.AssociateDTO;
import com.compass.politicians.dto.PoliticalPartyDTO;
import com.compass.politicians.entities.Associate;
import com.compass.politicians.entities.PoliticalParty;
import com.compass.politicians.enums.Gender;
import com.compass.politicians.enums.Ideology;
import com.compass.politicians.enums.PoliticalOffice;
import com.compass.politicians.repositories.AssociateRepository;
import com.compass.politicians.repositories.PoliticalPartyRepository;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DisplayName("Tests for Associate Service")
class AssociateServiceTest {

	@InjectMocks
	private PoliticalPartyService politicalService;
	@Mock
	private PoliticalPartyRepository politicalRepository;
	@Mock
	private PoliticalParty politicalParty;
	@Mock
	private PoliticalPartyDTO politicalPartyDTO;
	
	@BeforeEach
	public void beforeEach() {
		MockitoAnnotations.openMocks(this);
	
	}
	
	@DisplayName("Save Associate")
	@Test
	void saveAssociate() {
		when(this.politicalService.insert(any(PoliticalParty.class))).thenReturn(politicalParty);		
		PoliticalParty aux = politicalRepository.save(politicalParty);
		
		assertNotNull(aux);
		assertEquals(PoliticalParty.class, aux.getClass());
		assertEquals(1L, aux.getId());
		assertEquals("Partido Trabalhista", aux.getName());
		assertEquals("PT", aux.getAbbreviation());
		assertEquals(new Date(), aux.getFoundationDate());
		assertEquals(Ideology.LEFTIST, aux.getIdeology());

	}


}
