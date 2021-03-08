package persistence;

import model.Notebook;
import org.json.JSONObject;

import java.io.*;
//Class largely based off JsonSerializationDemo
// (https://repo1.maven.org/maven2/org/json/json/20200518/json-20200518.jar)

public class JsonWriter {
    private static final int TAB = 4;
    private PrintWriter writer;
    private String destination;

    //EFFECTS: constructor assigns destination file to writer
    public JsonWriter(String destination) {
        this.destination = destination;
    }

    //MODIFIES: this
    //EFFECTS: opens writer. FileNotFoundException thrown if file can't be opened
    public void open() throws FileNotFoundException {
        writer = new PrintWriter(new File(destination));
    }

    //MODIFIES: this
    //EFFECTS: writes JSON representation of Notebook
    public void write(Notebook nb) {
        JSONObject json = nb.toJson();
        saveToFile(json.toString(TAB));
    }

    //MODIFIES: this
    //EFFECTS: closes writer
    public void close() {
        writer.close();
    }

    //MODIFIES: this
    //EFFECTS: writes string to file
    private void saveToFile(String json) {
        writer.print(json);
    }
}
