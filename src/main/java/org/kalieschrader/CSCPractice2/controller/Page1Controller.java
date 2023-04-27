package org.kalieschrader.CSCPractice2.controller;

import java.net.URI;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.kalieschrader.CSCPractice2.model.CharacterRace;
import org.kalieschrader.CSCPractice2.model.CharacterSheet;
import org.kalieschrader.CSCPractice2.model.Spells;
import org.kalieschrader.CSCPractice2.model.User;
import org.kalieschrader.CSCPractice2.repository.CharacterClassRepository;
import org.kalieschrader.CSCPractice2.repository.CharacterRaceRepository;
import org.kalieschrader.CSCPractice2.repository.CharacterSheetRepository;
import org.kalieschrader.CSCPractice2.repository.ItemRepository;
import org.kalieschrader.CSCPractice2.repository.SpellsRepository;
import org.kalieschrader.CSCPractice2.repository.UserRepository;
import org.kalieschrader.CSCPractice2.repository.WeaponRepository;
import org.kalieschrader.CSCPractice2.service.FormattingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.websocket.server.PathParam;

@SessionAttributes("characterSheet")
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
	private ModelController modelController;
	@Autowired
	private UserRepository userRepo;

	@ModelAttribute("characterSheet")
	public CharacterSheet setUpCharacterSheet() {
		return new CharacterSheet();
	}

	@GetMapping(value = "/page1")
	public String viewPage(Model model) {
		CharacterSheet charsheet = new CharacterSheet();
		model.addAttribute("characterSheet", charsheet);
		model.addAttribute("races", characterRaceRepo.findAll());
		model.addAttribute("classes", charClassRepo.findAll());
		return "charcreatorpage1";
	}

	@PostMapping("/page1")
	public String createCharacterSheet(@ModelAttribute("characterSheet") CharacterSheet characterSheet, Model model) {
		CharacterSheet savedCharSheet = charSheetRepo.save(characterSheet);
		model.addAttribute("characterSheet", savedCharSheet);
		return "redirect:page2/" + savedCharSheet.getCharId();
	}

	@GetMapping(value = "/page2/{charId}")
	public String submit(@PathVariable("charId") Integer charId, Model model, Authentication authentication) {
		CharacterSheet characterSheet = charSheetRepo.findByCharId(charId); // Gets characterSheet with id passed in by page1 controller's redirect
		if(authentication.getName().equals(characterSheet.getUsername())) {
		model.addAttribute("characterSheet", characterSheet);
		model.addAttribute("items", itemRepo.findAll());
		List<Spells> spellsList = new ArrayList<Spells>();
		List<Spells> cantripsList = new ArrayList<Spells>(); // Here, I'm creating another list of spells but this one will only have cantrips in it
		String className = characterSheet.getCharClass().getName();
		for (Spells spell : spellsRepo.findAll()) {
			if (spell.getCastingClasses().contains(className)) {
				switch (spell.getCastingLevel()) { // Here, we read in the spell's casting level and put it in one of the lists accordingly.
				case 0:
					cantripsList.add(spell);
					break;
				case 1:
					spellsList.add(spell);
				}
			}
		} // This can be expanded in the future by creating a list for each level of spell the same way we did for cantrips.
		model.addAttribute("cantrips", cantripsList);
		model.addAttribute("spells", spellsList);
		return "charcreatorpage2";
	}else {
		return "unauthorized";
	}
	}

	@GetMapping("/principal")
	public String getPrincipal(@CurrentSecurityContext(expression = "authentication.principal") Principal principal) {
		return principal.getName();
	}

//	  @GetMapping(value = "/charsheetpage/{charId}")
//	  public String submit2(@PathVariable("charId") Integer charId, Model model) {
//		  CharacterSheet characterSheet = charSheetRepo.findByCharId(charId);
//		  logger.info(characterSheet.toString());
//		  FormattingService formatting = new FormattingService(characterSheet);
////			model.addAttribute("characterSheet", characterSheet);
//			model.addAttribute("formatting", formatting);
//			return "charsheetpage";
//		}

	// TODO update schema to remove unnecessary columns from characterSheet,
	// including: armor_class, spell_attack, spell_savedc, armor_armor_name,
	@GetMapping(value = "/charsheetpage/{charId}")
	public String charSheetPage(@PathVariable("charId") Integer charId, Model model, Authentication authentication) {
		CharacterSheet characterSheet = charSheetRepo.findByCharId(charId); // Gets characterSheet with id passed in by
		if(authentication.getName().equals(characterSheet.getUsername())) {																// page1 controller's redirect
		FormattingService formatting = new FormattingService(characterSheet);
		model.addAttribute("formatting", formatting);
		return "charsheetpage";
	}else {
		return "unauthorized";
	}
	}

	@PostMapping("/page2")
	public String updateCharacterSheet(@ModelAttribute("characterSheet") CharacterSheet characterSheet, Model model) {
		CharacterSheet savedCharSheet = charSheetRepo.save(characterSheet);
		model.addAttribute("characterSheet", savedCharSheet);
		return "redirect:charsheetpage/" + characterSheet.getCharId();
	}
	
	
//	@PostMapping("/charsheetpage")
//	public String saveCharSheet(@ModelAttribute("user") User user, Model model) {
//		User savedUser = userRepo.findByEmail(user.getEmail());
//		model.addAttribute("user", savedUser);
//		return "redirect:/oldcharacterview/" + savedUser.getEmail();
//	}

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
//		@PostMapping("/page2")  
//		public String updateCharacterSheet(@ModelAttribute("characterSheet") CharacterSheet characterSheet, Model model){
//		  // ResponseEntity<CharacterSheet> savedCharSheet = modelController.updateCharacterSheet(charSheet.getCharId(), charSheet);
//		   logger.info(characterSheet.toString());
//			   CharacterSheet existingCharSheet = charSheetRepo.findByCharId(characterSheet.getCharId());
//			  // CharacterSheet savedCharSheet = modelController.updateCharacterSheet(characterSheet.getCharId(), existingCharSheet);
//			  charSheetRepo.save(existingCharSheet);
////			   model.addAttribute("characterSheet", existingCharSheet);
//			return "redirect:charsheetpage/"+characterSheet.getCharId();
////			   return (ResponseEntity<CharacterSheet>) ResponseEntity.created(URI.create("/charsheetpage/" + existingCharSheet.getCharId()));
//			} 

//	@GetMapping("/page1")
//	public ModelAndView getAllAttributes() {
//		ModelAndView mav = new ModelAndView("charcreatorpage1"); //This is the page referenced, so the HTML file. It can match what's passed in above, but doesn't always
//		mav.addObject("races", characterRaceRepo.findAll());
//		mav.addObject("classes", charClassRepo.findAll());
//		mav.addObject("characterSheet", new CharacterSheet());
//		return mav;
//	}

//	@GetMapping("/page2/{charId}")
//	public String charSheetInfo(@ModelAttribute("characterSheet") CharacterSheet charSheet, Model model) {
	// ModelAndView mav = new ModelAndView("charcreatorpage2"); //This is the page
	// referenced, so the HTML file. It can match what's passed in above, but
	// doesn't always
	// model.addAttribute(CharacterSheet)
	// charSheet1 = charSheetRepo.findByCharId(charSheet1.getCharId());
	// model.addAttribute("charSheet1", charSheetInfo(charSheet, model));

//		//logger.info(request.getSession().getAttribute("characterSheet").toString());
////		mav.addObject("spells", spellsRepo.findAll());
////				for (spell : spells) {
////					if spell.castingClasses.contains(characterSheet.getClass.getClassName) {
////						mav.addObject("spells", spell);
////					}
//////				}
//		model.addAttribute("items", itemRepo.findAll());
//		model.addAttribute("weapon1", weaponRepo.findByWeaponName(charSheet.getCharClass().getWeapon1().getWeaponName()));//We're adding "spells" to our model and view here so we will be able to reference it from within the HTML page
//		model.addAttribute("weapon2", weaponRepo.findByWeaponName(charSheet.getCharClass().getWeapon2().getWeaponName()));
//		model.addAttribute("weapon3", weaponRepo.findByWeaponName(charSheet.getCharClass().getWeapon3().getWeaponName()));
//		return "charcreatorpage2";
//	}

}
