package pl.sdk.special_fields;

import pl.sdk.creatures.BattleObject;
import pl.sdk.creatures.Creature;
import pl.sdk.spells.Spell;
import pl.sdk.spells.SpellFactory;

import java.util.Random;

public class FieldsApplyModifyStatisticStrategy implements FieldsApplyStrategy {
    @Override
    public void apply(BattleObject creature) {

        if ( !(creature instanceof Creature)) {
            return;
        }
        Creature charmCreature = (Creature) creature;

        Random random = new Random();
        switch (random.nextInt(4)) {
            case 0:
                charmCreature.increaseHealth(5);
                break;
            case 1:
                charmCreature.increaseHealth(-2);
                break;
            case 2:
                charmCreature.increaseSpeed(1);
                break;
            case 3:
                charmCreature.increaseSpeed(-1);
                break;
        }
    }
}
