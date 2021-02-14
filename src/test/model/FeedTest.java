package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FeedTest {

    @Test
    public void constructorTest() {
        Feed testFeed1 = new Feed("21.01.13 - 2", 160);
        Feed testFeed2 = new Feed("21.01.13 - 8", 180);

        assertEquals("21.01.13 - 2", testFeed1.getTime());
        assertEquals(160, testFeed1.getAmount());

        assertEquals("21.01.13 - 8", testFeed2.getTime());
        assertEquals(180, testFeed2.getAmount());

    }
}
