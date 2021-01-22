package pl.sdk.artifacts;

public class EconomyArtifactPrimaryFactory {

    private static final String EXCEPTION_MESSAGE = "There is no artifact with that name";

    public EconomyArtifact create(String aName){
        switch (aName) {
            case "Centaur's Ax":
                return new EconomyArtifact(ArtifactStatistic.CENTAURS_AX, 120);
            case "Blackshard of the Dead Knight":
                return new EconomyArtifact(ArtifactStatistic.BLACKSHARD_OF_THE_DEAD_KNIGHT, 200);
            case "Greater Gnoll's Flail":
                return new EconomyArtifact(ArtifactStatistic.GREATER_GNOLLS_FLAIL, 300);
            case "Ogre's Club of Havoc":
                return new EconomyArtifact(ArtifactStatistic.OGRES_CLUB_OF_HOVOC, 490);
            case "Sword of Hellfire":
                return new EconomyArtifact(ArtifactStatistic.SWORD_OF_HELLFIRE, 630);
            case "Titan's Gladius":
                return new EconomyArtifact(ArtifactStatistic.TITANS_GLADIUS, 1400);
            case "Shield of the Dwarven Lords":
                return new EconomyArtifact(ArtifactStatistic.SHIELD_OF_THE_DWARVEN_LORDS, 120);
            case "Shield of the Yawning Dead":
                return new EconomyArtifact(ArtifactStatistic.SHIELD_OF_THE_YAWNING_DEAD, 200);
            case "Buckler of the Gnoll King":
                return new EconomyArtifact(ArtifactStatistic.BUCKLER_OF_THE_GNOLL_KING, 300);
            case "Targ of the Rampaging Ogre":
                return new EconomyArtifact(ArtifactStatistic.TARG_OF_THE_RAMPAGING_OGRE, 490);
            case "Shield of the Damned":
                return new EconomyArtifact(ArtifactStatistic.SHIELD_OF_THE_DAMNED, 630);
            case "Sentinel's Shield":
                return new EconomyArtifact(ArtifactStatistic.SENTINELS_SHIELD, 1400);
            case "Breastplate of Petrified Wood":
                return new EconomyArtifact(ArtifactStatistic.BREASTPLATE_OF_PETRIFIED_WOOD, 150);
            case "Rib Cage":
                return new EconomyArtifact(ArtifactStatistic.RIB_CAGE, 250);
            case "Scales of the Greater Basilisk":
                return new EconomyArtifact(ArtifactStatistic.SCALES_OF_THE_GREATER_BASILISK, 390);
            case "Tunic of the Cyclops King":
                return new EconomyArtifact(ArtifactStatistic.TUNIC_OF_THE_CYCLOPS_KING, 500);
            case "Breastplate of Brimstone":
                return new EconomyArtifact(ArtifactStatistic.BREASTPLATE_OF_BRIMSTONE, 700);
            case "Titan's Cuiras":
                return new EconomyArtifact(ArtifactStatistic.TITANS_CUIRAS, 1400);
            case "Helm of the Alabaster Unicorn":
                return new EconomyArtifact(ArtifactStatistic.HELM_OF_THE_ALABASTER_UNICORN, 150);
            case "Skull Helmet":
                return new EconomyArtifact(ArtifactStatistic.SKULL_HELMET, 320);
            case "Helm of Chaos":
                return new EconomyArtifact(ArtifactStatistic.HELM_OF_CHAOS, 430);
            case "Crown of the Supreme Magi":
                return new EconomyArtifact(ArtifactStatistic.CROWN_OF_THE_SUPREME_MAGI, 600);
            case "Hellstorm Helmet":
                return new EconomyArtifact(ArtifactStatistic.HELLSTORM_HELMET, 790);
            case "Thunder Helmet":
                return new EconomyArtifact(ArtifactStatistic.THUNDER_HELMET, 1400);
            case "Quiet Eye of the Dragon":
                return new EconomyArtifact(ArtifactStatistic.QUIET_EYE_OF_THE_DRAGON, 140);
            case "Red Dragon Flame Tongue":
                return new EconomyArtifact(ArtifactStatistic.RED_DRAGON_FLAME_TONGUE, 280);
            case "Dragon Scale Shield":
                return new EconomyArtifact(ArtifactStatistic.DRAGON_SCALE_SHIELD, 420);
            case "Dragon Scale Armor":
                return new EconomyArtifact(ArtifactStatistic.DRAGON_SCALE_ARMOR, 600);
            case "Dragonbone Greaves":
                return new EconomyArtifact(ArtifactStatistic.DRAGONBONE_GREAVES,  140);
            case "Dragon Wing Tabard":
                return new EconomyArtifact(ArtifactStatistic.DRAGON_WING_TABARD, 280);
            case "Necklace of Dragonteeth":
                return new EconomyArtifact(ArtifactStatistic.NECKLACE_OF_DRAGONTEETH, 420);
            case "Crown of Dragontooth":
                return new EconomyArtifact(ArtifactStatistic.CROWN_OF_DRAGONTOOTH, 600);
            case "Armor of Wonder":
                return new EconomyArtifact(ArtifactStatistic.ARMOR_OF_WONDER, 240);
            case "Sandals of the Saint":
                return new EconomyArtifact(ArtifactStatistic.SANDALS_OF_THE_SAINT, 480);
            case "Celestial Necklace of Bliss":
                return new EconomyArtifact(ArtifactStatistic.CELESTIAL_NECKLACE_OFBLISS, 720);
            case "Lion's Shield of Courage":
                return new EconomyArtifact(ArtifactStatistic.LIONS_SHIELD_OF_COURAGE,1000);
            case "Sword of Judjement":
                return new EconomyArtifact(ArtifactStatistic.SWORD_OF_JUJEMENT, 1300);
            case "Helm of Heavenly Enlightenment":
                return new EconomyArtifact(ArtifactStatistic.HELM_OF_HEAVENLY_ENLIGHTENMENT, 1800);
            default:
                    throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }
    }
}
