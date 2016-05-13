import javax.swing.*;

/**
 * Created by Satsu on 5/9/2016.
 */
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainWindow mainWindow = new MainWindow();
            }
        });
    }
}
