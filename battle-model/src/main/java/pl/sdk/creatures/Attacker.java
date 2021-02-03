package pl.sdk.creatures;

import com.google.common.collect.Range;

public interface Attacker extends BattleObjectStatistic {

    AttackStrategy getAttackStrategy();
    CalculateDamageStrategy getCalculateDamage();
    Range<Integer> getDamage();
    int getAttack();
    double getAttackRange();


    boolean canFortifficationAttack();
    boolean canCreatureAttack();

}
