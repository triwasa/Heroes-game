package pl.sdk.hero;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.sdk.EconomyEngine;
import pl.sdk.skills.EconomySkillFactory;

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
        economyEngine.buySkill(skillFactory.create());
    }
}
