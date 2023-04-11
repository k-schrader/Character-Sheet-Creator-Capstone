package org.kalieschrader.CSCPractice2.repository;

import java.util.Optional;
import org.kalieschrader.CSCPractice2.model.Spells;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpellsRepository extends JpaRepository<Spells, String>{

	Optional<Spells> findByName(String name);

	void deleteByName(String name);
	
}
