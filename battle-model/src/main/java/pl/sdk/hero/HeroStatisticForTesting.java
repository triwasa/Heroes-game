package pl.sdk.hero;

import pl.sdk.heroClass.HeroClassStatisticIf;

public class HeroStatisticForTesting implements HeroClassStatisticIf {

    private Integer attack;
    private Integer defence;
    private Integer power;
    private Integer knowledge;

    HeroStatisticForTesting(int aAttack, int aDefence, int aPower, int aKnowledge) {
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
