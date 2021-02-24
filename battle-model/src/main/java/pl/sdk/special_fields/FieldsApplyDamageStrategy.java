package pl.sdk.special_fields;

import pl.sdk.creatures.BattleObject;

public class FieldsApplyDamageStrategy implements FieldsApplyStrategy {

    private int damageToApply;

    FieldsApplyDamageStrategy(int damageToApply) {
        this.damageToApply = damageToApply;
    }

    @Override
    public void apply(BattleObject creature) {
        creature.applyDamage(damageToApply);
    }
}
