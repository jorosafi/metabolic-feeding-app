package ui.graphics;

import model.Recipe;
import ui.FeedingApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class RecipeScreen extends UtilityScreen {
    JButton updateRecipeButton;
    JButton submitButton;
    JTextField ivalexTextField = new JTextField();
    JTextField enfamilTextField = new JTextField();
    JTextField proPhreeTextField = new JTextField();
    JTextField glycineTextField = new JTextField();
    JTextField breastMilkTextField = new JTextField();
    JTextField volumeTextField = new JTextField();


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

        addRecipeToBody();

        addButton("Update Recipe", updateRecipeButton);
        addButton("Main Menu", mainMenu);
    }

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
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        if ("Update Recipe".equals(e.getActionCommand())) {
            dashboard.remove(infoPanel);
            dashboard.add(formPanel);
            loadUpdateRecipeForm();
            formPanel.setVisible(true);

        } else if ("Submit".equals(e.getActionCommand())) {

            updateIvalex(getNewIngredientValue(ivalexTextField));
            updateEnfamil(getNewIngredientValue(enfamilTextField));
            updateProPhree(getNewIngredientValue(proPhreeTextField));
            updateGlycine(getNewIngredientValue(glycineTextField));
            updateBreastMilk(getNewIngredientValue(breastMilkTextField));
            updateVolume(getNewIngredientValue(volumeTextField));

            frame.dispose();
            new RecipeScreen(this.feedingApp);
            JOptionPane.showMessageDialog(frame, "Your Recipe has been updated", "Recipe Updated",
                    JOptionPane.PLAIN_MESSAGE);
        }
    }

    //EFFECTS: returns value of textField in the form of Double. If textField is empty, return -1
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
            feedingApp.getCurrentRecipe().setIvalex(amount);
        }
    }

    private void updateProPhree(double amount) {
        if (amount != -1) {
            feedingApp.getCurrentRecipe().setProPhree(amount);
        }
    }

    private void updateEnfamil(double amount) {
        if (amount != -1) {
            feedingApp.getCurrentRecipe().setEnfamil(amount);
        }
    }

    private void updateGlycine(double amount) {
        if (amount != -1) {
            feedingApp.getCurrentRecipe().setGlycine(amount);
        }
    }

    private void updateBreastMilk(double amount) {
        if (amount != -1) {
            feedingApp.getCurrentRecipe().setBreastMilk(amount);
        }
    }

    private void updateVolume(double amount) {
        if (amount != -1) {
            feedingApp.getCurrentRecipe().setTotalVolume(amount);
        }
    }


}
