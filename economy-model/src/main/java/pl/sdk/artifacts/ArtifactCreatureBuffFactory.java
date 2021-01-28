package pl.sdk.artifacts;

public class ArtifactCreatureBuffFactory  extends  ArtifactAbstractFactory {
    private static final String EXCEPTION_MESSAGE = "There is no artifact with that name";

    @Override
    public ArtifactCreatureBuff create(String aName) {
        switch (aName) {
            case "Ring of Vitality":
                return new ArtifactHealth(ArtifactStatistic.RING_OF_VITALITY, 1);
            case "Ring of Life":
                return new ArtifactHealth(ArtifactStatistic.RING_OF_LIFE, 1);
            case "Vial of Lifeblood":
                return new ArtifactHealth(ArtifactStatistic.VIAL_OF_LIFEBLOOD, 2);
            case "Garniture of Interference":
                return new ArtifactResistance(ArtifactStatistic.GARNITURE_OF_INTERFERENCE, 0.05);
            case "Surcoat of Counterpoise":
                return new ArtifactResistance(ArtifactStatistic.SURCOAT_OF_COUNTERPOISE, 0.1);
            case "Boots of Polarity":
                return new ArtifactResistance(ArtifactStatistic.BOOTS_OF_POLARITY, 0.15);
            case "Necklace of Swiftness":
                return new ArtifactSpeed(ArtifactStatistic.NECKLACE_OF_SWIFTNESS, 1);
            case "Ring of the Wayfarer":
                return new ArtifactSpeed(ArtifactStatistic.RING_OF_THE_WAYFARER, 1);
            case "Cape of Velocity":
                return new ArtifactSpeed(ArtifactStatistic.CAPE_OF_VELOCITY, 2);

            default:
                throw new IllegalArgumentException(EXCEPTION_MESSAGE);

        }
    }
}
