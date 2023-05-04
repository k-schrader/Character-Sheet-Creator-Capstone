package org.kalieschrader.CSC.repository;

import java.util.Collection;

import org.kalieschrader.CSC.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

//Interface for role repo, extends JpaRepo to allow use of data manipulation methods 
public interface RoleRepository extends JpaRepository<Role, Long> {

	Collection<Role> findByName(String name);
}