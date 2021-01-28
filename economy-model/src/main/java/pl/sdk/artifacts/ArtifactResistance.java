package pl.sdk.artifacts;

public class ArtifactResistance extends ArtifactCreatureBuff {
    private final double resistanceValue;

    public ArtifactResistance(ArtifactStatisticIf aStat, double aResistanceValue) {
        stats = aStat;
        this.resistanceValue = aResistanceValue;
    }

    @Override
    void buffCreature(List<Creature> creatures) {
        for (creature: creatures) {
            creature.increaseResistance(resistanceValue);
        }
    }
}
