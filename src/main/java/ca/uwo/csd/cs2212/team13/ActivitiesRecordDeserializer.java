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
 * <code>ActivitiesRecordDeserializer</code> is an interface representing a
 * custom deserializer to parse a JSON file (i.e. with best days and lifetime
 * totals) into Java object {@link ActivitiesRecord}
 * <p>
 * Custom deserializer is necessary because this JSON file, with activities,
 * contains both best days and lifetime data, so full control of JSON parsing is
 * required.
 * <p>
 * This interface requires the type <code>ActivitiesRecord</code>, which is the
 * type of object to be parsed. The return type of deserialize is thus this very
 * type.
 * <p>
 * <h4>Implementation notes</h4>
 * In order to be able to parse JSON to Java, need to create instance of this
 * JsonDeserializer interface and register it with GsonBuilder.
 * <p>
 * Whenever Gson is requested to deserialize a JSON file to the
 * <code>ActivitiesRecord</code> class, Gson will use this deserializer. The
 * method deserialize(), once given the necessary parameters, will then create
 * an object of type <code>ActivitiesRecord</code> from the given JsonElement.
 * <p>
 * Gson will then receive an object from this deserializer.
 */
public class ActivitiesRecordDeserializer implements
		JsonDeserializer<ActivitiesRecord> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.google.gson.JsonDeserializer#deserialize(com.google.gson.JsonElement,
	 * java.lang.reflect.Type, com.google.gson.JsonDeserializationContext)
	 */
	@Override
	public ActivitiesRecord deserialize(final JsonElement json,
			final Type typeOfT, final JsonDeserializationContext context)
			throws JsonParseException {

		final JsonObject jsonObject = json.getAsJsonObject();

		final String best_dis_date = jsonObject.getAsJsonObject("best")
				.getAsJsonObject("total").getAsJsonObject("distance")
				.get("date").getAsString();
		final double best_dis_value = jsonObject.getAsJsonObject("best")
				.getAsJsonObject("total").getAsJsonObject("distance")
				.get("value").getAsDouble();
		final String best_floors_date = jsonObject.getAsJsonObject("best")
				.getAsJsonObject("total").getAsJsonObject("floors").get("date")
				.getAsString();
		final int best_floors_value = jsonObject.getAsJsonObject("best")
				.getAsJsonObject("total").getAsJsonObject("floors")
				.get("value").getAsInt();
		final String best_steps_date = jsonObject.getAsJsonObject("best")
				.getAsJsonObject("total").getAsJsonObject("steps").get("date")
				.getAsString();
		final int best_steps_value = jsonObject.getAsJsonObject("best")
				.getAsJsonObject("total").getAsJsonObject("steps").get("value")
				.getAsInt();

		final int lt_aScore = jsonObject.getAsJsonObject("lifetime")
				.getAsJsonObject("total").get("activeScore").getAsInt();
		final int lt_cOut = jsonObject.getAsJsonObject("lifetime")
				.getAsJsonObject("total").get("caloriesOut").getAsInt();
		final double lt_distance = jsonObject.getAsJsonObject("lifetime")
				.getAsJsonObject("total").get("distance").getAsDouble();
		final int lt_floors = jsonObject.getAsJsonObject("lifetime")
				.getAsJsonObject("total").get("floors").getAsInt();
		final int lt_steps = jsonObject.getAsJsonObject("lifetime")
				.getAsJsonObject("total").get("steps").getAsInt();

		final LifetimeRecord lf = new LifetimeRecord(lt_aScore, lt_cOut,
				lt_distance, lt_floors, lt_steps);
		final BestDaysRecord br = new BestDaysRecord(best_dis_date,
				best_dis_value, best_floors_date, best_floors_value,
				best_steps_date, best_steps_value);
		final ActivitiesRecord actRecord = new ActivitiesRecord(br, lf);

		return actRecord;
	}
}
