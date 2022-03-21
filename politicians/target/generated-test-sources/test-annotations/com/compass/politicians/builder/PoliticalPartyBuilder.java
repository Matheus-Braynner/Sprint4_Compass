package com.compass.politicians.builder;

import java.util.Date;

import com.compass.politicians.entities.PoliticalParty;
import com.compass.politicians.enums.Ideology;

public class PoliticalPartyBuilder {

	private void newPoliticalParty() {
		PoliticalParty newPoliticalParty = new PoliticalParty();
		newPoliticalParty.setId(1L);
		newPoliticalParty.setName("Partido Trabalhista");
		newPoliticalParty.setAbbreviation("PT");
		newPoliticalParty.setFoundationDate(new Date());
		newPoliticalParty.setIdeology(Ideology.LEFTIST);
	}
}
