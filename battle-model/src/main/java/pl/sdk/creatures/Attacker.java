package pl.sdk.creatures;

public interface Attacker {

    void applyDamage(int aDamageToDeal);
    void counterAttack(Attacker aDefender);

}
