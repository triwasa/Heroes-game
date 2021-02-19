package pl.sdk.hero;

import org.junit.jupiter.api.Test;
import pl.sdk.creatures.Creature;
import pl.sdk.creatures.NecropolisFactory;
import pl.sdk.spells.Spell;
import pl.sdk.spells.SpellEnum;
import pl.sdk.spells.SpellFactory;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HeroTest {

    @Test
    void createHeroTest() {
        Hero hero = new Hero.BuilderForTesting().attack(1).defence(2).power(3).knowledge(3).luck(2).morale(1).build();

        assertEquals(1, hero.getAttack());
        assertEquals(2, hero.getDefence());
        assertEquals(3, hero.getPower());
        assertEquals(3, hero.getKnowledge());
        assertEquals(2, hero.getLuck());
        assertEquals(1, hero.getMorale());
    }

    @Test
    void createHeroFromHeroClassStatistic() {
        Hero hero = new Hero(HeroClassStatistic.KNIGHT);

        assertEquals(2, hero.getAttack());
        assertEquals(2, hero.getDefence());
        assertEquals(1, hero.getPower());
        assertEquals(1, hero.getKnowledge());
        assertEquals(0, hero.getLuck());
        assertEquals(0, hero.getMorale());
    }

    @Test
    void increaseHeroStats() {
        Hero hero = new Hero.BuilderForTesting().attack(1).defence(1).power(1).knowledge(1).luck(1).morale(1).build();

        // I use HeroClassStatistic, because I don't have access to ArtifactPrimaryStatistic
        // but both of them implement HeroClassStatisticIf
        hero.increaseStats(HeroClassStatistic.ALCHEMIST); // 1,1,2,2,0,0
        assertEquals(1 + 1, hero.getAttack());
        assertEquals(1 + 1, hero.getDefence());
        assertEquals(1 + 2, hero.getPower());
        assertEquals(1 + 2, hero.getKnowledge());
        assertEquals(1, hero.getLuck());
        assertEquals(1, hero.getMorale());
        assertEquals((1 + 2) * 10, hero.getMana());
    }

    @Test
    void increaseHeroMana() {
        Hero hero = new Hero.BuilderForTesting().attack(1).defence(1).power(1).knowledge(1).luck(1).morale(1).build();

        // mana = 10 * knowledge
        assertEquals(hero.getMana(), 10);

        // Intelligence	skill can increase mana by 25%, 50%, 100%
        hero.increaseManaPercent(0.25);
        assertEquals(((int) Math.round(10 + 10 * 0.25)), hero.getMana());
    }

    @Test
    void shouldAddCreaturesCorrectly() {
        NecropolisFactory necropolisFactory = new NecropolisFactory();
        Hero hero = new Hero.BuilderForTesting().attack(1).defence(1).power(1).knowledge(1).luck(1).morale(1).build();

        List<Creature> creatureList = new ArrayList<>();
        creatureList.add(necropolisFactory.create(false,1,1));
        creatureList.add(necropolisFactory.create(false,2,1));
        creatureList.add(necropolisFactory.create(false,3,1));

        hero.addCreatures(creatureList);

        assertEquals(3, hero.getCreatures().size());
        assertEquals("Skeleton", hero.getCreatures().get(0).getName());
        assertEquals(5 ,hero.getCreatures().get(1).getAttack());
        assertEquals(7, hero.getCreatures().get(2).getArmor());
    }

    @Test
    void shouldAddSpellsCorrectly() {
        SpellFactory spellFactory = new SpellFactory();
        Hero hero = new Hero.BuilderForTesting().attack(1).defence(1).power(1).knowledge(1).luck(1).morale(1).build();

        List<Spell> spellList = new ArrayList<>();
        spellList.add(spellFactory.create(SpellEnum.MAGIC_ARROW_AIR));

        hero.addSpells(spellList);

        assertEquals(1, hero.getSpells().size());
        assertEquals("Magic Arrow", hero.getSpells().stream().findFirst().get().getName());

    }
}
