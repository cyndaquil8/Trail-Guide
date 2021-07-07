//utility
import java.util.*;
//files
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
//json
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


class Translator {
  //lists
  static ArrayList<Stranger> strangerdata = new ArrayList<Stranger>();
  

  static void loadStrangerInfo() {
    //object that  can translate our file
    JSONParser parser = new JSONParser();
    try {
      //jar contains all the same information as the array of strangerlist
      JSONArray jar = (JSONArray) parser.parse(new FileReader("/Users/ivymahncke/Desktop/TrailGuide/strangerlist.json"));
      //for each item in our array:
      for (Object obj : jar) {
        //p retrieves data from the array
        JSONObject p = (JSONObject)obj;
        //c stores the data as a Stranger object
        Stranger c = new Stranger();
        //retrieve and store all values
        c.name = (String) p.get("name");
        c.desc = (String) p.get("desc");
        c.depth = Integer.parseInt((String) p.get("depth"));
        c.weather = Integer.parseInt((String) p.get("weather"));
        c.depthmod = Integer.parseInt((String) p.get("depthmod"));
        c.sanitymod = Integer.parseInt((String) p.get("sanitymod"));
        //add the completed stranger to the archive
        strangerdata.add(c);
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    } catch (ParseException e) {
        e.printStackTrace();
    }
  }
}
