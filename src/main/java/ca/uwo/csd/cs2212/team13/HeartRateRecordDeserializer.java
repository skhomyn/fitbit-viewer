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

public class HeartRateRecordDeserializer implements JsonDeserializer<HeartRateRecord> {

    @Override
    public HeartRateRecord deserialize(final JsonElement json, final Type typeOfT, final JsonDeserializationContext context)
            throws JsonParseException {

        final JsonObject jsonObject = json.getAsJsonObject();

        final JsonObject jsonHeart = jsonObject.getAsJsonObject("activities-heart");
        final JsonElement jsonDateTime = jsonHeart.get("dateTime");
        final JsonObject jsonValue = jsonHeart.getAsJsonObject("value");

//        final JsonArray jsonHeartZone = jsonObject.get("heartRateZones").getAsJsonArray();
//        final HeartZoneRecord[] zonesArray = new HeartZoneRecord[jsonHeartZone.size()];
//        for (int i = 0; i < zonesArray.length; i++) {
//            final JsonObject jsonZoneObject = jsonHeartZone.getAsJsonObject(i);
//        }

        final HeartRateRecord heartRecord = new HeartRateRecord();
        heartRecord.setDate(jsonDateTime.getAsString());

        return heartRecord;
    }
}