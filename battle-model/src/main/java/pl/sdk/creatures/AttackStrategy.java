package pl.sdk.creatures;

public interface AttackStrategy {
    void attack(Attacker aAttacker, Defender aDefender);
    void beforeAttack(Attacker aAttacker, Defender aDefender);
    void afterAttack(Attacker aAttacker, Defender aDefender);
}

