package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.Set;

//Representation of feeding app data to be stored into JSON
public class Notebook implements Writable {

    private JSONObject supplyList;
    private  JSONObject recipe;
    private  JSONObject logList;
    private JSONObject feedSchedule;

    //EFFECTS: Constructs Notebook from JSONObjects
    public Notebook(JSONObject supplyList, JSONObject recipe, JSONObject schedule, JSONObject logs) {
        this.supplyList = supplyList;
        this.recipe = recipe;
        this.feedSchedule = schedule;
        this.logList = logs;
    }

    //EFFECTS: Returns notebook as a JSONObject
    public JSONObject toJson() {
        JSONObject json = new JSONObject();

        json.put("supplyList", this.supplyList);
        json.put("currentRecipe", this.recipe);
        json.put("todayFeedingSchedule", feedSchedule);
        json.put("logList", this.logList);

        return json;
    }

    //EFFECTS: Returns a new IngredientSupply from the savedSupplyList JSONObject taken from file
    public IngredientSupply getSupplyList() {
        double ivalex = this.supplyList.getDouble("ivalex");
        double proPhree = this.supplyList.getDouble("proPhree");
        double glycine = this.supplyList.getDouble("glycine");

        return new IngredientSupply(ivalex, proPhree, glycine);
    }

    //EFFECTS: Returns a new Recipe from the savedRecipe JSONObject taken from file
    public Recipe getRecipe() {
        double ivalex = this.recipe.getDouble("ivalex");
        double enfamil = this.recipe.getDouble("enfamil");
        double proPhree = this.recipe.getDouble("proPhree");
        double glycine = this.recipe.getDouble("glycine");
        double breastMilk = this.recipe.getDouble("breastMilk");
        double totalVolume = this.recipe.getDouble("totalVolume");

        return new Recipe(ivalex, enfamil, proPhree, glycine, breastMilk, totalVolume);
    }

    //EFFECTS: Returns a new DailySchedule from the savedSchedule JSONObject taken from file
    public DailySchedule getFeedSchedule() {
        return new DailySchedule(this.feedSchedule);
    }

    //EFFECTS: Returns a new LogList from the savedLogList JSONArray in file
    public LogList getLogList() {
        LogList parsedLogList = new LogList();
        Set<String> keySet = logList.keySet();

        //TODO log list returns out of order
        for (String key : keySet) {
            JSONArray amountArray = logList.getJSONArray(key);
            double feedAmount = amountArray.getDouble(0);
            int leftoverAmount = amountArray.getInt(1);

            Feed loggedFeed = new Feed(key, feedAmount);
            Log log = new Log(loggedFeed, leftoverAmount);

            parsedLogList.addLog(log);
        }

        return parsedLogList.sortLogList();
    }

}
