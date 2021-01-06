package pl.sdk.warMachines;
import pl.sdk.creatures.Creature;

interface CalculateDamageStrategy {

    int calculateDamage(WarMachine attacker, Creature aDefender);
}
