package pl.sdk.hero;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.sdk.EconomyEngine;
import pl.sdk.spell.EconomySpellEnum;
import pl.sdk.spell.EconomySpellFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static pl.sdk.hero.HeroClassName.DEATH_KNIGHT;

public class BuyingSpellTest {

    private EconomyHero hero1;
    private final EconomySpellFactory spellFactory = new EconomySpellFactory();
    private EconomyEngine economyEngine;

    @BeforeEach
    void init() {
        hero1 = new EconomyHero(DEATH_KNIGHT, 1000);
        EconomyHero hero2 = new EconomyHero(DEATH_KNIGHT, 1000);
        economyEngine = new EconomyEngine(hero1, hero2);
    }

    @Test
    void heroShouldCanBuySpell(){
        economyEngine.buySpell(spellFactory.create(EconomySpellEnum.BLESS));
        assertEquals(995,hero1.getGold());
    }

    @Test
    void heroShouldCanBuyFewSpells(){
        economyEngine.buySpell(spellFactory.create(EconomySpellEnum.BLESS));
        economyEngine.buySpell(spellFactory.create(EconomySpellEnum.TELEPORT));
        assertEquals(980,hero1.getGold());
    }

    @Test
    void heroShouldNotBuyTheSameSpell(){
//        economyEngine.buySpell(spellFactory.create(EconomySpellEnum.BLESS));
//        assertEquals(995,hero1.getGold());
//        assertThrows(IllegalStateException.class, () -> economyEngine.buySpell(spellFactory.create(EconomySpellEnum.BLESS)));
    }

}
