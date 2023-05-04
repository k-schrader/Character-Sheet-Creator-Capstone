package org.kalieschrader.CSC.service;

import java.util.List;

import org.kalieschrader.CSC.DTO.UserDto;
import org.kalieschrader.CSC.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

//Manages user data in DB
public interface UserService {
	// Creates or updates a user
	void saveUser(UserDto userDto);

	// Finds a user by email
	User findUserByEmail(String email);

	// Returns a list of UserDto objects which contains user info
	List<UserDto> findAllUsers();

	// Loads user by username and throws exception if no user is found with that
	// username
	UserDetails loadUserByUsername(String email) throws UsernameNotFoundException;
}