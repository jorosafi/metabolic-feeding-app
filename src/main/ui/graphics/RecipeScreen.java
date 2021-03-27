package ui.graphics;

import model.Recipe;
import ui.FeedingApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.time.chrono.JapaneseChronology;

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

        addButton("Submit", submitButton, formPanel);
    }

    private void addIngredientInput(JTextField textField, String labelName) {
        JPanel inputPanel = new JPanel();
        JLabel inputLabel = new JLabel(labelName);

        inputLabel.setFont(new Font("Arial", Font.BOLD, 18));
        inputLabel.setForeground(IVORY);

        inputPanel.setBackground(DARK_BLUE);
        inputPanel.add(inputLabel);
        inputPanel.add(textField);

        textField.setPreferredSize(new Dimension(40,40));
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
            System.out.println("Update Recipe");
            dashboard.remove(infoPanel);
            dashboard.add(formPanel);
            loadUpdateRecipeForm();
            formPanel.setVisible(true);
        }
    }


}
