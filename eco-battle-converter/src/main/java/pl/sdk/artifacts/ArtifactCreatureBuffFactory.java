package pl.sdk.artifacts;

import static pl.sdk.artifacts.ArtifactName.*;

public class ArtifactCreatureBuffFactory  extends  ArtifactAbstractFactory {
    private static final String EXCEPTION_MESSAGE = "There is no artifact with that name";
    private static final String BERZERK = "Berzerk";
    private static final String BLIND = "Blind";
    private static final String CURSE = "Curse";
    private static final String DEATH_RIPPLE = "Death Ripple";
    private static final String DESTROY_UNDEAD = "Destroy Undead";
    private static final String HYPNOTIZE = "Hypnotize";
    private static final String LIGHTNING_BOLT = "Lightning Bolt";
    private static final String FORGETFULNESS = "Forgetfulness";
    private static final String DISPEL = "Dispel";

    @Override
    public ArtifactCreatureBuff create(String aName) {
        switch (aName) {
            case RING_OF_VITALITY:
                return new ArtifactHealth(ArtifactStatistic.RING_OF_VITALITY, 1);
            case RING_OF_LIFE:
                return new ArtifactHealth(ArtifactStatistic.RING_OF_LIFE, 1);
            case VIAL_OF_LIFEBLOOD:
                return new ArtifactHealth(ArtifactStatistic.VIAL_OF_LIFEBLOOD, 2);
            case GARNITURE_OF_INTERFERENCE:
                return new ArtifactResistance(ArtifactStatistic.GARNITURE_OF_INTERFERENCE, 5);
            case SURCOAT_OF_COUNTERPOISE:
                return new ArtifactResistance(ArtifactStatistic.SURCOAT_OF_COUNTERPOISE, 10);
            case BOOTS_OF_POLARITY:
                return new ArtifactResistance(ArtifactStatistic.BOOTS_OF_POLARITY, 15);
            case NECKLACE_OF_SWIFTNESS:
                return new ArtifactSpeed(ArtifactStatistic.NECKLACE_OF_SWIFTNESS, 1);
            case RING_OF_THE_WAYFARER:
                return new ArtifactSpeed(ArtifactStatistic.RING_OF_THE_WAYFARER, 1);
            case CAPE_OF_VELOCITY:
                return new ArtifactSpeed(ArtifactStatistic.CAPE_OF_VELOCITY, 2);
            case PENDANT_OF_DISPASSION:
                return new ArtifactImmunity(ArtifactStatistic.PENDANT_OF_DISPASSION, BERZERK);
            case PENDANT_OF_SECOND_SIGHT:
                return new ArtifactImmunity(ArtifactStatistic.PENDANT_OF_SECOND_SIGHT, BLIND);
            case PENDANT_OF_HOLINESS:
                return new ArtifactImmunity(ArtifactStatistic.PENDANT_OF_HOLINESS, CURSE);
            case PENDANT_OF_LIFE:
                return new ArtifactImmunity(ArtifactStatistic.PENDANT_OF_LIFE, DEATH_RIPPLE);
            case PENDANT_OF_DEATH:
                return new ArtifactImmunity(ArtifactStatistic.PENDANT_OF_DEATH, DESTROY_UNDEAD);
            case PENDANT_OF_FREE_WILL:
                return new ArtifactImmunity(ArtifactStatistic.PENDANT_OF_FREE_WILL, HYPNOTIZE);
            case PENDANT_OF_NEGATIVITY:
                return new ArtifactImmunity(ArtifactStatistic.PENDANT_OF_NEGATIVITY, LIGHTNING_BOLT);
            case PENDANT_OF_TOTAL_RECALL:
                return new ArtifactImmunity(ArtifactStatistic.PENDANT_OF_TOTAL_RECALL, FORGETFULNESS);
            case SPHERE_OF_PERMANENCE:
                return new ArtifactImmunity(ArtifactStatistic.SPHERE_OF_PERMANENCE, DISPEL);

            default:
                throw new IllegalArgumentException(EXCEPTION_MESSAGE);

        }
    }
}
