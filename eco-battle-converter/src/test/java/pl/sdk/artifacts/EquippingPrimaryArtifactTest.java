package pl.sdk.artifacts;

import com.google.common.collect.Range;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.sdk.creatures.Creature;
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

        (artifactFactory.create(THUNDER_HELMET)).buff(hero); // +10 knowledge, -2 spellPower

        assertEquals(primaryHeroKnowledge + 10, hero.getKnowledge());
        assertEquals(primaryHeroSpellPower - 2, hero.getPower());
    }

    @Test
    void heroShouldChangeStatsWithPurchasedTwoArtifact() {
        int primaryHeroAttack = hero.getAttack();
        int primaryHeroDefense = hero.getDefence();

        (artifactFactory.create(CENTAURS_AX)).buff(hero); // +2 attack
        (artifactFactory.create(SHIELD_OF_THE_DWARVEN_LORDS)).buff(hero); // +2 defense

        assertEquals(primaryHeroAttack + 2, hero.getAttack());
        assertEquals(primaryHeroDefense + 2, hero.getDefence());
    }

    @Test
    void heroShouldIncreaseLuckWithPurchasedArtifact() {
        int primaryHeroLuck = hero.getLuck();

        (artifactFactory.create(CLOVER_OF_FORTUNE)).buff(hero); // +1 luck

        assertEquals(primaryHeroLuck + 1, hero.getLuck());
    }

    @Test
    void heroShouldIncreaseMoraleWithPurchasedArtifact() {
        int primaryHeroMorale= hero.getMorale();

        (artifactFactory.create(CREST_OF_VALOR)).buff(hero); // +1 morale

        assertEquals(primaryHeroMorale + 1, hero.getMorale());
    }

    @Test
    void heroShouldIncreaseLuckAndMoraleWithPurchasedArtifact() {
        int primaryHeroMorale= hero.getMorale();
        int primaryHeroLuck= hero.getLuck();

        (artifactFactory.create(PENDANT_OF_COURAGE)).buff(hero); // +3 morale and luck

        assertEquals(primaryHeroMorale + 3, hero.getMorale());
        assertEquals(primaryHeroLuck + 3, hero.getLuck());
    }

}
