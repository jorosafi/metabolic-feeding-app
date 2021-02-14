package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LogListTest {
    private DailySchedule testSchedule;
    private LogList testLogList;

    @BeforeEach
    public void setUp() {
        testSchedule = new DailySchedule();
        testLogList = new LogList();
    }

    @Test
    public void logFeedTest() {
        testLogList.logFeed(30);
        testLogList.logFeed(20);
        testLogList.logFeed(0);
        testLogList.logFeed(15);

        Log log1 = testLogList.getLogByIndex(0);
        Log log2 = testLogList.getLogByIndex(0);
        Log log3 = testLogList.getLogByIndex(0);
        Log log4 = testLogList.getLogByIndex(0);

        assertEquals(4, testLogList.logListSize());
        assertEquals(30, log1.getAmount());
        assertEquals(20, log2.getAmount());
        assertEquals(0, log3.getAmount());
        assertEquals(15, log4.getAmount());

        assertEquals(2, testSchedule.feedsLeftInDay());
    }
}
