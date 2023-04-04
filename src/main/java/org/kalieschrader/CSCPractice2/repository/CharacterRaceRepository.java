package org.kalieschrader.CSCPractice2.repository;
import java.util.List;
import java.util.Optional;

import org.kalieschrader.CSCPractice2.model.CharacterRace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface CharacterRaceRepository extends JpaRepository<CharacterRace, Long>{

	Optional<CharacterRace> findByRaceName(String raceName);

	void deleteByRaceName(String raceName);

}
