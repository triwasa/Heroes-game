package pl.sdk.creatures;

import com.google.common.collect.Range;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.sdk.AttackEngine;
import pl.sdk.Board;

import static org.junit.jupiter.api.Assertions.*;
import static pl.sdk.fortifications.FortificationStatistic.WALL;

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
                .damage(Range.closed(2, 2))
                .build();

        Creature defender1=new Creature.BuilderForTesting()
                .name("Defender")
                .attack(NOT_IMPORTANT)
                .armor(10)
                .maxHp(100)
                .moveRange(NOT_IMPORTANT)
                .damage(Range.closed(NOT_IMPORTANT, NOT_IMPORTANT))
                .build();

        Wall wall = new Wall.BuilderForTesting()
                .name("Wall")
                .maxHp(100)
                .damage(5)
                .build();

        attackEngine.attack(catapult, defender1);
//        assertEquals(100, defender1.getCurrentHp());


    }



}