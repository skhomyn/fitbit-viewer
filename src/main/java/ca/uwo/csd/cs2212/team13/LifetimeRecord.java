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
 * <code>LifetimeRecord</code> is a simple Java object that represents the
 * lifetime totals and the rules that govern access to and updates of this data.
 */
public class LifetimeRecord {

	/**
	 * The activity score lifetime total
	 */
	private int activityScore;

	/**
	 * the calories out lifetime total
	 */
	private int caloriesOut;

	/**
	 * The distance lifetime total
	 */
	private double distance;

	/**
	 * The floors lifetime total
	 */
	private int floors;

	/**
	 * The steps lifetime total
	 */
	private int steps;

	/**
	 * Constructor, previously validated
	 * 
	 * @param aScore
	 *            the activity score from JSON file
	 * @param cOut
	 *            the calories out from JSON file
	 * @param dis
	 *            the distance from JSON file
	 * @param flo
	 *            the floors from JSON file
	 * @param ste
	 *            the steps from JSON file
	 */
	LifetimeRecord(int aScore, int cOut, double dis, int flo, int ste) {
		super();
		this.activityScore = aScore;
		this.caloriesOut = cOut;
		this.distance = dis;
		this.floors = flo;
		this.steps = ste;
	}

	/**
	 * Gets the <code>distance</code> field.
	 * <p>
	 * This method returns the {@code double} value for the distance.
	 * 
	 * @return the distance lifetime total
	 */
	public double getDistance() {
		return distance;
	}

	/**
	 * Sets the {@code distance} field.
	 * <p>
	 * This method sets the {@code int} value for the field {@code distance}.
	 * 
	 * @param distance
	 *            the new value of the field {@code distance} for the lifetime
	 *            record
	 */
	public void setDistance(double distance) {
		this.distance = distance;
	}

	/**
	 * Gets the <code>activityScore</code> field.
	 * <p>
	 * This method returns the {@code int} value for the activity score.
	 * 
	 * @return the activity score lifetime total
	 */
	public int getActivityScore() {
		return activityScore;
	}

	/**
	 * Sets the {@code activityScore} field.
	 * <p>
	 * This method sets the {@code int} value for the field
	 * {@code activityScore}.
	 * 
	 * @param activityScore
	 *            the new value of the field {@code activityScore} for the
	 *            lifetime record
	 */
	public void setActivityScore(int activityScore) {
		this.activityScore = activityScore;
	}

	/**
	 * Gets the <code>caloriesOut</code> field.
	 * <p>
	 * This method returns the {@code int} value for the calories out.
	 * 
	 * @return the calories out lifetime total
	 */
	public int getCaloriesOut() {
		return caloriesOut;
	}

	/**
	 * Sets the {@code caloriesOut} field.
	 * <p>
	 * This method sets the {@code int} value for the field {@code caloriesOut}.
	 * 
	 * @param caloriesOut
	 *            the new value of the field {@code caloriesOut} for the
	 *            lifetime record
	 */
	public void setCaloriesOut(int caloriesOut) {
		this.caloriesOut = caloriesOut;
	}

	/**
	 * Gets the <code>floors</code> field.
	 * <p>
	 * This method returns the {@code int} value for the floors.
	 * 
	 * @return the floors lifetime total
	 */
	public int getFloors() {
		return floors;
	}

	/**
	 * Sets the {@code floor} field.
	 * <p>
	 * This method sets the {@code int} value for the field {@code floors}.
	 * 
	 * @param floors
	 *            the new value of the field {@code floors} for the lifetime
	 *            record
	 */
	public void setFloors(int floors) {
		this.floors = floors;
	}

	/**
	 * Gets the <code>steps</code> field.
	 * <p>
	 * This method returns the {@code int} value for the steps.
	 * 
	 * @return the steps lifetime total
	 */
	public int getSteps() {
		return steps;
	}

	/**
	 * Sets the {@code steps} field.
	 * <p>
	 * This method sets the {@code int} value for the field {@code steps}.
	 * 
	 * @param steps
	 *            the new value of the field {@code steps} for the lifetime
	 *            record
	 */
	public void setSteps(int steps) {
		this.steps = steps;
	}

}
