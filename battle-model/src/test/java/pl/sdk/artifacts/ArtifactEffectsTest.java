package pl.sdk.artifacts;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.sdk.creatures.Creature;
import pl.sdk.creatures.NecropolisFactory;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArtifactEffectsTest {
    private static final int NOT_IMPORTANT = 1;
    private Hero hero;
    private final ArtifactPrimary1Factory artifactFactory = new ArtifactPrimary1Factory();

    @BeforeEach
    void init(){
        HeroEquipment heroEquipment = new HeroEquipment();
        List<Creature> creatureList = new ArrayList<>();
        hero = new Hero(NOT_IMPORTANT, NOT_IMPORTANT, NOT_IMPORTANT, NOT_IMPORTANT, heroEquipment, creatureList);
    }

    @Test
    void artifactShouldIncreaseHeroesAttack(){
        // given
        Artifact centaursAx = artifactFactory.create("Centaur's Ax"); // +2 attackSkill

        // when
        hero.equip(centaursAx);

        // then
        assertEquals(3, hero.getAttack());
    }

    @Test
    void artifactThatAddsAttackShouldWorksCorrectly(){
        // given
        Artifact centaursAx = artifactFactory.create("Centaur's Ax"); // +2 attackSkill
        Creature attacker = NecropolisFactory.createDefaultForTests();
        Creature defender = NecropolisFactory.createDefaultForTests();

        // when
        hero.equip(centaursAx);
        hero.addCreature(attacker);
        attacker.attack(defender);

        //then
        assertEquals(7, defender.getCurrentHp());
    }

    @Test
    void artifactThatAddsDefenceShouldWorksCorrectly(){
        // given
        Artifact damnedShield = artifactFactory.create("Shield of the Damned"); // +6 defenceSkill
        Creature attacker = NecropolisFactory.createDefaultForTests();
        Creature defender = NecropolisFactory.createDefaultForTests();

        // when
        hero.equip(damnedShield);
        hero.addCreature(defender);
        attacker.attack(defender);

        //then
        assertEquals(10, defender.getCurrentHp());
    }
}