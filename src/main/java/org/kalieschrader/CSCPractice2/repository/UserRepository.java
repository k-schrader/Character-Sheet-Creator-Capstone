package org.kalieschrader.CSCPractice2.repository;

import org.kalieschrader.CSCPractice2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

}