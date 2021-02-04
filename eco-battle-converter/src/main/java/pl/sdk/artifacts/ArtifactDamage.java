package pl.sdk.artifacts;

import pl.sdk.spells.Spell;

import java.util.List;

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
