package pl.sdk.artifacts;

import static pl.sdk.artifacts.ArtifactName.*;

public class ArtifactSpellBuffFactory extends ArtifactAbstractFactory{
    private static final String EXCEPTION_MESSAGE = "There is no artifact with that name";
    private static final String AIR = "AIR";
    private static final String EARTH = "EARTH";
    private static final String FIRE = "FIRE";
    private static final String WATER = "WATER";

    @Override
    public ArtifactSpellBuff create(String aName) {
        switch (aName) {
            case COLLAR_OF_CONJURING:
                return new ArtifactDuration(ArtifactStatistic.COLLAR_OF_CONJURING, 1);
            case RING_OF_CONJURING:
                return new ArtifactDuration(ArtifactStatistic.RING_OF_CONJURING, 2);
            case CAPE_OF_CONJURING:
                return new ArtifactDuration(ArtifactStatistic.CAPE_OF_CONJURING, 3);
            case ORB_OF_THE_FIRMAMENT:
                return new ArtifactDamage(ArtifactStatistic.ORB_OF_THE_FIRMAMENT, 0.5, AIR);
            case ORB_OF_SILT:
                return new ArtifactDamage(ArtifactStatistic.ORB_OF_SILT, 0.5, EARTH);
            case ORB_OF_TEMPSTUOUS_FIRE:
                return new ArtifactDamage(ArtifactStatistic.ORB_OF_TEMPSTUOUS_FIRE, 0.5, FIRE);
            case ORB_OF_DRIVING_RAIN:
                return new ArtifactDamage(ArtifactStatistic.ORB_OF_DRIVING_RAIN, 0.5, WATER);
            case TOME_OF_AIR_MAGIC:
                return new ArtifactSpellBookType(ArtifactStatistic.TOME_OF_AIR_MAGIC, AIR);
            case TOME_OF_EARTH_MAGIC:
                return new ArtifactSpellBookType(ArtifactStatistic.TOME_OF_EARTH_MAGIC, EARTH);
            case TOME_OF_FIRE_MAGIC:
                return new ArtifactSpellBookType(ArtifactStatistic.TOME_OF_FIRE_MAGIC, FIRE);
            case TOME_OF_WATER_MAGIC:
                return new ArtifactSpellBookType(ArtifactStatistic.TOME_OF_WATER_MAGIC, WATER);
            case SPELLBINDERS_HAT:
                return new ArtifactSpellBookTier(ArtifactStatistic.SPELLBINDERS_HAT, 5);


            default:
                throw new IllegalArgumentException(EXCEPTION_MESSAGE);

        }
    }
}
