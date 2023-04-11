package org.kalieschrader.CSCPractice2.repository;

import java.util.Optional;


import org.kalieschrader.CSCPractice2.model.Item;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, String>{
	Optional<Item> findByItemName(String name);

	void deleteByItemName(String name);

}