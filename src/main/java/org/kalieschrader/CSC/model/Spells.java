package org.kalieschrader.CSC.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Spells {

@Id
private String name;
private String castingClasses;
private int castingLevel;
private String castingTime;
private String castingRange;
private String duration;
private boolean concentraion;
@Column(length = 1000)
private String details;

public Spells(String name, String castingClasses, int castingLevel, String castingTime, String castingRange,
		String duration, boolean concentraion, String details) {
	super();
	this.name = name;
	this.castingClasses = castingClasses;
	this.castingLevel = castingLevel;
	this.castingTime = castingTime;
	this.castingRange = castingRange;
	this.duration = duration;
	this.concentraion = concentraion;
	this.details = details;
}
public Spells() {}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getCastingClasses() {
	return castingClasses;
}
public void setCastingClasses(String castingClasses) {
	this.castingClasses = castingClasses;
}
public int getCastingLevel() {
	return castingLevel;
}
public void setCastingLevel(int castingLevel) {
	this.castingLevel = castingLevel;
}
public String getCastingTime() {
	return castingTime;
}
public void setCastingTime(String castingTime) {
	this.castingTime = castingTime;
}
public String getCastingRange() {
	return castingRange;
}
public void setCastingRange(String castingRange) {
	this.castingRange = castingRange;
}
public String getDuration() {
	return duration;
}
public void setDuration(String duration) {
	this.duration = duration;
}
public boolean isConcentraion() {
	return concentraion;
}
public void setConcentraion(boolean concentraion) {
	this.concentraion = concentraion;
}
public String getDetails() {
	return details;
}
public void setDetails(String details) {
	this.details = details;
}
@Override
public int hashCode() {
	return Objects.hash(castingClasses, castingLevel, castingRange, castingTime, concentraion, details, duration, name);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Spells other = (Spells) obj;
	return Objects.equals(castingClasses, other.castingClasses) && castingLevel == other.castingLevel
			&& Objects.equals(castingRange, other.castingRange) && Objects.equals(castingTime, other.castingTime)
			&& concentraion == other.concentraion && Objects.equals(details, other.details)
			&& Objects.equals(duration, other.duration) && Objects.equals(name, other.name);
}
@Override
public String toString() {
	return "Spells [name=" + name + ", castingClasses=" + castingClasses + ", castingLevel=" + castingLevel
			+ ", castingTime=" + castingTime + ", castingRange=" + castingRange + ", duration=" + duration
			+ ", concentraion=" + concentraion + ", details=" + details + "]";
}

}