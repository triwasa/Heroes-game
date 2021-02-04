package pl.sdk.hero;

import pl.sdk.creatures.Creature;
import pl.sdk.heroClass.HeroClassStatisticIf;
import pl.sdk.spells.Spell;
import pl.sdk.spells.SpellBook;

import java.util.*;

public class Hero {
    private List<Creature> creatures = new ArrayList<>();
    private HeroClassStatisticIf classStats;
    private SpellBook spellBook;



    public Hero(HeroClassStatisticIf aStats) {
        classStats = aStats;
    }

    public Hero() {
        this(new HeroStatisticForTesting(0,0,0,0));
        spellBook = new SpellBook();
    }

    public void addCreatures(List<Creature> aCreatures) {
        this.creatures = aCreatures;
    }


    //TODO go away!
    public void addSpells(List<Spell> aSpells) {
        aSpells.forEach(s -> spellBook.addSpell(s));
    }

    public List<Creature> getCreatures() {
        return creatures;
    }

    public Set<Spell> getSpells() { return spellBook.getSpellBook(); }

    public Object getStats() {
        return classStats;
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

            HeroClassStatisticIf stats = new HeroStatisticForTesting(attack, defence, power, knowledge);
            Hero ret = createInstance(stats);
            return ret;
        }

        public Hero createInstance(HeroClassStatisticIf aStats) {
            return new Hero(aStats);
        }
    }

}



