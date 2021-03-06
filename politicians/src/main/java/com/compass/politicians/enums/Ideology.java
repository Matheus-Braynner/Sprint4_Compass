package com.compass.politicians.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Ideology {
	
	LEFTIST("LEFTIST"),
	CENTRIST("CENTRIST"),
	RIGHTIST("RIGHTIST");
	
	private String political;

	
	public static Ideology toEnum(String cod) {
        if (cod == null) {
            return null;
        }

        for (Ideology x : Ideology.values()) {
            if (cod.equals(x.getPolitical())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Ideology invalid: " + cod + ".");
    }
}
