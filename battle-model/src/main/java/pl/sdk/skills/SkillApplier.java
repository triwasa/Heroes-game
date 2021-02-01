package pl.sdk.skills;

import pl.sdk.Hero;
import pl.sdk.creatures.Creature;
import pl.sdk.creatures.*;

import java.util.List;
import java.util.ListIterator;

public class SkillApplier {

    private static String EXCEPTION_MESSEAGE = "There is no such skill";

    public void apply(Skill skill, Hero hero){
        String aName = skill.getName();
        switch (aName) {
            case "Offence: basic": {
                List<Creature> creatures = hero.getCreatures();
                ListIterator<Creature> listIter = creatures.listIterator();
                while (listIter.hasNext()) {
                    Creature decoratedCreature = listIter.next();
                    if (decoratedCreature.getAttackRange() == 1.0) {
                        decoratedCreature = new PercentDamageBoostCreatureDecorator(decoratedCreature, 10);
                    }
                    listIter.set(decoratedCreature);
                }
                break;
            }
            case "Offence: advanced": {
                List<Creature> creatures = hero.getCreatures();
                ListIterator<Creature> listIter = creatures.listIterator();
                while (listIter.hasNext()) {
                    Creature decoratedCreature = listIter.next();
                    if (decoratedCreature.getAttackRange() == 1.0) {
                        decoratedCreature = new PercentDamageBoostCreatureDecorator(decoratedCreature, 20);
                    }
                    listIter.set(decoratedCreature);
                }
                break;
            }
            case "Offence: expert": {
                List<Creature> creatures = hero.getCreatures();
                ListIterator<Creature> listIter = creatures.listIterator();
                while (listIter.hasNext()) {
                    Creature decoratedCreature = listIter.next();
                    if (decoratedCreature.getAttackRange() == 1.0) {
                        decoratedCreature = new PercentDamageBoostCreatureDecorator(decoratedCreature, 30);
                    }
                    listIter.set(decoratedCreature);
                }
                break;
            }
            case "Archery: basic": {
                List<Creature> creatures = hero.getCreatures();
                ListIterator<Creature> listIter = creatures.listIterator();
                while (listIter.hasNext()) {
                    Creature decoratedCreature = listIter.next();
                    if (decoratedCreature.getAttackRange() == Double.MAX_VALUE) {
                        decoratedCreature = new PercentDamageBoostCreatureDecorator(new PercentDamageBoostCreatureDecorator(decoratedCreature, 1), 1);
                    }
                    listIter.set(decoratedCreature);
                }
                break;
            }
            case "Archery: advanced": {
                List<Creature> creatures = hero.getCreatures();
                ListIterator<Creature> listIter = creatures.listIterator();
                while (listIter.hasNext()) {
                    Creature decoratedCreature = listIter.next();
                    if (decoratedCreature.getAttackRange() == Double.MAX_VALUE) {
                        decoratedCreature = new PercentDamageBoostCreatureDecorator(new PercentDamageBoostCreatureDecorator(decoratedCreature, 2), 2);
                    }
                    listIter.set(decoratedCreature);
                }
                break;
            }
            case "Archery: expert": {
                List<Creature> creatures = hero.getCreatures();
                ListIterator<Creature> listIter = creatures.listIterator();
                while (listIter.hasNext()) {
                    Creature decoratedCreature = listIter.next();
                    if (decoratedCreature.getAttackRange() == Double.MAX_VALUE) {
                        decoratedCreature = new PercentDamageBoostCreatureDecorator(new PercentDamageBoostCreatureDecorator(decoratedCreature, 3), 3);
                    }
                    listIter.set(decoratedCreature);
                }
                break;
            }
            case "Armourer: basic": {
                List<Creature> creatures = hero.getCreatures();
                ListIterator<Creature> listIter = creatures.listIterator();
                while (listIter.hasNext()) {
                    Creature decoratedCreature = listIter.next();
                    if (decoratedCreature.getAttackRange() == 1) {
                        decoratedCreature = new PercentDamageReduceCreatureDecorator(decoratedCreature, 5);
                    }
                    listIter.set(decoratedCreature);
                }
                break;
            }
            case "Armourer: advanced": {
                List<Creature> creatures = hero.getCreatures();
                ListIterator<Creature> listIter = creatures.listIterator();
                while (listIter.hasNext()) {
                    Creature decoratedCreature = listIter.next();
                    if (decoratedCreature.getAttackRange() == 1) {
                        decoratedCreature = new PercentDamageReduceCreatureDecorator(decoratedCreature, 10);
                    }
                    listIter.set(decoratedCreature);
                }
                break;
            }
            case "Armourer: expert": {
                List<Creature> creatures = hero.getCreatures();
                ListIterator<Creature> listIter = creatures.listIterator();
                while (listIter.hasNext()) {
                    Creature decoratedCreature = listIter.next();
                    if (decoratedCreature.getAttackRange() == 1) {
                        decoratedCreature = new PercentDamageReduceCreatureDecorator(decoratedCreature, 15);
                    }
                    listIter.set(decoratedCreature);
                }
                break;
            }
            case "Leadership: basic": {
                System.out.println(aName);
                break;
            }
            case "Leadership: advanced": {
                System.out.println(aName);
                break;
            }
            case "Leadership: expert": {
                System.out.println(aName);
                break;
            }
            case "Luck: basic": {
                System.out.println(aName);
                break;
            }
            case "Luck: advanced": {
                System.out.println(aName);
                break;
            }
            case "Luck: expert": {
                System.out.println(aName);
                break;
            }
            default:
                throw new IllegalArgumentException(EXCEPTION_MESSEAGE);
        }
    }
}
