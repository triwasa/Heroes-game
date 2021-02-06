package pl.sdk.hero;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HeroTest {

    @Test
    void createHeroTest() {
        Hero hero = new Hero.BuilderForTesting().attack(1).defence(2).power(3).knowledge(4).build();

        assertEquals(hero.getAttack(), 1);
        assertEquals(hero.getDefence(), 2);
        assertEquals(hero.getPower(), 3);
        assertEquals(hero.getKnowledge(), 4);
    }
}
