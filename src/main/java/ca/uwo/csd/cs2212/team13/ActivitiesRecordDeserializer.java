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

public class ActivitiesRecordDeserializer implements JsonDeserializer<ActivitiesRecord> {

	@Override
	public ActivitiesRecord deserialize(final JsonElement json, final Type typeOfT, final JsonDeserializationContext context)
			throws JsonParseException {

		final JsonObject jsonObject = json.getAsJsonObject();
		
		final String best_dis_date = jsonObject.getAsJsonObject("best").getAsJsonObject("total").getAsJsonObject("distance").get("date").getAsString();
		final double best_dis_value = jsonObject.getAsJsonObject("best").getAsJsonObject("total").getAsJsonObject("distance").get("value").getAsDouble();
		final String best_floors_date = jsonObject.getAsJsonObject("best").getAsJsonObject("total").getAsJsonObject("floors").get("date").getAsString();
		final double best_floors_value = jsonObject.getAsJsonObject("best").getAsJsonObject("total").getAsJsonObject("floors").get("value").getAsDouble();
		final String best_steps_date = jsonObject.getAsJsonObject("best").getAsJsonObject("total").getAsJsonObject("steps").get("date").getAsString();
		final double best_steps_value = jsonObject.getAsJsonObject("best").getAsJsonObject("total").getAsJsonObject("steps").get("value").getAsDouble();

		final int lt_aScore = jsonObject.getAsJsonObject("lifetime").getAsJsonObject("total").get("activeScore").getAsInt();
		final int lt_cOut = jsonObject.getAsJsonObject("lifetime").getAsJsonObject("total").get("caloriesOut").getAsInt();
		final double lt_distance = jsonObject.getAsJsonObject("lifetime").getAsJsonObject("total").get("distance").getAsDouble();
		final int lt_floors = jsonObject.getAsJsonObject("lifetime").getAsJsonObject("total").get("floors").getAsInt();
		final int lt_steps = jsonObject.getAsJsonObject("lifetime").getAsJsonObject("total").get("steps").getAsInt();

		final LifetimeRecord lf = new LifetimeRecord(lt_aScore, lt_cOut, lt_distance, lt_floors, lt_steps);
		final BestDaysRecord br = new BestDaysRecord(best_dis_date, best_dis_value, best_floors_date, best_floors_value, best_steps_date, best_steps_value);

		final ActivitiesRecord actRecord = new ActivitiesRecord(br, lf);
		System.out.println(actRecord.toString());
		return actRecord;
	}
}