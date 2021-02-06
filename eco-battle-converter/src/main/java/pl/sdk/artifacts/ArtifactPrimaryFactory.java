package pl.sdk.artifacts;

import static pl.sdk.artifacts.ArtifactName.*;

public class ArtifactPrimaryFactory extends ArtifactAbstractFactory {

    private static final String EXCEPTION_MESSAGE = "There is no artifact with that name";

    @Override
    public ArtifactPrimary create(String aName){
        switch (aName) {
            case CENTAURS_AX:
                return new ArtifactPrimary(ArtifactStatistic.CENTAURS_AX, ArtifactPrimaryStatistic.CENTAURS_AX);
            case BLACKSHARD_OF_THE_DEAD_KNIGHT:
                return new ArtifactPrimary(ArtifactStatistic.BLACKSHARD_OF_THE_DEAD_KNIGHT, ArtifactPrimaryStatistic.BLACKSHARD_OF_THE_DEAD_KNIGHT);
            case GREATER_GNOLLS_FLAIL:
                return new ArtifactPrimary(ArtifactStatistic.GREATER_GNOLLS_FLAIL, ArtifactPrimaryStatistic.GREATER_GNOLLS_FLAIL);
            case OGRES_CLUB_OF_HOVOC:
                return new ArtifactPrimary(ArtifactStatistic.OGRES_CLUB_OF_HOVOC, ArtifactPrimaryStatistic.OGRES_CLUB_OF_HOVOC);
            case SWORD_OF_HELLFIRE:
                return new ArtifactPrimary(ArtifactStatistic.SWORD_OF_HELLFIRE, ArtifactPrimaryStatistic.SWORD_OF_HELLFIRE);
            case TITANS_GLADIUS:
                return new ArtifactPrimary(ArtifactStatistic.TITANS_GLADIUS, ArtifactPrimaryStatistic.TITANS_GLADIUS);
            case SHIELD_OF_THE_DWARVEN_LORDS:
                return new ArtifactPrimary(ArtifactStatistic.SHIELD_OF_THE_DWARVEN_LORDS, ArtifactPrimaryStatistic.SHIELD_OF_THE_DWARVEN_LORDS);
            case SHIELD_OF_THE_YAWNING_DEAD:
                return new ArtifactPrimary(ArtifactStatistic.SHIELD_OF_THE_YAWNING_DEAD, ArtifactPrimaryStatistic.SHIELD_OF_THE_YAWNING_DEAD);
            case BUCKLER_OF_THE_GNOLL_KING:
                return new ArtifactPrimary(ArtifactStatistic.BUCKLER_OF_THE_GNOLL_KING, ArtifactPrimaryStatistic.BUCKLER_OF_THE_GNOLL_KING);
            case TARG_OF_THE_RAMPAGING_OGRE:
                return new ArtifactPrimary(ArtifactStatistic.TARG_OF_THE_RAMPAGING_OGRE, ArtifactPrimaryStatistic.TARG_OF_THE_RAMPAGING_OGRE);
            case SHIELD_OF_THE_DAMNED:
                return new ArtifactPrimary(ArtifactStatistic.SHIELD_OF_THE_DAMNED, ArtifactPrimaryStatistic.SHIELD_OF_THE_DAMNED);
            case SENTINELS_SHIELD:
                return new ArtifactPrimary(ArtifactStatistic.SENTINELS_SHIELD, ArtifactPrimaryStatistic.SENTINELS_SHIELD);
            case BREASTPLATE_OF_PETRIFIED_WOOD:
                return new ArtifactPrimary(ArtifactStatistic.BREASTPLATE_OF_PETRIFIED_WOOD, ArtifactPrimaryStatistic.BREASTPLATE_OF_PETRIFIED_WOOD);
            case RIB_CAGE:
                return new ArtifactPrimary(ArtifactStatistic.RIB_CAGE, ArtifactPrimaryStatistic.RIB_CAGE);
            case SCALES_OF_THE_GREATER_BASILISK:
                return new ArtifactPrimary(ArtifactStatistic.SCALES_OF_THE_GREATER_BASILISK, ArtifactPrimaryStatistic.SCALES_OF_THE_GREATER_BASILISK);
            case TUNIC_OF_THE_CYCLOPS_KING:
                return new ArtifactPrimary(ArtifactStatistic.TUNIC_OF_THE_CYCLOPS_KING, ArtifactPrimaryStatistic.TUNIC_OF_THE_CYCLOPS_KING);
            case BREASTPLATE_OF_BRIMSTONE:
                return new ArtifactPrimary(ArtifactStatistic.BREASTPLATE_OF_BRIMSTONE, ArtifactPrimaryStatistic.BREASTPLATE_OF_BRIMSTONE);
            case TITANS_CUIRAS:
                return new ArtifactPrimary(ArtifactStatistic.TITANS_CUIRAS, ArtifactPrimaryStatistic.TITANS_CUIRAS);
            case HELM_OF_THE_ALABASTER_UNICORN:
                return new ArtifactPrimary(ArtifactStatistic.HELM_OF_THE_ALABASTER_UNICORN, ArtifactPrimaryStatistic.HELM_OF_THE_ALABASTER_UNICORN);
            case SKULL_HELMET:
                return new ArtifactPrimary(ArtifactStatistic.SKULL_HELMET, ArtifactPrimaryStatistic.SKULL_HELMET);
            case HELM_OF_CHAOS:
                return new ArtifactPrimary(ArtifactStatistic.HELM_OF_CHAOS, ArtifactPrimaryStatistic.HELM_OF_CHAOS);
            case CROWN_OF_THE_SUPREME_MAGI:
                return new ArtifactPrimary(ArtifactStatistic.CROWN_OF_THE_SUPREME_MAGI, ArtifactPrimaryStatistic.CROWN_OF_THE_SUPREME_MAGI);
            case HELLSTORM_HELMET:
                return new ArtifactPrimary(ArtifactStatistic.HELLSTORM_HELMET, ArtifactPrimaryStatistic.HELLSTORM_HELMET);
            case THUNDER_HELMET:
                return new ArtifactPrimary(ArtifactStatistic.THUNDER_HELMET, ArtifactPrimaryStatistic.THUNDER_HELMET);
            case QUIET_EYE_OF_THE_DRAGON:
                return new ArtifactPrimary(ArtifactStatistic.QUIET_EYE_OF_THE_DRAGON, ArtifactPrimaryStatistic.QUIET_EYE_OF_THE_DRAGON);
            case RED_DRAGON_FLAME_TONGUE:
                return new ArtifactPrimary(ArtifactStatistic.RED_DRAGON_FLAME_TONGUE, ArtifactPrimaryStatistic.RED_DRAGON_FLAME_TONGUE);
            case DRAGON_SCALE_SHIELD:
                return new ArtifactPrimary(ArtifactStatistic.DRAGON_SCALE_SHIELD, ArtifactPrimaryStatistic.DRAGON_SCALE_SHIELD);
            case DRAGON_SCALE_ARMOR:
                return new ArtifactPrimary(ArtifactStatistic.DRAGON_SCALE_ARMOR, ArtifactPrimaryStatistic.DRAGON_SCALE_ARMOR);
            case DRAGONBONE_GREAVES:
                return new ArtifactPrimary(ArtifactStatistic.DRAGONBONE_GREAVES, ArtifactPrimaryStatistic.DRAGONBONE_GREAVES);
            case DRAGON_WING_TABARD:
                return new ArtifactPrimary(ArtifactStatistic.DRAGON_WING_TABARD, ArtifactPrimaryStatistic.DRAGON_WING_TABARD);
            case NECKLACE_OF_DRAGONTEETH:
                return new ArtifactPrimary(ArtifactStatistic.NECKLACE_OF_DRAGONTEETH, ArtifactPrimaryStatistic.NECKLACE_OF_DRAGONTEETH);
            case CROWN_OF_DRAGONTOOTH:
                return new ArtifactPrimary(ArtifactStatistic.CROWN_OF_DRAGONTOOTH, ArtifactPrimaryStatistic.CROWN_OF_DRAGONTOOTH);
            case ARMOR_OF_WONDER:
                return new ArtifactPrimary(ArtifactStatistic.ARMOR_OF_WONDER, ArtifactPrimaryStatistic.ARMOR_OF_WONDER);
            case SANDALS_OF_THE_SAINT:
                return new ArtifactPrimary(ArtifactStatistic.SANDALS_OF_THE_SAINT, ArtifactPrimaryStatistic.SANDALS_OF_THE_SAINT);
            case CELESTIAL_NECKLACE_OF_BLISS:
                return new ArtifactPrimary(ArtifactStatistic.CELESTIAL_NECKLACE_OF_BLISS, ArtifactPrimaryStatistic.CELESTIAL_NECKLACE_OFBLISS);
            case LIONS_SHIELD_OF_COURAGE:
                return new ArtifactPrimary(ArtifactStatistic.LIONS_SHIELD_OF_COURAGE, ArtifactPrimaryStatistic.LIONS_SHIELD_OF_COURAGE);
            case SWORD_OF_JUJEMENT:
                return new ArtifactPrimary(ArtifactStatistic.SWORD_OF_JUJEMENT, ArtifactPrimaryStatistic.SWORD_OF_JUJEMENT);
            case BADGE_OF_COURAGE:
                return new ArtifactPrimary(ArtifactStatistic.BADGE_OF_COURAGE, ArtifactPrimaryStatistic.BADGE_OF_COURAGE);
            case CREST_OF_VALOR:
                return new ArtifactPrimary(ArtifactStatistic.CREST_OF_VALOR, ArtifactPrimaryStatistic.CREST_OF_VALOR);
            case GLYPH_OF_GALLANTRY:
                return new ArtifactPrimary(ArtifactStatistic.GLYPH_OF_GALLANTRY, ArtifactPrimaryStatistic.GLYPH_OF_GALLANTRY);
            case CLOVER_OF_FORTUNE:
                return new ArtifactPrimary(ArtifactStatistic.CLOVER_OF_FORTUNE, ArtifactPrimaryStatistic.CLOVER_OF_FORTUNE);
            case CARDS_OF_PROPHECY:
                return new ArtifactPrimary(ArtifactStatistic.CARDS_OF_PROPHECY, ArtifactPrimaryStatistic.CARDS_OF_PROPHECY);
            case LADYBIRD_OF_LUCK:
                return new ArtifactPrimary(ArtifactStatistic.LADYBIRD_OF_LUCK, ArtifactPrimaryStatistic.LADYBIRD_OF_LUCK);
            case STILL_EYE_OF_THE_DRAGON:
                return new ArtifactPrimary(ArtifactStatistic.STILL_EYE_OF_THE_DRAGON, ArtifactPrimaryStatistic.STILL_EYE_OF_THE_DRAGON);
            case PENDANT_OF_COURAGE:
                return new ArtifactPrimary(ArtifactStatistic.PENDANT_OF_COURAGE, ArtifactPrimaryStatistic.PENDANT_OF_COURAGE);



            default:
                throw new IllegalArgumentException(EXCEPTION_MESSAGE);

        }
    }
}
