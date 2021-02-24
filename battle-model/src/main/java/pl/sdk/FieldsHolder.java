package pl.sdk;

import pl.sdk.special_fields.Field;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "fields")
@XmlAccessorType(XmlAccessType.FIELD)
public class FieldsHolder {
    @XmlElement(name = "fields")
    private List<Field> things= null;

    public FieldsHolder() {
        things = new ArrayList<>();
    }

    public List<Field> getThings() {
        return things;
    }

    public void setThings(List<Field> things) {
        this.things = things;
    }

    public void addThing(Field thing) {
        things.add(thing);
    }
}