package pl.sdk.artifacts;

import pl.sdk.spells.Spell;
import pl.sdk.spells.SpellEnum;

import java.util.List;
import java.util.Set;

public class ArtifactDuration extends ArtifactSpellBuff {
    private final int durationValue;

    public ArtifactDuration(ArtifactStatisticIf aStat, int aDurationValue) {
        stats = aStat;
        this.durationValue = aDurationValue;
    }

    @Override
    void buffSpell(Set<Spell> spells) {
        spells.forEach(spell -> {
            if (checkSpell(spell)) {
                // TODO increase duration of Spell
            }
        });
    }

    private boolean checkSpell(Spell spell) {
        return false; // (spell.getType() == SpellEnum.typeOfSpell.BUFF);
    }
}
