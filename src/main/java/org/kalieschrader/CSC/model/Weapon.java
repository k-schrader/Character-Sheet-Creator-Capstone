package org.kalieschrader.CSC.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

//Model class for Weapon
//It is mapped to the table with annotations and contains all the column values, constructors, and getters/setters
//It has the overridden Hashcode, Equals, and toString methods for testing 
@Entity
public class Weapon {

	@Id
	private String weaponName;
	private String skillMod;
	private int damageDie;
	private String weaponRange;
	@Column(length = 800)
	private String details;

	public Weapon(String weaponName, String skillMod, int damageDie, String weaponRange, String details) {
		super();
		this.weaponName = weaponName;
		this.skillMod = skillMod;
		this.damageDie = damageDie;
		this.weaponRange = weaponRange;
		this.details = details;
	}

	public Weapon() {
	}

	public String getWeaponName() {
		return weaponName;
	}

	public void setWeaponName(String weaponName) {
		this.weaponName = weaponName;
	}

	public String getSkillMod() {
		return skillMod;
	}

	public void setSkillMod(String skillMod) {
		this.skillMod = skillMod;
	}

	public int getDamageDie() {
		return damageDie;
	}

	public void setDamageDie(int damageDie) {
		this.damageDie = damageDie;
	}

	public String getWeaponRange() {
		return weaponRange;
	}

	public void setWeaponRange(String weaponRange) {
		this.weaponRange = weaponRange;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	@Override
	public int hashCode() {
		return Objects.hash(damageDie, details, skillMod, weaponName, weaponRange);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Weapon other = (Weapon) obj;
		return damageDie == other.damageDie && Objects.equals(details, other.details)
				&& Objects.equals(skillMod, other.skillMod) && Objects.equals(weaponName, other.weaponName)
				&& Objects.equals(weaponRange, other.weaponRange);
	}

	@Override
	public String toString() {
		return "Weapon [weaponName=" + weaponName + ", skillMod=" + skillMod + ", damageDie=" + damageDie
				+ ", weaponRange=" + weaponRange + ", details=" + details + "]";
	}

}