package pl.sdk.artifacts;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.sdk.EconomyEngine;
import pl.sdk.hero.EconomyHero;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static pl.sdk.artifacts.ArtifactName.*;

public class BuyingArtifactTest {

    private EconomyHero hero1;
    private EconomyEngine economyEngine;
    private final EconomyArtifactPrimaryFactory economyArtifactFactory = new EconomyArtifactPrimaryFactory();

    @BeforeEach
    void prepareHero() {
        hero1 = new EconomyHero(EconomyHero.Fraction.NECROPOLIS, 1000);
        EconomyHero hero2 = new EconomyHero(EconomyHero.Fraction.NECROPOLIS, 1000);
        economyEngine = new EconomyEngine(hero1, hero2);
    }

    @Test
    void heroShouldCanBuyArtifact() {
        economyEngine.buyArtifact(economyArtifactFactory.createArtifactForTests(TEST_LEFT_HAND_SLOT));

        assertEquals(880, hero1.getGold());
    }

    @Test
    void heroShouldCanBuyFewArtifacts() {
        economyEngine.buyArtifact(economyArtifactFactory.createArtifactForTests(TEST_LEFT_HAND_SLOT));
        economyEngine.buyArtifact(economyArtifactFactory.createArtifactForTests(TEST_RIGHT_HAND_SLOT));

        assertEquals(740, hero1.getGold());
    }

    @Test
    void heroCannotBuyArtifactWhenHasNotEnoughGold() {
        assertThrows(IllegalStateException.class, () -> economyEngine.buyArtifact(economyArtifactFactory.createArtifactForTests(TEST_TOO_EXPENSIVE)));
        assertEquals(1000, hero1.getGold());
        assertEquals(0, hero1.getArtifacts().size());
    }

    @Test
    void heroCannotBuyArtifactWhenHasOneAlreadyInSlot() {
        economyEngine.buyArtifact(economyArtifactFactory.createArtifactForTests(TEST_LEFT_HAND_SLOT));

        assertThrows(IllegalStateException.class, () -> economyEngine.buyArtifact(economyArtifactFactory.createArtifactForTests(TEST_LEFT_HAND_SLOT)));
        assertEquals(880, hero1.getGold());
        assertEquals(1, hero1.getArtifacts().size());
    }

}
