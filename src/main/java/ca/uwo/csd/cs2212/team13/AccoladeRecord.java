/* Copyright (c) 2016, Team Sharkzilla (13) */
package ca.uwo.csd.cs2212.team13;

import java.io.Serializable;

/**
 * Class to represent model of 
 * Accolades page
 * @author Jennifer
 */

public class AccoladeRecord implements Serializable {
	
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
	 * Constructor
	 */
	public AccoladeRecord(boolean achieved, String date, int value, String image, String type) {
		this.achieved = achieved;
		this.date = date;
		this.value = value;
		this.image = image;
		this.type = type;
	}
	
	/**
	 * Getter for achievement
	 * @return true if achieved accolade, false otherwise
	 */
	public boolean getAchieved() {
		return achieved;
	}
	
	/**
	 * Set achievement
	 * @param a
	 */
	public void setAchieved(boolean a) {
		this.achieved = a;
	}
	
	/**
	 * Get the current date
	 * @return date
	 */
	public String getDate() {
		return date;
	}
	
	/**
	 * Set the date
	 * @param d
	 */
	public void setDate(String d) {
		this.date = d;
	}
	
	/**
	 * Getter for value of image
	 * @return image's value
	 */
	public int getValue() {
		return value;
	}
	
	/**
	 * Set image's value
	 * @param v
	 */
	public void setValue(int v) {
		this.value = v;
	}
	
	/**
	 * @return String of image's location
	 */
	public String getImage() {
		return image;
	}
	
	/**
	 * set image via string
	 * @param i
	 */
	public void setImage(String i) {
		this.image = i;
	}
	
	/**
	 * @return type of image
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * set the type of the image
	 * @param t
	 */
	public void setType(String t) {
		this.type = t;
	}
}