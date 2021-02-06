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
        assertEquals(hero.getLuck(), 0);
        assertEquals(hero.getMorale(), 0);
    }

    @Test
    void increaseHeroStats() {
        Hero hero = new Hero.BuilderForTesting().attack(1).defence(1).power(1).knowledge(1).build();

        // I use HeroClassStatistic, because I don't have access to ArtifactPrimaryStatistic
        // but both of them implement HeroClassStatisticIf
        hero.increaseStats(HeroClassStatistic.ALCHEMIST); // 1,1,2,2
        assertEquals(hero.getAttack(), 1 + 1);
        assertEquals(hero.getDefence(), 1 + 1);
        assertEquals(hero.getPower(), 1 + 2);
        assertEquals(hero.getKnowledge(), 1 + 2);
    }



}
