/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.uwo.csd.cs2212.team13;

/**
 *
 * @author kbhaskar
 */

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

public class GoalsDeserializer implements JsonDeserializer<Goals> {

  @Override
  public Author deserialize(final JsonElement json, final Type typeOfT, final JsonDeserializationContext context)
      throws JsonParseException {
    final JsonObject jsonObject = json.getAsJsonObject();

    final Goals goal = new Goals();
    Goals.setActiveMinutes(jsonObject.get("activeMinutes").getAsInt());
    Goals.setCaloriesOut(jsonObject.get("caloriesOut").getAsInt());
    Goals.setDistance(jsonObject.get("distance").getAsDouble());
    Goals.setFloors(jsonObject.get("floors").getAsInt());
    Goals.setSteps(jsonObject.get("steps").getAsInt());
    return goal;
  }

}
