package ui.graphics;

import model.Log;
import model.LogList;
import ui.FeedingApp;

import java.awt.event.ActionEvent;

public class LogScreen extends UtilityScreen {

    public LogScreen(FeedingApp feedingApp) {
        super(feedingApp);
    }

    @Override
    public void setPageTitle() {
        super.setPageTitle();
        title.setText("<html><p>Feed Log</p></html>");
    }

    @Override
    public void setBody() {
        super.setBody();
        LogList logList = feedingApp.getFeedLogList();
        String logString = "<html><ul>";

        for (int i = 0; i < 6; i++) {
            if (i < logList.logListSize()) {
                Log log = logList.getLogByIndex(i);
                logString = logString + "<li>" + log.getFeed().getTime() + " - "
                        + log.getFeed().getAmount() + " - "
                        + log.getAmount() + "</li>";
            }
        }

        logString = logString + "</ul></html>";

        dashboard.setText(logString);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
    }
}
