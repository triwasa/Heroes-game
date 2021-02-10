package pl.sdk.creatures;

import pl.sdk.hero.Hero;

public interface CalculateDamageStrategy {

    int calculateDamage(Attacker attacker, Defender aDefender);
    int calculateDamage(Attacker attacker, Defender aDefender, Hero hero);
}
