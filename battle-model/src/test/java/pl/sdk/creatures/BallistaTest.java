
package pl.sdk.creatures;

import com.google.common.collect.Range;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.sdk.AttackEngine;
import pl.sdk.Board;

import static org.junit.jupiter.api.Assertions.*;


class BallistaTest {

    public static final int NOT_IMPORTANT=5;
    private AttackEngine attackEngine;

    @BeforeEach
    void init() {
        attackEngine=new AttackEngine(new Board());
    }

    @Test
    void shouldShoot() {
        Ballista ballista=new Ballista.BuilderForTesting()
                .name("Ballista")
                .attack(10)
                .armor(NOT_IMPORTANT)
                .maxHp(NOT_IMPORTANT)
                .moveRange(NOT_IMPORTANT)
                .damage(Range.closed(3, 3))
                .build();
        Creature defender1=new Creature.BuilderForTesting()
                .name("Defender")
                .attack(NOT_IMPORTANT)
                .armor(10)
                .maxHp(100)
                .moveRange(NOT_IMPORTANT)
                .damage(Range.closed(NOT_IMPORTANT, NOT_IMPORTANT))
                .build();
        ballista.getAttackStrategy().attack(ballista, defender1);
        assertEquals(97, defender1.getCurrentHp());
    }

}


