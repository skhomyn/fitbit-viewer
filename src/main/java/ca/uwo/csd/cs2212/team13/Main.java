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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * <code>Main</code> is the class that handles up all the initial input going
 * into the interface and then runs the program.
 * <p>
 * As of the moment, there is only <code>test_run()</code> to test if the
 * {@link InterfaceView} is working properly upon receiving input.
 */
public class Main {
	
	private ActivitiesRecord actRecord;
	private DailyRecord ddModel;
	
	private DailyDashboardController ddController;
	private GoalsController dgController;
	private AccoladeController acController;
	private TimeSeriesController tsController;
	private HRZController hrController;
	private LifetimeController ltController;
	private BestDaysController bdController;
	
	private InterfaceView view;

	public void run() throws IOException {

		// Configure GSON
		final GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.registerTypeAdapter(ActivitiesRecord.class,
				new ActivitiesRecordDeserializer());

		gsonBuilder.registerTypeAdapter(ActivitiesRecord.class,
				new ActivitiesRecordSerializer());

		gsonBuilder.registerTypeAdapter(DailyRecord.class,
				new DailyRecordDeserializer());

		gsonBuilder.registerTypeAdapter(DailyRecord.class,
				new DailyRecordSerializer());

		gsonBuilder.registerTypeAdapter(HeartRateRecord.class,
				new HeartRateRecordSerializer());

		gsonBuilder.registerTypeAdapter(HeartRateRecord.class,
				new HeartRateRecordDeserializer());

		gsonBuilder.registerTypeAdapter(GoalsRecord.class,
				new GoalsDeserializer());

		gsonBuilder.setPrettyPrinting();
		final Gson gson = gsonBuilder.create();

		// Create InterfaceView and set as visible
		view = new InterfaceView();
		view.setVisible(view);

		final WriterReader wr = new WriterReader();
		final APICaller apiCaller = new APICaller("activity%20heartrate",
				"src/main/resources/Team13Tokens.txt",
				"src/main/resources/Team13Credentials.txt");

		// test.request("activities/heart/date/today/1d.json",
		// "src/main/resources/cur_heart_data.json");
		// test.request("activities/date/today.json",
		// "src/main/resources/cur_activities_data.json");
		// test.request("activities.json",
		// "src/main/resources/cur_totals.json");

		// Read JSON data for heart rate
		try (Reader data = new InputStreamReader(Main.class.getClassLoader()
				.getResourceAsStream("cur_heart_data.json"), "UTF-8")) {

			// Parse JSON to Java
			final HeartRateRecord hrRecord = gson.fromJson(data,
					HeartRateRecord.class);

			// Create controllers
			hrController = new HRZController(hrRecord, view);

			// Format to JSON
			// final String json = gson.toJson(hrRecord);
			// System.out.println(json);
			// System.out.println(hrRecord);
		//	final String json = gson.toJson(hrRecord);
		//	System.out.println(json);
		}

		// Read the JSON data for daily dashboard and daily goals

		refreshInfo(gson, apiCaller, wr, "today");

		// Create Controller for daily goals
		ddController = new DailyDashboardController(ddModel, view);

		// Create Controller for daily goals
		dgController = new GoalsController(ddModel, ddModel.getGoals(), view);

		// initialize dashboard on start up of application
		ddController.dailyDashboardInitialize();
	
		// Create Models and Controllers
		BestDaysRecord bdModel = actRecord.getBest();
		bdController = new BestDaysController(bdModel, view);

		LifetimeRecord ltModel = actRecord.getLifetime();
		ltController = new LifetimeController(ltModel, view);
				
		//add action listener to refresh button, trigger new API calls for current date
		/**
		 * {@code ActionListener} object is added to the refresh button. When the refresh
		 * button is clicked, it triggers new API calls using the current date.
		 */
		view.addListenerForRefreshDash(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				refreshInfo(gson, apiCaller, wr, "today");
			}	
		});

		/**
		 * {@code ActionListener} object is added to calendar and triggers new API calls
		 * for the date selected, when the user chooses a new date on the calendar interface.
		 * Does not allow future dates to be selected.
		 */
		view.addCalendarDateChangeActions(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!view.checkConstraints(view.getCalendarObject())) {
					System.out.println("\n NOOOOOO - message from view.addCalendarDageChangeAction in Main "); //attempt to change date to future date

				}
				else
				{
					refreshInfo(gson, apiCaller, wr, view.getStringDate(null));
					System.out.println("\n CALENDAR date change:" + view.getStringDate(null)); //TESTFLAG
				}
		
			}
		});
		
		/**
		 * {@code ActionListener} object is added to the "previous" button and triggers new API calls
		 * for a date one day in the past of the currently displayed date, when the button is clicked.
		 * The {@link InterfaceView#addPreviousDayActions }method implementation also updates the date 
		 * displayed on the calendar.
		 */
		view.addPreviousDayActions(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (!view.checkConstraints(view.getCalendarObject())) {
					System.out.println("\naddPreviousDayActions in Main "); //attempt to change date to future date
				}
				else
				{
					if(view.checkConstraintsLower(view.getCalendarObject()))
					{
						System.out.println("Cannot API Call Past Three Years.\n");
					}
					else
					{
						refreshInfo(gson, apiCaller, wr, view.getStringDate("previous"));
						System.out.println("\n PREV DAY date change:" + view.getStringDate("previous"));
					}
				}
			}
		});
		
		/**
		 * {@code ActionListener} object is added to "next" button and triggers new API calls
		 * for a date one day in advance of the currently displayed date, when the button is clicked.
		 * The {@link InterfaceView#addNextDayActions} method implementation also updates the date 
		 * displayed on the calendar.
		 * Does not allow future dates to be selected.
		 */
		view.addNextDayActions(new ActionListener() {		
				@Override
				public void actionPerformed(ActionEvent e) {

					if (!view.checkConstraints(view.getCalendarObject())) {
						System.out.println("\naddNextDayActions in Main "); //attempt to change date to future date
					}
					else
					{
						if(view.checkConstraintsUpper(view.getCalendarObject()))
						{
							System.out.println("Cannot API Call Future Dates.\n");
						}
						else
						{
							refreshInfo(gson, apiCaller, wr, view.getStringDate("next"));
							System.out.println("\n NEXT DAY date change:" + view.getStringDate("next")); //TESTFLAG
						}
					}
				}
	});

	}
	
	//TESTFLAG
	//given: 23-Mar-2016
	//GET https://api.fitbitcom/1/user/[user-id]/activities/date/yyyy-MM-dd.json
	//TESTFLAG
	//note to self: limit access to >3 years ago
	
	public void refreshInfo(Gson gson, APICaller apiCaller, WriterReader wr, String dateStr){
		
		//make request for dashboard info
		String dRecord_String = apiCaller.requestJson("activities/date/" + dateStr + ".json");
		// If Null
		if (dRecord_String == null) {
			try {
				System.out.println("Reading in DailyRecord from File\n");
				ddModel = (DailyRecord) wr
						.loadRecord("src/main/resources/dailyrecord");
			} catch (Exception e) {
				System.out.println("Could not read DailyRecord from File");
			}
		} else {
			// Parse JSON to Java
			ddModel = gson.fromJson(dRecord_String, DailyRecord.class);
			//update view with new models
			ddController = new DailyDashboardController(ddModel, view);
			ddController.dailyDashboardInitialize();
			dgController = new GoalsController(ddModel, ddModel.getGoals(), view);
			dgController.goalsInitialize();
			
			//Last Updated label
			Date now = new Date();
			String apiCallDate = now.toString();
			view.setLastUpdatedDash(apiCallDate);
			view.setLastUpdatedGoals(apiCallDate);
		}
		try {
			wr.writeRecord(ddModel, "dailyrecord");
		} catch (Exception e) {
			System.out.println("Could not write to file");
		}

		// Read the JSON data for best days and lifetime totals
		String aRecord_String = apiCaller.requestJson("activities.json");

		// If Null
		if (aRecord_String == null) {
			try {
				System.out.println("Reading in ActivitiesRecord from File\n");
				actRecord = (ActivitiesRecord) wr
						.loadRecord("src/main/resources/activityrecord");
			} catch (Exception e) {
				System.out.println("Could not read ActivitiesRecord from File");
			}
		} else {
			// Parse JSON to Java
			actRecord = gson.fromJson(aRecord_String, ActivitiesRecord.class);
			//update view with new models
			ltController = new LifetimeController(actRecord.getLifetime(), view);
			ltController.lifetimeTotalsInitialize();
			bdController = new BestDaysController(actRecord.getBest(), view);
			bdController.bestDaysInitialize();
			
			//Last Updated label
			Date now = new Date();
			String apiCallDate = now.toString();
			view.setLastUpdatedBd(apiCallDate);
			view.setLastUpdatedLt(apiCallDate);
		}
		try {
			wr.writeRecord(actRecord, "activityrecord");
		} catch (Exception e) {
			System.out.println("Could not write to file");
		}

		// Format to JSON
		// final String json = gson.toJson(actRecord);
		// System.out.println(json);
		// }

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

		gsonBuilder.registerTypeAdapter(ActivitiesRecord.class,
				new ActivitiesRecordSerializer());

		gsonBuilder.registerTypeAdapter(DailyRecord.class,
				new DailyRecordDeserializer());

		gsonBuilder.registerTypeAdapter(DailyRecord.class,
				new DailyRecordSerializer());

		gsonBuilder.registerTypeAdapter(HeartRateRecord.class,
				new HeartRateRecordSerializer());

		gsonBuilder.registerTypeAdapter(HeartRateRecord.class,
				new HeartRateRecordDeserializer());

		gsonBuilder.registerTypeAdapter(GoalsRecord.class,
				new GoalsDeserializer());

		gsonBuilder.registerTypeAdapter(CaloriesTSRecord.class,
				new CaloriesRecordDeserializer());

		gsonBuilder.registerTypeAdapter(DistanceTSRecord.class,
				new DistanceRecordDeserializer());

		gsonBuilder.registerTypeAdapter(StepsTSRecord.class,
				new StepsRecordDeserializer());

		gsonBuilder.setPrettyPrinting();
		final Gson gson = gsonBuilder.create();

		// Create InterfaceView and set as visible
		final InterfaceView view = new InterfaceView();
		view.setVisible(view);

		// Read JSON data for heart rate
		try (Reader data = new InputStreamReader(Main.class.getClassLoader()
				.getResourceAsStream("cur_heart_data.json"), "UTF-8")) {

			// Parse JSON to Java
			final HeartRateRecord hrRecord = gson.fromJson(data,
					HeartRateRecord.class);

			// Create controllers
			hrController = new HRZController(hrRecord, view);

			// Format to JSON
			// final String json = gson.toJson(hrRecord);
			// System.out.println(json);
			// System.out.println(hrRecord);
		//	final String json = gson.toJson(hrRecord);
		//	System.out.println(json);
		}

		// Read the JSON data for daily dashboard
		try (Reader data = new InputStreamReader(Main.class.getClassLoader()
				.getResourceAsStream("date.json"), "UTF-8")) {

			// Parse JSON to Java
			final DailyRecord ddModel = gson.fromJson(data, DailyRecord.class);

			// Create Controller for daily goals
			ddController = new DailyDashboardController(
					ddModel, view);

			// Create Controller for daily goals
			dgController = new GoalsController(ddModel,
					ddModel.getGoals(), view);

			// initialize dashboard
			ddController.dailyDashboardInitialize();
			
			// Format to JSON
			// final String json = gson.toJson(ddModel);
			// System.out.println(json);
		}

		// Read the JSON data for best days and lifetime totals
		try (Reader data = new InputStreamReader(Main.class.getClassLoader()
				.getResourceAsStream("activities.json"), "UTF-8")) {

			// Parse JSON to Java
			final ActivitiesRecord actRecord = gson.fromJson(data,
					ActivitiesRecord.class);

			// Create Models and Controllers
			BestDaysRecord bdModel = actRecord.getBest();
			bdController = new BestDaysController(bdModel,
					view);

			LifetimeRecord ltModel = actRecord.getLifetime();
			ltController = new LifetimeController(ltModel,
					view);

			// Format to JSON
			// final String json = gson.toJson(actRecord);
			// System.out.println(json);

			WriterReader wr = new WriterReader();

			AccoladeRecord[] ar = new AccoladeRecord[20];
			ar = null;

			try {
				ar = (AccoladeRecord[]) wr
						.loadRecord("src/main/resources/accoladerecords");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// Read the JSON data for daily dashboard
			try (Reader data2 = new InputStreamReader(Main.class
					.getClassLoader().getResourceAsStream("date.json"), "UTF-8")) {

				// Parse JSON to Java
				final DailyRecord ddModel = gson.fromJson(data2,
						DailyRecord.class);

				// Read JSON data for heart rate
				try (Reader data3 = new InputStreamReader(Main.class.getClassLoader()
						.getResourceAsStream("cur_heart_data.json"), "UTF-8")) {

					// Parse JSON to Java
					final HeartRateRecord hrRecord = gson.fromJson(data3,
							HeartRateRecord.class);

					
				acController = new AccoladeController(ar,
						actRecord, ddModel, hrRecord, view);
				}
			}

		}

		// Read the JSON data for best days and lifetime totals
		try (Reader data = new InputStreamReader(Main.class.getClassLoader()
				.getResourceAsStream("distance.json"), "UTF-8")) {
			try (Reader data2 = new InputStreamReader(Main.class
					.getClassLoader().getResourceAsStream("steps.json"),
					"UTF-8")) {
				try (Reader data3 = new InputStreamReader(Main.class
						.getClassLoader().getResourceAsStream("calories.json"),
						"UTF-8")) {
					// Read JSON data for heart rate
					try (Reader data4 = new InputStreamReader(Main.class
							.getClassLoader().getResourceAsStream(
									"cur_heart_data.json"), "UTF-8")) {

						// Parse JSON to Java
						final HeartRateRecord hrRecord = gson.fromJson(data4,
								HeartRateRecord.class);

						// Parse JSON to Java
						final DistanceTSRecord dtsRecord = gson.fromJson(data,
								DistanceTSRecord.class);

						// Parse JSON to Java
						final StepsTSRecord stsRecord = gson.fromJson(data2,
								StepsTSRecord.class);

						// Parse JSON to Java
						final CaloriesTSRecord caRecord = gson.fromJson(data3,
								CaloriesTSRecord.class);

						// Create Controller for time series
						tsController = new TimeSeriesController(
								dtsRecord, stsRecord, caRecord, hrRecord, view);
					}
				}
			}
		}
		
		//set initial value of date labels on date-dependent pages to today
		view.setDisplayDate(new Date());
		
		//TESTFLAG
		//DELETE LATER
		view.addCalendarDateChangeActions(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				//do nothing				
			}});
			
		
		
		/**
		 * {@code ActionListener} object is added to the refresh button. When the refresh
		 * button is clicked, it triggers new API calls using the current date.
		 */
		view.addListenerForRefreshDash(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				String test = "Refresh unavailable in test mode.";
				view.setLastUpdatedTestMode(test);
			}	
		});

		/**
		 * The {@link InterfaceView#addPreviousDayActions} method implementation updates the date 
		 * displayed on the calendar.
		 */
		view.addPreviousDayActions(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//do nothing here in test mode			
			}
		});
		
		/**
		 * The {@link InterfaceView#addNextDayActions} method implementation updates the date 
		 * displayed on the calendar.
		 * Does not allow future dates to be selected.
		 */
		view.addNextDayActions(new ActionListener() {		
				@Override
				public void actionPerformed(ActionEvent e) {
					//do nothing here in test mode
		}
	});
		
		//Last updated label
		String test = "Not applicable in test mode.    ";
		view.setLastUpdatedTestMode(test);
	}
}
