package persistence;

import model.*;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class JsonWriterTest {

    @Test
    public void testWriterInvalidFileName() {
        JsonWriter writer = new JsonWriter("./data/invalid|File,json");
        try {
            writer.open();
            fail("IOException expected");
        } catch (FileNotFoundException e) {
            //Catch exception
        }
    }

    @Test void testWriter() {
        JsonWriter writer = new JsonWriter("./data/writerTest.json");
        Recipe testRecipe = new Recipe(50, 50, 50, 50,500, 600);
        DailySchedule testSchedule = new DailySchedule(testRecipe);
        IngredientSupply testSupplyList = new IngredientSupply(500, 500, 500);
        LogList testLogList = new LogList();
        Log testLog = new Log(testSchedule.getFeedByIndex(0), 50);

        testLogList.addLog(testLog);

        Notebook testNotebook = new Notebook(testSupplyList.toJson(), testRecipe.toJson(),
                testSchedule.toJson(),testLogList.toJson());

        try {writer.open();
        writer.write(testNotebook);
        writer.close();

        JsonReader reader = new JsonReader("./data/writerTest.json");
        testNotebook = reader.read();

        assertEquals(50, testNotebook.getRecipe().getIvalex());
        assertEquals(100, testNotebook.getFeedSchedule().getFeedByIndex(0).getAmount());
        assertEquals(500, testNotebook.getSupplyList().getIvalex());
        assertEquals(50, testNotebook.getLogList().getLogByIndex(0).getAmount());

        } catch (IOException e) {
            fail("Unexpected IOException");
        }
    }

}
