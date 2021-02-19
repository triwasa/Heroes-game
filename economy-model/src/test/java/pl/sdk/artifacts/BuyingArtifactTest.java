package pl.sdk.artifacts;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.sdk.EconomyEngine;
import pl.sdk.hero.EconomyHero;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static pl.sdk.artifacts.ArtifactName.*;
import static pl.sdk.hero.HeroClassName.DEATH_KNIGHT;

public class BuyingArtifactTest {

    private EconomyHero hero1, hero2;
    private EconomyEngine economyEngine;
    private final EconomyArtifactPrimaryFactory economyArtifactFactory = new EconomyArtifactPrimaryFactory();

    @BeforeEach
    void prepareHero() {
        hero1 = new EconomyHero( DEATH_KNIGHT, 1000);
        hero2 = new EconomyHero( DEATH_KNIGHT, 1000);
        economyEngine = new EconomyEngine(hero1, hero2);
    }

    @Test
    void heroShouldCanBuyArtifact() {
        economyEngine.buyArtifact(economyArtifactFactory.create(CENTAURS_AX));

        assertEquals(880, hero1.getGold());
    }

    @Test
    void heroShouldCanBuyFewArtifacts() {
        economyEngine.buyArtifact(economyArtifactFactory.create(CENTAURS_AX));
        economyEngine.buyArtifact(economyArtifactFactory.create(SHIELD_OF_THE_DWARVEN_LORDS));

        assertEquals(760, hero1.getGold());
    }

    @Test
    void heroCannotBuyArtifactWhenHasNotEnoughGold() {
        assertThrows(IllegalStateException.class, () -> economyEngine.buyArtifact(economyArtifactFactory.create(TITANS_GLADIUS)));
        assertEquals(1000, hero1.getGold());
        assertEquals(0, hero1.getArtifacts().size());
    }

    @Test
    void heroCannotBuyArtifactWhenHasOneAlreadyInSlot() {
        economyEngine.buyArtifact(economyArtifactFactory.create(CENTAURS_AX));

        assertThrows(IllegalStateException.class, () -> economyEngine.buyArtifact(economyArtifactFactory.create(BLACKSHARD_OF_THE_DEAD_KNIGHT)));
        assertEquals(880, hero1.getGold());
        assertEquals(1, hero1.getArtifacts().size());
    }

}
