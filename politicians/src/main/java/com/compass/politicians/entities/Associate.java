package com.compass.politicians.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.compass.politicians.enums.PoliticalOffice;
import com.compass.politicians.dto.AssociateDTO;
import com.compass.politicians.enums.Gender;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Associate implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	@Enumerated(EnumType.STRING)
	private PoliticalOffice politicalOffice;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date birthDate;
	@Enumerated(EnumType.STRING)
    private Gender gender;
	@ManyToOne
	private PoliticalParty politicalParty;
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Associate other = (Associate) obj;
		return Objects.equals(id, other.id);
	}
	
	public Associate(AssociateDTO obj) {
		this.setId(null);
		this.setName(obj.getName());
		this.setPoliticalOffice(obj.getPoliticalOffice());
		this.setBirthDate(obj.getBirthDate());
		this.setGender(obj.getGender());
	}
	
	

}
