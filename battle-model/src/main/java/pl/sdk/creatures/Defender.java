package pl.sdk.creatures;

public interface Defender extends Fortification, DefendingCreature {
    boolean attackable(CreatureAttacker attacker);
    boolean attackable(FortificationAttacker attacker);
}
