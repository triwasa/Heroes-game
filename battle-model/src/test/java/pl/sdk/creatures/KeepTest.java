
package pl.sdk.creatures;

import com.google.common.collect.Range;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.sdk.AttackEngine;
import pl.sdk.Board;
import pl.sdk.fortifications.FortificationStatistic;

import static org.junit.jupiter.api.Assertions.*;

class KeepTest {
    public static final int NOT_IMPORTANT = 5;
    private AttackEngine attackEngine;

    @BeforeEach
    void init() {
        attackEngine=new AttackEngine(new Board());

    }

    @Test
    void shouldShot() {
        Keep keep = new Keep(FortificationStatistic.KEEP);
        Creature defender1 = new Creature.BuilderForTesting()
                .name("defender1")
                .attack(NOT_IMPORTANT)
                .armor(0)
                .maxHp(100)
                .moveRange(NOT_IMPORTANT)
                .damage(Range.closed(NOT_IMPORTANT,NOT_IMPORTANT))
                .build();
        keep.getAttackStrategy().attack(keep, defender1);
        assertEquals(85, defender1.getCurrentHp());


    }

}
