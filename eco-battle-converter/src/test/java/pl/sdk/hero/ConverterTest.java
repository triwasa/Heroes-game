package pl.sdk.hero;


import com.google.common.collect.Range;
import org.junit.jupiter.api.Test;
import pl.sdk.artifacts.EconomyArtifactPrimaryFactory;
import pl.sdk.converter.Converter;
import pl.sdk.creatures.Creature;
import pl.sdk.creatures.EconomyCreature;
import pl.sdk.creatures.EconomyNecropolisFactory;
import pl.sdk.creatures.NecropolisFactory;
import pl.sdk.skills.EconomySkillFactory;
import pl.sdk.spell.EconomySpellFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static pl.sdk.hero.HeroClassName.DEATH_KNIGHT;

class ConverterTest {

    private static final int NOT_IMPORTANT = 5;
    private final EconomyNecropolisFactory economyCreatureNecropolisFactory = new EconomyNecropolisFactory();
    private final EconomyArtifactPrimaryFactory economyArtifactFactory = new EconomyArtifactPrimaryFactory();
    private final EconomySkillFactory economySkillFactory = new EconomySkillFactory();
    private final EconomySpellFactory economySpellFactory = new EconomySpellFactory();
    private final NecropolisFactory necropolisFactory = new NecropolisFactory();

    @Test
    void heroStatsShouldAffectCreatureStats(){
        EconomyHero economyHero = new EconomyHero(EconomyHero.Fraction.NECROPOLIS, DEATH_KNIGHT, NOT_IMPORTANT);

        economyHero.addCreature(economyCreatureNecropolisFactory.create(false,1,1));

        Hero hero = Converter.convert(economyHero);

        assertEquals(5 + 1, hero.getCreatures().get(0).getAttack());
        assertEquals(4 + 2, hero.getCreatures().get(0).getArmor());
    }


    @Test
    void artifactShouldAffectCreatureStats() {
        EconomyHero economyHero = new EconomyHero(EconomyHero.Fraction.NECROPOLIS, DEATH_KNIGHT, NOT_IMPORTANT);

        economyHero.addCreature(economyCreatureNecropolisFactory.create(false,1,1));
        economyHero.addArtifact(economyArtifactFactory.create("Dragon Scale Shield"));

        Hero hero = Converter.convert(economyHero);

        assertEquals(1 + 5 + 3, hero.getCreatures().get(0).getAttack());
        assertEquals(2 + 4 + 3, hero.getCreatures().get(0).getArmor());
    }

    @Test
    void skillShouldAffectCreature() {
        EconomyHero economyHero = new EconomyHero(EconomyHero.Fraction.NECROPOLIS, DEATH_KNIGHT, NOT_IMPORTANT);

        // 5 - lich is shooting creature
        economyHero.addCreature(economyCreatureNecropolisFactory.create(false,5,1));
        // adds 50% damage to attack to all shooting creatures
        economyHero.addSkill(economySkillFactory.create("Archery", 3));

        Creature creature = necropolisFactory.create(false,5,1);
        int lowerEndpoint = creature.getBasicDamage().lowerEndpoint();
        int upperEndpoint = creature.getBasicDamage().upperEndpoint();

        Hero hero = Converter.convert(economyHero);

        assertEquals(Range.closed( (int) Math.round(lowerEndpoint * 1.5), (int) Math.round(upperEndpoint * 1.5)), hero.getCreatures().get(0).getDamage());
    }

    @Test
    void skillDoesNotAffectCreatureWhenItDoesNotMeetConditions() {
        EconomyHero economyHero = new EconomyHero(EconomyHero.Fraction.NECROPOLIS, DEATH_KNIGHT, NOT_IMPORTANT);

        // 4 - not shooting creature
        economyHero.addCreature(economyCreatureNecropolisFactory.create(false,4,1));
        // adds 50% to attack to all shooting creatures
        economyHero.addSkill(economySkillFactory.create("Archery", 3));

        Creature creature = necropolisFactory.create(false,4,1);
        int lowerEndpoint = creature.getBasicDamage().lowerEndpoint();
        int upperEndpoint = creature.getBasicDamage().upperEndpoint();

        Hero hero = Converter.convert(economyHero);

        assertEquals(Range.closed( lowerEndpoint, upperEndpoint), hero.getCreatures().get(0).getDamage());
    }


    @Test
    void artifactAffectsSpell() {
//        EconomyHero economyHero = new EconomyHero(EconomyHero.Fraction.NECROPOLIS, DEATH_KNIGHT, NOT_IMPORTANT);
//
//        // Hero's fire spells to extra 50% damage
//        economyHero.addArtifact(economyArtifactFactory.create("Orb of Tempstuous Fire"));
//        // Target, enemy troop receives ((Power x 10) + 30) damage.
//        economyHero.addSpell(economySpellFactory.create("Magic Arrow", 3));
//
//        Hero hero = Converter.convert(economyHero);
//
//        assertEquals((10 * 10 + 30) * 1.5 , hero.getSpells().get(0).getDamage());
    }

    @Test
    void skillAffectsSpell() {
//        EconomyHero economyHero = new EconomyHero(EconomyHero.Fraction.NECROPOLIS, DEATH_KNIGHT, NOT_IMPORTANT);
//
//        //  Fire Magic spells are cast at the expert level
//        economyHero.addSkill(economySkillFactory.create("Fire Magic", 3));
//        // Target, enemy troop receives ((Power x 10) + 10) damage.
//        economyHero.addSpell(economySpellFactory.create("Magic Arrow", 1));
//
//        Hero hero = Converter.convert(economyHero);
//
//        assertNotEquals(10 * 10 + 10 , hero.getSpells().get(0).getDamage());
//        assertEquals(10 * 10 + 30 , hero.getSpells().get(0).getDamage());
    }

    @Test
    void skillLuckCanAffectCreatureLuck() {
//        EconomyHero economyHero = new EconomyHero(EconomyHero.Fraction.NECROPOLIS, DEATH_KNIGHT, NOT_IMPORTANT);
//
//        economyHero.addCreature(economyCreatureNecropolisFactory.create(false,5,1));
//        economyHero.addSkill(economySkillFactory.create("Luck", 3));
//
//        Hero hero = Converter.convert(economyHero);
//
//        assertEquals(3, hero.getCreatures().get(0).getLuck());
    }


    @Test
    void shouldConvertCreaturesCorrectly(){
        EconomyHero ecoHero = new EconomyHero(EconomyHero.Fraction.NECROPOLIS,  DEATH_KNIGHT, NOT_IMPORTANT);
        ecoHero.addCreature(economyCreatureNecropolisFactory.create(false,1,1));
        ecoHero.addCreature(economyCreatureNecropolisFactory.create(false,2,2));
        ecoHero.addCreature(economyCreatureNecropolisFactory.create(false,3,3));
        ecoHero.addCreature(economyCreatureNecropolisFactory.create(false,4,4));
        ecoHero.addCreature(economyCreatureNecropolisFactory.create(false,5,5));
        ecoHero.addCreature(economyCreatureNecropolisFactory.create(false,6,6));
        ecoHero.addCreature(economyCreatureNecropolisFactory.create(false,7,7));

        Hero hero = Converter.convert(ecoHero);
        List<Creature> convertedCreatures = hero.getCreatures();

        assertEquals(7,convertedCreatures.size());

        assertEquals("Skeleton",convertedCreatures.get(0).getName());
        assertEquals(1,convertedCreatures.get(0).getAmount());

        assertEquals("Walking Dead",convertedCreatures.get(1).getName());
        assertEquals(2,convertedCreatures.get(1).getAmount());

        assertEquals("Wight",convertedCreatures.get(2).getName());
        assertEquals(3,convertedCreatures.get(2).getAmount());

        assertEquals("Vampire",convertedCreatures.get(3).getName());
        assertEquals(4,convertedCreatures.get(3).getAmount());

        assertEquals("Lich",convertedCreatures.get(4).getName());
        assertEquals(5,convertedCreatures.get(4).getAmount());

        assertEquals("Black Knight",convertedCreatures.get(5).getName());
        assertEquals(6,convertedCreatures.get(5).getAmount());

        assertEquals("Bone Dragon",convertedCreatures.get(6).getName());
        assertEquals(7,convertedCreatures.get(6).getAmount());
    }


    @Test
    void shouldConvertSpellsCorrectly() {
//        EconomyHero ecoHero = new EconomyHero(EconomyHero.Fraction.NECROPOLIS, DEATH_KNIGHT,  NOT_IMPORTANT);
//
//        ecoHero.addSpell(economySpellFactory.create("Shield", 2));
//        ecoHero.addSpell(economySpellFactory.create("Stoneskin", 1));
//        ecoHero.addSpell(economySpellFactory.create("Magic Arrow", 3));
//        ecoHero.addSpell(economySpellFactory.create("Death Ripple", 3));
//        ecoHero.addSpell(economySpellFactory.create("Fortune", 2));
//
//        Hero hero = Converter.convert(ecoHero);
//        List<Spell> convertedSpells = hero.getSpells();
//
//        assertEquals(5, convertedSpells.size());
//
//        assertEquals("Shield",convertedSpells.get(0).getName());
//        assertEquals(2, convertedSpells.get(0).getLevel());
//
//        assertEquals("Stoneskin",convertedSpells.get(1).getName());
//        assertEquals(1, convertedSpells.get(1).getLevel());
//
//        assertEquals("Magic Arrow",convertedSpells.get(2).getName());
//        assertEquals(3, convertedSpells.get(2).getLevel());
//
//        assertEquals("Death Ripple",convertedSpells.get(3).getName());
//        assertEquals(3, convertedSpells.get(3).getLevel());
//
//        assertEquals("Fortune",convertedSpells.get(4).getName());
//        assertEquals(2, convertedSpells.get(4).getLevel());
    }
}