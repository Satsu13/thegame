import com.sun.istack.internal.NotNull;

import java.awt.*;
import java.io.*;
import java.nio.file.FileSystemNotFoundException;
import java.util.Properties;

/**
 * Created by Satsu on 5/9/2016.
 */
public class PropertiesManager {
    public static final String DEFAULTSAVEPATH = Config.WORKINGDIR + File.separator + "properties.properties";

    private static Properties properties = new Properties();

    private PropertiesManager() {}

    public static void save() throws IOException {
        save(DEFAULTSAVEPATH);
    }

    public static void save(String filepath) throws IOException {
        System.out.println(filepath);
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

    public static void loadAndValidateProperties() throws IOException {
        loadAndValidateProperties(DEFAULTSAVEPATH);
    }

    /**
     * Loads the properties file at the given path and validates it, formatting and saving it as a default
     * property file if it is found to be invalid.
     */
    public static void loadAndValidateProperties(String path) throws IOException {
        try {
            PropertiesManager.load(path);
        } catch (IOException e) {
            PropertiesManager.loadDefaultProperties();
            PropertiesManager.save(path);
            return;
        }
        if(!(
                properties.containsKey("resolution") &&
                true &&
                true)) {
            loadDefaultProperties();
        }
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
