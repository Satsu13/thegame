package map;

import java.awt.*;

/**
 * Created by Satsu on 5/11/2016.
 */
public class Area {
    private Map map;

    public Area(Map map) {
        this.map = map;
    }

    public Area North() throws IndexOutOfBoundsException {
        Point coords = map.getPoint(this);
        return map.getArea(coords.x, coords.y + 1);
    }

    public Area East() throws IndexOutOfBoundsException {
        Point coords = map.getPoint(this);
        return map.getArea(coords.x + 1, coords.y);
    }

    public Area South() throws IndexOutOfBoundsException {
        Point coords = map.getPoint(this);
        return map.getArea(coords.x, coords.y - 1);
    }

    public Area West() throws IndexOutOfBoundsException {
        Point coords = map.getPoint(this);
        return map.getArea(coords.x - 1, coords.y);
    }
}
