/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package voice.recognizer;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PeterTsongalis
 */
public class InputParser {
    
    private String input;
    
    
    public InputParser(String input){
        
        this.input = input;
           
    }
    
    
    public String findFirstCommandWord() {
        int x = 0;
        String firstWord = "";
        
        while (input.charAt(x) != ' '){
            
            firstWord += input.charAt(x);
            x++;
            
        }
            
        return firstWord;
              
    }
    
    public List<String> getOtherWords() {
        List<String>wordsList = new ArrayList<String>();
        
        
        String firstWord = findFirstCommandWord();
        String otherWordsString = input;
        
     
        otherWordsString = otherWordsString.substring(firstWord.length() + 1);
        System.out.println("otherWordsString = " + otherWordsString);
        int y = 0;
        String holder = "";
        while (y < otherWordsString.length()) {
            
            
            if (otherWordsString.charAt(y) != ' ') {
                
                holder += otherWordsString.charAt(y);
                
               
            }
            else  {
                
              wordsList.add(holder);  
              System.out.println(holder);
              holder = "";
              
            }
            
            y++;
        }
        System.out.println(holder);
        wordsList.add(holder);
        
        
        return wordsList;   
    }
    
    
}
