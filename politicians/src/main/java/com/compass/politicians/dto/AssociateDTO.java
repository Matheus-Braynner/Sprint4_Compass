package com.compass.politicians.dto;

import java.util.Date;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.springframework.data.domain.Page;

import com.compass.politicians.entities.Associate;
import com.compass.politicians.enums.Gender;
import com.compass.politicians.enums.PoliticalOffice;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AssociateDTO {

	private Long id;
	private String name;
	@Enumerated(EnumType.STRING)
	private PoliticalOffice politicalOffice;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date birthDate;
	@Enumerated(EnumType.STRING)
    private Gender gender;
	private Long idPoliticalParty;
	
    public AssociateDTO(Associate associate) {
    	this.id = associate.getId();
    	this.name = associate.getName();
    	this.politicalOffice = associate.getPoliticalOffice();
    	this.birthDate = associate.getBirthDate();
    	this.gender = associate.getGender();
    	this.idPoliticalParty = associate.getPoliticalParty().getId();
    }
    
    public static Page<AssociateDTO> convert(Page<Associate> states) {
		return states.map(AssociateDTO::new);
	}
    
    
}
