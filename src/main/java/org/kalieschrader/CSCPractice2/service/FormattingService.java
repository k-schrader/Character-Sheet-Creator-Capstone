package org.kalieschrader.CSCPractice2.service;

import java.util.ArrayList;
import java.util.List;

import org.kalieschrader.CSCPractice2.controller.Page1Controller;
import org.kalieschrader.CSCPractice2.model.Armor;
import org.kalieschrader.CSCPractice2.model.CharacterClass;
import org.kalieschrader.CSCPractice2.model.CharacterRace;
import org.kalieschrader.CSCPractice2.model.CharacterSheet;
import org.kalieschrader.CSCPractice2.model.Item;
import org.kalieschrader.CSCPractice2.model.Spells;
import org.kalieschrader.CSCPractice2.model.Weapon;
import org.kalieschrader.CSCPractice2.repository.SpellsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class FormattingService {

	private String playerName;
	private int modStrength;
	private int modDexterity;
	private int modCon;
	private int modIntelligence;
	private int modWisdom;
	private int modCharisma;
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
	private int toHit1;
	private int toHit2;
	private int spellSlots;
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

	public FormattingService() {
	}

	Logger logger = LoggerFactory.getLogger(FormattingService.class);

	SpellsRepository spellRepo;

	public FormattingService(CharacterSheet charSheet) {
		this.charSheet = charSheet;
		setCharRace(charSheet.getCharRace());
		setCharClass(charSheet.getCharClass());
		setAbilityAndSkillScores(charRace.getAbilityScoreIn(), charSheet.getAbilityScoresAsList(), charClass.getSkills());
		setHitPoints();
		setArmorClass();
		setWeapon1Modifier();
		setWeapon2Modifier();
		setSpellModifiers();
		setHitDie();
		setSpellSlots();
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
		setLanguages();
		setCharRace();
		setCharClass();
		setArmor();
		setCharName();
		setPlayerName();
	}

// Sets ability scores and skill scores given a list of ability score modifiers
	public void setAbilityAndSkillScores(String abilityIncreaseString, List<Integer> rawAbilityScoreList, String skillIncreaseString) {
		List<Integer> abilities = getAbilityScoreModifiers(abilityIncreaseString, rawAbilityScoreList);
		setModStrength(abilities.get(0));
		setModDexterity(abilities.get(1));
		setModCon(abilities.get(2));
		setModIntelligence(abilities.get(3));
		setModWisdom(abilities.get(4));
		setModCharisma(abilities.get(5));
		setSkillScores(skillIncreaseString, abilities);
	}

//Separates string of comma-delimited integers into a list
	public List<Integer> getAsNumberList(String numberString) {
		String[] numberArray = numberString.split(",");
		List<Integer> numberList = new ArrayList<>();
		for (String number : numberArray) {
			numberList.add(Integer.parseInt(number.trim()));
		}
		return numberList;
	}

	// Takes in string of ability score increases and string of raw ability scores,
	// and returns list of ability score modifiers.
	// Each index contains the modifier for an ability score as follows:
	/*
	 * 0: Strength 
	 * 1: Dexterity 
	 * 2: Constitution (Con) 
	 * 3: Intelligence 
	 * 4: Wisdom 
	 * 5: Charisma
	 */
	public List<Integer> getAbilityScoreModifiers(String abilityIncreaseString, List<Integer> rawAbilityScoreList) {
		List<Integer> abilityIncreaseList = getAsNumberList(abilityIncreaseString);
		List<Integer> abilityModifierList = new ArrayList<>();
		for (int i = 0; i < rawAbilityScoreList.size(); i++) {
			int moddedScore = ((rawAbilityScoreList.get(i) + abilityIncreaseList.get(i)) - 10) / 2;
			abilityModifierList.add(i, moddedScore);
		}
		return abilityModifierList;
	}

	// Sets skill scores given a list of ability score modifiers
	public void setSkillScores(String skillIncreaseString, List<Integer> abilityModifierList) {
		List<Integer> skills = getSkillScoreModifiers(skillIncreaseString, abilityModifierList);
		setModAcrobatics(skills.get(0));
		setModAnimalHandling(skills.get(1));
		setModArcana(skills.get(2));
		setModAthletics(skills.get(3));
		setModDeception(skills.get(4));
		setModHistory(skills.get(5));
		setModInsight(skills.get(6));
		setModIntimidation(skills.get(7));
		setModInvestigation(skills.get(8));
		setModMedicine(skills.get(9));
		setModNature(skills.get(10));
		setModPerception(skills.get(11));
		setModPerformance(skills.get(12));
		setModPersuasion(skills.get(13));
		setModReligion(skills.get(14));
		setModSleightOfHand(skills.get(15));
		setModStealth(skills.get(16));
		setModSurvival(skills.get(17));
	}

	// Takes in list of skill score increases and list of ability score modifiers,
	// and adds the relevant modifier to the ability score increase.
	// Skill and modifier for each index listed below:
	/*
	 * 0: Acrobatics (dexterity) 
	 * 1: Animal Handling (wisdom) 
	 * 2: Arcana (intelligence)
	 * 3: Athletics (strength)
	 * 4: Deception (charisma) 
	 * 5: History (intelligence) 
	 * 6: Insight (wisdom) 
	 * 7: Intimidation (charisma) 
	 * 8: Investigation (intelligence)
	 * 9: Medicine (wisdom) 
	 * 10: Nature (intelligence) 
	 * 11: Perception (wisdom) 
	 * 12: Performance (charisma) 
	 * 13: Persuasion (charisma) 
	 * 14: Religion (intelligence)
	 * 15: Sleight of hand (dexterity) 
	 * 16: Stealth (dexterity) 
	 * 17: Survival (wisdom)
	 */
	public List<Integer> getSkillScoreModifiers(String skillIncreaseString, List<Integer> abilityModifierList) {
		List<Integer> skillIncreaseList = getAsNumberList(skillIncreaseString);
		List<Integer> skillModifierList = new ArrayList<>();
		int strength = abilityModifierList.get(0);
		int dexterity = abilityModifierList.get(1);
		int intelligence = abilityModifierList.get(3);
		int wisdom = abilityModifierList.get(4);
		int charisma = abilityModifierList.get(5);
		for (int i = 0; i < skillIncreaseList.size(); i++) {
			int skill = skillIncreaseList.get(i);
			switch (i) {
				case 0, 15, 16 -> skill += dexterity;
				case 1, 6, 9, 11, 17 -> skill += wisdom;
				case 2, 5, 8, 10, 14 -> skill += intelligence;
				case 3 -> skill += strength;
				case 4, 7, 12, 13 -> skill += charisma;
				default -> skill += 0;
			}
			skillModifierList.add(i, skill);
		}
		return skillModifierList;
	}

	public void setHitPoints() {
		hitPoints = charSheet.getCharClass().getHitDie() + modCon;
	}

	public void setArmorClass() {
		armorClass = charSheet.getCharClass().getArmor().getAcBonus() + modDexterity + 10;
	}

	public void setSpellSlots() {
		spellSlots = charSheet.getCharClass().getSpellSlots();
	}

	public void setSpellModifiers() {
		String spellModifier = charSheet.getCharClass().getSpellModifier();
		int spellPlus = 0;
		if (("Intelligence").equals(spellModifier)) {
			spellPlus = modIntelligence;
		} else if (("Wisdom").equals(spellModifier)) {
			spellPlus = modWisdom;
		} else if (("Charisma").equals(spellModifier)) {
			spellPlus = modCharisma;
		}
		spellSaveDC = 10 + spellPlus;
		spellAttack = 2 + spellPlus;
	}

	public void setWeapon1Modifier() {
		String weaponModifier = charSheet.getWeapon1().getSkillMod();
		int weaponPlus = 0;
		if (("Strength").equals(weaponModifier)) {
			weaponPlus = modStrength;
		} else if (("Dexterity").equals(weaponModifier)) {
			weaponPlus = modDexterity;
		}
		toHit1 = weaponPlus;
	}

	public void setWeapon2Modifier() {
		String weaponModifier = charSheet.getWeapon2().getSkillMod();
		int weaponPlus = 0;
		if (("Strength").equals(weaponModifier)) {
			weaponPlus = modStrength;
		} else if (("Dexterity").equals(weaponModifier)) {
			weaponPlus = modDexterity;
		}
		toHit2 = weaponPlus;
	}

	public void setLanguages() {
		this.languages = charSheet.getCharRace().getLang();
	}

	public void setHitDie() {
		this.hitdie = charSheet.getCharClass().getHitDie();
	}

	public void setSpeed() {
		this.speed = charSheet.getCharRace().getSpeed();
	}

	public void setWeapon1() {
		this.weapon1 = charSheet.getWeapon1();
	}

	public void setWeapon2() {
		this.weapon2 = charSheet.getWeapon2();
	}

	public void setItem1() {
		this.item1 = charSheet.getItem1();
	}

	public void setItem2() {
		this.item2 = charSheet.getItem2();
	}

	public void setItem3() {
		this.item3 = charSheet.getItem3();
	}

	public void setSpell1() {
		this.spell1 = charSheet.getSpell1();
	}

	public void setSpell2() {
		this.spell2 = charSheet.getSpell2();
	}

	public void setSpell3() {
		this.spell3 = charSheet.getSpell3();
	}

	public void setSpell4() {
		this.spell4 = charSheet.getSpell4();
	}

	public void setSpell5() {
		this.spell5 = charSheet.getSpell5();
	}

	public void setClassFeature1() {
		this.classFeature1 = charSheet.getCharClass().getClassFeat1();
	}

	public void setClassFeature2() {
		this.classFeature2 = charSheet.getCharClass().getClassFeat2();
	}

	public void setClassFeature3() {
		this.classFeature3 = charSheet.getCharClass().getClassFeat3();
	}

	public void setRacialFeature1() {
		this.racialFeature1 = charSheet.getCharRace().getRaceFeat1();
	}

	public void setRacialFeature2() {
		this.racialFeature2 = charSheet.getCharRace().getRaceFeat2();
	}

	public void setRacialFeature3() {
		this.racialFeature3 = charSheet.getCharRace().getRaceFeat3();
	}

	public void setCharRace() {
		this.charRace = charSheet.getCharRace();
	}

	public void setCharClass() {
		this.charClass = charSheet.getCharClass();
	}

	public void setArmor() {
		this.armor = charSheet.getCharClass().getArmor();
	}

	public void setCharName() {
		this.charName = charSheet.getCharName();
	}

	public void setPlayerName() {
		this.playerName = charSheet.getUsername();
	}

	public void setModStrength(int modStrength) {
		this.modStrength = modStrength;
	}

	public void setModDexterity(int modDexterity) {
		this.modDexterity = modDexterity;
	}

	public void setModCon(int modCon) {
		this.modCon = modCon;
	}

	public void setModIntelligence(int modIntelligence) {
		this.modIntelligence = modIntelligence;
	}

	public void setModWisdom(int modWisdom) {
		this.modWisdom = modWisdom;
	}

	public void setModCharisma(int modCharisma) {
		this.modCharisma = modCharisma;
	}

	public void setModAcrobatics(int modAcrobatics) {
		this.modAcrobatics = modAcrobatics;
	}

	public void setModAnimalHandling(int modAnimalHandling) {
		this.modAnimalHandling = modAnimalHandling;
	}

	public void setModArcana(int modArcana) {
		this.modArcana = modArcana;
	}

	public void setModAthletics(int modAthletics) {
		this.modAthletics = modAthletics;
	}

	public void setModDeception(int modDeception) {
		this.modDeception = modDeception;
	}

	public void setModHistory(int modHistory) {
		this.modHistory = modHistory;
	}

	public void setModInsight(int modInsight) {
		this.modInsight = modInsight;
	}

	public void setModIntimidation(int modIntimidation) {
		this.modIntimidation = modIntimidation;
	}

	public void setModInvestigation(int modInvestigation) {
		this.modInvestigation = modInvestigation;
	}

	public void setModMedicine(int modMedicine) {
		this.modMedicine = modMedicine;
	}

	public void setModNature(int modNature) {
		this.modNature = modNature;
	}

	public void setModPerception(int modPerception) {
		this.modPerception = modPerception;
	}

	public void setModPerformance(int modPerformance) {
		this.modPerformance = modPerformance;
	}

	public void setModPersuasion(int modPersuasion) {
		this.modPersuasion = modPersuasion;
	}

	public void setModReligion(int modReligion) {
		this.modReligion = modReligion;
	}

	public void setModSleightOfHand(int modSleightOfHand) {
		this.modSleightOfHand = modSleightOfHand;
	}

	public void setModStealth(int modStealth) {
		this.modStealth = modStealth;
	}

	public void setModSurvival(int modSurvival) {
		this.modSurvival = modSurvival;
	}

	public void setCharRace(CharacterRace charRace) {
		this.charRace = charRace;
	}

	public void setCharClass(CharacterClass charClass) {
		this.charClass = charClass;
	}

	public String getPlayerName() {
		return playerName;
	}

	public int getToHit1() {
		return toHit1;
	}

	public int getToHit2() {
		return toHit2;
	}

	public int getSpellSlots() {
		return spellSlots;
	}

	public int getModStrength() {
		return modStrength;
	}

	public int getModDexterity() {
		return modDexterity;
	}

	public int getModCon() {
		return modCon;
	}

	public int getModIntelligence() {
		return modIntelligence;
	}

	public int getModWisdom() {
		return modWisdom;
	}

	public int getModCharisma() {
		return modCharisma;
	}

	public int getModAcrobatics() {
		return modAcrobatics;
	}

	public int getModAnimalHandling() {
		return modAnimalHandling;
	}

	public int getModArcana() {
		return modArcana;
	}

	public int getModAthletics() {
		return modAthletics;
	}

	public int getModDeception() {
		return modDeception;
	}

	public int getModHistory() {
		return modHistory;
	}

	public int getModInsight() {
		return modInsight;
	}

	public int getModIntimidation() {
		return modIntimidation;
	}

	public int getModInvestigation() {
		return modInvestigation;
	}

	public int getModMedicine() {
		return modMedicine;
	}

	public int getModNature() {
		return modNature;
	}

	public int getModPerception() {
		return modPerception;
	}

	public int getModPerformance() {
		return modPerformance;
	}

	public int getModPersuasion() {
		return modPersuasion;
	}

	public int getModReligion() {
		return modReligion;
	}

	public int getModSleightOfHand() {
		return modSleightOfHand;
	}

	public int getModStealth() {
		return modStealth;
	}

	public int getModSurvival() {
		return modSurvival;
	}

	public int getHitdie() {
		return hitdie;
	}

	public int getSpeed() {
		return speed;
	}

	public Weapon getWeapon1() {
		return weapon1;
	}

	public Weapon getWeapon2() {
		return weapon2;
	}

	public Item getItem1() {
		return item1;
	}

	public Item getItem2() {
		return item2;
	}

	public Item getItem3() {
		return item3;
	}

	public String getLanguages() {
		return languages;
	}

	public Spells getSpell1() {
		return spell1;
	}

	public Spells getSpell2() {
		return spell2;
	}

	public Spells getSpell3() {
		return spell3;
	}

	public Spells getSpell4() {
		return spell4;
	}

	public Spells getSpell5() {
		return spell5;
	}

	public String getClassFeature1() {
		return classFeature1;
	}

	public String getClassFeature2() {
		return classFeature2;
	}

	public String getClassFeature3() {
		return classFeature3;
	}

	public String getRacialFeature1() {
		return racialFeature1;
	}

	public String getRacialFeature2() {
		return racialFeature2;
	}

	public String getRacialFeature3() {
		return racialFeature3;
	}

	public String getCharName() {
		return charName;
	}

	public CharacterRace getCharRace() {
		return charRace;
	}

	public CharacterClass getCharClass() {
		return charClass;
	}

	public Armor getArmor() {
		return armor;
	}

	public int getHitPoints() {
		return hitPoints;
	}

	public int getArmorClass() {
		return armorClass;
	}

	public int getSpellSaveDC() {
		return spellSaveDC;
	}

	public int getSpellAttack() {
		return spellAttack;
	}

	public CharacterSheet getCharSheet() {
		return charSheet;
	}
}