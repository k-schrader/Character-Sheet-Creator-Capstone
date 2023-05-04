package org.kalieschrader.CSC.repository;

import java.util.Optional;

import org.kalieschrader.CSC.model.CharacterRace;
import org.springframework.data.jpa.repository.JpaRepository;

//Interface for CharacterRace repo, extends JpaRepo to allow use of data manipulation methods 
public interface CharacterRaceRepository extends JpaRepository<CharacterRace, String> {

	Optional<CharacterRace> findByRaceName(String raceName);

	void deleteByRaceName(String raceName);

}
