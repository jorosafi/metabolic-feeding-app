package persistence;

import model.Notebook;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonReaderTest {
    @Test
    //Checking that IOException is caught
    public void testInvalidFilePath() {
        JsonReader reader = new JsonReader("./data/nofile.json");
        try {
            Notebook nb = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            //exception caught
        }
    }

    @Test
    //Checking that Notebook reads properly
    public void testReadingFile() {
        JsonReader reader = new JsonReader("./data/testJson.json");

        try {
            Notebook testNotebook = reader.read();
            double firstFeedAmount = testNotebook.getFeedSchedule().getFeedByIndex(0).getAmount();
            double ivalexFromRecipe = testNotebook.getRecipe().getIvalex();
            double glycineFromSupply = testNotebook.getSupplyList().getGlycine();
            int leftOverFromLogList = testNotebook.getLogList().getLogByIndex(0).getAmount();

            assertEquals(160, firstFeedAmount);
            assertEquals(40, ivalexFromRecipe);
            assertEquals(200, glycineFromSupply);
            assertEquals(40, leftOverFromLogList);
        } catch (IOException e) {
            fail("could not read from file");
        }

    }

}
