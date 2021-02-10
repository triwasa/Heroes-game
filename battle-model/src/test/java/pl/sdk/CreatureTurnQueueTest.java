package pl.sdk;

import com.google.common.collect.Range;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.sdk.CreatureTurnQueue;
import pl.sdk.creatures.BattleObject;
import pl.sdk.creatures.Creature;
import pl.sdk.creatures.NecropolisFactory;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class CreatureTurnQueueTest {

    private Creature a;
    private Creature b;
    private Creature c;
    private Collection<BattleObject> creatureList;


    @BeforeEach
    void init(){
        a = NecropolisFactory.createDefaultForTests();
        b = NecropolisFactory.createDefaultForTests();
        c = NecropolisFactory.createDefaultForTests();
        creatureList = new ArrayList<>();
        creatureList.add(a);
        creatureList.add(b);
        creatureList.add(c);
    }

    @Test
    void shouldChangeActiveCreature(){
        CreatureTurnQueue creatureTurnQueue = new CreatureTurnQueue(creatureList);

        assertEquals(a,creatureTurnQueue.getActiveCreature());
        creatureTurnQueue.next();

        assertEquals(b,creatureTurnQueue.getActiveCreature());
        creatureTurnQueue.next();

        assertEquals(c,creatureTurnQueue.getActiveCreature());
        creatureTurnQueue.next();

        assertEquals(a, creatureTurnQueue.getActiveCreature());
    }
}