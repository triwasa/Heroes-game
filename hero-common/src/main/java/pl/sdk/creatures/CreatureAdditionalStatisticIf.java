package pl.sdk.creatures;

import com.google.common.collect.Range;

public interface CreatureAdditionalStatisticIf {
    int getAdditionalMoveRange();
    int getAdditionalHp();
    int getResistance();
    int getAdditionalAttack();
    int getAdditionalDefence();
    Range<Integer> getAdditionalDamage();
}
