package voice.recognizer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;



public class runWeather {

  private static String readAll(Reader rd) throws IOException {
    StringBuilder sb = new StringBuilder();
    int cp;
    while ((cp = rd.read()) != -1) {
      sb.append((char) cp);
    }
    return sb.toString();
  }

  public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
    InputStream is = new URL(url).openStream();
    try {
      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
      String jsonText = readAll(rd);
      JSONObject json = new JSONObject(jsonText);
      return json;
    } finally {
      is.close();
    }
  }

  public String weather(List<String> locationList) throws IOException, JSONException {
    String city = locationList.get(0);
    String state = locationList.get(1);
    String url = "http://api.wunderground.com/api/53d0b1f2a98f8f3d/conditions/q/"+state+"/"+city+".json";
    JSONObject json = readJsonFromUrl(url);
    System.out.println(json.toString());
    //System.out.println(json.getDouble("temp_f"));
    
    JSONObject outer = json.getJSONObject("current_observation");  
    JSONObject weather = outer.getJSONObject("estimated");
    JSONObject place = outer.getJSONObject("display_location");
    String humidity = outer.getString("relative_humidity");
    String wind = outer.getString("wind_string");
    double tempurature = outer.getDouble("temp_f");
    String location = place.getString("full");
    System.out.println();
    
    String outStatement = "In " + location + " it is " + tempurature + " degrees with " + humidity + " humidity";
    System.out.println(outStatement);
    return outStatement;
    
  }
}