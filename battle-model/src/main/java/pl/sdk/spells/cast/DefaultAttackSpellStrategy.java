package pl.sdk.spells.cast;

import pl.sdk.creatures.Creature;
import pl.sdk.hero.Hero;
import pl.sdk.spells.Spell;

import java.util.List;

public class DefaultAttackSpellStrategy implements CastSpellStrategy {

    @Override
    public Creature castSpell(Creature creature, Spell spell, Hero owner) {
        switch (spell.getTechName()) {
            case MAGIC_ARROW_AIR:
                creature.applyDamage((owner.getPower() * 10) + spell.getLevel() * 10);
            case MAGIC_ARROW_AIR2:
                creature.applyDamage((owner.getPower() * 10) + spell.getLevel() * 20);
            case MAGIC_ARROW_AIR3:
                creature.applyDamage((owner.getPower() * 10) + spell.getLevel() * 30);
            case ICE_BOLD:
                creature.applyDamage((owner.getPower() * 20) + spell.getLevel() * 10);
            case ICE_BOLD2:
                creature.applyDamage((owner.getPower() * 20) + spell.getLevel() * 20);
            case ICE_BOLD3:
                creature.applyDamage((owner.getPower() * 20) + spell.getLevel() * 50);
            case FROST_RING:
                creature.applyDamage((owner.getPower() * 10) + spell.getLevel() * 15);
            case FROST_RING2:
                creature.applyDamage((owner.getPower() * 10) + spell.getLevel() * 30);
            case FROST_RING3:
                creature.applyDamage((owner.getPower() * 10) + spell.getLevel() * 60);
            default:
                break;
        }
        return creature;
    }

}