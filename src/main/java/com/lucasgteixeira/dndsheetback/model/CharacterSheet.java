package com.lucasgteixeira.dndsheetback.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class CharacterSheet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String classname;
    private String race;
    private int level;
    private int strength;
    private int dexterity;
    private int constitution;
    private int wisdom;
    private int intelligence;
    private int charisma;
    private int modStrength;
    private int modDexterity;
    private int modConstitution;
    private int modWisdom;
    private int modIntelligence;
    private int modCharisma;
    private boolean inspiration;
    private int proficiencyBonus;
    private int armorClass;
    private int initiative;
    private int speed;
    private int currentHP;
    private int maxHP;
    private int tempHP;
    private String hitDice;
    private boolean stStrength;
    private boolean stDexterity;
    private boolean stConstitution;
    private boolean stWisdom;
    private boolean stIntelligence;
    private boolean stCharisma;
    private int stStrengthBonus;
    private int stDexterityBonus;
    private int stConstitutionBonus;
    private int stWisdomBonus;
    private int stIntelligenceBonus;
    private int stCharismaBonus;
    private boolean skillAcrobatics;
    private boolean skillAnimalHandling;
    private boolean skillArcana;
    private boolean skillAthletics;
    private boolean skillDeception;
    private boolean skillHistory;
    private boolean skillInsight;
    private boolean skillIntimidation;
    private boolean skillInvestigation;
    private boolean skillMedicine;
    private boolean skillNature;
    private boolean skillPerception;
    private boolean skillPerformance;
    private boolean skillPersuasion;
    private boolean skillReligion;
    private boolean skillSleightOfHand;
    private boolean skillStealth;
    private boolean skillSurvival;
    private int passiveWisdom;
    private String equipment;
    private int copperPieces;
    private int silverPieces;
    private int emeraldPieces;
    private int goldPieces;
    private int platinumPieces;
}
