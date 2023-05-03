package org.kalieschrader.CSC.repository;

import org.kalieschrader.CSC.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

}