package com.compass.politicians.dto;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;

import com.compass.politicians.entities.Associate;
import com.compass.politicians.entities.PoliticalParty;
import com.compass.politicians.enums.Ideology;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PoliticalPartyDTO {

	private Long id;
	private String name;
	private String abbreviation;
	private Ideology ideology;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date foundationDate;
	private List<Associate> listAssociate;
	
	
	public PoliticalPartyDTO(PoliticalParty politicalParty) {
		this.id = politicalParty.getId();
		this.name = politicalParty.getName();
		this.abbreviation = politicalParty.getAbbreviation();
		this.ideology = politicalParty.getIdeology();
		this.foundationDate = politicalParty.getFoundationDate();
		this.listAssociate = politicalParty.getListAssociate();
    }
    
    public static Page<PoliticalPartyDTO> convert(Page<PoliticalParty> politicalParty) {
		return politicalParty.map(PoliticalPartyDTO::new);
	}
}
