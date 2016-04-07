package ca.uwo.csd.cs2212.team13;

import java.lang.reflect.Type;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

/**
 * <code>CaloriesRecordDeserializer</code> is an interface representing a custom
 * deserializer to parse a JSON file (i.e. with daily dashboard stuff and daily
 * goals) into Java object {@link DailyRecord}
 * <p>
 * Custom deserializer is necessary because this JSON file, with daily stuff,
 * contains both daily dashboard and goals data, so full control of JSON parsing
 * is required.
 * <p>
 * This interface requires the type <code>DailyRecord</code>, which is the type
 * of object to be parsed. The return type of deserialize is thus this very
 * type.
 * <p>
 * Implementation notes
 * <p>
 * In order to be able to parse JSON to Java, need to create instance of this
 * JsonDeserializer interface and register it with GsonBuilder.
 * <p>
 * Whenever Gson is requested to deserialize a JSON file to the
 * <code>DailyRecord</code> class, Gson will use this deserializer. The method
 * deserialize(), once given the necessary parameters, will then create an
 * object of type <code>DailyRecord</code> from the given JsonElement.
 * <p>
 * Gson will then receive an object from this deserializer.
 */
public class CaloriesRecordDeserializer implements JsonDeserializer<CaloriesTSRecord> {

    @Override
    public CaloriesTSRecord deserialize(final JsonElement json, final Type typeOfT, final JsonDeserializationContext contextt) throws JsonParseException {

        final JsonObject jsonObject = json.getAsJsonObject();

        final JsonArray jsonCaloriesData = jsonObject
                .get("activities-calories").getAsJsonArray();
        final JsonElement jsonCalories = jsonCaloriesData.get(0);
        final JsonObject jsonCaloriesOb = jsonCalories.getAsJsonObject();

        final String dateTime = jsonCaloriesOb.get("dateTime").getAsString();
        final double valueM = jsonCaloriesOb.get("value").getAsDouble();

        // turns value into an object
        final JsonObject jsonIntraDay = jsonObject
                .getAsJsonObject("activities-calories-intraday");

        // get heart rate zones as an array and get the size of the array
        final JsonArray jsonCaloriesDataIntraDay = jsonIntraDay.get("dataset")
                .getAsJsonArray();

        final CaloriesRecord[] caloriesArray = new CaloriesRecord[jsonCaloriesDataIntraDay
                .size()];

        for (int i = 0; i < caloriesArray.length; i++) {
            final JsonElement jsonZoneElement = jsonCaloriesDataIntraDay.get(i);
            final JsonObject jsonCaloriesObject = jsonZoneElement
                    .getAsJsonObject();

            int mets = jsonCaloriesObject.get("mets").getAsInt();
            String time = jsonCaloriesObject.get("time").getAsString();
            double value = jsonCaloriesObject.get("value").getAsDouble();

            caloriesArray[i] = new CaloriesRecord(time, value, mets);
        }

        final int datasetInterval = jsonIntraDay.get("datasetInterval")
                .getAsInt();
        final String datasetType = jsonIntraDay.get("datasetType")
                .getAsString();

        final CaloriesTSRecord ctsRecord = new CaloriesTSRecord(dateTime,
                valueM, caloriesArray, datasetInterval, datasetType);

        return ctsRecord;

    }
}
