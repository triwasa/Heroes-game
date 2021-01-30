package pl.sdk.creatures;



public interface Fortification extends Attacker {

    String getName();

    int getAmount();

    int getLevel();

    int getCurrentHp();

    int getMaxHp();

}
