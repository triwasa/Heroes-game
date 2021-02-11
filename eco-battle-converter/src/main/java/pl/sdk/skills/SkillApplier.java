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
        String aName = skill.getCoreName();
        int aTier = skill.getTier();
        if (aName == SkillStatistic.OFFENCE1.getCoreName()) {
            switch (aTier) {
                case 1:
                    increaseMeleeDamage(hero, 10);
                    break;
                case 2:
                    increaseMeleeDamage(hero, 20);
                    break;
                case 3:
                    increaseMeleeDamage(hero, 30);
                    break;
            }
        } else if (aName == SkillStatistic.ARCHERY1.getCoreName()) {
            switch (aTier) {
                case 1:
                    increaseRangeDamage(hero, 10);
                    break;
                case 2:
                    increaseRangeDamage(hero, 25);
                    break;
                case 3:
                    increaseRangeDamage(hero, 50);
                    break;
            }
        } else if (aName == SkillStatistic.ARMOURER1.getCoreName()) {
            switch (aTier) {
                case 1:
                    applyArmourer(hero,5);
                    break;
                case 2:
                    applyArmourer(hero,10);
                    break;
                case 3:
                    applyArmourer(hero,15);
                    break;
            }
        } else if (aName == SkillStatistic.LEADERSHIP1.getCoreName()) {
            switch (aTier) {
                case 1:
                    hero.increaseStats(SkillAdditionalStatistic.LEADERSHIP1);
                    break;
                case 2:
                    hero.increaseStats(SkillAdditionalStatistic.LEADERSHIP2);
                    break;
                case 3:
                    hero.increaseStats(SkillAdditionalStatistic.LEADERSHIP3);
                    break;
            }
        } else if (aName == SkillStatistic.LUCK1.getCoreName()) {
            switch (aTier) {
                case 1:
                    hero.increaseStats(SkillAdditionalStatistic.LUCK1);
                    break;
                case 2:
                    hero.increaseStats(SkillAdditionalStatistic.LUCK2);
                    break;
                case 3:
                    hero.increaseStats(SkillAdditionalStatistic.LUCK3);
                    break;
            }
        } else if (aName == SkillStatistic.RESISTANCE1.getCoreName()) {
            switch (aTier) {
                case 1:
                    increaseResistance(hero, 5);
                    break;
                case 2:
                    increaseResistance(hero, 10);
                    break;
                case 3:
                    increaseResistance(hero, 20);
                    break;
            }
        } else if (aName == SkillStatistic.ARTILLERY1.getCoreName()) {
            switch (aTier) {
                case 1:
                    buffBallista(hero,50);
                    break;
                case 2:
                    buffBallista(hero,75);
                    break;
                case 3:
                    buffBallista(hero,100);
                    break;
            }
        } else if (aName == SkillStatistic.BALLISTICS1.getCoreName()) {
            switch (aTier) {
                case 1:
                    buffCatapult(hero,1);
                    break;
                case 2:
                    buffCatapult(hero,2);
                    break;
                case 3:
                    buffCatapult(hero,3);
                    break;
            }
        } else if (aName == SkillStatistic.FIRSTAID1.getCoreName()) {
            switch (aTier) {
                case 1:
                    buffFirstAidTent(hero,1);
                    break;
                case 2:
                    buffFirstAidTent(hero,2);
                    break;
                case 3:
                    buffFirstAidTent(hero,3);
                    break;
            }
        }else if (aName == SkillStatistic.INTELLIGENCE1.getCoreName()) {
            switch (aTier) {
                case 1:
                    hero.increaseManaPercent(0.25);
                    break;
                case 2:
                    hero.increaseManaPercent(0.5);
                    break;
                case 3:
                    hero.increaseManaPercent(1);
                    break;
            }
        }
        //skill which aren't used in applier
        else if (aName == SkillStatistic.AIR_MAGIC1.getCoreName()) { }
        else if (aName == SkillStatistic.EARTH_MAGIC1.getCoreName()) { }
        else if (aName == SkillStatistic.FIRE_MAGIC1.getCoreName()) { }
        else if (aName == SkillStatistic.WATER_MAGIC1.getCoreName()) {}
        else if (aName == SkillStatistic.WISDOM1.getCoreName()) { }
        else if (aName == SkillStatistic.EAGLEEYE1.getCoreName()) { }
        else{
            throw new IllegalArgumentException(EXCEPTION_MESSEAGE);
        }
    }

    private void increaseMeleeDamage(Hero hero, int percentDamageIncrease){
        List<Creature> creatures = hero.getCreatures();
        ListIterator<Creature> listIter = creatures.listIterator();
        float bonus = (float) percentDamageIncrease/100;
        while (listIter.hasNext()) {
            Creature buffedCreature = listIter.next();
            if (buffedCreature.getAttackRange() == 1.0) {
                Range<Integer> buff = buffedCreature.getBasicDamage();
                int buffLowerEndpoint = Math.round(buff.lowerEndpoint() * bonus);
                int buffUpperEndpoint = Math.round(buff.upperEndpoint() * bonus);
                buffedCreature.increaseDamage(buffLowerEndpoint, buffUpperEndpoint);
            }
            listIter.set(buffedCreature);
        }
    }

    private void increaseRangeDamage(Hero hero, int percentDamageIncrease){
        List<Creature> creatures = hero.getCreatures();
        ListIterator<Creature> listIter = creatures.listIterator();
        float bonus = (float) percentDamageIncrease/100;
        while (listIter.hasNext()) {
            Creature buffedCreature = listIter.next();
            if (buffedCreature.getAttackRange() == Double.MAX_VALUE) {
                Range<Integer> buff = buffedCreature.getBasicDamage();
                int buffLowerEndpoint = Math.round(buff.lowerEndpoint() * bonus);
                int buffUpperEndpoint = Math.round(buff.upperEndpoint() * bonus);
                buffedCreature.increaseDamage(buffLowerEndpoint, buffUpperEndpoint);
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
            if (buffedCreature.getName() == "Ballista"){
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
            if (buffedCreature.getName() == "Catapult"){
                switch (skillTier){
                    case 1:{
                        //buffedMachine.increaseDamage(0,25);
                        break;
                    }
                    case 2:{
                        //buffedMachine.increaseDamage(0, 50);
                        break;
                    }
                    case 3:{
                        //buffedMachine.increaseDamage(0,75);
                        break;
                    }

                }
            }
            listIter.set(buffedCreature);
        }
    }

    private void buffFirstAidTent(Hero hero, int skillTier){
        List<BattleObject> machines = hero.getMachines();
        ListIterator<BattleObject> listIter = machines.listIterator();
        while (listIter.hasNext()) {
            BattleObject buffedMachine = listIter.next();
            if (buffedMachine.getName() == "First Aid Tent"){
                switch (skillTier){
                    case 1:{
                        //buffedMachine.increaseDamage(0,25);
                        break;
                    }
                    case 2:{
                        //buffedMachine.increaseDamage(0, 50);
                        break;
                    }
                    case 3:{
                        //buffedMachine.increaseDamage(0,75);
                        break;
                    }

                }

            }
            listIter.set(buffedMachine);
        }
    }

    private void increaseResistance(Hero hero, int additionalResistance){
        List<Creature> creatures = hero.getCreatures();
        ListIterator<Creature> listIter = creatures.listIterator();
        while (listIter.hasNext()) {
            Creature buffedCreature = listIter.next();
            buffedCreature.increaseResistance(additionalResistance);
            listIter.set(buffedCreature);
        }
    }

}

