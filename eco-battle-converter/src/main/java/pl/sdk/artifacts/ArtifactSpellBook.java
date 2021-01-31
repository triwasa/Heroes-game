package pl.sdk.artifacts;

public class ArtifactSpellBook extends ArtifactSpellBuff {
    private final String spellType;

    public ArtifactSpellBook(ArtifactStatisticIf aStat, String aSpellType) {
        stats = aStat;
        this.spellType = aSpellType;
    }

    @Override
    void buffSpell(List<Spell> spells) {
        // TODO implement adding spells
    }
}
