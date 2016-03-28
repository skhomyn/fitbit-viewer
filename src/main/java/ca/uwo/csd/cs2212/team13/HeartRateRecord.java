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

import java.io.Serializable;

/**
 * <code>HeartRateRecord</code> is a simple Java object that represents the
 * heart rate stuff and the rules that govern access to and updates of this
 * data, but also contain the model for {@link HeartZoneRecord}.
 * <ul>
 * <li>Is necessary because JSON call, for a date, contains both that heart
 * stuff and the heart zone info
 * <li>Basically, this Java object holds the combined heart info listed in JSON
 * object from API call 
 * </ul>
 */
public class HeartRateRecord implements Serializable{

	/**
	 * Date of this HeartRateRecord
	 */
	private String date;

	/**
	 * reseting heart rate for this record
	 */
	private double restingHR;

	/**
	 * minutes TOTALED from each zone for this record
	 */
	private int minuteTotal;

	/**
	 * All the heart zones for this record
	 */
	private HeartZoneRecord[] heart_zones;

	private HeartRateInstanceRecord[] heart_rates;
	private int datasetInterval;
	private String datasetType;
	
	/**
	 * @return the dRecords
	 */
	public HeartRateInstanceRecord[] getdRecords() {
		return heart_rates;
	}

	/**
	 * @param dRecords the dRecords to set
	 */
	public void setdRecords(HeartRateInstanceRecord[] dRecords) {
		this.heart_rates = dRecords;
	}

	/**
	 * @return the datasetInterval
	 */
	public int getDatasetInterval() {
		return datasetInterval;
	}

	/**
	 * @param datasetInterval the datasetInterval to set
	 */
	public void setDatasetInterval(int datasetInterval) {
		this.datasetInterval = datasetInterval;
	}

	/**
	 * @return the datasetType
	 */
	public String getDatasetType() {
		return datasetType;
	}

	/**
	 * @param datasetType the datasetType to set
	 */
	public void setDatasetType(String datasetType) {
		this.datasetType = datasetType;
	}

	/**
	 * Default Constructor, previously validated
	 * <p>
	 * Sets everything to null
	 */
	public HeartRateRecord() {
		date = null;
		heart_zones = null;
		restingHR = 0;
		minuteTotal = 0;
	}

	/**
	 * constructor, previously validated
	 * 
	 * @param da
	 *            the date from JSON file
	 * @param heart_zones
	 *            the heart zones from JSON file
	 * @param rhr
	 *            the resting heart rate from JSON file
	 * @param total
	 *            the total minutes from JSON file
	 */
	HeartRateRecord(String da, HeartZoneRecord[] heart_zones, double rhr, int total, HeartRateInstanceRecord[] heart_rates, int datasetInterval, String datasetType ) {
		super();
		this.heart_zones = heart_zones;
		this.date = da;
		this.restingHR = rhr;
		this.minuteTotal = total;
		this.heart_rates = heart_rates;
		this.datasetInterval = datasetInterval;
		this.datasetType = datasetType;
	}

	
	/**
	 * Gets the <code>heart_zones</code> field.
	 * <p>
	 * This method returns the {@code HeartZoneRecord[]} value for the heart
	 * zones array.
	 * 
	 * @return the heart_zones array for this record
	 */
	public HeartZoneRecord[] getHeart_zones() {
		return heart_zones;
	}

	/**
	 * Sets the <code>heart_zones</code> field.
	 * <p>
	 * This method sets the {@code HeartZoneRecord[]} value for the field
	 * <code>heart_zones</code>.
	 * 
	 * @param heart_zones
	 *            the new value of the field <code>heart_zones</code> for the
	 *            heart rate record.
	 */
	public void setHeart_zones(HeartZoneRecord[] heart_zones) {
		this.heart_zones = heart_zones;
	}

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
	 * Sets the <code>date</code> field.
	 * <p>
	 * This method sets the {@code String} value for the field <code>date</code>.
	 * 
	 * @param date
	 *            the new value of the field <code>date</code> for the heart
	 *            rate record.
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * Gets the <code>restingHR</code> field.
	 * <p>
	 * This method returns the primitive {@code int} value for the resting heart
	 * rate
	 * 
	 * @return the resting heart rate for this record
	 */
	public double getRestingHR() {
		return restingHR;
	}

	/**
	 * Sets the <code>restingHR</code> field.
	 * <p>
	 * This method sets the {@code int} value for the field
	 * <code>restingHR</code>.
	 * 
	 * @param restingHR
	 *            the new value of the field <code>restingHR</code> for this
	 *            record
	 */
	public void setRestingHR(int restingHR) {
		this.restingHR = restingHR;
	}

	/**
	 * Gets the <code>minuteTotal</code> field.
	 * <p>
	 * This method returns the primitive {@code int} value for the minute total
	 * 
	 * @return the minute total for this record
	 */
	public int getMinuteTotal() {
		return minuteTotal;
	}

	/**
	 * Sets the <code>minuteTotal</code> field.
	 * <p>
	 * This method sets the {@code int} value for the field
	 * <code>minuteTotal</code>.
	 * 
	 * @param minuteTotal
	 *            the new value of the field <code>minuteTotal</code> for this
	 *            record
	 */
	public void setMinuteTotal(int minuteTotal) {
		this.minuteTotal = minuteTotal;
	}

	/**
	 * Gets the out of range heart zone
	 * <p>
	 * This method returns the primitive {@code HeartRateRecord} value for the
	 * out of range heart zone
	 * 
	 * @return the out of range heart zone for this record
	 */
	public HeartZoneRecord getOutRangeZone() {
		return heart_zones[0];
	}

	/**
	 * Sets the out of range zone
	 * <p>
	 * This method sets the {@code int} value for <code>heart_zones[0]</code>.
	 * 
	 * @param zone
	 *            the new value of the field <code>heart_zones[0]</code> for
	 *            this record
	 */
	public void setOutRangeZone(HeartZoneRecord zone) {
		this.heart_zones[0] = zone;
	}

	/**
	 * Gets the fat burn heart zone
	 * <p>
	 * This method returns the primitive {@code HeartRateRecord} value for the
	 * fat burn heart zone
	 * 
	 * @return the fat burn heart zone for this record
	 */
	public HeartZoneRecord getFatBurnZone() {
		return heart_zones[1];
	}

	/**
	 * Sets the fat burn zone
	 * <p>
	 * This method sets the {@code int} value for <code>heart_zones[1]</code>.
	 * 
	 * @param zone
	 *            the new value of the field <code>heart_zones[1]</code> for
	 *            this record
	 */
	public void setFatBurnZone(HeartZoneRecord zone) {
		this.heart_zones[1] = zone;
	}

	/**
	 * Gets the cardio heart zone
	 * <p>
	 * This method returns the primitive {@code HeartRateRecord} value for the
	 * cardio zone
	 * 
	 * @return the cardio heart zone for this record
	 */
	public HeartZoneRecord getCardioZone() {
		return heart_zones[2];
	}

	/**
	 * Sets the cardio zone
	 * <p>
	 * This method sets the {@code int} value for <code>heart_zones[2]</code>.
	 * 
	 * @param zone
	 *            the new value of the field <code>heart_zones[2]</code> for
	 *            this record
	 */
	public void setCardioZone(HeartZoneRecord zone) {
		this.heart_zones[2] = zone;
	}

	/**
	 * Gets the peak heart zone
	 * <p>
	 * This method returns the primitive {@code HeartRateRecord} value for the
	 * peak heart zone
	 * 
	 * @return the peak zone for this record
	 */
	public HeartZoneRecord getPeakZone() {
		return heart_zones[3];
	}

	/**
	 * Sets the peak zone
	 * <p>
	 * This method sets the {@code int} value for <code>heart_zones[3]</code>.
	 * 
	 * @param zone
	 *            the new value of the field <code>heart_zones[3]</code> for
	 *            this record
	 */
	public void setPeakZone(HeartZoneRecord zone) {
		this.heart_zones[3] = zone;
	}
}