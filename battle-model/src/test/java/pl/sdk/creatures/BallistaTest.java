package pl.sdk.creatures;

import com.google.common.collect.Range;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.sdk.creatures.Ballista;
import pl.sdk.creatures.Creature;
import pl.sdk.creatures.NecropolisFactory;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BallistaTest {

    public static final int NOT_IMPORTANT = 5;
    private Random randomizer;

    @BeforeEach
    void init(){
        randomizer = mock(Random.class);
        when(randomizer.nextInt(anyInt())).thenReturn(3);
    }

    @Test
    void shouldShot(){
        Ballista ballista = new Ballista();
        Creature defender1 = new Creature.BuilderForTesting()
                .name("defender1")
                .attack(10)
                .armor(10)
                .maxHp(20)
                .moveRange(NOT_IMPORTANT)
                .damage(Range.closed(20,20))
                .build();
        ballista.damage = Range.closed(3,3);
        ballista.attack(defender1);
        assertEquals(17, defender1.getCurrentHp());
    }

}
