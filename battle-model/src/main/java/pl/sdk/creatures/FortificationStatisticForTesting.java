package pl.sdk.creatures;

import pl.sdk.fortifications.FortificationStatisticIf;

class FortificationStatisticForTesting implements FortificationStatisticIf {



    private final String name;
    private int damage;
    private final int maxHp;



    FortificationStatisticForTesting(String aName, int aMaxHp, int aDamage) {
        name=aName;
        maxHp=aMaxHp;
        damage = aDamage;

    }
    String getName() {
        return name;
    }


    @Override
    public String getTranslatedName() {
        return getName();
    }


    public int getMaxHp() {
        return maxHp;
    }

    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public int getLevel() {
        return 0;
    }

    @Override
    public String getDescription() {
        return "Fortification for testing";
    }
}

