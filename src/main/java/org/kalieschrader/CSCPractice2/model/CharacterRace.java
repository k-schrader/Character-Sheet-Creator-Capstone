package org.kalieschrader.CSCPractice2.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Race")
public class CharacterRace {

	@Id
	private String raceName;
	private String abilityScoreIn;
	private String raceFeat1;
	private String raceFeat2;
	private String raceFeat3;
	private String lang;
	private boolean darkVision;
	private String details;
	private int speed;

	public CharacterRace(String raceName, String abilityScoreIn, String raceFeat1, String raceFeat2, String raceFeat3,
			String lang, boolean darkVision, String details, int speed) {
		super();
		this.raceName = raceName;
		this.abilityScoreIn = abilityScoreIn;
		this.raceFeat1 = raceFeat1;
		this.raceFeat2 = raceFeat2;
		this.raceFeat3 = raceFeat3;
		this.lang = lang;
		this.darkVision = darkVision;
		this.details = details;
		this.speed = speed;
	}
	public CharacterRace() {}
	public String getRaceName() {
		return raceName;
	}
	public void setRaceName(String raceName) {
		this.raceName = raceName;
	}
	public String getAbilityScoreIn() {
		return abilityScoreIn;
	}
	public void setAbilityScoreIn(String abilityScoreIn) {
		this.abilityScoreIn = abilityScoreIn;
	}
	public String getRaceFeat1() {
		return raceFeat1;
	}
	public void setRaceFeat1(String raceFeat1) {
		this.raceFeat1 = raceFeat1;
	}
	public String getRaceFeat2() {
		return raceFeat2;
	}
	public void setRaceFeat2(String raceFeat2) {
		this.raceFeat2 = raceFeat2;
	}
	public String getRaceFeat3() {
		return raceFeat3;
	}
	public void setRaceFeat3(String raceFeat3) {
		this.raceFeat3 = raceFeat3;
	}
	public String getLang() {
		return lang;
	}
	public void setLang(String lang) {
		this.lang = lang;
	}
	public boolean isDarkVision() {
		return darkVision;
	}
	public void setDarkVision(boolean darkVision) {
		this.darkVision = darkVision;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	@Override
	public int hashCode() {
		return Objects.hash(abilityScoreIn, darkVision, details, lang, raceFeat1, raceFeat2, raceFeat3, raceName,
				speed);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CharacterRace other = (CharacterRace) obj;
		return Objects.equals(abilityScoreIn, other.abilityScoreIn) && darkVision == other.darkVision
				&& Objects.equals(details, other.details) && Objects.equals(lang, other.lang)
				&& Objects.equals(raceFeat1, other.raceFeat1) && Objects.equals(raceFeat2, other.raceFeat2)
				&& Objects.equals(raceFeat3, other.raceFeat3) && Objects.equals(raceName, other.raceName)
				&& speed == other.speed;
	}
	@Override
	public String toString() {
		return "CharacterRace [raceName=" + raceName + ", abilityScoreIn=" + abilityScoreIn + ", raceFeat1=" + raceFeat1
				+ ", raceFeat2=" + raceFeat2 + ", raceFeat3=" + raceFeat3 + ", lang=" + lang + ", darkVision="
				+ darkVision + ", details=" + details + ", speed=" + speed + "]";
	}
	
}