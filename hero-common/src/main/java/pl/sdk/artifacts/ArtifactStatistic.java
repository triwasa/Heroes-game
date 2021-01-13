package pl.sdk.artifacts;

enum ArtifactStatistic implements ArtifactStatisticIf {

    // PRIMARY 1
    CENTAURS_AX("Centaur's Ax", "right hand", "treasure", "+2 attack skill"),
    BLACKSHARD_OF_THE_DEAD_KNIGHT("Blackshard of the Dead Knight", "right hand","minor", "+3 attack skill"),
    GREATER_GNOLLS_FLAIL("Greater Gnoll's Flail", "right hand","minor", "+4 attack skill"),
    OGRES_CLUB_OF_HOVOC("Ogre's Club of Havoc", "right hand","major", "+5 attack skill"),
    SWORD_OF_HELLFIRE("Sword of Hellfire", "right hand","major", "+6 attack skill"),
    TITANS_GLADIUS("Titan's Gladius", "right hand","relic", "+12 attack skill, -3 defence skill"),
    SHIELD_OF_THE_DWARVEN_LORDS("Shield of the Dwarven Lords", "left hand","treasure", "+2 defence skill"),
    SHIELD_OF_THE_YAWNING_DEAD("Shield of the Yawning Dead", "left hand","minor", "+3 defence skill"),
    BUCKLER_OF_THE_GNOLL_KING("Buckler of the Gnoll King", "left hand","minor", "+4 defence skill"),
    TARG_OF_THE_RAMPAGING_OGRE("Targ of the Rampaging Ogre", "left hand","major", "+5 defence skill"),
    SHIELD_OF_THE_DAMNED("Shield of the Damned", "left hand","major", "+6 defence skill"),
    SENTINELS_SHIELD("Sentinel's Shield", "left hand","relic", "+12 defence skill, -3 attack skill"),
    BREASTPLATE_OF_PETRIFIED_WOOD("Breastplate of Petrified Wood", "torso","treasure", "+1 spell power"),
    RIB_CAGE("Rib Cage", "torso","minor", "+2 spell power"),
    SCALES_OF_THE_GREATER_BASILISK("Scales of the Greater Basilisk", "torso","minor", "+3 spell power"),
    TUNIC_OF_THE_CYCLOPS_KING("Tunic of the Cyclops King", "torso","major", "+4 spell power"),
    BREASTPLATE_OF_BRIMSTONE("Breastplate of Brimstone", "torso","major", "+5 spell power"),
    TITANS_CUIRAS("Titan's Cuiras", "torso","relic", "+10 spell power, -2 knowledge"),
    HELM_OF_THE_ALABASTER_UNICORN("Helm of the Alabaster Unicorn", "head","treasure", "+1 knowledge"),
    SKULL_HELMET("Skull Helmet", "head","treasure", "+2 knowledge"),
    HELM_OF_CHAOS("Helm of Chaos", "head","minor", "+3 knowledge"),
    CROWN_OF_THE_SUPREME_MAGI("Crown of the Supreme Magi", "head","minor", "+4 knowledge"),
    HELLSTORM_HELMET("Hellstorm Helmet", "head","major", "+5 knowledge"),
    THUNDER_HELMET("Thunder Helmet", "head","relic", "+10 knowledge, -2 spell power"),

    QUIET_EYE_OF_THE_DRAGON("Quiet Eye of the Dragon", "finger", "treasure", "+1 to attack and defence skills"),
    RED_DRAGON_FLAME_TONGUE("Red Dragon Flame Tongue", "right hand", "minor", "+2 to attack and defence skills"),
    DRAGON_SCALE_SHIELD("Dragon Scale Shield", "left hand", "major", "+3 to attack and defence skills"),
    DRAGON_SCALE_ARMOR("Dragon Scale Armor", "torso", "relic", "+4 to attack and defence skills"),
    DRAGONBONE_GREAVES("Dragonbone Greaves", "feet", "treasure", "+1 to spell power and knowledge skills"),
    DRAGON_WING_TABARD("Dragon Wing Tabard", "shoulders", "minor", "+2 to spell power and knowledge skills"),
    NECKLACE_OF_DRAGONTEETH("Necklace of Dragonteeth", "neck", "major", "+3 to spell power and knowledge skills"),
    CROWN_OF_DRAGONTOOTH("Crown of Dragontooth", "head", "relic", "+4 to spell power and knowledge skills"),
    ARMOR_OF_WONDER("Armor of Wonder", "torso", "minor", "+1 to all 4 primary skills"),
    SANDALS_OF_THE_SAINT("Sandals of the Saint", "feet", "relic", "+2 to all 4 primary skills"),
    CELESTIAL_NECKLACE_OFBLISS("Celestial Necklace of Bliss", "neck", "relic", "+3 to all 4 primary skills"),
    LIONS_SHIELD_OF_COURAGE("Lion's Shield of Courage", "left hand", "relic", "+4 to all 4 primary skills"),
    SWORD_OF_JUJEMENT("Sword of Judjement", "right hand", "relic", "+5 to all 4 primary skills"),
    HELM_OF_HEAVENLY_ENLIGHTENMENT("Helm of Heavenly Enlightenment", "head", "relic", "+6 to all 4 primary skills");


    private final String name;
    private final String slotName;
    private final String rarity;
    private final String description;

    ArtifactStatistic(String aName, String aSlotName, String aRarity, String aDescription) {
        this.name = aName;
        this.slotName = aSlotName;
        this.rarity = aRarity;
        this.description = aDescription;
    }

    public String getTranslatedName() { return name; }

    public String getSlotName() { return slotName; }

    public String getRarity() { return rarity; }

    public String getDescription() { return description; }
}
