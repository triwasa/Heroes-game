package pl.sdk.artifacts;

public class ArtifactSpellBookTier extends ArtifactSpellBuff {
    private final int tier;

    public ArtifactSpellBookTier(ArtifactStatistic aStat, int aTier) {
        stats = aStat;
        this.tier = aTier;
    }

    @Override
    void buffSpell(List<Spell> spells) {
        // TODO create all spell of $tier level and add them to hero
    }
}
