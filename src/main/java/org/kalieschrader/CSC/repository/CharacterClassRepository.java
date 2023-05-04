package org.kalieschrader.CSC.repository;

import java.util.Optional;

import org.kalieschrader.CSC.model.CharacterClass;
import org.springframework.data.jpa.repository.JpaRepository;

//Interface for CharacterClass repo, extends JpaRepo to allow use of data manipulation methods 
public interface CharacterClassRepository extends JpaRepository<CharacterClass, String> {

	Optional<CharacterClass> findByName(String name);

	void deleteByName(String name);

}
