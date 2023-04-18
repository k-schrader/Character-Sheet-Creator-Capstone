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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

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
	 
	 public FormattingService() {}
	 
	 Logger logger = LoggerFactory.getLogger(FormattingService.class);
	
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
	setLanguages();
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
		 armorClass=charSheet.getCharClass().getArmor().getAcBonus()+modDexterity+10;
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
	 
	 public void setLanguages() {
		 this.languages=charSheet.getCharRace().getLang();
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
		 this.weapon2=charSheet.getCharClass().getWeapon2();
	 }
	 public void setItem1() {
		 this.item1=charSheet.getItem1();
	 }
	 public void setItem2() {
		 this.item2=charSheet.getItem2();
	 }
	 public void setItem3() {
		 this.item3=charSheet.getItem3();
	 }
	 public void setSpell1() {
		 this.spell1=charSheet.getSpell1();
	 }
	 public void setSpell2() {
		 this.spell2=charSheet.getSpell2();
	 }
	 public void setSpell3() {
		 this.spell3=charSheet.getSpell3();
	 }
	 public void setSpell4() {
		 this.spell4=charSheet.getSpell4();
	 }
	 public void setSpell5() {
		 this.spell5=charSheet.getSpell5();
	 }
	 public void setClassFeature1() {
		 this.classFeature1=charSheet.getCharClass().getClassFeat1();
	 }
	 public void setClassFeature2() {
		 this.classFeature2=charSheet.getCharClass().getClassFeat2();
	 }
	 public void setClassFeature3() {
		 this.classFeature3=charSheet.getCharClass().getClassFeat3();
	 }
	 public void setRacialFeature1() {
		 this.racialFeature1=charSheet.getCharRace().getRaceFeat1();
	 }
	 public void setRacialFeature2() {
		 this.racialFeature2=charSheet.getCharRace().getRaceFeat2();
	 }
	 public void setRacialFeature3() {
		 this.racialFeature3=charSheet.getCharRace().getRaceFeat3();
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
		 this.playerName=charSheet.getUsername();
	 }
	public String getPlayerName() {
		return playerName;
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