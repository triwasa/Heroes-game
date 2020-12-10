package pl.sdk.hero;

import pl.sdk.creatures.EconomyCreature;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class EconomyHero {

    public enum Fraction {
        NECROPOLIS;
    }
    private final Fraction fraction;

    private final List<EconomyCreature> creatureList;
    private int gold;
    public EconomyHero(Fraction aFraction, int aGold) {
        fraction = aFraction;
        gold = aGold;
        creatureList = new ArrayList<>();
    }

    void addCreature(EconomyCreature aCreature){
        if (creatureList.size()>=7){
            throw new IllegalStateException("Hero has not empty slot for creature");
        }
        creatureList.add(aCreature);
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

    void substractGold(int aAmount){
        if (aAmount > gold){
            throw new IllegalStateException("Hero has not enought money");
        }
        gold -= aAmount;
    }
}
