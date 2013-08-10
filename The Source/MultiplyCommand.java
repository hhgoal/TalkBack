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
public class MultiplyCommand {

    private List<String> otherWordsList;

    public MultiplyCommand(List<String> otherWordsList) {

        this.otherWordsList = otherWordsList;


    }

    public int run() {
        
        int answer;
        int firstNumber;
        int secondNumber;
        String holder = "";
        String secondHolder = "";
        //convert first word to firstNumber integer
        for (int x = 0; x < otherWordsList.get(0).length(); x++) {

            holder += otherWordsList.get(0).charAt(x);
            //System.out.println("word 0, holder = " + holder);
        }
        firstNumber = Integer.parseInt(holder);
        

        for (int y = 0; y < otherWordsList.get(2).length(); y++) {

            secondHolder += otherWordsList.get(2).charAt(y);
        }
        secondNumber = Integer.parseInt(secondHolder);

        answer = firstNumber * secondNumber;

        return answer;
    }
}
