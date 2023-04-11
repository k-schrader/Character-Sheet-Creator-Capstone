package org.kalieschrader.CSCPractice2.repository;

import java.util.Optional;


import org.kalieschrader.CSCPractice2.model.Weapon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeaponRepository extends JpaRepository<Weapon, String>{

	Optional<Weapon> findByWeaponName(String name);

	void deleteByWeaponName(String name);
	
}
