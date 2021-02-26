package pl.sdk.artifacts;

import static pl.sdk.artifacts.ArtifactName.*;

public class EconomyArtifactPrimaryFactory {

    private static final String EXCEPTION_MESSAGE = "There is no artifact with that name";

    public EconomyArtifact createArtifactForTests(String aName){
        switch (aName) {
            case TEST_LEFT_HAND_SLOT:
                return new EconomyArtifact(ArtifactStatistic.TEST_LEFT_HAND_SLOT, 120);
             case TEST_RIGHT_HAND_SLOT:
                return new EconomyArtifact(ArtifactStatistic.TEST_RIGHT_HAND_SLOT, 140);
             case TEST_TOO_EXPENSIVE:
                return new EconomyArtifact(ArtifactStatistic.TEST_TOO_EXPENSIVE, 5000);
            default:
                throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }
    }

    public EconomyArtifact create(String aName){
        switch (aName) {
            case CENTAURS_AX:
                return new EconomyArtifact(ArtifactStatistic.CENTAURS_AX, 120);
            case BLACKSHARD_OF_THE_DEAD_KNIGHT:
                return new EconomyArtifact(ArtifactStatistic.BLACKSHARD_OF_THE_DEAD_KNIGHT, 200);
            case GREATER_GNOLLS_FLAIL:
                return new EconomyArtifact(ArtifactStatistic.GREATER_GNOLLS_FLAIL, 300);
            case OGRES_CLUB_OF_HOVOC:
                return new EconomyArtifact(ArtifactStatistic.OGRES_CLUB_OF_HOVOC, 490);
            case SWORD_OF_HELLFIRE:
                return new EconomyArtifact(ArtifactStatistic.SWORD_OF_HELLFIRE, 630);
            case TITANS_GLADIUS:
                return new EconomyArtifact(ArtifactStatistic.TITANS_GLADIUS, 900);
            case SHIELD_OF_THE_DWARVEN_LORDS:
                return new EconomyArtifact(ArtifactStatistic.SHIELD_OF_THE_DWARVEN_LORDS, 120);
            case SHIELD_OF_THE_YAWNING_DEAD:
                return new EconomyArtifact(ArtifactStatistic.SHIELD_OF_THE_YAWNING_DEAD, 200);
            case BUCKLER_OF_THE_GNOLL_KING:
                return new EconomyArtifact(ArtifactStatistic.BUCKLER_OF_THE_GNOLL_KING, 300);
            case TARG_OF_THE_RAMPAGING_OGRE:
                return new EconomyArtifact(ArtifactStatistic.TARG_OF_THE_RAMPAGING_OGRE, 490);
            case SHIELD_OF_THE_DAMNED:
                return new EconomyArtifact(ArtifactStatistic.SHIELD_OF_THE_DAMNED, 630);
            case SENTINELS_SHIELD:
                return new EconomyArtifact(ArtifactStatistic.SENTINELS_SHIELD, 1400);
            case BREASTPLATE_OF_PETRIFIED_WOOD:
                return new EconomyArtifact(ArtifactStatistic.BREASTPLATE_OF_PETRIFIED_WOOD, 150);
            case RIB_CAGE:
                return new EconomyArtifact(ArtifactStatistic.RIB_CAGE, 250);
            case SCALES_OF_THE_GREATER_BASILISK:
                return new EconomyArtifact(ArtifactStatistic.SCALES_OF_THE_GREATER_BASILISK, 390);
            case TUNIC_OF_THE_CYCLOPS_KING:
                return new EconomyArtifact(ArtifactStatistic.TUNIC_OF_THE_CYCLOPS_KING, 500);
            case BREASTPLATE_OF_BRIMSTONE:
                return new EconomyArtifact(ArtifactStatistic.BREASTPLATE_OF_BRIMSTONE, 700);
            case TITANS_CUIRAS:
                return new EconomyArtifact(ArtifactStatistic.TITANS_CUIRAS, 1400);
            case HELM_OF_THE_ALABASTER_UNICORN:
                return new EconomyArtifact(ArtifactStatistic.HELM_OF_THE_ALABASTER_UNICORN, 150);
            case SKULL_HELMET:
                return new EconomyArtifact(ArtifactStatistic.SKULL_HELMET, 320);
            case HELM_OF_CHAOS:
                return new EconomyArtifact(ArtifactStatistic.HELM_OF_CHAOS, 430);
            case CROWN_OF_THE_SUPREME_MAGI:
                return new EconomyArtifact(ArtifactStatistic.CROWN_OF_THE_SUPREME_MAGI, 600);
            case HELLSTORM_HELMET:
                return new EconomyArtifact(ArtifactStatistic.HELLSTORM_HELMET, 790);
            case THUNDER_HELMET:
                return new EconomyArtifact(ArtifactStatistic.THUNDER_HELMET, 1400);
            case QUIET_EYE_OF_THE_DRAGON:
                return new EconomyArtifact(ArtifactStatistic.QUIET_EYE_OF_THE_DRAGON, 140);
            case RED_DRAGON_FLAME_TONGUE:
                return new EconomyArtifact(ArtifactStatistic.RED_DRAGON_FLAME_TONGUE, 280);
            case DRAGON_SCALE_SHIELD:
                return new EconomyArtifact(ArtifactStatistic.DRAGON_SCALE_SHIELD, 420);
            case DRAGON_SCALE_ARMOR:
                return new EconomyArtifact(ArtifactStatistic.DRAGON_SCALE_ARMOR, 600);
            case DRAGONBONE_GREAVES:
                return new EconomyArtifact(ArtifactStatistic.DRAGONBONE_GREAVES,  140);
            case DRAGON_WING_TABARD:
                return new EconomyArtifact(ArtifactStatistic.DRAGON_WING_TABARD, 280);
            case NECKLACE_OF_DRAGONTEETH:
                return new EconomyArtifact(ArtifactStatistic.NECKLACE_OF_DRAGONTEETH, 420);
            case CROWN_OF_DRAGONTOOTH:
                return new EconomyArtifact(ArtifactStatistic.CROWN_OF_DRAGONTOOTH, 600);
            case ARMOR_OF_WONDER:
                return new EconomyArtifact(ArtifactStatistic.ARMOR_OF_WONDER, 240);
            case SANDALS_OF_THE_SAINT:
                return new EconomyArtifact(ArtifactStatistic.SANDALS_OF_THE_SAINT, 480);
            case CELESTIAL_NECKLACE_OF_BLISS:
                return new EconomyArtifact(ArtifactStatistic.CELESTIAL_NECKLACE_OF_BLISS, 720);
            case LIONS_SHIELD_OF_COURAGE:
                return new EconomyArtifact(ArtifactStatistic.LIONS_SHIELD_OF_COURAGE,1000);
            case SWORD_OF_JUJEMENT:
                return new EconomyArtifact(ArtifactStatistic.SWORD_OF_JUJEMENT, 1300);
            case HELM_OF_HEAVENLY_ENLIGHTENMENT:
                return new EconomyArtifact(ArtifactStatistic.HELM_OF_HEAVENLY_ENLIGHTENMENT, 2500);
            case BADGE_OF_COURAGE:
                return new EconomyArtifact(ArtifactStatistic.BADGE_OF_COURAGE, 600);
            case CREST_OF_VALOR:
                return new EconomyArtifact(ArtifactStatistic.CREST_OF_VALOR, 600);
            case GLYPH_OF_GALLANTRY:
                return new EconomyArtifact(ArtifactStatistic.GLYPH_OF_GALLANTRY, 600);
            case CLOVER_OF_FORTUNE:
                return new EconomyArtifact(ArtifactStatistic.CLOVER_OF_FORTUNE, 600);
            case CARDS_OF_PROPHECY:
                return new EconomyArtifact(ArtifactStatistic.CARDS_OF_PROPHECY, 600);
            case LADYBIRD_OF_LUCK:
                return new EconomyArtifact(ArtifactStatistic.LADYBIRD_OF_LUCK, 600);
            case STILL_EYE_OF_THE_DRAGON:
                return new EconomyArtifact(ArtifactStatistic.STILL_EYE_OF_THE_DRAGON, 1300);
            case PENDANT_OF_COURAGE:
                return new EconomyArtifact(ArtifactStatistic.PENDANT_OF_COURAGE, 4000);
            case RING_OF_VITALITY:
                return new EconomyArtifact(ArtifactStatistic.RING_OF_VITALITY, 450);
            case RING_OF_LIFE:
                return new EconomyArtifact(ArtifactStatistic.RING_OF_LIFE, 450);
            case VIAL_OF_LIFEBLOOD:
                return new EconomyArtifact(ArtifactStatistic.VIAL_OF_LIFEBLOOD, 900);
            case GARNITURE_OF_INTERFERENCE:
                return new EconomyArtifact(ArtifactStatistic.GARNITURE_OF_INTERFERENCE, 200);
            case SURCOAT_OF_COUNTERPOISE:
                return new EconomyArtifact(ArtifactStatistic.SURCOAT_OF_COUNTERPOISE, 300);
            case BOOTS_OF_POLARITY:
                return new EconomyArtifact(ArtifactStatistic.BOOTS_OF_POLARITY, 400);
            case NECKLACE_OF_SWIFTNESS:
                return new EconomyArtifact(ArtifactStatistic.NECKLACE_OF_SWIFTNESS, 120);
            case RING_OF_THE_WAYFARER:
                return new EconomyArtifact(ArtifactStatistic.RING_OF_THE_WAYFARER, 120);
            case CAPE_OF_VELOCITY:
                return new EconomyArtifact(ArtifactStatistic.CAPE_OF_VELOCITY, 360);


            default:
                    throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }
    }
}
