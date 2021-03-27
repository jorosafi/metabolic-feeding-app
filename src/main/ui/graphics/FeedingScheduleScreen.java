package ui.graphics;

import model.Feed;
import model.Log;
import ui.FeedingApp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class FeedingScheduleScreen extends UtilityScreen {
    JButton editScheduleButton;
    JButton createScheduleButton;

    public FeedingScheduleScreen(FeedingApp feedingApp) {
        super(feedingApp);
    }

    @Override
    public void setPageTitle() {
        super.setPageTitle();
        title.setText("<html><p>Feeding Schedule</p></html>");
    }

    @Override
    public void setBody() {
        super.setBody();

        String scheduleString = scheduleToString();

        infoPanel.setText(scheduleString);

        addButton("Log Feed", editScheduleButton);
        addButton("Create Schedule", createScheduleButton);
    }

    public String scheduleToString() {
        ArrayList<Feed> schedule = feedingApp.getFeedingSchedule().getDailySchedule();
        String scheduleString = "<html><p>   Date   - Time - Feed Amount</p><ul>";

        for (Feed feed : schedule) {
            scheduleString = scheduleString + "<li>" + feed.getTime() + " - "
                    + Math.round(feed.getAmount()) + "</li>";

        }
        scheduleString = scheduleString + "</ul></html>";

        return scheduleString;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        if ("Log Feed".equals(e.getActionCommand())) {
            addNewLog();
            frame.dispose();
            new FeedingScheduleScreen(this.feedingApp);
            JOptionPane.showMessageDialog(frame, "The feed has been logged",
                    "Schedule Updated",
                    JOptionPane.PLAIN_MESSAGE);
        } else if ("Create Schedule".equals(e.getActionCommand())) {
            feedingApp.createFeedingScheduleFromGUI();
            frame.dispose();
            new FeedingScheduleScreen(this.feedingApp);
            JOptionPane.showMessageDialog(frame, "A new schedule has been created for today",
                    "Schedule Updated",
                    JOptionPane.PLAIN_MESSAGE);
        }
    }

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
