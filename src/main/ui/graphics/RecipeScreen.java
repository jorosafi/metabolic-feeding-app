package ui.graphics;

import model.Recipe;
import ui.FeedingApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

//Creates and styles the RecipeScreen using UtilityScreen as template
public class RecipeScreen extends UtilityScreen {
    JButton updateRecipeButton;
    JButton submitButton;
    JTextField ivalexTextField = new JTextField();
    JTextField enfamilTextField = new JTextField();
    JTextField proPhreeTextField = new JTextField();
    JTextField glycineTextField = new JTextField();
    JTextField breastMilkTextField = new JTextField();
    JTextField volumeTextField = new JTextField();

    //EFFECTS: Constructs RecipeScreen using UtilityScreen's contructor
    public RecipeScreen(FeedingApp feedingApp) {
        super(feedingApp);
    }

    @Override
    //MODIFIES: This(titlePanel)
    //EFFECTS: Set's page title
    public void setPageTitle() {
        super.setPageTitle();
        title.setText("<html><p>Current Formula Recipe</p></html>");
    }

    @Override
    //MODIFIES: This(bodyPanel)
    //EFFECTS: Adds recipe and action buttons to bodyPanel
    public void setBody() {
        super.setBody();

        addRecipeToBody();

        addButton("Update Recipe", updateRecipeButton);
        addButton("Main Menu", mainMenu);
    }

    //EFFECTS: Adds the recipe from feedingApp to bodyPanel in a human readsble format
    private void addRecipeToBody() {
        Recipe currentRecipe = feedingApp.getCurrentRecipe();

        infoPanel.setText("<html><ul>\n"
                + "<li>Ivalex: " + currentRecipe.getIvalex() + "</li>"
                + "<li>Enfamil: " + currentRecipe.getEnfamil() + "</li>"
                + "<li>Pro-Phree: " + currentRecipe.getProPhree() + "</li>"
                + "<li>Glycine: " + currentRecipe.getGlycine() + "</li>"
                + "<li>Breast Milk: " + currentRecipe.getBreastMilk() + "</li>"
                + "<li>Total Volume: " + currentRecipe.getVolume() + "</li>"
                + "</ul></html>");
    }

    //MODIFIES: this(formPanel)
    //EFFECTS: Creates user form for user to input new recipe values and loads it to dashboard
    public void loadUpdateRecipeForm() {
        JLabel formTitle = new JLabel("<html><h2>Enter New Ingredient Amounts</h2></html>");
        formTitle.setHorizontalTextPosition(JLabel.CENTER);
        formTitle.setVerticalTextPosition(JLabel.CENTER);
        formTitle.setForeground(IVORY);

        formPanel.add(formTitle);

        addIngredientInput(ivalexTextField, "Ivalex(gr)");
        addIngredientInput(enfamilTextField, "Enfamil (gr)");
        addIngredientInput(proPhreeTextField, "Pro Phree (gr)");
        addIngredientInput(glycineTextField, "Glycine (gr)");
        addIngredientInput(breastMilkTextField, "Breast Milk (ml)");
        addIngredientInput(volumeTextField, "Volume (ml)");

        addSubmitButton("Submit", submitButton, formPanel);
    }

    //MODIFIES: this(formPanel)
    //EFFECTS: Helper method for loadUpdateRecipeForm() that adds input fields to formPanel
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

    @Override
    //EFFECTS: Handles behaviour of action buttons
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        if ("Update Recipe".equals(e.getActionCommand())) {
            dashboard.remove(infoPanel);
            dashboard.add(formPanel);
            loadUpdateRecipeForm();
            formPanel.setVisible(true);

        } else if ("Submit".equals(e.getActionCommand())) {
            runSubmitCommand();
        }
    }

    //MODIFIES: This, feedingApp.currentRecipe
    //EFFECTS: When user clicks submit, values are updated in feedingApp.currentRecipe, dialog box confirms update
    //          and new RecipeScreen appears with new recipe. If user enters non-numerical values in form, method
    //          catches NumberFormatException and reminds user to only enter numerical values.
    private void runSubmitCommand() {
        try {
            double ivalexValue = getNewIngredientValue(ivalexTextField);
            double enfamilValue = getNewIngredientValue(enfamilTextField);
            double proPhreeValue = getNewIngredientValue(proPhreeTextField);
            double glycineValue = getNewIngredientValue(glycineTextField);
            double breastMilkValue = getNewIngredientValue(breastMilkTextField);
            double volumeValue = getNewIngredientValue(volumeTextField);

            updateIvalex(ivalexValue);
            updateEnfamil(enfamilValue);
            updateProPhree(proPhreeValue);
            updateGlycine(glycineValue);
            updateBreastMilk(breastMilkValue);
            updateVolume(volumeValue);

            frame.dispose();
            new RecipeScreen(this.feedingApp);
            JOptionPane.showMessageDialog(frame, "Your Recipe has been updated", "Recipe Updated",
                    JOptionPane.PLAIN_MESSAGE);
        } catch (NumberFormatException exception) {
            JOptionPane.showMessageDialog(frame, "Please enter a numeric value", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    //EFFECTS: returns value of textField in the form of Double. If textField is empty, return -1
    private double getNewIngredientValue(JTextField ingredientTextField) throws NumberFormatException {
        double ingredientAmount = -1;
        if (!ingredientTextField.getText().isEmpty()) {
            ingredientAmount = Double.parseDouble(ingredientTextField.getText());
        }
        return ingredientAmount;
    }

    //MODIFIES: feedingApp.currentRecipe
    //EFFECTS: Updates Ivalex amount of feedingApp.currentRecipe
    private void updateIvalex(double amount) {
        if (amount != -1) {
            feedingApp.getCurrentRecipe().setIvalex(amount);
        }
    }

    //MODIFIES: feedingApp.currentRecipe
    //EFFECTS: Updates ProPhree amount of feedingApp.currentRecipe
    private void updateProPhree(double amount) {
        if (amount != -1) {
            feedingApp.getCurrentRecipe().setProPhree(amount);
        }
    }

    //MODIFIES: feedingApp.currentRecipe
    //EFFECTS: Updates Enfamil amount of feedingApp.currentRecipe
    private void updateEnfamil(double amount) {
        if (amount != -1) {
            feedingApp.getCurrentRecipe().setEnfamil(amount);
        }
    }

    //MODIFIES: feedingApp.currentRecipe
    //EFFECTS: Updates Glycine amount of feedingApp.currentRecipe
    private void updateGlycine(double amount) {
        if (amount != -1) {
            feedingApp.getCurrentRecipe().setGlycine(amount);
        }
    }

    //MODIFIES: feedingApp.currentRecipe
    //EFFECTS: Updates BreastMilk amount of feedingApp.currentRecipe
    private void updateBreastMilk(double amount) {
        if (amount != -1) {
            feedingApp.getCurrentRecipe().setBreastMilk(amount);
        }
    }

    //MODIFIES: feedingApp.currentRecipe
    //EFFECTS: Updates Volume amount of feedingApp.currentRecipe
    private void updateVolume(double amount) {
        if (amount != -1) {
            feedingApp.getCurrentRecipe().setTotalVolume(amount);
        }
    }
}
