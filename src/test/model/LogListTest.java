package model;

import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

//Tests LogList class
public class LogListTest {

    //fields
    private DailySchedule testSchedule;
    private LogList testLogList;
    private Recipe recipe;
    private Log log1;
    private Log log2;
    private Log log3;
    private Log log4;
    private Log log5;

    @BeforeEach
    public void setUp() {
        recipe = new Recipe(10, 10, 10, 10, 10, 960);
        testSchedule = new DailySchedule(recipe);
        testLogList = new LogList();

        log1 = new Log(testSchedule.getFeedByIndex(0), 20);
        log2 = new Log(testSchedule.getFeedByIndex(1), 0);
        log3 = new Log(testSchedule.getFeedByIndex(2), 10);
        log4 = new Log(testSchedule.getFeedByIndex(3), 40);
        log5 = new Log(testSchedule.getFeedByIndex(4), 30);

        testLogList.addLog(log1);
        testLogList.addLog(log2);
        testLogList.addLog(log3);
        testLogList.addLog(log4);

    }

    @Test
    //EFFECTS: Tests addLog method
    public void addLogTest() {

        assertEquals(4, testLogList.logListSize());

        testLogList.addLog(log4);

        assertEquals(5, testLogList.logListSize());
    }

    @Test
    //EFFECTS: Tests getLogByFeed method
    public void getLogByFeedTest() {
        Date today = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yy.MM.dd");
        String todayFormatted = "" + dateFormat.format(today) + "";

        Log sixAMFeed = testLogList.getLogByFeed(todayFormatted + " - 06");
        assertEquals(log2, sixAMFeed);

        Log twoPMFeed = testLogList.getLogByFeed(todayFormatted + " - 14");
        assertEquals(log4, twoPMFeed);

        Log tenPMFeed = testLogList.getLogByFeed(todayFormatted + " - 22");
        assertNull(tenPMFeed);
    }

    @Test
    //EFFECTS: Tests getLogByIndex method
    public void getLogByIndexTest() {
        assertEquals(log2, testLogList.getLogByIndex(1));
        assertEquals(log4, testLogList.getLogByIndex(3));
    }

    @Test
    //EFFECTS: tests addAmountLeftInDay method
    public void addAmountLeftInDayTest() {
        assertEquals(70, testLogList.addAmountLeftInDay());

        testLogList.addLog(log5);

        assertEquals(100, testLogList.addAmountLeftInDay());
    }

    @Test
    //EFFECTS: Test getLogList
    public void getLogListTest() {
        ArrayList<Log> logListArray =  testLogList.getLogList();

        assertEquals(4, logListArray.size());
    }

    @Test
    //EFFECTS: Test toJson
    public void testToJson() {
        JSONObject json = testLogList.toJson();

        assertEquals(4, json.length());
        assertEquals(10, json.getJSONArray(log3.getFeed().getTime()).getInt(1));
    }
}
