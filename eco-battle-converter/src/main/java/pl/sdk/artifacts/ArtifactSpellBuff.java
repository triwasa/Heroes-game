package pl.sdk.artifacts;

import pl.sdk.hero.Hero;
import pl.sdk.spells.Spell;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public abstract class ArtifactSpellBuff extends AbstractArtifact {
    @Override
    void buff(Hero hero) {
        Set<Spell> spells = hero.getSpells();
        buffSpell(new ArrayList<>(spells));
    }

    abstract void buffSpell(List<Spell> spells);
}
