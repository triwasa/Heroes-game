package pl.sdk.artifacts;

public class EconomyArtifact {

    private final ArtifactStatisticIf stats;
    private final int goldCost;


    public EconomyArtifact(ArtifactStatistic aStats, int aGoldCost) {
        this.stats = aStats;
        this.goldCost = aGoldCost;
    }

    public int getGoldCost() { return goldCost; }

    public String getName() { return stats.getTranslatedName(); }

}
