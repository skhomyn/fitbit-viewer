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

/**
 * <code>DailyRecord</code> is a simple Java object that represents the daily
 * dashboard and the rules that govern access to and updates of this data, but
 * also contain the model for {@link goals}.
 * <p>
 * <li>Is necessary because JSON call, for a date, contains both that daily info
 * plus the daily goals
 * <li>Basically, this Java object holds the combined daily record listed in
 * JSON object from API call </ul>
 */
public class DailyRecord {

	/**
	 * Floors, steps, minutes, calories - all necessary info for daily dashboard
	 */
	private int floors, steps, lightlyActiveMinutes, fairlyActiveMinutes,
			sedentaryMinutes, veryActiveMinutes, calories;
	/**
	 * The total distance for the day
	 */
	private double distance;

	/**
	 * The Record for the Goals
	 */
	private Goals goals;

	/**
	 * The Date for this DailyRecord
	 */
	private String date;

	/**
	 * Gets the <code>date</code> field.
	 * <p>
	 * This method returns the primitive {@code String} value for the date
	 * 
	 * @return the date for this record
	 */
	public String getDate() {
		return date;
	}

	/**
	 * Gets the <code>goals</code> field.
	 * <p>
	 * This method returns the {@code Goals} value for the goals record.
	 * 
	 * @return the goals record
	 */
	public Goals getGoals() {
		return goals;
	}

	/**
	 * Gets the <code>floors</code> field.
	 * <p>
	 * This method returns the {@code int} value for the floors.
	 * 
	 * @return the number of floors for this record
	 */
	public int getFloors() {
		return floors;
	}

	/**
	 * Gets the <code>steps</code> field.
	 * <p>
	 * This method returns the {@code int} value for the steps.
	 * 
	 * @return the number of steps for this record
	 */
	public int getSteps() {
		return steps;
	}

	/**
	 * Gets the <code>lightlyActiveMinutes</code> field.
	 * <p>
	 * This method returns the {@code int} value for the lightly active minutes.
	 * 
	 * @return the lightly active minutes for this record
	 */
	public int getLightlyActiveMinutes() {
		return lightlyActiveMinutes;
	}

	/**
	 * Gets the <code>fairlyActiveMinutes</code> field.
	 * <p>
	 * This method returns the {@code int} value for the fairly active minutes
	 * record.
	 * 
	 * @return the fairly active minutes for this record
	 */
	public int getFairlyActiveMinutes() {
		return fairlyActiveMinutes;
	}

	/**
	 * Gets the <code>sedentaryMinutes</code> field.
	 * <p>
	 * This method returns the {@code int} value for the sedentary minutes
	 * record.
	 * 
	 * @return the sedentary minutes for this record
	 */
	public int getSedentaryMinutes() {
		return sedentaryMinutes;
	}

	/**
	 * Gets the <code>veryActiveMinutes</code> field.
	 * <p>
	 * This method returns the {@code int} value for the very active minutes
	 * 
	 * @return the very active minutes for this record
	 */
	public int getVeryActiveMinutes() {
		return veryActiveMinutes;
	}

	/**
	 * Gets the <code>calories</code> field.
	 * <p>
	 * This method returns the {@code int} value for the calories.
	 * 
	 * @return the calories for this record
	 */
	public int getCalories() {
		return calories;
	}

	/**
	 * Gets the <code>distance</code> field.
	 * <p>
	 * This method returns the {@code double} value for the distance.
	 * 
	 * @return the distance for this record
	 */
	public double getDistance() {
		return distance;
	}

	/**
	 * Sets the <code>date</code> field.
	 * <p>
	 * This method sets the {@code String} value for the field <code>date</code>.
	 * 
	 * @param date
	 *            the new value of the field <code>date</code> for the daily record.
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * Sets the {@code goals} field.
	 * <p>
	 * This method sets the {@code Goals} value for the field {@code goals}.
	 * 
	 * @param goals
	 *            the new value of the field {@code goals} for the daily record
	 */
	public void setGoals(Goals goals) {
		this.goals = goals;
	}

	/**
	 * Sets the {@code floors} field.
	 * <p>
	 * This method sets the {@code int} value for the field {@code floors}.
	 * 
	 * @param floors
	 *            the new value of the field {@code floors} for the daily record
	 */
	public void setFloors(int floors) {
		this.floors = floors;
	}

	/**
	 * Sets the {@code steps} field.
	 * <p>
	 * This method sets the {@code int} value for the field {@code steps}.
	 * 
	 * @param steps
	 *            the new value of the field {@code steps} for the daily record
	 */
	public void setSteps(int steps) {
		this.steps = steps;
	}

	/**
	 * Sets the {@code lightlyActiveMinutes} field.
	 * <p>
	 * This method sets the {@code int} value for the field {@code lightlyActiveMinutes}.
	 * 
	 * @param LightlyActiveMinutes
	 *            the new value of the field {@code lightlyActiveMinutes} for the daily record
	 */
	public void setLightlyActiveMinutes(int LightlyActiveMinutes) {
		this.lightlyActiveMinutes = LightlyActiveMinutes;
	}

	/**
	 * Sets the {@code fairlyActiveMinutes} field.
	 * <p>
	 * This method sets the {@code int} value for the field {@code fairlyActiveMinutes}.
	 * 
	 * @param FairlyActiveMinutes
	 *            the new value of the field {@code lightlyActiveMinutes} for the daily record
	 */
	public void setFairlyActiveMinutes(int FairlyActiveMinutes) {
		this.fairlyActiveMinutes = FairlyActiveMinutes;
	}

	/**
	 * Sets the {@code sedentaryMinutes} field.
	 * <p>
	 * This method sets the {@code int} value for the field {@code sedentaryMinutes}.
	 * 
	 * @param SedentaryMinutes
	 *            the new value of the field {@code sedentaryMinutes} for the daily record
	 */
	public void setSedentaryMinutes(int SedentaryMinutes) {
		this.sedentaryMinutes = SedentaryMinutes;
	}

	/**
	 * Sets the {@code veryActiveMinutes} field.
	 * <p>
	 * This method sets the {@code int} value for the field {@code veryActiveMinutes}.
	 * 
	 * @param VeryActiveMinutes
	 *            the new value of the field {@code veryActiveMinutes} for the daily record
	 */
	public void setVeryActiveMinutes(int VeryActiveMinutes) {
		this.veryActiveMinutes = VeryActiveMinutes;
	}

	/**
	 * Sets the {@code calories} field.
	 * <p>
	 * This method sets the {@code int} value for the field {@code calories}.
	 * 
	 * @param calories
	 *            the new value of the field {@code calories} for the daily record
	 */
	public void setCalories(int calories) {
		this.calories = calories;
	}

	/**
	 * Sets the {@code distance} field.
	 * <p>
	 * This method sets the {@code double} value for the field {@code distance}.
	 * 
	 * @param distance
	 *            the new value of the field {@code distance} for the daily record
	 */
	public void setDistance(double distance) {
		this.distance = distance;
	}

}