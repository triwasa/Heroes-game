package pl.sdk;

import com.google.common.collect.Range;
import org.junit.jupiter.api.Test;

import java.beans.PropertyChangeEvent;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

public class EndOfTurnTests {

    @Test
    void shouldResetCounterAttackFlagAfterEndOfTurn(){
        Creature attacker = new Creature.Builder()
                .name("Name")
                .attack(2)
                .armor(1)
                .maxHp(10)
                .moveRange(1)
                .damage(Range.closed(2,2))
                .build();
        Creature defender = new Creature.Builder()
                .name("Name")
                .attack(2)
                .armor(1)
                .maxHp(10)
                .moveRange(1)
                .damage(Range.closed(2,2))
                .build();
        GameEngine engine = new GameEngine(List.of(attacker), List.of(defender));

        assertEquals(true, defender.canCounterAttack());
        attacker.attack(defender);
        assertEquals(false, defender.canCounterAttack());

        engine.pass();
        engine.pass();
        assertEquals(true, defender.canCounterAttack());
    }

    @Test
    void shouldCallPropertyChangeAfterEndOfTurn(){
        Creature attacker = spy(Creature.class);
        Creature defender = new Creature.Builder()
                .name("Name")
                .attack(2)
                .armor(1)
                .maxHp(10)
                .moveRange(1)
                .damage(Range.closed(2,2))
                .build();
        GameEngine engine = new GameEngine(List.of(attacker), List.of(defender));

        engine.pass();
        engine.pass();
        verify(attacker).propertyChange(any(PropertyChangeEvent.class));
    }
}
