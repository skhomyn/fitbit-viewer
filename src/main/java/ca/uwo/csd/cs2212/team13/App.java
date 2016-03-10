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

		APICaller test = new APICaller("activity%20heartrate", "src/main/resources/Team13Tokens.txt", "src/main/resources/Team13Credentials.txt");
		test.request("activities/heart/date/today/1d.json");
		
		Main run = new Main();

		// If no arguments, then actual run. But we don't have that working yet
		if (args.length == 0) {
			logger.trace("No arguments passed");
			logger.warn("We need to build a program. And we have to do it quickly");
			logger.warn("Run with argument test to test");
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
