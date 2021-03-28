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

        String logString = logToString();

        infoPanel.setText(logString);
        addButton("Main Menu", mainMenu);
    }

    private String logToString() {
        LogList logList = feedingApp.getFeedLogList();
        String logString = "<html><p>   Date   - Time - Feed Amount - Amount Left</p><ul>";

        for (int i = 0; i < 6; i++) {
            if (i < logList.logListSize()) {
                Log log = logList.getLogByIndex(logList.logListSize() - 1 - i);
                logString = logString + "<li>" + log.getFeed().getTime() + " - "
                        + Math.round(log.getFeed().getAmount()) + " - "
                        + log.getAmount() + "</li>";
            }
        }

        logString = logString + "</ul></html>";

        return  logString;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
    }
}
