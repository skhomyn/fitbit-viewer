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

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

/**
 * <code>GoalsDeserializer</code> is an interface representing a custom
 * deserializer to parse a JSON file (i.e. with daily goals) into Java object
 * {@link Goals}
 * <p>
 * Custom deserializer is necessary because this is used in
 * {@link DailyRecordDeserializer}, so full control of JSON parsing is required.
 * This encapsulates the goal deserialization.
 * <p>
 * This interface requires the type <code>Goals</code>, which is the type of
 * object to be parsed. The return type of deserialize is thus this very type.
 * <p>
 * Implementation notes
 * <p>
 * In order to be able to parse JSON to Java, need to create instance of this
 * JsonDeserializer interface and register it with GsonBuilder.
 * <p>
 * Whenever Gson is requested to deserialize a JSON file to the
 * <code>Goals</code> class, Gson will use this deserializer. The method
 * deserialize(), once given the necessary parameters, will then create an
 * object of type <code>Goals</code> from the given JsonElement.
 * <p>
 * Gson will then receive an object from this deserializer.
 */
public class GoalsDeserializer implements JsonDeserializer<GoalsRecord> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.google.gson.JsonDeserializer#deserialize(com.google.gson.JsonElement,
	 * java.lang.reflect.Type, com.google.gson.JsonDeserializationContext)
	 */
	@Override
	public GoalsRecord deserialize(final JsonElement json, final Type typeOfT,
			final JsonDeserializationContext context) throws JsonParseException {
		final JsonObject jsonObject = json.getAsJsonObject();

		final GoalsRecord goal = new GoalsRecord();
		goal.setActiveMinutes(jsonObject.get("activeMinutes").getAsInt());
		goal.setCaloriesOut(jsonObject.get("caloriesOut").getAsInt());
		goal.setDistance(jsonObject.get("distance").getAsDouble());
		goal.setFloors(jsonObject.get("floors").getAsInt());
		goal.setSteps(jsonObject.get("steps").getAsInt());
		goal.setGoalMet(false);
		goal.setGoalNotMet(false);
		return goal;
	}
}
