/*
 * Copyright (c) 2016, Team Sharkzilla (13)
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *  * Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *
 *  * Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 *  * Neither the name of JSR-310 nor the names of its contributors
 *    may be used to endorse or promote products derived from this software
 *    without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package ca.uwo.csd.cs2212.team13;

import java.lang.reflect.Type;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

/**
 * <code>HeartRateRecordSerializer</code> is an interface representing a custom
 * serializer to transform a {@link HeartRateRecord} (i.e. with heart zone
 * records) into a JSON object for proper output
 * <p>
 * Custom serializer is necessary because <code>HeartRateRecord</code> contains
 * both best days and lifetime records, so full control of serialization is
 * required.
 * <p>
 * This interface requires the type <code>HeartRateRecord</code>, which is the
 * type of object to be serialized into a JSON object
 * <p>
 * Implementation notes
 * <p>
 * In order to be able to serialize a Java object into JSON, need to create
 * instance of this JsonSerializer interface and register it with GsonBuilder.
 * <p>
 * Whenever Gson is requested to serialize <code>ActivitiesRecord</code> class,
 * Gson will use this serializer.
 */
public class HeartRateRecordSerializer implements JsonSerializer<HeartRateRecord> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.gson.JsonSerializer#serialize(java.lang.Object,
	 * java.lang.reflect.Type, com.google.gson.JsonSerializationContext)
	 */
	@Override
	public JsonElement serialize(final HeartRateRecord hr, final Type typeOfSrc,
			final JsonSerializationContext context) {

		// This will be the eventual output
		final JsonObject jsonObject = new JsonObject();
		JsonArray activitiesArray = new JsonArray();
	
		JsonObject activitiesObject = new JsonObject();
		activitiesObject.addProperty("dateTime", hr.getDate());
		
		//Put all heartzones in a json array for eventual output
		JsonObject valueObject = new JsonObject();
	    final JsonArray jsonHZArray = new JsonArray();
	    for (final HeartZoneRecord hz : hr.getHeart_zones()) {
	 	   final JsonElement jsonHZ = context.serialize(hz);
	 	   jsonHZArray.add(jsonHZ);
	    }
	    valueObject.add("heartRateZones", jsonHZArray);
		valueObject.addProperty("restingHeartRate", hr.getRestingHR());

		activitiesObject.add("value", valueObject);
        activitiesArray.add(activitiesObject);
        jsonObject.add("activities-heart", activitiesArray);
		
		return jsonObject;
	}
}
