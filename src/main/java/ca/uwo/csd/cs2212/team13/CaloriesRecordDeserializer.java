package ca.uwo.csd.cs2212.team13;

import java.lang.reflect.Type;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

/**
 * Deserializer for Calories model
 * @author Andy
 *
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
