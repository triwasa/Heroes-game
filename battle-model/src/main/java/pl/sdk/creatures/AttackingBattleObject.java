package pl.sdk.creatures;


import com.google.common.collect.Range;

public interface AttackingBattleObject extends BattleObjectStatistic {
    AttackStrategy getAttackStrategy();
    CalculateDamageStrategy getCalculateDamage();
    Range<Integer> getDamage();
    int getAttack();
}
