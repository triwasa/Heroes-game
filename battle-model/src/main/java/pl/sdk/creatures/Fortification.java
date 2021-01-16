package pl.sdk.creatures;

public interface Fortification {

    boolean isAttackPossible();

    String getName();

    int getAmount();

    int getLevel();

    int getCurrentHp();

    int getMaxHp();

    void applyDamage(int damageToDeal);
}
