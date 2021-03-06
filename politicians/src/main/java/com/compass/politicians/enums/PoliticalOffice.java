package com.compass.politicians.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PoliticalOffice {
	COUNCILLOR("COUNCILLOR"),
	MAYOR("MAYOR"),
	STATE_REPRESENTATIVE("STATE_REPRESENTATIVE"),
	FEDERAL_REPRESENTATIVE("FEDERAL_REPRESENTATIVE"),
	SENATOR("SENATOR"),
	DISTRICT_GOVERNOR("DISTRICT_GOVERNOR"),
	PRESIDENT("PRESIDENT"),
	NONE("NONE");

	private String political;
	
	public static PoliticalOffice toEnum(String cod) {
        if (cod == null) {
            return null;
        }

        for (PoliticalOffice x : PoliticalOffice.values()) {
            if (cod.equals(x.getPolitical())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Political Office invalid: " + cod + ".");
    }
}	
