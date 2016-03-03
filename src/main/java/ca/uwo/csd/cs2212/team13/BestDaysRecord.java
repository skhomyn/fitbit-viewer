package ca.uwo.csd.cs2212.team13;

/**
 * <code>BestDaysRecord</code> is a simple Java object that represents the
 * lifetime totals and the rules that govern access to and updates of this data
 */

public class BestDaysRecord {
	
	/**
	 * The date of the best recorded day for distance traveled
	 */
	private String dis_date;
	
	/**
	 * The value of the farthest distance recorded in a single day
	 */
	private double dis_value;
	
	/**
	 * The date of the best recorded day for floors climbed
	 */
	private String floors_date;
	
	/**
	 * The value of the most floors climbed in a single day
	 */
	private int floors_value;
	
	/**
	 * The date of the best recorded day for steps taken
	 */
	private String steps_date;
	
	/**
	 * The value of the most steps taken in a single day
	 */
	private int steps_value;
	
	/**
	 * Constructor initializes the data fields for this object from the JSON file.
	 * Constructor is called from {@link ActivitiesRecordDeserializer} with arguments from activities.json.
	 * 
	 * @param dis_date date of best day for distance from the JSON file
	 * @param dis_value value for distance on the best recorded day day from the JSON file
	 * @param floors_date date of best day for floors from the JSON file
	 * @param floors_value value for floors on the best recorded day day from the JSON file
	 * @param steps_date date of best day for steps from the JSON file
	 * @param steps_value value for steps on the best recorded day day from the JSON file
	 */
	public BestDaysRecord(String dis_date, double dis_value, String floors_date, int floors_value, String steps_date, int steps_value) {
		super();
		this.dis_date = dis_date;
		this.dis_value = dis_value;
		this.floors_date = floors_date;
		this.floors_value = floors_value;
		this.steps_date = steps_date;
		this.steps_value = steps_value;
	}
	
	/**
	 * Gets the {@code String} value for the{@code dis_date} field.
	 * 
	 * @return dis_date date for the day on which the farthest distance was traveled
	 */
	public String getDis_date() {
		return dis_date;
	}
	
	/**
	 * Sets the {@code String} value for the field {@code dis_date}.
	 * 
	 * @param distance
	 *            the new date on which the farthest distance was traveled
	 */
	public void setDis_date(String dis_date) {
		this.dis_date = dis_date;
	}
	
	/**
	 * Gets the {@code double} value for the {@code dist_value} field.
	 * 
	 * @return dis_value the value for distance traveled on the best day
	 */
	public double getDis_value() {
		return dis_value;
	}
	
	/**
	 * Sets the {@code double} value for the {@code dist_value} field.
	 * 
	 * @param dis_value the new value for distance traveled on the best day.
	 */
	public void setDis_value(double dis_value) {
		this.dis_value = dis_value;
	}

	/**
	 * Gets the {@code String} value for the{@code floors_date} field.
	 * 
	 * @return floors_date date for the day on which the most floors were climbed
	 */
	public String getFloors_date() {
		return floors_date;
	}

	/**
	 * Sets the {@code String} value for the field {@code floors_date}.
	 * 
	 * @param floors_date
	 *            the new date on which the most floors were climbed
	 */
	public void setFloors_date(String floors_date) {
		this.floors_date = floors_date;
	}

	/**
	 * Gets the {@code int} value for the {@code floors_value} field.
	 * 
	 * @return floors_value the value for floors climbed on the best day
	 */
	public int getFloors_value() {
		return floors_value;
	}

	/**
	 * Sets the {@code int} value for the {@code floors_value} field.
	 * 
	 * @param floors_value the new value for floors climbed on the best day.
	 */
	public void setFloors_value(int floors_value) {
		this.floors_value = floors_value;
	}

	/**
	 * Gets the {@code String} value for the{@code steps_date} field.
	 * 
	 * @return steps_date date for the day on which the most steps were taken
	 */
	public String getSteps_date() {
		return steps_date;
	}

	/**
	 * Sets the {@code String} value for the field {@code steps_date}.
	 * 
	 * @param steps_date
	 *            the new date on which the most steps were taken
	 */
	public void setSteps_date(String steps_date) {
		this.steps_date = steps_date;
	}

	/**
	 * Gets the {@code int} value for the {@code steps_value} field.
	 * 
	 * @return steps_value the value for steps taken on the best day
	 */
	public int getSteps_value() {
		return steps_value;
	}

	/**
	 * Sets the {@code int} value for the {@code steps_value} field.
	 * 
	 * @param steps_value the new value for steps taken on the best day.
	 */
	public void setSteps_value(int steps_value) {
		this.steps_value = steps_value;
	}

}
