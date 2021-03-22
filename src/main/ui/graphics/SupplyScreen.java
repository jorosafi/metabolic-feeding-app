package ui.graphics;

import ui.FeedingApp;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class SupplyScreen extends UtilityScreen {

    JButton updateSupplyButton;
    FeedingApp feedingApp;

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
