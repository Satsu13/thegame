import java.io.*;
import java.nio.file.FileSystemNotFoundException;
import java.util.Properties;

/**
 * Created by Satsu on 5/9/2016.
 */
public class PropertiesManager {
    public static final String DEFAULTSAVEPATH = System.getenv("APPDATA") + File.pathSeparator + "thegame";

    private Properties properties;

    public PropertiesManager() {
        properties = new Properties();
    }

    public void save() throws IOException {
        save(DEFAULTSAVEPATH);
    }

    public void save(String filepath) throws IOException {
        properties.store(new FileOutputStream(new File(filepath)), "");
    }

    public void load() throws IOException {
        load(DEFAULTSAVEPATH);
    }

    public void load(String filepath) throws IOException {
        properties.load(new FileInputStream(new File(filepath)));
    }
}
