package pl.sdk.hero;

import org.junit.jupiter.api.Test;
import pl.sdk.artifacts.ArtifactName;
import pl.sdk.artifacts.EconomyArtifactPrimaryFactory;
import pl.sdk.creatures.EconomyNecropolisFactory;
import pl.sdk.creatures.NecropolisFactory;
import pl.sdk.skills.EconomySkillFactory;
import pl.sdk.spell.EconomySpellFactory;
import pl.sdk.spells.Spell;

import static org.junit.jupiter.api.Assertions.*;
import static pl.sdk.converter.Converter.convert;
import static pl.sdk.hero.HeroClassName.DEATH_KNIGHT;

public class ArtifactsConvertTest {

    private static final int NOT_IMPORTANT = 500;
    private final EconomyNecropolisFactory economyCreatureNecropolisFactory = new EconomyNecropolisFactory();
    private final EconomyArtifactPrimaryFactory economyArtifactFactory = new EconomyArtifactPrimaryFactory();
    private final EconomySpellFactory economySpellFactory = new EconomySpellFactory();


    @Test
    void artifactShouldBeAbleToAffectCreaturesAttackAndDefence() {
        EconomyHero economyHero = new EconomyHero(DEATH_KNIGHT, NOT_IMPORTANT);
        economyHero.addCreature(economyCreatureNecropolisFactory.create(false,1,1));
        economyHero.addArtifact(economyArtifactFactory.create(ArtifactName.HELM_OF_HEAVENLY_ENLIGHTENMENT));

        Hero hero = convert(economyHero);

        assertEquals(1 + 5 + 6, hero.getCreatures().get(0).getAttack());
        assertEquals(2 + 4 + 6, hero.getCreatures().get(0).getArmor());
    }

    @Test
    void allArtifactsShouldBeAbleToAffectAllCreaturesAttackAndDefence() {
        EconomyHero economyHero = new EconomyHero(DEATH_KNIGHT, NOT_IMPORTANT);
        economyHero.addCreature(economyCreatureNecropolisFactory.create(false,1,1));
        economyHero.addCreature(economyCreatureNecropolisFactory.create(false,2,1));
        economyHero.addArtifact(economyArtifactFactory.create(ArtifactName.HELM_OF_HEAVENLY_ENLIGHTENMENT));
        economyHero.addArtifact(economyArtifactFactory.create(ArtifactName.SWORD_OF_JUJEMENT));

        Hero hero = convert(economyHero);

        assertEquals(1 + 5 + 6 + 5, hero.getCreatures().get(0).getAttack());
        assertEquals(2 + 4 + 6 + 5, hero.getCreatures().get(0).getArmor());
        assertEquals(1 + 5 + 6 + 5, hero.getCreatures().get(1).getAttack());
        assertEquals(2 + 5 + 6 + 5, hero.getCreatures().get(1).getArmor());
    }

    @Test
    void artifactsShouldBeAbleToAffectCreatureHealth() {
        EconomyHero economyHero = new EconomyHero(DEATH_KNIGHT, NOT_IMPORTANT);
        economyHero.addCreature(economyCreatureNecropolisFactory.create(false,1,1));
        economyHero.addArtifact(economyArtifactFactory.create(ArtifactName.VIAL_OF_LIFEBLOOD));

        Hero hero = convert(economyHero);

        assertEquals(6 + 2, hero.getCreatures().get(0).getMaxHp());
    }

    @Test
    void artifactShouldBeAbleToAffectCreatureResistance() {
        EconomyHero economyHero = new EconomyHero(DEATH_KNIGHT, NOT_IMPORTANT);
        economyHero.addCreature(economyCreatureNecropolisFactory.create(false,1,1));
        economyHero.addArtifact(economyArtifactFactory.create(ArtifactName.BOOTS_OF_POLARITY));

        Hero hero = convert(economyHero);

        assertEquals(15 , hero.getCreatures().get(0).getResistance());
    }

    @Test
    void artifactShouldBeAbleToAffectCreatureMoveRange() {
        EconomyHero economyHero = new EconomyHero(DEATH_KNIGHT, NOT_IMPORTANT);
        economyHero.addCreature(economyCreatureNecropolisFactory.create(false,1,1));
        economyHero.addArtifact(economyArtifactFactory.create(ArtifactName.CAPE_OF_VELOCITY));

        Hero hero = convert(economyHero);

        assertEquals(4 + 2 , hero.getCreatures().get(0).getMoveRange());
    }

    @Test
    void artifactShouldBeAbleToAffectCreatureImmunity() {
//        EconomyHero economyHero = new EconomyHero(DEATH_KNIGHT, NOT_IMPORTANT);
//        economyHero.addArtifact(economyArtifactFactory.create(ArtifactName.PENDANT_OF_HOLINESS));
//        Spell curseSpell = new Spell(SpellName.CURSE);
//        Spell bloodLustSpell = new Spell(SpellName.BLOODLUST);
//
//        Hero hero = convert(economyHero);
//
//        assertTrue( hero.getCreatures().get(0).getImmunity().checkImmunity(curseSpell));
//        assertFalse( hero.getCreatures().get(0).getImmunity().checkImmunity(bloodLustSpell));
    }

    @Test
    void artifactShouldBeAbleToAffectSpellDuration() {
//        EconomyHero economyHero = new EconomyHero(DEATH_KNIGHT, NOT_IMPORTANT);
//        economyHero.addCreature(economyCreatureNecropolisFactory.create(false,1,1));
//        economyHero.addSpell(economySpellFactory.create(SpellName.BLESS));
//
//        Hero hero = convert(economyHero);
//
//        assertEquals( 2 , hero.getSpells().stream().findFirst().get().getDuration());
    }

    @Test
    void artifactShouldBeAbleToAffectSpellDamage() {
//        EconomyHero economyHero = new EconomyHero(DEATH_KNIGHT, NOT_IMPORTANT);
//
//        // Hero's fire spells to extra 50% damage
//        economyHero.addArtifact(economyArtifactFactory.create(ArtifactName.ORB_OF_TEMPSTUOUS_FIRE));
//        // Target, enemy troop receives ((Power x 10) + 30) damage.
//        economyHero.addSpell(economySpellFactory.create(SpellName.MAGIC_ARROW));
//
//        Hero hero = convert(economyHero);
//
//        assertEquals((10 * 10 + 30) * 1.5 , hero.getSpells().stream().findFirst().get().getDamage());
    }
}
