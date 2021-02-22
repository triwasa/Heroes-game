package pl.sdk.creatures;


import com.google.common.collect.Range;

import java.beans.PropertyChangeEvent;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FirstAidTent implements BattleObject {


    private int currentHp;
    private PossibleAttackManagerIf possibleAttackManager;
    private CreatureStatisticIf stats;
    private CalculateDamageStrategy calculateDamageStrategy;
    private DamageApplierIf damageApplier;
    private AttackStrategy attackStrategy;
    private CreatureAdditionalStatistic additionalStats;
    private int amount;


    FirstAidTent(CreatureStatisticIf aStats) {
        this.stats=aStats;
        currentHp=stats.getMaxHp();
        possibleAttackManager=new PossibleAttackManagerForCreature();
        calculateDamageStrategy=new HealCalculateDamageStrategy();
        damageApplier=new DefaultDamageApplier();
        attackStrategy=new DefaultAttackStrategy();
        additionalStats=new CreatureAdditionalStatistic();
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
    public Range<Integer> getDamage() {
        return Range.closed(stats.getDamage().lowerEndpoint() + additionalStats.getAdditionalDamage().lowerEndpoint(),
                        stats.getDamage().upperEndpoint() + additionalStats.getAdditionalDamage().upperEndpoint());
    }

    public void increaseDamage(int aLowerBound, int aUpperBound) {
        additionalStats.increaseDamage(aLowerBound, aUpperBound);
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
    public boolean canFortificationAttack() {
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
    public void applyDamage(int aDamageToApply) {
        int fullCurrentHp=currentHp - aDamageToApply;
        if (fullCurrentHp <= 0) {
            amount=0;
            currentHp=0;
        } else {
            currentHp=fullCurrentHp;
        }

    }

    @Override
    public String getMovementType() {
        return stats.getMovementType();
    }

    @Override
    public int getMoveRange() {
        return stats.getMoveRange();
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
        return new boolean[0][];
    }

    @Override
    public String getName() {
        return stats.getTranslatedName();
    }

    @Override
    public int getAmount() {
        return amount;
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
        private CalculateDamageStrategy damageCalculator;
        private DamageApplierIf damageApplier;
        private AttackStrategy attackStrategy;
        private Integer amount;

        FirstAidTent.BuilderForTesting name(String name) {
            this.name=name;
            return this;
        }

        FirstAidTent.BuilderForTesting attack(int attack) {
            this.attack=attack;
            return this;
        }

        FirstAidTent.BuilderForTesting armor(int armor) {
            this.armor=armor;
            return this;
        }

        FirstAidTent.BuilderForTesting maxHp(int maxHp) {
            this.maxHp=maxHp;
            return this;
        }

        FirstAidTent.BuilderForTesting moveRange(int moveRange) {
            this.moveRange=moveRange;
            return this;
        }

        FirstAidTent.BuilderForTesting damage(Range<Integer> damage) {
            this.damage=damage;
            return this;
        }

        ;

        FirstAidTent.BuilderForTesting amount(int amount) {
            this.amount=amount;
            return this;
        }

        FirstAidTent.BuilderForTesting damageCalculator(CalculateDamageStrategy aCalculateDamageStrategy) {
            this.damageCalculator=aCalculateDamageStrategy;
            return this;
        }

        FirstAidTent.BuilderForTesting damageApplier(DamageApplierIf aDamageApplier) {
            this.damageApplier=aDamageApplier;
            return this;
        }

        FirstAidTent.BuilderForTesting attackStrategy(AttackStrategy aAttackStrategy) {
            this.attackStrategy=aAttackStrategy;
            return this;
        }

        FirstAidTent build() {
            Set<String> emptyFields=new HashSet<>();
            if (name == null) {
                emptyFields.add("name");
            }
            if (attack == null) {
                emptyFields.add("attack");
            }
            if (armor == null) {
                emptyFields.add("armor");
            }
            if (maxHp == null) {
                emptyFields.add("maxHp");
            }
            if (moveRange == null) {
                emptyFields.add("moveRange");
            }
            if (damage == null) {
                emptyFields.add("damage");
            }
            if (!emptyFields.isEmpty()) {
                throw new IllegalStateException("These fileds: " + Arrays.toString(emptyFields.toArray()) + " cannot be empty");
            }

            CreatureStatisticIf stats=new CreatureStatisticForTesting(name, attack, armor, maxHp, moveRange, damage);
            FirstAidTent ret=createInstance(stats);
            if (amount == null) {
                ret.amount=1;
            } else {
                ret.amount=amount;
            }
            if (damageCalculator != null) {
                ret.calculateDamageStrategy=damageCalculator;
            } else {
                ret.calculateDamageStrategy=new DefaultCalculateStrategy();
            }
            if (damageApplier != null) {
                ret.damageApplier=damageApplier;
            } else {
                ret.damageApplier=new DefaultDamageApplier();
            }
            if (attackStrategy != null) {
                ret.attackStrategy=attackStrategy;
            } else {
                ret.attackStrategy=new DefaultAttackStrategy();
            }

            return ret;
        }

        FirstAidTent createInstance(CreatureStatisticIf aStats) {
            return new FirstAidTent(aStats);
        }
    }
}
