package pl.sdk.creatures;

import com.google.common.collect.Range;
import pl.sdk.fortifications.FortificationStatistic;
import pl.sdk.fortifications.FortificationStatisticIf;

import java.beans.PropertyChangeEvent;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Wall implements BattleObject, Fortification {

    private int currentHp;
    private FortificationStatisticIf stats;
    private DamageApplierIf damageApplier;
    private int amount;

    public Wall() {
        stats=FortificationStatistic.WALL;
        damageApplier=new DefaultDamageApplier();
        currentHp=stats.getMaxHp();
        amount = 1;
    }


    Wall(FortificationStatisticIf aStats) {
        this.stats=aStats;
        currentHp=stats.getMaxHp();
        damageApplier=new DefaultDamageApplier();
        amount = 1;
    }


    @Override
    public AttackStrategy getAttackStrategy() {
        return null;
    }

    @Override
    public CalculateDamageStrategy getCalculateDamage() {
        return null;
    }

    @Override
    public Range<Integer> getDamage() {
        return null;
    }

    @Override
    public int getAttack() {
        return 0;
    }

    @Override
    public double getAttackRange() {
        return 0;
    }

    @Override
    public boolean canFortificationAttack(Fortification fortification) {
        return false;
    }

    @Override
    public boolean canCreatureAttack() {
        return false;
    }

    @Override
    public int getLevel() {
        return 0;
    }

    @Override
    public DamageApplierIf getDamageApplier() {
        return damageApplier;
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
    public boolean isCreature() {
        return false;
    }

    @Override
    public boolean isFortification() {
        return true;
    }



    @Override
    public boolean isAlive() {
        return amount > 0;
    }

    @Override
    public String getName() {
        return stats.getTranslatedName();
    }

    @Override
    public int getArmor() {
        return 0;
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
    public int getCurrentHp() {
        return currentHp;
    }

    @Override
    public boolean[][] getSplashRange() {
        return new boolean[0][];
    }

    @Override
    public String getMovementType() {
        return null;
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
    public void counterAttackedInThisTurn() {

    }

    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent) {

    }

    static class Builder {
        private FortificationStatisticIf stats;
        private CalculateDamageStrategy damageCalculator;
        private DamageApplierIf damageApplier;
        private AttackStrategy attackStrategy;
        private Integer amount;

        Wall.Builder statistic(FortificationStatisticIf aStats) {
            this.stats=aStats;
            return this;
        }

        ;

        Wall.Builder amount(int amount) {
            this.amount=amount;
            return this;
        }

        Wall.Builder damageCalculator(CalculateDamageStrategy aCalculateDamageStrategy) {
            this.damageCalculator=aCalculateDamageStrategy;
            return this;
        }

        Wall.Builder damageApplier(DamageApplierIf aDamageApplier) {
            this.damageApplier=aDamageApplier;
            return this;
        }

        Wall.Builder attackStrategy(AttackStrategy aAttackStrategy) {
            this.attackStrategy=aAttackStrategy;
            return this;
        }

        Wall build() {
            Set<String> emptyFields=new HashSet<>();
            if (stats == null) {
                emptyFields.add("stats");
            }
            if (!emptyFields.isEmpty()) {
                throw new IllegalStateException("These fileds: " + Arrays.toString(emptyFields.toArray()) + " cannot be empty");
            }

            Wall ret=createInstance(stats);
            if (amount == null) {
                ret.amount=1;
            } else {
                ret.amount=amount;
            }
            if (damageApplier != null) {
                ret.damageApplier=damageApplier;
            } else {
                ret.damageApplier=new DefaultDamageApplier();
            }

            return ret;

        }

        Wall createInstance(FortificationStatisticIf aStats) {
            return new Wall(aStats);
        }

    }

    static class BuilderForTesting {
        private String name;
        private Integer maxHp;
        private Range<Integer> damage;
        private DamageApplierIf damageApplier;
        private Integer amount;

        BuilderForTesting name(String name) {
            this.name=name;
            return this;
        }

        BuilderForTesting maxHp(int maxHp) {
            this.maxHp=maxHp;
            return this;
        }

        BuilderForTesting damage(Range<Integer> damage) {
            this.damage=damage;
            return this;
        }

        BuilderForTesting amount(int amount) {
            this.amount=amount;
            return this;
        }

        BuilderForTesting damageApplier(DamageApplierIf aDamageApplier) {
            this.damageApplier=aDamageApplier;
            return this;
        }

        Wall build() {
            Set<String> emptyFields=new HashSet<>();
            if (name == null) {
                emptyFields.add("name");
            }
            if (maxHp == null) {
                emptyFields.add("maxHp");
            }

            if (damage == null) {
                emptyFields.add("damage");
            }
            if (!emptyFields.isEmpty()) {
                throw new IllegalStateException("These fileds: " + Arrays.toString(emptyFields.toArray()) + " cannot be empty");
            }

            FortificationStatisticIf stats=new FortificationStatisticForTesting(name, maxHp, damage);
            Wall ret=createInstance(stats);
            if (amount == null) {
                ret.amount=1;
            } else {
                ret.amount=amount;
            }

            if (damageApplier != null) {
                ret.damageApplier=damageApplier;
            } else {
                ret.damageApplier=new DefaultDamageApplier();
            }

            return ret;
        }

        Wall createInstance(FortificationStatisticIf aStats) {
            return new Wall(aStats);
        }
    }
}