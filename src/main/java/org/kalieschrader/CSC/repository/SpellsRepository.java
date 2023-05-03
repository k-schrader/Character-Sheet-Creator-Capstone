package org.kalieschrader.CSC.repository;

import org.kalieschrader.CSC.model.Spells;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpellsRepository extends JpaRepository<Spells, String>{

	Spells findByName(String name);

	void deleteByName(String name);
	
}
