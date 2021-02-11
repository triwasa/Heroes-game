
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
                .attack(0)
                .armor(NOT_IMPORTANT)
                .maxHp(NOT_IMPORTANT)
                .moveRange(NOT_IMPORTANT)
                .damage(Range.closed(3, 3))
                .build();


        Wall wall=new Wall.BuilderForTesting()
                .name("Wall")
                .amount(1)
                .maxHp(6)
                .damage(Range.closed(0,0))
                .build();

        catapult.getAttackStrategy().attack(catapult, wall);
        assertEquals(3, wall.getCurrentHp());
    }

    @Test
    void shouldTakeDamage() {
        Catapult catapult=new Catapult.BuilderForTesting()
                .name("Catapult")
                .attack(NOT_IMPORTANT)
                .armor(NOT_IMPORTANT)
                .maxHp(100)
                .moveRange(NOT_IMPORTANT)
                .damage(Range.closed(NOT_IMPORTANT, NOT_IMPORTANT))
                .build();
        Creature attacker=new Creature.BuilderForTesting()
                .name("Attacker")
                .attack(5)
                .armor(NOT_IMPORTANT)
                .maxHp(NOT_IMPORTANT)
                .moveRange(NOT_IMPORTANT)
                .damage(Range.closed(5, 5))
                .build();
        attacker.getAttackStrategy().attack(attacker, catapult);
        assertEquals(95, catapult.getCurrentHp());
    }

    @Test
    void shouldGetDestroyed() {
        Catapult catapult=new Catapult.BuilderForTesting()
                .name("Catapult")
                .attack(NOT_IMPORTANT)
                .armor(NOT_IMPORTANT)
                .maxHp(5)
                .moveRange(NOT_IMPORTANT)
                .damage(Range.closed(5, 5))
                .build();
        Creature attacker=new Creature.BuilderForTesting()
                .name("Attacker")
                .attack(5)
                .armor(NOT_IMPORTANT)
                .maxHp(NOT_IMPORTANT)
                .moveRange(NOT_IMPORTANT)
                .damage(Range.closed(NOT_IMPORTANT, NOT_IMPORTANT))
                .build();
        attacker.getAttackStrategy().attack(attacker, catapult);
        assertEquals(0, catapult.getCurrentHp());
        assertEquals(0, catapult.getAmount());
    }




}
