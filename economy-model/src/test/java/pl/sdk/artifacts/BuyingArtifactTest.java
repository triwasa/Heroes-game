package pl.sdk.artifacts;

import org.junit.jupiter.api.BeforeEach;
import pl.sdk.EconomyEngine;
import pl.sdk.hero.EconomyHero;

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
}
