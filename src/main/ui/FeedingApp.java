package ui;

import model.Recipe;
import model.RegularRecipe;

import java.util.Scanner;

//This class is largely based off the course's TellerApp ui: https://github.students.cs.ubc.ca/CPSC210/TellerApp.
// Many of the methods were taken from the TellerApp class and modified for the purpose of this app.

public class FeedingApp {

    private RegularRecipe currentRecipe;

    private Scanner input;

    //EFFECTS: Starts the Feeding App
    public FeedingApp() {
        runFeedingApp();
    }

    //Method taken from TellerApp
    // MODIFIES: this
    // EFFECTS: processes user input
    public void runFeedingApp() {
        boolean keepGoing = true;
        String command = null;

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

    public void processCommand(String command) {
        if (command.equals("l")) {
            logFeed();
        } else if (command.equals("r")) {
            viewRecipe();
        } else if (command.equals("nr")) {
            newRecipe();
        } else if (command.equals("s")) {
            estimateSupply();
        } else if (command.equals("as")) {
            addSupply();
        } else {
            System.out.println("Selection not valid...");
        }
    }

    public void init() {
        currentRecipe = new RegularRecipe(40,35,
                15,1.8, 350,960);
    }

    public void displayMenu() {
        System.out.println("\nWelcome to Santiago's Metabolic Feeding App.");
        System.out.println("\nWhat would you like to do today?");
        System.out.println("\tl -> Log a Feed");
        System.out.println("\tnr -> Create a New Recipe");
        System.out.println("\ts -> Estimate Remaining Supply of Ivalex, Pro Phree and Glycine");
        System.out.println("\ts -> Add Supply of Ivalex, Pro Phree and Glycine");
        System.out.println("\tq -> quit");
    }

    public void logFeed() {
        //TODO
    }

    public void viewRecipe() {
        //TODO
    }

    public void newRecipe() {
        //TODO
    }

    private void estimateSupply() {
        //TODO
    }

    private void addSupply() {
        //TODO
    }

    private RegularRecipe getCurrentRecipe{
        return currentRecipe;
    }
}
