package org.kalieschrader.CSCPractice2.repository;

import org.kalieschrader.CSCPractice2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
User findByUserEmail(String userEmail);
}