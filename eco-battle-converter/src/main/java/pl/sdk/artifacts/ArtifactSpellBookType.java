package pl.sdk.artifacts;

public class ArtifactSpellBookType extends ArtifactSpellBuff {
    private final String spellType;

    public ArtifactSpellBookType(ArtifactStatisticIf aStat, String aSpellType) {
        stats = aStat;
        this.spellType = aSpellType;
    }

    @Override
    void buffSpell(List<Spell> spells) {
        // TODO implement adding spells
    }
}
