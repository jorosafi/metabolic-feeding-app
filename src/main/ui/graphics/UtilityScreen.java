package ui.graphics;

import ui.FeedingApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public abstract class UtilityScreen extends BasicScreen {
    FeedingApp feedingApp;
    JEditorPane dashboard;
    JButton mainMenu;
    HomeScreen homeScreen;

    public UtilityScreen(FeedingApp feedingApp) {
        super();
    }



    @Override
    public void setPageTitle() {
        super.setPageTitle();
        titlePanel.setBounds(0, 140, WIDTH, 145);
        title.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 30));
    }

    @Override
    public void setBody() {
        super.setBody();

        dashboard = new JEditorPane();
        dashboard.setBounds(45, 0, 360,300);
        dashboard.setSize(360, 300);
        dashboard.setBackground(IVORY);
        dashboard.setContentType("text/html");
        dashboard.setText("<h2>Dashboard Text</h2>");

        bodyPanel.setBounds(0, 285, WIDTH, 515);
        bodyPanel.add(dashboard);

        addButton("Main Menu", mainMenu);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ("Main Menu".equals(e.getActionCommand())) {
            frame.dispose();
            homeScreen = new HomeScreen(feedingApp);
        }
    }
}
