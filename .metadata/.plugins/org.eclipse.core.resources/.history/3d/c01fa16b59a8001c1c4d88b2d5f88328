package com.compass.politicians.dto;

import java.util.Date;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.springframework.data.domain.Page;

import com.compass.politicians.entities.Associate;
import com.compass.politicians.enums.Gender;
import com.compass.politicians.enums.PoliticalOffice;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AssociateDTO {

	private Long id;
	private String name;
	@Enumerated(EnumType.STRING)
	private PoliticalOffice politicalOffice;
	private Date birthDate;
	@Enumerated(EnumType.STRING)
    private Gender gender;
	
    public AssociateDTO(Associate associate) {
    	this.id = associate.getId();
    	this.name = associate.getName();
    	this.politicalOffice = associate.getPoliticalOffice();
    	this.birthDate = associate.getBirthDate();
    	this.gender = associate.getGender();
    }
    
    public static Page<AssociateDTO> convert(Page<Associate> states) {
		return states.map(AssociateDTO::new);
	}
}
