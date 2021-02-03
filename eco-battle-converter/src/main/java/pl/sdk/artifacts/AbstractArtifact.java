package pl.sdk.artifacts;

import pl.sdk.hero.Hero;

public abstract class AbstractArtifact {
    protected ArtifactStatisticIf stats;

    abstract void buff(Hero hero);

    public String getName(){
        return stats.getTranslatedName();
    }
}
