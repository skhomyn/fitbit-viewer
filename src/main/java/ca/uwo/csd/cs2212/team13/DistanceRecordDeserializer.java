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

public class DistanceRecordDeserializer implements
		JsonDeserializer<DistanceTSRecord> {

	@Override
	public DistanceTSRecord deserialize(final JsonElement json,
			final Type typeOfT, final JsonDeserializationContext context)
			throws JsonParseException {

		final JsonObject jsonObject = json.getAsJsonObject();

		final JsonArray jsondistanceData = jsonObject
				.get("activities-distance").getAsJsonArray();
		final JsonElement jsonDistance = jsondistanceData.get(0);
		final JsonObject jsonDistanceOb = jsonDistance.getAsJsonObject();

		final String dateTime = jsonDistanceOb.get("dateTime").getAsString();
		final double valueM = jsonDistanceOb.get("value").getAsDouble();

		// turns value into an object
		final JsonObject jsonIntraDay = jsonObject
				.getAsJsonObject("activities-distance-intraday");

		// get heart rate zones as an array and get the size of the array
		final JsonArray jsonDistanceDataIntraDay = jsonIntraDay.get("dataset")
				.getAsJsonArray();

		final DistanceRecord[] distanceArray = new DistanceRecord[jsonDistanceDataIntraDay
				.size()];

		for (int i = 0; i < distanceArray.length; i++) {
			final JsonElement jsonZoneElement = jsonDistanceDataIntraDay.get(i);
			final JsonObject jsonDistanceObject = jsonZoneElement
					.getAsJsonObject();

			String time = jsonDistanceObject.get("time").getAsString();
			double value = jsonDistanceObject.get("value").getAsInt();

			distanceArray[i] = new DistanceRecord(time, value);
		}

		final int datasetInterval = jsonIntraDay.get("datasetInterval")
				.getAsInt();
		final String datasetType = jsonIntraDay.get("datasetType")
				.getAsString();

		final DistanceTSRecord dtsRecord = new DistanceTSRecord(dateTime,
				valueM, distanceArray, datasetInterval, datasetType);
		return dtsRecord;
	}
}
