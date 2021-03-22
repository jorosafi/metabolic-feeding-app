package ui.graphics;

import ui.FeedingApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeScreen extends BasicScreen implements ActionListener {
    FeedingApp feedingApp;

    JButton recipeButton;
    JButton scheduleButton;
    JButton logButton;
    JButton supplyButton;
    JButton saveButton;

    RecipeScreen recipeScreen;
    FeedingScheduleScreen feedingScheduleScreen;
    LogScreen logScreen;
    SupplyScreen supplyScreen;

    public HomeScreen(FeedingApp feedingApp) {
        super();
    }

    @Override
    public void setPageTitle() {
        super.setPageTitle();
        title.setText("<HTML><H1>Santiago's Metabolic Feeding App</H1>");
        title.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 40));
    }

    @Override
    public void setBody() {
        super.setBody();

        addButton("Recipe", recipeButton);
        addButton("Schedule", scheduleButton);
        addButton("Feed Log", logButton);
        addButton("Ingredient Supply", supplyButton);
        addButton("Save & Exit", saveButton);
    }

    @Override
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
            System.out.println("save");
        }
    }
}
