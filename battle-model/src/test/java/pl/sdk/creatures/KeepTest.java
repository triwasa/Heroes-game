/*
package pl.sdk.creatures;

import com.google.common.collect.Range;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KeepTest {
    public static final int NOT_IMPORTANT = 5;

    @Test
    void shouldShot() {
        Keep keep = new Keep();
        Creature defender1 = new Creature.BuilderForTesting()
                .name("defender1")
                .attack(10)
                .armor(0)
                .maxHp(100)
                .moveRange(NOT_IMPORTANT)
                .damage(Range.closed(20,20))
                .build();
        keep.attack(defender1);
        assertEquals(85, defender1.getCurrentHp());


    }

}*/
