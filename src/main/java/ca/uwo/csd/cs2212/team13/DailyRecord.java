package ca.uwo.csd.cs2212.team13;

public class DailyRecord {
	
	private int floors, steps, lightlyActiveMinutes, fairlyActiveMinutes, sedentaryMinutes, veryActiveMinutes, calories;
	private double distance;
	private Goals goals;
	private String date;
	
	
	
        /**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}
	
		public Goals getGoals(){
            return goals;
        } 
	public int getFloors() {
		return floors;
	}
	
	public int getSteps(){
		return steps;
	}
	
	public int getLightlyActiveMinutes(){
		return lightlyActiveMinutes;
	}
	
	public int getFairlyActiveMinutes(){
		return fairlyActiveMinutes;
	}
	
	public int getSedentaryMinutes(){
		return sedentaryMinutes;
	}
	
	public int getVeryActiveMinutes(){
		return veryActiveMinutes;
	}
        
	public int getCalories(){
		return calories;
	}

	public double getDistance(){
		return distance;
	}

    public void setGoals(Goals goals){
            this.goals = goals;
    }
	
	public void setFloors(int floors) {
		this.floors = floors;
	}
	
	public void setSteps(int steps){
		this.steps = steps;
	}
	
	public void setLightlyActiveMinutes(int LightlyActiveMinutes){
		this.lightlyActiveMinutes = LightlyActiveMinutes;
	}
	
	public void setFairlyActiveMinutes(int FairlyActiveMinutes){
		this.fairlyActiveMinutes = FairlyActiveMinutes;
	}
	
	public void setSedentaryMinutes(int SedentaryMinutes){
		this.sedentaryMinutes = SedentaryMinutes;
	}
	
	public void setVeryActiveMinutes(int VeryActiveMinutes ){
		this.veryActiveMinutes = VeryActiveMinutes;
	}

	public void setCalories(int calories){
		this.calories = calories;
	}

	public void setDistance(double distance){
		this.distance = distance;
	}
	
	

}