package pl.sdk.creatures;

import com.google.common.collect.Range;

import java.beans.PropertyChangeEvent;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class Ballista implements BattleObject {


    private int currentHp;
    private PossibleAttackManagerIf possibleAttackManager;
    private CreatureStatisticIf stats;
    private CalculateDamageStrategy calculateDamageStrategy;
    private DamageApplierIf damageApplier;
    private AttackStrategy attackStrategy;
    private int amount;
    boolean counterAttackedThisTurn=true;


    Ballista(CreatureStatisticIf aStats) {
        this.stats=aStats;
        currentHp=stats.getMaxHp();
        possibleAttackManager = new PossibleAttackManagerForCreature();
        calculateDamageStrategy = new CalculateDamageBallistaStrategy();
        damageApplier = new DefaultDamageApplier();
        attackStrategy = new BallistaAttackStrategy();
        amount = 1;
    }

    public Ballista() {
        stats = CreatureStatistic.BALLISTA;
        calculateDamageStrategy = new CalculateDamageBallistaStrategy();
        damageApplier = new DefaultDamageApplier();
        possibleAttackManager = new PossibleAttackManagerForCreature();
    }



    @Override
    public AttackStrategy getAttackStrategy() {
        return attackStrategy;
    }

    @Override
    public CalculateDamageStrategy getCalculateDamage() {
        return calculateDamageStrategy;
    }

    @Override
    public void applyDamage(int aDamageToApply) {
        int fullCurrentHp = currentHp - aDamageToApply;
        if (fullCurrentHp <= 0) {
            amount = 0;
            currentHp = 0;
        }
        else
        {
            currentHp = fullCurrentHp;
        }
    }

    @Override
    public Range<Integer> getDamage() {
        return stats.getDamage();
    }

    @Override
    public int getAttack() {
        return stats.getAttack();
    }

    @Override
    public double getAttackRange() {
        return Double.MAX_VALUE;
    }

    @Override
    public boolean canFortificationAttack(Fortification fortification) {
        return possibleAttackManager.canFortificationAttack();
    }

    @Override
    public boolean canCreatureAttack() {
        return possibleAttackManager.canCreatureAttack();
    }

    @Override
    public DamageApplierIf getDamageApplier() {
        return damageApplier;
    }



    @Override
    public String getMovementType() {
        return stats.getMovementType();
    }

    @Override
    public int getMoveRange() {
        return 0;
    }

    @Override
    public boolean canCounterAttack() {
        return false;
    }

    @Override
    public boolean isAlive() {
        return amount > 0;
    }

    @Override
    public int getCurrentHp() {
        return currentHp;
    }

    @Override
    public boolean[][] getSplashRange() {
        boolean[][] ret = new boolean[3][3];
        ret[1][1] = true;
        return ret;
    }

    @Override
    public String getName() {
        return stats.getTranslatedName();
    }

    @Override
    public int getAmount() {

        if (currentHp > 0) {
            return 1;
        } else return 0;


    }

    @Override
    public int getMaxHp() {
        return stats.getMaxHp();
    }



    @Override
    public int getArmor() {
        return stats.getArmor();
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
    public void counterAttackedInThisTurn() {

            }

    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent) {

    }


    static class BuilderForTesting {
        private String name;
        private Integer attack;
        private Integer armor;
        private Integer maxHp;
        private Integer moveRange;
        private Range<Integer> damage;
        private CalculateDamageBallistaStrategy damageCalculator;
        private DamageApplierIf damageApplier;
        private AttackStrategy attackStrategy;
        private Integer amount;

        Ballista.BuilderForTesting name (String name){
            this.name = name;
            return this;
        }
        Ballista.BuilderForTesting attack (int attack){
            this.attack = attack;
            return this;
        }
        Ballista.BuilderForTesting armor (int armor){
            this.armor = armor;
            return this;
        }
        Ballista.BuilderForTesting maxHp (int maxHp){
            this.maxHp = maxHp;
            return this;
        }
        Ballista.BuilderForTesting moveRange (int moveRange){
            this.moveRange = moveRange;
            return this;
        }
        Ballista.BuilderForTesting damage (Range<Integer> damage){
            this.damage = damage;
            return this;
        };
        Ballista.BuilderForTesting amount(int amount){
            this.amount=amount;
            return this;
        }
        Ballista.BuilderForTesting damageCalculator (CalculateDamageBallistaStrategy aCalculateDamageStrategy){
            this.damageCalculator = aCalculateDamageStrategy;
            return this;
        }
        Ballista.BuilderForTesting damageApplier (DamageApplierIf aDamageApplier) {
            this.damageApplier = aDamageApplier;
            return this;
        }
        Ballista.BuilderForTesting attackStrategy (AttackStrategy aAttackStrategy){
            this.attackStrategy = aAttackStrategy;
            return this;
        }

        Ballista build(){
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
            Ballista ret = createInstance(stats);
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
                ret.calculateDamageStrategy = new CalculateDamageBallistaStrategy();
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
                ret.attackStrategy = new BallistaAttackStrategy();
            }

            return ret;
        }

        Ballista createInstance(CreatureStatisticIf aStats) {
            return new Ballista(aStats);
        }
    }

}
