package ca.uwo.csd.cs2212.team13;

import java.io.Serializable;

import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class SettingsRecord implements Serializable {


	private boolean radioTotalDist;
	private boolean radioCalories;
	private boolean radioSedMin;
	private boolean radioActiveMin;
	private boolean radioFloors;
	private boolean radioSteps;
	private JPanel[] panelArray;

	
	/**
	 * @param radioTotalDist
	 * @param radioCalories
	 * @param radioSedMin
	 * @param radioActiveMin
	 * @param radioFloors
	 * @param radioSteps
	 */
	public SettingsRecord(boolean radioTotalDist, boolean radioCalories,
			boolean radioSedMin, boolean radioActiveMin, boolean radioFloors,
			boolean radioSteps, JPanel panelArray[]) {
		super();
		this.radioTotalDist = radioTotalDist;
		this.radioCalories = radioCalories;
		this.radioSedMin = radioSedMin;
		this.radioActiveMin = radioActiveMin;
		this.radioFloors = radioFloors;
		this.radioSteps = radioSteps;
		this.panelArray = panelArray;
	}

	/**
	 * @return the panelArray
	 */
	public JPanel[] getPanelArray() {
		return panelArray;
	}

	/**
	 * @param panelArray the panelArray to set
	 */
	public void setPanelArray(JPanel[] panelArray) {
		this.panelArray = panelArray;
	}

	/**
	 * @return the radioTotalDist
	 */
	public boolean isRadioTotalDist() {
		return radioTotalDist;
	}

	/**
	 * @param radioTotalDist
	 *            the radioTotalDist to set
	 */
	public void setRadioTotalDist(boolean radioTotalDist) {
		this.radioTotalDist = radioTotalDist;
	}

	/**
	 * @return the radioCalories
	 */
	public boolean isRadioCalories() {
		return radioCalories;
	}

	/**
	 * @param radioCalories
	 *            the radioCalories to set
	 */
	public void setRadioCalories(boolean radioCalories) {
		this.radioCalories = radioCalories;
	}

	/**
	 * @return the radioSedMin
	 */
	public boolean isRadioSedMin() {
		return radioSedMin;
	}

	/**
	 * @param radioSedMin
	 *            the radioSedMin to set
	 */
	public void setRadioSedMin(boolean radioSedMin) {
		this.radioSedMin = radioSedMin;
	}

	/**
	 * @return the radioActiveMin
	 */
	public boolean isRadioActiveMin() {
		return radioActiveMin;
	}

	/**
	 * @param radioActiveMin
	 *            the radioActiveMin to set
	 */
	public void setRadioActiveMin(boolean radioActiveMin) {
		this.radioActiveMin = radioActiveMin;
	}

	/**
	 * @return the radioFloors
	 */
	public boolean isRadioFloors() {
		return radioFloors;
	}

	/**
	 * @param radioFloors
	 *            the radioFloors to set
	 */
	public void setRadioFloors(boolean radioFloors) {
		this.radioFloors = radioFloors;
	}

	/**
	 * @return the radioSteps
	 */
	public boolean isRadioSteps() {
		return radioSteps;
	}

	/**
	 * @param radioSteps
	 *            the radioSteps to set
	 */
	public void setRadioSteps(boolean radioSteps) {
		this.radioSteps = radioSteps;
	}

}
