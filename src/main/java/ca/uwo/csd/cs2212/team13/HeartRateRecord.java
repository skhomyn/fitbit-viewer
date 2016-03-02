package ca.uwo.csd.cs2212.team13;

//this class is for the 4 different zones
public class HeartRateRecord {

	private String date;
	private int restingHR;
	private int minuteTotal;
	
	public HeartZoneRecord[] getHeart_zones() {
		return heart_zones;
	}

	public void setHeart_zones(HeartZoneRecord[] heart_zones) {
		this.heart_zones = heart_zones;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	private HeartZoneRecord[] heart_zones;
	
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

	//constructor which populates fields with data
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

	public HeartZoneRecord getOutRangeZone() {
		return heart_zones[0];
	}

	public void setOutRangeZone(HeartZoneRecord zone) {
		this.heart_zones[0] = zone;
	}
	
	public HeartZoneRecord getFatBurnZone() {
		return heart_zones[1];
	}

	public void setFatBurnZone(HeartZoneRecord zone) {
		this.heart_zones[1] = zone;
	}
	
	public HeartZoneRecord getCardioZone() {
		return heart_zones[2];
	}

	public void setCardioZone(HeartZoneRecord zone) {
		this.heart_zones[2] = zone;
	}

	public HeartZoneRecord getPeakZone() {
		return heart_zones[3];
	}

	public void setPeakZone(HeartZoneRecord zone) {
		this.heart_zones[3] = zone;
	}


}