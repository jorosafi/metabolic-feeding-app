package ui.graphics;

import ui.FeedingApp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Creates initial screen for app, which prompts user to load Notebook
public class LoadScreen extends BasicScreen implements ActionListener {

    JButton loadButton;
    HomeScreen homeScreen;

    ////EFFECTS: Constructs new LoadScreen using BasicScreen's constructor
    public LoadScreen(FeedingApp feedingApp) {
        super(feedingApp);
    }

    @Override
    //MODIFIES: this(bodyPanel)
    //EFFECTS: Custom settings and styles for bodyPanel in LoadScreen
    public void setBody() {
        super.setBody();

        String santiagoPath = "./images/santiago.jpg";
        JLabel introText = new JLabel("<html><h2>Please Load a Notebook to Proceed</h2></html>");
        introText.setForeground(IVORY);
        introText.setIcon(new ImageIcon(santiagoPath));
        introText.setHorizontalTextPosition(JLabel.CENTER);
        introText.setVerticalTextPosition(JLabel.TOP);

        buttonPanel.add(introText);
        addButton("Load Notebook", loadButton);
        buttonPanel.setVisible(true);

        bodyPanel.setLayout(new BoxLayout(bodyPanel, BoxLayout.Y_AXIS));
        bodyPanel.add(buttonPanel);

    }

    @Override
    //EFFECTS: Handles behaviour for Load Notebook button. Accesses loadSavedNotebook() function from feedingApp
    public void actionPerformed(ActionEvent e) {
        if ("Load Notebook".equals(e.getActionCommand())) {
            frame.dispose();
            feedingApp.loadSavedNotebook();
            homeScreen = new HomeScreen(this.feedingApp);
        }
    }
}
