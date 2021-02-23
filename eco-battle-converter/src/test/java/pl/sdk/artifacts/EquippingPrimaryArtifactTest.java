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

        (artifactFactory.createArtifactForTests(TEST_KNOWLEDGE_SPELLPOWER)).buff(hero);

        assertEquals(primaryHeroKnowledge + 10, hero.getKnowledge());
        assertEquals(primaryHeroSpellPower - 2, hero.getPower());
    }

    @Test
    void heroShouldChangeStatsWithPurchasedTwoArtifact() {
        int primaryHeroAttack = hero.getAttack();
        int primaryHeroDefense = hero.getDefence();

        (artifactFactory.createArtifactForTests(TEST_ATTACK)).buff(hero);
        (artifactFactory.createArtifactForTests(TEST_DEFENCE)).buff(hero);

        assertEquals(primaryHeroAttack + 2, hero.getAttack());
        assertEquals(primaryHeroDefense + 2, hero.getDefence());
    }

    @Test
    void heroShouldIncreaseLuckWithPurchasedArtifact() {
        int primaryHeroLuck = hero.getLuck();

        (artifactFactory.createArtifactForTests(TEST_LUCK)).buff(hero);

        assertEquals(primaryHeroLuck + 1, hero.getLuck());
    }

    @Test
    void heroShouldIncreaseMoraleWithPurchasedArtifact() {
        int primaryHeroMorale= hero.getMorale();

        (artifactFactory.createArtifactForTests(TEST_MORALE)).buff(hero);

        assertEquals(primaryHeroMorale + 1, hero.getMorale());
    }

    @Test
    void heroShouldIncreaseLuckAndMoraleWithPurchasedArtifact() {
        int primaryHeroMorale= hero.getMorale();
        int primaryHeroLuck= hero.getLuck();

        (artifactFactory.createArtifactForTests(TEST_LUCK_MORALE)).buff(hero);

        assertEquals(primaryHeroMorale + 2, hero.getMorale());
        assertEquals(primaryHeroLuck + 2, hero.getLuck());
    }

}
