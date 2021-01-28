package pl.sdk.artifacts;

public class ArtifactSpeed extends ArtifactCreatureBuff {
    private final int speedValue;

    public ArtifactSpeed(ArtifactStatisticIf aStat, int aSpeedValue) {
        stats = aStat;
        this.speedValue = aSpeedValue;
    }

    @Override
    void buffCreature(List<Creature> creatures) {
        for (creature: creatures) {
            creature.increaseHealth(speedValue);
        }
    }
}
