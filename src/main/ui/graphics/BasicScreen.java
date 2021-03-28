package ui.graphics;

import ui.FeedingApp;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

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
    protected JPanel buttonPanel = new JPanel();
    protected FeedingApp feedingApp;



    //EFFECTS: Constructor creates window that will house basic gui for app
    public BasicScreen(FeedingApp feedingApp) {

        this.feedingApp = feedingApp;

        frame = new JFrame();
        frame.setTitle("Santiago's Feeding App");
        frame.setSize(WIDTH, HEIGHT);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setConfirmBeforeClosingDialogue(feedingApp);

        //frame.setResizable(false);
        frame.setLayout(new BoxLayout(frame.getContentPane(),BoxLayout.Y_AXIS));
        frame.setBackground(DARK_BLUE);
        frame.setIconImage(new ImageIcon(logoPath).getImage());

        frame.getContentPane().setBackground(DARK_BLUE);
        frame.getContentPane().setSize(new Dimension(WIDTH, HEIGHT));

        setHeader();
        setPageTitle();
        setBody();
        frame.setVisible(true);
    }

    private void setConfirmBeforeClosingDialogue(FeedingApp feedingApp) {
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int userDialogueResponse = JOptionPane.showConfirmDialog(null,
                        "Would you like to save before quitting?",
                        "Exit",
                        JOptionPane.YES_NO_OPTION);

                System.out.println(userDialogueResponse);

                if (userDialogueResponse == 1) {
                    System.exit(0);
                } else if (userDialogueResponse == 0) {
                    feedingApp.saveNotebook();
                    JOptionPane.showMessageDialog(null,
                            "Your Notebook has been saved.");
                    System.exit(0);
                }
            }
        });
    }

    //MODIFIES: This (frame)
    //EFFECTS: Creates header panel for basic screen
    public void setHeader() {
        ImageIcon logo = new ImageIcon(logoPath);
        JLabel headerLogo = new JLabel();

        //headerPanel.setBounds(0, 0, WIDTH, 120);
        headerPanel.setPreferredSize(new Dimension(WIDTH, 110));
        headerPanel.setBackground(DARK_BLUE);
        headerPanel.setLayout(new GridLayout(1, 1, 0, 0));

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

        //titlePanel.setBounds(0, 120, WIDTH, 220);
        titlePanel.setPreferredSize(new Dimension(WIDTH, 220));
        titlePanel.setBackground(DARK_BLUE);
        titlePanel.setLayout(new GridLayout(1,1,0,0));

        title.setVerticalAlignment(JLabel.CENTER);
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setLayout(new FlowLayout());
        title.setForeground(IVORY);
        title.setText("<HTML><H1>Santiago's Metabolic Feeding App</H1>");
        title.setHorizontalTextPosition(JLabel.CENTER);
        title.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 30));

        titlePanel.add(title);
        frame.add(titlePanel);

        title.setVisible(true);
        titlePanel.setVisible(true);
    }

    public void setBody() {
//        GridLayout gridLayout = new GridLayout(5, 1, 40, 20);
//        BoxLayout boxLayout = new BoxLayout(bodyPanel, BoxLayout.Y_AXIS);

        //bodyPanel.setBounds(0, 340, WIDTH, 380);
        bodyPanel.setPreferredSize(new Dimension(WIDTH, 380));
        bodyPanel.setBackground(DARK_BLUE);
        bodyPanel.setLayout(new GridLayout(1, 1, 0, 0));

        frame.add(bodyPanel);
        bodyPanel.setVisible(true);

        buttonPanel.setBackground(DARK_BLUE);
    }

    public void addButton(String buttonName, JButton buttonField) {
        JPanel buttonContainer = new JPanel();
        buttonContainer.setPreferredSize(new Dimension(260,65));
        buttonContainer.setLayout(new GridLayout(1,1,10,10));
        buttonContainer.setBorder(new EmptyBorder(5,5,5,5));
        buttonContainer.setBackground(DARK_BLUE);

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
        buttonField.setPreferredSize(new Dimension(260,65));

        buttonContainer.add(buttonField);
        buttonPanel.add(buttonContainer);
    }

    public void addButton(String buttonName, JButton buttonField, JPanel container) {
        JPanel buttonContainer = new JPanel();
        buttonContainer.setPreferredSize(new Dimension(260,65));
        buttonContainer.setLayout(new GridLayout(1,1,10,10));
        buttonContainer.setBorder(new EmptyBorder(5,5,5,5));
        buttonContainer.setBackground(DARK_BLUE);

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
        buttonField.setPreferredSize(new Dimension(260,65));

        buttonContainer.add(buttonField);
        container.add(buttonContainer);
    }


}
