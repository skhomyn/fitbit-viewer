/*
 * Copyright (c) 2016, Team Sharkzilla (13)
 * */
package ca.uwo.csd.cs2212.team13;

/**
 * <code>HeartZoneRecord</code> is a simple Java object that represents the
 * heart zone record and the rules that govern access to and updates of this data.
 */
public class HeartZoneRecord {

	/**
	 * the name of the zone
	 */
	private String name;
	
	/**each zone has a maximum, minutes and 
	 * minimum rate associated with it
	 */
	private int max;
	private int min;
	private int minutes;

	/**
	 * Constructor, previously validated
	 * 
	 * @param max
	 *            the max heart rate from JSON file
	 * @param min
	 *            the min heart rate from JSON file
	 * @param minut
	 *            the minutes from JSON file
	 * @param na
	 *            the name from JSON file
	 */
	HeartZoneRecord(int max, int min, int minut, String na) {
		this.minutes = minut;
		this.name = na;
		this.max = max;
		this.min = min;
	}

	/**
	 * Gets the <code>minutes</code> field.
	 * <p>
	 * This method returns the {@code int} value for the distance.
	 * 
	 * @return the minutes
	 */
	public int getMinutes() {
		return minutes;
	}

	/**
	 * Sets the {@code minutes} field.
	 * <p>
	 * This method sets the {@code int} value for the field {@code minutes}.
	 * 
	 * @param minutes
	 *            the new value of the field {@code minutes} for the heart zone
	 */
	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	/**
	 * Gets the <code>name</code> field.
	 * <p>
	 * This method returns the {@code String} value for the name.
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the {@code name} field.
	 * <p>
	 * This method sets the {@code int} value for the field {@code minutes}.
	 * 
	 * @param name
	 *            the new value of the field {@code name} for the heart zone
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the <code>max</code> field.
	 * <p>
	 * This method returns the {@code int} value for the name.
	 * 
	 * @return the max
	 */
	public int getMax() {
		return max;
	}

	/**
	 * Sets the {@code max} field.
	 * <p>
	 * This method sets the {@code int} value for the field {@code minutes}.
	 * 
	 * @param max
	 *            the new value of the field {@code max} for the heart zone
	 */
	public void setMax(int max) {
		this.max = max;
	}

	/**
	 * Gets the <code>min</code> field.
	 * <p>
	 * This method returns the {@code int} value for the name.
	 * 
	 * @return the min
	 */
	public int getMin() {
		return min;
	}

	/**
	 * Sets the {@code min} field.
	 * <p>
	 * This method sets the {@code int} value for the field {@code minutes}.
	 * 
	 * @param min
	 *            the new value of the field {@code min} for the heart zone
	 */
	public void setMin(int min) {
		this.min = min;
	}

}