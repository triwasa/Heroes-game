package pl.sdk.artifacts;

class Artifact {

    private final ArtifactStatisticIf stats;
    private final PrimaryStatisticIf primaryStats;

    public Artifact(ArtifactStatisticIf aStats,PrimaryStatisticIf aPrimaryStats) {
        this.stats = aStats;
        this.primaryStats = aPrimaryStats;
    }

    public String getSlotName() { return stats.getSlotName(); }

    public int getAttack() { return primaryStats.getAttack(); }

    public int getDefence() { return primaryStats.getDefence(); }

    public int getSpellPower() { return primaryStats.getSpellPower(); }

    public int getKnowledge() { return primaryStats.getKnowledge(); }
}
