package ca.uwo.csd.cs2212.team13;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Type;

public class DistanceRecordDederializer implements JsonDeserializer<DistanceRecord>{

    @Override
    public DistanceRecord deserialize(final JsonElement json, final Type typeOfT, final JsonDeserializationContext context) throws JsonParseException {

        final JsonObject jsonObject = json.getAsJsonObject();

        final JsonArray jsondistanceData = jsonObject.get("activities-distance").getAsJsonArray();

        final JsonElement jsonDistance = jsondistanceData.get(0);

        final JsonObject jsonDistanceOb = jsonDistance.getAsJsonObject();

        final String dateTimeMain = jsonDistanceOb.get("dateTime").getAsString();
        final String valueMain = jsonDistanceOb.get("value").getAsString();

        final JsonArray jsondistanceDataIntraday = jsonObject.get("activities-distance-intraday").getAsJsonArray();

        final DistanceRecord[] distanceArray = new DistanceRecord[jsondistanceDataIntraday.size()];

        for (int i = 0; i < distanceArray.length; i++) {
            final JsonElement jsonZoneElement = jsondistanceDataIntraday.get(i);
            final JsonObject jsonDistanceObject = jsonZoneElement.getAsJsonObject();

            distanceArray[i] = new DistanceRecord();

        }

        return null;
    }
}
