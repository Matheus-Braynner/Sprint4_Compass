package com.compass.politicians.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.compass.politicians.entities.Associate;
import com.compass.politicians.entities.PoliticalParty;
import com.compass.politicians.enums.PoliticalOffice;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AssociateWithPoliticalPartyDTO {

	private Long id;
	private String name;
	@Enumerated(EnumType.STRING)
	private PoliticalOffice politicalOffice;
	private String politicalParty;
	
	public AssociateWithPoliticalPartyDTO(PoliticalParty politicalParty, Associate associate) {
		this.setId(associate.getId());  
		this.setName(associate.getName());
		this.setPoliticalOffice(associate.getPoliticalOffice()); 
		this.setPoliticalParty(politicalParty.getName()); 
	}
	
}