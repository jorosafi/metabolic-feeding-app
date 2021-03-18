package ui;

import model.*;
import org.json.JSONObject;
import persistence.JsonReader;
import persistence.JsonWriter;
import ui.graphics.BasicScreen;
import ui.graphics.HomeScreen;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

//Generates UI for user to view information and input commands.
//The functionality of this class is largely based off the course's TellerApp
// ui: https://github.students.cs.ubc.ca/CPSC210/TellerApp.
// Many of the methods were taken from the TellerApp class and modified for the purpose of this app.
public class FeedingApp extends JFrame {

    private static final String BABY_NAME = "Santiago";
    private static final String JSON_PATH = "./data/notebook.json";
    private Notebook notebook;
    private Recipe currentRecipe;
    private LogList feedLogList;
    private DailySchedule feedingSchedule;
    private IngredientSupply ingredientSupply;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private BasicScreen window;



    private Scanner input;

    //Method taken from TellerApp
    //EFFECTS: Starts the Feeding App
    public FeedingApp() {
        runFeedingApp();
    }

    //Method taken from TellerApp
    // MODIFIES: this
    // EFFECTS: processes user input
    public void runFeedingApp() {
        boolean keepGoing = true;
        String command;

        init();

        while (keepGoing) {
            displayMenu();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("q")) {
                keepGoing = false;
            } else {
                processCommand(command);
            }
        }

        System.out.println("\nGoodbye!");
    }

    //EFFECTS: redirects user commands to appropriate methods
    public void processCommand(String command) {
        switch (command) {
            case "ln":
                loadSavedNotebook();
                break;
            case "lf":
                logFeed();
                break;
            case "vr":
                viewRecipe();
                break;
            case "ur":
                newRecipe();
                break;
            case "es":
                estimateSupply();
                break;
            case "ai":
                addSupply();
                break;
            default:
                moreCommands(command);
                break;
        }
    }

    //EFFECTS: helper function for processCommand to run more commands
    private void moreCommands(String command) {
        switch (command) {
            case "vl":
                viewLog();
                break;
            case "vs":
                viewSchedule();
                break;
            case "lo":
                addLogAmount();
                break;
            case "sn":
                saveNotebook();
                break;
            case "cs":
                createFeedingSchedule();
                break;
            default:
                System.out.println("Selection not valid...");
                break;
        }
    }


    //MODIFIES: this
    //EFFECTS: initializes default Recipe, DailySchedule, Ingredient Supply, log list, and Scanner input
    public void init() {
        window = new HomeScreen();
        currentRecipe = new Recipe(1, 1,
                1, 1, 1, 1000);
        feedingSchedule = new DailySchedule(currentRecipe);
        ingredientSupply = new IngredientSupply(1, 1, 1);
        feedLogList = new LogList();

        input = new Scanner(System.in);

        jsonWriter = new JsonWriter(JSON_PATH);
        jsonReader = new JsonReader(JSON_PATH);
    }


    //EFFECTS: Displays main user menu
    public void displayMenu() {
        System.out.println("\nWelcome to Santiago's Metabolic Feeding App.");
        System.out.println("\nWhat would you like to do today?");
        System.out.println("\tln -> Load a saved Notebook");

        System.out.println("\n\tur -> Update Recipe");
        System.out.println("\tvr -> View Recipe");

        System.out.println("\n\tcs -> Create feeding schedule for today");
        System.out.println("\tvs -> View the feeding schedule");

        System.out.println("\n\tlf -> Log a feed");
        System.out.println("\tvl -> View the feeding log");
        System.out.println("\tlo -> View how much " + BABY_NAME + " has left today");
        //TODO change command to show only today

        System.out.println("\n\tai -> Add ingredients to the supply");
        System.out.println("\tes -> Estimate how long the ingredient supply will last");

        System.out.println("\n\tsn -> Save Notebook");
        System.out.println("\tq -> Close the App");
    }

    //EFFECTS: saves current notebook to a JSON file
    private void saveNotebook() {
        JSONObject supplyListToSave = this.ingredientSupply.toJson();
        JSONObject recipeToSave = this.currentRecipe.toJson();
        JSONObject feedingScheduleToSave = this.feedingSchedule.toJson();
        JSONObject logListToSave = this.feedLogList.toJson();

        this.notebook = new Notebook(supplyListToSave,recipeToSave, feedingScheduleToSave, logListToSave);

        try {
            jsonWriter.open();
            jsonWriter.write(notebook);
            jsonWriter.close();
            System.out.println("The Notebook has been saved");
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_PATH);
        }
    }

    //MODIFIES: this
    //EFFECTS: Loads a notebook from a saved JSON and assigns Recipe, Schedule, LogList and SupplyList from notebook
    public void loadSavedNotebook() {
        try {
            this.notebook = jsonReader.read();
            this.feedingSchedule = notebook.getFeedSchedule();
            this.feedLogList = notebook.getLogList();
            this.currentRecipe = notebook.getRecipe();
            this.ingredientSupply = notebook.getSupplyList();
            System.out.println("Your notebook has been loaded");
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_PATH);
        }
    }

    //MODIFIES: feedLogList and feedingSchedule
    //EFFECTS: Creates new log from next Feed in feedingSchedule and adds it to the feedLogList
    public void logFeed() {
        Feed latestFeed = feedingSchedule.getFeedByIndex(0);
        System.out.println("\nYou are logging the " + latestFeed.getTime() + " feed.");
        System.out.println("Did " + BABY_NAME + " leave any of his meal? please enter the amount in ml.");

        int leftOver = input.nextInt();

        Log log = new Log(latestFeed, leftOver);

        feedLogList.addLog(log);
        feedingSchedule.removeFirstFeed();

        System.out.println("\nThank you for logging a feed. Would you like to log another feed?");
        System.out.println("\tlf -> Log another feed");
        System.out.println("\tlo -> View how much " + BABY_NAME + " has left today so far");
        System.out.println("\tpress any key to return to the main menu");

        String nextCommand = input.next();

        if (nextCommand.equals("lf")) {
            logFeed();
        } else if (nextCommand.equals("lo")) {
            addLogAmount();
        }
    }

    //MODIFIES: This
    //EFFECTS: Creates new schedule for the day
    private void createFeedingSchedule() {
        this.feedingSchedule = new DailySchedule(currentRecipe);

        System.out.println("\nThis is the feeding schedule for the day:");
        viewSchedule();
    }

    //EFFECTS: prints out the feedingSchedule
    private void viewSchedule() {
        System.out.println("\n" + BABY_NAME + " has to eat at the following times today:");
        System.out.println("\t Time(24hr) - Amount(ml)");

        ArrayList<Feed> schedule = feedingSchedule.getDailySchedule();

        for (Feed f : schedule) {
            String time = f.getTime();
            double amount = Math.round(f.getAmount());
            System.out.println(time + " - " + amount);
        }

        System.out.println("\nWould you like to log a feed?");
        System.out.println("\tlf -> Log feed");
        System.out.println("\tEnter any key to return to the main menu");

        String nextCommand = input.next();

        if (nextCommand.equals("lf")) {
            logFeed();
        }
    }

    //EFFECTS: Prints out hte feedLogList
    private void viewLog() {
        System.out.println("\nThese are " + BABY_NAME + "'s latest feeds:");
        System.out.println("\t Date and Time(24hr) | Size of Feed(ml) | Amount Left(ml)");

        ArrayList<Log> log = feedLogList.getLogList();

        for (Log l : log) {
            String feedTime = l.getFeed().getTime();
            double feedAmount = l.getFeed().getAmount();
            double amountLeft = l.getAmount();
            System.out.println(feedTime + " | " + feedAmount + " | " + amountLeft);
        }

        System.out.println("\nWould you like to log a feed?");
        System.out.println("\tlf -> Log feed");
        System.out.println("\tEnter any key to return to the main menu");

        String nextCommand = input.next();

        if (nextCommand.equals("lf")) {
            logFeed();
        }
    }

    //EFFECTS: prints out the currentRecipe
    public void viewRecipe() {
        double enfamilAmount = currentRecipe.getEnfamil();
        double ivalexAmount = currentRecipe.getIvalex();
        double proPhreeAmount = currentRecipe.getProPhree();
        double glycineAmount = currentRecipe.getGlycine();
        double breastMilkAmount = currentRecipe.getBreastMilk();
        double totalVolumeAmount = currentRecipe.getVolume();

        System.out.println("I-Valex -> " + ivalexAmount + "gr");
        System.out.println("Enfamil -> " + enfamilAmount + "gr");
        System.out.println("Pro Phree -> " + proPhreeAmount + "gr");
        System.out.println("Glycine -> " + glycineAmount + "gr");
        System.out.println("Breast Milk -> " + breastMilkAmount + "ml");
        System.out.println("Fill with water to total volume of -> " + totalVolumeAmount + "ml");

        System.out.println("\nWould you like to create a new recipe or return to the main menu?");
        System.out.println("\tur -> Update Recipe");
        System.out.println("\tpress any key to return to the main menu");

        String nextCommand = input.next();

        if (nextCommand.equals("ur")) {
            newRecipe();
        }

    }

    //MODIFIES: currentRecipe, ingredientSupply
    //EFFECTS: Creates a new recipe and removes one day's worth of ingredients from ingredientSupply
    public void newRecipe() {
        System.out.println("Enter the amount for each Ingredient:");
        System.out.println("I-valex - enter amount in grams");
        double ivalexAmount = input.nextDouble();
        System.out.println("Pro Phree - enter amount in grams");
        double proPhreeAmount = input.nextDouble();
        System.out.println("Glycine - enter amount in grams");
        double glycineAmount = input.nextDouble();
        System.out.println("Enfamil - enter amount in grams");
        double enfamilAmount = input.nextDouble();
        System.out.println("Breast Milk - enter amount in ml");
        double breastMilkAmount = input.nextDouble();
        System.out.println("Add water to total volume of - enter amount in ml");
        double totalVolumeAmount = input.nextDouble();

        currentRecipe = new Recipe(ivalexAmount, enfamilAmount, proPhreeAmount,
                glycineAmount, breastMilkAmount, totalVolumeAmount);

        ingredientSupply.takeGlycine(glycineAmount);
        ingredientSupply.takeProPhree(proPhreeAmount);
        ingredientSupply.takeIvalex(ivalexAmount);

        newRecipeThankYouMenu();
    }

    //EFFECTS: Generates Thank You menu for newRecipe()
    private void newRecipeThankYouMenu() {
        System.out.println("\nThank you! Your recipe has been created");

        System.out.println("\tvr -> View your recipe");
        System.out.println("\tes -> Estimate how long the ingredient supply will last with this recipe");
        System.out.println("\tpress any key to return to the main menu");

        String nextCommand = input.next();

        if (nextCommand.equals("vr")) {
            viewRecipe();
        } else if (nextCommand.equals("es")) {
            estimateSupply();
        }
    }

    //EFFECTS: Estimates how long current supply of medical ingredients will last if using currentRecipe
    private void estimateSupply() {

        HashMap<String, Double> supplyEstimate = ingredientSupply.estimateIngredientSupply(currentRecipe);

        System.out.println("\nUnder the current recipe, this is how long your ingredients are estimated to last:");

        for (Map.Entry<String, Double> ingredients : supplyEstimate.entrySet()) {
            String ingredient = ingredients.getKey();
            long daysRemaining = Math.round(ingredients.getValue());
            System.out.println(ingredient + " -> " + daysRemaining + " days");
        }

        System.out.println("\nTo add to the ingredient supply, type 'ai'");
        System.out.println("\tpress any other key to return to the main menu");

        String nextCommand = input.next();

        if (nextCommand.equals("ai")) {
            addSupply();
        }
    }

    //MODIFIES: ingredientSupply
    //EFFECTS: Allows user to add I-valex, Pro Phree and Glycine to the ingredientSupply
    private void addSupply() {
        System.out.println("Enter the amount you would like to add for each Ingredient:");
        System.out.println("I-valex - enter amount in grams");
        double ivalexAmount = input.nextDouble();
        System.out.println("Pro Phree - enter amount in grams");
        double proPhreeAmount = input.nextDouble();
        System.out.println("Glycine - enter amount in grams");
        double glycineAmount = input.nextDouble();

        ingredientSupply.addIvalex(ivalexAmount);
        ingredientSupply.addGlycine(glycineAmount);
        ingredientSupply.addProPhree(proPhreeAmount);

        System.out.println("\nThank you! Your ingredients have been added");
        System.out.println("\tType 'es' to estimate how long the new supply will last");
        System.out.println("\tpress any other key to return to the main menu");

        String nextCommand = input.next();

        if (nextCommand.equals("es")) {
            estimateSupply();
        }
    }

    //EFFECTS: adds up the amount of food leftover in logList. Log currently only supports one day.
    private void addLogAmount() {
        int amountLeftInDay = feedLogList.addAmountLeftInDay();
        System.out.println("\n" + BABY_NAME + " has failed to drink " + amountLeftInDay + "ml so far today");
    }

}
