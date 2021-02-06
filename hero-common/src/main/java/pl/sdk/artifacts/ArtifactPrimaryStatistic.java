package pl.sdk.artifacts;

import pl.sdk.hero.HeroClassStatisticIf;

enum ArtifactPrimaryStatistic implements HeroClassStatisticIf {
    // PRIMARY 1
    CENTAURS_AX(2, 0, 0, 0, 0, 0),
    BLACKSHARD_OF_THE_DEAD_KNIGHT(3, 0, 0, 0, 0, 0),
    GREATER_GNOLLS_FLAIL(4, 0, 0, 0, 0, 0),
    OGRES_CLUB_OF_HOVOC(5, 0, 0, 0, 0, 0),
    SWORD_OF_HELLFIRE(6, 0, 0, 0, 0, 0),
    TITANS_GLADIUS(12, -3, 0, 0, 0, 0),
    SHIELD_OF_THE_DWARVEN_LORDS(0, 2, 0, 0, 0, 0),
    SHIELD_OF_THE_YAWNING_DEAD(0, 3, 0, 0, 0, 0),
    BUCKLER_OF_THE_GNOLL_KING(0, 4, 0, 0, 0, 0),
    TARG_OF_THE_RAMPAGING_OGRE(0, 5, 0, 0, 0, 0),
    SHIELD_OF_THE_DAMNED(0, 6, 0, 0, 0, 0),
    SENTINELS_SHIELD(-3, 12, 0, 0, 0, 0),
    BREASTPLATE_OF_PETRIFIED_WOOD(0, 0, 1, 0, 0, 0),
    RIB_CAGE(0, 0, 2, 0, 0, 0),
    SCALES_OF_THE_GREATER_BASILISK(0, 0, 3, 0, 0, 0),
    TUNIC_OF_THE_CYCLOPS_KING(0, 0, 4, 0, 0, 0),
    BREASTPLATE_OF_BRIMSTONE(0, 0, 5, 0, 0, 0),
    TITANS_CUIRAS(0, 0, 10, -2, 0, 0),
    HELM_OF_THE_ALABASTER_UNICORN(0, 0, 0, 1, 0, 0),
    SKULL_HELMET(0, 0, 0, 2, 0, 0),
    HELM_OF_CHAOS(0, 0, 0, 3, 0, 0),
    CROWN_OF_THE_SUPREME_MAGI(0, 0, 0, 4, 0, 0),
    HELLSTORM_HELMET(0, 0, 0, 5, 0, 0),
    THUNDER_HELMET(0, 0, -2, 10, 0, 0),
    QUIET_EYE_OF_THE_DRAGON(1, 1, 0, 0, 0, 0),
    RED_DRAGON_FLAME_TONGUE(2, 2, 0, 0, 0, 0),
    DRAGON_SCALE_SHIELD(3, 3, 0, 0, 0, 0),
    DRAGON_SCALE_ARMOR(4, 4, 0, 0, 0, 0),
    DRAGONBONE_GREAVES(0, 0, 1, 1, 0, 0),
    DRAGON_WING_TABARD(0, 0, 2, 2, 0, 0),
    NECKLACE_OF_DRAGONTEETH(0, 0, 3, 3, 0, 0),
    CROWN_OF_DRAGONTOOTH(0, 0, 4, 4, 0, 0),
    ARMOR_OF_WONDER(1, 1, 1, 1, 0, 0),
    SANDALS_OF_THE_SAINT(2, 2, 2, 2, 0, 0),
    CELESTIAL_NECKLACE_OFBLISS(3, 3, 3, 3, 0, 0),
    LIONS_SHIELD_OF_COURAGE(4, 4, 4, 4, 0, 0),
    SWORD_OF_JUJEMENT(5, 5, 5, 5, 0, 0),
    HELM_OF_HEAVENLY_ENLIGHTENMENT(6, 6, 6, 6, 0, 0),
    BADGE_OF_COURAGE(0, 0, 0, 0, 0, 1),
    CREST_OF_VALOR(0, 0, 0, 0, 0, 1),
    GLYPH_OF_GALLANTRY(0, 0, 0, 0, 0, 1),
    CLOVER_OF_FORTUNE(0, 0, 0, 0, 1, 0),
    CARDS_OF_PROPHECY(0, 0, 0, 0, 1, 0),
    LADYBIRD_OF_LUCK(0, 0, 0, 0, 1, 0),
    STILL_EYE_OF_THE_DRAGON(0, 0, 0, 0, 1, 1),
    PENDANT_OF_COURAGE(0, 0, 0, 0, 3, 3);

    private final int attack;
    private final int defence;
    private final int power;
    private final int knowledge;
    private final int luck;
    private final int morale;

    ArtifactPrimaryStatistic(int aAttack, int aDefence, int aPower, int aKnowledge, int aLuck, int aMorale) {
        this.attack = aAttack;
        this.defence = aDefence;
        this.power = aPower;
        this.knowledge = aKnowledge;
        this.luck = aLuck;
        this.morale = aMorale;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefence() {
        return defence;
    }

    public int getPower() {
        return power;
    }

    public int getKnowledge() {
        return knowledge;
    }

    public int getLuck() {
        return luck;
    }

    public int getMorale() {
        return morale;
    }

}
