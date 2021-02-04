package pl.sdk.artifacts;

import pl.sdk.creatures.Creature;

import java.util.List;

public class ArtifactSpeed extends ArtifactCreatureBuff {
    private final int speedValue;

    public ArtifactSpeed(ArtifactStatisticIf aStat, int aSpeedValue) {
        stats = aStat;
        this.speedValue = aSpeedValue;
    }

    @Override
    void buffCreature(List<Creature> creatures) {
//        creatures.forEach(creature -> creature.increaseSpeed(speedValue));
    }
}
