package org.kalieschrader.CSCPractice2.controller;

import jakarta.validation.Valid;

import org.kalieschrader.CSCPractice2.DTO.UserDto;
import org.kalieschrader.CSCPractice2.model.User;
import org.kalieschrader.CSCPractice2.service.UserAlreadyExistException;
import org.kalieschrader.CSCPractice2.service.UserData;
import org.kalieschrader.CSCPractice2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;



@Controller
public class AuthController {

	  private UserService userService;

	    public AuthController(UserService userService) {
	        this.userService = userService;
	    }

	    // handler method to handle home page request
	    @GetMapping("/index")
	    public String home(){
	        return "index";
	    }

	    // handler method to handle login request
	    @GetMapping("/login")
	    public String login(){
	        return "login";
	    }
	    
	    @GetMapping("/newcharacterstart")
	    public String start(){
	        return "newcharacterstart";
	    }

	    // handler method to handle user registration form request
	    @GetMapping("/register")
	    public String showRegistrationForm(Model model){
	        // create model object to store form data
	        UserDto user = new UserDto();
	        model.addAttribute("user", user);
	        return "register";
	    }

	    // handler method to handle user registration form submit request
	    @PostMapping("/register")
	    public String registration(@Valid @ModelAttribute("user") UserDto userDto,
	                               BindingResult result,
	                               Model model){
	        User existingUser = userService.findUserByEmail(userDto.getEmail());

	        if(existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()){
	            result.rejectValue("email", null,
	                    "There is already an account registered with the same email");
	        }

	        if(result.hasErrors()){
	            model.addAttribute("user", userDto);
	            return "/register";
	        }

	        userService.saveUser(userDto);
	        return "redirect:/register?success";
	    }

	    // handler method to handle list of users
	    @GetMapping("/users")
	    public String users(Model model){
	        List<UserDto> users = userService.findAllUsers();
	        model.addAttribute("users", users);
	        return "users";
	    }
	}
	
	
	
	
	
	
	
//    @GetMapping("/")
//    public String root() {
//        return "index";
//    }
//
//    @GetMapping("/login")
//    public String login(Model model) {
//        return "login";
//    }
//
//    @GetMapping("/user")
//    public String userIndex() {
//        return "user/index";
//    }
//}




//@Controller
//public class AuthController {
//@Autowired
//    private UserService userService;
//
//@GetMapping("/register")
//public String register(final Model model){
//    model.addAttribute("userData", new UserData());
//    return "account/register";
//}
//
//@PostMapping("/register")
//public String userRegistration(final @Valid  UserData userData, final BindingResult bindingResult, final Model model){
//    if(bindingResult.hasErrors()){
//        model.addAttribute("registrationForm", userData);
//        return "account/register";
//    }
//    try {
//        userService.register(userData);
//    }catch (UserAlreadyExistException e){
//        bindingResult.rejectValue("username", "userData.username","An account already exists for this email.");
//        model.addAttribute("registrationForm", userData);
//        return "account/register";
//    }
//    return "redirect:/index";
//}








//    public AuthController(UserService userService) {
//        this.userService = userService;
//    }
//
//    // handler method to handle home page request
//    @GetMapping("/index")
//    public String index(){
//        return "index";
//    }
//
//    // handler method to handle login request
//    @GetMapping("/login")
//    public String login(){
//        return "login";
//    }
//
//    // handler method to handle user registration form request
//    @GetMapping("/register")
//    public String showRegistrationForm(Model model){
//        // create model object to store form data
//        User user = new User();
//        model.addAttribute("user", user);
//        return "register";
//    }
//
//    // handler method to handle user registration form submit request
//    @PostMapping("/register/save")
//    public String registration(@Valid @ModelAttribute("user") User user,
//                               BindingResult result,
//                               Model model){
//        User existingUser = userService.findUserByUsername(user.getUsername());
//
//        if(existingUser != null && existingUser.getUsername() != null && !existingUser.getUsername().isEmpty()){
//            result.rejectValue("email", null,
//                    "There is already an account registered with the same email");
//        }
//
//        if(result.hasErrors()){
//            model.addAttribute("user", user);
//            return "/register";
//        }
//
//        userService.saveUser(user);
//        return "redirect:/index";
//    }
//
//    // handler method to handle list of users
//    @GetMapping("/users")
//    public String users(Model model){
//        List<User> users = userService.findAllUsers();
//        model.addAttribute("users", users);
//        return "users";
//    }
//}