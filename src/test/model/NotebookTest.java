package model;

import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import persistence.JsonReader;
import persistence.JsonWriter;
import ui.FeedingApp;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class NotebookTest {
    private static final String JSON_PATH = "./data/testJson.json";
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private Notebook testNotebook;
    private IngredientSupply testSupplyList;
    private Recipe testRecipe;
    private DailySchedule testFeedingSchedule;
    private LogList testLogList;


    @BeforeEach
    public void setUp() {
        jsonReader = new JsonReader(JSON_PATH);
        jsonWriter = new JsonWriter(JSON_PATH);

        try {
            testNotebook = jsonReader.read();
        } catch (IOException e) {
            fail();
        }


    }

    @Test
    //EFFECTS: Test constructor by getting file information
    public void constructorTest() {
        testSupplyList = testNotebook.getSupplyList();
        testFeedingSchedule = testNotebook.getFeedSchedule();
        testLogList = testNotebook.getLogList();
        testRecipe = testNotebook.getRecipe();

        //check testSupplyList
        assertEquals(500, testSupplyList.getIvalex());
        assertEquals(1600, testSupplyList.getProPhree());
        assertEquals(200, testSupplyList.getGlycine());

        //check testFeedingSchedule
        assertEquals(160, testFeedingSchedule.getFeedByIndex(0).getAmount());
        assertEquals(160, testFeedingSchedule.getFeedByIndex(3).getAmount());

        //check testLogList
        assertEquals(10, testLogList.getLogByIndex(1).getAmount());
        assertEquals(50, testLogList.getLogByIndex(4).getAmount());

        //check testRecipe
        assertEquals(40, testRecipe.getEnfamil());
        assertEquals(940, testRecipe.getVolume());
    }

    @Test
    //EFFECTS: Test that supply list saves to Json
    public void supplyToJsonTest() {

        JSONObject json = testNotebook.toJson();

        int jsonLength = json.length();

        assertEquals(4, jsonLength);
    }

}
