package pl.sdk.artifacts;

import pl.sdk.hero.HeroClassStatisticIf;

enum ArtifactPrimaryStatistic implements HeroClassStatisticIf {
    // PRIMARY 1
    CENTAURS_AX(2, 0,0,0),
    BLACKSHARD_OF_THE_DEAD_KNIGHT(3, 0, 0, 0),
    GREATER_GNOLLS_FLAIL(4, 0,0, 0),
    OGRES_CLUB_OF_HOVOC(5, 0, 0, 0),
    SWORD_OF_HELLFIRE(6, 0, 0, 0),
    TITANS_GLADIUS(12, -3, 0, 0),
    SHIELD_OF_THE_DWARVEN_LORDS(0, 2, 0, 0),
    SHIELD_OF_THE_YAWNING_DEAD(0, 3, 0, 0),
    BUCKLER_OF_THE_GNOLL_KING(0, 4, 0, 0),
    TARG_OF_THE_RAMPAGING_OGRE(0,5,0,0),
    SHIELD_OF_THE_DAMNED(0, 6,0,0),
    SENTINELS_SHIELD(-3,12,0,0),
    BREASTPLATE_OF_PETRIFIED_WOOD(0,0,1,0),
    RIB_CAGE(0,0,2,0),
    SCALES_OF_THE_GREATER_BASILISK(0,0,3,0),
    TUNIC_OF_THE_CYCLOPS_KING(0,0,4,0),
    BREASTPLATE_OF_BRIMSTONE(0,0,5,0),
    TITANS_CUIRAS(0,0,10,-2),
    HELM_OF_THE_ALABASTER_UNICORN(0,0,0,1),
    SKULL_HELMET(0,0,0,2),
    HELM_OF_CHAOS(0,0,0,3),
    CROWN_OF_THE_SUPREME_MAGI(0,0,0,4),
    HELLSTORM_HELMET(0,0,0,5),
    THUNDER_HELMET(0,0,-2,10),
    QUIET_EYE_OF_THE_DRAGON(1,1,0,0),
    RED_DRAGON_FLAME_TONGUE(2,2,0,0),
    DRAGON_SCALE_SHIELD(3,3,0,0),
    DRAGON_SCALE_ARMOR(4,4,0,0),
    DRAGONBONE_GREAVES(0,0,1,1),
    DRAGON_WING_TABARD(0,0,2,2),
    NECKLACE_OF_DRAGONTEETH(0,0,3,3),
    CROWN_OF_DRAGONTOOTH(0,0,4,4),
    ARMOR_OF_WONDER(1,1,1,1),
    SANDALS_OF_THE_SAINT(2,2,2,2),
    CELESTIAL_NECKLACE_OFBLISS(3,3,3,3),
    LIONS_SHIELD_OF_COURAGE(4,4,4,4),
    SWORD_OF_JUJEMENT(5,5,5,5),
    HELM_OF_HEAVENLY_ENLIGHTENMENT(6,6,6,6);

    private final int attack;
    private final int defence;
    private final int power;
    private final int knowledge;

    ArtifactPrimaryStatistic(int aAttack, int aDefence, int aPower, int aKnowledge ) {
        this.attack = aAttack;
        this.defence = aDefence;
        this.power = aPower;
        this.knowledge = aKnowledge;
    }

    public int getAttack() { return attack; }

    public int getDefence() { return defence; }

    public int getPower() { return power; }

    public int getKnowledge() { return knowledge; }

}
