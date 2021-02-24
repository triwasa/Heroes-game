package pl.sdk.hero;


import org.junit.jupiter.api.Test;
import static pl.sdk.converter.Converter.convert;

import pl.sdk.artifacts.ArtifactName;
import pl.sdk.artifacts.EconomyArtifactPrimaryFactory;
import pl.sdk.creatures.Creature;
import pl.sdk.creatures.EconomyNecropolisFactory;
import pl.sdk.creatures.EconomyWarmachineFactory;
import pl.sdk.skills.EconomySkillFactory;
import pl.sdk.spell.EconomySpellFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static pl.sdk.hero.HeroClassName.DEATH_KNIGHT;

class ConverterTest {

    private static final int NOT_IMPORTANT = 500;
    private final EconomyNecropolisFactory economyCreatureNecropolisFactory = new EconomyNecropolisFactory();
    private final EconomySkillFactory economySkillFactory = new EconomySkillFactory();
    private final EconomyArtifactPrimaryFactory economyArtifactPrimaryFactory = new EconomyArtifactPrimaryFactory();
    private final EconomyWarmachineFactory economyWarmachineFactory = new EconomyWarmachineFactory();
    private final EconomySpellFactory economySpellFactory = new EconomySpellFactory();


    @Test
    void heroStatsShouldAffectCreatureStats(){
        EconomyHero economyHero = new EconomyHero(DEATH_KNIGHT, NOT_IMPORTANT);
        economyHero.addCreature(economyCreatureNecropolisFactory.create(false,1,1));

        Hero hero = convert(economyHero);

        assertEquals(5 + 1, hero.getCreatures().get(0).getAttack());
        assertEquals(4 + 2, hero.getCreatures().get(0).getArmor());
    }

    @Test
    void shouldConvertHeroCorrectly() {
        EconomyHero economyHero = new EconomyHero(DEATH_KNIGHT, NOT_IMPORTANT);
        economyHero.addCreature(economyCreatureNecropolisFactory.create(false,1,1));
        economyHero.addCreature(economyWarmachineFactory.create(false, 1, 1));
        economyHero.addSkill(economySkillFactory.create("intelligence", 1));
        economyHero.addSkill(economySkillFactory.create("resistance", 1));
        //economyHero.addSpell(economySpellFactory.create("Magic Arrow"));
        economyHero.addArtifact(economyArtifactPrimaryFactory.create(ArtifactName.HELM_OF_HEAVENLY_ENLIGHTENMENT));

        Hero hero = convert(economyHero);

        assertEquals("Catapult", hero.getMachines().get(0).getName());
        assertEquals(1 + 6 + 5, hero.getCreatures().get(0).getAttack());
        assertEquals(Math.round((1 + 6) * 10 * 1.25), hero.getMana());
        assertEquals(5, hero.getCreatures().get(0).getResistance());
        //assertEquals("Magic Arrow", hero.getSpells().stream().findFirst().get().getName());

    }

    @Test
    void shouldConvertCreaturesCorrectly(){
        EconomyHero ecoHero = new EconomyHero(DEATH_KNIGHT, NOT_IMPORTANT);
        ecoHero.addCreature(economyCreatureNecropolisFactory.create(false,1,1));
        ecoHero.addCreature(economyCreatureNecropolisFactory.create(false,2,2));
        ecoHero.addCreature(economyCreatureNecropolisFactory.create(false,3,3));
        ecoHero.addCreature(economyCreatureNecropolisFactory.create(false,4,4));
        ecoHero.addCreature(economyCreatureNecropolisFactory.create(false,5,5));
        ecoHero.addCreature(economyCreatureNecropolisFactory.create(false,6,6));
        ecoHero.addCreature(economyCreatureNecropolisFactory.create(false,7,7));

        Hero hero = convert(ecoHero);
        List<Creature> convertedCreatures = hero.getCreatures();

        assertEquals(convertedCreatures.get(0).getClass(), Creature.class);

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


//    @Test
//    void shouldConvertSpellsCorrectly() {
//        EconomyHero ecoHero = new EconomyHero(DEATH_KNIGHT,  NOT_IMPORTANT);
//
//        ecoHero.addSpell(economySpellFactory.create("Shield", 2));
//        ecoHero.addSpell(economySpellFactory.create("Stoneskin", 1));
//        ecoHero.addSpell(economySpellFactory.create("Magic Arrow", 3));
//        ecoHero.addSpell(economySpellFactory.create("Death Ripple", 3));
//        ecoHero.addSpell(economySpellFactory.create("Fortune", 2));
//
//        Hero hero = convert(ecoHero);
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
//    }
}