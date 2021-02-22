package pl.sdk.artifacts;

enum ArtifactStatistic implements ArtifactStatisticIf {

    // ARTIFACTS FOR TESTS
    TEST_LEFT_HAND_SLOT(ArtifactName.TEST_LEFT_HAND_SLOT, ArtifactSlotName.LEFT_HAND, ArtifactRarity.TREASURE, ArtifactDescription.TEST),
    TEST_RIGHT_HAND_SLOT(ArtifactName.TEST_RIGHT_HAND_SLOT, ArtifactSlotName.RIGHT_HAND, ArtifactRarity.TREASURE, ArtifactDescription.TEST),
    TEST_TOO_EXPENSIVE(ArtifactName.TEST_TOO_EXPENSIVE, ArtifactSlotName.NECK, ArtifactRarity.TREASURE, ArtifactDescription.TEST),
    TEST_INCREASE_HEALTH_1(ArtifactName.TEST_INCREASE_HEALTH_1, ArtifactSlotName.NECK, ArtifactRarity.TREASURE, ArtifactDescription.TEST),
    TEST_INCREASE_HEALTH_2(ArtifactName.TEST_INCREASE_HEALTH_2, ArtifactSlotName.HEAD, ArtifactRarity.TREASURE, ArtifactDescription.TEST),
    TEST_INCREASE_MOVERANGE_1(ArtifactName.TEST_INCREASE_MOVERANGE_1, ArtifactSlotName.NECK, ArtifactRarity.TREASURE, ArtifactDescription.TEST),
    TEST_INCREASE_MOVERANGE_2(ArtifactName.TEST_INCREASE_MOVERANGE_2, ArtifactSlotName.HEAD, ArtifactRarity.TREASURE, ArtifactDescription.TEST),
    TEST_INCREASE_RESISTANCE_5(ArtifactName.TEST_INCREASE_RESISTANCE_5, ArtifactSlotName.NECK, ArtifactRarity.TREASURE, ArtifactDescription.TEST),
    TEST_INCREASE_RESISTANCE_10(ArtifactName.TEST_INCREASE_RESISTANCE_10, ArtifactSlotName.HEAD, ArtifactRarity.TREASURE, ArtifactDescription.TEST),
    TEST_KNOWLEDGE_SPELLPOWER(ArtifactName.TEST_KNOWLEDGE_SPELLPOWER, ArtifactSlotName.HEAD, ArtifactRarity.TREASURE, ArtifactDescription.TEST),
    TEST_ATTACK(ArtifactName.TEST_ATTACK, ArtifactSlotName.LEFT_HAND, ArtifactRarity.TREASURE, ArtifactDescription.TEST),
    TEST_DEFENCE(ArtifactName.TEST_DEFENCE, ArtifactSlotName.RIGHT_HAND, ArtifactRarity.TREASURE, ArtifactDescription.TEST),
    TEST_LUCK(ArtifactName.TEST_LUCK, ArtifactSlotName.HEAD, ArtifactRarity.TREASURE, ArtifactDescription.TEST),
    TEST_MORALE(ArtifactName.TEST_MORALE, ArtifactSlotName.HEAD, ArtifactRarity.TREASURE, ArtifactDescription.TEST),
    TEST_LUCK_MORALE(ArtifactName.TEST_LUCK_MORALE, ArtifactSlotName.HEAD, ArtifactRarity.TREASURE, ArtifactDescription.TEST),

    // PRIMARY 1
    CENTAURS_AX(ArtifactName.CENTAURS_AX, ArtifactSlotName.RIGHT_HAND, ArtifactRarity.TREASURE, ArtifactDescription.CENTAURS_AX),
    BLACKSHARD_OF_THE_DEAD_KNIGHT(ArtifactName.BLACKSHARD_OF_THE_DEAD_KNIGHT, ArtifactSlotName.RIGHT_HAND,ArtifactRarity.MINOR, ArtifactDescription.BLACKSHARD_OF_THE_DEAD_KNIGHT),
    GREATER_GNOLLS_FLAIL(ArtifactName.GREATER_GNOLLS_FLAIL, ArtifactSlotName.RIGHT_HAND,ArtifactRarity.MINOR, ArtifactDescription.GREATER_GNOLLS_FLAIL),
    OGRES_CLUB_OF_HOVOC(ArtifactName.OGRES_CLUB_OF_HOVOC, ArtifactSlotName.RIGHT_HAND,ArtifactRarity.MINOR, ArtifactDescription.OGRES_CLUB_OF_HOVOC),
    SWORD_OF_HELLFIRE(ArtifactName.SWORD_OF_HELLFIRE, ArtifactSlotName.RIGHT_HAND,ArtifactRarity.MAJOR, ArtifactDescription.SWORD_OF_HELLFIRE),
    TITANS_GLADIUS(ArtifactName.TITANS_GLADIUS, ArtifactSlotName.RIGHT_HAND,ArtifactRarity.RELIC, ArtifactDescription.TITANS_GLADIUS),
    SHIELD_OF_THE_DWARVEN_LORDS(ArtifactName.SHIELD_OF_THE_DWARVEN_LORDS, ArtifactSlotName.LEFT_HAND,ArtifactRarity.TREASURE, ArtifactDescription.SHIELD_OF_THE_DWARVEN_LORDS),
    SHIELD_OF_THE_YAWNING_DEAD(ArtifactName.SHIELD_OF_THE_YAWNING_DEAD, ArtifactSlotName.LEFT_HAND,ArtifactRarity.MINOR, ArtifactDescription.SHIELD_OF_THE_YAWNING_DEAD),
    BUCKLER_OF_THE_GNOLL_KING(ArtifactName.BUCKLER_OF_THE_GNOLL_KING, ArtifactSlotName.LEFT_HAND,ArtifactRarity.MINOR, ArtifactDescription.BUCKLER_OF_THE_GNOLL_KING),
    TARG_OF_THE_RAMPAGING_OGRE(ArtifactName.TARG_OF_THE_RAMPAGING_OGRE, ArtifactSlotName.LEFT_HAND,ArtifactRarity.MAJOR, ArtifactDescription.TARG_OF_THE_RAMPAGING_OGRE),
    SHIELD_OF_THE_DAMNED(ArtifactName.SHIELD_OF_THE_DAMNED, ArtifactSlotName.LEFT_HAND,ArtifactRarity.MAJOR, ArtifactDescription.SHIELD_OF_THE_DAMNED),
    SENTINELS_SHIELD(ArtifactName.SENTINELS_SHIELD, ArtifactSlotName.LEFT_HAND,ArtifactRarity.RELIC, ArtifactDescription.SENTINELS_SHIELD),
    BREASTPLATE_OF_PETRIFIED_WOOD(ArtifactName.BREASTPLATE_OF_PETRIFIED_WOOD, ArtifactSlotName.TORSO,ArtifactRarity.TREASURE, ArtifactDescription.BREASTPLATE_OF_PETRIFIED_WOOD),
    RIB_CAGE(ArtifactName.RIB_CAGE, ArtifactSlotName.TORSO,ArtifactRarity.MINOR, ArtifactDescription.RIB_CAGE),
    SCALES_OF_THE_GREATER_BASILISK(ArtifactName.SCALES_OF_THE_GREATER_BASILISK, ArtifactSlotName.TORSO,ArtifactRarity.MINOR, ArtifactDescription.SCALES_OF_THE_GREATER_BASILISK),
    TUNIC_OF_THE_CYCLOPS_KING(ArtifactName.TUNIC_OF_THE_CYCLOPS_KING, ArtifactSlotName.TORSO,ArtifactRarity.MAJOR, ArtifactDescription.TUNIC_OF_THE_CYCLOPS_KING),
    BREASTPLATE_OF_BRIMSTONE(ArtifactName.BREASTPLATE_OF_BRIMSTONE, ArtifactSlotName.TORSO,ArtifactRarity.MAJOR, ArtifactDescription.BREASTPLATE_OF_BRIMSTONE),
    TITANS_CUIRAS(ArtifactName.TITANS_CUIRAS, ArtifactSlotName.TORSO,ArtifactRarity.RELIC, ArtifactDescription.TITANS_CUIRAS),
    HELM_OF_THE_ALABASTER_UNICORN(ArtifactName.HELM_OF_THE_ALABASTER_UNICORN, ArtifactSlotName.HEAD,ArtifactRarity.TREASURE, ArtifactDescription.HELM_OF_THE_ALABASTER_UNICORN),
    SKULL_HELMET(ArtifactName.SKULL_HELMET, ArtifactSlotName.HEAD,ArtifactRarity.TREASURE, ArtifactDescription.SKULL_HELMET),
    HELM_OF_CHAOS(ArtifactName.HELM_OF_CHAOS, ArtifactSlotName.HEAD,ArtifactRarity.MINOR, ArtifactDescription.HELM_OF_CHAOS),
    CROWN_OF_THE_SUPREME_MAGI(ArtifactName.CROWN_OF_THE_SUPREME_MAGI, ArtifactSlotName.HEAD,ArtifactRarity.MINOR, ArtifactDescription.CROWN_OF_THE_SUPREME_MAGI),
    HELLSTORM_HELMET(ArtifactName.HELLSTORM_HELMET, ArtifactSlotName.HEAD,ArtifactRarity.MAJOR, ArtifactDescription.HELLSTORM_HELMET),
    THUNDER_HELMET(ArtifactName.THUNDER_HELMET, ArtifactSlotName.HEAD,ArtifactRarity.RELIC, ArtifactDescription.THUNDER_HELMET),

    // PRIMARY 2
    QUIET_EYE_OF_THE_DRAGON(ArtifactName.QUIET_EYE_OF_THE_DRAGON, ArtifactSlotName.FINGER, ArtifactRarity.TREASURE, ArtifactDescription.QUIET_EYE_OF_THE_DRAGON),
    RED_DRAGON_FLAME_TONGUE(ArtifactName.RED_DRAGON_FLAME_TONGUE, ArtifactSlotName.RIGHT_HAND, ArtifactRarity.MINOR, ArtifactDescription.RED_DRAGON_FLAME_TONGUE),
    DRAGON_SCALE_SHIELD(ArtifactName.DRAGON_SCALE_SHIELD, ArtifactSlotName.LEFT_HAND, ArtifactRarity.MAJOR, ArtifactDescription.DRAGON_SCALE_SHIELD),
    DRAGON_SCALE_ARMOR(ArtifactName.DRAGON_SCALE_ARMOR, ArtifactSlotName.TORSO, ArtifactRarity.RELIC, ArtifactDescription.DRAGON_SCALE_ARMOR),
    DRAGONBONE_GREAVES(ArtifactName.DRAGONBONE_GREAVES, ArtifactSlotName.FEET, ArtifactRarity.TREASURE, ArtifactDescription.DRAGONBONE_GREAVES),
    DRAGON_WING_TABARD(ArtifactName.DRAGON_WING_TABARD, ArtifactSlotName.SHOULDERS, ArtifactRarity.MINOR, ArtifactDescription.DRAGON_WING_TABARD),
    NECKLACE_OF_DRAGONTEETH(ArtifactName.NECKLACE_OF_DRAGONTEETH, ArtifactSlotName.NECK, ArtifactRarity.MAJOR, ArtifactDescription.NECKLACE_OF_DRAGONTEETH),
    CROWN_OF_DRAGONTOOTH(ArtifactName.CROWN_OF_DRAGONTOOTH, ArtifactSlotName.HEAD, ArtifactRarity.RELIC, ArtifactDescription.CROWN_OF_DRAGONTOOTH),
    ARMOR_OF_WONDER(ArtifactName.ARMOR_OF_WONDER, ArtifactSlotName.TORSO, ArtifactRarity.MINOR, ArtifactDescription.ARMOR_OF_WONDER),
    SANDALS_OF_THE_SAINT(ArtifactName.SANDALS_OF_THE_SAINT, ArtifactSlotName.FEET, ArtifactRarity.RELIC, ArtifactDescription.SANDALS_OF_THE_SAINT),
    CELESTIAL_NECKLACE_OF_BLISS(ArtifactName.CELESTIAL_NECKLACE_OF_BLISS, ArtifactSlotName.NECK, ArtifactRarity.RELIC, ArtifactDescription.CELESTIAL_NECKLACE_OF_BLISS),
    LIONS_SHIELD_OF_COURAGE(ArtifactName.LIONS_SHIELD_OF_COURAGE, ArtifactSlotName.LEFT_HAND, ArtifactRarity.RELIC, ArtifactDescription.LIONS_SHIELD_OF_COURAGE),
    SWORD_OF_JUJEMENT(ArtifactName.SWORD_OF_JUJEMENT, ArtifactSlotName.RIGHT_HAND, ArtifactRarity.RELIC, ArtifactDescription.SWORD_OF_JUJEMENT),
    HELM_OF_HEAVENLY_ENLIGHTENMENT(ArtifactName.HELM_OF_HEAVENLY_ENLIGHTENMENT, ArtifactSlotName.HEAD, ArtifactRarity.RELIC, ArtifactDescription.HELM_OF_HEAVENLY_ENLIGHTENMENT),
    BADGE_OF_COURAGE(ArtifactName.BADGE_OF_COURAGE, ArtifactSlotName.MISC, ArtifactRarity.TREASURE, ArtifactDescription.BADGE_OF_COURAGE),
    CREST_OF_VALOR(ArtifactName.CREST_OF_VALOR, ArtifactSlotName.MISC, ArtifactRarity.TREASURE, ArtifactDescription.CREST_OF_VALOR),
    GLYPH_OF_GALLANTRY(ArtifactName.GLYPH_OF_GALLANTRY, ArtifactSlotName.MISC, ArtifactRarity.TREASURE, ArtifactDescription.GLYPH_OF_GALLANTRY),
    CLOVER_OF_FORTUNE(ArtifactName.CLOVER_OF_FORTUNE, ArtifactSlotName.MISC, ArtifactRarity.TREASURE, ArtifactDescription.CLOVER_OF_FORTUNE),
    CARDS_OF_PROPHECY(ArtifactName.CARDS_OF_PROPHECY, ArtifactSlotName.MISC, ArtifactRarity.TREASURE, ArtifactDescription.CARDS_OF_PROPHECY),
    LADYBIRD_OF_LUCK(ArtifactName.LADYBIRD_OF_LUCK, ArtifactSlotName.MISC, ArtifactRarity.TREASURE, ArtifactDescription.LADYBIRD_OF_LUCK),
    STILL_EYE_OF_THE_DRAGON(ArtifactName.STILL_EYE_OF_THE_DRAGON, ArtifactSlotName.FINGER, ArtifactRarity.TREASURE, ArtifactDescription.STILL_EYE_OF_THE_DRAGON),
    PENDANT_OF_COURAGE(ArtifactName.PENDANT_OF_COURAGE, ArtifactSlotName.NECK, ArtifactRarity.MAJOR, ArtifactDescription.PENDANT_OF_COURAGE),

    // COMBAT
    GOLDEN_BOW(ArtifactName.GOLDEN_BOW, ArtifactSlotName.MISC, ArtifactRarity.MAJOR, ArtifactDescription.GOLDEN_BOW),
    RING_OF_VITALITY(ArtifactName.RING_OF_VITALITY, ArtifactSlotName.FINGER, ArtifactRarity.TREASURE, ArtifactDescription.RING_OF_VITALITY),
    RING_OF_LIFE(ArtifactName.RING_OF_LIFE, ArtifactSlotName.FINGER, ArtifactRarity.MINOR, ArtifactDescription.RING_OF_LIFE),
    VIAL_OF_LIFEBLOOD(ArtifactName.VIAL_OF_LIFEBLOOD, ArtifactSlotName.MISC, ArtifactRarity.MAJOR, ArtifactDescription.VIAL_OF_LIFEBLOOD),

    GARNITURE_OF_INTERFERENCE(ArtifactName.GARNITURE_OF_INTERFERENCE, ArtifactSlotName.NECK, ArtifactRarity.MAJOR, ArtifactDescription.GARNITURE_OF_INTERFERENCE),
    SURCOAT_OF_COUNTERPOISE(ArtifactName.SURCOAT_OF_COUNTERPOISE, ArtifactSlotName.SHOULDERS, ArtifactRarity.MAJOR, ArtifactDescription.SURCOAT_OF_COUNTERPOISE),
    BOOTS_OF_POLARITY(ArtifactName.BOOTS_OF_POLARITY, ArtifactSlotName.FEET, ArtifactRarity.RELIC, ArtifactDescription.BOOTS_OF_POLARITY),
    NECKLACE_OF_SWIFTNESS(ArtifactName.NECKLACE_OF_SWIFTNESS, ArtifactSlotName.NECK, ArtifactRarity.TREASURE, ArtifactDescription.NECKLACE_OF_SWIFTNESS),
    RING_OF_THE_WAYFARER(ArtifactName.RING_OF_THE_WAYFARER, ArtifactSlotName.FINGER, ArtifactRarity.MAJOR, ArtifactDescription.RING_OF_THE_WAYFARER),
    CAPE_OF_VELOCITY(ArtifactName.CAPE_OF_VELOCITY, ArtifactSlotName.SHOULDERS, ArtifactRarity.MAJOR, ArtifactDescription.CAPE_OF_VELOCITY),

    // SPELL
    COLLAR_OF_CONJURING(ArtifactName.COLLAR_OF_CONJURING, ArtifactSlotName.NECK, ArtifactRarity.TREASURE, ArtifactDescription.COLLAR_OF_CONJURING),
    RING_OF_CONJURING(ArtifactName.RING_OF_CONJURING, ArtifactSlotName.FINGER, ArtifactRarity.TREASURE, ArtifactDescription.RING_OF_CONJURING),
    CAPE_OF_CONJURING(ArtifactName.CAPE_OF_CONJURING, ArtifactSlotName.SHOULDERS, ArtifactRarity.TREASURE, ArtifactDescription.CAPE_OF_CONJURING),

    ORB_OF_THE_FIRMAMENT(ArtifactName.ORB_OF_THE_FIRMAMENT, ArtifactSlotName.MISC, ArtifactRarity.MAJOR, ArtifactDescription.ORB_OF_THE_FIRMAMENT),
    ORB_OF_SILT(ArtifactName.ORB_OF_SILT, ArtifactSlotName.MISC, ArtifactRarity.MAJOR, ArtifactDescription.ORB_OF_SILT),
    ORB_OF_TEMPSTUOUS_FIRE(ArtifactName.ORB_OF_TEMPSTUOUS_FIRE, ArtifactSlotName.MISC, ArtifactRarity.MAJOR, ArtifactDescription.ORB_OF_TEMPSTUOUS_FIRE),
    ORB_OF_DRIVING_RAIN(ArtifactName.ORB_OF_DRIVING_RAIN, ArtifactSlotName.MISC, ArtifactRarity.MAJOR, ArtifactDescription.ORB_OF_DRIVING_RAIN),

    TOME_OF_AIR_MAGIC(ArtifactName.TOME_OF_AIR_MAGIC, ArtifactSlotName.MISC, ArtifactRarity.RELIC, ArtifactDescription.TOME_OF_AIR_MAGIC),
    TOME_OF_EARTH_MAGIC(ArtifactName.TOME_OF_EARTH_MAGIC, ArtifactSlotName.MISC, ArtifactRarity.RELIC, ArtifactDescription.TOME_OF_EARTH_MAGIC),
    TOME_OF_FIRE_MAGIC(ArtifactName.TOME_OF_FIRE_MAGIC, ArtifactSlotName.MISC, ArtifactRarity.RELIC, ArtifactDescription.TOME_OF_FIRE_MAGIC),
    TOME_OF_WATER_MAGIC(ArtifactName.TOME_OF_WATER_MAGIC, ArtifactSlotName.MISC, ArtifactRarity.RELIC, ArtifactDescription.TOME_OF_WATER_MAGIC),
    SPELLBINDERS_HAT(ArtifactName.SPELLBINDERS_HAT, ArtifactSlotName.HEAD, ArtifactRarity.RELIC, ArtifactDescription.SPELLBINDERS_HAT),

    PENDANT_OF_DISPASSION(ArtifactName.PENDANT_OF_DISPASSION, ArtifactSlotName.NECK, ArtifactRarity.TREASURE, ArtifactDescription.PENDANT_OF_DISPASSION),
    PENDANT_OF_SECOND_SIGHT(ArtifactName.PENDANT_OF_SECOND_SIGHT, ArtifactSlotName.NECK, ArtifactRarity.MAJOR, ArtifactDescription.PENDANT_OF_SECOND_SIGHT),
    PENDANT_OF_HOLINESS(ArtifactName.PENDANT_OF_HOLINESS, ArtifactSlotName.NECK, ArtifactRarity.TREASURE, ArtifactDescription.PENDANT_OF_HOLINESS),
    PENDANT_OF_LIFE(ArtifactName.PENDANT_OF_LIFE, ArtifactSlotName.NECK, ArtifactRarity.TREASURE, ArtifactDescription.PENDANT_OF_LIFE),
    PENDANT_OF_DEATH(ArtifactName.PENDANT_OF_DEATH, ArtifactSlotName.NECK, ArtifactRarity.TREASURE, ArtifactDescription.PENDANT_OF_DEATH),
    PENDANT_OF_FREE_WILL(ArtifactName.PENDANT_OF_FREE_WILL, ArtifactSlotName.NECK, ArtifactRarity.TREASURE, ArtifactDescription.PENDANT_OF_FREE_WILL),
    PENDANT_OF_NEGATIVITY(ArtifactName.PENDANT_OF_NEGATIVITY, ArtifactSlotName.NECK, ArtifactRarity.MAJOR, ArtifactDescription.PENDANT_OF_NEGATIVITY),
    PENDANT_OF_TOTAL_RECALL(ArtifactName.PENDANT_OF_TOTAL_RECALL, ArtifactSlotName.NECK, ArtifactRarity.TREASURE, ArtifactDescription.PENDANT_OF_TOTAL_RECALL),
    SPHERE_OF_PERMANENCE(ArtifactName.SPHERE_OF_PERMANENCE, ArtifactSlotName.MISC, ArtifactRarity.MAJOR, ArtifactDescription.SPHERE_OF_PERMANENCE),
    RECANTERS_CLOAK(ArtifactName.RECANTERS_CLOAK, ArtifactSlotName.SHOULDERS, ArtifactRarity.MAJOR, ArtifactDescription.RECANTERS_CLOAK),
    ORB_OF_INHIBITION(ArtifactName.ORB_OF_INHIBITION, ArtifactSlotName.MISC, ArtifactRarity.RELIC, ArtifactDescription.ORB_OF_INHIBITION);


    private final String name;
    private final ArtifactSlotName slotName;
    private final ArtifactRarity rarity;
    private final ArtifactDescription description;

    ArtifactStatistic(String aName, ArtifactSlotName aSlotName, ArtifactRarity aRarity, ArtifactDescription aDescription) {
        this.name = aName;
        this.slotName = aSlotName;
        this.rarity = aRarity;
        this.description = aDescription;
    }

    public String getTranslatedName() { return name; }

    public String getSlotName() { return slotName.name(); }

    public String getRarity() { return rarity.name(); }

    public String getDescription() { return description.name(); }
}
