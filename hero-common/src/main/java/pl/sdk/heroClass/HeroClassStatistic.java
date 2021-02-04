package pl.sdk.heroClass;

enum HeroClassStatistic implements HeroClassStatisticIf {

    KNIGHT("Knight",2,2,1,1),
    CLERIC("Cleric",1,0,2,2),
    RANGER("Ranger",1,3,1,1),
    DRUID("Druid",0,2,1,2),
    ALCHEMIST("Alchemist",1,1,2,2),
    WIZARD("Wizard",0,0,2,3),
    DEMONIAC("Demoniac",2,2,1,1),
    HERETIC("Heretic",1,1,2,1),
    DEATH_KNIGHT("Death Knight",1,2,2,1),
    NECROMANCER("Necromancer",1,0,2,2),
    OVERLORD("Overlord",2,2,1,1),
    WARLOCK("Warlock",0,0,3,2),
    BARBARIAN("Barbarian",4,0,1,1),
    BATTLE_MAGE("Battle Mage",2,1,1,1),
    BEASTMASTER("Beastmaster",0,4,1,1),
    WITCH("Witch",0,1,2,2),
    PLANESWALKER("Planeswalker",3,1,1,1),
    ELEMENTALIST("Elementalist",0,0,3,3),
    CAPTAIN("Captain",3,0,2,1),
    NAVIGATOR("Navigator",2,0,1,2);


    private final int attack;
    private final int defence;
    private final int knowledge;
    private final int power;
    private final String name;


    HeroClassStatistic(String aName, int aAttack, int aDefence, int aPower, int aKnowledge) {
        this.name = aName;
        this.attack = aAttack;
        this.defence = aDefence;
        this.power = aPower;
        this.knowledge = aKnowledge;
    }

    public String getName() {return name;}
    public int getAttack() {return attack;}
    public int getDefence() {return defence;}
    public int getPower() {return  power;}
    public int getKnowledge() {return knowledge;}
}
