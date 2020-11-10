package pl.sdk;

import com.google.common.collect.Range;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CreatureTurnQueueTest {

    private Creature a;
    private Creature b;
    private Creature c;
    private Collection<Creature> creatureList;


    @BeforeEach
    void init(){
        a = new Creature.Builder()
                .name("Name")
                .attack(2)
                .armor(1)
                .maxHp(10)
                .moveRange(1)
                .damage(Range.closed(2,2))
                .build();
        b = new Creature.Builder()
                .name("Name")
                .attack(2)
                .armor(1)
                .maxHp(10)
                .moveRange(1)
                .damage(Range.closed(2,2))
                .build();
        c = new Creature.Builder()
                .name("Name")
                .attack(2)
                .armor(1)
                .maxHp(10)
                .moveRange(1)
                .damage(Range.closed(2,2))
                .build();
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