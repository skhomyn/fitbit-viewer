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

/**
 * <code>HeartRateDeserializer</code> is an interface representing a custom
 * deserializer to parse a JSON file (i.e. with heart rate and heart zone info)
 * into Java object {@link HeartRateRecord}
 * <p>
 * Custom deserializer is necessary because this JSON file, with heart stuff,
 * contains both heart rate and heart zone data, so full control of JSON parsing
 * is required.
 * <p>
 * This interface requires the type <code>HeartRateRecord</code>, which is the
 * type of object to be parsed. The return type of deserialize is thus this very
 * type.
 * <p>
 * Implementation notes
 * <p>
 * In order to be able to parse JSON to Java, need to create instance of this
 * JsonDeserializer interface and register it with GsonBuilder.
 * <p>
 * Whenever Gson is requested to deserialize a JSON file to the
 * <code>HeartRateRecord</code> class, Gson will use this deserializer. The
 * method deserialize(), once given the necessary parameters, will then create
 * an object of type <code>HeartRateRecord</code> from the given JsonElement.
 * <p>
 * Gson will then receive an object from this deserializer.
 */
public class HeartRateRecordDeserializer implements
		JsonDeserializer<HeartRateRecord> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.google.gson.JsonDeserializer#deserialize(com.google.gson.JsonElement,
	 * java.lang.reflect.Type, com.google.gson.JsonDeserializationContext)
	 */
	@Override
	public HeartRateRecord deserialize(final JsonElement json,
			final Type typeOfT, final JsonDeserializationContext context)
			throws JsonParseException {

		// get the whole json file as an object
		final JsonObject jsonObject = json.getAsJsonObject();
		// get "activities-heart" in the json file as an array
		final JsonArray jsonHeartData = jsonObject.get("activities-heart")
				.getAsJsonArray();

		// get the information in first position in the array
		final JsonElement jsonHeart = jsonHeartData.get(0);

		// turn the first position in the array into an object
		final JsonObject jsonHeartOb = jsonHeart.getAsJsonObject();
		// get the data and time from the object
		final String dateTime = jsonHeartOb.get("dateTime").getAsString();

//		// turns value into an object
//		//final JsonObject jsonValue = jsonHeartOb.getAsJsonObject("value");

		// get heart rate zones as an array and get the size of the array
		final JsonArray jsonHeartZones = jsonHeartOb.get("heartRateZones")
				.getAsJsonArray();
		final HeartZoneRecord[] zonesArray = new HeartZoneRecord[jsonHeartZones
				.size()];

		int minuteTotal = 0;

		// loop through array getting minutes, max, min, and name from each
		// position
		for (int i = 0; i < zonesArray.length; i++) {
			final JsonElement jsonZoneElement = jsonHeartZones.get(i);
			final JsonObject jsonHeartZoneObject = jsonZoneElement
					.getAsJsonObject();

			 int minutes = jsonHeartZoneObject.get("minutes").getAsInt();
			 int max = jsonHeartZoneObject.get("max").getAsInt();
			 int min = jsonHeartZoneObject.get("min").getAsInt();
			 String name = jsonHeartZoneObject.get("name").getAsString();

			zonesArray[i] = new HeartZoneRecord(max, min, minutes, name);
			minuteTotal += zonesArray[i].getMinutes();
		}

		// get resting Heartrate as an int then create a heartrecord object with
		// all the information
		final double restingHR = jsonHeartOb.get("value").getAsDouble() ;// 0; //jsonValue.get("value").getAsInt();

		final JsonObject jsonIntraDay = jsonObject
				.getAsJsonObject("activities-heart-intraday");

		// get heart rate zones as an array and get the size of the array
		final JsonArray jsonHeartDataIntraDay = jsonIntraDay.get("dataset")
				.getAsJsonArray();

		final HeartRateInstanceRecord[] heartArray = new HeartRateInstanceRecord[jsonHeartDataIntraDay
				.size()];

		for (int i = 0; i < heartArray.length; i++) {
			final JsonElement jsonZoneElement = jsonHeartDataIntraDay.get(i);
			final JsonObject jsonHeartObject = jsonZoneElement
					.getAsJsonObject();

			String time = jsonHeartObject.get("time").getAsString();
			double value = jsonHeartObject.get("value").getAsInt();

			heartArray[i] = new HeartRateInstanceRecord(time, value);
		}

		final int datasetInterval = jsonIntraDay.get("datasetInterval")
				.getAsInt();
		final String datasetType = jsonIntraDay.get("datasetType")
				.getAsString();

		final HeartRateRecord heartRecord = new HeartRateRecord(dateTime,
				zonesArray, restingHR, minuteTotal, heartArray, datasetInterval, datasetType);

		return heartRecord;
	}
}