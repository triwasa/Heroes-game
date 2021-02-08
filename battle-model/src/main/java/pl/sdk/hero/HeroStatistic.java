package pl.sdk.hero;

public class HeroStatistic implements HeroClassStatisticIf {

    private Integer attack;
    private Integer defence;
    private Integer power;
    private Integer knowledge;

    HeroStatistic(int aAttack, int aDefence, int aPower, int aKnowledge) {
        attack = aAttack;
        defence = aDefence;
        power = aPower;
        knowledge = aKnowledge;
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

}
