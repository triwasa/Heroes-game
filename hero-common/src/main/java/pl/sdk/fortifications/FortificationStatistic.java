package pl.sdk.fortifications;

import com.google.common.collect.Range;

public enum FortificationStatistic implements FortificationStatisticIf {


    WALL("Wall", 3, Range.closed(0,0), 0, "Walking units can’t go through wall, it can be destroyed only by Catapult, Cyclops or Earthquake spell. It's hp depends on level."),
    KEEP("Keep", 2,Range.closed(15,15) , 0, "It's special addition to combat when hero is trying to capture a garrisoned town. Deals 2*more damage than tower");


    private final String name;
    private Range<Integer> damage;
    private final int maxHp;
    private final int level;
    private final String description;


     FortificationStatistic(String aName, int aMaxHp, Range<Integer> aDamage, int aLevel, String aDescription) {
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
    public Range<Integer> getDamage() {
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
