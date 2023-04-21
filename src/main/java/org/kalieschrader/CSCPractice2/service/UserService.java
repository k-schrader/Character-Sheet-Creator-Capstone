package org.kalieschrader.CSCPractice2.service;

import java.util.List;

import org.kalieschrader.CSCPractice2.DTO.UserDto;
import org.kalieschrader.CSCPractice2.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


public interface UserService{
    void saveUser(UserDto userDto);

    User findUserByEmail(String email);

    List<UserDto> findAllUsers();

	UserDetails loadUserByUsername(String email) throws UsernameNotFoundException;
}