package pl.sdk;

import org.junit.jupiter.api.Test;

import pl.sdk.creatures.Creature;
import pl.sdk.creatures.NecropolisFactory;
import pl.sdk.hero.Hero;

import java.beans.PropertyChangeEvent;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

public class EndOfTurnTests {

    @Test
    void shouldResetCounterAttackFlagAfterEndOfTurn(){
        Creature attacker = NecropolisFactory.createDefaultForTests();
        Creature defender = NecropolisFactory.createDefaultForTests();
        Hero hero1 = new Hero();
        hero1.addCreatures(List.of(attacker));
        Hero hero2 = new Hero();
        hero2.addCreatures(List.of(defender));
        GameEngine engine = new GameEngine(hero1,hero2 , new Board());

        assertEquals(true, defender.canCounterAttack());
        attacker.getAttackStrategy().attack(attacker,defender);
        assertEquals(false, defender.canCounterAttack());

        engine.pass();
        engine.pass();
        assertEquals(true, defender.canCounterAttack());
    }

    @Test
    void shouldCallPropertyChangeAfterEndOfTurn(){
        Creature attacker = spy(Creature.class);
        Creature defender = NecropolisFactory.createDefaultForTests();
        Hero hero1 = new Hero();
        hero1.addCreatures(List.of(attacker));
        Hero hero2 = new Hero();
        hero2.addCreatures(List.of(defender));
        GameEngine engine = new GameEngine(hero1,hero2, new Board());

        engine.pass();
        engine.pass();
        verify(attacker).propertyChange(any(PropertyChangeEvent.class));
    }
}
