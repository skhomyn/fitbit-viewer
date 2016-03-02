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


public class DailyRecordDeserializer implements JsonDeserializer<DailyRecord> {

	@Override
	public DailyRecord deserialize(final JsonElement json, final Type typeOfT, final JsonDeserializationContext context)
			throws JsonParseException {

		final JsonObject jsonObject = json.getAsJsonObject();
		final JsonObject jsonSummary = jsonObject.getAsJsonObject("summary");
	
       final Goals goals = context.deserialize(jsonObject.get("goals"), Goals.class);   
       
       
		final DailyRecord dailyRecord = new DailyRecord();
		dailyRecord.setDate("March 2, 2016");//Hardcoded for now as test. Would usually get date as you API call for specific dates...
		dailyRecord.setFloors(jsonSummary.get("floors").getAsInt());
		dailyRecord.setSteps(jsonSummary.get("steps").getAsInt());
		dailyRecord.setLightlyActiveMinutes(jsonSummary.get("lightlyActiveMinutes").getAsInt());
		dailyRecord.setFairlyActiveMinutes(jsonSummary.get("fairlyActiveMinutes").getAsInt());
		dailyRecord.setSedentaryMinutes(jsonSummary.get("sedentaryMinutes").getAsInt());
		dailyRecord.setVeryActiveMinutes(jsonSummary.get("veryActiveMinutes").getAsInt());
        dailyRecord.setGoals(goals);
        dailyRecord.setCalories(jsonSummary.get("caloriesOut").getAsInt());
        
        final JsonArray jsonDistance = jsonSummary.get("distances").getAsJsonArray();
        final JsonElement distanceTotal = jsonDistance.get(0);
        final JsonObject distanceObj = distanceTotal.getAsJsonObject();
        
        dailyRecord.setDistance(distanceObj.get("distance").getAsDouble());

        System.out.println(dailyRecord.getDate());

		return dailyRecord;
	}
}