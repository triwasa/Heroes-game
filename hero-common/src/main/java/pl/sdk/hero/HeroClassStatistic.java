package pl.sdk.hero;

enum HeroClassStatistic implements HeroClassStatisticIf {

    //FOR_TESTS("For testing",1,1,1,1,1,1),

    KNIGHT(HeroClassName.KNIGHT,2,2,1,1,0,0),
    CLERIC(HeroClassName.CLERIC,1,0,2,2,0,0),
    RANGER(HeroClassName.RANGER,1,3,1,1,0,0),
    DRUID(HeroClassName.DRUID,0,2,1,2,0,0),
    ALCHEMIST(HeroClassName.ALCHEMIST,1,1,2,2,0,0),
    WIZARD(HeroClassName.WIZARD,0,0,2,3,0,0),
    DEMONIAC(HeroClassName.DEMONIAC,2,2,1,1,0,0),
    HERETIC(HeroClassName.HERETIC,1,1,2,1,0,0),
    DEATH_KNIGHT(HeroClassName.DEATH_KNIGHT,1,2,2,1,0,0),
    NECROMANCER(HeroClassName.NECROMANCER, 1,0,2,2,0,0),
    OVERLORD(HeroClassName.OVERLORD,2,2,1,1,0,0),
    WARLOCK(HeroClassName.WARLOCK,0,0,3,2,0,0),
    BARBARIAN(HeroClassName.BARBARIAN,4,0,1,1,0,0),
    BATTLE_MAGE(HeroClassName.BATTLE_MAGE,2,1,1,1,0,0),
    BEASTMASTER(HeroClassName.BEASTMASTER,0,4,1,1,0,0),
    WITCH(HeroClassName.WITCH,0,1,2,2,0,0),
    PLANESWALKER(HeroClassName.PLANESWALKER,3,1,1,1,0,0),
    ELEMENTALIST(HeroClassName.ELEMENTALIST,0,0,3,3,0,0),
    CAPTAIN(HeroClassName.CAPTAIN,3,0,2,1,0,0),
    NAVIGATOR(HeroClassName.NAVIGATOR,2,0,1,2,0,0);


    private final String name;
    private final int attack;
    private final int defence;
    private final int knowledge;
    private final int power;
    private final int luck;
    private final int morale;


    HeroClassStatistic(String aName, int aAttack, int aDefence, int aPower, int aKnowledge, int aLuck, int aMorale) {
        this.name = aName;
        this.attack = aAttack;
        this.defence = aDefence;
        this.power = aPower;
        this.knowledge = aKnowledge;
        this.luck = aLuck;
        this.morale = aMorale;
    }

    public String getName() {return name;}
    public int getAttack() {return attack;}
    public int getDefence() {return defence;}
    public int getPower() {return  power;}
    public int getKnowledge() {return knowledge;}
    public int getLuck() {
        return luck;
    }
    public int getMorale() {
        return morale;
    }
}
