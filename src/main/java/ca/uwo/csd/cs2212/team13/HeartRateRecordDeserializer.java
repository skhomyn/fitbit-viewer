package ca.uwo.csd.cs2212.team13;

import java.lang.reflect.Type;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class HeartRateRecordDeserializer implements JsonDeserializer<HeartRateRecord> {

    @Override
    public HeartRateRecord deserialize(final JsonElement json, final Type typeOfT, final JsonDeserializationContext context)
            throws JsonParseException {

        final JsonObject jsonObject = json.getAsJsonObject();
        final JsonArray jsonHeartData = jsonObject.get("activities-heart").getAsJsonArray();
        
        final JsonElement jsonHeart = jsonHeartData.get(0);
        
        final JsonObject jsonHeartOb = jsonHeart.getAsJsonObject();
        final String dateTime = jsonHeartOb.get("dateTime").getAsString();
        
        final JsonObject jsonValue = jsonHeartOb.getAsJsonObject("value");
  
        final JsonArray jsonHeartZones = jsonValue.get("heartRateZones").getAsJsonArray();
        
        final HeartZoneRecord[] zonesArray = new HeartZoneRecord[jsonHeartZones.size()];
 
        int minuteTotal = 0;
        
        for (int i = 0; i < zonesArray.length; i++) {
            final JsonElement jsonZoneElement = jsonHeartZones.get(i);
            final JsonObject jsonHeartZoneObject = jsonZoneElement.getAsJsonObject();
            
            int minutes = jsonHeartZoneObject.get("minutes").getAsInt();
            int max = jsonHeartZoneObject.get("max").getAsInt();
            int min = jsonHeartZoneObject.get("min").getAsInt();
            String name = jsonHeartZoneObject.get("name").getAsString();
 
            zonesArray[i] = new HeartZoneRecord(minutes, max, min, name);
            minuteTotal += minutes;
        }

        final int restingHR = jsonValue.get("restingHeartRate").getAsInt();

        
        final HeartRateRecord heartRecord = new HeartRateRecord(dateTime, zonesArray, restingHR, minuteTotal);
       
        return heartRecord;
    }
}