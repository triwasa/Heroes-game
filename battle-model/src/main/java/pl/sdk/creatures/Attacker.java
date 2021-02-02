package pl.sdk.creatures;

public interface Attacker extends CreatureAttacker, FortificationAttacker{

    void applyDamage(int aDamageToDeal);
    void counterAttack(Attacker aDefender);

}
