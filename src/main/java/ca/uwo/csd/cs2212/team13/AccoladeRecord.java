/* Copyright (c) 2016, Team Sharkzilla (13) */
package ca.uwo.csd.cs2212.team13;

/**
 * Class to represent model of 
 * Accolades page
 * @author Jennifer
 */

public class AccoladeRecord {
	
	//true/false value for if you have acquired accolade or not
	private boolean achieved; 
	private String date;
	
	//value associated with each image
	private int value;
	private String image;
	
	//type of image
	private String type;
	
	/** 
	 * Constructor
	 */
	public AccoladeRecord() {
		//what even goes here
	}
	
	/**
	 * Getter for achievement
	 * @return true if achieved accolade, false otherwise
	 */
	private boolean getAchieved() {
		return achieved;
	}
	
	/**
	 * Set achievement
	 * @param a
	 */
	private void setAchieved(boolean a) {
		this.achieved = a;
	}
	
	/**
	 * Get the current date
	 * @return date
	 */
	private String getDate() {
		return date;
	}
	
	/**
	 * Set the date
	 * @param d
	 */
	private void setDate(String d) {
		this.date = d;
	}
	
	/**
	 * Getter for value of image
	 * @return image's value
	 */
	private int getValue() {
		return value;
	}
	
	/**
	 * Set image's value
	 * @param v
	 */
	private void setValue(int v) {
		this.value = v;
	}
	
	/**
	 * @return String of image's location
	 */
	private String getImage() {
		return image;
	}
	
	/**
	 * set image via string
	 * @param i
	 */
	private void setImage(String i) {
		this.image = i;
	}
	
	/**
	 * @return type of image
	 */
	private String getType() {
		return type;
	}
	
	/**
	 * set the type of the image
	 * @param t
	 */
	private void setType(String t) {
		this.type = t;
	}
}