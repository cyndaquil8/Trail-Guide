package trailguide;

import java.util.Scanner;

public class App {
    static Scanner obj = new Scanner(System.in);
    public static void main( String[] args) {
        Printer.pr("          ");
        Printer.pr("          ");
        Printer.pr("You're lost, boys... More lost than you realize. -The Woodsman, Over the Garden Wall");
        while (true) {
            Printer.pr("          ");
            Printer.pr("------------");
            
            Event current = Forest.createNewEvent();
            
            String s = ("You are approached by " + current.properties.get("id") + ". The weather is " + current.properties.get("weather") + " or maybe " + Forest.getCurrentWeather() + ". Your choices are: " + current.choices);
            Printer.pr(s);
            Printer.pr("Would you like to venture forth?");
            obj.next();
        }
    }
}