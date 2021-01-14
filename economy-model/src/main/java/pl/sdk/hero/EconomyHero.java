package pl.sdk.hero;

import pl.sdk.artifacts.Artifact;
import pl.sdk.artifacts.EconomyArtifact;
import pl.sdk.creatures.EconomyCreature;
import pl.sdk.artifacts.HeroEquipment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EconomyHero {



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
    }

    void addCreature(EconomyCreature aCreature){
        if (creatureList.size()>=7){
            throw new IllegalStateException("Hero has not empty slot for creature");
        }
        creatureList.add(aCreature);
    }

    void addArtifact(Artifact aArtifact){
        heroEquipment.equip(aArtifact);
    }

    public void addSkill(EconomySklill aEconomySklill) {

        if (skillList.containsKey(aEconomySklill.getCoreName())){
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

    public HashMap<String, Artifact> getArtifacts() {
        return heroEquipment.getEquipment();
    }



    void substractGold(int aAmount){
        if (aAmount > gold){
            throw new IllegalStateException("Hero has not enought money");
        }
        gold -= aAmount;
    }
}
