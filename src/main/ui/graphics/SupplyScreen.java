package ui.graphics;

import model.IngredientSupply;
import model.Recipe;
import ui.FeedingApp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.HashMap;

public class SupplyScreen extends UtilityScreen {

    JButton updateSupplyButton;

    public SupplyScreen(FeedingApp feedingApp) {
        super(feedingApp);
    }

    @Override
    public void setPageTitle() {
        super.setPageTitle();
        title.setText("<html><p>Ingredient Supply</p></html>");
    }

    @Override
    public void setBody() {
        super.setBody();

        IngredientSupply currentSupply = feedingApp.getIngredientSupply();
        Recipe currentRecipe = feedingApp.getCurrentRecipe();
        HashMap<String, Double> timeEstimate = currentSupply.estimateIngredientSupply(currentRecipe);

        dashboard.setText("<html><p>Current Ingredient Supply</p><ul>\n"
                + "<li>Ivalex: " + currentSupply.getIvalex()
                + "gr (" + timeEstimate.get("Ivalex") + " days)</li>"
                + "<li>Pro-Phree: " + currentSupply.getProPhree()
                + "gr (" + timeEstimate.get("Pro Phree") + " days)</li>"
                + "<li>Glycine: " + currentSupply.getGlycine()
                + "gr (" + timeEstimate.get("Glycine") + " days)</li>"
                + "</ul></html>");

        addButton("Update Supply", updateSupplyButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        if ("Update Supply".equals(e.getActionCommand())) {
            System.out.println("Update Supply");
        }
    }
}
