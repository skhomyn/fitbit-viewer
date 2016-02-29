package ca.uwo.csd.cs2212.team13;


public class DailyDashboardModel {

private double distance;
private int calories;
private int floors;
private int steps;
private int activeMin;
private int sedenteryMin;
	
	public DailyDashboardModel(double distance, int calories, int floors, int steps, int activeMin, int sedenteryMin){
		this.distance = distance;
		this.calories = calories;
		this.floors = floors;
		this.steps = steps;
		this.activeMin = activeMin;
		this.sedenteryMin = sedenteryMin;
		
	}
	
	public int getCalories(){
		return calories;
	}
	
	public double getDistance(){
		return distance;
	}
	
	public int getFloors(){
		return floors;
	}
	
	public int getSteps(){
		return steps;
	}
	
	public int getActiveMin(){
		return activeMin;
	}
	
	public int getSedenteryMin(){
		return sedenteryMin;
	}
	
	
	
	
}
