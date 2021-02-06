package pl.sdk.hero;

public interface HeroAdditionalStatisticIf extends HeroClassStatisticIf {

    int getLuck();
    int getMorale();
    void increaseStats(HeroClassStatisticIf values);
}
