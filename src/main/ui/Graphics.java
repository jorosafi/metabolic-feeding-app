package ui;

import javax.swing.*;
import java.awt.*;

public class Graphics extends JFrame {
    public static final int WIDTH = 500;
    public static final int HEIGHT = 800;
    public static final String DARK_BLUE = "0b1c48";
    public static final String MID_BLUE = "265b8b";
    public static final String LIGHT_BLUE = "84c7f2";
    public static final String IVORY = "ececeb";
    private JFrame frame;
    private final String logoPath = "./images/rs.png";


    public Graphics() {
        //TODO complete constructor
    }

    //EFFECTS: Create window that will house the gui
    public void initializeGraphics() {
        frame = new JFrame();
        frame.setTitle("Metabolic Baby Feeding App");
        frame.setSize(WIDTH,HEIGHT); //If needed, can set minimum size with setMinimumSize()
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon imageIcon = new ImageIcon(logoPath);
        frame.setIconImage(imageIcon.getImage());

        frame.getContentPane().setBackground(new Color(0x0b1c48));

        setHeader();
    }

    private void setHeader() {
        //ImageIcon logo = new ImageIcon(logoPath);

        JLabel header = new JLabel();
        header.setText("Welcome to Santiago's Feeding App!");
        //header.setIcon(logo);
        header.setVerticalTextPosition(JLabel.BOTTOM);
        header.setHorizontalTextPosition(JLabel.CENTER);
        header.setVerticalAlignment(JLabel.TOP);
        header.setHorizontalAlignment(JLabel.CENTER);
        header.setForeground(new Color(0xececeb));

        frame.add(header);
    }

//    private void createTools() {
//        JPanel toolArea = new JPanel();
//        toolArea.setLayout(new GridLayout(1,1));
//        toolArea.setSize(new Dimension(200, 200));
//        add(toolArea, BorderLayout.SOUTH);
//    }
}
