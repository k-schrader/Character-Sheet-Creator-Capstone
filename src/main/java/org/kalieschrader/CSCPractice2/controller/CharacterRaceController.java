package org.kalieschrader.CSCPractice2.controller;

import org.kalieschrader.CSCPractice2.model.CharacterRace;
import org.kalieschrader.CSCPractice2.repository.CharacterRaceRepository;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;
import java.util.List;
import java.util.Optional;
@RestController
public class CharacterRaceController {
   @Autowired
      private CharacterRaceRepository characterRaceRepo;      
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
 
}