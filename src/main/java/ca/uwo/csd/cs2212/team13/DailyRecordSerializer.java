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
 * <code>DailyRecordSerializer</code> is an interface representing a custom
 * serializer to transform a {@link DailyRecord} into a JSON object for proper
 * output
 * <p>
 * Custom serializer is necessary because <code>DailyRecord</code> uses really
 * odd variable names, so full control of serialization is required.
 * <p>
 * This interface requires the type <code>DailyRecord</code>, which is the type
 * of object to be serialized into a JSON object
 * <p>
 * Implementation notes
 * <p>
 * In order to be able to serialize a Java object into JSON, need to create
 * instance of this JsonSerializer interface and register it with GsonBuilder.
 * <p>
 * Whenever Gson is requested to serialize <code>ActivitiesRecord</code> class,
 * Gson will use this serializer.
 */
public class DailyRecordSerializer implements JsonSerializer<DailyRecord> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.gson.JsonSerializer#serialize(java.lang.Object,
	 * java.lang.reflect.Type, com.google.gson.JsonSerializationContext)
	 */
	@Override
	public JsonElement serialize(final DailyRecord dr, final Type typeOfSrc,
			final JsonSerializationContext context) {

		// This will be the eventual output
		final JsonObject jsonObject = new JsonObject();

		//Get goals stuff and put in jsonObject
	    final JsonElement jsonGoals = context.serialize(dr.getGoals());
	    jsonObject.add("goals", jsonGoals);
		
		//Get the summary stuff and then put in jsonObject
		JsonObject summaryObject = new JsonObject();
		summaryObject.addProperty("caloriesOut", dr.getCalories());
		
        final JsonArray jsonDistanceArray = new JsonArray();
        final JsonObject distanceObject = new JsonObject();
        distanceObject.addProperty("distance", dr.getDistance());
        jsonDistanceArray.add(distanceObject);

        summaryObject.add("distances", jsonDistanceArray);
        
		summaryObject.addProperty("floors", dr.getFloors());
		summaryObject.addProperty("sedentaryMinutes", dr.getSedentaryMinutes());
		summaryObject.addProperty("steps", dr.getSteps());
		summaryObject.addProperty("veryActiveMinutes", dr.getVeryActiveMinutes());
		
		summaryObject.addProperty("date", dr.getDate()); //Still thinking if this is necessary. Probably.

        jsonObject.add("summary", summaryObject);
		
		return jsonObject;
	}

}
