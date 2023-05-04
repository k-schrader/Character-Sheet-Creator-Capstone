package org.kalieschrader.CSC.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import org.kalieschrader.CSC.model.Armor;
import org.kalieschrader.CSC.model.CharacterClass;
import org.kalieschrader.CSC.model.CharacterRace;
import org.kalieschrader.CSC.model.CharacterSheet;
import org.kalieschrader.CSC.model.Item;
import org.kalieschrader.CSC.model.Spells;
import org.kalieschrader.CSC.model.Weapon;
import org.kalieschrader.CSC.repository.ArmorRepository;
import org.kalieschrader.CSC.repository.CharacterClassRepository;
import org.kalieschrader.CSC.repository.CharacterRaceRepository;
import org.kalieschrader.CSC.repository.CharacterSheetRepository;
import org.kalieschrader.CSC.repository.ItemRepository;
import org.kalieschrader.CSC.repository.SpellsRepository;
import org.kalieschrader.CSC.repository.WeaponRepository;
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
import org.springframework.web.server.ResponseStatusException;

//This class is the controller for all of our model classes
//Each method here allows us to create new instances of our model objects, or read/edit/delete them
//Used mostly for me to manipulate data in the DB from postman
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

	// CLASSES
	@GetMapping("/class")
	public String classes() {
		return "classes";
	}// Retrieves all existing classes

	@GetMapping("/classes")
	public List<CharacterClass> getAllCharacterClasses() {
		return characterClassRepo.findAll();
	}// Retrieves classes by name

	@GetMapping("/classes/{name}")
	public Optional<CharacterClass> getCharacterClassByClassName(@PathVariable("name") String name) {
		return characterClassRepo.findByName(name);
	}

	// Creates a new class
	@PostMapping("/classes")
	public ResponseEntity<CharacterClass> createCharacterClass(@RequestBody CharacterClass characterClass) {
		CharacterClass savedCharacterClass = characterClassRepo.save(characterClass);
		return ResponseEntity.created(URI.create("/characterClass/" + savedCharacterClass.getName()))
				.body(savedCharacterClass);
	}

	// Edits an existing class
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
	}// Deletes an existing class

	@DeleteMapping("/classes/{name}")
	public ResponseEntity<Void> deleteCharacterClass(@PathVariable String name) {
		characterClassRepo.deleteByName(name);
		return ResponseEntity.noContent().build();
	}

	// RACES
	// Returns all existing races
	@GetMapping("/races")
	public List<CharacterRace> getAllCharacterRaces() {
		return characterRaceRepo.findAll();
	}

//Returns race selected by name
	@GetMapping("/races/{raceName}")
	public Optional<CharacterRace> getCharacterRaceByRaceName(@PathVariable("name") String raceName) {
		return characterRaceRepo.findByRaceName(raceName);
	}

//Creates a new race
	@PostMapping("/races")
	public ResponseEntity<CharacterRace> createCharacterRace(@RequestBody CharacterRace race) {
		CharacterRace savedRace = characterRaceRepo.save(race);
		return ResponseEntity.created(URI.create("/races/" + savedRace.getRaceName())).body(savedRace);
	}

//Edits an existing race
	@PutMapping("/races/{raceName}")
	public ResponseEntity<CharacterRace> updateCharacterRace(@PathVariable String name,
			@RequestBody CharacterRace race) {
		CharacterRace existingCharacterRace = characterRaceRepo.findByRaceName(name)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Race not found"));
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

//Deletes an existing race
	@DeleteMapping("/races/{raceName}")
	public ResponseEntity<Void> deleteCharacterRace(@PathVariable String name) {
		characterRaceRepo.deleteByRaceName(name);
		return ResponseEntity.noContent().build();
	}

//SPELLS
//Creates new spells
	@PostMapping("/spells")
	public ResponseEntity<Spells> createSpells(@RequestBody Spells spell) {
		Spells savedSpell = spellsRepo.save(spell);
		return ResponseEntity.created(URI.create("/spells/" + savedSpell.getName())).body(savedSpell);
	}

//ITEMS
//Creates new items
	@PostMapping("/item")
	public ResponseEntity<Item> createItem(@RequestBody Item item) {
		Item savedItem = itemRepo.save(item);
		return ResponseEntity.created(URI.create("/item/" + savedItem.getItemName())).body(savedItem);
	}

//WEAPONS
//Creates new weapons
	@PostMapping("/weapon")
	public ResponseEntity<Weapon> createWeapon(@RequestBody Weapon weapon) {
		Weapon savedWeapon = weaponRepo.save(weapon);
		return ResponseEntity.created(URI.create("/weapon/" + savedWeapon.getWeaponName())).body(savedWeapon);
	}

//ARMOR
//Creates new armor
	@PostMapping("/armor")
	public ResponseEntity<Armor> createArmor(@RequestBody Armor armor) {
		Armor savedArmor = armorRepo.save(armor);
		return ResponseEntity.created(URI.create("/armor/" + savedArmor.getArmorName())).body(savedArmor);

	}

//Updates an existing CharacterSheet object, this is done so that we can add on new information the the same character sheet
//over multiple pages 
	@PutMapping("/charsheet/{charId}")
	public CharacterSheet updateCharacterSheet(@PathVariable Integer charId, @RequestBody CharacterSheet charSheet) {
		CharacterSheet existingCharSheet = charSheetRepo.findByCharId(charId);
		if (!(charSheet.getCharName().isEmpty())) {
			existingCharSheet.setCharName(charSheet.getCharName());
		}
		if (!(charSheet.getHitPoints() == 0)) {
			existingCharSheet.setHitPoints(charSheet.getHitPoints());
		}
		if (!(charSheet.getStrength() == 0)) {
			existingCharSheet.setStrength(charSheet.getStrength());
		}
		if (!(charSheet.getCon() == 0)) {
			existingCharSheet.setCon(charSheet.getCon());
		}
		if (!(charSheet.getDex() == 0)) {
			existingCharSheet.setDex(charSheet.getDex());
		}
		if (!(charSheet.getIntelligence() == 0)) {
			existingCharSheet.setIntelligence(charSheet.getIntelligence());
		}
		if (!(charSheet.getWisdom() == 0)) {
			existingCharSheet.setWisdom(charSheet.getWisdom());
		}
		if (!(charSheet.getWisdom() == 0)) {
			existingCharSheet.setCharisma(charSheet.getCharisma());
		}
		CharacterSheet savedCharSheet = charSheetRepo.save(existingCharSheet);
		return savedCharSheet;
	}

	@DeleteMapping("/charsheet/{charId}")
	public ResponseEntity<Void> deleteCharacterSheet(@PathVariable Integer charId) {
		charSheetRepo.deleteByCharId(charId);
		return ResponseEntity.noContent().build();
	}

}
