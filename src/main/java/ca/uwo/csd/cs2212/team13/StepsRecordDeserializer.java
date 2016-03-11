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

public class StepsRecordDeserializer implements
		JsonDeserializer<StepsTSRecord> {

	@Override
	public StepsTSRecord deserialize(final JsonElement json,
			final Type typeOfT, final JsonDeserializationContext context)
			throws JsonParseException {

		final JsonObject jsonObject = json.getAsJsonObject();

		final JsonArray jsonstepsData = jsonObject
				.get("activities-steps").getAsJsonArray();
		final JsonElement jsonSteps = jsonstepsData.get(0);
		final JsonObject jsonStepsOb = jsonSteps.getAsJsonObject();

		final String dateTime = jsonStepsOb.get("dateTime").getAsString();
		final double valueM = jsonStepsOb.get("value").getAsDouble();

		// turns value into an object
		final JsonObject jsonIntraDay = jsonObject
				.getAsJsonObject("activities-steps-intraday");

		// get heart rate zones as an array and get the size of the array
		final JsonArray jsonStepsDataIntraDay = jsonIntraDay.get("dataset")
				.getAsJsonArray();

		final StepsRecord[] stepsArray = new StepsRecord[jsonStepsDataIntraDay
				.size()];

		for (int i = 0; i < stepsArray.length; i++) {
			final JsonElement jsonZoneElement = jsonStepsDataIntraDay.get(i);
			final JsonObject jsonStepsObject = jsonZoneElement
					.getAsJsonObject();

			String time = jsonStepsObject.get("time").getAsString();
			double value = jsonStepsObject.get("value").getAsInt();

			stepsArray[i] = new StepsRecord(time, value);
		}

		final int datasetInterval = jsonIntraDay.get("datasetInterval")
				.getAsInt();
		final String datasetType = jsonIntraDay.get("datasetType")
				.getAsString();

		final StepsTSRecord stsRecord = new StepsTSRecord(dateTime,
				valueM, stepsArray, datasetInterval, datasetType);
		return stsRecord;
	}
}
