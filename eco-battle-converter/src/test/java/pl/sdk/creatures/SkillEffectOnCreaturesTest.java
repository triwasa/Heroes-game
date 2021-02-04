package pl.sdk.creatures;

import com.google.common.collect.Range;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.sdk.hero.Hero;
import skills.Skill;
import skills.SkillApplier;
import skills.SkillFactory;
import skills.SkillSet;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class SkillEffectOnCreaturesTest {

    private SkillSet skillSet;
    private Hero hero;
    public static final int NOT_IMPORTANT = 5;
    Creature attacker;
    Creature defender;
    SkillApplier applier;
    List<Creature> creatures;

    @BeforeEach
    void init(){
        hero = new Hero();
        applier = new SkillApplier();
        creatures = new ArrayList<>();
        attacker = new Creature.BuilderForTesting()
                .name("attacker")
                .attack(5)
                .armor(NOT_IMPORTANT)
                .damage(Range.closed(50,50))
                .maxHp(NOT_IMPORTANT)
                .moveRange(NOT_IMPORTANT)
                .build();
        defender = new Creature.BuilderForTesting()
                .name("defender")
                .attack(NOT_IMPORTANT)
                .armor(0)
                .maxHp(200)
                .damage(Range.closed(NOT_IMPORTANT,NOT_IMPORTANT))
                .moveRange(NOT_IMPORTANT)
                .build();

    }
    //standard dmg = 62

    @Test
    void skillDontTurOffCounterAttacks() {
//        //offence zwiększa zadawany dmg o 10%
//        Skill offence = SkillFactory.createForTest("offence 1");
//        attacker = new BlockCounterAttackCreatureDecorator(new ShootingCreatureDecorator(attacker));
//        creatures.add(attacker);
//        hero.addCreatures(creatures);
//        applier.apply(offence, hero);
//        attacker = hero.getCreatures().get(0);
//        attacker.attack(defender);
//        assertEquals(5, attacker.getCurrentHp());
    }

    @Test
    void offenceShouldNotWorkOnRangeCreatures(){
//        Skill offence = SkillFactory.createForTest("offence 1");
//        attacker = new BlockCounterAttackCreatureDecorator(new ShootingCreatureDecorator(attacker));
//        creatures.add(attacker);
//        hero.addCreatures(creatures);
//        applier.apply(offence,hero);
//        attacker = hero.getCreatures().get(0);
//        attacker.attack(defender);
//        assertEquals(138,defender.getCurrentHp());
    }

    @Test
    void archeryShouldNotWorkOnMeleeCreatures(){
//        Skill offence = SkillFactory.createForTest("archery 1");
//        creatures.add(attacker);
//        hero.addCreatures(creatures);
//        applier.apply(offence,hero);
//        attacker = hero.getCreatures().get(0);
//        attacker.attack(defender);
//        assertEquals(138,defender.getCurrentHp());
    }

    @Test
    void offence1ShouldIncreaseDamage() {
//        //offence zwiększa zadawany dmg o 10%
//        Skill offence = SkillFactory.createForTest("offence 1");
//        creatures.add(attacker);
//        hero.addCreatures(creatures);
//        applier.apply(offence, hero);
//        attacker = hero.getCreatures().get(0);
//        attacker.attack(defender);
//        assertEquals(132, defender.getCurrentHp());
    }

    @Test
    void offence2ShouldIncreaseDamage(){
//        //offence zwiększa zadawany dmg o 10%
//        Skill offence = SkillFactory.createForTest("offence 2");
//        creatures.add(attacker);
//        hero.addCreatures(creatures);
//        applier.apply(offence,hero);
//        attacker = hero.getCreatures().get(0);
//        attacker.attack(defender);
//        assertEquals(126,defender.getCurrentHp());
    }

    @Test
    void offence3ShouldIncreaseDamage(){
//        //offence zwiększa zadawany dmg o 10%
//        Skill offence = SkillFactory.createForTest("offence 3");
//        creatures.add(attacker);
//        hero.addCreatures(creatures);
//        applier.apply(offence,hero);
//        attacker = hero.getCreatures().get(0);
//        attacker.attack(defender);
//        assertEquals(119,defender.getCurrentHp());
    }


    @Test
    void archery1ShouldIncreaseDamage(){
//        Skill archery = SkillFactory.createForTest("archery 1");
//        attacker = new BlockCounterAttackCreatureDecorator(new ShootingCreatureDecorator(attacker));
//        creatures.add(attacker);
//        hero.addCreatures(creatures);
//        applier.apply(archery,hero);
//        attacker = hero.getCreatures().get(0);
//        attacker.attack(defender);
//        assertEquals(132,defender.getCurrentHp());
    }

    @Test
    void archery2ShouldIncreaseDamage(){
//        Skill archery = SkillFactory.createForTest("archery 2");
//        attacker = new BlockCounterAttackCreatureDecorator(new ShootingCreatureDecorator(attacker));
//        creatures.add(attacker);
//        hero.addCreatures(creatures);
//        applier.apply(archery,hero);
//        attacker = hero.getCreatures().get(0);
//        attacker.attack(defender);
//        assertEquals(122,defender.getCurrentHp());
    }

    @Test
    void archery3ShouldIncreaseDamage(){
//        Skill archery = SkillFactory.createForTest("archery 3");
//        attacker = new BlockCounterAttackCreatureDecorator(new ShootingCreatureDecorator(attacker));
//        creatures.add(attacker);
//        hero.addCreatures(creatures);
//        applier.apply(archery,hero);
//        attacker = hero.getCreatures().get(0);
//        attacker.attack(defender);
//        assertEquals(107,defender.getCurrentHp());
    }

    @Test
    void SkillAppliedCorrectly() {
//        Creature attacker2 = new Creature.BuilderForTesting()
//                .name("attacker")
//                .attack(5)
//                .armor(NOT_IMPORTANT)
//                .damage(Range.closed(50, 50))
//                .maxHp(NOT_IMPORTANT)
//                .moveRange(NOT_IMPORTANT)
//                .build();
//        Skill archery = SkillFactory.createForTest("archery 1");
//        Skill offence = SkillFactory.createForTest("offence 2");
//        attacker = new BlockCounterAttackCreatureDecorator(new ShootingCreatureDecorator(attacker));
//        creatures.add(attacker);
//        creatures.add(attacker2);
//        hero.addCreatures(creatures);
//        applier.apply(archery, hero);
//        applier.apply(offence, hero);
//        attacker = hero.getCreatures().get(0);
//        attacker2 = hero.getCreatures().get(1);
//        attacker.attack(defender);
//        assertEquals(132, defender.getCurrentHp());
//        attacker2.attack(defender);
//        assertEquals(58, defender.getCurrentHp());
    }

    @Test
    void armourer1ShouldDecreaseDamage() {
//        Skill armourer = SkillFactory.createForTest("armourer 1");
//        creatures.add(defender);
//        hero.addCreatures(creatures);
//        applier.apply(armourer, hero);
//        defender = hero.getCreatures().get(0);
//        attacker.attack(defender);
//        assertEquals(141, defender.getCurrentHp());
    }

    @Test
    void armourer2ShouldDecreaseDamage() {
//        Skill armourer = SkillFactory.createForTest("armourer 2");
//        creatures.add(defender);
//        hero.addCreatures(creatures);
//        applier.apply(armourer, hero);
//        defender = hero.getCreatures().get(0);
//        attacker.attack(defender);
//        assertEquals(144, defender.getCurrentHp());
    }

    @Test
    void armourer3ShouldDecreaseDamage() {
//        Skill armourer = SkillFactory.createForTest("armourer 3");
//        creatures.add(defender);
//        hero.addCreatures(creatures);
//        applier.apply(armourer, hero);
//        defender = hero.getCreatures().get(0);
//        attacker.attack(defender);
//        assertEquals(147, defender.getCurrentHp());
    }

    @Test
    void artilleryShouldDecreaseDamage() {
//        Creature ballista = new Creature.BuilderForTesting()
//                            .name("ballista")
//                            .attack(5)
//                            .armor(NOT_IMPORTANT)
//                            .damage(Range.closed(50,50))
//                            .maxHp(NOT_IMPORTANT)
//                            .moveRange(NOT_IMPORTANT)
//                            .build();
//        Skill artillery = SkillFactory.createForTest("artillery 3");
//        creatures.add(ballista);
//        hero.addCreatures(creatures);
//        applier.apply(artillery, hero);
//        ballista = hero.getCreatures().get(0);
//        ballista.attack(defender);
//        assertEquals(76, defender.getCurrentHp());
    }

    @Test
    void artilleryShouldDecreaseDamage2() {
//        Creature ballista = new Creature.BuilderForTesting()
//                .name("ballista")
//                .attack(5)
//                .armor(NOT_IMPORTANT)
//                .damage(Range.closed(50,50))
//                .maxHp(NOT_IMPORTANT)
//                .moveRange(NOT_IMPORTANT)
//                .build();
//        Skill artillery = SkillFactory.createForTest("artillery 1");
//        creatures.add(ballista);
//        hero.addCreatures(creatures);
//        applier.apply(artillery, hero);
//        ballista = hero.getCreatures().get(0);
//        ballista.attack(defender);
//        assertEquals(76, defender.getCurrentHp());
    }

}
