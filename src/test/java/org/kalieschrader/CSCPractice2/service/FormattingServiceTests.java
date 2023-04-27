package org.kalieschrader.CSCPractice2.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class FormattingServiceTests {

	@ParameterizedTest
	@CsvSource(value = {"8:-1", "10:0", "15:2", "11:0", "12:1"}, delimiter = ':')
	void setAbilityScores_expectedValues(int input, int expected) {
		int actualValue=((input)-10)/2;
	    assertEquals(expected, actualValue);
	}
}
