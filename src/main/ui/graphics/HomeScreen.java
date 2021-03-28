package ui.graphics;

import ui.FeedingApp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Creates, styles and adds functionality to the app's home screen
public class HomeScreen extends BasicScreen implements ActionListener {

    JButton recipeButton;
    JButton scheduleButton;
    JButton logButton;
    JButton supplyButton;
    JButton saveButton;
    RecipeScreen recipeScreen;
    FeedingScheduleScreen feedingScheduleScreen;
    LogScreen logScreen;
    SupplyScreen supplyScreen;

    //EFFECTS: Constructs new HomeScreen
    public HomeScreen(FeedingApp feedingApp) {
        super(feedingApp);
    }


    @Override
    //MODIFIES: This (bodyPanel)
    //EFFECTS: Customizes bodyPanel for HomeScreen
    public void setBody() {
        super.setBody();

        bodyPanel.add(buttonPanel);

        addButton("Recipe", recipeButton);
        addButton("Schedule", scheduleButton);
        addButton("Feed Log", logButton);
        addButton("Ingredient Supply", supplyButton);
        addButton("Save & Exit", saveButton);

        buttonPanel.setVisible(true);
    }

    @Override
    //EFFECTS: Handles behaviour for buttons in HomeScreen.
    public void actionPerformed(ActionEvent e) {
        if ("Recipe".equals(e.getActionCommand())) {
            frame.dispose();
            recipeScreen = new RecipeScreen(feedingApp);
        } else if ("Feed Log".equals(e.getActionCommand())) {
            frame.dispose();
            logScreen = new LogScreen(feedingApp);
        } else if ("Schedule".equals(e.getActionCommand())) {
            frame.dispose();
            feedingScheduleScreen = new FeedingScheduleScreen(feedingApp);
        } else if ("Ingredient Supply".equals(e.getActionCommand())) {
            frame.dispose();
            supplyScreen = new SupplyScreen(feedingApp);
        } else {
            saveAndClose();
        }
    }

    //EFFECTS: Saves current notebook and notifies user the notebook has been saved. Dialog asks if user would like to
    //          exit or continue working.
    public void saveAndClose() {
        feedingApp.saveNotebook();
        int userDialogueResponse = JOptionPane.showConfirmDialog(null,
                "Your Notebook has been saved. Would you like to Exit?",
                "Notebook Saved",
                JOptionPane.YES_NO_OPTION);

        if (userDialogueResponse == 0) {
            feedingApp.setKeepGoingToFalse();
            frame.dispose();
            System.exit(0);
        }
    }
}
