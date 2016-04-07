/* Copyright (c) 2016, Team Sharkzilla (13) */
package ca.uwo.csd.cs2212.team13;

import java.io.Serializable;

/**
 * Class to represent model of 
 * Accolades page
 * @author Jennifer
 */

public class AccoladeRecord implements Serializable {

	/**
	 * True/false if achieved value or not and the date
	 */
	private boolean achieved; 
	private String date;

	/**
	 * value associated with each image
	 */
	private int value;
	private String image;

	/**
	 * desc
	 */
	private String desc;
	

	/**
	 * @return the desc
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * @param desc the desc to set
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}

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
	public AccoladeRecord(boolean achieved, String date, int value, String image, String type,  String desc) {
		this.achieved = achieved;
		this.date = date;
		this.value = value;
		this.image = image;
		this.type = type;
		this.desc = desc;
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
	 * @param a t or f
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
	 * @param d the date
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
	 * @param v image value
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
	 * @param i image as string
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
	 * @param t type of the image
	 */
	public void setType(String t) {
		this.type = t;
	}
}