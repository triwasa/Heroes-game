package pl.sdk.artifacts;

public enum ArtifactStatistic implements ArtifactStatisticIf {

    // PRIMARY 1
    CENTAURS_AX(ArtifactName.CENTAURS_AX, "right hand", "treasure", "+2 attack skill"),
    BLACKSHARD_OF_THE_DEAD_KNIGHT(ArtifactName.BLACKSHARD_OF_THE_DEAD_KNIGHT, "right hand","minor", "+3 attack skill"),
    GREATER_GNOLLS_FLAIL(ArtifactName.GREATER_GNOLLS_FLAIL, "right hand","minor", "+4 attack skill"),
    OGRES_CLUB_OF_HOVOC(ArtifactName.OGRES_CLUB_OF_HOVOC, "right hand","major", "+5 attack skill"),
    SWORD_OF_HELLFIRE(ArtifactName.SWORD_OF_HELLFIRE, "right hand","major", "+6 attack skill"),
    TITANS_GLADIUS(ArtifactName.TITANS_GLADIUS, "right hand","relic", "+12 attack skill, -3 defence skill"),
    SHIELD_OF_THE_DWARVEN_LORDS(ArtifactName.SHIELD_OF_THE_DWARVEN_LORDS, "left hand","treasure", "+2 defence skill"),
    SHIELD_OF_THE_YAWNING_DEAD(ArtifactName.SHIELD_OF_THE_YAWNING_DEAD, "left hand","minor", "+3 defence skill"),
    BUCKLER_OF_THE_GNOLL_KING(ArtifactName.BUCKLER_OF_THE_GNOLL_KING, "left hand","minor", "+4 defence skill"),
    TARG_OF_THE_RAMPAGING_OGRE(ArtifactName.TARG_OF_THE_RAMPAGING_OGRE, "left hand","major", "+5 defence skill"),
    SHIELD_OF_THE_DAMNED(ArtifactName.SHIELD_OF_THE_DAMNED, "left hand","major", "+6 defence skill"),
    SENTINELS_SHIELD(ArtifactName.SENTINELS_SHIELD, "left hand","relic", "+12 defence skill, -3 attack skill"),
    BREASTPLATE_OF_PETRIFIED_WOOD(ArtifactName.BREASTPLATE_OF_PETRIFIED_WOOD, "torso","treasure", "+1 spell power"),
    RIB_CAGE(ArtifactName.RIB_CAGE, "torso","minor", "+2 spell power"),
    SCALES_OF_THE_GREATER_BASILISK(ArtifactName.SCALES_OF_THE_GREATER_BASILISK, "torso","minor", "+3 spell power"),
    TUNIC_OF_THE_CYCLOPS_KING(ArtifactName.TUNIC_OF_THE_CYCLOPS_KING, "torso","major", "+4 spell power"),
    BREASTPLATE_OF_BRIMSTONE(ArtifactName.BREASTPLATE_OF_BRIMSTONE, "torso","major", "+5 spell power"),
    TITANS_CUIRAS(ArtifactName.TITANS_CUIRAS, "torso","relic", "+10 spell power, -2 knowledge"),
    HELM_OF_THE_ALABASTER_UNICORN(ArtifactName.HELM_OF_THE_ALABASTER_UNICORN, "head","treasure", "+1 knowledge"),
    SKULL_HELMET(ArtifactName.SKULL_HELMET, "head","treasure", "+2 knowledge"),
    HELM_OF_CHAOS(ArtifactName.HELM_OF_CHAOS, "head","minor", "+3 knowledge"),
    CROWN_OF_THE_SUPREME_MAGI(ArtifactName.CROWN_OF_THE_SUPREME_MAGI, "head","minor", "+4 knowledge"),
    HELLSTORM_HELMET(ArtifactName.HELLSTORM_HELMET, "head","major", "+5 knowledge"),
    THUNDER_HELMET(ArtifactName.THUNDER_HELMET, "head","relic", "+10 knowledge, -2 spell power"),

    // PRIMARY 2
    QUIET_EYE_OF_THE_DRAGON(ArtifactName.QUIET_EYE_OF_THE_DRAGON, "finger", "treasure", "+1 to attack and defence skills"),
    RED_DRAGON_FLAME_TONGUE(ArtifactName.RED_DRAGON_FLAME_TONGUE, "right hand", "minor", "+2 to attack and defence skills"),
    DRAGON_SCALE_SHIELD(ArtifactName.DRAGON_SCALE_SHIELD, "left hand", "major", "+3 to attack and defence skills"),
    DRAGON_SCALE_ARMOR(ArtifactName.DRAGON_SCALE_ARMOR, "torso", "relic", "+4 to attack and defence skills"),
    DRAGONBONE_GREAVES(ArtifactName.DRAGONBONE_GREAVES, "feet", "treasure", "+1 to spell power and knowledge skills"),
    DRAGON_WING_TABARD(ArtifactName.DRAGON_WING_TABARD, "shoulders", "minor", "+2 to spell power and knowledge skills"),
    NECKLACE_OF_DRAGONTEETH(ArtifactName.NECKLACE_OF_DRAGONTEETH, "neck", "major", "+3 to spell power and knowledge skills"),
    CROWN_OF_DRAGONTOOTH(ArtifactName.CROWN_OF_DRAGONTOOTH, "head", "relic", "+4 to spell power and knowledge skills"),
    ARMOR_OF_WONDER(ArtifactName.ARMOR_OF_WONDER, "torso", "minor", "+1 to all 4 primary skills"),
    SANDALS_OF_THE_SAINT(ArtifactName.SANDALS_OF_THE_SAINT, "feet", "relic", "+2 to all 4 primary skills"),
    CELESTIAL_NECKLACE_OF_BLISS(ArtifactName.CELESTIAL_NECKLACE_OF_BLISS, "neck", "relic", "+3 to all 4 primary skills"),
    LIONS_SHIELD_OF_COURAGE(ArtifactName.LIONS_SHIELD_OF_COURAGE, "left hand", "relic", "+4 to all 4 primary skills"),
    SWORD_OF_JUJEMENT(ArtifactName.SWORD_OF_JUJEMENT, "right hand", "relic", "+5 to all 4 primary skills"),
    HELM_OF_HEAVENLY_ENLIGHTENMENT(ArtifactName.HELM_OF_HEAVENLY_ENLIGHTENMENT, "head", "relic", "+6 to all 4 primary skills"),
    BADGE_OF_COURAGE(ArtifactName.BADGE_OF_COURAGE, "misc", "treasure", "+1 morale"),
    CREST_OF_VALOR(ArtifactName.CREST_OF_VALOR, "misc", "treasure", "+1 morale"),
    GLYPH_OF_GALLANTRY(ArtifactName.GLYPH_OF_GALLANTRY, "misc", "treasure", "+1 morale"),
    CLOVER_OF_FORTUNE(ArtifactName.CLOVER_OF_FORTUNE, "misc", "treasure", "+1 luck"),
    CARDS_OF_PROPHECY(ArtifactName.CARDS_OF_PROPHECY, "misc", "treasure", "+1 luck"),
    LADYBIRD_OF_LUCK(ArtifactName.LADYBIRD_OF_LUCK, "misc", "treasure", "+1 luck"),
    STILL_EYE_OF_THE_DRAGON(ArtifactName.STILL_EYE_OF_THE_DRAGON, "finger", "treasure", "+1 luck and morale"),
    PENDANT_OF_COURAGE(ArtifactName.PENDANT_OF_COURAGE, "neck", "major", "+3 luck and morale"),

    // COMBAT
    RING_OF_VITALITY(ArtifactName.RING_OF_VITALITY, "finger", "treasure", "Increases health of all your units by 1"),
    RING_OF_LIFE(ArtifactName.RING_OF_LIFE, "finger", "minor", "Increases health of all your units by 1"),
    VIAL_OF_LIFEBLOOD(ArtifactName.VIAL_OF_LIFEBLOOD, "misc", "major", "Increases health of all your units by 2"),

    GARNITURE_OF_INTERFERENCE(ArtifactName.GARNITURE_OF_INTERFERENCE, "neck", "major", "+5% to magic resistance"),
    SURCOAT_OF_COUNTERPOISE(ArtifactName.SURCOAT_OF_COUNTERPOISE, "shoulders", "major", "+10% to magic resistance"),
    BOOTS_OF_POLARITY(ArtifactName.BOOTS_OF_POLARITY, "feet", "relic", "+15% to magic resistance"),
    NECKLACE_OF_SWIFTNESS(ArtifactName.NECKLACE_OF_SWIFTNESS, "neck", "treasure", "Increases the combat speed of all your units by 1"),
    RING_OF_THE_WAYFARER(ArtifactName.RING_OF_THE_WAYFARER, "finger", "major", "Increases the combat speed of all your units by 1"),
    CAPE_OF_VELOCITY(ArtifactName.CAPE_OF_VELOCITY, "shoulders", "major", "Increases the combat speed of all your units by 2"),

    // SPELL
    COLLAR_OF_CONJURING(ArtifactName.COLLAR_OF_CONJURING, "neck", "treasure", "Increases duration of all your spells by 1"),
    RING_OF_CONJURING(ArtifactName.RING_OF_CONJURING, "finger", "treasure", "Increases duration of all your spells by 2"),
    CAPE_OF_CONJURING(ArtifactName.CAPE_OF_CONJURING, "shoulders", "treasure", "Increases duration of all your spells by 3"),

    ORB_OF_THE_FIRMAMENT(ArtifactName.ORB_OF_THE_FIRMAMENT, "misc", "major", "Hero's air spells to extra 50% damage"),
    ORB_OF_SILT(ArtifactName.ORB_OF_SILT, "misc", "major", "Hero's earth spells to extra 50% damage"),
    ORB_OF_TEMPSTUOUS_FIRE(ArtifactName.ORB_OF_TEMPSTUOUS_FIRE, "misc", "major", "Hero's fire spells to extra 50% damage"),
    ORB_OF_DRIVING_RAIN(ArtifactName.ORB_OF_DRIVING_RAIN, "misc", "major", "Hero's water spells to extra 50% damage"),

    TOME_OF_AIR_MAGIC(ArtifactName.TOME_OF_AIR_MAGIC, "misc", "relic", "All air spells are available to hero when equipped"),
    TOME_OF_EARTH_MAGIC(ArtifactName.TOME_OF_EARTH_MAGIC, "misc", "relic", "All earth spells are available to hero when equipped"),
    TOME_OF_FIRE_MAGIC(ArtifactName.TOME_OF_FIRE_MAGIC, "misc", "relic", "All fire spells are available to hero when equipped"),
    TOME_OF_WATER_MAGIC(ArtifactName.TOME_OF_WATER_MAGIC, "misc", "relic", "All water spells are available to hero when equipped"),
    SPELLBINDERS_HAT(ArtifactName.SPELLBINDERS_HAT, "head", "relic", "All 5th level spells are available to hero when worn"),

    PENDANT_OF_DISPASSION(ArtifactName.PENDANT_OF_DISPASSION, "neck", "treasure", "Renders your units immune to the berserk spell"),
    PENDANT_OF_SECOND_SIGHT(ArtifactName.PENDANT_OF_SECOND_SIGHT, "neck", "major", "Renders your units immune to the blind spell"),
    PENDANT_OF_HOLINESS(ArtifactName.PENDANT_OF_HOLINESS, "neck", "treasure", "Renders your units immune to the curse spell"),
    PENDANT_OF_LIFE(ArtifactName.PENDANT_OF_LIFE, "neck", "treasure", "Renders your units immune to the death ripple spell"),
    PENDANT_OF_DEATH(ArtifactName.PENDANT_OF_DEATH, "neck", "treasure", "Renders your units immune to the destroy undead spell"),
    PENDANT_OF_FREE_WILL(ArtifactName.PENDANT_OF_FREE_WILL, "neck", "treasure", "Renders your units immune to the hypnotize spell"),
    PENDANT_OF_NEGATIVITY(ArtifactName.PENDANT_OF_NEGATIVITY, "neck", "major", "Renders your units immune to the lightning spell"),
    PENDANT_OF_TOTAL_RECALL(ArtifactName.PENDANT_OF_TOTAL_RECALL, "neck", "treasure", "Renders your units immune to the forgetfulness spell"),
    SPHERE_OF_PERMANENCE(ArtifactName.SPHERE_OF_PERMANENCE, "misc", "major", "Renders your units immune to dispel magic spell"),
    RECANTERS_CLOAK(ArtifactName.RECANTERS_CLOAK, "shoulders", "major", "Prevents casting spells of level 3 and higher in combat"),
    ORB_OF_INHIBITION(ArtifactName.ORB_OF_INHIBITION, "misc", "relic", "Prevents all spellcasting in combat");


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
