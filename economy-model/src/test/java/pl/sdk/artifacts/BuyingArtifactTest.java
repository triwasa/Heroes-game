package pl.sdk.artifacts;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.sdk.EconomyEngine;
import pl.sdk.hero.EconomyHero;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        economyEngine.buyArtifact(artifactFactory.create("Centaur's Ax"));

        assertEquals(880, hero1.getGold());
    }
}
