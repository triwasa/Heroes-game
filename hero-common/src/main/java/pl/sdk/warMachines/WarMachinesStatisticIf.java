package pl.sdk.warMachines;
import com.google.common.collect.Range;

public interface WarMachinesStatisticIf {

    String getTranslatedName();

    int getAttack();

    int getArmor();

    int getMaxHp();

    int getMoveRange();

    Range<Integer> getDamage();

    String getDescription();
}
