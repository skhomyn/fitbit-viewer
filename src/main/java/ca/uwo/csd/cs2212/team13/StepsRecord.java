package ca.uwo.csd.cs2212.team13;

import java.io.Serializable;

/**
 * Model for Steps
 * @author Robin
 * 
 * 
 * 
 */

public class StepsRecord implements Serializable {

	private String time;
	private double value;
	
    /**
     * method to
	 * @return the time
	 */
	public String getTime() {
		return time;
	}

	/**
	 * method to set time
	 * @param time (the time to set)
	 */
	public void setTime(String time) {
		this.time = time;
	}

	/**
	 * method to get steps value
	 * @return the value
	 */
	public double getValue() {
		return value;
	}

	/**
	 * method to set steps value
	 * @param value (the value to set)
	 */
	public void setValue(double value) {
		this.value = value;
	}

	/**
	 * Constructor
	 * @param time
	 * @param value
	 */
	public StepsRecord(String time, double value) {
		super();
		this.time = time;
		this.value = value;
	}

	/*
	 * constructor not used
	 */
	public StepsRecord() {
		
    }
	
	@Override
	/**
	 * toString method to format
	 * time and value to a string
	 * @return formatted string
	 */
	public String toString() {
		final StringBuilder formatted = new StringBuilder();		
		formatted.append(time + "\n");
		formatted.append(value + "\n");
		return formatted.toString();
	}
}
