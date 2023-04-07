package org.kalieschrader.CSCPractice2.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CharacterSheet {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int charId;
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

@ManyToOne
CharacterRace charRace;
@ManyToOne
CharacterClass charClass;
@ManyToOne
Weapon weapon1;
@ManyToOne
Weapon weapon2;
@ManyToOne
Armor armor;
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

}