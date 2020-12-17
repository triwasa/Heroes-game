package pl.sdk.artifacts;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.sdk.creatures.Creature;

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
        Artefact centaursAx = ArtefactFactory.create("Centaur's Ax");

        // when
        hero.equip(centaursAx);

        // then
        assertEquals(3, hero.getAttack());
    }

    @Test
    void artifactThatAddsAttackShouldWorksCorrectly(){
        // given
        Artefact centaursAx = ArtefactFactory.create("Centaur's Ax");
        Creature attacker = new Creature("Attacker",20,NOT_IMPORTANT,100,NOT_IMPORTANT);
        Creature defender = new Creature("Defender",NOT_IMPORTANT,10,100, NOT_IMPORTANT);

        // when
        hero.equip(centaursAx);
        hero.addCreature(attacker);
        attacker.attack(defender);

        //then
        assertEquals(88, attacker.getAttack());
    }

    @Test
    void artifactThatAddsDefenceShouldWorksCorrectly(){
        // given
        Artefact damnedShield = ArtefactFactory.create("Shield of the Damned");
        Creature attacker = new Creature("Attacker",20,NOT_IMPORTANT,100,NOT_IMPORTANT);
        Creature defender = new Creature("Defender",NOT_IMPORTANT,10,100, NOT_IMPORTANT);

        // when
        hero.equip(damnedShield);
        hero.addCreature(defender);

        attacker.attack(defender);

        //then
        assertEquals(96, defender.getDefence());
    }
}
