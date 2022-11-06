package trailguide;

import org.json.simple.JSONObject;

import java.util.HashMap;

public class Event {
    HashMap<String,Object> properties;
    String choices;

    public Event(JSONObject source) {
        properties = new HashMap<String,Object>();
        properties.put("id", source.get("id").toString());
        properties.put("type", source.get("type").toString());
        properties.put("weather", source.get("weather").toString());
        properties.put("trust", Integer.parseInt(source.get("trust").toString()));
        properties.put("severity", Integer.parseInt(source.get("severity").toString()));
        
        choices = source.get("choices").toString();
    }
}
