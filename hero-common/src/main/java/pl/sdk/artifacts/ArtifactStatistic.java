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

    // PRIMARY 2
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
    HELM_OF_HEAVENLY_ENLIGHTENMENT("Helm of Heavenly Enlightenment", "head", "relic", "+6 to all 4 primary skills"),

    // COMBAT
    GOLDEN_BOW("Golden Bow", "misc", "major", "Your troops can shoot at any distance, through any obstacle without penalty"),
    RING_OF_VITALITY("Ring of Vitality", "finger", "treasure", "Increases health of all your units by 1"),
    RING_OF_LIFE("Ring of Life", "finger", "minor", "Increases health of all your units by 1"),
    VIAL_OF_LIFEBLOOD("Vial of Lifeblood", "misc", "major", "Increases health of all your units by 2"),

    COLLAR_OF_CONJURING("Collar of Conjuring", "neck", "treasure", "Increases duration of all your spells by 1"),
    RING_OF_CONJURING("Ring of Conjuring", "finger", "treasure", "Increases duration of all your spells by 2"),
    CAPE_OF_CONJURING("Cape of Conjuring", "shoulders", "treasure", "Increases duration of all your spells by 3"),
    GARNITURE_OF_INTERFERENCE("Garniture of Interference", "neck", "major", "+5% to magic resistance"),
    SURCOAT_OF_COUNTERPOISE("Surcoat of Counterpoise", "shoulders", "major", "+10% to magic resistance"),
    BOOTS_OF_POLARITY("Boots of Polarity", "feet", "relic", "+15% to magic resistance"),
    NECKLACE_OF_SWIFTNESS("Necklace of Swiftness", "neck", "treasure", "Increases the combat speed of all your units by 1"),
    RING_OF_THE_WAYFARER("Ring of the Wayfarer", "finger", "major", "Increases the combat speed of all your units by 1"),
    CAPE_OF_VELOCITY("Cape of Velocity", "shoulders", "major", "Increases the combat speed of all your units by 2"),

    // SPELL
    ORB_OF_THE_FIRMAMENT("Orb of Firmament", "misc", "major", "Hero's air spells to extra 50% damage"),
    ORB_OF_SILT("Orb of Silt", "misc", "major", "Hero's earth spells to extra 50% damage"),
    ORB_OF_TEMPSTUOUS_FIRE("Orb of Tempstuous Fire", "misc", "major", "Hero's fire spells to extra 50% damage"),
    ORB_OF_DRIVING_RAIN("Orb of Driving Rain", "misc", "major", "Hero's water spells to extra 50% damage"),

    TOME_OF_AIR_MAGIC("Tome of Air Magic", "misc", "relic", "All air spells are available to hero when equipped"),
    TOME_OF_EARTH_MAGIC("Tome of Earth Magic", "misc", "relic", "All earth spells are available to hero when equipped"),
    TOME_OF_FIRE_MAGIC("Tome of Fire Magic", "misc", "relic", "All fire spells are available to hero when equipped"),
    TOME_OF_WATER_MAGIC("Tome of Water Magic", "misc", "relic", "All water spells are available to hero when equipped"),
    SPELLBINDERS_HAT("Spellbinder's Hat", "head", "relic", "All 5th level spells are available to hero when worn"),

    PENDANT_OF_DISPASSION("Pendant of Dispassion", "neck", "treasure", "Renders your units immune to the berserk spell"),
    PENDANT_OF_SECOND_SIGHT("Pendant of Second Sight", "neck", "major", "Renders your units immune to the blind spell"),
    PENDANT_OF_HOLINESS("Pendant of Holiness", "neck", "treasure", "Renders your units immune to the curse spell"),
    PENDANT_OF_LIFE("Pendant of Life", "neck", "treasure", "Renders your units immune to the death ripple spell"),
    PENDANT_OF_DEATH("Pendant of Death", "neck", "treasure", "Renders your units immune to the destroy undead spell"),
    PENDANT_OF_FREE_WILL("Pendant of Free Will", "neck", "treasure", "Renders your units immune to the hypnotize spell"),
    PENDANT_OF_NEGATIVITY("Pendant of Negativity", "neck", "major", "Renders your units immune to the lightning spell"),
    PENDANT_OF_TOTAL_RECALL("Pendant of Total Recall", "neck", "treasure", "Renders your units immune to the forgetfulness spell"),
    SPHERE_OF_PERMANENCE("Sphere of Permanence", "misc", "major", "Renders your units immune to dispel magic spell"),
    RECANTERS_CLOAK("Recanter's Cloak", "shoulders", "major", "Prevents casting spells of level 3 and higher in combat"),
    ORB_OF_INHIBITION("Orb of Inhibition", "misc", "relic", "Prevents all spellcasting in combat");


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
