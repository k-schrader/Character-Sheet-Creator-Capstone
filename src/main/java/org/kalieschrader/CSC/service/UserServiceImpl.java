package org.kalieschrader.CSC.service;

import org.kalieschrader.CSC.DTO.UserDto;
import org.kalieschrader.CSC.model.Role;
import org.kalieschrader.CSC.model.User;
import org.kalieschrader.CSC.repository.RoleRepository;
import org.kalieschrader.CSC.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.List;

//User management! 
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;

	public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository,
			PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	// Saves a user! Takes UserDto and creates a new user by setting the fields from
	// the UserDto
	// Encodes the password with our BCrypt encoder
	// Assigns the role of user
	@Override
	public void saveUser(UserDto userDto) {
		User user = new User();
		user.setFirstName(userDto.getFirstName());
		user.setEmail(userDto.getEmail());
		user.setPassword(passwordEncoder.encode(userDto.getPassword()));
		user.setRoles(roleRepository.findByName("ROLE_USER"));
		userRepository.save(user);
	}

	// Find a user by email using the user repo find by email method, returns a user
	@Override
	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	// Finds all user objects from user repo
	// Maps each user object to a UserDto object
	// Returns a list of UserDto objects
	@Override
	public List<UserDto> findAllUsers() {
		List<User> users = userRepository.findAll();
		return users.stream().map((user) -> mapToUserDto(user)).collect(Collectors.toList());
	}

	// Maps a user object to a UserDto object
	private UserDto mapToUserDto(User user) {
		UserDto userDto = new UserDto();
		String str = user.getFirstName();
		userDto.setFirstName(str);
		userDto.setEmail(user.getEmail());
		return userDto;
	}

//Loads a UserDetails object by username
//Utilized user repo to find a user by email, if not null it returns the details of the user (email, pass, roles)
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(email);
		if (user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
				mapRolesToAuthorities(user.getRoles()));
	}

//Maps the user roles to authorities using the "SimpleGrantedAuthority" class and the "GrantedAuthority" interface 
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}
}
