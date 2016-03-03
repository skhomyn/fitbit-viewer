/*
 * Copyright (c) 2016, Team Sharkzilla (13)
 */
package ca.uwo.csd.cs2212.team13;

/**
 * <code>Goals</code> is a simple Java object that represents the
 * goals and the rules that govern access to and updates of this data.
 */
public class Goals {
    
	/**
	 * The active minutes goal
	 */
    private int activeMinutes;
    /**
	 * The calories goal
	 */
    private double caloriesOut;
    /**
	 * The distance goal
	 */
    private double distance;
    /**
   	 * The floors goal
   	 */
    private int floors;
    /**
   	 * The steps goal
   	 */
    private int steps;

    
    
	/**
	 * Gets the <code>active minutes goal</code> field.
	 * <p>
	 * This method returns the {@code int} value for the distance.
	 * 
	 * @return the active minutes goal
	 */
    public int getActiveMinutes() {
        return activeMinutes;
    }

    /**
	 * Gets the <code>calories goal</code> field.
	 * <p>
	 * This method returns the {@code double} value for the distance.
	 * 
	 * @return the calories goal
	 */
    public double getCaloriesOut() {
        return caloriesOut;
    }

    /**
   	 * Gets the <code>distance goal</code> field.
   	 * <p>
   	 * This method returns the {@code double} value for the distance.
   	 * 
   	 * @return the distance goal
   	 */
    public double getDistance() {
        return distance;
    }

    /**
   	 * Gets the <code>floors goal</code> field.
   	 * <p>
   	 * This method returns the {@code int} value for the distance.
   	 * 
   	 * @return the floors goal
   	 */
    public int getFloors() {
        return floors;
    }

    /**
   	 * Gets the <code>steps goal</code> field.
   	 * <p>
   	 * This method returns the {@code int} value for the distance.
   	 * 
   	 * @return the steps goal
   	 */
    public int getSteps() {
        return steps;
    }

    /**
	 * Sets the {@code active minutes} field.
	 * <p>
	 * This method sets the {@code int} value for the field {@code distance}.
	 * 
	 * @param active minutes
	 *            the new value of the field {@code active minutes} for the goal
	 */
    public void setActiveMinutes(int activeMinutes) {
        this.activeMinutes = activeMinutes;
    }

    /**
   	 * Sets the {@code calories out} field.
   	 * <p>
   	 * This method sets the {@code double} value for the field {@code distance}.
   	 * 
   	 * @param calories out
   	 *            the new value of the field {@code calories} for the goal
   	 */
    public void setCaloriesOut(double caloriesOut) {
        this.caloriesOut = caloriesOut;
    }

    /**
   	 * Sets the {@code distance} field.
   	 * <p>
   	 * This method sets the {@code double} value for the field {@code distance}.
   	 * 
   	 * @param distance
   	 *            the new value of the field {@code distance} for the goal
   	 */
    public void setDistance(double distance) {
        this.distance = distance;
    }

    /**
   	 * Sets the {@code floors} field.
   	 * <p>
   	 * This method sets the {@code int} value for the field {@code distance}.
   	 * 
   	 * @param floors
   	 *            the new value of the field {@code floors} for the goal
   	 */
    public void setFloors(int floors) {
        this.floors = floors;
    }

    /**
   	 * Sets the {@code steps} field.
   	 * <p>
   	 * This method sets the {@code int} value for the field {@code distance}.
   	 * 
   	 * @param steps
   	 *            the new value of the field {@code steps} for the goal
   	 */
    public void setSteps(int steps) {
        this.steps = steps;
    }
    
  
}
