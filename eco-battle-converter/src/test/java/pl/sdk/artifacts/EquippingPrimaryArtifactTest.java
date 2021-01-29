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

        (artifactFactory.create("Thunder Helmet")).buff(hero); // +10 knowledge, -2 spellPower

        assertEquals(primaryHeroKnowledge + 10, hero.getKnowledge());
        assertEquals(primaryHeroSpellPower - 2, hero.getSpellPower());
    }

    @Test
    void heroShouldChangeStatsWithPurchasedTwoArtifact() {
        int primaryHeroAttack = hero.getAttack();
        int primaryHeroDefense = hero.getDefense();

        (artifactFactory.create("Centaur's Ax")).buff(hero); // +2 attack
        (artifactFactory.create("Shield of the Dwarven Lords")).buff(hero); // +2 defense

        assertEquals(primaryHeroAttack + 2, hero.getAttack());
        assertEquals(primaryHeroDefense + 2, hero.getDefense());
    }
}
