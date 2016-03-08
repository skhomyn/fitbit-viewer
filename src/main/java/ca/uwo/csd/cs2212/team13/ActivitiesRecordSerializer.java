/**
 * 
 */
package ca.uwo.csd.cs2212.team13;


import java.lang.reflect.Type;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class ActivitiesRecordSerializer implements JsonSerializer<ActivitiesRecord> {

    @Override
    public JsonElement serialize(final ActivitiesRecord ar, final Type typeOfSrc, final JsonSerializationContext context) {
        final JsonObject jsonObject = new JsonObject();
        
        final JsonObject bestObject = new JsonObject();
        final JsonObject totalObject = new JsonObject();
        
        final JsonObject distanceBestObject = new JsonObject();
        distanceBestObject.addProperty("date", ar.getBest().getDis_date());
        distanceBestObject.addProperty("value", ar.getBest().getDis_value());

        final JsonObject floorsBestObject = new JsonObject();
        floorsBestObject.addProperty("date", ar.getBest().getFloors_date());
        floorsBestObject.addProperty("value", ar.getBest().getFloors_value());
        
        final JsonObject stepsBestObject = new JsonObject();
        stepsBestObject.addProperty("steps", ar.getBest().getSteps_date());
        stepsBestObject.addProperty("value", ar.getBest().getSteps_value());
        
        totalObject.add("distance", distanceBestObject);
        totalObject.add("floors", floorsBestObject);
        totalObject.add("steps", stepsBestObject);
        
        bestObject.add("total", totalObject);
        jsonObject.add("best", bestObject);
		
        final JsonObject lifetimeObject = new JsonObject();
        final JsonObject totalLTObject = new JsonObject();
        totalLTObject.addProperty("activeScore", ar.getLifetime().getActivityScore());
        totalLTObject.addProperty("caloriesOut", ar.getLifetime().getCaloriesOut());
        totalLTObject.addProperty("distance", ar.getLifetime().getDistance());
        totalLTObject.addProperty("floors", ar.getLifetime().getFloors());
        totalLTObject.addProperty("steps", ar.getLifetime().getSteps());
        
        lifetimeObject.add("total", totalLTObject);
        jsonObject.add("lifetime", lifetimeObject);        
 
        return jsonObject;
    }
}