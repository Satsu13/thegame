package gameflow;

import map.Map;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Satsu on 5/11/2016.
 */
public class Game extends Thread {
    private Map map;

    public Game(Map map) {
        this.map = map;
    }

    public void run() {

    }
}
