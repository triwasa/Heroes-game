package pl.sdk.spells.cast;

import pl.sdk.creatures.Creature;
import pl.sdk.hero.Hero;
import pl.sdk.spells.Spell;
import pl.sdk.spells.SpellEnum;
import pl.sdk.spells.cast.decorators.CreatureStatisticDecorator;

import java.util.List;

public class ChangeStatisticBySpellStrategy implements CastSpellStrategy {

    @Override
    public Creature castSpell(Creature creature, Spell spell, Hero owner) {
        if (spell.getTechName().equals(SpellEnum.BLESS)) {
            creature = new CreatureStatisticDecorator(creature, 0);
        }
        if (spell.getTechName().equals(SpellEnum.BLESS2)) {
            creature = new CreatureStatisticDecorator(creature, 1);
        }
        if (spell.getTechName().equals(SpellEnum.BLESS3)) {
            creature = new CreatureStatisticDecorator(creature, 1);
        }
        return creature;
    }
}
