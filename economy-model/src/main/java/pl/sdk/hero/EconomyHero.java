package pl.sdk.hero;

import pl.sdk.artifacts.EconomyArtifact;
import pl.sdk.creatures.EconomyCreature;
import pl.sdk.artifacts.HeroEquipment;
import pl.sdk.skills.EconomySkill;
import pl.sdk.spell.EconomySpell;
import pl.sdk.skills.EconomySkillSet;

import java.util.*;

public class EconomyHero {

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

    @Override
    public String toString() {
        return heroName;
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

    public List<EconomySkill> getSkillList() {
        return new ArrayList<EconomySkill>(skillList.getSkillSet());
    }

    public List<EconomySpell> getSpell() {return List.copyOf(spellList);}

    void substractGold(int aAmount){
        if (aAmount > gold){
            throw new IllegalStateException("Hero has not enought money");
        }
        gold -= aAmount;
    }
}
