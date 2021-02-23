package pl.sdk.artifacts;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.sdk.creatures.Creature;
import pl.sdk.creatures.NecropolisFactory;
import pl.sdk.hero.Hero;
import pl.sdk.spells.Spell;
import pl.sdk.spells.SpellFactory;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static pl.sdk.artifacts.ArtifactName.*;

public class EquippingCreatureBuffArtifactTest {

    private Hero hero;
    private List<Creature> creatures;
    private ArtifactFactory artifactFactory = new ArtifactFactory();
    private final SpellFactory spellFactory = new SpellFactory();

    @BeforeEach
    void prepareHero(){
        creatures = new ArrayList<>();
        hero = new Hero();
    }

    @Test
    void artifactHealthShouldIncreaseCreatureHealthCorrectly(){
        Creature creatureForTests = NecropolisFactory.createDefaultForTests();
        creatures.add(creatureForTests);
        hero.addCreatures(creatures);

        int primaryCreatureHealth = creatureForTests.getCurrentHp();

        (artifactFactory.createArtifactForTests(TEST_INCREASE_HEALTH_2)).buff(hero);

        assertEquals(primaryCreatureHealth + 2, creatureForTests.getCurrentHp());
    }
    @Test
    void fewArtifactHealthShouldIncreaseCreatureHealthCorrectly(){
        Creature creatureForTests = NecropolisFactory.createDefaultForTests();
        creatures.add(creatureForTests);
        hero.addCreatures(creatures);

        int primaryCreatureHealth = creatureForTests.getCurrentHp();

        (artifactFactory.createArtifactForTests(TEST_INCREASE_HEALTH_1)).buff(hero);
        (artifactFactory.createArtifactForTests(TEST_INCREASE_HEALTH_2)).buff(hero);

        assertEquals(primaryCreatureHealth + 3, creatureForTests.getCurrentHp());
    }

    @Test
    void artifactSpeedShouldIncreaseCreatureSpeedCorrectly(){
        Creature creatureForTests = NecropolisFactory.createDefaultForTests();
        creatures.add(creatureForTests);
        hero.addCreatures(creatures);

        int primaryMoveRange = creatureForTests.getMoveRange();

        (artifactFactory.createArtifactForTests(TEST_INCREASE_MOVERANGE_2)).buff(hero);

        assertEquals(primaryMoveRange + 2, creatureForTests.getMoveRange());
    }

    @Test
    void fewArtifactSpeedShouldIncreaseCreatureSpeedCorrectly(){
        Creature creatureForTests = NecropolisFactory.createDefaultForTests();
        creatures.add(creatureForTests);
        hero.addCreatures(creatures);

        int primaryMoveRange = creatureForTests.getMoveRange();

        (artifactFactory.createArtifactForTests(TEST_INCREASE_MOVERANGE_1)).buff(hero);
        (artifactFactory.createArtifactForTests(TEST_INCREASE_MOVERANGE_2)).buff(hero);

        assertEquals(primaryMoveRange + 3, creatureForTests.getMoveRange());
    }

    @Test
    void artifactResistanceShouldIncreaseCreatureResistanceCorrectly(){
         Creature creatureForTests = NecropolisFactory.createDefaultForTests();
        creatures.add(creatureForTests);
        hero.addCreatures(creatures);

        int primaryResistance = creatureForTests.getResistance();

        (artifactFactory.createArtifactForTests(TEST_INCREASE_RESISTANCE_10)).buff(hero);

        assertEquals(primaryResistance + 10, creatureForTests.getResistance());
    }

    @Test
    void fewArtifactResistanceShouldIncreaseCreatureResistanceCorrectly(){
        Creature creatureForTests = NecropolisFactory.createDefaultForTests();
        creatures.add(creatureForTests);
        hero.addCreatures(creatures);

        int primaryResistance = creatureForTests.getResistance();

        (artifactFactory.createArtifactForTests(TEST_INCREASE_RESISTANCE_5)).buff(hero);
        (artifactFactory.createArtifactForTests(TEST_INCREASE_RESISTANCE_10)).buff(hero);

       assertEquals(primaryResistance + 15, creatureForTests.getResistance());
    }

//    @Test
//    void artifactImmunityShouldAddImmunityToCreatureCorrectly(){
//        Creature creatureForTests = NecropolisFactory.createDefaultForTests();
//        creatures.add(creatureForTests);
//        hero.addCreatures(creatures);
//
//        (artifactFactory.create(PENDANT_OF_NEGATIVITY)).buff(hero); // immunity to  the lightning spell
//        Spell lightningBoltSpell = spellFactory.create(LIGHTNING_BOLT);
//
//        assertEquals(true, creatureForTests.checkImmunity(lightningBoltSpell));
//    }

}
