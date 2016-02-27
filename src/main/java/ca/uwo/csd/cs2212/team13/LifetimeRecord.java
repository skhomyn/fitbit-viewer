package ca.uwo.csd.cs2212.team13;

/**
 * @author Andy
 *
 */
public class LifetimeRecord extends RecordModel {

	private int activityScore;
	private int caloriesOut;
	private double distance;
	private int floors;
	private int steps;
	
	//constructor which populates fields with data from API call
	//currently we are using fake sample data instead of an API call
	LifetimeRecord(int aScore, int cOut, double dis, int flo, int ste) {
		super();
		this.activityScore = aScore;
		this.caloriesOut = cOut;
		this.distance = dis;
		this.floors = flo;
		this.steps = ste; 
	}	

	/**
	 * @return the distance
	 */
	public double getDistance() {
		return distance;
	}

	/**
	 * @param distance the distance to set
	 */
	public void setDistance(double distance) {
		this.distance = distance;
	}

	/**
	 * @return
	 */
	public int getActivityScore() {
		return activityScore;
	}

	/**
	 * @param activityScore
	 */
	public void setActivityScore(int activityScore) {
		this.activityScore = activityScore;
	}

	/**
	 * @return
	 */
	public int getCaloriesOut() {
		return caloriesOut;
	}

	/**
	 * @param caloriesOut
	 */
	public void setCaloriesOut(int caloriesOut) {
		this.caloriesOut = caloriesOut;
	}

	/**
	 * @return
	 */
	public int getFloors() {
		return floors;
	}

	/**
	 * @param floors
	 */
	public void setFloors(int floors) {
		this.floors = floors;
	}

	/**
	 * @return
	 */
	public int getSteps() {
		return steps;
	}

	/**
	 * @param steps
	 */
	public void setSteps(int steps) {
		this.steps = steps;
	}
	
	  @Override
	  public String toString() {
	    return String.format("[%d] [%d] [%f] [%d] [%d] ", activityScore, caloriesOut, distance, floors, steps);
	  }

}
