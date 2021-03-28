package ui.graphics;

import ui.FeedingApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public abstract class UtilityScreen extends BasicScreen {
    JPanel dashboard;
    JLabel infoPanel;
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

        setDashboardStyling();
        setInfoPanelStyling();
        setFormPanelStyling();

        dashboard.add(infoPanel);
        bodyPanel.add(dashboard);
        bodyPanel.add(buttonPanel);

        infoPanel.setVisible(true);
        buttonPanel.setVisible(true);
    }

    private void setFormPanelStyling() {
        formPanel = new JPanel();
        formPanel.setPreferredSize(new Dimension(360, 300));
        formPanel.setVisible(false);
        formPanel.setBackground(DARK_BLUE);
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
    }

    private void setInfoPanelStyling() {
        infoPanel = new JLabel();
        infoPanel.setPreferredSize(new Dimension(360, 300));
        infoPanel.setForeground(IVORY);
        infoPanel.setBackground(DARK_BLUE);
        infoPanel.setFont(new Font("Arial", Font.BOLD, 20));
        infoPanel.setText("<h2>Dashboard Text</h2>");
        infoPanel.setBorder(BorderFactory.createMatteBorder(10,20,10,20,DARK_BLUE));
    }

    private void setDashboardStyling() {
        dashboard = new JPanel();
        dashboard.setBackground(DARK_BLUE);
        dashboard.setBorder(BorderFactory.createMatteBorder(5,0,5,0, MID_BLUE));
        dashboard.setLayout(new GridLayout(1,1,0,0));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ("Main Menu".equals(e.getActionCommand())) {
            frame.dispose();
            homeScreen = new HomeScreen(this.feedingApp);
        }
    }
}
