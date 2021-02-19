package pl.sdk.hero;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.sdk.artifacts.EconomyArtifactPrimaryFactory;
import pl.sdk.creatures.EconomyNecropolisFactory;
import pl.sdk.spell.EconomySpellEnum;
import pl.sdk.spell.EconomySpellFactory;
import pl.sdk.skills.EconomySkillFactory;

import static org.junit.jupiter.api.Assertions.*;
import static pl.sdk.artifacts.ArtifactName.CENTAURS_AX;
import static pl.sdk.hero.HeroClassName.DEATH_KNIGHT;

class EconomyHeroTest {


    private EconomyHero hero;

    @BeforeEach
    void init(){
        hero = new EconomyHero(DEATH_KNIGHT, 3000);
    }

    @Test
    void shouldThrowExceptionWhileHeroHas7CreatureAndYoTryToAddNextOne(){
        EconomyNecropolisFactory factory = new EconomyNecropolisFactory();
        hero.addCreature(factory.create(true,1,1));
        hero.addCreature(factory.create(true,1,1));
        hero.addCreature(factory.create(true,1,1));
        hero.addCreature(factory.create(true,1,1));
        hero.addCreature(factory.create(true,1,1));
        hero.addCreature(factory.create(true,1,1));
        hero.addCreature(factory.create(true,1,1));

        assertThrows(IllegalStateException.class, () -> hero.addCreature(factory.create(true,1,1)));
    }

    @Test
    void shouldThrowExceptionWhileYouTrySubstractMoreGoldThanHeroHas(){
        assertThrows(IllegalStateException.class, () -> hero.substractGold(3001));
    }

    @Test
    void shouldThrowExceptionWhileHeroAddArtifactToOccupiedSlot(){
        EconomyArtifactPrimaryFactory artifactPrimaryFactory = new EconomyArtifactPrimaryFactory();
        hero.addArtifact(artifactPrimaryFactory.create(CENTAURS_AX));
        assertThrows(IllegalStateException.class, () -> hero.addArtifact(artifactPrimaryFactory.create(CENTAURS_AX)));
    }

    @Test
    void shouldThrowExceptionWhileHeroAddOwnedSpell(){
//        EconomySpellFactory spellFactory = new EconomySpellFactory();
//        hero.addSpell(spellFactory.create(EconomySpellEnum.BLESS));
//        assertThrows(IllegalStateException.class, () -> hero.addSpell(spellFactory.create(EconomySpellEnum.BLESS)));
    }

    @Test
    void shouldThrowExceptionWhileHeroAddOwnedSkill(){
//        EconomySkillFactory skillFactory = new EconomySkillFactory();
//        hero.addSkill(skillFactory.create("offence",1));
//        assertThrows(IllegalStateException.class, () -> hero.addSkill(skillFactory.create("offence",1)));
    }
}