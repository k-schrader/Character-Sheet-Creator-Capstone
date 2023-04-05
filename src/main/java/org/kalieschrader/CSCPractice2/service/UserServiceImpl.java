package org.kalieschrader.CSCPractice2.service;


import org.kalieschrader.CSCPractice2.model.Role;
import org.kalieschrader.CSCPractice2.model.User;
import org.kalieschrader.CSCPractice2.repository.RoleRepository;
import org.kalieschrader.CSCPractice2.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository,
                           RoleRepository roleRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void saveUser(User user) {
        User userNew = new User();
        userNew.setUserName(user.getUserName());
        userNew.setUserEmail(user.getUserEmail());
        // encrypt the password using spring security
        userNew.setUserPass(passwordEncoder.encode(user.getUserPass()));

        Role role = roleRepository.findByName("ROLE_ADMIN");
        if(role == null){
            role = checkRoleExist();
        }
        userNew.setRoles(Arrays.asList(role));
        userRepository.save(userNew);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByUserEmail(email);
    }

    @Override
    public List<User> findAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map((user) -> mapToUser(user))
                .collect(Collectors.toList());
    }

    private User mapToUser(User user){
        User userNew = new User();
        userNew.setUserName(user.getUserName());
        userNew.setUserEmail(user.getUserEmail());
        return userNew;
    }

    private Role checkRoleExist(){
        Role role = new Role();
        role.setName("ROLE_ADMIN");
        return roleRepository.save(role);
    }

	@Override
	public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}


}
