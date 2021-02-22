package pl.sdk.artifacts;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.sdk.hero.Hero;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static pl.sdk.artifacts.ArtifactName.*;

public class EquippingPrimaryArtifactTest {

    private Hero hero;
    private final ArtifactFactory artifactFactory = new ArtifactFactory();

    @BeforeEach
    void init() {
        hero = new Hero();
    }

    @Test
    void heroShouldChangeStatsWithPurchasedOneArtifact() {
        int primaryHeroKnowledge = hero.getKnowledge();
        int primaryHeroSpellPower = hero.getPower();

        (artifactFactory.create(THUNDER_HELMET)).buff(hero);

        assertEquals(primaryHeroKnowledge + 10, hero.getKnowledge());
        assertEquals(primaryHeroSpellPower - 2, hero.getPower());
    }

    @Test
    void heroShouldChangeStatsWithPurchasedTwoArtifact() {
        int primaryHeroAttack = hero.getAttack();
        int primaryHeroDefense = hero.getDefence();

        (artifactFactory.create(CENTAURS_AX)).buff(hero);
        (artifactFactory.create(SHIELD_OF_THE_DWARVEN_LORDS)).buff(hero);

        assertEquals(primaryHeroAttack + 2, hero.getAttack());
        assertEquals(primaryHeroDefense + 2, hero.getDefence());
    }

    @Test
    void heroShouldIncreaseLuckWithPurchasedArtifact() {
        int primaryHeroLuck = hero.getLuck();

        (artifactFactory.create(CLOVER_OF_FORTUNE)).buff(hero);

        assertEquals(primaryHeroLuck + 1, hero.getLuck());
    }

    @Test
    void heroShouldIncreaseMoraleWithPurchasedArtifact() {
        int primaryHeroMorale= hero.getMorale();

        (artifactFactory.create(CREST_OF_VALOR)).buff(hero);

        assertEquals(primaryHeroMorale + 1, hero.getMorale());
    }

    @Test
    void heroShouldIncreaseLuckAndMoraleWithPurchasedArtifact() {
        int primaryHeroMorale= hero.getMorale();
        int primaryHeroLuck= hero.getLuck();

        (artifactFactory.create(PENDANT_OF_COURAGE)).buff(hero);

        assertEquals(primaryHeroMorale + 3, hero.getMorale());
        assertEquals(primaryHeroLuck + 3, hero.getLuck());
    }

}
