package pl.sdk.hero;


import com.google.common.collect.Range;
import org.junit.jupiter.api.Test;
import pl.sdk.Hero;
import pl.sdk.artifacts.EconomyArtifactPrimary1Factory;
import pl.sdk.converter.Converter;
import pl.sdk.creatures.Creature;
import pl.sdk.creatures.EconomyNecropolisFactory;
import pl.sdk.creatures.NecropolisFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class ConverterTest {




    @Test
    void heroStatsAffectCreature(){
        EconomyHero ecoHero = new EconomyHero.Builder().attack(8).build();
        EconomyNecropolisFactory factory = new EconomyNecropolisFactory();
        ecoHero.addCreature(factory.create(false,1,1));

        Hero hero = Converter.convert(ecoHero);
        List<Creature> convertedCreatures = hero.getCreatures();

        assertEquals(4+8,convertedCreatures.get(0).getAttack());
    }


    @Test
    void artifactAffectsCreature() {
        EconomyHero ecoHero = new EconomyHero.Builder().attack(8).build();
        EconomyNecropolisFactory factory = new EconomyNecropolisFactory();
        EconomyArtifactPrimary1Factory artifactPrimary1Factory = new EconomyArtifactPrimary1Factory();
        ecoHero.addCreature(factory.create(false,1,1));
        ecoHero.addArtifact(artifactPrimary1Factory.create("Centaur's Ax"));

        Hero hero = Converter.convert(ecoHero);
        List<Creature> convertedCreatures = hero.getCreatures();

        assertEquals(8 + 2, convertedCreatures.get(0).getAttack());
    }

    @Test
    void skillAffectsCreature() {
        EconomyHero ecoHero = new EconomyHero.Builder().attack(8).build();
        EconomyNecropolisFactory factory = new EconomyNecropolisFactory();
        EconomySkillFactory skillFactory = new EconomySkillFactory();
        // 5 - lich is shooting creature
        ecoHero.addCreature(factory.create(false,5,1));
        // adds 50% to attack to all shooting creatures
        ecoHero.addSkill(skillFactory.create("Archery", 3));

        Hero hero = Converter.convert(ecoHero);
        List<Creature> convertedCreatures = hero.getCreatures();

        assertEquals(Range.closed(11 * 1.5, 15 * 1.5 ), convertedCreatures.get(0).getDamage());
    }

    @Test
    void skillDoesNotAffectCreatureWhenItDoesNotMeetConditions() {
        EconomyHero ecoHero = new EconomyHero.Builder().attack(8).build();
        EconomyNecropolisFactory factory = new EconomyNecropolisFactory();
        EconomySkillFactory skillFactory = new EconomySkillFactory();
        // 4 - not shooting creature
        ecoHero.addCreature(factory.create(false,4,1));
        // adds 50% to attack to all shooting creatures
        ecoHero.addSkill(skillFactory.create("Archery", 3));

        Hero hero = Converter.convert(ecoHero);
        List<Creature> convertedCreatures = hero.getCreatures();

        assertEquals(Range.closed(5, 8), convertedCreatures.get(0).getDamage());
    }


    @Test
    void artifactAffectsSpell() {
        NecropolisFactory necropolisFactory = new NecropolisFactory();
        EconomyHero ecoHero = new EconomyHero.Builder().power(7).build();
        EconomyArtifactPrimary1Factory artifactFactory = new EconomyArtifactPrimary1Factory();
        EconomySpellFactory spellFactory = new EconomySpellFactory();

        // Hero's fire spells to extra 50% damage
        ecoHero.addArtifact(artifactFactory.create("Orb of Tempstuous Fire"));
        // Target, enemy troop receives ((Power x 10) + 30) damage.
        ecoHero.addSpell(spellFactory.create("Magic Arrow", 3));

        Hero hero = Converter.convert(ecoHero);

        assertEquals((7 * 10 + 30) * 1.5 , hero.getSpells().get(0).getDamage());

    }

    @Test
    void skillAffectsSpell() {
        NecropolisFactory necropolisFactory = new NecropolisFactory();
        EconomyHero ecoHero = new EconomyHero.Builder().power(7).build();
        EconomySkillFactory skillFactory = new EconomySkillFactory();
        EconomySpellFactory spellFactory = new EconomySpellFactory();
        //  Fire Magic spells are cast at the expert level
        ecoHero.addSkill(skillFactory.create("Fire Magic", 3));
        // Target, enemy troop receives ((Power x 10) + 10) damage.
        ecoHero.addSpell(spellFactory.create("Magic Arrow", 1));

        Hero hero = Converter.convert(ecoHero);

        assertNotEquals(7 * 10 + 10 , hero.getSpells().get(0).getDamage());
        assertEquals(7 * 10 + 30 , hero.getSpells().get(0).getDamage());

    }

    @Test
    void skillLuckCanAffectCreatureLuck() {
        EconomyNecropolisFactory factory = new EconomyNecropolisFactory();
        EconomyHero ecoHero = new EconomyHero.Builder().build();
        ecoHero.addCreature(factory.create(false,5,1));
        ecoHero.addSkill("Luck", 3);

        Hero hero = Converter.convert(ecoHero);

        assertEquals(3, hero.getCreatures().get(0).getLuck());
    }


    @Test
    void shouldConvertCreaturesCorrectly(){
        EconomyHero ecoHero = new EconomyHero(EconomyHero.Fraction.NECROPOLIS, 1000);
        EconomyNecropolisFactory factory = new EconomyNecropolisFactory();
        ecoHero.addCreature(factory.create(false,1,1));
        ecoHero.addCreature(factory.create(false,2,2));
        ecoHero.addCreature(factory.create(false,3,3));
        ecoHero.addCreature(factory.create(false,4,4));
        ecoHero.addCreature(factory.create(false,5,5));
        ecoHero.addCreature(factory.create(false,6,6));
        ecoHero.addCreature(factory.create(false,7,7));

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
//
//
//    @Test
//    void shouldConvertArtifactsCorrectly() {
//        EconomyHero ecoHero = new EconomyHero(EconomyHero.Fraction.NECROPOLIS, 1000);
//        ArtifactFactory factory = new ArtifactFactory();
//        ecoHero.addArtifact(factory.create("Centaur's Ax"));
//        ecoHero.addArtifact(factory.create("Blackshard of the Dead Knight"));
//        ecoHero.addArtifact(factory.create("Greater Gnoll's Flail"));
//        ecoHero.addArtifact(factory.create("Ogre's Club of Havoc"));
//        ecoHero.addArtifact(factory.create("Sword of Hellfire"));
//
//        Hero hero = Converter.convert(ecoHero);
//
//        List<Artifact> convertedArtifacts = hero.getArtifacts();
//
//        assertEquals(5, convertedArtifacts.size());
//
//        assertEquals("Centaur's Ax",convertedArtifacts.get(0).getName());
//
//        assertEquals("Blackshard of the Dead Knight",convertedArtifacts.get(1).getName());
//
//        assertEquals("Greater Gnoll's Flail",convertedArtifacts.get(2).getName());
//
//        assertEquals("Ogre's Club of Havoc",convertedArtifacts.get(3).getName());
//
//        assertEquals("Sword of Hellfire",convertedArtifacts.get(4).getName());
//
//    }
//
//    @Test
//    void shouldConvertSpellsCorrectly() {
//        EconomyHero ecoHero = new EconomyHero(EconomyHero.Fraction.NECROPOLIS, 1000);
//        SpellFactory factory = new SpellFactory();
//
//        ecoHero.addSpell(factory.create("Shield", 2));
//        ecoHero.addSpell(factory.create("Stoneskin", 1));
//        ecoHero.addSpell(factory.create("Magic Arrow", 3));
//        ecoHero.addSpell(factory.create("Death Ripple", 3));
//        ecoHero.addSpell(factory.create("Fortune", 2));
//
//        Hero hero = Converter.convert(ecoHero);
//
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
//
//    }
//
//    @Test
//    void shouldConvertSkillsCorrectly() {
//        EconomyHero ecoHero = new EconomyHero(EconomyHero.Fraction.NECROPOLIS, 1000);
//        SpellFactory factory = new SpellFactory();
//
//        ecoHero.addSkill(factory.create("Archery", 2));
//        ecoHero.addSkill(factory.create("Offence", 1));
//        ecoHero.addSkill(factory.create("Armourer", 1));
//        ecoHero.addSkill(factory.create("Resistance", 3));
//
//        Hero hero = Converter.convert(ecoHero);
//
//        List<Skill> convertedSkills = hero.getSkills();
//
//        assertEquals(4, convertedSkills.size());
//
//        assertEquals("Archery",convertedSkills.get(0).getName());
//        assertEquals(2, convertedSkills.get(0).getLevel());
//
//        assertEquals("Offence",convertedSkills.get(1).getName());
//        assertEquals(1, convertedSkills.get(1).getLevel());
//
//        assertEquals("Armourer",convertedSkills.get(2).getName());
//        assertEquals(1, convertedSkills.get(2).getLevel());
//
//        assertEquals("Resistance",convertedSkills.get(3).getName());
//        assertEquals(3, convertedSkills.get(3).getLevel());
//    }
//
}