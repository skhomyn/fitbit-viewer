package ca.uwo.csd.cs2212.team13;

public class StepsRecord {

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
	 * @param value
	 */
	public StepsRecord(String time, double value) {
		super();
		this.time = time;
		this.value = value;
	}

	public StepsRecord() {

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
