package pl.sdk.creatures;

import com.google.common.collect.Range;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.sdk.AttackEngine;
import pl.sdk.Board;
import pl.sdk.GameEngine;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ShootingAndBlockCounterAttackCreatureTest {

    int NOT_IMPORTANT = 5;
    int MORE_THAN_SECOND_CREATURE = NOT_IMPORTANT+1;
    private AttackEngine attackEngine;

    @BeforeEach
    void init() {
        attackEngine = new AttackEngine(new Board());
    }

    @Test
    void creatureCanAttackEvenDistanceToOpponentIsMoreThanOne(){
        Creature shootingCreature = new Creature.BuilderForTesting()
                .name("Shooter")
                .maxHp(NOT_IMPORTANT)
                .attack(NOT_IMPORTANT)
                .armor(NOT_IMPORTANT)
                .damage(Range.closed(NOT_IMPORTANT, NOT_IMPORTANT))
                .moveRange(MORE_THAN_SECOND_CREATURE)
                .amount(NOT_IMPORTANT)
                .build();
        shootingCreature = new ShootingCreatureDecorator(shootingCreature);
        Creature normalCreature = new Creature.BuilderForTesting()
                .name("Normal unit")
                .maxHp(NOT_IMPORTANT)
                .attack(NOT_IMPORTANT)
                .armor(NOT_IMPORTANT)
                .damage(Range.closed(NOT_IMPORTANT, NOT_IMPORTANT))
                .moveRange(NOT_IMPORTANT)
                .amount(NOT_IMPORTANT)
                .build();
        GameEngine engine = new GameEngine(List.of(shootingCreature), List.of(normalCreature), new Board());

        assertTrue(engine.canAttack(GameEngine.BOARD_WIDTH-1,1));

        engine.pass();
        assertFalse(engine.canAttack(0,1));
    }

    @Test
    void defenderShouldNotCounterAttackForBlockCounterAttackCreature(){
        Creature blockCounterAttackCreature = new Creature.BuilderForTesting()
                .name("Shooter")
                .maxHp(100)
                .attack(10)
                .armor(10)
                .damage(Range.closed(10, 10))
                .moveRange(NOT_IMPORTANT)
                .attackStrategy(new BlockCounterAttackAttackStrategy(new DefaultAttackStrategy()))
                .amount(1)
                .build();
        Creature normalCreature = new Creature.BuilderForTesting()
                .name("Normal unit")
                .maxHp(100)
                .attack(10)
                .armor(10)
                .damage(Range.closed(10, 10))
                .moveRange(10)
                .amount(1)
                .build();

        blockCounterAttackCreature = new ShootingCreatureDecorator(blockCounterAttackCreature);
        attackEngine.attack(blockCounterAttackCreature,normalCreature);
        blockCounterAttackCreature.getAttackRange();

        assertEquals(100,blockCounterAttackCreature.getCurrentHp());
        assertEquals(1,blockCounterAttackCreature.getAmount());
    }
}
