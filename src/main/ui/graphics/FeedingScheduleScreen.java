package ui.graphics;

import model.Feed;
import ui.FeedingApp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

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
        if ("Edit Schedule".equals(e.getActionCommand())) {
            System.out.println("Edit Schedule");
        } else if ("Create Schedule".equals(e.getActionCommand())) {
            System.out.println("Create Schedule");
        }
    }
}
