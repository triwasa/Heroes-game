package pl.sdk.spell;

public enum EconomySpellEnum {

    //WATER
    BLESS(5, "Bless", typeOfSpell.WATER, 1),
    CURE(6, "Cure", typeOfSpell.WATER, 1),
    DISPEL(5, "Dispel", typeOfSpell.WATER, 1),
    PROTECTION_FROM_WATER(5, "Protection from water", typeOfSpell.WATER, 1),
    MAGIC_ARROW_WATER(5, "Magic Arrow", typeOfSpell.WATER, 1),
    ICE_BOLT(8, "Ice Bolt", typeOfSpell.WATER, 2),
    REMOVE_OBSTRACLE(7, "Remove Obstracle", typeOfSpell.WATER, 2),
    WEAKNESS(8, "Weakness", typeOfSpell.WATER, 2),
    FORGETFULNESS(12, "Forgetfilness", typeOfSpell.WATER, 3),
    FROST_RING(12, "Frost Ring", typeOfSpell.WATER, 3),
    MIRTH(12, "Mirth", typeOfSpell.WATER, 3),
    TELEPORT(15, "Teleport", typeOfSpell.WATER, 3),
    CLONE(24, "Clone", typeOfSpell.WATER, 4),
    PRAYER(16, "Prayer", typeOfSpell.WATER, 4),
    SUMMON_WATER_ELEMENTAL(25, "Summon Water Elemental", typeOfSpell.WATER, 5),

    //AIR
    HASTE(6, "Haste", typeOfSpell.AIR, 1),
    MAGIC_ARROW_AIR(5, "Magic Arrow", typeOfSpell.AIR, 1),
    DISRUPTING_RAY(10, "Disrupting Ray", typeOfSpell.AIR, 1),
    FORTUNE(7, "Fortune", typeOfSpell.AIR, 2),
    LIGHTING_BOLT(10, "Lighting Bolt", typeOfSpell.AIR, 2),
    PRECISION(8, "Precision", typeOfSpell.AIR, 2),
    AIR_SHIELD(12, "Air Shield", typeOfSpell.AIR, 3),
    DESTROY_UNDEAD(15, "Destroy Undead", typeOfSpell.AIR, 3),
    PROTECTION_FROM_AIR(5, "Protection from Air", typeOfSpell.AIR, 3),
    HYPNOTIZE(18, "hypnotize", typeOfSpell.AIR, 3),
    CHAIN_LIGHTNING(24, "Chain Lightning", typeOfSpell.AIR, 4),
    COUNTERSTRIKE(24, "Counterstrike", typeOfSpell.AIR, 4),
    MAGIC_MIRROR(25, "Magic Mirror", typeOfSpell.WATER, 5),
    SUMMON_AIR_ELEMENTAL(25, "Summon Air Elemental", typeOfSpell.WATER, 5),

    //FIRE
    BLOODLUST(5, "Bloodlust", typeOfSpell.FIRE, 1),
    CURSE(6, "Curse", typeOfSpell.FIRE, 1),
    PROTECTION_FROM_FIRE(5, "Protection From Fire", typeOfSpell.FIRE, 1),
    MAGIC_ARROW_FIRE(5, "Magic Arrow", typeOfSpell.FIRE, 1),
    BLIND(10, "Blind", typeOfSpell.FIRE, 2),
    FIRE_WALL(8, "Fire Wall", typeOfSpell.FIRE, 2),
    FIRE_BALL(15, "fire Ball", typeOfSpell.FIRE, 3),
    LAND_MINE(18, "Land Mine", typeOfSpell.FIRE, 3),
    MISFORTUNE(12, "Misfortune", typeOfSpell.FIRE, 3),
    ARMAGEDDON(24, "Armageddon", typeOfSpell.FIRE, 4),
    BERZERK(20, "Berzerk", typeOfSpell.FIRE, 4),
    FIRE_SHIELD(16, "Fire Shield", typeOfSpell.FIRE, 4),
    FRENZY(16, "Frenzy", typeOfSpell.FIRE, 4),
    INFERNO(16, "Inferno", typeOfSpell.FIRE, 4),
    SLAYER(25, "Slayer", typeOfSpell.FIRE, 4),
    SACRIFICE(25, "Sacryfice", typeOfSpell.FIRE, 5),
    SUMMON_FIRE_ELEMENTAL(25, "Summon Fire Elemental", typeOfSpell.FIRE, 5),

    //EARTH
    SHIELD(5, "Shield", typeOfSpell.EARTH, 1),
    SLOW(6, "Slow", typeOfSpell.EARTH, 1),
    STONESKIN(5, "Stoneskin", typeOfSpell.EARTH, 1),
    MAGIC_ARROW_EARTH(5, "Magic Arrow", typeOfSpell.EARTH, 1),
    DEATH_RIPPLE(10, "Death Ripple", typeOfSpell.EARTH, 2),
    PROTECTION_FROM_EARTH(5, "Protection from Earth", typeOfSpell.EARTH, 2),
    QUICKSAND(8, "Quicksand", typeOfSpell.EARTH, 2),
    ANIMATE_DEAD(15, "Animate dead", typeOfSpell.EARTH, 3),
    EAEHQUAKE(20, "Earhquake", typeOfSpell.EARTH, 3),
    FORCE_FIELD(12, "Force Field", typeOfSpell.EARTH, 3),
    METEOR_SHOWER(20, "Meteor Shower", typeOfSpell.EARTH, 4),
    RESURRECTION(20, "Resurrection", typeOfSpell.EARTH, 4),
    SORROW(16, "Sorrow", typeOfSpell.EARTH, 4),
    IMPLOSION(30, "Implosion", typeOfSpell.EARTH, 5),
    SUMMON_EARH_ELEMENTAL(25, "Summon Earh Elemental", typeOfSpell.EARTH, 5);


    public enum typeOfSpell {
        WATER, AIR, FIRE, EARTH
    }

    private Integer cost;
    private String name;
    private EconomySpellEnum.typeOfSpell type;
    private Integer level;

    private EconomySpellEnum(int cost, String name, typeOfSpell type, Integer level) {
        this.cost = cost;
        this.name = name;
        this.type = type;
        this.level = level;
    }

    public Integer getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }

    public EconomySpellEnum.typeOfSpell getType() {
        return type;
    }

    public Integer getLevel() {
        return level;
    }
}
