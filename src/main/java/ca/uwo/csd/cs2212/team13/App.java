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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * When someone tries to run the program, this decides, based on arguments, what
 * actually runs.
 * <p>
 * Located in this folder as very important for pom file and Maven
 * <p>
 * Logger implemented.
 */
public class App {

	/**
	 * A logger to our program to check if test mode/program actually run
	 */
	static Logger logger = LogManager.getLogger(App.class.getName());

	/**
	 * Main method that decides what form of program to run based on arguments
	 * <p>
	 * Creates a {@link Main} instance which actually handles the interface and
	 * input.
	 * <p>
	 * Checks arguments to decide what runs.
	 * <ul>
	 * <li>If test argument, run test mode.
	 * <li>If no arguments, then runs
	 * <li>Otherwise, fails.
	 * </ul>
	 * 
	 * @param args
	 *            the arguments to the program - could be test
	 * @throws IOException
	 *             if i/o glitches out
	 */
	public static void main(String[] args) throws IOException {
		logger.trace("Entering main");
		logger.warn("Hello Maven/log4j World");
		logger.info("My username is team13");

		AccoladeRecord[] ar = new AccoladeRecord[20];
		WriterReader wr = new WriterReader();
		
		//public AccoladeRecord(boolean achieved, String date, int value, String image, String type) {

		ar[0] = new AccoladeRecord(false, null, 10000, "stepsAcc.jpg", "lifetime/steps");
		ar[1] = new AccoladeRecord(false, null, 0, "noGoalsAcc.jpg", "dailygoals/check");
		ar[2] = new AccoladeRecord(false, null, 2000, "calorieAcc.jpg", "calorie/check");
		ar[3] = new AccoladeRecord(false, null, 2000, "calsBurnedAcc.jpg", "calorie/burned");
		ar[4] = new AccoladeRecord(false, null, 25, "CardioAcc.jpg", "heartrate/cardio");
		ar[5] = new AccoladeRecord(false, null, 5, "distanceAcc.jpg", "distance/check");
		ar[6] = new AccoladeRecord(false, null, 8, "eightHrsSleepAcc.jpg", "lifetime/sleep8");
		ar[7] = new AccoladeRecord(false, null, 25, "FatBurnAcc.jpgDownload", "heartrate/fat");
		ar[8] = new AccoladeRecord(false, null, 100, "floorsAcc.jpg", "lifetime/floor");
		ar[9] = new AccoladeRecord(false, null, 60, "noActivityAcc.jpg", "lazy/noactivity");
		ar[10] = new AccoladeRecord(false, null, 0, "noGoalsAcc.jpg", "lifetime/nogoals");
		ar[11] = new AccoladeRecord(false, null, 0, "nosleepAcc.jpg", "lifetime/nosleep");
		ar[12] = new AccoladeRecord(false, null, 50, "OutofRangeAcc.jpg", "heartrate/outofrange");
		ar[13] = new AccoladeRecord(false, null, 50, "PeakAcc.jpg", "heartrate/peak");
		ar[14] = new AccoladeRecord(false, null, 0, "sedentaryMinsAcc.jpg", "lifetime/potato");
		ar[15] = new AccoladeRecord(false, null, 0, "tooMuchSleepAcc.jpg", "lifetime/sleepalot");
		ar[16] = new AccoladeRecord(false, null, 0, "xmasAcc.jpg", "event/christmas");



		
		//Ryan, just make new accolades ar[2] all the way to ar[20] accordingly
		
		try {
			wr.writeRecord(ar, "accoladerecords");

		} catch (Exception e) {
			System.out.println("Could not write to file");
		}
		ar = null;
		try {
			ar = (AccoladeRecord[]) wr.loadRecord("src/main/resources/accoladerecords");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(ar[1].getImage());
		
		Main run = new Main();

		// If no arguments, then actual run. But we don't have that working yet
		if (args.length == 0) {
			//logger.trace("No arguments passed");
			//logger.warn("We need to build a program. And we have to do it quickly");
			//logger.warn("Run with argument test to test");
			logger.trace("Running main program");
			
			//APICaller test = new APICaller("activity%20heartrate", "src/main/resources/Team13Tokens.txt", "src/main/resources/Team13Credentials.txt");
			//test.request("activities/heart/date/today/1d.json", "src/main/resources/cur_heart_data.json");
			//test.request("activities/date/today.json", "src/main/resources/cur_activities_data.json");
			//test.request("activities.json", "src/main/resources/cur_totals.json");
			
			run.run();
		}
		// Check if argument is test. If so, run in test mode
		else if (args.length == 1 && args[0].equals("test")) {
			logger.trace("Running test mode");
			run.test_run();
		} else {
			logger.trace("Unvalid arguments passed for now…");
		}
		logger.trace("Exiting main");
	}
}
