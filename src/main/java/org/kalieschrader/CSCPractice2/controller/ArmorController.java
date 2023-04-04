package org.kalieschrader.CSCPractice2.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.kalieschrader.CSCPractice2.model.Armor;
import org.kalieschrader.CSCPractice2.repository.ArmorRepository;
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

@RestController
public class ArmorController {
   @Autowired
      private ArmorRepository armorRepo;      
   @GetMapping("/armors")
   public List<Armor> getAllArmor(){
       return armorRepo.findAll();
   }
   @GetMapping("/armors/{armorName}")
   public Optional<Armor> getArmorByArmorName(@PathVariable("name") String name) {
       return  armorRepo.findByArmorName(name);
   }

   @PostMapping("/armors")
   public ResponseEntity<Armor> createArmor(@RequestBody Armor armor){
       Armor savedArmor = armorRepo.save(armor);
       return ResponseEntity.created(URI.create("/armor/" + savedArmor.getArmorName())).body(savedArmor);
   }

   @PutMapping("/armors/{armorName}")
   public ResponseEntity<Armor> updateArmor(@PathVariable String name, @RequestBody Armor armor){
	   Armor existingArmor = armorRepo.findByArmorName(name).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
			   "Armor not found"));
	   existingArmor.setArmorName(armor.getArmorName());
	   existingArmor.setAcBonus(armor.getAcBonus());
	   existingArmor.setDetails(armor.getDetails());
    	   Armor savedArmor = armorRepo.save(existingArmor);
           return ResponseEntity.ok(savedArmor);
       }

   @DeleteMapping("/armors/{armorName}")
   public ResponseEntity<Void> deleteArmor(@PathVariable String name) {
       armorRepo.deleteByArmorName(name);
       return ResponseEntity.noContent().build();
   }
 
}
