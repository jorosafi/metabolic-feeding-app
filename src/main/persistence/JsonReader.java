package persistence;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import model.Notebook;
import org.json.*;

//Reader that reads saved feeding schedule data stored in JSON file
public class JsonReader {
    private String source;

    //EFFECTS: constructs reader from source file
    public JsonReader(String source) {
        this.source = source;
    }

    //EFFECTS: read notebook from file and return it, throw IOException if error occurs when reading data from file
    public Notebook read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseNotebook(jsonObject);
    }

    //EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    //EFFECTS: Parses Notebook from JSON object and returns it
    private Notebook parseNotebook(JSONObject jsonObject) {
        JSONObject supplyList = jsonObject.getJSONObject("supplyList");
        JSONObject currentRecipe = jsonObject.getJSONObject("currentRecipe");
        JSONObject todayFeedingSchedule = jsonObject.getJSONObject("todayFeedingSchedule");
        JSONObject logList = jsonObject.getJSONObject("logList");

        return new Notebook(supplyList, currentRecipe, todayFeedingSchedule, logList);
    }
}
