package model;

import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class DailyScheduleTest {

    @Test
    private void constructorTest() {
        DailySchedule testSchedule = new DailySchedule();

        Date currentTime = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yy.MM.dd");
        String todayFormatted = ""+dateFormat.format(currentTime)+"";

        Feed feed1 = new Feed(""+todayFormatted+" - 02", 160);
        Feed feed2 = new Feed(""+todayFormatted+" - 06", 160);
        Feed feed3 = new Feed(""+todayFormatted+" - 10", 160);
        Feed feed4 = new Feed(""+todayFormatted+" - 14", 160);
        Feed feed5 = new Feed(""+todayFormatted+" - 18", 160);
        Feed feed6 = new Feed(""+todayFormatted+" - 22", 160);

        assertEquals(feed1, testSchedule.getFeedByIndex(0));
        assertEquals(feed1, testSchedule.getFeedByIndex(1));
        assertEquals(feed1, testSchedule.getFeedByIndex(2));
        assertEquals(feed1, testSchedule.getFeedByIndex(3));
        assertEquals(feed1, testSchedule.getFeedByIndex(4));
        assertEquals(feed1, testSchedule.getFeedByIndex(5));
    }
}