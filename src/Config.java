import java.io.File;

/**
 * Created by Satsu on 5/9/2016.
 */
public class Config {
    public static final String WORKINGDIR = System.getenv("APPDATA") + File.separator + "thegame";
    static {
        File appDir = new File(WORKINGDIR);
        if(!appDir.exists()) {
            appDir.mkdir();
        }
    }
}
