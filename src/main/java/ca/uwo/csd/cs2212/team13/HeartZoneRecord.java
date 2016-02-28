package ca.uwo.csd.cs2212.team13;

public class HeartZoneRecord {
	
	//attributes
	private static int minutes;
	
	//the different heart rate zones are:
	//out-of-range, cardio, fat-burn, peak
	private static String name;
	
	//each zone has a max/min rate associated with it
	private static int max;
	private static int min;
	
	//constructor which populates fields with data from API call
	HeartZoneRecord(int max, int min, int minut, String na) {
		this.minutes = minut;
		this.name = na;
		this.max = max;
		this.min = min;
	}
	
	 /**
	 * @return the minutes
	 */
	public static int getMinutes() {
		return minutes;
	}

	/**
	 * @param minutes the minutes to set
	 */
	public static void setMinutes(int minutes) {
		HeartZoneRecord.minutes = minutes;
	}

	/**
	 * @return the name
	 */
	public static String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public static void setName(String name) {
		HeartZoneRecord.name = name;
	}

	/**
	 * @return the max
	 */
	public static int getMax() {
		return max;
	}

	/**
	 * @param max the max to set
	 */
	public static void setMax(int max) {
		HeartZoneRecord.max = max;
	}

	/**
	 * @return the min
	 */
	public static int getMin() {
		return min;
	}

	/**
	 * @param min the min to set
	 */
	public static void setMin(int min) {
		HeartZoneRecord.min = min;
	}

	@Override
	  public String toString() {
		    return String.format("[%d] [%d] [%d] [%d] ", minutes, max, min, name);
		  }
}