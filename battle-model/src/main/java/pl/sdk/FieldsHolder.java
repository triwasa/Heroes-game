package pl.sdk;

import pl.sdk.special_fields.Field;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "fields")
@XmlAccessorType(XmlAccessType.FIELD)
public class FieldsHolder {
    @XmlElement(name = "fields")
    private List<String> things= null;

    public FieldsHolder() {
        things = new ArrayList<>();
    }

    public List<String> getThings() {
        return things;
    }

    public void setThings(List<String> things) {
        this.things = things;
    }

    public void addThing(String thing) {
        things.add(thing);
    }
}