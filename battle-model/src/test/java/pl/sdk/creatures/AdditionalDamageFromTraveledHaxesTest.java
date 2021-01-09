package pl.sdk.creatures;


import com.google.common.collect.Range;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.sdk.GameEngine;
import pl.sdk.Point;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AdditionalDamageFromTraveledHaxesTest {
    int NOT_IMPORTANT = 5;
    Creature attacker;
    Creature defender;
    @BeforeEach
    void init() {
         attacker = new Creature.BuilderForTesting()
                .name("attacker")
                 .attack(2)
                 .armor(NOT_IMPORTANT)
                 .damage(Range.closed(5,5))
                 .maxHp(NOT_IMPORTANT)
                 .moveRange(NOT_IMPORTANT)
                .build();
         defender = new Creature.BuilderForTesting()
                 .name("defender")
                 .attack(NOT_IMPORTANT)
                 .armor(2)
                 .maxHp(20)
                 .damage(Range.closed(NOT_IMPORTANT,NOT_IMPORTANT))
                 .moveRange(NOT_IMPORTANT)
                .build();
    }

   /* @Test
    void EightHaxesTraveled() {
        GameEngine engine = new GameEngine(List.of(attacker), List.of(defender));
        //attacker is now at Point(0,1)
        engine.move(new Point(0,7));
        attacker.attack(defender);
        assertEquals(13, defender.getCurrentHp());
    }*/
}
