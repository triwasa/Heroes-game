package pl.sdk.artifacts;

import pl.sdk.hero.Hero;
import pl.sdk.heroClass.HeroClassStatisticIf;

class ArtifactPrimary extends AbstractArtifact {

    private final HeroClassStatisticIf primaryStats;

    public ArtifactPrimary(ArtifactStatisticIf aStats, HeroClassStatisticIf aPrimaryStats) {
        stats = aStats;
        this.primaryStats = aPrimaryStats;
    }

    @Override
    void buff(Hero hero) {
        increaseHeroStatistic(hero);
    }

    void increaseHeroStatistic(Hero hero){
//        hero.increaseStats(primaryStats);
    }

}
