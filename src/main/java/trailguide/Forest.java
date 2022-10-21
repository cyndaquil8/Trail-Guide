package trailguide;

import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Random;

public class Forest {
    JSONObject obj;
    private static HashMap<String,Event> events;
    private static HashMap<String,Weather> weathers;
    private static Weather currentweather;

    static {
        events = Translator.getEventDatabase();
        weathers = Translator.getWeatherDatabase();
        currentweather = Translator.getWeather("default");
    }

    public static String getCurrentWeather() {
        return currentweather.properties.get("id").toString();
    }

    //pass empty string for when you don't care about a particular property in the search
    public static Event createNewEvent() {
        return getEventByAttribute("", currentweather.properties.get("id").toString(), "", "");
    }

    private static Event getEventByAttribute(Object type, Object weather, Object trust, Object severity) {
        ArrayList<Event> list = getSetByAttribute(type, weather, trust, severity);
        return list.get(new Random().nextInt(list.size() - 1));
    }

    private static ArrayList<Event> getSetByAttribute(Object type, Object weather, Object trust, Object severity) {
        ArrayList<Event> result = new ArrayList<Event>();

        HashMap<String,Object> parameters = new HashMap<String,Object>();
        parameters.put("type",type);
        parameters.put("weather",weather);
        parameters.put("trust",trust);
        parameters.put("severity",severity);

        for (String k : events.keySet()) {
            for (Object p : parameters.keySet()) {
                if (parameters.get(p) == "" || parameters.get(p) == events.get(k).properties.get(p)) {
                    result.add(events.get(k));
                }
            }
        }

        return result;
    }
}
