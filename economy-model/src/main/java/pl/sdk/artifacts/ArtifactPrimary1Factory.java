package pl.sdk.artifacts;

public class ArtifactPrimary1Factory {

    private static final String EXCEPTION_MESSAGE = "There is no artifact with that name";

    public Artifact create(String aName){
        switch (aName) {
            case "Centaur's Ax":
                return new Artifact(ArtifactStatistic.CENTAURS_AX, 2, 0,0,0);
            case "Blackshard of the Dead Knight":
                return new Artifact(ArtifactStatistic.BLACKSHARD_OF_THE_DEAD_KNIGHT, 3, 0, 0, 0);
            case "Greater Gnoll's Flail":
                return new Artifact(ArtifactStatistic.GREATER_GNOLLS_FLAIL, 4, 0,0, 0);
            case "Ogre's Club of Havoc":
                return new Artifact(ArtifactStatistic.OGRES_CLUB_OF_HOVOC, 5, 0, 0, 0);
            case "Sword of Hellfire":
                return new Artifact(ArtifactStatistic.SWORD_OF_HELLFIRE, 6, 0, 0, 0);
            case "Titan's Gladius":
                return new Artifact(ArtifactStatistic.TITANS_GLADIUS, 12, -3, 0, 0);
            case "Shield of the Dwarven Lords":
                return new Artifact(ArtifactStatistic.SHIELD_OF_THE_DWARVEN_LORDS, 0, 2, 0, 0);
            case "Shield of the Yawning Dead":
                return new Artifact(ArtifactStatistic.SHIELD_OF_THE_YAWNING_DEAD, 0, 3, 0, 0);
            case "Buckler of the Gnoll King":
                return new Artifact(ArtifactStatistic.BUCKLER_OF_THE_GNOLL_KING, 0, 4, 0, 0);
            case "Targ of the Rampaging Ogre":
                return new Artifact(ArtifactStatistic.TARG_OF_THE_RAMPAGING_OGRE, 0,5,0,0);
            case "Shield of the Damned":
                return new Artifact(ArtifactStatistic.SHIELD_OF_THE_DAMNED, 0, 6,0,0);
            case "Sentinel's Shield":
                return new Artifact(ArtifactStatistic.SENTINELS_SHIELD, -3,12,0,0);
            case "Breastplate of Petrified Wood":
                return new Artifact(ArtifactStatistic.BREASTPLATE_OF_PETRIFIED_WOOD, 0,0,1,0);
            case "Rib Cage":
                return new Artifact(ArtifactStatistic.RIB_CAGE, 0,0,2,0);
            case "Scales of the Greater Basilisk":
                return new Artifact(ArtifactStatistic.SCALES_OF_THE_GREATER_BASILISK, 0,0,3,0);
            case "Tunic of the Cyclops King":
                return new Artifact(ArtifactStatistic.TUNIC_OF_THE_CYCLOPS_KING, 0,0,4,0);
            case "Breastplate of Brimstone":
                return new Artifact(ArtifactStatistic.BREASTPLATE_OF_BRIMSTONE, 0,0,5,0);
            case "Titan's Cuiras":
                return new Artifact(ArtifactStatistic.TITANS_CUIRAS, 0,0,10,-2);
            case "Helm of the Alabaster Unicorn":
                return new Artifact(ArtifactStatistic.HELM_OF_THE_ALABASTER_UNICORN, 0,0,0,1);
            case "Skull Helmet":
                return new Artifact(ArtifactStatistic.SKULL_HELMET, 0,0,0,2);
            case "Helm of Chaos":
                return new Artifact(ArtifactStatistic.HELM_OF_CHAOS, 0,0,0,3);
            case "Crown of the Supreme Magi":
                return new Artifact(ArtifactStatistic.CROWN_OF_THE_SUPREME_MAGI, 0,0,0,4);
            case "Hellstorm Helmet":
                return new Artifact(ArtifactStatistic.HELLSTORM_HELMET, 0,0,0,5);
            case "Thunder Helmet":
                return new Artifact(ArtifactStatistic.THUNDER_HELMET, 0,0,-2,10);
            default:
                throw new IllegalArgumentException(EXCEPTION_MESSAGE);

        }
    }
}
