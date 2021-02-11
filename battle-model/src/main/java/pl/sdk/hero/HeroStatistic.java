package pl.sdk.hero;

public class HeroStatistic implements HeroClassStatisticIf {

    private int attack;
    private int defence;
    private int power;
    private int knowledge;
    private int luck;
    private int morale;


    HeroStatistic(int aAttack, int aDefence, int aPower, int aKnowledge, int aLuck, int aMorale) {
        attack = aAttack;
        defence = aDefence;
        power = aPower;
        knowledge = aKnowledge;
        luck = aLuck;
        morale = aMorale;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefence() {
        return defence;
    }

    public int getPower() {
        return power;
    }

    public int getKnowledge() {
        return knowledge;
    }

    public int getLuck() {
        return luck;
    }

    public int getMorale() {
        return morale;
    }
}
