package ui;

import model.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

//This class is largely based off the course's TellerApp ui: https://github.students.cs.ubc.ca/CPSC210/TellerApp.
// Many of the methods were taken from the TellerApp class and modified for the purpose of this app.

public class FeedingApp {

    private RegularRecipe currentRecipe;
    private SickDayRecipe currentSickRecipe;
    private LogList feedLogList;
    private final String babyName = "Santiago";

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

        currentSickRecipe = new SickDayRecipe(60, 20, 30,
                2.2,250,960);


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
        System.out.print("Would you like to log the most recent feed or a previous one?");
        System.out.print("\tmr -> Most Recent");
        System.out.print("\tpo -> Previous One");

        String command = input.next();

        if (command.equals("mr")) {
            logRecentFeed();
        } else if (command.equals("po")) {
            logPreviousFeed();
        } else {
            System.out.println("Selection not valid...");
        }
    }

    public void logPreviousFeed() {
        System.out.print("How much formula did " + babyName + " leave? Type the amount in ml");

        int amount = input.nextInt();
        LocalDate date = LocalDate.now();
        FeedLog log;
        Feed feed = //TODO -- How do I find the most recent feed to add it as a parameter to the new FeedLog?;


        log = new FeedLog(date, feed, amount);



    }

    public void logRecentFeed() {
        //TODO
    }

    public void viewRecipe() {
        String command = input.next();

        System.out.print("The current regular formula recipe is: ");
        System.out.print(this.currentRecipe.viewRecipe());

        System.out.print("The current sick day formula recipe is: ");
        System.out.print(this.currentSickRecipe.viewRecipe());

        System.out.print("\tnr -> Create new recipe");
        System.out.print("\tm -> Return to main menu");
        //System.out.print("\tq -> Quit"); //TODO

        if (command.equals("nr")) {
            newRecipe();
        } else if (command.equals("m")) {
            displayMenu(); //This may throw an infinite loop.
        } else {
            System.out.println("Selection not valid...");
        }
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
