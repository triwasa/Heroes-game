package pl.sdk.hero;

public class HeroAdditionalStatistic implements HeroAdditionalStatisticIf {
    private int attack;
    private int defence;
    private int power;
    private int knowledge;
    private int luck;
    private int morale;


    HeroAdditionalStatistic(int aAttack, int aDefence, int aPower, int aKnowledge, int aLuck, int aMorale) {
        attack = aAttack;
        defence = aDefence;
        power = aPower;
        knowledge = aKnowledge;
        luck = aLuck;
        morale = aMorale;
    }

    HeroAdditionalStatistic(HeroClassStatisticIf stats) {
        attack = stats.getAttack();
        defence = stats.getDefence();
        power = stats.getPower();
        knowledge = stats.getKnowledge();
        luck = stats.getLuck();
        morale = stats.getMorale();
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

    public void increaseStats(HeroClassStatisticIf x) {
        attack += x.getAttack();
        defence += x.getDefence();
        power += x.getPower();
        knowledge += x.getKnowledge();
        luck += x.getLuck();
        morale += x.getMorale();
    }
}
