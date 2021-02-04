package pl.sdk;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "points")
@XmlAccessorType(XmlAccessType.FIELD)
public class PointHolder {
    @XmlElement(name = "point")
    private List<Point> things= null;

    public PointHolder() {
        things = new ArrayList<>();
    }

    public void setThings(List<Point> things) {
        this.things = things;
    }

    public List<Point> getThings() {
        return things;
    }

    public void addThing(Point thing) {
        things.add(thing);
    }
}