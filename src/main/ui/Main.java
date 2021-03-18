package ui;

import java.awt.*;
import java.util.Arrays;

//Runs FeedingApp
public class Main {
    public static void main(String[] args) {
        new FeedingApp();
        System.out.println(Arrays.toString(GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames()));

    }
}
