package pl.sdk.special_fields;

import static pl.sdk.special_fields.FlyFieldOptions.*;

public class FieldsFactory {

    private static final String EXCEPTION_MESSAGE = "This field's name does not exist";

    public static Field create( String name ){
        switch (name) {
            case "Normal":
                return new Field(name, true, TRUE, false, 0, 1);
            case "Lava":
                return new Field(name, true, TRUE, true, 10, 0.5); //damage per round, +fire magic upgrade
            case "Stone":
                return new Field(name, false, TRUE, false, 0, 0);
            case "Water":
                return new Field(name, true, TRUE, false, 0, 0.6); //move range continue for 2 rounds, +water magic upgrade
            case "Poison":
                return new Field(name, true, TRUE_WITH_DAMAGE, true, 5, 0.8); //damage and range per round, continue for 3 rounds
            case "Mountain":
                return new Field(name, false, FALSE, false, 0, 0);
            default:
                throw new IllegalArgumentException(EXCEPTION_MESSAGE);

        }
    }
}