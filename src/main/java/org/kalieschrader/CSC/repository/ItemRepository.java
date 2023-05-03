package org.kalieschrader.CSC.repository;

import java.util.Optional;

import org.kalieschrader.CSC.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, String>{
	Optional<Item> findByItemName(String name);

	void deleteByItemName(String name);

}