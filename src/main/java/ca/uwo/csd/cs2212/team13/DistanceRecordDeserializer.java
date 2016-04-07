package ca.uwo.csd.cs2212.team13;

/**
 * <code>DistanceRecordDeserializer</code> is an interface representing a
 * custom deserializer to parse a JSON file into Java object {@link DistanceTSRecord}
 * <p>
 * Custom deserializer is necessary because this JSON file, with activities,
 * contains data, so full control of JSON parsing is required.
 * <p>
 * This interface requires the type <code>DistanceTSRecord</code>, which is the
 * type of object to be parsed. The return type of deserialize is thus this very
 * type.
 * <p>
 * Implementation notes
 * <p>
 * In order to be able to parse JSON to Java, need to create instance of this
 * JsonDeserializer interface and register it with GsonBuilder.
 * <p>
 * Whenever Gson is requested to deserialize a JSON file to the
 * <code>DistanceTSRecord</code> class, Gson will use this deserializer. The
 * method deserialize(), once given the necessary parameters, will then create
 * an object of type <code>DistanceTSRecord</code> from the given JsonElement.
 * <p>
 * Gson will then receive an object from this deserializer.
 */



/**
 * This class is our deserializer
 * for the Distance model
 */
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
			double value;
			try {
				value = jsonDistanceObject.get("value").getAsDouble();
			} catch (Exception e) {
				value = jsonDistanceObject.get("value").getAsInt();
			}

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
