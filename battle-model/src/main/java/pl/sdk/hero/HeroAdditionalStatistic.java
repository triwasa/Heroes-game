package pl.sdk.hero;

public class HeroAdditionalStatistic implements HeroAdditionalStatisticIf {
    private Integer attack;
    private Integer defence;
    private Integer power;
    private Integer knowledge;

    HeroAdditionalStatistic(int aAttack, int aDefence, int aPower, int aKnowledge) {
        attack = aAttack;
        defence = aDefence;
        power = aPower;
        knowledge = aKnowledge;
    }

    HeroAdditionalStatistic(HeroClassStatisticIf stats) {
        attack = stats.getAttack();
        defence = stats.getDefence();
        power = stats.getPower();
        knowledge = stats.getKnowledge();
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

    public void increaseStats(HeroClassStatisticIf x) {
        attack += x.getAttack();
        defence += x.getDefence();
        power += x.getPower();
        knowledge += x.getKnowledge();
    }
}
