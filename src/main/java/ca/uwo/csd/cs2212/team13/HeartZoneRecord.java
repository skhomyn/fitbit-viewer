package ca.uwo.csd.cs2212.team13;

public class HeartZoneRecord {
	
	//attributes
	private static int minutes;
	
	//the different heart rate zones are:
	//out-of-range, cardio, fat-burn, peak
	private static String zones;
	
	//each zone has a max/min rate associated with it
	private static int rate;
	
	//constructor which populates fields with data from API call
	HeartZoneRecord(int mins, String z, int r) {
		super();
		this.minutes = mins;
		this.zones = z;
		this.rate = r;
	}
	
	//accessors for heart rate values
	public static int getHRMinutes() {
		return minutes;
	}
	
	public void setHRMinutes(int hrm) {
		this.minutes = hrm;
	}
	
	//accessors for zones
	public static String getHRZones() {
		return zones;
	}
	
	public void setHRZones(String hrz) {
		this.zones = hrz;
	}
	
	//accessors for rate
	public static int getHRRate() {
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