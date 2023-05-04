package org.kalieschrader.CSCPractice2.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.kalieschrader.CSC.model.CharacterClass;
import org.kalieschrader.CSC.model.CharacterRace;
import org.kalieschrader.CSC.model.CharacterSheet;
import org.kalieschrader.CSC.model.Item;
import org.kalieschrader.CSC.model.Spells;
import org.kalieschrader.CSC.model.Weapon;
import org.kalieschrader.CSC.repository.CharacterClassRepository;
import org.kalieschrader.CSC.repository.CharacterRaceRepository;
import org.springframework.beans.factory.annotation.Autowired;

class FormattingServiceTests {
	

//	@ParameterizedTest
//	@CsvSource(value = {"8:-1", "10:0", "15:2", "11:0", "12:1"}, delimiter = ':')
//	void setAbilityScores_expectedValues(int input, int expected) {
//		charSheet.setStrength(input);
//		FormattingService formatting = new FormattingService(charSheet);
//		int actualValue = formatting.getModStrength();
////		int actualValue=((input)-10)/2;
//	    assertEquals(expected, actualValue);
//	}
}
