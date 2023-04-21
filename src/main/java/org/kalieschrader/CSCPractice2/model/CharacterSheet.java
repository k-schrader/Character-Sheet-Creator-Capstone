package org.kalieschrader.CSCPractice2.model;


import java.util.Objects;

import org.kalieschrader.CSCPractice2.repository.CharacterSheetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
public class CharacterSheet {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Integer charId;
//TODO link userEmail to characterSheet table 
private String username;
private String charName;
private int hitPoints;
private int armorClass;
private String spellSaveDC;
private String spellAttack;
private int strength;
private int con;
private int dex;
private int intelligence;
private int wisdom;
private int charisma;



public CharacterSheet(Integer charId, String username, String charName, int hitPoints, int armorClass,
			int strength, int con, int dex, int intelligence, int wisdom,
			int charisma, CharacterRace charRace, CharacterClass charClass, Weapon weapon1, Weapon weapon2,
			Item item1, Item item2, Item item3, Spells spell1, Spells spell2, Spells spell3, Spells spell4,
			Spells spell5) {
		super();
		this.charId = charId;
		setUsername();
		this.charName = charName;
		this.hitPoints = hitPoints;
		this.armorClass = armorClass;
		this.strength = strength;
		this.con = con;
		this.dex = dex;
		this.intelligence = intelligence;
		this.wisdom = wisdom;
		this.charisma = charisma;
		this.charRace = charRace;
		this.charClass = charClass;
		this.weapon1 = weapon1;
		this.weapon2 = weapon2;
		this.item1 = item1;
		this.item2 = item2;
		this.item3 = item3;
		this.spell1 = spell1;
		this.spell2 = spell2;
		this.spell3 = spell3;
		this.spell4 = spell4;
		this.spell5 = spell5;
	}
public CharacterSheet() {
}
@ManyToOne
CharacterRace charRace;
@ManyToOne
CharacterClass charClass;
@ManyToOne
Weapon weapon1;
@ManyToOne
Weapon weapon2;
@ManyToOne
Item item1;
@ManyToOne
Item item2;
@ManyToOne
Item item3;
@ManyToOne
Spells spell1;
@ManyToOne
Spells spell2;
@ManyToOne
Spells spell3;
@ManyToOne
Spells spell4;
@ManyToOne
Spells spell5;


public Integer getCharId() {
	return charId;
}
public void setCharId(Integer charId) {
	this.charId = charId;
}
public String getUsername() {
	return username;
}
public void setUsername() {
	User user = new User();
	this.username = user.getEmail();
}
public String getCharName() {
	return charName;
}
public void setCharName(String charName) {
	this.charName = charName;
}
public int getHitPoints() {
	return hitPoints;
}
public void setHitPoints(int hitPoints) {
	this.hitPoints = hitPoints;
}
public int getArmorClass() {
	return armorClass;
}
public void setArmorClass(int armorClass) {
	this.armorClass = armorClass;
}
public String getSpellSaveDC() {
	return spellSaveDC;
}
public void setSpellSaveDC(String spellSaveDC) {
	this.spellSaveDC = spellSaveDC;
}
public String getSpellAttack() {
	return spellAttack;
}
public void setSpellAttack(String spellAttack) {
	this.spellAttack = spellAttack;
}
public int getStrength() {
	return strength;
}
public void setStrength(int strength) {
	this.strength = strength;
}
public int getCon() {
	return con;
}
public void setCon(int con) {
	this.con = con;
}
public int getDex() {
	return dex;
}
public void setDex(int dex) {
	this.dex = dex;
}
public int getIntelligence() {
	return intelligence;
}
public void setIntelligence(int intelligence) {
	this.intelligence = intelligence;
}
public int getWisdom() {
	return wisdom;
}
public void setWisdom(int wisdom) {
	this.wisdom = wisdom;
}
public int getCharisma() {
	return charisma;
}
public void setCharisma(int charisma) {
	this.charisma = charisma;
}
public CharacterRace getCharRace() {
	return charRace;
}
public void setCharRace(CharacterRace charRace) {
	this.charRace = charRace;
}
public CharacterClass getCharClass() {
	return charClass;
}
public void setCharClass(CharacterClass charClass) {
	this.charClass = charClass;
}
public Weapon getWeapon1() {
	return weapon1;
}
public void setWeapon1(Weapon weapon1) {
	this.weapon1 = weapon1;
}
public Weapon getWeapon2() {
	return weapon2;
}
public void setWeapon2(Weapon weapon2) {
	this.weapon2 = weapon2;
}

public Item getItem1() {
	return item1;
}
public void setItem1(Item item1) {
	this.item1 = item1;
}
public Item getItem2() {
	return item2;
}
public void setItem2(Item item2) {
	this.item2 = item2;
}
public Item getItem3() {
	return item3;
}
public void setItem3(Item item3) {
	this.item3 = item3;
}
public Spells getSpell1() {
	return spell1;
}
public void setSpell1(Spells spell1) {
	this.spell1 = spell1;
}
public Spells getSpell2() {
	return spell2;
}
public void setSpell2(Spells spell2) {
	this.spell2 = spell2;
}
public Spells getSpell3() {
	return spell3;
}
public void setSpell3(Spells spell3) {
	this.spell3 = spell3;
}
public Spells getSpell4() {
	return spell4;
}
public void setSpell4(Spells spell4) {
	this.spell4 = spell4;
}
public Spells getSpell5() {
	return spell5;
}
public void setSpell5(Spells spell5) {
	this.spell5 = spell5;
}
@Override
public int hashCode() {
	return Objects.hash(armorClass, charClass, charId, charName, charRace, charisma, con, dex, hitPoints,
			intelligence, item1, item2, item3, spell1, spell2, spell3, spell4, spell5,
			strength, username, weapon1, weapon2, wisdom);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	CharacterSheet other = (CharacterSheet) obj;
	return  Objects.equals(charClass, other.charClass) && Objects.equals(charId, other.charId)
			&& Objects.equals(charName, other.charName) && Objects.equals(charRace, other.charRace)
			&& charisma == other.charisma && con == other.con && dex == other.dex && hitPoints == other.hitPoints
			&& intelligence == other.intelligence && Objects.equals(item1, other.item1)
			&& Objects.equals(item2, other.item2) && Objects.equals(item3, other.item3)
			&& Objects.equals(spell1, other.spell1) && Objects.equals(spell2, other.spell2)
			&& Objects.equals(spell3, other.spell3) && Objects.equals(spell4, other.spell4)
			&& Objects.equals(spell5, other.spell5) && strength == other.strength
			&& Objects.equals(username, other.username) && Objects.equals(weapon1, other.weapon1)
			&& Objects.equals(weapon2, other.weapon2) && wisdom == other.wisdom;
}
@Override
public String toString() {
	return "CharacterSheet [charId=" + charId + ", username=" + username + ", charName=" + charName + ", hitPoints="
			+ hitPoints + ", armorClass=" + armorClass + ", spellSaveDC=" + spellSaveDC + ", spellAttack=" + spellAttack
			+ ", strength=" + strength + ", con=" + con + ", dex=" + dex + ", intelligence=" + intelligence
			+ ", wisdom=" + wisdom + ", charisma=" + charisma + ", charRace=" + charRace + ", charClass=" + charClass
			+ ", weapon1=" + weapon1 + ", weapon2=" + weapon2 + ",  item1=" + item1 + ", item2="
			+ item2 + ", item3=" + item3 + ", spell1=" + spell1 + ", spell2=" + spell2 + ", spell3=" + spell3
			+ ", spell4=" + spell4 + ", spell5=" + spell5 + "]";
}

    }




