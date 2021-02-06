package pl.sdk.hero;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HeroTest {

    @Test
    void createHeroTest() {
        Hero hero = new Hero.BuilderForTesting().attack(1).defence(2).power(3).knowledge(4).build();

        HeroStatistic stats = (HeroStatistic) hero.getStats();

        assertEquals(stats.getAttack(), 1);
        assertEquals(stats.getDefence(), 2);
        assertEquals(stats.getPower(), 3);
        assertEquals(stats.getKnowledge(), 4);
    }
}
