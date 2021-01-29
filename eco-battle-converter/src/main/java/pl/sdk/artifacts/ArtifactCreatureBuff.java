package pl.sdk.artifacts;

import pl.sdk.converter.Hero;
import pl.sdk.creatures.Creature;

import java.util.List;

public abstract class ArtifactCreatureBuff extends AbstractArtifact {
    @Override
    void buff(Hero hero) {
        // TODO wyciąganie listy kreatur
        buffCreature(List<Creature> creatures);
    }

    abstract void buffCreature(List<Creature> creatures);
}
