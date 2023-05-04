package org.kalieschrader.CSC.controller;

import jakarta.validation.Valid;

import org.kalieschrader.CSC.DTO.UserDto;
import org.kalieschrader.CSC.model.CharacterSheet;
import org.kalieschrader.CSC.model.User;
import org.kalieschrader.CSC.repository.CharacterSheetRepository;
import org.kalieschrader.CSC.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {
	
	//Injects instance of CharacterSheetRepository 
	@Autowired
	CharacterSheetRepository charSheetRepo;

	private UserService userService;

	//Adds UserDto object to the model 
	@ModelAttribute("user")
	public UserDto userDto() {
		return new UserDto();
	}
	//Injects instance of UserService into AuthController so we can use its methods
	public AuthController(UserService userService) {
		this.userService = userService;
	}

	// Handles requests to the home page
	@GetMapping("/index")
	public String home() {
		return "index";
	}

	// Handles requests to the parent info page
	@GetMapping("/parentInfo")
	public String parentInfo() {
		return "parentInfo";
	}

	// Handles requests to the unauthorized page
	@GetMapping("/unauthorized")
	public String unauthorized() {
		return "unauthorized";
	}

	// Handles requests to the dice roller page
	@GetMapping("/diceroller")
	public String diceroller() {
		return "diceroller";
	}

	// Handles requests to the login page
	@GetMapping("/login")
	public String login() {
		return "login";
	}

	// Handles requests to the new character start page
	@GetMapping("/newcharacterstart")
	public String start() {
		return "newcharacterstart";
	}

	// Handles requests to the delete page, adds the charId to the URL to delete by
	// id
	@GetMapping("/deletecheck/{charId}")
	public String deletecheck(@PathVariable("charId") int charId, Model model) {
		// Finds desired sheet by id
		CharacterSheet characterSheet = charSheetRepo.findByCharId(charId);
		model.addAttribute("characterSheet", characterSheet);
		return "deletecheck";
	}

	// Handles requests for user registration form
	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
		// Creates a new user object to store data from the registration form
		UserDto user = new UserDto();
		model.addAttribute("user", user);
		return "register";
	}

	// Handles user registration when registration form is submitted
	@PostMapping("/register")
	public String registration(@Valid @ModelAttribute("user") UserDto userDto, BindingResult result, Model model) {
		User existingUser = userService.findUserByEmail(userDto.getEmail());
		// Checks for user already exists
		if (existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()) {
			result.rejectValue("email", null, "There is already an account registered with the same email");
		}
		//If the form is filled out with errors, we return the registration page with an error
		if (result.hasErrors()) {
			model.addAttribute("user", userDto);
			return "/register";
		}
		// Saves user to the DB if no errors and redirects to the success page
		userService.saveUser(userDto);
		return "redirect:/register?success";
	}

}
