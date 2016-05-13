package map;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Satsu on 5/11/2016.
 */
public class Map {
    public static final Dimension DEFAULTDIMENSION = new Dimension(10, 10);

    private Dimension size;
    private ArrayList<ArrayList<Area>> mapArray;

    public Map() {
        this(DEFAULTDIMENSION);
    }

    private Map(Dimension size) {
        this.size = size;
        mapArray = new ArrayList<>();
        for(int i = 0; i < size.height; i++) {
            ArrayList<Area> column = new ArrayList<>();
            for(int j = 0; j < size.width; j++) {
                column.add(new Area(this));
            }
        }
    }

    public Dimension getSize() {
        return size;
    }

    public boolean contains(Area area) {
        Point coords = getPoint(area);
        return coords.x > -1 && coords.y > -1;
    }

    public Point getPoint(Area area) {
        int x = 0;
        for(ArrayList<Area> column : mapArray) {
            int y = column.indexOf(area);
            if(y > -1) {
                return new Point(x, y);
            }
            x++;
        }
        return new Point(-1, -1);
    }

    public Area getArea(int x, int y) throws IndexOutOfBoundsException {
        return mapArray.get(x).get(y);
    }

    public void paint(Graphics graphics) {

    }
}
