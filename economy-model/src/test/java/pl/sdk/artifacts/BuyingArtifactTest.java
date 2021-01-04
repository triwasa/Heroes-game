package pl.sdk.artifacts;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.sdk.EconomyEngine;
import pl.sdk.hero.EconomyHero;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BuyingArtifactTest {

    private EconomyHero hero1;
    private final EconomyArtifactPrimary1Factory artifactFactory = new EconomyArtifactPrimary1Factory();
    private EconomyEngine economyEngine;
    private EconomyHero hero2;

    @BeforeEach
    void init() {
        hero1 = new EconomyHero(EconomyHero.Fraction.NECROPOLIS, 1000);
        hero2 = new EconomyHero(EconomyHero.Fraction.NECROPOLIS, 1000);
        economyEngine = new EconomyEngine(hero1, hero2);
    }

    @Test
    void heroShouldCanBuyArtifact() {
        economyEngine.buyArtifact(artifactFactory.create("Centaur's Ax")); // 120 gold

        assertEquals(880, hero1.getGold());
    }

    @Test
    void heroShouldCanBuyFewArtifacts() {
        economyEngine.buyArtifact(artifactFactory.create("Centaur's Ax")); // 120 gold
        economyEngine.buyArtifact(artifactFactory.create("Shield of the Dwarven Lords")); // 120 gold

        assertEquals(760, hero1.getGold());
    }

    @Test
    void heroCannotBuyArtifactWhenHasNotEnoughGold() {
        assertThrows(IllegalStateException.class, () -> economyEngine.buyArtifact(artifactFactory.create("Titan's Gladius")));
        assertEquals(1000, hero1.getGold());
        assertEquals(0, hero1.getArtifacts().size());
    }
}
