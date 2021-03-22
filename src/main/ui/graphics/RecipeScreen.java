package ui.graphics;

import ui.FeedingApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class RecipeScreen extends UtilityScreen {
    FeedingApp feedingApp;
    JButton updateRecipeButton;

    public RecipeScreen(FeedingApp feedingApp) {
        super(feedingApp);
    }

    @Override
    public void setPageTitle() {
        super.setPageTitle();
        title.setText("<html><p>Current Formula Recipe</p></html>");
    }

    @Override
    public void setBody() {
        super.setBody();

        addButton("Update Recipe", updateRecipeButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        if ("Update Recipe".equals(e.getActionCommand())) {
            System.out.println("Update Recipe");
        }
    }
}
