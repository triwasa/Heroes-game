package pl.sdk.artifacts;

import pl.sdk.creatures.Creature;

import java.util.List;

public class ArtifactImmunity extends ArtifactCreatureBuff {
    private final String spellName;

    public ArtifactImmunity(ArtifactStatisticIf aStat, String aSpellName) {
        stats = aStat;
        this.spellName = aSpellName;
    }

    @Override
    void buffCreature(List<Creature> creatures) {
        creatures.forEach(creature -> creature.addImmunity(spellName));
    }
}
