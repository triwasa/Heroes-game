package pl.sdk.hero;

import pl.sdk.creatures.Creature;
import pl.sdk.heroClass.HeroClassStatisticIf;

import java.util.*;

public class Hero {
    List<Spell> spells = new ArrayList<>();
    List<Creature> creatures = new ArrayList<>();
    HeroClassStatisticIf classStats;

    public Hero(HeroClassStatisticIf aStats) {
        classStats = aStats;
    }

    public void addCreatures(List<Creature> aCreatures) {
        this.creatures = aCreatures;
    }

    public void addSpells(List<Spell> aSpells) {
        this.spells = aSpells;
    }

    public List<Creature> getCreatures() {
        return creatures;
    }

    public List<Spell> getSpells() { return spells; }

    public Object getStats() {
        return classStats;
    }



    public int getLuck() {
        return 0;
    }

    static class BuilderForTesting {
        private Integer attack;
        private  Integer defence;
        private  Integer power;
        private  Integer knowledge;

        Hero.BuilderForTesting attack (Integer attack){
            this.attack = attack;
            return this;
        }

        Hero.BuilderForTesting defence (Integer defence){
            this.defence = defence;
            return this;
        }

        Hero.BuilderForTesting power (Integer power){
            this.power = power;
            return this;
        }

        Hero.BuilderForTesting knowledge (Integer knowledge){
            this.knowledge = knowledge;
            return this;
        }

        Hero build() {
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

            HeroClassStatisticIf stats = new HeroStatisticForTesting(attack, defence, power, knowledge);
            Hero ret = createInstance(stats);
            return ret;
        }

        Hero createInstance(HeroClassStatisticIf aStats) {
            return new Hero(aStats);
        }
    }

}



