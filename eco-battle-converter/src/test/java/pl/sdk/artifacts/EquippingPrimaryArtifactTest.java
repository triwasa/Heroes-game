package pl.sdk.artifacts;

import com.google.common.collect.Range;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.sdk.converter.Hero;
import pl.sdk.creatures.Creature;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EquippingPrimaryArtifactTest {

    private Hero hero;
    private final ArtifactAbstractFactory artifactFactory = new ArtifactPrimaryFactory();

    @BeforeEach
    void init() {
        hero = new Hero();
    }

    @Test
    void heroShouldChangeStatsWithPurchasedOneArtifact() {
        int primaryHeroKnowledge = hero.getKnowledge();
        int primaryHeroSpellPower = hero.getSpellPower();

        hero.addArtifact(artifactFactory.create("Thunder Helmet")); // +10 knowledge, -2 spellPower

        assertEquals(primaryHeroKnowledge + 10, hero.getKnowledge());
        assertEquals(primaryHeroSpellPower - 2, hero.getSpellPower());
    }

    @Test
    void heroShouldChangeStatsWithPurchasedTwoArtifact() {
        int primaryHeroAttack = hero.getAttack();
        int primaryHeroDefense = hero.getDefense();

        hero.addArtifact(artifactFactory.create("Centaur's Ax")); // +2 attack
        hero.addArtifact(artifactFactory.create("Shield of the Dwarven Lords")); // +2 defense

        assertEquals(primaryHeroAttack + 2, hero.getAttack());
        assertEquals(primaryHeroDefense + 2, hero.getDefense());
    }
}
