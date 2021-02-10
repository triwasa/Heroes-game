package pl.sdk.fortifications;

import com.google.common.collect.Range;

public interface FortificationStatisticIf {

    String getTranslatedName();

    int getMaxHp();

    Range<Integer> getDamage();

    int getLevel();

    String getDescription();
}
