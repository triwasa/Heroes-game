package pl.sdk.artifacts;

public class ArtifactDamage extends ArtifactSpellBuff {
    private final double damageValue;
    private final String spellType;

    public ArtifactDamage(ArtifactStatisticIf aStat, double aDamageValue, String aSpellType) {
        stats = aStat;
        this.damageValue = aDamageValue;
        this.spellType = aSpellType;
    }

    @Override
    void buffSpell(List<Spell> spells) {
        // TODO implement buffing damage of spells
    }
}
