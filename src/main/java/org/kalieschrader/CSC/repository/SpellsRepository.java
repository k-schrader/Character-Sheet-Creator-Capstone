package org.kalieschrader.CSC.repository;

import org.kalieschrader.CSC.model.Spells;
import org.springframework.data.jpa.repository.JpaRepository;

//Interface for spells repo, extends JpaRepo to allow use of data manipulation methods 
public interface SpellsRepository extends JpaRepository<Spells, String> {

	Spells findByName(String name);

	void deleteByName(String name);

}
