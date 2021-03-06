package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.lang.reflect.Array;
import java.util.Set;

//Representation of feeding app data to be stored into JSON
public class Notebook implements Writable {

    private JSONObject savedSupplyList;
    private  JSONObject savedRecipe;
    private  JSONObject savedLogList;
    private JSONObject savedSchedule;

    //EFFECTS: Constructs Notebook from scratch
    public Notebook(){
        //TODO think about what is needed for this constructor that will be used to save
    }

    //EFFECTS: Constructs Notebook from JSONObjects
    public Notebook(JSONObject supplyList, JSONObject recipe, JSONObject schedule, JSONObject logs) {
        this.savedSupplyList = supplyList;
        this.savedRecipe = recipe;
        this.savedSchedule = schedule;
        this.savedLogList = logs;
    }

    //EFFECTS: Returns notebook as a JSONObject
    public JSONObject toJson() {
        //TODO - stub for toJson
        return null;
    }

    //EFFECTS: Returns a new IngredientSupply from the savedSupplyList JSONObject taken from file
    public IngredientSupply getSavedSupplyList() {
        double ivalex = this.savedSupplyList.getDouble("ivalex");
        double proPhree = this.savedSupplyList.getDouble("proPhree");
        double glycine = this.savedSupplyList.getDouble("glycine");

        return new IngredientSupply(ivalex, proPhree, glycine);
    }

    //EFFECTS: Returns a new Recipe from the savedRecipe JSONObject taken from file
    public Recipe getSavedRecipe() {
        double ivalex = this.savedRecipe.getDouble("ivalex");
        double enfamil = this.savedRecipe.getDouble("enfamil");
        double proPhree = this.savedRecipe.getDouble("proPhree");
        double glycine = this.savedRecipe.getDouble("glycine");
        double breastMilk = this.savedRecipe.getDouble("breastMilk");
        double totalVolume = this.savedRecipe.getDouble("totalVolume");

        return new Recipe(ivalex, enfamil, proPhree, glycine, breastMilk, totalVolume);
    }

    //EFFECTS: Returns a new DailySchedule from the savedSchedule JSONObject taken from file
    public DailySchedule getSavedSchedule() {
        return new DailySchedule(this.savedSchedule);
    }

    //EFFECTS: Returns a new LogList from the savedLogList JSONArray in file
    public LogList getSavedLogList() {
        LogList parsedLogList = new LogList();
        Set<String> keySet = savedLogList.keySet();

        //TODO log list returns out of order
        for (String key : keySet) {
            JSONArray amountArray = savedLogList.getJSONArray(key);
            double feedAmount = amountArray.getDouble(0);
            int leftoverAmount = amountArray.getInt(1);

            Feed loggedFeed = new Feed(key, feedAmount);
            Log log = new Log(loggedFeed, leftoverAmount);

            parsedLogList.addLog(log);
        }

        return parsedLogList;
    }

}
