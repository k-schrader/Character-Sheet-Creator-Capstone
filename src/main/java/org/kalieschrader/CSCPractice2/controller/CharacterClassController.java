//package org.kalieschrader.CSCPractice2.controller;
//
//import org.kalieschrader.CSCPractice2.model.CharacterClass;
//import org.kalieschrader.CSCPractice2.model.Spells;
//import org.kalieschrader.CSCPractice2.repository.CharacterClassRepository;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.server.ResponseStatusException;
//import org.springframework.web.servlet.ModelAndView;
//
//import java.net.URI;
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//public class CharacterClassController {
//	@Autowired
//	private CharacterClassRepository characterClassRepo;
//
//   @GetMapping("/class")
//   public String classes(){
//       return "classes";
//   }
//	@GetMapping("/classes")
//	public List<CharacterClass> getAllCharacterClasses() {
//		return characterClassRepo.findAll();
//	}
//
//	@GetMapping("/classes/{name}")
//	public Optional<CharacterClass> getCharacterClassByClassName(@PathVariable("name") String name) {
//		return characterClassRepo.findByName(name);
//	}
//
//	@PostMapping("/edit")
//	public ModelAndView edit(@ModelAttribute CharacterClass charClass,
//			@RequestParam(value = "action", required = true) String action) {
//
//		if (action.equals("barbarian")) {
//			charClass.setName("Barbarian");
//		}
//		if (action.equals("bard")) {
//			charClass.setName("Bard");
//		}
//		if (action.equals("cleric")) {
//			charClass.setName("Cleric");
//		}
//		if (action.equals("druid")) {
//			charClass.setName("Druid");
//		}
//		if (action.equals("fighter")) {
//			charClass.setName("Fighter");
//		}
//		if (action.equals("paladin")) {
//			charClass.setName("Paladin");
//		}
//		if (action.equals("rogue")) {
//			charClass.setName("Rogue");
//		}
//		if (action.equals("sorcerer")) {
//			charClass.setName("Sorcer");
//		}
//		if (action.equals("warlock")) {
//			charClass.setName("Warlock");
//		}
//		if (action.equals("wizard")) {
//			charClass.setName("Wizard");
//		}
//		return edit(charClass, action);
//	
//	}
//
//	@PostMapping("/classes")
//	   public ResponseEntity<CharacterClass> createCharacterClass(@RequestBody CharacterClass characterClass){
//	       CharacterClass savedCharacterClass = characterClassRepo.save(characterClass);
//	       return ResponseEntity.created(URI.create("/characterClass/" + savedCharacterClass.getName())).body(savedCharacterClass);
//	   }
//
//	@PutMapping("/classes/{name}")
//	public ResponseEntity<CharacterClass> updateCharacterClass(@PathVariable String name,
//			@RequestBody CharacterClass charClass) {
//		CharacterClass existingCharacterClass = characterClassRepo.findByName(name)
//				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Class not found"));
//		existingCharacterClass.setName(charClass.getName());
//		existingCharacterClass.setHitDie(charClass.getHitDie());
//		existingCharacterClass.setSkills(charClass.getSkills());
//		existingCharacterClass.setWeapon1(charClass.getWeapon1());
//		existingCharacterClass.setWeapon2(charClass.getWeapon2());
//		existingCharacterClass.setWeapon3(charClass.getWeapon3());
//		existingCharacterClass.setArmor(charClass.getArmor());
//		existingCharacterClass.setDetails(charClass.getDetails());
//		existingCharacterClass.setNumCantrips(charClass.getNumCantrips());
//		existingCharacterClass.setNumSpells(charClass.getNumSpells());
//		existingCharacterClass.setClassFeat1(charClass.getClassFeat1());
//		existingCharacterClass.setClassFeat2(charClass.getClassFeat2());
//		existingCharacterClass.setClassFeat3(charClass.getClassFeat3());
//		existingCharacterClass.setSpellSlots(charClass.getSpellSlots());
//		existingCharacterClass.setSpellModifier(charClass.getSpellModifier());
//		CharacterClass savedClass = characterClassRepo.save(existingCharacterClass);
//		return ResponseEntity.ok(savedClass);
//	}
//
//	@DeleteMapping("/classes/{name}")
//	public ResponseEntity<Void> deleteCharacterClass(@PathVariable String name) {
//		characterClassRepo.deleteByName(name);
//		return ResponseEntity.noContent().build();
//	}
//
//}
