import com.sun.istack.internal.NotNull;

import java.awt.*;
import java.io.*;
import java.nio.file.FileSystemNotFoundException;
import java.util.Properties;

/**
 * Created by Satsu on 5/9/2016.
 */
public class PropertiesManager {
    public static final String DEFAULTSAVEPATH = System.getenv("APPDATA") + File.separator + "thegame";
    static {
        System.out.println(DEFAULTSAVEPATH);
        File appDir = new File(DEFAULTSAVEPATH);
        if(!appDir.exists()) {
            appDir.mkdir();
        }
    }

    private static Properties properties = new Properties();

    private PropertiesManager() {}

    public static void save() throws IOException {
        save(DEFAULTSAVEPATH);
    }

    public static void save(String filepath) throws IOException {
        properties.store(new FileOutputStream(new File(filepath)), "");
    }

    public static void load() throws IOException {
        load(DEFAULTSAVEPATH);
    }

    public static void load(String filepath) throws IOException {
        properties.load(new FileInputStream(new File(filepath)));
    }

    public static void loadDefaultProperties() {
        properties = new Properties();
        setResolution(new Dimension(1024, 768));
    }

    @NotNull
    public static void setResolution(Dimension resolution) {
        String resolutionString = resolution.width + " " + resolution.height;
        properties.put("resolution", resolutionString);
    }

    public static Dimension getResolution() {
        String[] resolution = properties.getProperty("resolution").split("\\s+");
        return new Dimension(Integer.valueOf(resolution[0]), Integer.valueOf(resolution[1]));
    }
}
