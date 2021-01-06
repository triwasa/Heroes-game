package pl.sdk.warMachines;

import com.google.common.collect.Range;

class WarMachineStatisticForTesting implements WarMachinesStatisticIf{

    private final String name;
    private final int attack;
    private final int maxHp;
    private final int moveRange;
    private final Range<Integer> damage;

    WarMachineStatisticForTesting(String aName, int aAttack, int aMaxHp, int aMoveRange, Range<Integer> aDamage) {
        name = aName;
        attack = aAttack;
        maxHp = aMaxHp;
        moveRange = aMoveRange;
        damage = aDamage;
    }

    String getName() {
        return name;
    }

    @Override
    public String getTranslatedName() {
        return getName();
    }

    public int getAttack() {
        return attack;
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

    @Override
    public String getDescription() {
        return "War Machine for testing";
    }
}

