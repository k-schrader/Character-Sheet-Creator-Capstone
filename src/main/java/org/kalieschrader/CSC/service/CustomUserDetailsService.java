package org.kalieschrader.CSC.service;

import org.kalieschrader.CSC.model.User;
import org.kalieschrader.CSC.repository.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;

//This class implements UserDetailsService which lets us retrieve details about a user
//When a user logs in, Spring Security uses this class to get user details from the DB to verify their identity 
@Service
public class CustomUserDetailsService implements UserDetailsService {

	private UserRepository userRepository;

	public CustomUserDetailsService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	// Finds user by username and returns a UserDetails object with all the user
	// info
	// If the user does not exist it throws UsernameNotFoundException
	@Override
	public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {

		User user = userRepository.findByEmail(usernameOrEmail);
		if (user != null) {
			return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
					user.getRoles().stream().map((role) -> new SimpleGrantedAuthority(role.getName()))
							.collect(Collectors.toList()));
		} else {
			throw new UsernameNotFoundException("Invalid email or password");
		}
	}
}