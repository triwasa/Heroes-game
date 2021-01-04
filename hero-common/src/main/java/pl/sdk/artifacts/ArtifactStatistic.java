package pl.sdk.artifacts;

enum ArtifactStatistic implements ArtifactStatisticIf {

    // PRIMARY 1
    CENTAURS_AX("Centaur's Ax", "right hand", 2, 0, 0, 0,"treasure", "+2 attack skill"),
    BLACKSHARD_OF_THE_DEAD_KNIGHT("Blackshard of the Dead Knight", "right hand", 3, 0, 0, 0,"minor", "+3 attack skill"),
    GREATER_GNOLLS_FLAIL("Greater Gnoll's Flail", "right hand", 4, 0, 0, 0,"minor", "+4 attack skill"),
    OGRES_CLUB_OF_HOVOC("Ogre's Club of Havoc", "right hand", 5, 0, 0, 0,"major", "+5 attack skill"),
    SWORD_OF_HELLFIRE("Sword of Hellfire", "right hand", 6, 0, 0, 0,"major", "+6 attack skill"),
    TITANS_GLADIUS("Titan's Gladius", "right hand", 12, -3, 0, 0,"relic", "+12 attack skill, -3 defence skill"),
    SHIELD_OF_THE_DWARVEN_LORDS("Shield of the Dwarven Lords", "left hand", 0, 2, 0, 0,"treasure", "+2 defence skill"),
    SHIELD_OF_THE_YAWNING_DEAD("Shield of the Yawning Dead", "left hand", 0, 3, 0, 0,"minor", "+3 defence skill"),
    BUCKLER_OF_THE_GNOLL_KING("Buckler of the Gnoll King", "left hand", 0, 4, 0, 0,"minor", "+4 defence skill"),
    TARG_OF_THE_RAMPAGING_OGRE("Targ of the Rampaging Ogre", "left hand", 0, 5, 0, 0,"major", "+5 defence skill"),
    SHIELD_OF_THE_DAMNED("Shield of the Damned", "left hand", 0, 6, 0, 0,"major", "+6 defence skill"),
    SENTINELS_SHIELD("Sentinel's Shield", "left hand", -3, 6, 0, 0,"relic", "+12 defence skill, -3 attack skill"),
    BREASTPLATE_OF_PETRIFIED_WOOD("Breastplate of Petrified Wood", "torso", 0, 0, 1, 0,"treasure", "+1 spell power"),
    RIB_CAGE("Rib Cage", "torso", 0, 0, 2, 0,"minor", "+2 spell power"),
    SCALES_OF_THE_GREATER_BASILISK("Scales of the Greater Basilisk", "torso", 0, 0, 3, 0,"minor", "+3 spell power"),
    TUNIC_OF_THE_CYCLOPS_KING("Tunic of the Cyclops King", "torso", 0, 0, 4, 0,"major", "+4 spell power"),
    BREASTPLATE_OF_BRIMSTONE("Breastplate of Brimstone", "torso", 0, 0, 5, 0,"major", "+5 spell power"),
    TITANS_CUIRAS("Titan's Cuiras", "torso", 0, 0, 10, -2,"relic", "+10 spell power, -2 knowledge"),
    HELM_OF_THE_ALABASTER_UNICORN("Helm of the Alabaster Unicorn", "head", 0, 0, 0, 1,"treasure", "+1 knowledge"),
    SKULL_HELMET("Skull Helmet", "head", 0, 0, 0, 2,"treasure", "+2 knowledge"),
    HELM_OF_CHAOS("Helm of Chaos", "head", 0, 0, 0, 3,"minor", "+3 knowledge"),
    CROWN_OF_THE_SUPREME_MAGI("Crown of the Supreme Magi", "head", 0, 0, 0, 4,"minor", "+4 knowledge"),
    HELLSTORM_HELMET("Hellstorm Helmet", "head", 0, 0, 0, 5,"major", "+5 knowledge"),
    THUNDER_HELMET("Thunder Helmet", "head", 0, 0, -2, 10,"relic", "+10 knowledge, -2 spell power");


    private final String name;
    private final String slotName;
    private final int attackSkill;
    private final int defenceSkill;
    private final int spellPower;
    private final int knowledge;
    private final String rarity;
    private final String description;

    ArtifactStatistic(String aName, String aSlotName, int aAttackSkill, int aDefenceSkill, int aSpellPower, int aKnowledge, String aRarity, String aDescription) {
        this.name = aName;
        this.slotName = aSlotName;
        this.attackSkill = aAttackSkill;
        this.defenceSkill = aDefenceSkill;
        this.spellPower = aSpellPower;
        this.knowledge = aKnowledge;
        this.rarity = aRarity;
        this.description = aDescription;
    }

    public String getTranslatedName() { return name; }

    public String getSlotName() { return slotName; }

    public int getAttackSkill() { return attackSkill; }

    public int getDefenceSkill() { return defenceSkill; }

    public int getSpellPower() { return spellPower; }

    public int getKnowledge() { return knowledge; }

    public String getRarity() { return rarity; }

    public String getDescription() { return description; }
}
