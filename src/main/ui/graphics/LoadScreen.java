package ui.graphics;

import ui.FeedingApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoadScreen extends BasicScreen implements ActionListener {

    JButton loadButton;
    HomeScreen homeScreen;
    private final String santiagoPath = "./images/santiago.jpg";

    public LoadScreen(FeedingApp feedingApp) {
        super(feedingApp);
    }

    @Override
    public void setBody() {
        super.setBody();

        JLabel introText = new JLabel("<HTML><h2>Please Load a Notebook to Proceed</h2>");
        introText.setForeground(IVORY);
        introText.setIcon(new ImageIcon(santiagoPath));
        //introText.setPreferredSize(new Dimension(200, 200));
        introText.setHorizontalTextPosition(JLabel.CENTER);
        introText.setVerticalTextPosition(JLabel.TOP);

        buttonPanel.add(introText);
        addButton("Load Notebook", loadButton);
        buttonPanel.setVisible(true);

        bodyPanel.setLayout(new BoxLayout(bodyPanel, BoxLayout.Y_AXIS));
        bodyPanel.add(buttonPanel);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ("Load Notebook".equals(e.getActionCommand())) {
            frame.dispose();
            feedingApp.loadSavedNotebook();
            homeScreen = new HomeScreen(this.feedingApp);
        }
    }
}
