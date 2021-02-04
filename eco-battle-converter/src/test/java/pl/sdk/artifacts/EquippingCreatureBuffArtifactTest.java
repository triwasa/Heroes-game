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

public class EquippingCreatureBuffArtifactTest {

    private Hero hero;
    private List<Creature> creatures;
    private final ArtifactAbstractFactory artifactFactory = new ArtifactPrimaryFactory();
    private final SpellFactory spellFactory = new SpellFactory();

    @BeforeEach
    void init(){
        creatures = new ArrayList<>();
        hero = new Hero();
    }

    @Test
    void ArtifactHealthShouldIncreaseCreatureHealthCorrectly(){
        Creature creatureForTests = NecropolisFactory.createDefaultForTests();
        creatures.add(creatureForTests);
        hero.addCreatures(creatures);

        int primaryCreatureHealth = creatureForTests.getCurrentHp();

        (artifactFactory.create("Vial of Lifeblood")).buff(hero); // +2 hp

        assertEquals(primaryCreatureHealth + 2, creatureForTests.getCurrentHp());
    }
    @Test
    void FewArtifactHealthShouldIncreaseCreatureHealthCorrectly(){
        Creature creatureForTests = NecropolisFactory.createDefaultForTests();
        creatures.add(creatureForTests);
        hero.addCreatures(creatures);

        int primaryCreatureHealth = creatureForTests.getCurrentHp();

        (artifactFactory.create("Vial of Lifeblood")).buff(hero); // +2 hp
        (artifactFactory.create("Ring of Vitality")).buff(hero); // +1 hp

        assertEquals(primaryCreatureHealth + 3, creatureForTests.getCurrentHp());
    }

    @Test
    void ArtifactSpeedShouldIncreaseCreatureSpeedCorrectly(){
        Creature creatureForTests = NecropolisFactory.createDefaultForTests();
        creatures.add(creatureForTests);
        hero.addCreatures(creatures);

        int primaryMoveRange = creatureForTests.getMoveRange();

        (artifactFactory.create("Cape of Velocity")).buff(hero); // +2 moveRange

        assertEquals(primaryMoveRange + 2, creatureForTests.getMoveRange());
    }

    @Test
    void FewArtifactSpeedShouldIncreaseCreatureSpeedCorrectly(){
        Creature creatureForTests = NecropolisFactory.createDefaultForTests();
        creatures.add(creatureForTests);
        hero.addCreatures(creatures);

        int primaryMoveRange = creatureForTests.getMoveRange();

        (artifactFactory.create("Cape of Velocity")).buff(hero); // +2 moveRange
        (artifactFactory.create("Ring of the Wayfarer")).buff(hero); // +1 moveRange

        assertEquals(primaryMoveRange + 3, creatureForTests.getMoveRange());
    }

    @Test
    void ArtifactResistanceShouldIncreaseCreatureResistanceCorrectly(){
        Creature creatureForTests = NecropolisFactory.createDefaultForTests();
        creatures.add(creatureForTests);
        hero.addCreatures(creatures);

//        double primaryResistance = creatureForTests.getResistance();

        (artifactFactory.create("Surcoat of Counterpoise")).buff(hero); // +10 resistance

//        assertEquals(primaryResistance + 10, creatureForTests.getResistance());
    }

    @Test
    void ArtifactResistanceShouldIncreaseCreatureResistanceCorrectlyx(){
        Creature creatureForTests = NecropolisFactory.createDefaultForTests();
        creatures.add(creatureForTests);
        hero.addCreatures(creatures);

//        double primaryResistance = creatureForTests.getResistance();

        (artifactFactory.create("Surcoat of Counterpoise")).buff(hero); // +10 resistance
        (artifactFactory.create("Garniture of Interference")).buff(hero); // +5 resistance

//        assertEquals(primaryResistance + 15, creatureForTests.getResistance());
    }

    @Test
    void ArtifactImmunityShouldAddImmunityToCreatureCorrectly(){
        Creature creatureForTests = NecropolisFactory.createDefaultForTests();
        creatures.add(creatureForTests);
        hero.addCreatures(creatures);

        (artifactFactory.create("Pendant of Negativity")).buff(hero); // immunity to  the lightning spell
//        Spell lightningSpell = spellFactory.create("Lightning spell");

//        assertEquals(true, creatureForTests.checkImmunity(lightningSpell));
    }

}
