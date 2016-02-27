public class HRZmodel {
	
	//attributes
	private int minutes;
	private String zones;
	private int rate;
	
	//constructor
	HRZmodel() {
		//use FakeAPI
		minutes = FakeAPI.getHRMins();
		zones = FakeAPI.getHRZone();
		rate = FakeAPI.getRestRate();
	}
	
	//getters for heart rate values
	public float getHRMinutes() {
		return minutes;
	}
	
	public String getHRZones() {
		return zones;
	}
	
	public int getHRRate() {
		return rate;
	}
}