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

    @BeforeEach
    void init(){
        HeroEquipment heroEquipment = new HeroEquipment();
        List<Creature> creatureList = new ArrayList<>();
        hero = new Hero(NOT_IMPORTANT, NOT_IMPORTANT, NOT_IMPORTANT, NOT_IMPORTANT, heroEquipment, creatureList);
    }

    @Test
    void artifactShouldIncreaseHeroesAttack(){
        // given
        Artifact centaursAx = ArtifactFactory.create("Centaur's Ax");

        // when
        hero.equip(centaursAx);

        // then
        assertEquals(3, hero.getAttack());
    }

    @Test
    void artifactThatAddsAttackShouldWorksCorrectly(){
        // given
        Artifact centaursAx = ArtifactFactory.create("Centaur's Ax");
        Creature attacker = new Creature("Attacker",20,NOT_IMPORTANT,100,NOT_IMPORTANT);
        Creature defender = new Creature("Defender",NOT_IMPORTANT,10,100, NOT_IMPORTANT);

        // when
        hero.equip(centaursAx);
        hero.addCreature(attacker);
        attacker.attack(defender);

        //then
        assertEquals(88, defender.getCurrentHp());
    }

    @Test
    void artifactThatAddsDefenceShouldWorksCorrectly(){
        // given
        Artifact damnedShield = ArtifactFactory.create("Shield of the Damned"); // +6 defenceSkill
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
