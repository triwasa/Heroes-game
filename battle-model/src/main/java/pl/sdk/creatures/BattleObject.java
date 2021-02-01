package pl.sdk.creatures;


import com.google.common.collect.Range;

public interface BattleObject extends Defender {
    AttackStrategy getAttackStrategy();
    CalculateDamageStrategy getCalculateDamage();
    Range<Integer> getDamage();
    int getAttack();
}
