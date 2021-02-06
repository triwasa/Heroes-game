/*
package pl.sdk.creatures;

import com.google.common.collect.Range;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.sdk.AttackEngine;
import pl.sdk.Board;

import static org.junit.jupiter.api.Assertions.*;

class CatapultTest {

    public static final int NOT_IMPORTANT=5;
    private AttackEngine attackEngine;

    @BeforeEach
    void init() {
        attackEngine=new AttackEngine(new Board());
    }

    @Test
    public void shouldAttackWalls() {
        Catapult catapult=new Catapult.BuilderForTesting()
                .name("Catapult")
                .attack(10)
                .armor(NOT_IMPORTANT)
                .maxHp(NOT_IMPORTANT)
                .moveRange(NOT_IMPORTANT)
                .damage(Range.closed(3, 3))
                .build();


        Wall wall=new Wall.BuilderForTesting()
                .name("Wall")
                .amount(1)
                .maxHp(6)
                .damage(NOT_IMPORTANT)
                .build();

        attackEngine.attack(catapult, wall);
        assertEquals(3, wall.getCurrentHp());


    }


}*/
