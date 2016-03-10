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

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * <code>Main</code> is the class that handles up all the initial input going
 * into the interface and then runs the program.
 * <p>
 * As of the moment, there is only <code>test_run()</code> to test if the
 * {@link InterfaceView} is working properly upon receiving input.
 */
public class Main {

	
	public void run() throws IOException {

		// Configure GSON
		final GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.registerTypeAdapter(ActivitiesRecord.class,
				new ActivitiesRecordDeserializer());
		
	    gsonBuilder.registerTypeAdapter(ActivitiesRecord.class, new ActivitiesRecordSerializer());
	    
		gsonBuilder.registerTypeAdapter(DailyRecord.class,
				new DailyRecordDeserializer());
		
		gsonBuilder.registerTypeAdapter(DailyRecord.class,
				new DailyRecordSerializer());
		
		gsonBuilder.registerTypeAdapter(HeartRateRecord.class,
				new HeartRateRecordSerializer());
		
		gsonBuilder.registerTypeAdapter(HeartRateRecord.class,
				new HeartRateRecordDeserializer());
		
		gsonBuilder.setPrettyPrinting();
		final Gson gson = gsonBuilder.create();

		// Create InterfaceView and set as visible
		InterfaceView view = new InterfaceView();
		view.setVisible(view);

		// Read JSON data for heart rate
		try (Reader data = new InputStreamReader(Main.class.getClassLoader()
				.getResourceAsStream("heartrate.json"), "UTF-8")) {

			// Parse JSON to Java
			final HeartRateRecord hrRecord = gson.fromJson(data,
					HeartRateRecord.class);

			// Create controllers
			HRZController hrController = new HRZController(hrRecord, view);
			
		    // Format to JSON
		    final String json = gson.toJson(hrRecord);
		    System.out.println(json);
		}

		// Read the JSON data for daily dashboard
		try (Reader data = new InputStreamReader(Main.class.getClassLoader()
				.getResourceAsStream("cur_activities_data.json"), "UTF-8")) {

			// Parse JSON to Java
			final DailyRecord ddModel = gson.fromJson(data, DailyRecord.class);

			// Create Controller and initialize dailydashboard
			DailyDashboardController ddController = new DailyDashboardController(
					ddModel, view);
			ddController.DailyDashboardInitialize();
			
		    // Format to JSON
		  //  final String json = gson.toJson(ddModel);
		  //  System.out.println(json);
		}

		// Read the JSON data for best days and lifetime totals
		try (Reader data = new InputStreamReader(Main.class.getClassLoader()
				.getResourceAsStream("cur_totals.json"), "UTF-8")) {

			// Parse JSON to Java
			final ActivitiesRecord actRecord = gson.fromJson(data,
					ActivitiesRecord.class);

			// Create Models and Controllers
			BestDaysRecord bdModel = actRecord.getBest();
			BestDaysController bdController = new BestDaysController(bdModel,
					view);

			LifetimeRecord ltModel = actRecord.getLifetime();
			LifetimeController ltController = new LifetimeController(ltModel,
					view);
			
		    // Format to JSON
		    //final String json = gson.toJson(actRecord);
		    //System.out.println(json);
		}
	}
	
	/**
	 * Reads in test JSON files and then runs instance of {@link InterfaceView}
	 * <p>
	 * This will first create an instance of Gson through GsonBuilder. Then,
	 * using {@code registerTypeAdapter()} methods, register all deserializers
	 * to instruct Gson to use deserializers when deserializing various objects.
	 * <p>
	 * Then, GUI will be initialized.
	 * <p>
	 * Then, input is read in.with InputStreamReaders. Right now, just JSON
	 * files which are currently stored in src/main/resources.
	 * <p>
	 * Then, the following steps occur when <code>gson.from()</code> is run.
	 * <ul>
	 * <li>
	 * First, it parses the input as JsonElement. Json Element can be anything:
	 * at this stage, the string JSON object is deserialized into Java objects
	 * of type JsonElements. This also ensures that given JSON data is valid.
	 * <li>Then, it finds the deserializer for the given object. Invokes
	 * <code>deserialize()</code> which returns the desired object to the caller
	 * of the <code>fromJson()</code> method
	 * </ul>
	 * <p>
	 * Basically, Gson receives object from deserializer and returns it to its
	 * caller.
	 * <p>
	 * This object will act as the model for the MVC pattern. It, along with the
	 * InterfaceView, will then be passed to the controller.
	 * <p>
	 * 
	 * @throws IOException
	 *             if there is an IO glitch
	 */
	public void test_run() throws IOException {

		// Configure GSON
		final GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.registerTypeAdapter(ActivitiesRecord.class,
				new ActivitiesRecordDeserializer());
		
	    gsonBuilder.registerTypeAdapter(ActivitiesRecord.class, new ActivitiesRecordSerializer());
	    
		gsonBuilder.registerTypeAdapter(DailyRecord.class,
				new DailyRecordDeserializer());
		
		gsonBuilder.registerTypeAdapter(DailyRecord.class,
				new DailyRecordSerializer());
		
		gsonBuilder.registerTypeAdapter(HeartRateRecord.class,
				new HeartRateRecordSerializer());
		
		gsonBuilder.registerTypeAdapter(HeartRateRecord.class,
				new HeartRateRecordDeserializer());
		
		gsonBuilder.setPrettyPrinting();
		final Gson gson = gsonBuilder.create();

		// Create InterfaceView and set as visible
		InterfaceView view = new InterfaceView();
		view.setVisible(view);

		// Read JSON data for heart rate
		try (Reader data = new InputStreamReader(Main.class.getClassLoader()
				.getResourceAsStream("heartrate.json"), "UTF-8")) {

			// Parse JSON to Java
			final HeartRateRecord hrRecord = gson.fromJson(data,
					HeartRateRecord.class);

			// Create controllers
			HRZController hrController = new HRZController(hrRecord, view);
			
		    // Format to JSON
		    final String json = gson.toJson(hrRecord);
		    System.out.println(json);
		}

		// Read the JSON data for daily dashboard
		try (Reader data = new InputStreamReader(Main.class.getClassLoader()
				.getResourceAsStream("date.json"), "UTF-8")) {

			// Parse JSON to Java
			final DailyRecord ddModel = gson.fromJson(data, DailyRecord.class);

			// Create Controller and initialize dailydashboard
			DailyDashboardController ddController = new DailyDashboardController(
					ddModel, view);
			ddController.DailyDashboardInitialize();
			
		    // Format to JSON
		  //  final String json = gson.toJson(ddModel);
		  //  System.out.println(json);
		}

		// Read the JSON data for best days and lifetime totals
		try (Reader data = new InputStreamReader(Main.class.getClassLoader()
				.getResourceAsStream("activities.json"), "UTF-8")) {

			// Parse JSON to Java
			final ActivitiesRecord actRecord = gson.fromJson(data,
					ActivitiesRecord.class);

			// Create Models and Controllers
			BestDaysRecord bdModel = actRecord.getBest();
			BestDaysController bdController = new BestDaysController(bdModel,
					view);

			LifetimeRecord ltModel = actRecord.getLifetime();
			LifetimeController ltController = new LifetimeController(ltModel,
					view);
			
		    // Format to JSON
		    //final String json = gson.toJson(actRecord);
		    //System.out.println(json);
		}
	}
}
