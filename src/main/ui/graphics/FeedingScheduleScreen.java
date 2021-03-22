package ui.graphics;

import ui.FeedingApp;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class FeedingScheduleScreen extends UtilityScreen {
    JButton editScheduleButton;
    JButton createScheduleButton;
    FeedingApp feedingApp;

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

        addButton("Edit Schedule", editScheduleButton);
        addButton("Create Schedule", createScheduleButton);
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
