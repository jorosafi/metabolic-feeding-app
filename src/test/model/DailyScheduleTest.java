package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class DailyScheduleTest {

    private DailySchedule testSchedule;
    private Recipe recipe;
    private String todayFormatted;
    private Feed feed1;
    private Feed feed2;
    private Feed feed3;
    private Feed feed4;
    private Feed feed5;
    private Feed feed6;


    @BeforeEach
    public void setUp() {
        recipe = new Recipe(10, 10, 10, 10, 10, 960);
        testSchedule = new DailySchedule(recipe);

        Date currentTime = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yy.MM.dd");
        todayFormatted = ""+dateFormat.format(currentTime)+"";

        feed1 = new Feed("" + todayFormatted + " - 2", 160);
        feed2 = new Feed("" + todayFormatted + " - 6", 160);
        feed3 = new Feed("" + todayFormatted + " - 10", 160);
        feed4 = new Feed("" + todayFormatted + " - 14", 160);
        feed5 = new Feed("" + todayFormatted + " - 18", 160);
        feed6 = new Feed("" + todayFormatted + " - 22", 160);
    }

    @Test
    public void constructorTest() {
        assertEquals("" + todayFormatted + " - 2", testSchedule.getFeedByIndex(0).getTime());
        assertEquals("" + todayFormatted + " - 6", testSchedule.getFeedByIndex(1).getTime());
        assertEquals("" + todayFormatted + " - 10", testSchedule.getFeedByIndex(2).getTime());
        assertEquals("" + todayFormatted + " - 14", testSchedule.getFeedByIndex(3).getTime());
        assertEquals("" + todayFormatted + " - 18", testSchedule.getFeedByIndex(4).getTime());
        assertEquals("" + todayFormatted + " - 22", testSchedule.getFeedByIndex(5).getTime());
    }

    @Test
    public void removeFeedTest() {
        assertEquals("" + todayFormatted + " - 2", testSchedule.getFeedByIndex(0).getTime());

        testSchedule.removeFirstFeed();
        assertEquals("" + todayFormatted + " - 6", testSchedule.getFeedByIndex(0).getTime());

        testSchedule.removeFirstFeed();
        assertEquals("" + todayFormatted + " - 10", testSchedule.getFeedByIndex(0).getTime());
    }
}