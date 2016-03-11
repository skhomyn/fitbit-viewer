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
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * <code>DailyRecordDeserializer</code> is an interface representing a custom
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
public class DailyRecordDeserializer implements JsonDeserializer<DailyRecord> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.google.gson.JsonDeserializer#deserialize(com.google.gson.JsonElement,
	 * java.lang.reflect.Type, com.google.gson.JsonDeserializationContext)
	 */
	@Override
	public DailyRecord deserialize(final JsonElement json, final Type typeOfT,
			final JsonDeserializationContext context) throws JsonParseException {

		final JsonObject jsonObject = json.getAsJsonObject();
		final JsonObject jsonSummary = jsonObject.getAsJsonObject("summary");

		final GoalsRecord goals = context.deserialize(jsonObject.get("goals"),
				GoalsRecord.class);

		final DailyRecord dailyRecord = new DailyRecord();
		dailyRecord.setDate("March 2, 2016");// Hardcoded for now as test. Would
												// usually get date as you API
												// call for specific dates...

		dailyRecord.setFloors(jsonSummary.get("floors").getAsInt());
		dailyRecord.setSteps(jsonSummary.get("steps").getAsInt());
		dailyRecord.setLightlyActiveMinutes(jsonSummary.get(
				"lightlyActiveMinutes").getAsInt());
		dailyRecord.setFairlyActiveMinutes(jsonSummary.get(
				"fairlyActiveMinutes").getAsInt());
		dailyRecord.setSedentaryMinutes(jsonSummary.get("sedentaryMinutes")
				.getAsInt());
		dailyRecord.setVeryActiveMinutes(jsonSummary.get("veryActiveMinutes")
				.getAsInt());
		dailyRecord.setGoals(goals);
		dailyRecord.setCalories(jsonSummary.get("caloriesOut").getAsInt());

		final JsonArray jsonDistance = jsonSummary.get("distances")
				.getAsJsonArray();
		final JsonElement distanceTotal = jsonDistance.get(0);
		final JsonObject distanceObj = distanceTotal.getAsJsonObject();

		dailyRecord.setDistance(distanceObj.get("distance").getAsDouble());

		System.out.println(dailyRecord.getDate());

		return dailyRecord;
	}
}