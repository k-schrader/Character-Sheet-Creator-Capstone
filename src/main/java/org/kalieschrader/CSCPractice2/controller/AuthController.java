package org.kalieschrader.CSCPractice2.controller;

import jakarta.validation.Valid;

import org.kalieschrader.CSCPractice2.DTO.UserDto;
import org.kalieschrader.CSCPractice2.model.CharacterSheet;
import org.kalieschrader.CSCPractice2.model.User;
import org.kalieschrader.CSCPractice2.repository.CharacterSheetRepository;
import org.kalieschrader.CSCPractice2.service.UserAlreadyExistException;
import org.kalieschrader.CSCPractice2.service.UserData;
import org.kalieschrader.CSCPractice2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Controller
public class AuthController {
	
	@Autowired
	CharacterSheetRepository charSheetRepo;

	  private UserService userService;
	  
	  @ModelAttribute("user")
	   public UserDto userDto() {
	       return new UserDto();
	   }

	    public AuthController(UserService userService) {
	        this.userService = userService;
	    }

	    //Handles requests to the home page
	    @GetMapping("/index")
	    public String home(){
	        return "index";
	    }
	    //Handles requests to the parent info page
	    @GetMapping("/parentInfo")
	    public String parentInfo(){
	        return "parentInfo";
	    }
	    //Handles requests to the unauthorized page
	    @GetMapping("/unauthorized")
	    public String unauthorized(){
	        return "unauthorized";
	    }
	    @GetMapping("/diceroller")
	    public String diceroller(){
	        return "diceroller";
	    }

	    //Handles requests to the login page
	    @GetMapping("/login")
	    public String login(){
	        return "login";
	    }
	    //Handles requests to the new character start page
	    @GetMapping("/newcharacterstart")
	    public String start(){
	        return "newcharacterstart";
	    }
	    @GetMapping("/deletecheck/{charId}")
	    public String deletecheck(@PathVariable("charId") int charId, Model model){
			CharacterSheet characterSheet = charSheetRepo.findByCharId(charId); 
			model.addAttribute("characterSheet", characterSheet);
	        return "deletecheck";
	    }

	    //Handles requests for user registration form 
	    @GetMapping("/register")
	    public String showRegistrationForm(Model model){
	        //Creates a new user object to store data from the registration form
	        UserDto user = new UserDto();
	        model.addAttribute("user", user);
	        return "register";
	    }

	    //Handles user registration when registration form is submitted 
	    @PostMapping("/register")
	    public String registration(@Valid @ModelAttribute("user") UserDto userDto,
	                               BindingResult result,
	                               Model model){
	        User existingUser = userService.findUserByEmail(userDto.getEmail());
	        //Checks for user already exists 
	        if(existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()){
	            result.rejectValue("email", null,
	                    "There is already an account registered with the same email");
	        }

	        if(result.hasErrors()){
	            model.addAttribute("user", userDto);
	            return "/register";
	        }
	        //Saves user to the DB 
	        userService.saveUser(userDto);
	        return "redirect:/register?success";
	    }

	}
