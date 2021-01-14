<<<<<<< Updated upstream:battle-model/src/test/java/pl/sdk/skill/SkillBookBasicTest.java
package pl.sdk.skill;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.sdk.Hero;
import pl.sdk.creatures.*;
=======
package pl.sdk.skills;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
>>>>>>> Stashed changes:economy-model/src/test/java/pl/sdk/skills/SkillSetEconomyTest.java


import static org.junit.jupiter.api.Assertions.assertEquals;


public class SkillSetEconomyTest {

    private SkillSet skillSet;
    public static final int NOT_IMPORTANT = 5;

    //TODO: fix tests with creatures

    @Test
    void skillShouldBeAddedCorrectly(){
        SkillSet aSkillSet = new SkillSet();
        SkillFactory skillFactory = new SkillFactory();
        Skill offence = skillFactory.create("offence 1");
        aSkillSet.addSkill(offence);
        assertEquals(true,aSkillSet.contains(offence));
    }

    @Test
    void skillShouldBeReplacedCorrectly(){
        SkillSet aSkillSet = new SkillSet();
        SkillFactory skillFactory = new SkillFactory();
        Skill offence1 = skillFactory.create("offence 1");
        aSkillSet.addSkill(offence1);
        Skill offence2 = skillFactory.create("offence 2");
        aSkillSet.addSkill(offence2);
        assertEquals(false,aSkillSet.contains(offence1));
        assertEquals(true,aSkillSet.contains(offence2));
    }
/*
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
<<<<<<< Updated upstream:battle-model/src/test/java/pl/sdk/skill/SkillBookBasicTest.java
}
=======
*/
}

>>>>>>> Stashed changes:economy-model/src/test/java/pl/sdk/skills/SkillSetEconomyTest.java
