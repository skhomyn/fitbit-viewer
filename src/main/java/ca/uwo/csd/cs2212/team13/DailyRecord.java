package ca.uwo.csd.cs2212.team13;

public class DailyRecord {
	
	private int floors, steps, lightlyActiveMinutes, fairlyActiveMinutes, sedentaryMinutes, veryActiveMinutes;
	
	DailyRecord()
	{
		
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
	
	public void setFloors(int floors) {
		this.floors = floors;
	}
	
	public void setSteps(int steps){
		this.steps = steps;
	}
	
	public void setLightlyActiveMinutes(int LightlyActiveMinutes){
		this.lightlyActiveMinutes = lightlyActiveMinutes;
	}
	
	public void setFairlyActiveMinutes(int FairlyActiveMinutes){
		this.fairlyActiveMinutes = fairlyActiveMinutes;
	}
	
	public void setSedentaryMinutes(int SedentaryMinutes){
		this.sedentaryMinutes = sedentaryMinutes;
	}
	
	public void setVeryActiveMinutes(int VeryActiveMinutes ){
		this.veryActiveMinutes = veryActiveMinutes;
	}
	
	

}