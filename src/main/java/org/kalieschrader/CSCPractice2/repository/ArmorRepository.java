package org.kalieschrader.CSCPractice2.repository;
import java.util.Optional;
import org.kalieschrader.CSCPractice2.model.Armor;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ArmorRepository extends JpaRepository<Armor, Long>{
		Optional<Armor> findByArmorName(String name);

		void deleteByArmorName(String name);
}