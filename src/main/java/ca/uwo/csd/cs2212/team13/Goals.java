/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.uwo.csd.cs2212.team13;

/**
 *
 * @author kbhaskar
 */
public class Goals {
    
    private int activeMinutes;
    private double caloriesOut;
    private double distance;
    private int floors;
    private int steps;

    /**
     * @return the activeMinutes
     */
    public int getActiveMinutes() {
        return activeMinutes;
    }

    /**
     * @return the caloriesOut
     */
    public double getCaloriesOut() {
        return caloriesOut;
    }

    /**
     * @return the distance
     */
    public double getDistance() {
        return distance;
    }

    /**
     * @return the floors
     */
    public int getFloors() {
        return floors;
    }

    /**
     * @return the steps
     */
    public int getSteps() {
        return steps;
    }

    /**
     * @param activeMinutes the activeMinutes to set
     */
    public void setActiveMinutes(int activeMinutes) {
        this.activeMinutes = activeMinutes;
    }

    /**
     * @param caloriesOut the caloriesOut to set
     */
    public void setCaloriesOut(double caloriesOut) {
        this.caloriesOut = caloriesOut;
    }

    /**
     * @param distance the distance to set
     */
    public void setDistance(double distance) {
        this.distance = distance;
    }

    /**
     * @param floors the floors to set
     */
    public void setFloors(int floors) {
        this.floors = floors;
    }

    /**
     * @param steps the steps to set
     */
    public void setSteps(int steps) {
        this.steps = steps;
    }
    
    @Override
	  public String toString() {
		  final StringBuilder formatted = new StringBuilder();
		    formatted.append(steps);
		    formatted.append("\n");
		    formatted.append(floors);
		    formatted.append("\n");
		    formatted.append(caloriesOut);
		    formatted.append("\n");
		    formatted.append(activeMinutes);
		    formatted.append("\n");
		    formatted.append(distance);
		    return formatted.toString();
		  }
    
}
