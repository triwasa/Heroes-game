package pl.sdk.hero;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.sdk.EconomyEngine;
import pl.sdk.spell.EconomySpellEnum;
import pl.sdk.spell.EconomySpellFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BuyingSpellTest {

    private EconomyHero hero1;
    private final EconomySpellFactory spellFactory = new EconomySpellFactory();
    private EconomyEngine economyEngine;
    private EconomyHero hero2;

    @BeforeEach
    void init() {
        hero1 = new EconomyHero(EconomyHero.Fraction.NECROPOLIS, 1000);
        hero2 = new EconomyHero(EconomyHero.Fraction.NECROPOLIS, 1000);
        economyEngine = new EconomyEngine(hero1, hero2);
    }

    @Test
    void heroShouldCanBuySpell(){
        economyEngine.buySpell(spellFactory.create(EconomySpellEnum.BLESS));
        assertEquals(995,hero1.getGold());
    }

    @Test
    void heroShouldNotBuyTheSameSpell(){
        economyEngine.buySpell(spellFactory.create(EconomySpellEnum.BLESS));
        assertEquals(995,hero1.getGold());
        //assertThrows(IllegalStateException.class, () -> economyEngine.buySpell(spellFactory.create(EconomySpellEnum.BLESS)));
        System.out.println(hero1.getSpell().toString());
    }

}
