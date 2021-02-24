package pl.sdk.hero;

import com.google.common.collect.Range;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.sdk.creatures.*;
import pl.sdk.skills.EconomySkillFactory;
import pl.sdk.spell.EconomySpellFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static pl.sdk.converter.Converter.convert;
import static pl.sdk.hero.HeroClassName.DEATH_KNIGHT;

public class SkillsConvertTest {

    private static final int NOT_IMPORTANT = 500;
    private final EconomyNecropolisFactory economyCreatureNecropolisFactory = new EconomyNecropolisFactory();
    private final EconomyTowerFactory economyTowerFactory = new EconomyTowerFactory();
    private final WarMachineFactory warMachineFactory = new WarMachineFactory();
    private final EconomySkillFactory economySkillFactory = new EconomySkillFactory();
    private final EconomySpellFactory economySpellFactory = new EconomySpellFactory();
    private final NecropolisFactory necropolisFactory = new NecropolisFactory();
    private final EconomyWarmachineFactory economyWarmachineFactory = new EconomyWarmachineFactory();
    private EconomyHero economyHero;
    private Hero hero;

    @BeforeEach
    void init(){
        economyHero = new EconomyHero(DEATH_KNIGHT, NOT_IMPORTANT);
    }

    // ADDING SKILLS ABOVE LEVEL 1 NOT WORKING

    @Test
    void offenceShouldNotWorkOnRangeCreatures(){

        economyHero.addCreature(economyCreatureNecropolisFactory.create(false,5,1));
        economyHero.addSkill(economySkillFactory.create("offence", 3));

        Creature creature = necropolisFactory.create(false,5,1);
        int lowerEndpoint = creature.getBasicDamage().lowerEndpoint();
        int upperEndpoint = creature.getBasicDamage().upperEndpoint();

        hero = convert(economyHero);

        assertEquals(Range.closed( lowerEndpoint, upperEndpoint), hero.getCreatures().get(0).getDamage());
    }

    @Test
    void offence1() {
        economyHero.addCreature(economyCreatureNecropolisFactory.create(false,1,1));
        economyHero.addSkill(economySkillFactory.create("offence", 1));

        Creature creature = necropolisFactory.create(false,1,1);
        int lowerEndpoint = creature.getBasicDamage().lowerEndpoint();
        int upperEndpoint = creature.getBasicDamage().upperEndpoint();

        hero = convert(economyHero);

        assertEquals(Range.closed( (int) Math.round(lowerEndpoint * 0.1) + lowerEndpoint, (int) Math.round(upperEndpoint * 0.1) + upperEndpoint), hero.getCreatures().get(0).getDamage());
    }

    @Test
    void offence2() {
        economyHero.addCreature(economyCreatureNecropolisFactory.create(false,1,1));
        economyHero.addSkill(economySkillFactory.create("offence", 2));

        Creature creature = necropolisFactory.create(false,1,1);
        int lowerEndpoint = creature.getBasicDamage().lowerEndpoint();
        int upperEndpoint = creature.getBasicDamage().upperEndpoint();

        hero = convert(economyHero);

        assertEquals(Range.closed( (int) Math.round(lowerEndpoint * 0.2) + lowerEndpoint, (int) Math.round(upperEndpoint * 0.2) + upperEndpoint), hero.getCreatures().get(0).getDamage());
    }

    @Test
    void offence3() {
        economyHero.addCreature(economyCreatureNecropolisFactory.create(false,1,1));
        economyHero.addSkill(economySkillFactory.create("offence", 3));

        Creature creature = necropolisFactory.create(false,1,1);
        int lowerEndpoint = creature.getBasicDamage().lowerEndpoint();
        int upperEndpoint = creature.getBasicDamage().upperEndpoint();

        hero = convert(economyHero);

        assertEquals(Range.closed( (int) Math.round(lowerEndpoint * 0.3) + lowerEndpoint, (int) Math.round(upperEndpoint * 0.3) + upperEndpoint), hero.getCreatures().get(0).getDamage());
    }

    @Test
    void archeryShouldNotWorkOnNotRangeCreatures(){
        economyHero.addCreature(economyCreatureNecropolisFactory.create(false,1,1));
        economyHero.addSkill(economySkillFactory.create("archery", 3));

        Creature creature = necropolisFactory.create(false,1,1);
        int lowerEndpoint = creature.getBasicDamage().lowerEndpoint();
        int upperEndpoint = creature.getBasicDamage().upperEndpoint();

        hero = convert(economyHero);

        assertEquals(Range.closed( lowerEndpoint, upperEndpoint), hero.getCreatures().get(0).getDamage());
    }

    @Test
    void archery1() {
        economyHero.addCreature(economyCreatureNecropolisFactory.create(false,5,1));
        economyHero.addSkill(economySkillFactory.create("archery", 1));

        Creature creature = necropolisFactory.create(false,5,1);
        int lowerEndpoint = creature.getBasicDamage().lowerEndpoint();
        int upperEndpoint = creature.getBasicDamage().upperEndpoint();

        hero = convert(economyHero);

        assertEquals(Range.closed( (int) Math.round(lowerEndpoint * 0.1) + lowerEndpoint, (int) Math.round(upperEndpoint * 0.1) + upperEndpoint), hero.getCreatures().get(0).getDamage());
    }

    @Test
    void archery2() {
        economyHero.addCreature(economyCreatureNecropolisFactory.create(false,5,1));
        economyHero.addSkill(economySkillFactory.create("archery", 2));

        Creature creature = necropolisFactory.create(false,5,1);
        int lowerEndpoint = creature.getBasicDamage().lowerEndpoint();
        int upperEndpoint = creature.getBasicDamage().upperEndpoint();

        hero = convert(economyHero);

        assertEquals(Range.closed( (int) Math.round(lowerEndpoint * 0.25) + lowerEndpoint, (int) Math.round(upperEndpoint * 0.25) + upperEndpoint), hero.getCreatures().get(0).getDamage());
    }

    @Test
    void archery3() {
        economyHero.addCreature(economyCreatureNecropolisFactory.create(false,5,1));
        economyHero.addSkill(economySkillFactory.create("archery", 3));

        Creature creature = necropolisFactory.create(false,5,1);
        int lowerEndpoint = creature.getBasicDamage().lowerEndpoint();
        int upperEndpoint = creature.getBasicDamage().upperEndpoint();

        hero = convert(economyHero);

        assertEquals(Range.closed( (int) Math.round(lowerEndpoint * 0.5) + lowerEndpoint, (int) Math.round(upperEndpoint * 0.5) + upperEndpoint), hero.getCreatures().get(0).getDamage());
    }

    @Test
    void armourerDecoratesCreature() {
        economyHero.addCreature(economyCreatureNecropolisFactory.create(false,1,1));
        economyHero.addSkill(economySkillFactory.create("armourer", 1));

        hero = convert(economyHero);

        Class<?> a = hero.getCreatures().get(0).getClass();
        Class<?> b = PercentDamageReduceCreatureDecorator.class;

        assertTrue(b.isAssignableFrom(a));
    }

    @Test
    void armourer1() {
        economyHero.addCreature(economyTowerFactory.create(true,6,1));

        EconomyHero economyHero2 = new EconomyHero(DEATH_KNIGHT, NOT_IMPORTANT);
        economyHero2.addCreature(economyTowerFactory.create(true,6,1));
        economyHero2.addSkill(economySkillFactory.create("armourer", 1));

        Hero hero2 = convert(economyHero2);
        hero = convert(economyHero);

        hero.getCreatures().get(0).getAttackStrategy().attack(hero.getCreatures().get(0), hero2.getCreatures().get(0));

        assertEquals(79, hero2.getCreatures().get(0).getCurrentHp());
    }

    @Test
    void armourer2() {
        economyHero.addCreature(economyTowerFactory.create(true,6,1));

        EconomyHero economyHero2 = new EconomyHero(DEATH_KNIGHT, NOT_IMPORTANT);
        economyHero2.addCreature(economyTowerFactory.create(true,6,1));
        economyHero2.addSkill(economySkillFactory.create("armourer", 2));

        Hero hero2 = convert(economyHero2);
        hero = convert(economyHero);

        hero.getCreatures().get(0).getAttackStrategy().attack(hero.getCreatures().get(0), hero2.getCreatures().get(0));

        assertEquals(80, hero2.getCreatures().get(0).getCurrentHp());
    }

    @Test
    void armourer3() {
        economyHero.addCreature(economyTowerFactory.create(true,6,1));

        EconomyHero economyHero2 = new EconomyHero(DEATH_KNIGHT, NOT_IMPORTANT);
        economyHero2.addCreature(economyTowerFactory.create(true,6,1));
        economyHero2.addSkill(economySkillFactory.create("armourer", 3));

        Hero hero2 = convert(economyHero2);
        hero = convert(economyHero);

        hero.getCreatures().get(0).getAttackStrategy().attack(hero.getCreatures().get(0), hero2.getCreatures().get(0));

        assertEquals(82, hero2.getCreatures().get(0).getCurrentHp());
    }

    @Test
    void leadership1() {
        economyHero.addSkill(economySkillFactory.create("leadership", 1));

        hero = convert(economyHero);

        assertEquals(1, hero.getMorale());
    }

    @Test
    void leadership2() {
        economyHero.addSkill(economySkillFactory.create("leadership", 2));

        hero = convert(economyHero);

        assertEquals(2, hero.getMorale());
    }

    @Test
    void leadership3() {
        economyHero.addSkill(economySkillFactory.create("leadership", 3));

        hero = convert(economyHero);

        assertEquals(3, hero.getMorale());
    }

    @Test
    void luck1() {
        economyHero.addSkill(economySkillFactory.create("luck", 1));

        hero = convert(economyHero);

        assertEquals(1, hero.getLuck());
    }

    @Test
    void luck2() {
        economyHero.addSkill(economySkillFactory.create("luck", 2));

        hero = convert(economyHero);

        assertEquals(2, hero.getLuck());
    }

    @Test
    void luck3() {
        economyHero.addSkill(economySkillFactory.create("luck", 3));

        hero = convert(economyHero);

        assertEquals(3, hero.getLuck());
    }

    @Test
    void resistance1() {
        economyHero.addCreature(economyCreatureNecropolisFactory.create(false,1,1));
        economyHero.addSkill(economySkillFactory.create("resistance", 1));

        hero = convert(economyHero);

        assertEquals(5, hero.getCreatures().get(0).getResistance());
    }

    @Test
    void resistance2() {
        economyHero.addCreature(economyCreatureNecropolisFactory.create(false,1,1));
        economyHero.addSkill(economySkillFactory.create("resistance", 2));

        hero = convert(economyHero);

        assertEquals(10, hero.getCreatures().get(0).getResistance());
    }

    @Test
    void resistance3() {
        economyHero.addCreature(economyCreatureNecropolisFactory.create(false,1,1));
        economyHero.addSkill(economySkillFactory.create("resistance", 3));

        hero = convert(economyHero);

        assertEquals(20, hero.getCreatures().get(0).getResistance());
    }

    @Test
    void artillery() {
        economyHero.addCreature(economyTowerFactory.create(true,6,1));

        EconomyHero economyHero2 = new EconomyHero(DEATH_KNIGHT, NOT_IMPORTANT);
        economyHero2.addCreature(economyWarmachineFactory.create(false,3,1));
        economyHero2.addSkill(economySkillFactory.create("artillery", 3));

        Hero hero2 = convert(economyHero2);
        hero = convert(economyHero);

        hero2.getMachines().get(0).getAttackStrategy().attack(hero2.getMachines().get(0), hero.getCreatures().get(0));

        assertTrue(98 == hero.getCreatures().get(0).getCurrentHp() || hero.getCreatures().get(0).getCurrentHp()== 102);
    }

    @Test
    void intelligence1() {
        economyHero.addSkill(economySkillFactory.create("intelligence", 1));

        hero = convert(economyHero);

        assertEquals((int) Math.round(10.0 * 1.25), hero.getMana());
    }

    @Test
    void intelligence2() {
        economyHero.addSkill(economySkillFactory.create("intelligence", 2));

        hero = convert(economyHero);

        assertEquals((int) Math.round(10.0 * 1.5), hero.getMana());
    }

    @Test
    void intelligence3() {
        economyHero.addSkill(economySkillFactory.create("intelligence", 3));

        hero = convert(economyHero);

        assertEquals((int) Math.round(10.0 * 2.0), hero.getMana());
    }

    @Test
    void fireMagic1() {
//        economyHero.addSkill(economySkillFactory.create("Fire Magic", 1));
//        economyHero.addSpell(economySpellFactory.create("Magic Arrow"));
//
//        hero = convert(economyHero);
//
//        assertEquals(20 * 10 + 10 , hero.getSpells().stream().findFirst().get().getDamage());
    }

    @Test
    void fireMagic2() {
//        economyHero.addSkill(economySkillFactory.create("Fire Magic", 2));
//        economyHero.addSpell(economySpellFactory.create("Magic Arrow"));
//
//        hero = convert(economyHero);
//
//        assertEquals(20 * 10 + 20 , hero.getSpells().stream().findFirst().get().getDamage());
    }

    @Test
    void fireMagic3() {
//        economyHero.addSkill(economySkillFactory.create("Fire Magic", 3));
//        economyHero.addSpell(economySpellFactory.create("Magic Arrow"));
//
//        hero = convert(economyHero);
//
//        assertEquals(20 * 10 + 30 , hero.getSpells().stream().findFirst().get().getDamage());
    }

    @Test
    void earthMagic1() {
//        economyHero.addSkill(economySkillFactory.create("Earth Magic", 1));
//        economyHero.addSpell(economySpellFactory.create("Magic Arrow"));
//
//        hero = convert(economyHero);
//
//        assertEquals(20 * 10 + 10 , hero.getSpells().stream().findFirst().get().getDamage());
    }

    @Test
    void earthMagic2() {
//        economyHero.addSkill(economySkillFactory.create("Earth Magic", 2));
//        economyHero.addSpell(economySpellFactory.create("Magic Arrow"));
//
//        hero = convert(economyHero);
//
//        assertEquals(20 * 10 + 20 , hero.getSpells().stream().findFirst().get().getDamage());
    }

    @Test
    void earthMagic3() {
//        economyHero.addSkill(economySkillFactory.create("Earth Magic", 3));
//        economyHero.addSpell(economySpellFactory.create("Magic Arrow"));
//
//        hero = convert(economyHero);
//
//        assertEquals(20 * 10 + 30 , hero.getSpells().stream().findFirst().get().getDamage());
    }


    @Test
    void waterMagic1() {
//        economyHero.addSkill(economySkillFactory.create("Water Magic", 1));
//        economyHero.addSpell(economySpellFactory.create("Magic Arrow"));
//
//        hero = convert(economyHero);
//
//        assertEquals(20 * 10 + 10 , hero.getSpells().stream().findFirst().get().getDamage());
    }

    @Test
    void waterMagic2() {
//        economyHero.addSkill(economySkillFactory.create("Water Magic", 2));
//        economyHero.addSpell(economySpellFactory.create("Magic Arrow"));
//
//        hero = convert(economyHero);
//
//        assertEquals(20 * 10 + 20 , hero.getSpells().stream().findFirst().get().getDamage());
    }

    @Test
    void waterMagic3() {
//        economyHero.addSkill(economySkillFactory.create("Water Magic", 3));
//        economyHero.addSpell(economySpellFactory.create("Magic Arrow"));
//
//        hero = convert(economyHero);
//
//        assertEquals(20 * 10 + 30 , hero.getSpells().stream().findFirst().get().getDamage());
    }

    @Test
    void airMagic1() {
//        economyHero.addSkill(economySkillFactory.create("Air Magic", 1));
//        economyHero.addSpell(economySpellFactory.create("Magic Arrow"));
//
//        hero = convert(economyHero);
//
//        assertEquals(20 * 10 + 10 , hero.getSpells().stream().findFirst().get().getDamage());
    }

    @Test
    void airMagic2() {
//        economyHero.addSkill(economySkillFactory.create("Air Magic", 2));
//        economyHero.addSpell(economySpellFactory.create("Magic Arrow"));
//
//        hero = convert(economyHero);
//
//        assertEquals(20 * 10 + 20 , hero.getSpells().stream().findFirst().get().getDamage());
    }

    @Test
    void airMagic3() {
//        economyHero.addSkill(economySkillFactory.create("Air Magic", 3));
//        economyHero.addSpell(economySpellFactory.create("Magic Arrow"));
//
//        hero = convert(economyHero);
//
//        assertEquals(20 * 10 + 30 , hero.getSpells().stream().findFirst().get().getDamage());
    }
}
