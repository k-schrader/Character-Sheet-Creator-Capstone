package org.kalieschrader.CSCPractice2.service;

import java.util.List;

import org.kalieschrader.CSCPractice2.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


public interface UserService {
    void saveUser(User user);

    User findUserByEmail(String email);

    List<User> findAllUsers();

	UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException;
}