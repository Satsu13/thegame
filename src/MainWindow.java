import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * Created by Satsu on 5/9/2016.
 */
public class MainWindow extends JFrame {
    private JPanel contentPane;

    public MainWindow() {
        super();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        try {
            PropertiesManager.loadAndValidateProperties();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        contentPane = new JPanel(new BorderLayout());
        this.setContentPane(contentPane);
        contentPane.setPreferredSize(PropertiesManager.getResolution());
        goToMainMenu();
        setVisible(true);
    }

    public void goToMainMenu() {
        contentPane.removeAll();
        JPanel test = new JPanel(new GridBagLayout());
        contentPane.add(test, BorderLayout.CENTER);

        // button panel
        JPanel buttonPanel = new JPanel(new GridBagLayout());
        test.add(buttonPanel);
        JButton newGame = new JButton("New Game");
        JButton loadGame = new JButton("Load Game");
        JButton settings = new JButton("Settings");
        buttonPanel.add(newGame);
        buttonPanel.add(Box.createVerticalStrut(20));
        buttonPanel.add(loadGame);
        buttonPanel.add(Box.createVerticalStrut(20));
        buttonPanel.add(settings);


        pack();
    }


}
