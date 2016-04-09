package ca.uwo.csd.cs2212.team13;

import java.io.Serializable;

/**
 * Creates in instance object for heart rate
 */
public class HeartRateInstanceRecord implements Serializable {

	private String time;
	private double value;
	
    /**
	 * @return the time
	 */
	public String getTime() {
		return time;
	}

	/**
	 * @param time the time to set
	 */
	public void setTime(String time) {
		this.time = time;
	}

	/**
	 * @return the value
	 */
	public double getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(double value) {
		this.value = value;
	}

	/**
	 * @param time
	 * 	the time
	 * @param value
	 * 	the heart rate instance record value
	 */
	public HeartRateInstanceRecord(String time, double value) {
		super();
		this.time = time;
		this.value = value;
	}

	/**
	 * unused heart rate zone instance record
	 */
	public HeartRateInstanceRecord() {

    }
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		final StringBuilder formatted = new StringBuilder();		
		formatted.append(time + "\n");
		formatted.append(value + "\n");
		return formatted.toString();
	}
}
