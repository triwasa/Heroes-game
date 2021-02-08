package pl.sdk.skills;

import pl.sdk.hero.Hero;
import pl.sdk.creatures.Creature;
import pl.sdk.creatures.*;

import com.google.common.collect.Range;
import java.util.List;
import java.util.ListIterator;

public class SkillApplier {

    private static String EXCEPTION_MESSEAGE = "There is no such skill";
  
    public void apply(Skill skill, Hero hero) {
        String aName = skill.getName();
        int aTier = skill.getTier();
        if (aName == SkillStatistic.OFFENCE1.getCoreName()) {
            switch (aTier) {
                case 1:
                    increaseMeleeDamage(hero, 10);
                case 2:
                    increaseMeleeDamage(hero, 20);
                case 3:
                    increaseMeleeDamage(hero, 30);
            }
        } else if (aName == SkillStatistic.ARCHERY1.getCoreName()) {
            switch (aTier) {
                case 1:
                    increaseRangeDamage(hero, 10);
                case 2:
                    increaseRangeDamage(hero, 25);
                case 3:
                    increaseRangeDamage(hero, 30);
            }
        } else if (aName == SkillStatistic.ARMOURER1.getCoreName()) {
            switch (aTier) {
                case 1:
                    applyArmourer(hero,5);
                case 2:
                    applyArmourer(hero,10);
                case 3:
                    applyArmourer(hero,15);
            }
        } else if (aName == SkillStatistic.LEADERSHIP1.getCoreName()) {
            switch (aTier) {
                case 1:
                    //hero.increaseMorale(1);
                case 2:
                    //hero.increaseMorale(2);
                case 3:
                    //hero.increaseMorale(3);
            }
        } else if (aName == SkillStatistic.LUCK1.getCoreName()) {
            switch (aTier) {
                case 1:
                    //hero.increaseLuck(1);
                case 2:
                    // hero.increaseLuck(2);
                case 3:
                    //hero.increaseLuck(3);
            }
        } else if (aName == SkillStatistic.RESISTANCE1.getCoreName()) {
            switch (aTier) {
                case 1:
                    //increaseResistance(hero, 5);
                case 2:
                    //increaseResistance(hero, 10);
                case 3:
                    //increaseResistance(hero, 20);
            }
        } else if (aName == SkillStatistic.WISDOM1.getCoreName()) {
            switch (aTier) {
                case 1:
                    //work in progress
                case 2:
                    //work in progress
                case 3:
                    //work in progress
            }
        } else if (aName == SkillStatistic.SORCERY1.getCoreName()) {
            switch (aTier) {
                case 1:
                    //work in progress
                case 2:
                    //work in progress
                case 3:
                    //work in progress
            }
        } else if (aName == SkillStatistic.ARTILLERY1.getCoreName()) {
            switch (aTier) {
                case 1:
                    buffBallista(hero,50);
                case 2:
                    buffBallista(hero,75);
                case 3:
                    buffBallista(hero,100);
            }
        } else if (aName == SkillStatistic.BALLISTICS1.getCoreName()) {
            switch (aTier) {
                case 1:
                    buffCatapult(hero,1);
                case 2:
                    buffCatapult(hero,2);
                case 3:
                    buffCatapult(hero,3);
            }
        } else if (aName == SkillStatistic.FIRSTAID1.getCoreName()) {
            switch (aTier) {
                case 1:
                    buffFirstAidTent(hero,1);
                case 2:
                    buffFirstAidTent(hero,1);
                case 3:
                    buffFirstAidTent(hero,1);
            }
        } else if (aName == SkillStatistic.EAGLEEYE1.getCoreName()) {
            switch (aTier) {
                case 1:
                    //work in progress
                case 2:
                    //work in progress
                case 3:
                    //work in progress
            }
        } else if (aName == SkillStatistic.AIR_MAGIC1.getCoreName()) {
            switch (aTier) {
                case 1:
                    //work in progress
                case 2:
                    //work in progress
                case 3:
                    //work in progress
            }
        } else if (aName == SkillStatistic.EARTH_MAGIC1.getCoreName()) {
            switch (aTier) {
                case 1:
                    //work in progress
                case 2:
                    //work in progress
                case 3:
                    //work in progress
            }
        } else if (aName == SkillStatistic.FIRE_MAGIC1.getCoreName()) {
            switch (aTier) {
                case 1:
                    //work in progress
                case 2:
                    //work in progress
                case 3:
                    //work in progress
            }
        } else if (aName == SkillStatistic.WATER_MAGIC1.getCoreName()) {
            switch (aTier) {
                case 1:
                    //work in progress
                case 2:
                    //work in progress
                case 3:
                    //work in progress
            }
        }
        throw new IllegalArgumentException(EXCEPTION_MESSEAGE);
    }

    //TODO: dostosować increaseDamage do implementacji
    private void increaseMeleeDamage(Hero hero, int percentDamageIncrease){
        List<Creature> creatures = hero.getCreatures();
        ListIterator<Creature> listIter = creatures.listIterator();
        while (listIter.hasNext()) {
            Creature buffedCreature = listIter.next();
            if (buffedCreature.getAttackRange() == 1.0) {
                //buffedCreature.increaseDamage()
            }
            listIter.set(buffedCreature);
        }
    }

    //TODO: dostosować increasedamage do implementacji, sprawdzić zasieg ataku
    private void increaseRangeDamage(Hero hero, int percentDamageIncrease){
        List<Creature> creatures = hero.getCreatures();
        ListIterator<Creature> listIter = creatures.listIterator();
        while (listIter.hasNext()) {
            Creature buffedCreature = listIter.next();
            if (buffedCreature.getAttackRange() > 10.0) {
                //buffedCreature.increaseDamage()
            }
            listIter.set(buffedCreature);
        }
    }

    private void applyArmourer(Hero hero, int percentDamageReduction){
        List<Creature> creatures = hero.getCreatures();
        ListIterator<Creature> listIter = creatures.listIterator();
        while (listIter.hasNext()) {
            Creature decoratedCreature = listIter.next();
            decoratedCreature = new PercentDamageReduceCreatureDecorator(decoratedCreature, percentDamageReduction);
            listIter.set(decoratedCreature);
        }
    }

    private void buffBallista(Hero hero,int skillTier){
        List<Creature> creatures = hero.getCreatures();
        ListIterator<Creature> listIter = creatures.listIterator();
        while (listIter.hasNext()) {
            Creature buffedCreature = listIter.next();
            if (buffedCreature.getName() == "ballista"){
                //metoda buffowania do ustalenia
            }
            listIter.set(buffedCreature);
        }
    }

    private void buffCatapult(Hero hero, int skillTier){
        List<Creature> creatures = hero.getCreatures();
        ListIterator<Creature> listIter = creatures.listIterator();
        while (listIter.hasNext()) {
            Creature buffedCreature = listIter.next();
            if (buffedCreature.getName() == "catapult"){
                //metoda buffowania do ustalenia
            }
            listIter.set(buffedCreature);
        }
    }

    private void buffFirstAidTent(Hero hero, int skillTier){
        List<Creature> creatures = hero.getCreatures();
        ListIterator<Creature> listIter = creatures.listIterator();
        while (listIter.hasNext()) {
            Creature buffedCreature = listIter.next();
            if (buffedCreature.getName() == "first aid tent"){
                //metoda buffowania do ustalenia
            }
            listIter.set(buffedCreature);
        }
    }

    private void increaseResistance(Hero hero, int additionalResistance){
        List<Creature> creatures = hero.getCreatures();
        ListIterator<Creature> listIter = creatures.listIterator();
        while (listIter.hasNext()) {
            Creature buffedCreature = listIter.next();
            //buffedCreature.increaseResistance(additionalResistance);
            listIter.set(buffedCreature);
        }
    }

}
