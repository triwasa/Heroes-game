package pl.sdk.creatures;

public interface Defender extends Fortification, CreatureDefender {
    boolean attackable(CreatureAttacker attacker);
    boolean attackable(FortificationAttacker attacker);
}
