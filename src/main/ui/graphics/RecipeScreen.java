package ui.graphics;

import model.Recipe;
import ui.FeedingApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class RecipeScreen extends UtilityScreen {
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

        Recipe currentRecipe = feedingApp.getCurrentRecipe();

        infoPanel.setText("<html><ul>\n"
                + "<li>Ivalex: " + currentRecipe.getIvalex() + "</li>"
                + "<li>Enfamil: " + currentRecipe.getEnfamil() + "</li>"
                + "<li>Pro-Phree: " + currentRecipe.getProPhree() + "</li>"
                + "<li>Glycine: " + currentRecipe.getGlycine() + "</li>"
                + "<li>Breast Milk: " + currentRecipe.getBreastMilk() + "</li>"
                + "<li>Total Volume: " + currentRecipe.getVolume() + "</li>"
                + "</ul></html>");

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
