package pl.sdk.artifacts;

public class ArtifactPrimary1Factory extends ArtifactAbstractFactory {

    private static final String EXCEPTION_MESSAGE = "There is no artifact with that name";

    public Artifact create(String aName){
        switch (aName) {
            case "Centaur's Ax":
                return new Artifact(ArtifactStatistic.CENTAURS_AX, ArtifactPrimaryStatistic.CENTAURS_AX);
            case "Blackshard of the Dead Knight":
                return new Artifact(ArtifactStatistic.BLACKSHARD_OF_THE_DEAD_KNIGHT, ArtifactPrimaryStatistic.BLACKSHARD_OF_THE_DEAD_KNIGHT);
            case "Greater Gnoll's Flail":
                return new Artifact(ArtifactStatistic.GREATER_GNOLLS_FLAIL, ArtifactPrimaryStatistic.GREATER_GNOLLS_FLAIL);
            case "Ogre's Club of Havoc":
                return new Artifact(ArtifactStatistic.OGRES_CLUB_OF_HOVOC, ArtifactPrimaryStatistic.OGRES_CLUB_OF_HOVOC);
            case "Sword of Hellfire":
                return new Artifact(ArtifactStatistic.SWORD_OF_HELLFIRE, ArtifactPrimaryStatistic.SWORD_OF_HELLFIRE);
            case "Titan's Gladius":
                return new Artifact(ArtifactStatistic.TITANS_GLADIUS, ArtifactPrimaryStatistic.TITANS_GLADIUS);
            case "Shield of the Dwarven Lords":
                return new Artifact(ArtifactStatistic.SHIELD_OF_THE_DWARVEN_LORDS, ArtifactPrimaryStatistic.SHIELD_OF_THE_DWARVEN_LORDS);
            case "Shield of the Yawning Dead":
                return new Artifact(ArtifactStatistic.SHIELD_OF_THE_YAWNING_DEAD, ArtifactPrimaryStatistic.SHIELD_OF_THE_YAWNING_DEAD);
            case "Buckler of the Gnoll King":
                return new Artifact(ArtifactStatistic.BUCKLER_OF_THE_GNOLL_KING, ArtifactPrimaryStatistic.BUCKLER_OF_THE_GNOLL_KING);
            case "Targ of the Rampaging Ogre":
                return new Artifact(ArtifactStatistic.TARG_OF_THE_RAMPAGING_OGRE, ArtifactPrimaryStatistic.TARG_OF_THE_RAMPAGING_OGRE);
            case "Shield of the Damned":
                return new Artifact(ArtifactStatistic.SHIELD_OF_THE_DAMNED, ArtifactPrimaryStatistic.SHIELD_OF_THE_DAMNED);
            case "Sentinel's Shield":
                return new Artifact(ArtifactStatistic.SENTINELS_SHIELD, ArtifactPrimaryStatistic.SENTINELS_SHIELD);
            case "Breastplate of Petrified Wood":
                return new Artifact(ArtifactStatistic.BREASTPLATE_OF_PETRIFIED_WOOD, ArtifactPrimaryStatistic.BREASTPLATE_OF_PETRIFIED_WOOD);
            case "Rib Cage":
                return new Artifact(ArtifactStatistic.RIB_CAGE, ArtifactPrimaryStatistic.RIB_CAGE);
            case "Scales of the Greater Basilisk":
                return new Artifact(ArtifactStatistic.SCALES_OF_THE_GREATER_BASILISK, ArtifactPrimaryStatistic.SCALES_OF_THE_GREATER_BASILISK);
            case "Tunic of the Cyclops King":
                return new Artifact(ArtifactStatistic.TUNIC_OF_THE_CYCLOPS_KING, ArtifactPrimaryStatistic.TUNIC_OF_THE_CYCLOPS_KING);
            case "Breastplate of Brimstone":
                return new Artifact(ArtifactStatistic.BREASTPLATE_OF_BRIMSTONE, ArtifactPrimaryStatistic.BREASTPLATE_OF_BRIMSTONE);
            case "Titan's Cuiras":
                return new Artifact(ArtifactStatistic.TITANS_CUIRAS, ArtifactPrimaryStatistic.TITANS_CUIRAS);
            case "Helm of the Alabaster Unicorn":
                return new Artifact(ArtifactStatistic.HELM_OF_THE_ALABASTER_UNICORN, ArtifactPrimaryStatistic.HELM_OF_THE_ALABASTER_UNICORN);
            case "Skull Helmet":
                return new Artifact(ArtifactStatistic.SKULL_HELMET, ArtifactPrimaryStatistic.SKULL_HELMET);
            case "Helm of Chaos":
                return new Artifact(ArtifactStatistic.HELM_OF_CHAOS, ArtifactPrimaryStatistic.HELM_OF_CHAOS);
            case "Crown of the Supreme Magi":
                return new Artifact(ArtifactStatistic.CROWN_OF_THE_SUPREME_MAGI, ArtifactPrimaryStatistic.CROWN_OF_THE_SUPREME_MAGI);
            case "Hellstorm Helmet":
                return new Artifact(ArtifactStatistic.HELLSTORM_HELMET, ArtifactPrimaryStatistic.HELLSTORM_HELMET);
            case "Thunder Helmet":
                return new Artifact(ArtifactStatistic.THUNDER_HELMET, ArtifactPrimaryStatistic.THUNDER_HELMET);
            default:
                throw new IllegalArgumentException(EXCEPTION_MESSAGE);

        }
    }
}
