package ui.graphics;

import model.Feed;
import model.Log;
import ui.FeedingApp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;

//Creates and styles FeedingScheduleScreen for the app. Uses UtilityScreen as template
public class FeedingScheduleScreen extends UtilityScreen {
    JButton editScheduleButton;
    JButton createScheduleButton;

    ////EFFECTS: Constructs new FeedingScheduleScreen using UtilityScreen constructor
    public FeedingScheduleScreen(FeedingApp feedingApp) {
        super(feedingApp);
    }

    @Override
    //MODIFIES: this (titlePanel)
    //EFFECTS:  Changes page title
    public void setPageTitle() {
        super.setPageTitle();
        title.setText("<html><h1>Feeding Schedule</h1></html>");
    }

    @Override
    //MODIFIES: this (bodyPanel)
    //EFFECTS:  Customizes bodyPanel for FeedingScheduleScreen by adding feeding schedule and action buttons
    public void setBody() {
        super.setBody();

        String scheduleString = scheduleToString();

        infoPanel.setText(scheduleString);

        addButton("Log Feed", editScheduleButton);
        addButton("Create Schedule", createScheduleButton);
        addButton("Main Menu", mainMenu);
    }

    //EFFECTS: Returns the feeding schedule in the form of a string to be printed in the infoPanel
    public String scheduleToString() {
        ArrayList<Feed> schedule = feedingApp.getFeedingSchedule().getDailySchedule();
        String scheduleString = "<html><p>   Date   - Time - Feed Amount</p><ul>";

        for (Feed feed : schedule) {
            scheduleString = scheduleString
                    + "<li>"
                    + feed.getTime()
                    + " - "
                    + Math.round(feed.getAmount())
                    + "</li>";
        }
        scheduleString = scheduleString + "</ul></html>";
        return scheduleString;
    }

    @Override
    //EFFECTS: Handles the buttons in FeedingScheduleScreen
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        if ("Log Feed".equals(e.getActionCommand())) {
            logFeedButtonCommand();
        } else if ("Create Schedule".equals(e.getActionCommand())) {
            createScheduleButtonCommand();
        }
    }

    //MODIFIES: FeedLog, FeedingSchedule
    //EFFECTS: Runs command for logFeed button. Adds new log for FeedLog, removes Feed from Schedule,
    //          and shows confirmation to user
    private void logFeedButtonCommand() {
        addNewLog();
        frame.dispose();
        new FeedingScheduleScreen(this.feedingApp);
        JOptionPane.showMessageDialog(frame, "The feed has been logged",
                "Schedule Updated",
                JOptionPane.PLAIN_MESSAGE);
    }

    //MODIFIES: FeedingSchedule
    //EFFECTS: Runs command for Create Schedule button. Creates new schedule for the day and gives user a confirmation
    private void createScheduleButtonCommand() {
        feedingApp.createFeedingScheduleFromGUI();
        frame.dispose();
        new FeedingScheduleScreen(this.feedingApp);
        JOptionPane.showMessageDialog(frame, "A new schedule has been created for today",
                "Schedule Updated",
                JOptionPane.PLAIN_MESSAGE);
    }

    //MODIFIES: feedingApp.logList and feedingApp.feedingSchedule
    //EFFECTS: Helper method for logFeedButtonCommand() to log feed into logList using input dialog
    private void addNewLog() {
        Feed latestFeed = feedingApp.getFeedingSchedule().getFeedByIndex(0);
        String userInputAmount = JOptionPane.showInputDialog(frame, "You are logging the "
                + latestFeed.getTime() + " feed."
                + "\nWas there any milk leftover?");
        int userInputInt = parseInt(userInputAmount);
        Log log = new Log(latestFeed, userInputInt);

        feedingApp.getFeedingSchedule().removeFirstFeed();
        feedingApp.getFeedLogList().addLog(log);
    }
}
