package pl.sdk.artifacts;

import pl.sdk.creatures.Creature;
import pl.sdk.hero.Hero;

import java.util.List;

public abstract class ArtifactCreatureBuff extends AbstractArtifact {
    @Override
    public void buff(Hero hero) {
        List<Creature> creatures = hero.getCreatures();
        buffCreature(creatures);
    }

    abstract void buffCreature(List<Creature> creatures);
}
