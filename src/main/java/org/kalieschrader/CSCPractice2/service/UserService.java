package org.kalieschrader.CSCPractice2.service;

import java.util.List;

import org.kalieschrader.CSCPractice2.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


public interface UserService {
    void saveUser(User user);


    List<User> findAllUsers();

	UserDetails loadUserByUserEmail(String userEmail) throws UsernameNotFoundException;

	User findUserByUserEmail(String userEmail);
}