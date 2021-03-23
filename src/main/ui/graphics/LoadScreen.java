package ui.graphics;

import ui.FeedingApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoadScreen extends BasicScreen implements ActionListener {

    JButton loadButton;
    HomeScreen homeScreen;

    public LoadScreen(FeedingApp feedingApp) {
        super(feedingApp);
    }

    @Override
    public void setBody() {
        super.setBody();

        JLabel introText = new JLabel("<HTML><h2>Please Load a Notebook to Proceed</h2>");
        introText.setForeground(IVORY);
        introText.setHorizontalTextPosition(SwingConstants.CENTER);
        bodyPanel.add(introText);
        addButton("Load Notebook", loadButton);

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
