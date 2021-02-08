package pl.sdk.artifacts;

import pl.sdk.creatures.Creature;
import pl.sdk.spells.SpellEnum;

import java.util.List;

public class ArtifactImmunity extends ArtifactCreatureBuff {
    private final SpellEnum spellName;

    public ArtifactImmunity(ArtifactStatisticIf aStat, SpellEnum aSpellName) {
        stats = aStat;
        this.spellName = aSpellName;
    }

    @Override
    void buffCreature(List<Creature> creatures) {
        creatures.forEach(creature -> creature.addImmunity(spellName));
    }
}
