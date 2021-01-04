package pl.sdk.artifacts;

public class Artifact {
    private final ArtifactStatisticIf stats;

    public Artifact(ArtifactStatisticIf aStats) {
        this.stats = aStats;
    }

    public String getSlotName() { return stats.getSlotName(); }
}
