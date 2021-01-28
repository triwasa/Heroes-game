package pl.sdk.artifacts;

public abstract class AbstractArtifact {
    protected ArtifactStatisticIf stats;

    abstract void buff(Hero hero);

    public String getName(){
        return stats.getTranslatedName();
    }
}
