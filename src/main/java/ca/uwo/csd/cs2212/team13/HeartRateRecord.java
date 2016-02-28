package ca.uwo.csd.cs2212.team13;

//this class is for the 4 different zones
public class HeartRateRecord {

	private String date;
	private HeartZoneRecord[] heart_zones;
	
	HeartRateRecord()
	{
		date = null;
		heart_zones = null;
	}
	//constructor which populates fields with data
	HeartRateRecord(String da, HeartZoneRecord[] heart_zones) {
		super();
		this.heart_zones = heart_zones;
		this.date = da;
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