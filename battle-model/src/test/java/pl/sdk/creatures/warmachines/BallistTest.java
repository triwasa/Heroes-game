package pl.sdk.creatures.warmachines;

import com.google.common.collect.Range;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.sdk.creatures.Ballist;
import pl.sdk.creatures.Creature;
import pl.sdk.creatures.NecropolisFactory;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BallistTest {

    public static final int NOT_IMPORTANT = 5;
    private Random randomizer;

    @BeforeEach
    void init(){
        randomizer = mock(Random.class);
        when(randomizer.nextInt(anyInt())).thenReturn(3);
    }

    @Test
    void shouldShot(){
        Ballist ballist = new Ballist();
        Creature c1 = new NecropolisFactory().create(true, 7, 1);
        Creature c2 = new NecropolisFactory().create(true, 3, 1);
        ballist.damage = Range.closed(3,3);
        ballist.attack(c1);
        ballist.attack(c2);

        assertEquals(198, c1.getCurrentHp());
        assertEquals(15, c2.getCurrentHp());

    }

}
