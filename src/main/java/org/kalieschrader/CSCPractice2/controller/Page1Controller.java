package org.kalieschrader.CSCPractice2.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.kalieschrader.CSCPractice2.model.CharacterRace;
import org.kalieschrader.CSCPractice2.model.CharacterSheet;
import org.kalieschrader.CSCPractice2.repository.CharacterClassRepository;
import org.kalieschrader.CSCPractice2.repository.CharacterRaceRepository;
import org.kalieschrader.CSCPractice2.repository.CharacterSheetRepository;
import org.kalieschrader.CSCPractice2.repository.ItemRepository;
import org.kalieschrader.CSCPractice2.repository.SpellsRepository;
import org.kalieschrader.CSCPractice2.repository.WeaponRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;

@SessionAttributes({"characterSheet"})
@Controller
public class Page1Controller {
	
	Logger logger = LoggerFactory.getLogger(Page1Controller.class);
	
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
	private WeaponRepository weaponRepo;
	
	@GetMapping("/page1")
	public ModelAndView getAllAttributes() {
		ModelAndView mav = new ModelAndView("charcreatorpage1"); //This is the page referenced, so the HTML file. It can match what's passed in above, but doesn't always
		mav.addObject("races", characterRaceRepo.findAll());
		mav.addObject("classes", charClassRepo.findAll());
		mav.addObject("characterSheet", new CharacterSheet());
		return mav;
	}
   

	@GetMapping("/page2")
	public ModelAndView getAllAttributes2(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("charcreatorpage2"); //This is the page referenced, so the HTML file. It can match what's passed in above, but doesn't always
		mav.addObject("characterSheet", request.getSession().getAttribute("characterSheet"));
		//logger.info(request.getSession().getAttribute("characterSheet").toString());
		mav.addObject("spells", spellsRepo.findAll());
//				for (spell : spells) {
//					if spell.castingClasses.contains(characterSheet.getClass.getClassName) {
//						mav.addObject("spells", spell);
//					}
//				}
		mav.addObject("items", itemRepo.findAll());
		mav.addObject("weapons", weaponRepo.findAll());//We're adding "spells" to our model and view here so we will be able to reference it from within the HTML page
		return mav;
	}

	@PostMapping("/page1")   
	public String createCharacterSheet(HttpServletRequest request, CharacterSheet charSheet){
	   CharacterSheet savedCharSheet = charSheetRepo.save(charSheet);
	   logger.info(charSheet.toString() + savedCharSheet.toString());
	   request.getSession().setAttribute("characterSheet", savedCharSheet);
	   //logger.info(request.getSession().getAttribute("characterSheet").toString());
       return "redirect:page2";
	}
	   
	 
}
