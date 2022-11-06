package trailguide;

import org.json.simple.JSONObject;

import java.util.HashMap;

public class Weather {
    public static final String id = null;
    HashMap<String,Object> properties;
    public Weather(JSONObject source) {
        properties = new HashMap<String,Object>();
        properties.put("id", source.get("id"));
    }
}
