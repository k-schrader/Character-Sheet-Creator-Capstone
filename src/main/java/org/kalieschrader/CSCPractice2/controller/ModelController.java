package org.kalieschrader.CSCPractice2.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.kalieschrader.CSCPractice2.model.Armor;
import org.kalieschrader.CSCPractice2.model.CharacterClass;
import org.kalieschrader.CSCPractice2.model.CharacterRace;
import org.kalieschrader.CSCPractice2.model.CharacterSheet;
import org.kalieschrader.CSCPractice2.model.Item;
import org.kalieschrader.CSCPractice2.model.Spells;
import org.kalieschrader.CSCPractice2.model.Weapon;
import org.kalieschrader.CSCPractice2.repository.ArmorRepository;
import org.kalieschrader.CSCPractice2.repository.CharacterClassRepository;
import org.kalieschrader.CSCPractice2.repository.CharacterRaceRepository;
import org.kalieschrader.CSCPractice2.repository.CharacterSheetRepository;
import org.kalieschrader.CSCPractice2.repository.ItemRepository;
import org.kalieschrader.CSCPractice2.repository.SpellsRepository;
import org.kalieschrader.CSCPractice2.repository.WeaponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class ModelController {

	@Autowired
	private CharacterClassRepository characterClassRepo;
	@Autowired
	  private CharacterRaceRepository characterRaceRepo;  
	@Autowired
	public ItemRepository itemRepo;
	@Autowired
	private SpellsRepository spellsRepo;
	@Autowired
	private WeaponRepository weaponRepo;
	@Autowired
	private ArmorRepository armorRepo;
	@Autowired
	private CharacterSheetRepository charSheetRepo;
	
	//CLASSES
   @GetMapping("/class")
   public String classes(){
       return "classes";
   }
	@GetMapping("/classes")
	public List<CharacterClass> getAllCharacterClasses() {
		return characterClassRepo.findAll();
	}
	@GetMapping("/classes/{name}")
	public Optional<CharacterClass> getCharacterClassByClassName(@PathVariable("name") String name) {
		return characterClassRepo.findByName(name);
	}
	@PostMapping("/edit")
	public ModelAndView edit(@ModelAttribute CharacterClass charClass,
			@RequestParam(value = "action", required = true) String action) {

		if (action.equals("barbarian")) {
			charClass.setName("Barbarian");
		}
		if (action.equals("bard")) {
			charClass.setName("Bard");
		}
		if (action.equals("cleric")) {
			charClass.setName("Cleric");
		}
		if (action.equals("druid")) {
			charClass.setName("Druid");
		}
		if (action.equals("fighter")) {
			charClass.setName("Fighter");
		}
		if (action.equals("paladin")) {
			charClass.setName("Paladin");
		}
		if (action.equals("rogue")) {
			charClass.setName("Rogue");
		}
		if (action.equals("sorcerer")) {
			charClass.setName("Sorcer");
		}
		if (action.equals("warlock")) {
			charClass.setName("Warlock");
		}
		if (action.equals("wizard")) {
			charClass.setName("Wizard");
		}
		return edit(charClass, action);
	
	}
	@PostMapping("/classes")
	   public ResponseEntity<CharacterClass> createCharacterClass(@RequestBody CharacterClass characterClass){
	       CharacterClass savedCharacterClass = characterClassRepo.save(characterClass);
	       return ResponseEntity.created(URI.create("/characterClass/" + savedCharacterClass.getName())).body(savedCharacterClass);
	   }
	@PutMapping("/classes/{name}")
	public ResponseEntity<CharacterClass> updateCharacterClass(@PathVariable String name,
			@RequestBody CharacterClass charClass) {
		CharacterClass existingCharacterClass = characterClassRepo.findByName(name)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Class not found"));
		existingCharacterClass.setName(charClass.getName());
		existingCharacterClass.setHitDie(charClass.getHitDie());
		existingCharacterClass.setSkills(charClass.getSkills());
		existingCharacterClass.setWeapon1(charClass.getWeapon1());
		existingCharacterClass.setWeapon2(charClass.getWeapon2());
		existingCharacterClass.setWeapon3(charClass.getWeapon3());
		existingCharacterClass.setArmor(charClass.getArmor());
		existingCharacterClass.setDetails(charClass.getDetails());
		existingCharacterClass.setNumCantrips(charClass.getNumCantrips());
		existingCharacterClass.setNumSpells(charClass.getNumSpells());
		existingCharacterClass.setClassFeat1(charClass.getClassFeat1());
		existingCharacterClass.setClassFeat2(charClass.getClassFeat2());
		existingCharacterClass.setClassFeat3(charClass.getClassFeat3());
		existingCharacterClass.setSpellSlots(charClass.getSpellSlots());
		existingCharacterClass.setSpellModifier(charClass.getSpellModifier());
		CharacterClass savedClass = characterClassRepo.save(existingCharacterClass);
		return ResponseEntity.ok(savedClass);
	}
	@DeleteMapping("/classes/{name}")
	public ResponseEntity<Void> deleteCharacterClass(@PathVariable String name) {
		characterClassRepo.deleteByName(name);
		return ResponseEntity.noContent().build();
	}
      
	//RACES
@GetMapping("/races")
public List<CharacterRace> getAllCharacterRaces(){
   return characterRaceRepo.findAll();
}
@GetMapping("/races/{raceName}")
public Optional<CharacterRace> getCharacterRaceByRaceName(@PathVariable("name") String raceName) {
   return characterRaceRepo.findByRaceName(raceName);
}

@PostMapping("/races")
public ResponseEntity<CharacterRace> createCharacterRace(@RequestBody CharacterRace race){
   CharacterRace savedRace = characterRaceRepo.save(race);
   return ResponseEntity.created(URI.create("/races/" + savedRace.getRaceName())).body(savedRace);
}
@PutMapping("/races/{raceName}")
public ResponseEntity<CharacterRace> updateCharacterRace(@PathVariable String name, @RequestBody CharacterRace race){
   CharacterRace existingCharacterRace = characterRaceRepo.findByRaceName(name).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
		   "Race not found"));
	   existingCharacterRace.setRaceName(race.getRaceName());
	   existingCharacterRace.setAbilityScoreIn(race.getAbilityScoreIn());
	   existingCharacterRace.setRaceFeat1(race.getRaceFeat1());
	   existingCharacterRace.setRaceFeat2(race.getRaceFeat2());
	   existingCharacterRace.setRaceFeat3(race.getRaceFeat3());
	   existingCharacterRace.setLang(race.getLang());
	   existingCharacterRace.setDarkVision(race.isDarkVision());
	   existingCharacterRace.setDetails(race.getDetails());
	   existingCharacterRace.setSpeed(race.getSpeed());
	   CharacterRace savedRace = characterRaceRepo.save(existingCharacterRace);
       return ResponseEntity.ok(savedRace);
   }
@DeleteMapping("/races/{raceName}")
public ResponseEntity<Void> deleteCharacterRace(@PathVariable String name) {
   characterRaceRepo.deleteByRaceName(name);
   return ResponseEntity.noContent().build();
}
//SPELLS
@PostMapping("/spells")
public ResponseEntity<Spells> createSpells(@RequestBody Spells spell){
    Spells savedSpell = spellsRepo.save(spell);
    return ResponseEntity.created(URI.create("/spells/" + savedSpell.getName())).body(savedSpell);
}
//ITEMS
@PostMapping("/item")
public ResponseEntity<Item> createItem(@RequestBody Item item){
    Item savedItem = itemRepo.save(item);
    return ResponseEntity.created(URI.create("/item/" + savedItem.getItemName())).body(savedItem);
}
//WEAPONS
@PostMapping("/weapon")
public ResponseEntity<Weapon> createWeapon(@RequestBody Weapon weapon){
    Weapon savedWeapon = weaponRepo.save(weapon);
    return ResponseEntity.created(URI.create("/weapon/" + savedWeapon.getWeaponName())).body(savedWeapon);
}
//ARMOR
@PostMapping("/armor")
public ResponseEntity<Armor> createArmor(@RequestBody Armor armor){
    Armor savedArmor = armorRepo.save(armor);
    return ResponseEntity.created(URI.create("/armor/" + savedArmor.getArmorName())).body(savedArmor);

}
@PutMapping("/charsheet/{charId}")
public CharacterSheet updateCharacterSheet(@PathVariable Integer charId, @RequestBody CharacterSheet charSheet){
	   CharacterSheet existingCharSheet = charSheetRepo.findByCharId(charId);
		 if(!(charSheet.getCharName().isEmpty())) {
			   existingCharSheet.setCharName(charSheet.getCharName());
			 }if(!(charSheet.getHitPoints() == 0)){
			   existingCharSheet.setHitPoints(charSheet.getHitPoints());
			 }if(!(charSheet.getArmorClass() == 0)){
			   existingCharSheet.setArmorClass(charSheet.getArmorClass());
			 }if(!(charSheet.getSpellSaveDC().isEmpty())){
			   existingCharSheet.setSpellSaveDC(charSheet.getSpellSaveDC());
			 }if(!(charSheet.getSpellAttack().isEmpty())){
			   existingCharSheet.setSpellAttack(charSheet.getSpellAttack());
			 }if(!(charSheet.getStrength() == 0)){
			   existingCharSheet.setStrength(charSheet.getStrength());
			 }if(!(charSheet.getCon() == 0)){
			   existingCharSheet.setCon(charSheet.getCon());
			 }if(!(charSheet.getDex() == 0)){
			   existingCharSheet.setDex(charSheet.getDex());
			 }if(!(charSheet.getIntelligence() == 0)){
			   existingCharSheet.setIntelligence(charSheet.getIntelligence());
			 }if(!(charSheet.getWisdom() == 0)){
			   existingCharSheet.setWisdom(charSheet.getWisdom());
			 }if(!(charSheet.getWisdom() == 0)){
			   existingCharSheet.setCharisma(charSheet.getCharisma());
			 }
	   CharacterSheet savedCharSheet = charSheetRepo.save(existingCharSheet);
        return savedCharSheet;
    }
}


