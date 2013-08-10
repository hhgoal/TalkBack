/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package voice.recognizer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;

/**
 *
 * @author PeterTsongalis
 */
public class WeatherCommand {

    private List<String> otherWordsList;

    public WeatherCommand(List<String> otherWordsList) {

        this.otherWordsList = otherWordsList;
    }  


    public String run() throws IOException {
        List<String> cityState = new ArrayList<String>();
        System.out.println("inside of weather run");
        String city = "";
        String state = "";
        int size = otherWordsList.size();

        String x = otherWordsList.get(size - 2) + " " + otherWordsList.get(size - 1);
        
        if (switchList(x)!= "") {

            state = switchList(x);

            for (int y = 1; y < (size - 2); y++) {

                city += otherWordsList.get(y) + "_";

            }
        } else {
            state = otherWordsList.get(size - 1);

            for (int y = 1; y < (size - 1); y++) {

                city += otherWordsList.get(y) + "_";

            }

        }
        city = city.substring(0, city.length()-1);
        
        System.out.println(city);
        System.out.println(state);
        cityState.add(city);
        cityState.add(state);

        runWeather r = new runWeather();
        String weatherOutput = r.weather(cityState);



        return weatherOutput;
    }
    
    public String switchList(String state){
        String newState = "";
        switch (state) {

          case  "Alabama" :
              newState = "AL";
              break;
          case  "Alaska" : 
              newState = "AK";
              break;
          case  "Arizona" : 
              newState = "AZ";
              break;
          case  "Arkansas" : 
              newState = "AR";
              break;
          case  "California" : 
              newState ="CA";
              break;
          case  "Colorado" : 
              newState ="CO";
              break;
          case  "Connecticut" : 
              newState ="CT";
              break;
          case  "Delaware" : 
              newState ="DE";
              break;
          case  "District Of Columbia" : 
              newState ="DC";
              break;
          case  "Florida" : 
              newState ="FL";
              break;
          case  "Georgia" : 
              newState ="GA";
              break;
          case  "Hawaii" : 
              newState ="HI";
              break;
          case  "Idaho" : 
              newState ="ID";
              break;
          case  "Illinois" : 
              newState ="IL";
              break;
          case  "Indiana" : 
              newState ="IN";
              break;
          case  "Iowa" : 
              newState ="IA";
              break;
          case  "Kansas" : 
              newState ="KS";
              break;
          case  "Kentucky" : 
              newState ="KY";
              break;
          case  "Louisiana" : 
              newState ="LA";
              break;
          case  "Maine" : 
              newState ="ME";
              break;
          case  "Maryland" : 
              newState ="MD";
              break;
          case  "Massachusetts" : newState ="MA";
              break;
          case  "Michigan" : newState ="MI";
              break;
          case  "Minnesota" : newState ="MN";
              break;
          case  "Mississippi" : newState ="MS";
              break;
          case  "Missouri" : newState ="MO";
              break;
          case "Montana" : newState ="MT";
              break;
          case  "Nebraska" : newState ="NE";
              break;
          case "Nevada" : newState ="NV";
              break;
          case  "New Hampshire" : newState ="NH";
              break;
          case  "New Jersey" : newState ="NJ";
              break;
          case  "New Mexico" : newState ="NM";
              break;
          case "New York" : newState ="NY";
              break;
          case  "North Carolina" : newState ="NC";
              break;
          case  "North Dakota" : newState ="ND";
              break;
          case  "Ohio" : newState ="OH";
              break;
          case  "Oklahoma" : newState ="OK";
              break;
          case  "Oregon" : newState ="OR";
              break;
          case  "Pennsylvania" : newState ="PA";
              break;
          case  "Puerto Rico" : newState ="PR";
              break;
          case  "Rhode Island" : newState ="RI";
              break;
          case  "South Carolina" : newState ="SC";
              break;
          case  "South Dakota" : newState ="SD";
              break;
          case  "Tennessee" : newState ="TN";
              break;
          case  "Texas" : newState ="TX";
              break;
          case  "Utah" : newState ="UT";
              break;
          case  "Vermont" : newState ="VT";
              break;
          case  "Virginia" : newState ="VA";
              break;
          case  "Washington" : newState ="WA";
              break;
          case  "West Virginia" : newState ="WV";
              break;
          case  "Wisconsin" : newState ="WI";
              break;
          case  "Wyoming": newState = "WY";
              break;
                
        }
               
         return newState;
    }
    
       
}
