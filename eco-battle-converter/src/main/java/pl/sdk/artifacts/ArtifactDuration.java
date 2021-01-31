package pl.sdk.artifacts;

public class ArtifactDuration extends ArtifactSpellBuff {
    private final int durationValue;

    public ArtifactDuration(ArtifactStatisticIf aStat, int aDurationValue) {
        stats = aStat;
        this.durationValue = aDurationValue;
    }

    @Override
    void buffSpell(List<Spell> spells) {
        // TODO implement buffing duration of spells
    }
}
