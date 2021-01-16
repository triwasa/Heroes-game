package pl.sdk.warMachines;

import com.google.common.collect.Range;

enum WarMachinesStatistic implements WarMachinesStatisticIf{

    // TEST MACHINE
    TEST("name",10, 10, 250,0,Range.closed(8,12),"test war machine" ),


    // WAR MACHINES
    BALLISTA("Ballista",10, 10, 250,0,Range.closed(8,12),"A ballista is a missile weapon that, like ranged units, shoots projectiles toward enemy troops, but is unable to retaliate against attacks. The Artillery and Archery secondary skills increase this damage. The ballista acts at the end of every combat round, followed only by the first aid tent, and can be controlled when a hero has learned any level of Artillery." ),
    FIRSTAIDTENT("First Aid Tent",0, 0, 75,0,Range.closed(0,0),"First Aid Tent heals 1-25 hit points of the top creature in target allied stack. The amount of health restored is affected by First Aid secondary skill, which also gives the player control over the tent rather than being chosen by computer. First Aid Tents act last at the combat round."),
    CATAPULT("Catapult",10,10, 1000,0, Range.closed(1,1),"The Catapult only appears on the battlefield when siege attacking enemy towns with walls, which requires the town to have a fort, citadel, or castle. Its main use is to attack and destroy the walls in order to enable ground troops to attack the defenders. The Catapult can also attack and destroy the arrow towers of citadels and castles. The ballistics secondary skill enhances the performance of the Catapult. Basic ballistics gives the player control over the Catapult making it possible to aim at particular parts of the siege structures. During a siege, the Catapult shoots after the arrow towers, but before any other troop");

    private final String name;
    private final int attack;
    private final int armor;
    private final int maxHp;
    private final int moveRange;
    private final Range<Integer> damage;
    private final String description;


    WarMachinesStatistic(String aName, int aAttack, int aArmor, int aMaxHp, int aMoveRange, Range<Integer> aDamage, String aDescription ) {
        name = aName;
        attack = aAttack;
        armor = aArmor;
        maxHp = aMaxHp;
        moveRange = aMoveRange;
        damage = aDamage;
        description = aDescription;
    }

    public String getTranslatedName() {
        return name;
    }

    public int getAttack() {
        return attack;
    }

    @Override
    public int getArmor() { return armor;

    }

    public int getMaxHp() {
        return maxHp;
    }

    public int getMoveRange() {
        return moveRange;
    }

    public Range<Integer> getDamage(){
        return damage;
    }

    public String getDescription() {
        return description;
    }
}
