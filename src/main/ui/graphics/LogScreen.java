package ui.graphics;

import ui.FeedingApp;

import java.awt.event.ActionEvent;

public class LogScreen extends UtilityScreen {
    FeedingApp feedingApp;

    public LogScreen(FeedingApp feedingApp) {
        super(feedingApp);
    }

    @Override
    public void setPageTitle() {
        super.setPageTitle();
        title.setText("<html><p>Feed Log</p></html>");
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
    }
}
