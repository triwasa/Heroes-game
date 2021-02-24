package pl.sdk.spells.cast.decorators;

import com.google.common.collect.Range;
import pl.sdk.creatures.*;

import java.beans.PropertyChangeEvent;

public class CreatureStatisticDecorator extends Creature {

    private final Creature decorated;
    private final int change;

    public CreatureStatisticDecorator(Creature creature, int aChange) {
        super();
        decorated = creature;
        change = aChange;
    }

    @Override
    public int getAttack() {
        return decorated.getBasicDamage().upperEndpoint() + change;
    }
}

