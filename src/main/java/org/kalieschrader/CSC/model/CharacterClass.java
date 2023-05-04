package org.kalieschrader.CSC.model;

import java.util.Objects;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

//Model class for Class
//It is mapped to the table with annotations and contains all the column values, constructors, and getters/setters
//It has the overridden Hashcode, Equals, and toString methods for testing 
@Entity
public class CharacterClass {

	@Id
	private String name;
	private int hitDie;
	private String skills;
	@ManyToOne // Many rows in CharacterClass correspond with one row in Weapon
	Weapon weapon1;
	@ManyToOne
	Weapon weapon2;
	@ManyToOne
	Weapon weapon3;
	@ManyToOne
	Armor armor;
	@Column(length = 800)
	private String details;
	private int numCantrips;
	private int numSpells;
	@Column(length = 800)
	private String classFeat1;
	@Column(length = 800)
	private String classFeat2;
	@Column(length = 800)
	private String classFeat3;
	private int spellSlots;
	private String spellModifier;

	public CharacterClass(String name, int hitDie, String skills, Weapon weapon1, Weapon weapon2, Weapon weapon3,
			Armor armor, String details, int numCantrips, int numSpells, String classFeat1, String classFeat2,
			String classFeat3, int spellSlots, String spellModifier) {
		super();
		this.name = name;
		this.hitDie = hitDie;
		this.skills = skills;
		this.weapon1 = weapon1;
		this.weapon2 = weapon2;
		this.weapon3 = weapon3;
		this.armor = armor;
		this.details = details;
		this.numCantrips = numCantrips;
		this.numSpells = numSpells;
		this.classFeat1 = classFeat1;
		this.classFeat2 = classFeat2;
		this.classFeat3 = classFeat3;
		this.spellSlots = spellSlots;
		this.spellModifier = spellModifier;
	}

	public CharacterClass() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHitDie() {
		return hitDie;
	}

	public void setHitDie(int hitDie) {
		this.hitDie = hitDie;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
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

	public Weapon getWeapon3() {
		return weapon3;
	}

	public void setWeapon3(Weapon weapon3) {
		this.weapon3 = weapon3;
	}

	public Armor getArmor() {
		return armor;
	}

	public void setArmor(Armor armor) {
		this.armor = armor;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public int getNumCantrips() {
		return numCantrips;
	}

	public void setNumCantrips(int numCantrips) {
		this.numCantrips = numCantrips;
	}

	public int getNumSpells() {
		return numSpells;
	}

	public void setNumSpells(int numSpells) {
		this.numSpells = numSpells;
	}

	public String getClassFeat1() {
		return classFeat1;
	}

	public void setClassFeat1(String classFeat1) {
		this.classFeat1 = classFeat1;
	}

	public String getClassFeat2() {
		return classFeat2;
	}

	public void setClassFeat2(String classFeat2) {
		this.classFeat2 = classFeat2;
	}

	public String getClassFeat3() {
		return classFeat3;
	}

	public void setClassFeat3(String classFeat3) {
		this.classFeat3 = classFeat3;
	}

	public int getSpellSlots() {
		return spellSlots;
	}

	public void setSpellSlots(int spellSlots) {
		this.spellSlots = spellSlots;
	}

	public String getSpellModifier() {
		return spellModifier;
	}

	public void setSpellModifier(String spellModifier) {
		this.spellModifier = spellModifier;
	}

	@Override
	public int hashCode() {
		return Objects.hash(armor, classFeat1, classFeat2, classFeat3, details, hitDie, name, numCantrips, numSpells,
				skills, spellModifier, spellSlots, weapon1, weapon2, weapon3);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CharacterClass other = (CharacterClass) obj;
		return Objects.equals(armor, other.armor) && Objects.equals(classFeat1, other.classFeat1)
				&& Objects.equals(classFeat2, other.classFeat2) && Objects.equals(classFeat3, other.classFeat3)
				&& Objects.equals(details, other.details) && hitDie == other.hitDie && Objects.equals(name, other.name)
				&& numCantrips == other.numCantrips && numSpells == other.numSpells
				&& Objects.equals(skills, other.skills) && Objects.equals(spellModifier, other.spellModifier)
				&& spellSlots == other.spellSlots && Objects.equals(weapon1, other.weapon1)
				&& Objects.equals(weapon2, other.weapon2) && Objects.equals(weapon3, other.weapon3);
	}

	@Override
	public String toString() {
		return "CharacterClass [name=" + name + ", hitDie=" + hitDie + ", skills=" + skills + ", weapon1=" + weapon1
				+ ", weapon2=" + weapon2 + ", weapon3=" + weapon3 + ", armor=" + armor + ", details=" + details
				+ ", numCantrips=" + numCantrips + ", numSpells=" + numSpells + ", classFeat1=" + classFeat1
				+ ", classFeat2=" + classFeat2 + ", classFeat3=" + classFeat3 + ", spellSlots=" + spellSlots
				+ ", spellModifier=" + spellModifier + "]";
	}

}