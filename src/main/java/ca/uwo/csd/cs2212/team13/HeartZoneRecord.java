package ca.uwo.csd.cs2212.team13;

/**
 * Model for Heart Rate Zones
 * @author Jennifer
 */

public class HeartZoneRecord {
	
	/**
	 * the name of the zone
	 */
	private String name;
	/**each zone has a maximum and 
	 * minimum rate associated with it
	 */
	private int max;
	private int min;
	private int minutes;
	
	/**
	 * Constructor 
	 * populates fields with data
	 * from API call
	 * @param max
	 * @param min
	 * @param minut
	 * @param na
	 */
	HeartZoneRecord(int max, int min, int minut, String na) {
		this.minutes = minut;
		this.name = na;
		this.max = max;
		this.min = min;
	}
	
	 /**
	 * @return the minutes
	 */
	public int getMinutes() {
		return minutes;
	}

	/**
	 * @param minutes the minutes to set
	 */
	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the max
	 */
	public int getMax() {
		return max;
	}

	/**
	 * @param max the max to set
	 */
	public void setMax(int max) {
		this.max = max;
	}

	/**
	 * @return the min
	 */
	public int getMin() {
		return min;
	}

	/**
	 * @param min the min to set
	 */
	public void setMin(int min) {
		this.min = min;
	}

	@Override
	/**
	 * toString method 
	 * returns value for
	 * each property
	 */
	  public String toString() {
		    return String.format("[%d] [%d] [%d] [%d] ", minutes, max, min, name);
		  }
}