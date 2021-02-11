package pl.sdk.skills;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.sdk.hero.Hero;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SkillEffectOnHeroTest {

    private SkillSet skillSet;
    private Hero hero;
    SkillApplier applier;

    @BeforeEach
    void init(){
        hero = new Hero.BuilderForTesting().attack(0).defence(0).power(0).luck(0).morale(0).knowledge(10).build();
        applier = new SkillApplier();
    }

    @Test
    void luck1ShoudBeIncreasedCorrectly(){
        Skill luck = SkillFactory.createForTest("luck",1);
        applier.apply(luck, hero);
        assertEquals(1, hero.getLuck());
    }

    @Test
    void luck2ShoudBeIncreasedCorrectly(){
        Skill luck = SkillFactory.createForTest("luck",2);
        applier.apply(luck, hero);
        assertEquals(2, hero.getLuck());
    }

    @Test
    void luck3ShoudBeIncreasedCorrectly(){
        Skill luck = SkillFactory.createForTest("luck",3);
        applier.apply(luck, hero);
        assertEquals(3, hero.getLuck());
    }


    @Test
    void morale1ShoudBeIncreasedCorrectly(){
        Skill leadership = SkillFactory.createForTest("leadership", 1);
        applier.apply(leadership, hero);
        assertEquals(1, hero.getMorale());
    }

    @Test
    void morale2ShoudBeIncreasedCorrectly(){
        Skill leadership = SkillFactory.createForTest("leadership", 2);
        applier.apply(leadership, hero);
        assertEquals(2, hero.getMorale());
    }

    @Test
    void morale3ShoudBeIncreasedCorrectly(){
        Skill leadership = SkillFactory.createForTest("leadership", 3);
        applier.apply(leadership, hero);
        assertEquals(3, hero.getMorale());
    }

    @Test
    void mana1ShoudBeIncreasedCorrectly(){
        Skill leadership = SkillFactory.createForTest("intelligence", 1);
        applier.apply(leadership, hero);
        assertEquals(125, hero.getMana());
    }

    @Test
    void mana2ShoudBeIncreasedCorrectly(){
        Skill leadership = SkillFactory.createForTest("intelligence", 2);
        applier.apply(leadership, hero);
        assertEquals(150, hero.getMana());
    }

    @Test
    void mana3ShoudBeIncreasedCorrectly(){
        Skill leadership = SkillFactory.createForTest("intelligence", 3);
        applier.apply(leadership, hero);
        assertEquals(200, hero.getMana());
    }


}
