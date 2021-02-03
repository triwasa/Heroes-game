package pl.sdk.creatures;

import com.google.common.collect.Range;
import pl.sdk.DefaultDamageApplier;
import pl.sdk.fortifications.FortificationStatisticIf;

public class Wall implements BattleObject, Fortification {

    private int currentHp;
    private FortificationStatisticIf stats;
    private DamageApplierIf damageApplier;
    private int amount;

    Wall() {
    }


    Wall(FortificationStatisticIf aStats) {
        this.stats=aStats;
        currentHp=stats.getMaxHp();
        damageApplier = new DefaultDamageApplier();
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
    public boolean canFortifficationAttack() {
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
    public void currentHpAfterAttack(int currentHp) {
    }

    @Override
    public void amountAfterAttack(int aAmount) {
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
    public void counterAttack(Attacker attacker) {

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
}
