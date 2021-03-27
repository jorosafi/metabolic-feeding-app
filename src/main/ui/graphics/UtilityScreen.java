package ui.graphics;

import ui.FeedingApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public abstract class UtilityScreen extends BasicScreen {
    JPanel dashboard;
    JEditorPane infoPanel;
    JButton mainMenu;
    HomeScreen homeScreen;
    JPanel formPanel;

    public UtilityScreen(FeedingApp feedingApp) {
        super(feedingApp);
    }



    @Override
    public void setPageTitle() {
        super.setPageTitle();
        //titlePanel.setBounds(0, 120, WIDTH, 145);
        titlePanel.setPreferredSize(new Dimension(WIDTH, 145));
        title.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 30));
    }

    @Override
    public void setBody() {
        super.setBody();
        bodyPanel.setLayout(new GridLayout(2,1,0,0));
        bodyPanel.setPreferredSize(new Dimension(WIDTH, 515));

        dashboard = new JPanel();
        //dashboard.setPreferredSize(new Dimension(WIDTH, 300));
        dashboard.setBackground(Color.darkGray);
        dashboard.setLayout(new GridLayout(1,1,0,0));

        infoPanel = new JEditorPane();
        //infoPanel.setPreferredSize(new Dimension(360, 300));
        infoPanel.setSize(360, 300);
        infoPanel.setBackground(DARK_BLUE);
        infoPanel.setContentType("text/html");
        infoPanel.setText("<h2>Dashboard Text</h2>");
        infoPanel.setBackground(Color.CYAN);

        formPanel = new JPanel();
        formPanel.setPreferredSize(new Dimension(360, 300));
        formPanel.setVisible(false);
        formPanel.setBackground(Color.MAGENTA);
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));

        dashboard.add(infoPanel);
        //dashboard.add(formPanel);
        bodyPanel.add(dashboard);
        bodyPanel.add(buttonPanel);

        addButton("Main Menu", mainMenu);

        infoPanel.setVisible(true);
        buttonPanel.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ("Main Menu".equals(e.getActionCommand())) {
            frame.dispose();
            homeScreen = new HomeScreen(this.feedingApp);
        }
    }
}
