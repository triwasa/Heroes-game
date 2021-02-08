package pl.sdk.hero;

import pl.sdk.creatures.Creature;
import pl.sdk.spells.Spell;
import pl.sdk.spells.SpellBook;

import java.util.*;

public class Hero {
    private List<Creature> creatures = new ArrayList<>();
    private HeroClassStatisticIf classStats;
    private HeroAdditionalStatisticIf additionalStats;
    private SpellBook spellBook;

    public Hero(HeroClassStatisticIf aStats) {
        classStats = aStats;
        additionalStats = new HeroAdditionalStatistic(0,0,0,0);
    }

    public Hero() {
        this(new HeroStatistic(0,0,0,0));
        spellBook = new SpellBook();
    }

    public void increaseStats(HeroClassStatisticIf values) {
        additionalStats.increaseStats(values);
    }

    public void addCreatures(List<Creature> aCreatures) {
        this.creatures = aCreatures;
    }

    public List<Creature> getCreatures() {
        return creatures;
    }

    public Set<Spell> getSpells() { return spellBook.getSpellBook(); }

    public int getAttack() {
        return classStats.getAttack() + additionalStats.getAttack();
    }
    public int getDefence() {
        return classStats.getDefence() + additionalStats.getDefence();
    }
    public int getPower() {
        return classStats.getPower() + additionalStats.getPower();
    }
    public int getKnowledge() {
        return classStats.getKnowledge() + additionalStats.getKnowledge();
    }

    public int getLuck() {
        return 0;
    }

    public static class BuilderForTesting {
        private Integer attack;
        private  Integer defence;
        private  Integer power;
        private  Integer knowledge;

        public Hero.BuilderForTesting attack (Integer attack){
            this.attack = attack;
            return this;
        }

        public Hero.BuilderForTesting defence (Integer defence){
            this.defence = defence;
            return this;
        }

        public Hero.BuilderForTesting power (Integer power){
            this.power = power;
            return this;
        }

        public Hero.BuilderForTesting knowledge (Integer knowledge){
            this.knowledge = knowledge;
            return this;
        }

        public Hero build() {
            Set<String> emptyFields = new HashSet<>();
            if (attack == null ){
                emptyFields.add("attack");
            }
            if (defence == null ){
                emptyFields.add("defence");
            }
            if (power == null ){
                emptyFields.add("power");
            }
            if (knowledge == null ){
                emptyFields.add("knowledge");
            }

            if (!emptyFields.isEmpty()){
                throw new IllegalStateException("These fileds: " + Arrays.toString(emptyFields.toArray()) + " cannot be empty");
            }

            HeroClassStatisticIf stats = new HeroStatistic(attack, defence, power, knowledge);
            Hero ret = createInstance(stats);
            return ret;
        }

        public Hero createInstance(HeroClassStatisticIf aStats) {
            return new Hero(aStats);
        }
    }

}



