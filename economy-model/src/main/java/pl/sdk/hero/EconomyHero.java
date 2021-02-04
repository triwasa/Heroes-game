package pl.sdk.hero;

import pl.sdk.artifacts.EconomyArtifact;
import pl.sdk.creatures.EconomyCreature;
import pl.sdk.artifacts.HeroEquipment;
import pl.sdk.skills.EconomySkill;

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

    public enum Fraction {
        NECROPOLIS;
    }
    private final Fraction fraction;
    private final List<EconomyCreature> creatureList;
    private final HeroEquipment heroEquipment;
    private final HashMap<EconomySkill,String> skillList;
    private int gold;
    public EconomyHero(Fraction aFraction, int aGold) {
        fraction = aFraction;
        gold = aGold;
        creatureList = new ArrayList<>();
        heroEquipment = new HeroEquipment();
        skillList = new HashMap<>();
    }

    public Set<EconomySkill> getSkills() {
        return skillList.keySet();
    }

    void addCreature(EconomyCreature aCreature){
        if (creatureList.size()>=7){
            throw new IllegalStateException("Hero has not empty slot for creature");
        }
        creatureList.add(aCreature);
    }

//    void addArtifact(Artifact aArtifact){
//        heroEquipment.equip(aArtifact);
//    }

    public void addSkill(EconomySkill aEconomySklill) {

        if (skillList.containsKey(aEconomySklill)){
            throw new IllegalStateException("hero already has the item");
        }
        skillList.put(aEconomySklill,aEconomySklill.getName());
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

    public HashMap<String, EconomyArtifact> getArtifacts() {
        return null;
    }



    void substractGold(int aAmount){
        if (aAmount > gold){
            throw new IllegalStateException("Hero has not enought money");
        }
        gold -= aAmount;
    }
}
