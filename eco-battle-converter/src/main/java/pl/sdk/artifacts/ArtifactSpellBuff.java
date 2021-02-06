package pl.sdk.artifacts;

import pl.sdk.hero.Hero;
import pl.sdk.spells.Spell;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public abstract class ArtifactSpellBuff extends AbstractArtifact {
    @Override
    public void buff(Hero hero) {
        Set<Spell> spells = hero.getSpells();
        buffSpell(spells);
    }

    abstract void buffSpell(Set<Spell> spells);
}
