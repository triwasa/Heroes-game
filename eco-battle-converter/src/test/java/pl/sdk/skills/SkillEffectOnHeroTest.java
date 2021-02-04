package pl.sdk.skills;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.sdk.hero.Hero;
import skills.Skill;
import skills.SkillApplier;
import skills.SkillFactory;
import skills.SkillSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SkillEffectOnHeroTest {

    private SkillSet skillSet;
    private Hero hero;
    SkillApplier applier;

    @BeforeEach
    void init(){
        hero = new Hero();
        applier = new SkillApplier();
    }

    @Test
    void luckShoudBeIncreasedCorrectly(){
        Skill luck = SkillFactory.createForTest("luck 1");
        applier.apply(luck, hero);
        assertEquals(1, hero.getLuck());
    }


    @Test
    void moraleShoudBeIncreasedCorrectly(){
        Skill leadership = SkillFactory.createForTest("leadership 1");
        applier.apply(leadership, hero);
        assertEquals(1, hero.getMorale());
    }


}
