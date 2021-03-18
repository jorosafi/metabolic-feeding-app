package ui.graphics;

import javax.swing.*;
import java.awt.*;

//Creates basic frame that will house all app screens
public class BasicScreen extends JFrame {
    public static final int WIDTH = 450;
    public static final int HEIGHT = 800;
    public static final int DARK_BLUE = 0x0b1c48;
    public static final int MID_BLUE = 0x265b8b;
    public static final int LIGHT_BLUE = 0x84c7f2;
    public static final int IVORY = 0xececeb;
    private JFrame frame;
    private final String logoPath = "./images/rs-small.png";


    //EFFECTS: Constructor creates window that will house basic gui for app
    public BasicScreen() {
        frame = new JFrame();
        frame.setTitle("Santiago's Feeding App");
        frame.setSize(WIDTH,HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(null);

        frame.getContentPane().setBackground(new Color(DARK_BLUE));

        setHeader();
        setPageTitle();
        setBody();
        frame.setVisible(true);
    }

    //MODIFIES: This (frame)
    //EFFECTS: Creates header panel for basic screen
    public void setHeader() {
        JPanel headerPanel = new JPanel();
        ImageIcon logo = new ImageIcon(logoPath);
        JLabel headerLogo = new JLabel();

        headerPanel.setBounds(0,0,WIDTH, 140);

        headerPanel.setBackground(Color.red);
        //headerPanel.setLayout(null);

        headerLogo.setIcon(logo);
        headerLogo.setVerticalAlignment(JLabel.CENTER);
        headerLogo.setHorizontalAlignment(JLabel.CENTER);
        headerLogo.setForeground(new Color(0xececeb));

        headerPanel.add(headerLogo);
        frame.add(headerPanel);

        headerPanel.setVisible(true);
    }

    //MODIFIES: This
    //EFFECTS: Creates Title Panel for Basic Screen
    public void setPageTitle() {
        JPanel titlePanel = new JPanel();
        JLabel title = new JLabel();

        titlePanel.setBounds(0, 140,WIDTH, 220);
        titlePanel.setBackground(Color.BLUE);

        title.setText("Santiago's Metabolic Feeding App!");
        title.setVerticalAlignment(JLabel.CENTER);
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setLayout(new FlowLayout());
        title.setForeground(new Color(IVORY));
        title.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 40));

        titlePanel.add(title);
        frame.add(titlePanel);

        title.setVisible(true);
        titlePanel.setVisible(true);
    }

    private void setBody() {
        //TODO
    }


}
