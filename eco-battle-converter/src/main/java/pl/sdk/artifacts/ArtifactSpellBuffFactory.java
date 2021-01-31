package pl.sdk.artifacts;

public class ArtifactSpellBuffFactory extends ArtifactAbstractFactory{
    private static final String EXCEPTION_MESSAGE = "There is no artifact with that name";

    @Override
    public ArtifactSpellBuff create(String aName) {
        switch (aName) {
            case "Collar of Conjuring":
                return new ArtifactDuration(ArtifactStatistic.COLLAR_OF_CONJURING, 1);
            case "Ring of Conjuring":
                return new ArtifactDuration(ArtifactStatistic.RING_OF_CONJURING, 2);
            case "Cape of Conjuring":
                return new ArtifactDuration(ArtifactStatistic.CAPE_OF_CONJURING, 3);

            case "Orb of Firmament":
                return new ArtifactDamage(ArtifactStatistic.ORB_OF_THE_FIRMAMENT, 0.5, "AIR");
            case "Orb of Silt":
                return new ArtifactDamage(ArtifactStatistic.ORB_OF_SILT, 0.5, "EARTH");
            case "Orb of Tempstuous Fire":
                return new ArtifactDamage(ArtifactStatistic.ORB_OF_TEMPSTUOUS_FIRE, 0.5, "FIRE");
            case "Orb of Driving Rain":
                return new ArtifactDamage(ArtifactStatistic.ORB_OF_DRIVING_RAIN, 0.5, "WATER");
            case "Tome of Air Magic":
                return new ArtifactSpellBook(ArtifactStatistic.TOME_OF_AIR_MAGIC, "AIR");
            case "Tome of Earth Magic":
                return new ArtifactSpellBook(ArtifactStatistic.TOME_OF_EARTH_MAGIC, "EARTH");
            case "Tome of Fire Magic":
                return new ArtifactSpellBook(ArtifactStatistic.TOME_OF_FIRE_MAGIC, "FIRE");
            case "Tome of Water Magic":
                return new ArtifactSpellBook(ArtifactStatistic.TOME_OF_WATER_MAGIC, "WATER");


            default:
                throw new IllegalArgumentException(EXCEPTION_MESSAGE);

        }
    }
}
