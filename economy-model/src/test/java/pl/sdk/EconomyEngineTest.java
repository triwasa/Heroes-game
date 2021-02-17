package pl.sdk;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.sdk.creatures.EconomyNecropolisFactory;
import pl.sdk.hero.EconomyHero;
import pl.sdk.artifacts.EconomyArtifactPrimaryFactory;
import pl.sdk.spell.EconomySpellFactory;


import static org.junit.jupiter.api.Assertions.*;
import static pl.sdk.artifacts.ArtifactName.CENTAURS_AX;

class EconomyEngineTest {

    private EconomyEngine economyEngine;
    private EconomyHero h1;
    private EconomyHero h2;
    private EconomyNecropolisFactory creatureFactory;
    private EconomyArtifactPrimaryFactory artifactFactory;

    @BeforeEach
    void init(){
        h1 = new EconomyHero(EconomyHero.Fraction.NECROPOLIS, 1000);
        h2 = new EconomyHero(EconomyHero.Fraction.NECROPOLIS, 1000);
        economyEngine = new EconomyEngine(h1, h2);
        creatureFactory = new EconomyNecropolisFactory();

    }

    @Test
    void shouldChangeActiveHeroAfterPass(){
        assertEquals(h1,economyEngine.getActiveHero());
        economyEngine.pass();
        assertEquals(h2,economyEngine.getActiveHero());
    }

    @Test
    void shouldCountRoundCorrectly(){
        assertEquals(1,economyEngine.getRoundNumber());
        economyEngine.pass();
        assertEquals(1,economyEngine.getRoundNumber());
        economyEngine.pass();
        assertEquals(2,economyEngine.getRoundNumber());
    }

    @Test
    void shouldBuyCreatureCreatureInCorrectHero(){
        economyEngine.buy(creatureFactory.create(false,1,1));
        assertEquals(940, h1.getGold());
        assertEquals(1000, h2.getGold());
        economyEngine.pass();
        economyEngine.buy(creatureFactory.create(false,2,1));
        assertEquals(900, h2.getGold());
        assertEquals(940, h1.getGold());
    }

  /*  @Test
    void shouldBuyArtifactInCorrectHero(){
        economyEngine.buyArtifact(artifactFactory.create(CENTAURS_AX));
        //assertEquals(1000-120, h1.getGold());
    }

    @Test
    void shouldBuySpellInCorrectHero(){
        economyEngine.buySpell(spe);

    }*/
}