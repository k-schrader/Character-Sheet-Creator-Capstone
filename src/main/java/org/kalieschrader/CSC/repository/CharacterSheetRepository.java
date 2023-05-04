package org.kalieschrader.CSC.repository;

import java.util.List;
import org.kalieschrader.CSC.model.CharacterSheet;
import org.springframework.data.jpa.repository.JpaRepository;

//Interface for CharacterSheet repo, extends JpaRepo to allow use of data manipulation methods 

public interface CharacterSheetRepository extends JpaRepository<CharacterSheet, Integer> {
	CharacterSheet findByCharId(Integer charId);

	void deleteByCharId(Integer charId);

	List<CharacterSheet> findAllByUsername(String username);

}