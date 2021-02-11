package pl.sdk.hero;

enum HeroClassStatistic implements HeroClassStatisticIf {

    KNIGHT("Knight",2,2,1,1,0,0),
    CLERIC("Cleric",1,0,2,2,0,0),
    RANGER("Ranger",1,3,1,1,0,0),
    DRUID("Druid",0,2,1,2,0,0),
    ALCHEMIST("Alchemist",1,1,2,2,0,0),
    WIZARD("Wizard",0,0,2,3,0,0),
    DEMONIAC("Demoniac",2,2,1,1,0,0),
    HERETIC("Heretic",1,1,2,1,0,0),
    DEATH_KNIGHT("Death Knight",1,2,2,1,0,0),
    NECROMANCER("Necromancer",1,0,2,2,0,0),
    OVERLORD("Overlord",2,2,1,1,0,0),
    WARLOCK("Warlock",0,0,3,2,0,0),
    BARBARIAN("Barbarian",4,0,1,1,0,0),
    BATTLE_MAGE("Battle Mage",2,1,1,1,0,0),
    BEASTMASTER("Beastmaster",0,4,1,1,0,0),
    WITCH("Witch",0,1,2,2,0,0),
    PLANESWALKER("Planeswalker",3,1,1,1,0,0),
    ELEMENTALIST("Elementalist",0,0,3,3,0,0),
    CAPTAIN("Captain",3,0,2,1,0,0),
    NAVIGATOR("Navigator",2,0,1,2,0,0);


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
