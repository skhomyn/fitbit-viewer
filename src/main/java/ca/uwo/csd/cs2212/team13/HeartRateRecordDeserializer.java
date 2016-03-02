/**
 * This class allows us to get the information about Heart Rate from the json file
 */
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
    /**
     * Constructor
     */
    public HeartRateRecord deserialize(final JsonElement json, final Type typeOfT, final JsonDeserializationContext context)
            throws JsonParseException {

        //get the whole json file as an object
        final JsonObject jsonObject = json.getAsJsonObject();
        //get "activities-heart" in the json file as an array
        final JsonArray jsonHeartData = jsonObject.get("activities-heart").getAsJsonArray();
        
        //get the information in first position in the array
        final JsonElement jsonHeart = jsonHeartData.get(0);
        
        //turn the first position in the array into an object
        final JsonObject jsonHeartOb = jsonHeart.getAsJsonObject();
        //get the data and time from the object
        final String dateTime = jsonHeartOb.get("dateTime").getAsString();
        
        //turns value into an object
        final JsonObject jsonValue = jsonHeartOb.getAsJsonObject("value");
  
        //get heart rate zones as an array and get the size of the array
        final JsonArray jsonHeartZones = jsonValue.get("heartRateZones").getAsJsonArray();
        final HeartZoneRecord[] zonesArray = new HeartZoneRecord[jsonHeartZones.size()];
 
        int minuteTotal = 0;
        
        //loop through array getting minutes, max, min, and name from each position
        for (int i = 0; i < zonesArray.length; i++) {
            final JsonElement jsonZoneElement = jsonHeartZones.get(i);
            final JsonObject jsonHeartZoneObject = jsonZoneElement.getAsJsonObject();
            
            int minutes = jsonHeartZoneObject.get("minutes").getAsInt();
            int max = jsonHeartZoneObject.get("max").getAsInt();
            int min = jsonHeartZoneObject.get("min").getAsInt();
            String name = jsonHeartZoneObject.get("name").getAsString();
 
            zonesArray[i] = new HeartZoneRecord(max, min, minutes, name);
            minuteTotal += minutes;
        }

        //get resting Heartrate as an int then create a heartrecord object with all the information
        final int restingHR = jsonValue.get("restingHeartRate").getAsInt();

        
        final HeartRateRecord heartRecord = new HeartRateRecord(dateTime, zonesArray, restingHR, minuteTotal);
       
        return heartRecord;
    }
}