package pl.sdk.fortifications;

import com.google.common.collect.Range;

public interface FortificationStatisticIf {

    String getTranslatedName();

    int getMaxHp();

    int getDamage();

    int getLevel();

    String getDescription();
}
