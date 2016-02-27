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
		
		
		
		final DailyRecord dailyRecord = new DailyRecord();
		DailyRecord.setFloors(jsonSummary.get("floors").getAsInt());
		DailyRecord.setSteps(jsonSummary.get("steps").getAsInt());
		DailyRecord.setLightlyActiveMinutes(jsonSummary.get("lightlyActiveMinutes").getAsInt());
		DailyRecord.setFairlyActiveMinutes(jsonSummary.get("fairlyActiveMinutes").getAsInt());
		DailyRecord.setSedentaryMinutes(jsonSummary.get("sedentaryActiveMinutes").getAsInt());
		DailyRecord.setVeryActiveMinutes(jsonSummary.get("veryActiveMinutes").getAsInt());
		
		return dailyRecord;
	}
}