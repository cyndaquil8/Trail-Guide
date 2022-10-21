package trailguide;

import java.util.HashMap;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

import java.io.FileReader;
import java.io.IOException;

public class Translator {
    static JSONParser p = new JSONParser();

    private final static String eventpath = "src/main/java/trailguide/events.json";
    private final static String weatherpath = "src/main/java/trailguide/weathers.json";
    private static HashMap<String,JSONObject> eventdatabase;
    private static HashMap<String,JSONObject> weatherdatabase;

    static {
        eventdatabase = loadFile(eventpath);
        weatherdatabase = loadFile(weatherpath);
    }

    public static HashMap<String,Event> getEventDatabase() {
        HashMap<String,Event> result = new HashMap<String,Event>();
        for (String key : eventdatabase.keySet()) {
            result.put(key,new Event(eventdatabase.get(key)));
        }
        return result;
    }

    public static HashMap<String,Weather> getWeatherDatabase() {
        HashMap<String,Weather> result = new HashMap<String,Weather>();
        for (String key : weatherdatabase.keySet()) {
            result.put(key,new Weather(weatherdatabase.get(key)));
        }
        return result;
    }

    public static Event getEvent(String id) {
        Event e = new Event(eventdatabase.get(id));
        return e;
    }

    public static Weather getWeather(String id) {
        Weather e = new Weather(weatherdatabase.get(id));
        return e;
    }

    private static HashMap<String,JSONObject> loadFile(String filelocation) {
        HashMap<String,JSONObject> data = new HashMap<String,JSONObject>();
        try {
            JSONArray source = (JSONArray) p.parse(new FileReader(filelocation));
            for (Object obj : source) {
                JSONObject t = (JSONObject) obj;
                data.put(t.get("id").toString(), t);    
            }
            return data;
        } catch (ParseException e) {
            System.out.println("ParseException: " + e);
            return null;
        } catch (IOException e) {
            System.out.println("I/O Exception: " + e);
            return null;
        }
    }
}
