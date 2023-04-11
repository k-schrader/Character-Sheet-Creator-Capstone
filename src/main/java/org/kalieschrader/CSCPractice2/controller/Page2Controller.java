package org.kalieschrader.CSCPractice2.controller;

import java.net.URI;
import java.util.List;

import org.kalieschrader.CSCPractice2.model.CharacterRace;
import org.kalieschrader.CSCPractice2.model.Item;
import org.kalieschrader.CSCPractice2.model.Spells;
import org.kalieschrader.CSCPractice2.model.Weapon;
import org.kalieschrader.CSCPractice2.repository.ItemRepository;
import org.kalieschrader.CSCPractice2.repository.SpellsRepository;
import org.kalieschrader.CSCPractice2.repository.WeaponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Page2Controller {
	@Autowired
	public ItemRepository itemRepo;
	@Autowired
	private SpellsRepository spellsRepo;
	@Autowired
	private WeaponRepository weaponRepo;
	   @GetMapping("/page2")
		public ModelAndView getAllAttributes() {
			ModelAndView mav = new ModelAndView("charcreatorpage2"); //This is the page referenced, so the HTML file. It can match what's passed in above, but doesn't always
			mav.addObject("spells", spellsRepo.findAll());
//			for (spell : spells) {
//				if spell.castingClasses.contains(characterSheet.getClass.getClassName) {
//					mav.addObject("spells", spell);
//				}
//			}
			mav.addObject("items", itemRepo.findAll());
			mav.addObject("weapons", weaponRepo.findAll());//We're adding "spells" to our model and view here so we will be able to reference it from within the HTML page
			return mav;
		}
	
//	@GetMapping("/spells") //This is what's passed into the controller, so what's typed in the URL bar
//	public ModelAndView getAllSpells() {
//		ModelAndView mav = new ModelAndView("spells-list"); //This is the page referenced, so the HTML file. It can match what's passed in above, but doesn't always
//		mav.addObject("spells", spellsRepo.findAll()); //We're adding "spells" to our model and view here so we will be able to reference it from within the HTML page
//		return mav;
//	}
	
	   @PostMapping("/spells")
	   public ResponseEntity<Spells> createSpells(@RequestBody Spells spell){
	       Spells savedSpell = spellsRepo.save(spell);
	       return ResponseEntity.created(URI.create("/spells/" + savedSpell.getName())).body(savedSpell);
	   }
	   @PostMapping("/item")
	   public ResponseEntity<Item> createItem(@RequestBody Item item){
	       Item savedItem = itemRepo.save(item);
	       return ResponseEntity.created(URI.create("/item/" + savedItem.getItemName())).body(savedItem);
	   }
	   @PostMapping("/weapon")
	   public ResponseEntity<Weapon> createWeapon(@RequestBody Weapon weapon){
	       Weapon savedWeapon = weaponRepo.save(weapon);
	       return ResponseEntity.created(URI.create("/weapon/" + savedWeapon.getWeaponName())).body(savedWeapon);
	   }


}
