package org.kalieschrader.CSC.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Armor {

	@Id
	private String armorName;
	private int acBonus;
	@Column(length = 800)
	private String details;

	public Armor(String armorName, int acBonus, String details) {
		super();
		this.armorName = armorName;
		this.acBonus = acBonus;
		this.details = details;
	}

	public Armor() {
	}

	public String getArmorName() {
		return armorName;
	}

	public void setArmorName(String armorName) {
		this.armorName = armorName;
	}

	public int getAcBonus() {
		return acBonus;
	}

	public void setAcBonus(int acBonus) {
		this.acBonus = acBonus;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	@Override
	public int hashCode() {
		return Objects.hash(acBonus, armorName, details);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Armor other = (Armor) obj;
		return acBonus == other.acBonus && Objects.equals(armorName, other.armorName)
				&& Objects.equals(details, other.details);
	}

	@Override
	public String toString() {
		return "Armor [armorName=" + armorName + ", acBonus=" + acBonus + ", details=" + details + "]";
	}

	public Armor orElseThrow(Object object) {
		return null;
	}
	
}
