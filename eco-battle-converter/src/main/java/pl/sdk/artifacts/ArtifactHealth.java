package pl.sdk.artifacts;

import pl.sdk.creatures.Creature;

import java.util.List;

public class ArtifactHealth extends ArtifactCreatureBuff {
    private final int hpValue;

    public ArtifactHealth(ArtifactStatisticIf aStat, int aHpValue) {
        stats = aStat;
        this.hpValue = aHpValue;
    }

    @Override
    void buffCreature(List<Creature> creatures) {

    }
}
