package org.kalieschrader.CSC.repository;
import java.util.Optional;

import org.kalieschrader.CSC.model.Armor;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ArmorRepository extends JpaRepository<Armor, String>{
		Optional<Armor> findByArmorName(String name);

		void deleteByArmorName(String name);
}