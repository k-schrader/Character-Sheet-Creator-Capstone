package org.kalieschrader.CSCPractice2.controller;

import org.kalieschrader.CSCPractice2.model.CharacterClass;
import org.kalieschrader.CSCPractice2.repository.CharacterClassRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;
import java.util.List;
import java.util.Optional;
@RestController
public class CharacterClassController {
   @Autowired
      private CharacterClassRepository characterClassRepo;      
//   @GetMapping("/classes")
//   public String classes(){
//       return "classes";
//   }
   @GetMapping("/classes")
   public List<CharacterClass> getAllCharacterClasses(){
       return characterClassRepo.findAll();
   }
   @GetMapping("/classes/{name}")
   public Optional<CharacterClass> getCharacterClassByClassName(@PathVariable("name") String name) {
       return characterClassRepo.findByName(name);
   }

   @PostMapping("/classes")
   public ResponseEntity<CharacterClass> createCharacterClass(@RequestBody CharacterClass charClass){
       CharacterClass savedClass = characterClassRepo.save(charClass);
       return ResponseEntity.created(URI.create("/classes/" + savedClass.getName())).body(savedClass);
   }

   @PutMapping("/classes/{name}")
   public ResponseEntity<CharacterClass> updateCharacterClass(@PathVariable String name, @RequestBody CharacterClass charClass){
	   CharacterClass existingCharacterClass = characterClassRepo.findByName(name).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
			   "Class not found"));
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
 
}

