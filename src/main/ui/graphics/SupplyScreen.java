package ui.graphics;

import model.IngredientSupply;
import model.Recipe;
import ui.FeedingApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.HashMap;

//Creates SupplyScreen using UtilityScreen as template
public class SupplyScreen extends UtilityScreen {

    JButton updateSupplyButton;
    JButton submitButton;
    JTextField ivalexTextField = new JTextField();
    JTextField proPhreeTextField = new JTextField();
    JTextField glycineTextField = new JTextField();

    //EFFECTS: Constructs SupplyScreen using UtilityScreen's constructor
    public SupplyScreen(FeedingApp feedingApp) {
        super(feedingApp);
    }

    @Override
    //MODIFIES: This(titlePanel)
    //EFFECTS: Set's page title
    public void setPageTitle() {
        super.setPageTitle();
        title.setText("<html><p>Ingredient Supply</p></html>");
    }

    @Override
    //MODIFIES: This(bodyPanel)
    //EFFECTS: Adds recipe and action buttons to bodyPanel
    public void setBody() {
        super.setBody();

        addSupplyToBody();

        addButton("Update Supply", updateSupplyButton);
        addButton("Main Menu", mainMenu);
    }

    //EFFECTS: Adds the supply list from feedingApp to bodyPanel in a human readable format
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

    //MODIFIES: this(formPanel)
    //EFFECTS: Creates user form for user to input new ingredient supply values and loads it to dashboard
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

    //MODIFIES: this(formPanel)
    //EFFECTS: Helper method for loadUpdateSupplyForm() that adds input fields to formPanel
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

    //EFFECTS: returns value of textField in the form of Double. If textField is empty, return -1
    private double getNewIngredientValue(JTextField ingredientTextField) throws NumberFormatException {
        double ingredientAmount;
        if (ingredientTextField.getText().isEmpty()) {
            ingredientAmount = -1;
        } else {
            ingredientAmount = Double.parseDouble(ingredientTextField.getText());
        }
        return ingredientAmount;
    }

    //MODIFIES: feedingApp.supplyList
    //EFFECTS: Updates Ivalex amount of feedingApp.supplyList
    private void updateIvalex(double amount) {
        if (amount != -1) {
            feedingApp.getIngredientSupply().setIvalex(amount);
        }
    }

    //MODIFIES: feedingApp.supplyList
    //EFFECTS: Updates ProPhree amount of feedingApp.supplyList
    private void updateProPhree(double amount) {
        if (amount != -1) {
            feedingApp.getIngredientSupply().setProPhree(amount);
        }
    }

    //MODIFIES: feedingApp.supplyList
    //EFFECTS: Updates Glycine amount of feedingApp.supplyList
    private void updateGlycine(double amount) {
        if (amount != -1) {
            feedingApp.getIngredientSupply().setGlycine(amount);
        }
    }

    @Override
    //EFFECTS: Handles behaviour for buttons in SupplyScreen
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        if ("Update Supply".equals(e.getActionCommand())) {
            dashboard.remove(infoPanel);
            dashboard.add(formPanel);
            loadUpdateSupplyForm();
            formPanel.setVisible(true);
        } else if ("Submit".equals(e.getActionCommand())) {
            runSubmitCommand();
        }
    }

    //MODIFIES: This, feedingApp.supplyList
    //EFFECTS: When user clicks submit, values are updated in feedingApp.supplyList, dialog box confirms update
    //          and new SupplyScreen appears with new supply list. If user enters non-numerical values in form, method
    //          catches NumberFormatException and reminds user to only enter numerical values.
    private void runSubmitCommand() {
        try {
            double ivalexValue = getNewIngredientValue(ivalexTextField);
            double proPhreeValue = getNewIngredientValue(proPhreeTextField);
            double glycineValue = getNewIngredientValue(glycineTextField);

            updateIvalex(ivalexValue);
            updateProPhree(proPhreeValue);
            updateGlycine(glycineValue);

            frame.dispose();
            new SupplyScreen(this.feedingApp);
            JOptionPane.showMessageDialog(frame, "Your Ingredient Supply has been updated", "Recipe Updated",
                    JOptionPane.PLAIN_MESSAGE);
        } catch (NumberFormatException exception) {
            JOptionPane.showMessageDialog(frame, "Please enter a numeric value", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }


}
