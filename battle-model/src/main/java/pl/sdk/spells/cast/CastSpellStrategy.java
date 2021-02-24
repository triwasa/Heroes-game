package pl.sdk.spells.cast;

import pl.sdk.creatures.Creature;
import pl.sdk.hero.Hero;
import pl.sdk.spells.Spell;

import java.util.List;

public interface CastSpellStrategy {
    Creature castSpell(Creature creature, Spell spell, Hero owner);
}
