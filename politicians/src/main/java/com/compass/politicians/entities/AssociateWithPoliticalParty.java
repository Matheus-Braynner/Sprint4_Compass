package com.compass.politicians.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.compass.politicians.enums.PoliticalOffice;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@Entity
public class AssociateWithPoliticalParty {

	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	@Enumerated(EnumType.STRING)
	private PoliticalOffice politicalOffice;
	private String politicalParty;
	
	public AssociateWithPoliticalParty(PoliticalParty politicalParty, Associate associate) {
		this.setId(associate.getId());  
		this.setName(associate.getName());
		this.setPoliticalOffice(associate.getPoliticalOffice()); 
		this.setPoliticalParty(politicalParty.getName()); 
	}
}
