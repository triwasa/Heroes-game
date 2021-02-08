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
}
