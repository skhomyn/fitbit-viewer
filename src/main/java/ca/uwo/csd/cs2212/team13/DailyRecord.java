package ca.uwo.csd.cs2212.team13;

public class DailyRecord {
	
	private int floors, steps, lightlyActiveMinutes, fairlyActiveMinutes, sedentaryMinutes, veryActiveMinutes;
	
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
	
	public setFloors(int floors) {
		this.floors = floors;
	}
	
	public setSteps(int steps){
		this.steps = steps;
	}
	
	public setLightlyActiveMinutes(int LightlyActiveMinutes){
		this.lightlyActiveMinutes = lightlyActiveMinutes;
	}
	
	public setFairlyActiveMinutes(int FairlyActiveMinutes){
		this.fairlyActiveMinutes = fairlyActiveMinutes;
	}
	
	public setSedentaryMinutes(int SedentaryMinutes){
		this.sedentaryMinutes = sedentaryMinutes;
	}
	
	public setVeryActiveMinutes(int VeryActiveMinutes ){
		this.veryActiveMinutes = veryActiveMinutes;
	}
	
	

}