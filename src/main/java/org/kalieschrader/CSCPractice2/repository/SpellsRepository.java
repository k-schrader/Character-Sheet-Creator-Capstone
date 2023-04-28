package org.kalieschrader.CSCPractice2.repository;

import org.kalieschrader.CSCPractice2.model.Spells;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpellsRepository extends JpaRepository<Spells, String>{

	Spells findByName(String name);

	void deleteByName(String name);
	
}
