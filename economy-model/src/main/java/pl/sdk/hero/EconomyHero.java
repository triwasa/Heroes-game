package pl.sdk.hero;

import pl.sdk.artifacts.EconomyArtifact;
import pl.sdk.creatures.EconomyCreature;
import pl.sdk.artifacts.HeroEquipment;
import pl.sdk.skills.EconomySkill;
import pl.sdk.spell.EconomySpell;
import pl.sdk.skills.EconomySkillSet;

import java.util.*;

public class EconomyHero {




    public int getAttack() {
        return 0;
    }

    public int getDefense() {
        return 0;
    }

    public int getSpellPower() {
        return 0;
    }

    public int getKnowledge() {
        return 0;
    }

    public int getLuck() {
        return 0;
    }

    public int getMorale() {
        return 0;
    }


    private final String heroName;
    private final List<EconomyCreature> creatureList;
    private final EconomySkillSet skillList;
    private final List<EconomySpell> spellList;
    private final HeroEquipment heroEquipment;
    private int gold;

    public EconomyHero(String aHeroName, int aGold) {
        heroName = aHeroName;
        gold = aGold;
        creatureList = new ArrayList<>();
        heroEquipment = new HeroEquipment();
        spellList = new ArrayList<>();
        skillList = new EconomySkillSet();
    }

    public String getClassName() {
        return heroName;
    }

    void addCreature(EconomyCreature aCreature){
        if (creatureList.size()>=7){
            throw new IllegalStateException("Hero has not empty slot for creature");
        }
        creatureList.add(aCreature);
    }

    void addArtifact(EconomyArtifact aArtifact){
        heroEquipment.equip(aArtifact);
    }

    public void addSkill(EconomySkill aSklill) {
        if(skillList.contains(aSklill)) {
            throw new IllegalStateException("hero already has the skill");
        }
        skillList.addSkill(aSklill);
    }

    public void addSpell(EconomySpell aSpell){
        if (spellList.contains(aSpell)){
            throw new IllegalStateException("hero already has the spell");
        }
        spellList.add(aSpell);
    }

    public int getGold() {
        return gold;
    }

    public void addGold(int aAmount){
        gold += aAmount;
    }

    public List<EconomyCreature> getCreatures() {
        return List.copyOf(creatureList);
    }

    public List<EconomyArtifact> getArtifacts() {
        return heroEquipment.getArtifacts();
    }

    public HashSet<EconomySkill> getSkillList() {
        return skillList.getSkillSet();
    }

    public List<EconomySpell> getSpell() {return List.copyOf(spellList);}

    void substractGold(int aAmount){
        if (aAmount > gold){
            throw new IllegalStateException("Hero has not enought money");
        }
        gold -= aAmount;
    }
}
