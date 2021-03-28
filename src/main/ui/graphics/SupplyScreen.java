package ui.graphics;

import model.IngredientSupply;
import model.Recipe;
import ui.FeedingApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.HashMap;

public class SupplyScreen extends UtilityScreen {

    JButton updateSupplyButton;
    JButton submitButton;
    JTextField ivalexTextField = new JTextField();
    JTextField proPhreeTextField = new JTextField();
    JTextField glycineTextField = new JTextField();

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

        addSupplyToBody();

        addButton("Update Supply", updateSupplyButton);
        addButton("Main Menu", mainMenu);
    }

    private void addSupplyToBody() {
        IngredientSupply currentSupply = feedingApp.getIngredientSupply();
        Recipe currentRecipe = feedingApp.getCurrentRecipe();
        HashMap<String, Double> timeEstimate = currentSupply.estimateIngredientSupply(currentRecipe);

        infoPanel.setText("<html><p>Ivalex: " + currentSupply.getIvalex()
                + "gr (" + Math.round(timeEstimate.get("Ivalex")) + " days)</p>"
                + "<p>Pro-Phree: " + currentSupply.getProPhree()
                + "gr (" + Math.round(timeEstimate.get("Pro Phree")) + " days)</p>"
                + "<p>Glycine: " + currentSupply.getGlycine()
                + "gr (" + Math.round(timeEstimate.get("Glycine")) + " days)</p></html>");
    }

    private void loadUpdateSupplyForm() {
        JLabel formTitle = new JLabel("<html><h2>Enter New Ingredient Amounts</h2></html>");
        formTitle.setHorizontalTextPosition(JLabel.CENTER);
        formTitle.setVerticalTextPosition(JLabel.CENTER);
        formTitle.setForeground(IVORY);

        formPanel.add(formTitle);

        addIngredientInput(ivalexTextField, "Ivalex(gr)");
        addIngredientInput(proPhreeTextField, "Pro Phree (gr)");
        addIngredientInput(glycineTextField, "Glycine (gr)");

        addSubmitButton("Submit", submitButton, formPanel);
    }

    private void addIngredientInput(JTextField textField, String labelName) {
        JPanel inputPanel = new JPanel();
        JLabel inputLabel = new JLabel(labelName);

        inputLabel.setFont(new Font("Arial", Font.BOLD, 16));
        inputLabel.setForeground(IVORY);

        inputPanel.setBackground(DARK_BLUE);
        inputPanel.add(inputLabel);
        inputPanel.add(textField);

        textField.setPreferredSize(new Dimension(45, 35));
        textField.setFont(new Font("Arial", Font.PLAIN, 22));
        textField.setBackground(IVORY);
        textField.setForeground(DARK_BLUE);

        formPanel.add(inputPanel);
        inputPanel.setVisible(true);
    }

    private double getNewIngredientValue(JTextField ingredientTextField) {
        double ingredientAmount;
        if (ingredientTextField.getText().isEmpty()) {
            ingredientAmount = -1;
        } else {
            ingredientAmount = Double.parseDouble(ingredientTextField.getText());
        }
        return ingredientAmount;
    }

    private void updateIvalex(double amount) {
        if (amount != -1) {
            feedingApp.getIngredientSupply().setIvalex(amount);
        }
    }

    private void updateProPhree(double amount) {
        if (amount != -1) {
            feedingApp.getIngredientSupply().setProPhree(amount);
        }
    }

    private void updateGlycine(double amount) {
        if (amount != -1) {
            feedingApp.getIngredientSupply().setGlycine(amount);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        if ("Update Supply".equals(e.getActionCommand())) {
            System.out.println("Update Supply");
            dashboard.remove(infoPanel);
            dashboard.add(formPanel);
            loadUpdateSupplyForm();
            formPanel.setVisible(true);
        } else if ("Submit".equals(e.getActionCommand())) {

            updateIvalex(getNewIngredientValue(ivalexTextField));
            updateProPhree(getNewIngredientValue(proPhreeTextField));
            updateGlycine(getNewIngredientValue(glycineTextField));

            frame.dispose();
            new SupplyScreen(this.feedingApp);
            JOptionPane.showMessageDialog(frame, "Your Recipe has been updated", "Recipe Updated",
                    JOptionPane.PLAIN_MESSAGE);
        }
    }


}
