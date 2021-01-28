package pl.sdk.artifacts;

class ArtifactPrimary extends AbstractArtifact {

    private final PrimaryStatisticIf primaryStats;

    public ArtifactPrimary(ArtifactStatisticIf aStats, PrimaryStatisticIf aPrimaryStats) {
        stats = aStats;
        this.primaryStats = aPrimaryStats;
    }

    public String getSlotName() { return stats.getSlotName(); }

    public int getAttack() { return primaryStats.getAttack(); }

    public int getDefence() { return primaryStats.getDefence(); }

    public int getSpellPower() { return primaryStats.getSpellPower(); }

    public int getKnowledge() { return primaryStats.getKnowledge(); }

    @Override
    void buff(Hero hero) {
        increaseHeroStatistic(Hero hero);
    }

    void increaseHeroStatistic(Hero hero){
        hero.increaseAttack(getAttack());
        hero.increaseDefence(getDefence());
        hero.increaseSpellPower(getSpellPower());
        hero.increaseKnowledge(getKnowledge());
    }

}
