package pl.sdk.hero;

import pl.sdk.creatures.BattleObject;
import pl.sdk.creatures.Creature;
import pl.sdk.spells.Spell;
import pl.sdk.spells.SpellBook;

import java.util.*;

public class Hero {
    private List<Creature> creatures = new ArrayList<>();
    private List<BattleObject> machines = new ArrayList<>();
    private HeroClassStatisticIf classStats;
    private HeroAdditionalStatisticIf additionalStats;
    private SpellBook spellBook;
    private HeroMana mana;

    public Hero(HeroClassStatisticIf aStats) {
        classStats = aStats;
        additionalStats = new HeroAdditionalStatistic(0,0,0,0,0,0);
        mana = new HeroMana(aStats.getKnowledge());
        spellBook = new SpellBook();
    }

    public Hero() {
        this(new HeroStatistic(0,0,0,0,0,0));
        spellBook = new SpellBook();
    }

    public void increaseStats(HeroClassStatisticIf values) {
        additionalStats.increaseStats(values);
        mana.increaseMana(values.getKnowledge());
    }

    public void increaseManaPercent(double percent) {
        mana.increaseManaPercent(percent);
    }

    public void addCreatures(List<Creature> aCreatures) {
        this.creatures = aCreatures;
    }

    public void addSpells(List<Spell> aSpells) {
        aSpells.forEach(spell -> this.spellBook.addSpell(spell));
    }

    public List<Creature> getCreatures() {
        return creatures;
    }
    public List<BattleObject> getMachines() {
        return machines;
    }
    public List<Spell> getSpells() { return new ArrayList<>(spellBook.getSpellBook()); }

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
        return classStats.getLuck() + additionalStats.getLuck();
    }
    public int getMorale() {
        return classStats.getMorale() + additionalStats.getMorale();
    }
    public int getMana() {
        return mana.getMana();
    }

    public static class BuilderForTesting {
        private Integer attack;
        private  Integer defence;
        private  Integer power;
        private  Integer knowledge;
        private Integer luck;
        private Integer morale;

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

        public Hero.BuilderForTesting luck (Integer luck){
            this.luck = luck;
            return this;
        }

        public Hero.BuilderForTesting morale (Integer morale){
            this.morale = morale;
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
            if (luck == null){
                emptyFields.add("luck");
            }
            if (morale == null){
                emptyFields.add("morale");
            }

            if (!emptyFields.isEmpty()){
                throw new IllegalStateException("These fileds: " + Arrays.toString(emptyFields.toArray()) + " cannot be empty");
            }

            HeroClassStatisticIf stats = new HeroStatistic(attack, defence, power, knowledge, luck, morale);
            Hero ret = createInstance(stats);
            return ret;
        }

        public Hero createInstance(HeroClassStatisticIf aStats) {
            return new Hero(aStats);
        }
    }

}



