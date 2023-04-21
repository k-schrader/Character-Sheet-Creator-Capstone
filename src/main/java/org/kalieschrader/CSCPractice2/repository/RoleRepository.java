package org.kalieschrader.CSCPractice2.repository;

import java.util.Collection;

import org.kalieschrader.CSCPractice2.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Collection<Role> findByName(String name);
}