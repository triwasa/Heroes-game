package pl.sdk.creatures;

import org.junit.jupiter.api.Test;
import com.google.common.collect.Range;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AdditionalStatsTest {

    @Test
    void shouldIncreaseStatsCorrectly(){
        Creature c = new Creature(CreatureStatistic.AIR_ELEMENTAL);

        c.increaseAttack(5);
        c.increaseDefence(5);
        c.increaseDamage(5,5);

        assertEquals(5+9, c.getAttack());
        assertEquals(5+9, c.getArmor());
        assertEquals(Range.closed(2+5, 8 + 5), c.getDamage());
    }
}
