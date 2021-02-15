package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

//Tests the DailySchedule class
class DailyScheduleTest {

    private DailySchedule testSchedule;
    private String todayFormatted;


    @BeforeEach
    public void setUp() {
        Recipe recipe = new Recipe(10, 10, 10, 10, 10, 960);
        testSchedule = new DailySchedule(recipe);

        Date currentTime = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yy.MM.dd");
        todayFormatted = "" + dateFormat.format(currentTime) + "";
    }

    @Test
    //EFFECTS: tests the dailySchedule constructor
    public void constructorTest() {
        assertEquals("" + todayFormatted + " - 2", testSchedule.getFeedByIndex(0).getTime());
        assertEquals("" + todayFormatted + " - 6", testSchedule.getFeedByIndex(1).getTime());
        assertEquals("" + todayFormatted + " - 10", testSchedule.getFeedByIndex(2).getTime());
        assertEquals("" + todayFormatted + " - 14", testSchedule.getFeedByIndex(3).getTime());
        assertEquals("" + todayFormatted + " - 18", testSchedule.getFeedByIndex(4).getTime());
        assertEquals("" + todayFormatted + " - 22", testSchedule.getFeedByIndex(5).getTime());
    }

    @Test
    //EFFECTS tests that the removeFeed method properly removes Feeds from the dailySchedule
    public void removeFeedTest() {
        assertEquals("" + todayFormatted + " - 2", testSchedule.getFeedByIndex(0).getTime());

        testSchedule.removeFirstFeed();
        assertEquals("" + todayFormatted + " - 6", testSchedule.getFeedByIndex(0).getTime());

        testSchedule.removeFirstFeed();
        assertEquals("" + todayFormatted + " - 10", testSchedule.getFeedByIndex(0).getTime());
    }

    @Test
    //EFFECTS: tests getDaily Schedule
    public void getDailyScheduleTest() {
        assertEquals(6, testSchedule.getDailySchedule().size());
    }
}