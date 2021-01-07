package pl.sdk.hero;


import com.google.common.collect.Range;
import org.junit.jupiter.api.Test;
import pl.sdk.converter.Converter;
import pl.sdk.converter.EcoBattleConverter;
import pl.sdk.converter.Hero;
import pl.sdk.creatures.Creature;
import pl.sdk.creatures.EconomyNecropolisFactory;
import pl.sdk.creatures.NecropolisFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConverterTest {


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


    @Test
    void shouldConvertArtifactsCorrectly() {
        EconomyHero ecoHero = new EconomyHero(EconomyHero.Fraction.NECROPOLIS, 1000);
        ArtifactFactory factory = new ArtifactFactory();
        ecoHero.addArtifact(factory.create("Centaur's Ax"));
        ecoHero.addArtifact(factory.create("Blackshard of the Dead Knight"));
        ecoHero.addArtifact(factory.create("Greater Gnoll's Flail"));
        ecoHero.addArtifact(factory.create("Ogre's Club of Havoc"));
        ecoHero.addArtifact(factory.create("Sword of Hellfire"));

        Hero hero = Converter.convert(ecoHero);

        List<Artifact> convertedArtifacts = hero.getArtifacts();

        assertEquals(5, convertedArtifacts.size());

        assertEquals("Centaur's Ax",convertedArtifacts.get(0).getName());

        assertEquals("Blackshard of the Dead Knight",convertedArtifacts.get(1).getName());

        assertEquals("Greater Gnoll's Flail",convertedArtifacts.get(2).getName());

        assertEquals("Ogre's Club of Havoc",convertedArtifacts.get(3).getName());

        assertEquals("Sword of Hellfire",convertedArtifacts.get(4).getName());

    }

    @Test
    void shouldConvertSpellsCorrectly() {
        EconomyHero ecoHero = new EconomyHero(EconomyHero.Fraction.NECROPOLIS, 1000);
        SpellFactory factory = new SpellFactory();

        ecoHero.addSpell(factory.create("Shield", 2));
        ecoHero.addSpell(factory.create("Stoneskin", 1));
        ecoHero.addSpell(factory.create("Magic Arrow", 3));
        ecoHero.addSpell(factory.create("Death Ripple", 3));
        ecoHero.addSpell(factory.create("Fortune", 2));

        Hero hero = Converter.convert(ecoHero);

        List<Spell> convertedSpells = hero.getSpells();

        assertEquals(5, convertedSpells.size());

        assertEquals("Shield",convertedSpells.get(0).getName());
        assertEquals(2, convertedSpells.get(0).getLevel());

        assertEquals("Stoneskin",convertedSpells.get(1).getName());
        assertEquals(1, convertedSpells.get(1).getLevel());

        assertEquals("Magic Arrow",convertedSpells.get(2).getName());
        assertEquals(3, convertedSpells.get(2).getLevel());

        assertEquals("Death Ripple",convertedSpells.get(3).getName());
        assertEquals(3, convertedSpells.get(3).getLevel());

        assertEquals("Fortune",convertedSpells.get(4).getName());
        assertEquals(2, convertedSpells.get(4).getLevel());

    }

    @Test
    void shouldConvertSkillsCorrectly() {
        EconomyHero ecoHero = new EconomyHero(EconomyHero.Fraction.NECROPOLIS, 1000);
        SpellFactory factory = new SpellFactory();

        ecoHero.addSkill(factory.create("Archery", 2));
        ecoHero.addSkill(factory.create("Offence", 1));
        ecoHero.addSkill(factory.create("Armourer", 1));
        ecoHero.addSkill(factory.create("Resistance", 3));

        Hero hero = Converter.convert(ecoHero);

        List<Skill> convertedSkills = hero.getSkills();

        assertEquals(4, convertedSkills.size());

        assertEquals("Archery",convertedSkills.get(0).getName());
        assertEquals(2, convertedSkills.get(0).getLevel());

        assertEquals("Offence",convertedSkills.get(1).getName());
        assertEquals(1, convertedSkills.get(1).getLevel());

        assertEquals("Armourer",convertedSkills.get(2).getName());
        assertEquals(1, convertedSkills.get(2).getLevel());

        assertEquals("Resistance",convertedSkills.get(3).getName());
        assertEquals(3, convertedSkills.get(3).getLevel());
    }

    @Test
    void artifactShouldModifyPrimarySkill() {
        EconomyHero economyHero = new EconomyHero.Builder().attack(8).build();
        economyHero.putArtifact("Centaur's Ax");
        Hero hero = Converter.convert(economyHero);
        assertEquals(10, hero.getPrimaryAttack());
    }

    @Test
    void artifactShouldModifyAllPrimarySkills() {
        EconomyHero economyHero = new EconomyHero.Builder().attack(4).defence(4).spell(4).knowledge(4).build();
        economyHero.putArtifact("Helm of Heavenly Enlightenment");
        Hero hero = Converter.convert(economyHero);
        assertEquals(10, hero.getPrimaryAttack());
        assertEquals(10, hero.getPrimaryDefence());
        assertEquals(10, hero.getPrimarySpell());
        assertEquals(10, hero.getPrimaryKnowledge());
    }

    @Test
    void skillShouldBeAbleToModifyLuck() {
        EconomyNecropolisFactory ecoFactory = new EconomyNecropolisFactory();
        EconomyHero ecoHero = new EconomyHero(EconomyHero.Fraction.NECROPOLIS, 1000);

        ecoHero.putSkill("Luck", 3);

        Hero hero = Converter.convert(ecoHero);

        Creature aCreature = hero.getCreatures().get(0);
        assertEquals(3, aCreature.getLuck());

    }

    @Test
    void spellShouldAffectAttackersDamage() {
        EconomyNecropolisFactory ecoFactory = new EconomyNecropolisFactory();
        EconomyHero ecoHero = new EconomyHero(EconomyHero.Fraction.NECROPOLIS, 1000);
        ecoHero.addCreature(ecoFactory.create(true, 1, 1));

        ecoHero.putSpell("Curse", 1);

        Hero hero = Converter.convert(ecoHero);

        Creature creature = hero.getCreatures().get(0);
        Spell spell = hero.getSpells().get(0);

        Creature attacker = NecropolisFactory.createDefaultForTests();

        spell.castOn(attacker);

        attacker.attack(creature);

        // TODO
        // hp - minimum damage
        //assertEquals();

    }


}