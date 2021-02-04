package pl.sdk.creatures;

import com.google.common.collect.Range;
import pl.sdk.DefaultDamageApplier;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Creature implements PropertyChangeListener, BattleObject {

    private final CreatureStatisticIf stats;
    private int currentHp;
    private boolean counterAttackedInThisTurn;
    private CalculateDamageStrategy calculateDamageStrategy;
    private DamageApplierIf damageApplier;
    private AttackStrategy attackStrategy;
    private int amount;
    private PossibleAttackManagerIf possibleAttacKManager;

    // Constructor for mockito. Don't use it! You have builder here.
    Creature(){
        stats = CreatureStatistic.TEST;
        calculateDamageStrategy = new DefaultCalculateStrategy();
        damageApplier = new DefaultDamageApplier();
        possibleAttacKManager = new PossibleAttackManagerForCreature();
    }

    Creature(CreatureStatisticIf aStats){
        stats = aStats;
        currentHp = stats.getMaxHp();
    }

    public void counterAttack(BattleObject aAttacker) {
        if (canCounterAttack()){
            int damageToDealInCounterAttack = getCalculateDamage().calculateDamage(this, aAttacker);
            aAttacker.getDamageApplier().applyDamage(damageToDealInCounterAttack, aAttacker);
            counterAttackedInThisTurn();
        }
    }

    void counterAttackedInThisTurn() {
        counterAttackedInThisTurn = true;
    }

    public boolean isAlive() {
        return amount > 0;
    }

    @Override
    public void currentHpAfterAttack(int aCurrentHp) {
        currentHp = aCurrentHp;
    }

    @Override
    public void amountAfterAttack(int aAmount) {
        amount = aAmount;
    }

    @Override
    public boolean isCreature() {
        return true;
    }

    @Override
    public boolean isFortification() {
        return false;
    }

    @Override
    public void counterAttack(Attacker attacker) {

    }

    public int getCurrentHp() {
        return currentHp;
    }


    public String getName(){
        return stats.getTranslatedName();
    }

    public boolean canCounterAttack() {
        return !counterAttackedInThisTurn;
    }

    public int getMoveRange() {
        return stats.getMoveRange();
    }

    public String getMovementType() {
        return stats.getMovementType();
    }

    @Override
    public void propertyChange(PropertyChangeEvent aPropertyChangeEvent) {
        counterAttackedInThisTurn = false;
    }



    @Override
    public DamageApplierIf getDamageApplier() {
        return damageApplier;
    }


    public int getAttack() {
        return stats.getAttack();
    }

    @Override
    public AttackStrategy getAttackStrategy() {
        return attackStrategy;
    }

    @Override
    public CalculateDamageStrategy getCalculateDamage() {
        return calculateDamageStrategy;
    }

    public int getArmor() {
        return stats.getArmor();
    }

    public Range<Integer> getDamage() {
        return stats.getDamage();
    }

    public int getAmount(){
        return amount;
    }

    public int getMaxHp() {
        return stats.getMaxHp();
    }


    public String currentHealth() {
        StringBuilder sb = new StringBuilder();
        sb.append(getCurrentHp());
        sb.append("/");
        sb.append(stats.getMaxHp());
        return sb.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(stats.getTranslatedName());
        sb.append(System.lineSeparator());
        sb.append(getCurrentHp());
        sb.append("/");
        sb.append(stats.getMaxHp());
        return sb.toString();
    }

    public double getAttackRange() {
        return 1.0;
    }

    @Override
    public boolean canFortificationAttack() {
        return possibleAttacKManager.canFortificationAttack();
    }

    @Override
    public boolean canCreatureAttack() {
        return possibleAttacKManager.canCreatureAttack();
    }

    void setCurrentHpToMaximum() {
        currentHp = stats.getMaxHp();
    }

    public boolean[][] getSplashRange() {
        boolean[][] ret = new boolean[3][3];
        ret[1][1] = true;
        return ret;
    }

    public boolean backToPreviousPositionMechanic() {
        return false;
    }


    static class Builder {
        private CreatureStatisticIf stats;
        private CalculateDamageStrategy damageCalculator;
        private DamageApplierIf damageApplier;
        private AttackStrategy attackStrategy;
        private Integer amount;

        Builder statistic (CreatureStatisticIf aStats){
            this.stats = aStats;
            return this;
        };
        Builder amount(int amount){
            this.amount=amount;
            return this;
        }
        Builder damageCalculator (CalculateDamageStrategy aCalculateDamageStrategy){
            this.damageCalculator = aCalculateDamageStrategy;
            return this;
        }
        Builder damageApplier (DamageApplierIf aDamageApplier){
            this.damageApplier = aDamageApplier;
            return this;
        }
        Builder attackStrategy (AttackStrategy aAttackStrategy){
            this.attackStrategy = aAttackStrategy;
            return this;
        }

        Creature build(){
            Set<String> emptyFields = new HashSet<>();
            if (stats == null){
                emptyFields.add("stats");
            }
            if (!emptyFields.isEmpty()){
                throw new IllegalStateException("These fileds: " + Arrays.toString(emptyFields.toArray()) + " cannot be empty");
            }

            Creature ret = createInstance(stats);
            if(amount == null){
                ret.amount=1;
            }
            else{
                ret.amount = amount;
            }
            if (damageCalculator != null){
                ret.calculateDamageStrategy = damageCalculator;
            }
            else{
                ret.calculateDamageStrategy = new DefaultCalculateStrategy();
            }
            if (damageApplier != null) {
                ret.damageApplier = damageApplier;
            }
            else {
                ret.damageApplier = new DefaultDamageApplier();
            }
            if (attackStrategy != null) {
                ret.attackStrategy = attackStrategy;
            }
            else {
                ret.attackStrategy = new DefaultAttackStrategy();
            }

            return ret;

        }

        Creature createInstance(CreatureStatisticIf aStats) {
            return new Creature(aStats);
        }

    }

    static class BuilderForTesting {
        private String name;
        private Integer attack;
        private Integer armor;
        private Integer maxHp;
        private Integer moveRange;
        private Range<Integer> damage;
        private CalculateDamageStrategy damageCalculator;
        private DamageApplierIf damageApplier;
        private AttackStrategy attackStrategy;
        private Integer amount;

        BuilderForTesting name (String name){
            this.name = name;
            return this;
        }
        BuilderForTesting attack (int attack){
            this.attack = attack;
            return this;
        }
        BuilderForTesting armor (int armor){
            this.armor = armor;
            return this;
        }
        BuilderForTesting maxHp (int maxHp){
            this.maxHp = maxHp;
            return this;
        }
        BuilderForTesting moveRange (int moveRange){
            this.moveRange = moveRange;
            return this;
        }
        BuilderForTesting damage (Range<Integer> damage){
            this.damage = damage;
            return this;
        };
        BuilderForTesting amount(int amount){
            this.amount=amount;
            return this;
        }
        BuilderForTesting damageCalculator (CalculateDamageStrategy aCalculateDamageStrategy){
            this.damageCalculator = aCalculateDamageStrategy;
            return this;
        }
        BuilderForTesting damageApplier (DamageApplierIf aDamageApplier) {
            this.damageApplier = aDamageApplier;
            return this;
        }
        BuilderForTesting attackStrategy (AttackStrategy aAttackStrategy){
            this.attackStrategy = aAttackStrategy;
            return this;
        }

        Creature build(){
            Set<String> emptyFields = new HashSet<>();
            if (name == null ){
                emptyFields.add("name");
            }
            if (attack == null){
                emptyFields.add("attack");
            }
            if (armor == null){
                emptyFields.add("armor");
            }
            if (maxHp == null){
                emptyFields.add("maxHp");
            }
            if (moveRange == null){
                emptyFields.add("moveRange");
            }
            if (damage == null){
                emptyFields.add("damage");
            }
            if (!emptyFields.isEmpty()){
                throw new IllegalStateException("These fileds: " + Arrays.toString(emptyFields.toArray()) + " cannot be empty");
            }

            CreatureStatisticIf stats = new CreatureStatisticForTesting(name, attack, armor, maxHp, moveRange, damage);
            Creature ret = createInstance(stats);
            if(amount == null){
                ret.amount=1;
            }
            else{
                ret.amount = amount;
            }
            if (damageCalculator != null){
                ret.calculateDamageStrategy = damageCalculator;
            }
            else{
                ret.calculateDamageStrategy = new DefaultCalculateStrategy();
            }
            if (damageApplier != null) {
                ret.damageApplier = damageApplier;
            }
            else {
                ret.damageApplier = new DefaultDamageApplier();
            }
            if (attackStrategy != null) {
                ret.attackStrategy = attackStrategy;
            }
            else {
                ret.attackStrategy = new DefaultAttackStrategy();
            }

            return ret;
        }

        Creature createInstance(CreatureStatisticIf aStats) {
            return new Creature(aStats);
        }
    }
}
