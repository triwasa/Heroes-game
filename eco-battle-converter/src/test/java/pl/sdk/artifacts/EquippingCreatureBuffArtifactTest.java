package pl.sdk.artifacts;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.sdk.converter.Hero;
import pl.sdk.creatures.Creature;
import pl.sdk.creatures.NecropolisFactory;

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
    void ArtifactSpeedShouldIncreaseCreatureSpeedCorrectly(){
        Creature creatureForTests = NecropolisFactory.createDefaultForTests();
        creatures.add(creatureForTests);
        hero.addCreatures(creatures);

        int primaryMoveRange = creatureForTests.getMoveRange();

        (artifactFactory.create("Cape of Velocity")).buff(hero); // +2 moveRange

        assertEquals(primaryMoveRange + 2, creatureForTests.getMoveRange());
    }

    @Test
    void ArtifactResistanceShouldIncreaseCreatureResistanceCorrectly(){
        Creature creatureForTests = NecropolisFactory.createDefaultForTests();
        creatures.add(creatureForTests);
        hero.addCreatures(creatures);

        double primaryResistance = creatureForTests.getResistance();

        (artifactFactory.create("Surcoat of Counterpoise")).buff(hero); // +0.1 resistance

        assertEquals(primaryResistance + 0.1, creatureForTests.getResistance());
    }

    @Test
    void ArtifactImmunityShouldAddImmunityToCreatureCorrectly(){
        Creature creatureForTests = NecropolisFactory.createDefaultForTests();
        creatures.add(creatureForTests);
        hero.addCreatures(creatures);

        (artifactFactory.create("Pendant of Negativity")).buff(hero); // immunity to  the lightning spell
        Spell lightningSpell = spellFactory.create("Lightning spell");

        assertEquals(true, creatureForTests.checkImmunity(lightningSpell));
    }

    @Test
    void ArtifactImmunityShouldAddFewImmunitiesToCreatureCorrectly(){
        Creature creatureForTests = NecropolisFactory.createDefaultForTests();
        creatures.add(creatureForTests);
        hero.addCreatures(creatures);

        (artifactFactory.create("Pendant of Negativity")).buff(hero); // immunity to  the lightning spell
        (artifactFactory.create("Pendant of Second Sight")).buff(hero); // immunity to  the blind spell
        Spell lightningSpell = spellFactory.create("Lightning");
        Spell blindSpell = spellFactory.create("Blind");

        assertEquals(true, creatureForTests.checkImmunity(lightningSpell));
        assertEquals(true, creatureForTests.checkImmunity(blindSpell));
    }

}
