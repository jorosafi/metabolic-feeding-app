package ui.graphics;

import javax.swing.*;
import java.awt.*;

public class HomeScreen extends BasicScreen {

    public HomeScreen() {
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

        addButton("Recipe");
        addButton("Schedule");
        addButton("Feed Log");
        addButton("Ingredient Supply");
        addButton("Save & Exit");
    }

    public void addButton(String buttonName) {
        JButton button = new JButton(buttonName);

        button.setBackground(LIGHT_BLUE);
        button.setForeground(DARK_BLUE);
        button.setMinimumSize(new Dimension(260, 65)); //not working for some reason TODO
        button.setAlignmentX(Component.CENTER_ALIGNMENT);

        bodyPanel.add(button);
    }
}
