package pl.sdk.artifacts;

import pl.sdk.hero.Hero;

public abstract class ArtifactSpellBuff extends AbstractArtifact {
    @Override
    void buff(Hero hero) {
        List<Spell> spells = hero.getSpells();
        buffSpell(spells);
    }

    abstract void buffSpell(List<Spell> spells);
}
