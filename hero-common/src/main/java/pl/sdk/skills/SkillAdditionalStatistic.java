package pl.sdk.skills;
import pl.sdk.hero.HeroClassStatisticIf;

enum SkillAdditionalStatistic  implements HeroClassStatisticIf{

    LUCK1(0, 0, 0, 0, 1, 0),
    LUCK2(0, 0, 0, 0, 2, 0),
    LUCK3(0, 0, 0, 0, 3, 0),
    LEADERSHIP1(0, 0, 0, 0, 0, 1),
    LEADERSHIP2(0, 0, 0, 0, 0, 2),
    LEADERSHIP3(0, 0, 0, 0, 0, 3);


    private final int attack;
    private final int defence;
    private final int power;
    private final int knowledge;
    private final int luck;
    private final int morale;

    SkillAdditionalStatistic(int aAttack, int aDefence, int aPower, int aKnowledge, int aLuck, int aMorale) {
        this.attack = aAttack;
        this.defence = aDefence;
        this.power = aPower;
        this.knowledge = aKnowledge;
        this.luck = aLuck;
        this.morale = aMorale;
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
