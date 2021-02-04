package pl.sdk.spell;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.sdk.EconomyEngine;
import pl.sdk.creatures.EconomyNecropolisFactory;
import pl.sdk.hero.EconomyHero;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BuyingSpellTest {

    private EconomyHero hero1;
    private final EconomyNecropolisFactory creatureFactory = new EconomyNecropolisFactory();
    private final EconomySpellFactory economySpellFactory = new EconomySpellFactory();
    private EconomyEngine economyEngine;
    private EconomyHero hero2;
    private Integer goldBeforeShopping = 1000;
    private Integer smallValueOfGold = 3;

    @BeforeEach
    void init() {
        hero1 = new EconomyHero(EconomyHero.Fraction.NECROPOLIS, goldBeforeShopping);
        hero2 = new EconomyHero(EconomyHero.Fraction.NECROPOLIS, goldBeforeShopping);
        economyEngine = new EconomyEngine(hero1, hero2);
    }

//    @Test
//    void blessShouldCost5Gold(){
//        assertEquals(EconomySpellEnum.BLESS.getCost(), 5);
//    }

    @Test
    void heroShouldCanBuySpell() {
        economyEngine.buySpell(economySpellFactory.create(EconomySpellEnum.BLESS)); //5 gold

        assertEquals(goldBeforeShopping - EconomySpellEnum.BLESS.getCost(), hero1.getGold());

//        assertEquals(995, hero1.getGold());
    }

    @Test
    void heroShouldCanBuyFewArtifacts() {
        economyEngine.buySpell(economySpellFactory.create(EconomySpellEnum.BLESS)); // 5 gold
        economyEngine.buySpell(economySpellFactory.create(EconomySpellEnum.CURE)); // 6 gold

        assertEquals(goldBeforeShopping - EconomySpellEnum.BLESS.getCost() - EconomySpellEnum.CURE.getCost(), hero1.getGold());
    }

    @Test
    void heroCannotBuySpellWhenHasNotEnoughGold() {
        assertThrows(IllegalStateException.class, () -> economyEngine.buySpell(economySpellFactory.create(EconomySpellEnum.CURE)));
        assertEquals(smallValueOfGold, hero1.getGold());
        assertEquals(0, hero1.getArtifacts().size());
    }

}
