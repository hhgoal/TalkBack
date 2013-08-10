/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package voice.recognizer;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author PeterTsongalis
 */
public class FindCommand {

    private String firstWord;
    private List<String>otherWordsList;
    
    //initialize command classes
    private MultiplyCommand mult;
    private SubtractCommand sub;
    private WeatherCommand weather;
    private SearchCommand search;
    

    public FindCommand(String firstWord, List<String> otherWordsList) {

        this.firstWord = firstWord.toLowerCase();
        this.otherWordsList = otherWordsList;
    }

    public String executeCommandClass() throws IOException, URISyntaxException {

        String returnString = "";

        switch (firstWord) {

            case "multiply":
                initiateMultiply();
                int multAnswer = mult.run();
                System.out.println(multAnswer);
                returnString = "The answer is " + Integer.toString(multAnswer);
                mult = null;
                break;

            case "subtract":
                initiateSubtract();
                int subAnswer = sub.run();
                System.out.println(subAnswer);
                returnString = "The answer is " + Integer.toString(subAnswer);
                sub = null;
                break;
                
            case "weather":
                initiateWeather();
                System.out.println("found weather command");
                returnString = weather.run();
                weather = null;
                break;

            case "search":
                inititateSearch();
                System.out.println("search command");
                returnString = "Searching " + search.run() + " on Google";
                search = null;
                break;

            default:
                System.out.println("command not found error");
                returnString = "Sorry I could not find your command";
                break;


        }

        return returnString;
    }
    
    
    public void initiateMultiply() {
        mult = new MultiplyCommand(otherWordsList);  
    }
    
    public void initiateSubtract() {
        sub = new SubtractCommand(otherWordsList);  
    }
    
    public void initiateWeather() {
        weather = new WeatherCommand(otherWordsList);  
    }
    
    public void inititateSearch() {
        search = new SearchCommand(otherWordsList);  
    }
}
