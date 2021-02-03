package skills;

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
                    decoratedCreature = new PercentDamageReduceCreatureDecorator(decoratedCreature, 5);
                    listIter.set(decoratedCreature);
                }
                break;
            }
            case "Armourer: advanced": {
                List<Creature> creatures = hero.getCreatures();
                ListIterator<Creature> listIter = creatures.listIterator();
                while (listIter.hasNext()) {
                    Creature decoratedCreature = listIter.next();
                    decoratedCreature = new PercentDamageReduceCreatureDecorator(decoratedCreature, 10);
                    listIter.set(decoratedCreature);
                }
                break;
            }
            case "Armourer: expert": {
                List<Creature> creatures = hero.getCreatures();
                ListIterator<Creature> listIter = creatures.listIterator();
                while (listIter.hasNext()) {
                    Creature decoratedCreature = listIter.next();
                    decoratedCreature = new PercentDamageReduceCreatureDecorator(decoratedCreature, 15);
                    listIter.set(decoratedCreature);
                }
                break;
            }
            case "Leadership: basic": {
                //hero.increaseMorale(1);
                break;
            }
            case "Leadership: advanced": {
                //hero.increaseMorale(2);
                break;
            }
            case "Leadership: expert": {
                //hero.increaseMorale(3);
                break;
            }
            case "Luck: basic": {
                //hero.increaseLuck(1);
                break;
            }
            case "Luck: advanced": {
               // hero.increaseLuck(2);
                break;
            }
            case "Luck: expert": {
                //hero.increaseLuck(3);
                break;
            }
            case "Artillery: basic": {
                System.out.println(aName);
                break;
            }
            case "Artillery: advanced": {
                System.out.println(aName);
                break;
            }
            case "Artillery: expert": {
                System.out.println(aName);
                break;
            }
            case "Intelligence: basic": {
                //hero.IncreaseMana(hero.getMana() * 0.25);
                break;
            }
            case "Intelligence: advanced": {
                //hero.IncreaseMana(hero.getMana() * 0.55);
                break;
            }
            case "Intelligence: expert": {
                //hero.IncreaseMana(hero.getMana());
                break;
            }
            case "Resistance: basic": {
                List<Creature> creatures = hero.getCreatures();
                ListIterator<Creature> listIter = creatures.listIterator();
                while (listIter.hasNext()) {
                    //listIter.next().increaseResistance(5);
                }
                break;
            }
            case "Resistance: advanced": {
                List<Creature> creatures = hero.getCreatures();
                ListIterator<Creature> listIter = creatures.listIterator();
                while (listIter.hasNext()) {
                    //listIter.next().increaseResistance(10);
                }
                break;
            }
            case "Resistance: expert": {
                List<Creature> creatures = hero.getCreatures();
                ListIterator<Creature> listIter = creatures.listIterator();
                while (listIter.hasNext()) {
                    //listIter.next().increaseResistance(20);
                }
                break;
            }
            default:
                throw new IllegalArgumentException(EXCEPTION_MESSEAGE);
        }
    }
}
