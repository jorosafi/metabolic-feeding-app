package ui.graphics;

import model.Log;
import model.LogList;
import ui.FeedingApp;

import java.awt.event.ActionEvent;

//Creates LogScreen using UtilityScreen as template
public class LogScreen extends UtilityScreen {

    //EFFECTS: Constructor for LogScreen using UtilityScreen as template
    public LogScreen(FeedingApp feedingApp) {
        super(feedingApp);
    }

    @Override
    //MODIFIES: titlePanel
    //EFFECTS: Sets title for LogScreen
    public void setPageTitle() {
        super.setPageTitle();
        title.setText("<html><h1>Feed Log</h1></html>");
    }

    @Override
    //MODIFIES: bodyPanel
    //EFFECTS: Adds log to bodyPanel
    public void setBody() {
        super.setBody();

        String logString = logToString();

        infoPanel.setText(logString);
        addButton("Main Menu", mainMenu);
    }

    //EFFECTS: Returns the last 6 feeds in feedLog in the form of a string and adds up total leftover over the last
    //          6 feeds in format that can be added to infoPanel
    private String logToString() {
        LogList logList = feedingApp.getFeedLogList();
        String logString = "<html><p>   Date   - Time - Feed Amount - Amount Left</p><ul>";
        double sixFeedLeftover = 0;

        for (int i = 0; i < 6; i++) {
            if (i < logList.logListSize()) {
                Log log = logList.getLogByIndex(logList.logListSize() - 1 - i);
                logString = logString + "<li>" + log.getFeed().getTime() + " - "
                        + Math.round(log.getFeed().getAmount()) + " - "
                        + log.getAmount() + "</li>";
                sixFeedLeftover = sixFeedLeftover + Math.round(log.getAmount());
            }
        }

        logString = logString + "</ul><p>He has left a total of " + sixFeedLeftover
                + "ml over the past 6 feeds </p></html>";

        return logString;
    }

}
