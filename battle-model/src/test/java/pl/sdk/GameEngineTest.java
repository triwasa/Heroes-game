package pl.sdk;

import org.junit.jupiter.api.Test;
import pl.sdk.creatures.Creature;
import pl.sdk.creatures.NecropolisFactory;
import pl.sdk.hero.Hero;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.spy;

class GameEngineTest {

    @Test
    void shouldRecognizeFriendlyCreatureAndDoNotAttackHer(){
        NecropolisFactory factory = new NecropolisFactory();
        List<Creature> l1 = List.of(factory.create(true, 5,1), spy(Creature.class));
        List<Creature> l2 = List.of(spy(Creature.class));

        Hero h1 = new Hero();
        h1.addCreatures(l1);
        Hero h2 = new Hero();
        h2.addCreatures(l2);

        GameEngine engine = new GameEngine(h1,h2, new Board());
        assertTrue(engine.canAttack(GameEngine.BOARD_WIDTH-1, 1));
        assertFalse(engine.canAttack(0,1));
        assertFalse(engine.canAttack(0,1));
   }

}