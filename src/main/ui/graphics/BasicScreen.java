package ui.graphics;

import ui.FeedingApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

//Creates basic frame that will house all app screens
public abstract class BasicScreen extends JFrame implements ActionListener {
    public static final int WIDTH = 450;
    public static final int HEIGHT = 800;
    public static final Color DARK_BLUE = new Color(0x0b1c48);
    public static final Color MID_BLUE = new Color(0x265b8b);
    public static final Color LIGHT_BLUE = new Color(0x84c7f2);
    public static final Color IVORY = new Color(0xececeb);
    protected JFrame frame;
    private final String logoPath = "./images/rs-small.png";
    protected JPanel titlePanel = new JPanel();
    protected JLabel title = new JLabel();
    protected JPanel bodyPanel = new JPanel();
    protected JPanel headerPanel = new JPanel();


    //EFFECTS: Constructor creates window that will house basic gui for app
    public BasicScreen() {

        frame = new JFrame();
        frame.setTitle("Santiago's Feeding App");
        frame.setSize(WIDTH,HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setResizable(false);
        frame.setLayout(null);

        frame.getContentPane().setBackground(DARK_BLUE);

        setHeader();
        setPageTitle();
        setBody();
        frame.setVisible(true);
    }

    //MODIFIES: This (frame)
    //EFFECTS: Creates header panel for basic screen
    public void setHeader() {
        ImageIcon logo = new ImageIcon(logoPath);
        JLabel headerLogo = new JLabel();

        headerPanel.setBounds(0,0,WIDTH, 140);
        headerPanel.setBackground(DARK_BLUE);

        headerLogo.setIcon(logo);
        headerLogo.setVerticalAlignment(JLabel.CENTER);
        headerLogo.setHorizontalAlignment(JLabel.CENTER);
        headerLogo.setForeground(IVORY);

        headerPanel.add(headerLogo);
        frame.add(headerPanel);

        headerPanel.setVisible(true);
    }

    //MODIFIES: This
    //EFFECTS: Creates Title Panel for Basic Screen
    public void setPageTitle() {

        titlePanel.setBounds(0, 140, WIDTH, 220);
        titlePanel.setBackground(DARK_BLUE);

        title.setVerticalAlignment(JLabel.CENTER);
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setLayout(new FlowLayout());
        title.setForeground(IVORY);

        titlePanel.add(title);
        frame.add(titlePanel);

        title.setVisible(true);
        titlePanel.setVisible(true);
    }

    public void setBody() {
        GridLayout gridLayout = new GridLayout(5, 1, 40, 20);
        BoxLayout boxLayout = new BoxLayout(bodyPanel,BoxLayout.Y_AXIS);

        bodyPanel.setBounds(0, 360, WIDTH, 380);
        bodyPanel.setBackground(DARK_BLUE);
        bodyPanel.setLayout(gridLayout);

        frame.add(bodyPanel);

        bodyPanel.setVisible(true);
    }

    public void addButton(String buttonName, JButton buttonField) {
        buttonField = new JButton(buttonName);

        buttonField.setBackground(LIGHT_BLUE);
        buttonField.setForeground(DARK_BLUE);
        buttonField.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonField.setHorizontalTextPosition(JButton.CENTER);
        buttonField.setVerticalTextPosition(JButton.CENTER);
        buttonField.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
        buttonField.setBorder(BorderFactory.createEtchedBorder(1));
        buttonField.setActionCommand(buttonName);
        buttonField.addActionListener(this);

        bodyPanel.add(buttonField);
    }


}
