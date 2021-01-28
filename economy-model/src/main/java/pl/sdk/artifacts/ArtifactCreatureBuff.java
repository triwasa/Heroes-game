package pl.sdk.artifacts;

public abstract class ArtifactCreatureBuff extends AbstractArtifact {
    @Override
    void buff(Hero hero) {
        // TODO wyciąganie listy kreatur
        buffCreature(List<Creature> creatures);
    }

    abstract void buffCreature(List<Creature> creatures);
}
