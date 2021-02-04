package pl.sdk.artifacts;

import pl.sdk.creatures.Creature;

import java.util.List;

public class ArtifactResistance extends ArtifactCreatureBuff {
    private final int resistanceValue;

    public ArtifactResistance(ArtifactStatisticIf aStat, int aResistanceValue) {
        stats = aStat;
        this.resistanceValue = aResistanceValue;
    }

    @Override
    void buffCreature(List<Creature> creatures) {
        creatures.forEach(creature -> creature.increaseResistance(resistanceValue));
    }
}
