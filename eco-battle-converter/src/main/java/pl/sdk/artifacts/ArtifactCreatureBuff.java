package pl.sdk.artifacts;

import pl.sdk.converter.Hero;
import pl.sdk.creatures.Creature;

import java.util.List;

public abstract class ArtifactCreatureBuff extends AbstractArtifact {
    @Override
    void buff(Hero hero) {
        List<Creature> creatures = hero.getCreatures();
        buffCreature(creatures);
    }

    abstract void buffCreature(List<Creature> creatures);
}
