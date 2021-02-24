package pl.sdk.special_fields;

public class FieldsFactory {

    private static final String EXCEPTION_MESSAGE = "This field's name does not exist";

    public static Field create( String name ){
        switch (name) {
            case "Normal":
                return new Field(name, true, true, false, 1, new FieldsApplyNothingStrategy());
            case "Lava":
                return new Field(name, true, true, false, 0.5, new FieldsApplyDamageStrategy(5)); //damage per round, +fire magic upgrade
            case "Stone":
                return new Field(name, false, true, false, 0, new FieldsApplyNothingStrategy());
            case "Water":
                return new Field(name, true, true, false, 0.6, new FieldsApplyDamageStrategy(0)); //move range continue for 2 rounds, +water magic upgrade
            case "Poison":
                return new Field(name, true, true, true, 0.8, new FieldsApplyDamageStrategy(2)); //damage and range per round, continue for 3 rounds
            case "Mountain":
                return new Field(name, false, true, true, 0, new FieldsApplyNothingStrategy());
            case "ThunderStorm":
                return new Field(name, true, false, true, 0, new FieldsApplyDamageStrategy(2));
            case "Charm":
                return new Field(name, true, true, true, 0, new FieldsApplyModifyStatisticStrategy());
            default:
                throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }
    }
}