package pl.sdk.artifacts;

public class ArtifactHealth extends ArtifactCreatureBuff {
    private final int hpValue;

    public ArtifactHealth(ArtifactStatisticIf aStat, int aHpValue) {
        stats = aStat;
        this.hpValue = aHpValue;
    }

    @Override
    void buffCreature(List<Creature> creatures) {
        for (creature: creatures) {
            creature.increaseHealth(hpValue);
        }
    }
}
