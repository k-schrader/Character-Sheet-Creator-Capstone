package org.kalieschrader.CSC.repository;

import org.kalieschrader.CSC.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

//Interface for user repo, extends JpaRepo to allow use of data manipulation methods 
public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);

}