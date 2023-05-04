package org.kalieschrader.CSC.repository;

import java.util.Optional;
import org.kalieschrader.CSC.model.Armor;
import org.springframework.data.jpa.repository.JpaRepository;

//Interface for armor repo, extends JpaRepo to allow use of data manipulation methods 
public interface ArmorRepository extends JpaRepository<Armor, String> {
	// Finds by armor name but uses "Optional" to avoid a null pointer exception
	Optional<Armor> findByArmorName(String name);

	void deleteByArmorName(String name);
}