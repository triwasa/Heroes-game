package pl.sdk;

import com.google.common.collect.Range;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.sdk.creatures.*;
import pl.sdk.skill.*;


import static org.junit.jupiter.api.Assertions.assertEquals;


public class SkillBookBasicTest {

    private Hero hero;
    private SkillBook skillBook;
    public static final int NOT_IMPORTANT = 5;

    @BeforeEach
    void init(){
        Hero hero = new Hero();
        SkillBook skillBook = new SkillBook(hero);
    }

    //TODO: fix tests with creatures

    @Test
    void skillShouldBeAddedCorrectly(){
        Skill offence = SkillFactory.createForTest(SkillEnum.OFFENCE1);
        skillBook.addSkill(offence);
        assertEquals(true,skillBook.contains(offence));
    }

    @Test
    void skillShouldBeReplacedCorrectly(){
        Skill offence1 = SkillFactory.createForTest(SkillEnum.OFFENCE1);
        skillBook.addSkill(offence1);
        Skill offence2 = SkillFactory.createForTest(SkillEnum.OFFENCE2);
        skillBook.addSkill(offence2);
        assertEquals(false,skillBook.contains(offence1));
        assertEquals(true,skillBook.contains(offence2));
    }

    @Test
    void offenceShouldIncreaseDamage(){
        //offence zwiększa zadawany dmg o 10%
        Creature attacker = NecropolisFactory.createDefaultForTests();
        Creature defender = NecropolisFactory.createDefaultForTests();
        Skill offence = SkillFactory.createForTest(SkillEnum.OFFENCE1);
        skillBook.addSkill(offence);
        attacker.attack(defender);
        assertEquals(88,defender.getCurrentHp());
    }

    @Test
    void luckShouldBeIncreasedCorrectly(){
        Skill luck = SkillFactory.createForTest(SkillEnum.LUCK1);
        skillBook.addSkill(luck);
        assertEquals(1,hero.getLuck());
    }

    @Test
    void armourerShouldIncreaseDamage(){
        //armourer zmniejsza otrzymywany dmg o 10%
        Creature attacker = NecropolisFactory.createDefaultForTests();
        Creature defender = NecropolisFactory.createDefaultForTests();
        Skill armourer = SkillFactory.createForTest(SkillEnum.ARMOURER1);
        skillBook.addSkill(armourer);
        attacker.attack(defender);
        assertEquals(91,defender.getCurrentHp());
    }

}


}
