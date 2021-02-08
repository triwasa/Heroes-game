package pl.sdk.artifacts;

import pl.sdk.spells.Spell;
import pl.sdk.spells.SpellEnum;

import java.util.List;
import java.util.Set;

public class ArtifactDamage extends ArtifactSpellBuff {
    private final double damageValue;
    private final SpellEnum.magicTypeOfSpell spellType;

    public ArtifactDamage(ArtifactStatisticIf aStat, double aDamageValue, SpellEnum.magicTypeOfSpell aSpellType) {
        stats = aStat;
        this.damageValue = aDamageValue;
        this.spellType = aSpellType;
    }

    @Override
    void buffSpell(Set<Spell> spells) {
        spells.forEach(spell -> {
            if (checkSpell(spell)) {
                // TODO increase damage of Spell
            }
        });
    }

    private boolean checkSpell(Spell spell) {
        return false; // (spell.getType() == SpellEnum.typeOfSpell.ATTACK && spell.getMagicType() == spellType);
    }
}
