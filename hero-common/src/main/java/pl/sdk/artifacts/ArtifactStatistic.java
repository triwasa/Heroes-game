package pl.sdk.artifacts;

enum ArtifactStatistic implements ArtifactStatisticIf {

    // PRIMARY 1
    CENTAURS_AX("Centaur's Ax", "right hand", 2, 0, 0, 0,"treasure"),
    BLACKSHARD_OF_THE_DEAD_KNIGHT("Blackshard of the Dead Knight", "right hand", 3, 0, 0, 0,"minor"),
    GREATER_GNOLLS_FLAIL("Greater Gnoll's Flail", "right hand", 4, 0, 0, 0,"minor"),
    OGRES_CLUB_OF_HOVOC("Ogre's Club of Havoc", "right hand", 5, 0, 0, 0,"major"),
    SWORD_OF_HELLFIRE("Sword of Hellfire", "right hand", 6, 0, 0, 0,"major"),
    TITANS_GLADIUS("Titan's Gladius", "right hand", 12, -3, 0, 0,"relic"),
    SHIELD_OF_THE_DWARVEN_LORDS("Shield of the Dwarven Lords", "left hand", 0, 2, 0, 0,"treasure"),
    SHIELD_OF_THE_YAWNING_DEAD("Shield of the Yawning Dead", "left hand", 0, 3, 0, 0,"minor"),
    BUCKLER_OF_THE_GNOLL_KING("Buckler of the Gnoll King", "left hand", 0, 4, 0, 0,"minor"),
    TARG_OF_THE_RAMPAGING_OGRE("Targ of the Rampaging Ogre", "left hand", 0, 5, 0, 0,"major"),
    SHIELD_OF_THE_DAMNED("Shield of the Damned", "left hand", 0, 6, 0, 0,"major"),
    SENTINELS_SHIELD("Sentinel's Shield", "left hand", -3, 6, 0, 0,"relic"),
    BREASTPLATE_OF_PETRIFIED_WOOD("Breastplate of Petrified Wood", "torso", 0, 0, 1, 0,"treasure"),
    RIB_CAGE("Rib Cage", "torso", 0, 0, 2, 0,"minor"),
    SCALES_OF_THE_GREATER_BASILISK("Scales of the Greater Basilisk", "torso", 0, 0, 3, 0,"minor"),
    TUNIC_OF_THE_CYCLOPS_KING("Tunic of the Cyclops King", "torso", 0, 0, 4, 0,"major"),
    BREASTPLATE_OF_BRIMSTONE("Breastplate of Brimstone", "torso", 0, 0, 5, 0,"major"),
    TITANS_CUIRAS("Titan's Cuiras", "torso", 0, 0, 10, -2,"relic"),
    HELM_OF_THE_ALABASTER_UNICORN("Helm of the Alabaster Unicorn", "head", 0, 0, 0, 1,"treasure"),
    SKULL_HELMET("Skull Helmet", "head", 0, 0, 0, 2,"treasure"),
    HELM_OF_CHAOS("Helm of Chaos", "head", 0, 0, 0, 3,"minor"),
    CROWN_OF_THE_SUPREME_MAGI("Crown of the Supreme Magi", "head", 0, 0, 0, 4,"minor"),
    HELLSTORM_HELMET("Hellstorm Helmet", "head", 0, 0, 0, 5,"major"),
    THUNDER_HELMET("Thunder Helmet", "head", 0, 0, -2, 10,"relic");


    private final String name;
    private final String slotName;
    private final int attackSkill;
    private final int defenceSkill;
    private final int spellPower;
    private final int knowledge;
    private final String rarity;

    ArtifactStatistic(String aName, String aSlotName, int aAttackSkill, int aDefenceSkill, int aSpellPower, int aKnowledge, String aRarity) {
        this.name = aName;
        this.slotName = aSlotName;
        this.attackSkill = aAttackSkill;
        this.defenceSkill = aDefenceSkill;
        this.spellPower = aSpellPower;
        this.knowledge = aKnowledge;
        this.rarity = aRarity;
    }

    public String getTranslatedName() { return name; }

    public String getSlotName() { return slotName; }

    public int getAttackSkill() { return attackSkill; }

    public int getDefenceSkill() { return defenceSkill; }

    public int getSpellPower() { return spellPower; }

    public int getKnowledge() { return knowledge; }

    public String getRarity() { return rarity; }
}
