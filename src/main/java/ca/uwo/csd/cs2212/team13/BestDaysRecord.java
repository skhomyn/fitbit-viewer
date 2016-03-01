package ca.uwo.csd.cs2212.team13;

public class BestDaysRecord {

	private String dis_date;
	private double dis_value;
	private String floors_date;
	private int floors_value;
	private String steps_date;
	private int steps_value;
	
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
	 * @return the dis_date
	 */
	public String getDis_date() {
		return dis_date;
	}
	/**
	 * @param dis_date the dis_date to set
	 */
	public void setDis_date(String dis_date) {
		this.dis_date = dis_date;
	}
	/**
	 * @return the dis_value
	 */
	public double getDis_value() {
		return dis_value;
	}
	/**
	 * @param dis_value the dis_value to set
	 */
	public void setDis_value(double dis_value) {
		this.dis_value = dis_value;
	}
	/**
	 * @return the floors_date
	 */
	public String getFloors_date() {
		return floors_date;
	}
	/**
	 * @param floors_date the floors_date to set
	 */
	public void setFloors_date(String floors_date) {
		this.floors_date = floors_date;
	}
	/**
	 * @return the floors_value
	 */
	public int getFloors_value() {
		return floors_value;
	}
	/**
	 * @param floors_value the floors_value to set
	 */
	public void setFloors_value(int floors_value) {
		this.floors_value = floors_value;
	}
	/**
	 * @return the steps_date
	 */
	public String getSteps_date() {
		return steps_date;
	}
	/**
	 * @param steps_date the steps_date to set
	 */
	public void setSteps_date(String steps_date) {
		this.steps_date = steps_date;
	}
	/**
	 * @return the steps_value
	 */
	public int getSteps_value() {
		return steps_value;
	}
	/**
	 * @param steps_value the steps_value to set
	 */
	public void setSteps_value(int steps_value) {
		this.steps_value = steps_value;
	}
	
	 // @Override
	  //public String toString() {
	   // return String.format("[%s] [%f] [%s] [%f] [%s] [%f] ", dis_date, dis_value, floors_date, floors_value, steps_date, steps_value);
	  //}
	
}
