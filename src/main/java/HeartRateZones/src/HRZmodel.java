package HeartRateZones.src;

public class HRZmodel {
	
	//attributes
	private int minutes;
	private String zones;
	private int rate;
	
	//constructor which populates fields with data from API call
	HRZmodel(int mins, String z, int r) {
		super();
		// we don't use FakeAPI anymore!
		//minutes = FakeAPI.getHRMins();
		//zones = FakeAPI.getHRZone();
		//rate = FakeAPI.getRestRate();
		this.minutes = mins;
		this.zones = z;
		this.rate = r;
	}
	
	//accessors for heart rate values
	public float getHRMinutes() {
		return minutes;
	}
	
	public void setHRMinutes(int hrm) {
		this.minutes = hrm;
	}
	
	//accessors for zones
	public String getHRZones() {
		return zones;
	}
	
	public void setHRZones(String hrz) {
		this.zones = hrz;
	}
	
	//accessors for rate
	public int getHRRate() {
		return rate;
	}
	
	public void setHRRate(int hrr) {
		this.rate = hrr;
	}
	
	//toString method 
	  public String toString() {
		    return String.format("[%d] [%d] [%s] ", minutes, rate, zones);
		  }
}