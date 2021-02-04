package pl.sdk.fortifications;

import com.google.common.collect.Range;

public enum FortificationStatistic implements FortificationStatisticIf {


    WALL("Wall", 3, 0, 0, "Walking units can’t go through wall, it can be destroyed only by Catapult, Cyclops or Earthquake spell. It's hp depends on level.");


    private final String name;
    private int damage;
    private final int maxHp;
    private final int level;
    private final String description;


     FortificationStatistic(String aName, int aMaxHp, int aDamage, int aLevel, String aDescription) {
        name=aName;
        maxHp=aMaxHp;
        damage = aDamage;
        level=aLevel;
        description=aDescription;
    }


    @Override
    public String getTranslatedName() {
        return name;
    }

    @Override
    public int getMaxHp() {
        return maxHp;
    }

    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
