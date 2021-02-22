package pl.sdk.creatures;

public interface PossibleAttackManagerIf {
    boolean canFortificationAttack(Fortification fortification);
    boolean canCreatureAttack();
}
