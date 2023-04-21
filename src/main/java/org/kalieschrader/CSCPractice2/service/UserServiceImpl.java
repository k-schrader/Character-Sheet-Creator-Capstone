package org.kalieschrader.CSCPractice2.service;



import org.kalieschrader.CSCPractice2.DTO.UserDto;
import org.kalieschrader.CSCPractice2.model.Role;
//import org.kalieschrader.CSCPractice2.model.Role;
import org.kalieschrader.CSCPractice2.model.User;
import org.kalieschrader.CSCPractice2.repository.RoleRepository;
//import org.kalieschrader.CSCPractice2.repository.RoleRepository;
import org.kalieschrader.CSCPractice2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
    private UserRepository userRepository;
    @Autowired
	private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository,
                           RoleRepository roleRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        //this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void saveUser(UserDto userDto) {
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setEmail(userDto.getEmail());
        // encrypt the password using spring security
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
//        user.setRoles(Arrays.asList(getRoleByName("ROLE_USER")));
        user.setRoles(roleRepository.findByName("ROLE_USER"));
//        if(role == null){
//            role = checkRoleExist();
        
//        user.setRoles(Arrays.asList(role));
        userRepository.save(user);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<UserDto> findAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map((user) -> mapToUserDto(user))
                .collect(Collectors.toList());
    }

    private UserDto mapToUserDto(User user){
        UserDto userDto = new UserDto();
        String str = user.getFirstName();
        userDto.setFirstName(str);
        userDto.setEmail(user.getEmail());
        return userDto;
    }

//    private Role checkRoleExist(){
//        Role role = new Role();
//        role.setName("ROLE_USER");
//        return roleRepository.save(role);
//    }

 
@Override
public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    User user = userRepository.findByEmail(email);
    if (user == null){
        throw new UsernameNotFoundException("Invalid username or password.");
    }
    return new org.springframework.security.core.userdetails.User(user.getEmail(),
            user.getPassword(),
            mapRolesToAuthorities(user.getRoles()));
}

private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
    return roles.stream()
            .map(role -> new SimpleGrantedAuthority(role.getName()))
            .collect(Collectors.toList());
}
}

	
	//@Autowired
// private UserRepository userRepository;
////@Autowired
//// private RoleRepository roleRepository;
//@Autowired
//    private PasswordEncoder passwordEncoder;
//
////    public UserServiceImpl(UserRepository userRepository,
////                           
////                           PasswordEncoder passwordEncoder) {
////        this.userRepository = userRepository;
////      
////        this.passwordEncoder = passwordEncoder;
////    }
//    @Override
//    public void register(UserData user) throws UserAlreadyExistException {
//
//        //Let's check if user already registered with us
//        if(checkIfUserExist(user.getUsername())){
//            throw new UserAlreadyExistException("User already exists for this email");
//        }
//        User userEntity = new User();
//        BeanUtils.copyProperties(user, userEntity);
//        encodePassword(userEntity, user);
//        userRepository.save(userEntity);
//    }
//
//    
//    @Override
//    public boolean checkIfUserExist(String email) {
//        return userRepository.findByUsername(email) !=null ? true : false;
//    }
//
//    private void encodePassword( User userEntity, UserData user){
//        userEntity.setUserPass(passwordEncoder.encode(user.getUserPass()));
//    }
//}

//    @Override
//    public void saveUser(User user) {
//        User userNew = new User();
//        userNew.setPlayerName(user.getPlayerName());
//        userNew.setUsername(user.getUsername());
//        // encrypt the password using spring security
//        userNew.setUserPass(passwordEncoder.encode(user.getUserPass()));
//
//        Role role = roleRepository.findByName("ROLE_ADMIN");
//        if(role == null){
//            role = checkRoleExist();
//        }
//        userNew.setRoles(Arrays.asList(role));
//        userRepository.save(userNew);
//    }
//
//    @Override
//    public User findUserByUsername(String username) {
//        return userRepository.findByUsername(username);
//    }
//
//    @Override
//    public List<User> findAllUsers() {
//        List<User> users = userRepository.findAll();
//        return users.stream()
//                .map((user) -> mapToUser(user))
//                .collect(Collectors.toList());
//    }
//
//    private User mapToUser(User user){
//        User userNew = new User();
//        userNew.setPlayerName(user.getPlayerName());
//        userNew.setUsername(user.getUsername());
//        return userNew;
//    }
//
//    private Role checkRoleExist(){
//        Role role = new Role();
//        role.setName("ROLE_ADMIN");
//        return roleRepository.save(role);
//    }
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		User user = userRepository.findByUsername(username);
//		UserBuilder builder = null;
//		if (user !=null) {
//			builder = org.springframework.security.core.userdetails.User.withUsername(username);
//			builder.disabled(!user.isEnabled());
//			builder.password(user.getUserPass());
//			String [] authorities = user.getAuthorities().stream().map(a->a.getAuthority()).toArray(String[]::new);
//			builder.authorities(authorities);
//		} else {
//			throw new UsernameNotFoundException("User not found.");
//		}
//		return builder.build();                    
//	}
//
//
//}
