package org.kalieschrader.CSCPractice2.service;

import java.util.ArrayList;
import java.util.List;

import org.kalieschrader.CSCPractice2.model.Armor;
import org.kalieschrader.CSCPractice2.model.CharacterClass;
import org.kalieschrader.CSCPractice2.model.CharacterRace;
import org.kalieschrader.CSCPractice2.model.CharacterSheet;
import org.kalieschrader.CSCPractice2.model.Item;
import org.kalieschrader.CSCPractice2.model.Spells;
import org.kalieschrader.CSCPractice2.model.Weapon;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Service
public class FormattingService {

	 private String playerName;
//	 private String profBonus;
	 private int modStrength;
	 private int modDexterity;
	 private int modCon;
	 private int modIntelligence;
	 private int modWisdom;
	 private int modCharisma;
	// private List<Integer> skillScores; //list of skill scores 
	 private int modAcrobatics;
	 private int modAnimalHandling;
	 private int modArcana;
	 private int modAthletics;
	 private int modDeception;
	 private int modHistory;
	 private int modInsight;
	 private int modIntimidation;
	 private int modInvestigation;
	 private int modMedicine;
	 private int modNature;
	 private int modPerception;
	 private int modPerformance;
	 private int modPersuasion;
	 private int modReligion;
	 private int modSleightOfHand;
	 private int modStealth;
	 private int modSurvival;
	 private int hitdie;
	 private int speed;
	 private Weapon weapon1;
	 private Weapon weapon2;
	 private Item item1;
	 private Item item2;
	 private Item item3;
	 private String languages;
	 private Spells spell1;
	 private Spells spell2;
	 private Spells spell3;
	 private Spells spell4;
	 private Spells spell5;
	 private String classFeature1;
	 private String classFeature2;
	 private String classFeature3;
	 private String racialFeature1;
	 private String racialFeature2;
	 private String racialFeature3;
	 private String charName;
	 private CharacterRace charRace;
	 private CharacterClass charClass;
	 private Armor armor;
	 private int hitPoints;
	 private int armorClass;
	 private int spellSaveDC;
	 private int spellAttack;
	 private CharacterSheet charSheet;
	
public FormattingService(CharacterSheet charSheet) {
	this.charSheet=charSheet;
	setAbilityScores();
	setSkillScores();
	setHitPoints();
	setArmorClass();
	setSpellModifiers();
	setHitDie();
	setSpeed();
	setWeapon1(); 
	setWeapon2(); 
	setItem1(); 
	setItem2(); 
	setItem3(); 
	setSpell1(); 
	setSpell2(); 
	setSpell3(); 
	setSpell4(); 
	setSpell5(); 
	setClassFeature1(); 
	setClassFeature2();
	setClassFeature3(); 
	setRacialFeature1(); 
	setRacialFeature2();
	setRacialFeature3(); 
	setCharRace();
	setCharClass(); 
	setArmor(); 
	setCharName();
	setPlayerName(); 
}
//logic to calculate skill scores 
	 public void setAbilityScores() {
		 String[] abilityScoreArray = charSheet.getCharRace().getAbilityScoreIn().split(",");
		 List<Integer> abilityScoreList = new ArrayList<Integer>();
		 for (String number : abilityScoreArray) {
		     abilityScoreList.add(Integer.parseInt(number.trim()));
		 }
		 modStrength=((charSheet.getStrength() + abilityScoreList.get(0))-10)/2;
		 modDexterity=((charSheet.getDex() + abilityScoreList.get(1))-10)/2;
		 modCon=((charSheet.getCon() + abilityScoreList.get(2))-10)/2;
		 modIntelligence=((charSheet.getIntelligence() + abilityScoreList.get(3))-10)/2;
		 modWisdom=((charSheet.getWisdom() + abilityScoreList.get(4))-10)/2;
		 modCharisma=((charSheet.getCharisma() + abilityScoreList.get(5))-10)/2;
	 }
//logic to add skill scores/separate delimited list 
	 public void setSkillScores() {
		 String[] skillScoreArray = charSheet.getCharClass().getSkills().split(",");
		 List<Integer> skillScoreList = new ArrayList<Integer>();
		 for (String number : skillScoreArray) {
		     skillScoreList.add(Integer.parseInt(number.trim()));
		 }
		 modAcrobatics=modDexterity + skillScoreList.get(0);
		 modAnimalHandling=modWisdom + skillScoreList.get(1);;
		 modArcana=modIntelligence + skillScoreList.get(2);;
		 modAthletics=modStrength + skillScoreList.get(3);;
		 modDeception=modCharisma + skillScoreList.get(4);;
		 modHistory=modIntelligence + skillScoreList.get(5);;
		 modInsight=modWisdom + skillScoreList.get(6);;
		 modIntimidation=modCharisma + skillScoreList.get(7);;
		 modInvestigation=modIntelligence + skillScoreList.get(8);;
		 modMedicine=modWisdom + skillScoreList.get(9);;
		 modNature=modIntelligence + skillScoreList.get(10);;
		 modPerception=modWisdom + skillScoreList.get(11);;
		 modPerformance=modCharisma + skillScoreList.get(12);;
		 modPersuasion=modCharisma + skillScoreList.get(13);;
		 modReligion=modIntelligence + skillScoreList.get(14);;
		 modSleightOfHand=modDexterity + skillScoreList.get(15);;
		 modStealth=modDexterity + skillScoreList.get(16);;
		 modSurvival=modWisdom + skillScoreList.get(17);;
	 }
	 public void setHitPoints() {
		 hitPoints=charSheet.getCharClass().getHitDie()+modCon;
	 }
	 public void setArmorClass() {
		 armorClass=charSheet.getArmor().getAcBonus()+modDexterity+10;
	 }

	 public void setSpellModifiers() {
		 String spellModifier = charSheet.getCharClass().getSpellModifier();
		 int spellPlus = 0;
		 if(("Intelligence").equals(spellModifier)) {
			 spellPlus=modIntelligence;
		 }else if (("Wisdom").equals(spellModifier)) {
			 spellPlus=modWisdom;
		 }else if (("Charisma").equals(spellModifier)) {
			 spellPlus=modCharisma;
		 }
		 spellSaveDC=10+spellPlus;
		 spellAttack=2+spellPlus;
	 }
	
	 public void setHitDie() {
		 this.hitdie=charSheet.getCharClass().getHitDie();
	 }
	 public void setSpeed() {
		 this.speed=charSheet.getCharRace().getSpeed();
	 }
	 public void setWeapon1() {
		 this.weapon1=charSheet.getCharClass().getWeapon1();
	 }
	 public void setWeapon2() {
		 this.weapon1=charSheet.getCharClass().getWeapon2();
	 }
	 public void setItem1() {
		 this.item1=charSheet.getItem1();
	 }
	 public void setItem2() {
		 this.item1=charSheet.getItem2();
	 }
	 public void setItem3() {
		 this.item1=charSheet.getItem3();
	 }
	 public void setSpell1() {
		 this.spell1=charSheet.getSpell1();
	 }
	 public void setSpell2() {
		 this.spell1=charSheet.getSpell2();
	 }
	 public void setSpell3() {
		 this.spell1=charSheet.getSpell3();
	 }
	 public void setSpell4() {
		 this.spell1=charSheet.getSpell4();
	 }
	 public void setSpell5() {
		 this.spell1=charSheet.getSpell5();
	 }
	 public void setClassFeature1() {
		 this.classFeature1=charSheet.getCharClass().getClassFeat1();
	 }
	 public void setClassFeature2() {
		 this.classFeature1=charSheet.getCharClass().getClassFeat2();
	 }
	 public void setClassFeature3() {
		 this.classFeature1=charSheet.getCharClass().getClassFeat3();
	 }
	 public void setRacialFeature1() {
		 this.racialFeature1=charSheet.getCharRace().getRaceFeat1();
	 }
	 public void setRacialFeature2() {
		 this.racialFeature1=charSheet.getCharRace().getRaceFeat2();
	 }
	 public void setRacialFeature3() {
		 this.racialFeature1=charSheet.getCharRace().getRaceFeat3();
	 }
	 public void setCharRace() {
		 this.charRace=charSheet.getCharRace();
	 }
	 public void setCharClass() {
		 this.charClass=charSheet.getCharClass();
	 }
	 public void setArmor() {
		 this.armor=charSheet.getCharClass().getArmor();
	 }
	 public void setCharName() {
		 this.charName=charSheet.getCharName();
	 }
	 public void setPlayerName() {
		 this.playerName=playerName;
	 }
}