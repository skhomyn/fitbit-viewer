package ca.uwo.csd.cs2212.team13;

/**
 * Model class for 4 heart rate zones
 * @author Jennifer
 */

public class HeartRateRecord {

	/**
	 * properties
	 * We get date, resting heart rate,
	 * and total mins from the API
	 */
	private String date;
	private int restingHR;
	private int minuteTotal;
	
	/**
	 * getter for array of all 4
	 * heart zones
	 * @return
	 */
	public HeartZoneRecord[] getHeart_zones() {
		return heart_zones;
	}

	/**
	 * setter for the heart zones array
	 * @param heart_zones
	 */
	public void setHeart_zones(HeartZoneRecord[] heart_zones) {
		this.heart_zones = heart_zones;
	}

	/**
	 * getter for the date
	 * @return
	 */
	public String getDate() {
		return date;
	}

	/**
	 * setter for the date
	 * @param date
	 */
	public void setDate(String date) {
		this.date = date;
	}

	private HeartZoneRecord[] heart_zones;
	
	/**
	 * empty constructor
	 */
	HeartRateRecord()
	{
		date = null;
		heart_zones = null;
		restingHR = 0;
		minuteTotal = 0;
	}
	/**
	 * @return the restingHR
	 */
	public int getRestingHR() {
		return restingHR;
	}

	/**
	 * @param restingHR the restingHR to set
	 */
	public void setRestingHR(int restingHR) {
		this.restingHR = restingHR;
	}

	/**
	 * constructor that 
	 * populates with data
	 * @param da
	 * @param heart_zones
	 * @param rhr
	 * @param total
	 */
	HeartRateRecord(String da, HeartZoneRecord[] heart_zones, int rhr, int total) {
		super();
		this.heart_zones = heart_zones;
		this.date = da;
		this.restingHR = rhr;
		this.minuteTotal = total;
	}

	/**
	 * @return the minuteTotal
	 */
	public int getMinuteTotal() {
		return minuteTotal;
	}

	/**
	 * @param minuteTotal the minuteTotal to set
	 */
	public void setMinuteTotal(int minuteTotal) {
		this.minuteTotal = minuteTotal;
	}

	/**
	 * @return out of range heart zone
	 */
	public HeartZoneRecord getOutRangeZone() {
		return heart_zones[0];
	}

	/**
	 * sets out of range zone
	 * @param zone
	 */
	public void setOutRangeZone(HeartZoneRecord zone) {
		this.heart_zones[0] = zone;
	}
	
	/**
	 * @return fat burn zone
	 */
	public HeartZoneRecord getFatBurnZone() {
		return heart_zones[1];
	}

	/**
	 * sets the fat burn zone
	 * @param zone
	 */
	public void setFatBurnZone(HeartZoneRecord zone) {
		this.heart_zones[1] = zone;
	}
	
	/**
	 * @return cardio zone
	 */
	public HeartZoneRecord getCardioZone() {
		return heart_zones[2];
	}

	/**
	 * sets the cardio zone
	 * @param zone
	 */
	public void setCardioZone(HeartZoneRecord zone) {
		this.heart_zones[2] = zone;
	}

	/**
	 * @return peak zone
	 */
	public HeartZoneRecord getPeakZone() {
		return heart_zones[3];
	}

	/**
	 * sets the peak zone
	 * @param zone
	 */
	public void setPeakZone(HeartZoneRecord zone) {
		this.heart_zones[3] = zone;
	}
}