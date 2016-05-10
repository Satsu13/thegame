import javax.swing.*;
import java.io.IOException;

/**
 * Created by Satsu on 5/9/2016.
 */
public class MainWindow extends JFrame {
    private JPanel contentPane;

    public MainWindow() {
        super();

        try {
            PropertiesManager.load();
        } catch (IOException e) {
            try {
                PropertiesManager.loadDefaultProperties();
                PropertiesManager.save();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        contentPane = new JPanel();
        this.setContentPane(contentPane);
        contentPane.setPreferredSize(PropertiesManager.getResolution());
        pack();
        goToMainMenu();
    }

    public void goToMainMenu() {
        // draw main menu stuff here.
    }


}
