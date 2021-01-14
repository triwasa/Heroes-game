package pl.sdk.creatures.warmachines;

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
        Creature c1 = new NecropolisFactory().create(true, 7, 1);
        Creature c2 = new NecropolisFactory().create(true, 3, 1);
        ballista.damage = Range.closed(3,3);
        ballista.attack(c1);
        ballista.attack(c2);

        assertEquals(198, c1.getCurrentHp());
        assertEquals(15, c2.getCurrentHp());

    }

}
