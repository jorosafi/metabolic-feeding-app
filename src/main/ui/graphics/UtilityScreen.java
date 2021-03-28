package ui.graphics;

import ui.FeedingApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

//Abstract class that creates and styles basic architecture for the utility screens
public abstract class UtilityScreen extends BasicScreen {
    JPanel dashboard;
    JLabel infoPanel;
    JButton mainMenu;
    HomeScreen homeScreen;
    JPanel formPanel;

    //EFFECTS: Constructs and UtilityScreen using settings from Basic Screen
    public UtilityScreen(FeedingApp feedingApp) {
        super(feedingApp);
    }



    @Override
    //MODIFIES: this(titlePanel)
    //EFFECTS: Custom settings for titlePanel in UtilityScreens
    public void setPageTitle() {
        super.setPageTitle();
        titlePanel.setPreferredSize(new Dimension(WIDTH, 145));
    }

    @Override
    //MODIFIES: this(bodyPanel)
    //EFFECTS: Custom settings for bodyPanel in UtilityScreens
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

    //EFFECTS: Creates and styles the formPanel that houses the input forms in UtilityScreens
    private void setFormPanelStyling() {
        formPanel = new JPanel();
        formPanel.setPreferredSize(new Dimension(360, 300));
        formPanel.setVisible(false);
        formPanel.setBackground(DARK_BLUE);
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
    }

    //EFFECTS: Creates and styles the infoPanel that houses the information areas in UtilityScreens
    private void setInfoPanelStyling() {
        infoPanel = new JLabel();
        infoPanel.setPreferredSize(new Dimension(360, 300));
        infoPanel.setForeground(IVORY);
        infoPanel.setBackground(DARK_BLUE);
        infoPanel.setFont(new Font("Arial", Font.BOLD, 20));
        infoPanel.setText("<h2>Dashboard Text</h2>");
        infoPanel.setBorder(BorderFactory.createMatteBorder(10,20,10,20,DARK_BLUE));
    }

    //EFFECTS: Creates and styles the dashboard panel that houses the infoPanel and formPanels in UtilityScreens
    private void setDashboardStyling() {
        dashboard = new JPanel();
        dashboard.setBackground(DARK_BLUE);
        dashboard.setBorder(BorderFactory.createMatteBorder(5,0,5,0, MID_BLUE));
        dashboard.setLayout(new GridLayout(1,1,0,0));
    }

    @Override
    //EFFECTS: handles behaviour for Main Menu button across all UtilityScreens. Other buttons are handled in their
            // own class. Main Menu button disposes of existing frame and creates new HomeScreen for user.
    public void actionPerformed(ActionEvent e) {
        if ("Main Menu".equals(e.getActionCommand())) {
            frame.dispose();
            homeScreen = new HomeScreen(this.feedingApp);
        }
    }
}
