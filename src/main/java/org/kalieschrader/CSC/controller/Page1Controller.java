package org.kalieschrader.CSC.controller;


import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.kalieschrader.CSC.model.CharacterSheet;
import org.kalieschrader.CSC.model.Spells;
import org.kalieschrader.CSC.model.User;
import org.kalieschrader.CSC.repository.CharacterClassRepository;
import org.kalieschrader.CSC.repository.CharacterRaceRepository;
import org.kalieschrader.CSC.repository.CharacterSheetRepository;
import org.kalieschrader.CSC.repository.ItemRepository;
import org.kalieschrader.CSC.repository.SpellsRepository;
import org.kalieschrader.CSC.repository.UserRepository;
import org.kalieschrader.CSC.service.FormattingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

//This class maps out and handles requests for the pages that build up the final character sheet
//Session attribute for storing our character sheet for the session
@SessionAttributes("characterSheet")
@Controller
public class Page1Controller {
	
	//New logger created for troubleshooting and debugging
	Logger logger = LoggerFactory.getLogger(Page1Controller.class);
	
	//Injects instances of each needed repository so that we can use them inside of this controller
	@Autowired
	public CharacterRaceRepository characterRaceRepo;
	@Autowired
	private CharacterClassRepository charClassRepo;
	@Autowired
	private CharacterSheetRepository charSheetRepo;
	@Autowired
	public ItemRepository itemRepo;
	@Autowired
	private SpellsRepository spellsRepo;
	@Autowired
	private UserRepository userRepo;
	
	//Instance of characterSheet 
	@ModelAttribute("characterSheet")
	public CharacterSheet setUpCharacterSheet() {
		return new CharacterSheet();
	}
	//Handles requests to the first page of the character creator 
	//All races and classes are added for the view to access by adding the attributes to the model
	@GetMapping(value = {"/page1", "/page1/{charId}"})
	public String viewPage(@PathVariable (required = false) Integer charId, Model model, Authentication authentication) {
		if(charId == null) {
		CharacterSheet charsheet = new CharacterSheet();
		model.addAttribute("characterSheet", charsheet);
		model.addAttribute("races", characterRaceRepo.findAll());
		model.addAttribute("classes", charClassRepo.findAll());
		return "charcreatorpage1";
		} else {
			CharacterSheet characterSheet = charSheetRepo.findByCharId(charId); 
			if(authentication.getName().equals(characterSheet.getUsername())) {
			model.addAttribute("characterSheet", characterSheet);
			model.addAttribute("races", characterRaceRepo.findAll());
			model.addAttribute("classes", charClassRepo.findAll());
			return "charcreatorpage1";
		}else {
			return "unauthorized";
		}
			
		}
	}
	//Adds the half finished character sheet from page one to a saved sheet to pass through to the second page to be finished 
	@PostMapping("/page1")
	public String createCharacterSheet(@ModelAttribute("characterSheet") CharacterSheet characterSheet, Model model) {
		CharacterSheet savedCharSheet = charSheetRepo.save(characterSheet);
		model.addAttribute("characterSheet", savedCharSheet);
		return "redirect:page2/" + savedCharSheet.getCharId();
	}
	//Handles requests to the second page of the character creator 
	//Adds the items and spells for the views to access 
	//If-else added to assure that only the same user from page one can access page 2
	@GetMapping(value = "/page2/{charId}")
	public String submit(@PathVariable("charId") Integer charId, Model model, Authentication authentication) {
		CharacterSheet characterSheet = charSheetRepo.findByCharId(charId); // Gets characterSheet with id passed in by page1 controller's redirect which adds our half finished character sheet values to the view 
		if(authentication.getName().equals(characterSheet.getUsername())) {
		model.addAttribute("characterSheet", characterSheet);
		model.addAttribute("items", itemRepo.findAll());
		List<Spells> spellsList = new ArrayList<Spells>();
		List<Spells> cantripsList = new ArrayList<Spells>(); //List of spells to only include cantrips
		String className = characterSheet.getCharClass().getName();
		for (Spells spell : spellsRepo.findAll()) {
			if (spell.getCastingClasses().contains(className)) {
				switch (spell.getCastingLevel()) { //Assess the spells casting level to separate into spells vs cantrips
				case 0:
					cantripsList.add(spell);
					break;
				case 1:
					spellsList.add(spell);
				}
			}
		}
		model.addAttribute("cantrips", cantripsList);
		model.addAttribute("spells", spellsList);
		return "charcreatorpage2";
	}else {
		return "unauthorized";
	}
	}

	//Added to test login and security to see which user is logged in 
	@GetMapping("/principal")
	public String getPrincipal(@CurrentSecurityContext(expression = "authentication.principal") Principal principal) {
		return principal.getName();
	}
	//Handles requests to view all users- available only to ROLE_ADMIN
	@GetMapping("/userview")
	public String viewUsers(Model model) {
		model.addAttribute("users", userRepo.findAll());
		return "userview";
	}
	//Handles requests to the final character sheet page 
	//If the user is authenticated they are passed on to their character sheet page 
	//New formatting service created to use on the view page 
	@GetMapping(value = "/charsheetpage/{charId}")
	public String charSheetPage(@PathVariable("charId") Integer charId, Model model, Authentication authentication) {
		CharacterSheet characterSheet = charSheetRepo.findByCharId(charId); // Gets characterSheet with id passed in by page1 controller's redirect
		if(authentication.getName().equals(characterSheet.getUsername())) {
		FormattingService formatting = new FormattingService(characterSheet);
		model.addAttribute("formatting", formatting);
		return "charsheetpage";
	}else {
		return "unauthorized";
	}
	}
	//Adds the finished character sheet to the final page 
	@PostMapping("/page2")
	public String updateCharacterSheet(@ModelAttribute("characterSheet") CharacterSheet characterSheet, Model model) {
		CharacterSheet savedCharSheet = charSheetRepo.save(characterSheet);
		model.addAttribute("characterSheet", savedCharSheet);
		return "redirect:charsheetpage/" + characterSheet.getCharId();
	}
	//Handles requests to view old character sheets 
	//Checks first if user is the same as the old sheet user, if else they are redirected to unauthorized page
	@GetMapping(value = "/oldcharacterview/{email}")
	public String oldCharSheet(@PathVariable("email") String email, Model model, Authentication authentication) {
		User user = userRepo.findByEmail(email); 
		if(authentication.getName().equals(email)){
		List<CharacterSheet> userChar = charSheetRepo.findAllByUsername(email);
		model.addAttribute("user", user);
		model.addAttribute("userChar", userChar);
			return "oldcharacterview";
	}else {
		return "unauthorized";
}
	}
	@PostMapping("/deletecheck/{charId}")
	public String deleteCharacterSheet(@PathVariable("charId") int charId, Model model, Authentication authentication) {
		CharacterSheet characterSheet = charSheetRepo.findByCharId(charId);
		if(authentication.getName().equals(characterSheet.getUsername())) {
		charSheetRepo.deleteById(charId);
		return "redirect:/oldcharacterview/" + authentication.getName();
	}else {
		return "unauthorized";
	}
}
}
