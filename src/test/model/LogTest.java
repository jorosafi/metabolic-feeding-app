package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LogTest {
    @Test
    public void testLog() {
        Feed testFeed = new Feed("21.02.13 - 10", 160);
        Log testLog = new Log(testFeed, 30);

        assertEquals(30, testLog.getAmount());
        assertEquals(testFeed, testLog.getFeed());
    }
}
