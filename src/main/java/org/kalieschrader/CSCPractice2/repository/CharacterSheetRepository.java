package org.kalieschrader.CSCPractice2.repository;

import java.util.List;
import java.util.Optional;

import org.kalieschrader.CSCPractice2.model.CharacterSheet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterSheetRepository extends JpaRepository<CharacterSheet, Integer>{
	CharacterSheet findByCharId(Integer charId);

	void deleteByCharId(Integer charId);
	 
	List<CharacterSheet> findAllByUsername(String username);

	
	
	

}