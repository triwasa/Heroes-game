package pl.sdk.hero;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.sdk.EconomyEngine;
import pl.sdk.skills.EconomySkillFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BuyingSkillTest {

    private EconomyHero hero1;
    private final EconomySkillFactory skillFactory = new EconomySkillFactory();
    private EconomyEngine economyEngine;
    private EconomyHero hero2;

    @BeforeEach
    void init() {
        hero1 = new EconomyHero(EconomyHero.Fraction.NECROPOLIS, 1000);
        hero2 = new EconomyHero(EconomyHero.Fraction.NECROPOLIS, 1000);
        economyEngine = new EconomyEngine(hero1, hero2);
    }

    @Test
    void heroShouldCanBuySkill(){
        economyEngine.buySkill(skillFactory.create("offence",1));
        assertEquals(1,hero1.getSkillList().size());

    }

    @Test
    void heroCanNotBuyNonexistentSkill(){
        assertThrows(IllegalArgumentException.class, () -> economyEngine.buySkill(skillFactory.create("Trzeźwość",3)));
    }

    @Test
    void heroShouldCanBuyFewSkills(){
        economyEngine.buySkill(skillFactory.create("offence",1));
        economyEngine.buySkill(skillFactory.create("archery",1));
        assertEquals(2,hero1.getSkillList().size());
    }

    @Test
    void heroCanNotBuyOwnedSkills(){
        economyEngine.buySkill(skillFactory.create("offence",1));
        economyEngine.buySkill(skillFactory.create("offence",1));
        assertEquals(2,hero1.getSkillList().size());
    }
}
