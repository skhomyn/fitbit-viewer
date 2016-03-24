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
	private SPanel[] panelArray;
	private int count;

	private SPanel dailyCaloriesPanel;
	private SPanel dailyTotalDistPanel;
	private SPanel dailyActiveMinPanel;
	private SPanel dailySedMinPanel;
	private SPanel dailyFloorsPanel;
	private SPanel dailyStepsPanel;
	
	private SLabel lblDailyDistVal;
	private SLabel lblDailyCaloriesVal;
	private SLabel lblDailyStepsVal;
	private SLabel lblDailyFloorsVal;
	private SLabel lblDailySedenteryMinVal;
	private SLabel lblDailyVeryActMinVal;

	/**
	 * @param radioTotalDist
	 * @param radioCalories
	 * @param radioSedMin
	 * @param radioActiveMin
	 * @param radioFloors
	 * @param radioSteps
	 * @param panelArray
	 * @param count
	 * @param dailyCaloriesPanel
	 * @param dailyTotalDistPanel
	 * @param dailyActiveMinPanel
	 * @param dailySedMinPanel
	 * @param dailyFloorsPanel
	 * @param dailyStepsPanel
	 * @param lblDailyDistVal
	 * @param lblDailyCaloriesVal
	 * @param lblDailyStepsVal
	 * @param lblDailyFloorsVal
	 * @param lblDailySedenteryMinVal
	 * @param lblDailyVeryActMinVal
	 */
	public SettingsRecord(boolean radioTotalDist, boolean radioCalories,
			boolean radioSedMin, boolean radioActiveMin, boolean radioFloors,
			boolean radioSteps, SPanel[] panelArray, int count,
			SPanel dailyCaloriesPanel, SPanel dailyTotalDistPanel,
			SPanel dailyActiveMinPanel, SPanel dailySedMinPanel,
			SPanel dailyFloorsPanel, SPanel dailyStepsPanel,
			SLabel lblDailyDistVal, SLabel lblDailyCaloriesVal,
			SLabel lblDailyStepsVal, SLabel lblDailyFloorsVal,
			SLabel lblDailySedenteryMinVal, SLabel lblDailyVeryActMinVal) {
		super();
		this.radioTotalDist = radioTotalDist;
		this.radioCalories = radioCalories;
		this.radioSedMin = radioSedMin;
		this.radioActiveMin = radioActiveMin;
		this.radioFloors = radioFloors;
		this.radioSteps = radioSteps;
		this.panelArray = panelArray;
		this.count = count;
		this.dailyCaloriesPanel = dailyCaloriesPanel;
		this.dailyTotalDistPanel = dailyTotalDistPanel;
		this.dailyActiveMinPanel = dailyActiveMinPanel;
		this.dailySedMinPanel = dailySedMinPanel;
		this.dailyFloorsPanel = dailyFloorsPanel;
		this.dailyStepsPanel = dailyStepsPanel;
		this.lblDailyDistVal = lblDailyDistVal;
		this.lblDailyCaloriesVal = lblDailyCaloriesVal;
		this.lblDailyStepsVal = lblDailyStepsVal;
		this.lblDailyFloorsVal = lblDailyFloorsVal;
		this.lblDailySedenteryMinVal = lblDailySedenteryMinVal;
		this.lblDailyVeryActMinVal = lblDailyVeryActMinVal;
	}

	/**
	 * @return the lblDailyDistVal
	 */
	public SLabel getLblDailyDistVal() {
		return lblDailyDistVal;
	}

	/**
	 * @param lblDailyDistVal the lblDailyDistVal to set
	 */
	public void setLblDailyDistVal(SLabel lblDailyDistVal) {
		this.lblDailyDistVal = lblDailyDistVal;
	}

	/**
	 * @return the lblDailyCaloriesVal
	 */
	public SLabel getLblDailyCaloriesVal() {
		return lblDailyCaloriesVal;
	}

	/**
	 * @param lblDailyCaloriesVal the lblDailyCaloriesVal to set
	 */
	public void setLblDailyCaloriesVal(SLabel lblDailyCaloriesVal) {
		this.lblDailyCaloriesVal = lblDailyCaloriesVal;
	}

	/**
	 * @return the lblDailyStepsVal
	 */
	public SLabel getLblDailyStepsVal() {
		return lblDailyStepsVal;
	}

	/**
	 * @param lblDailyStepsVal the lblDailyStepsVal to set
	 */
	public void setLblDailyStepsVal(SLabel lblDailyStepsVal) {
		this.lblDailyStepsVal = lblDailyStepsVal;
	}

	/**
	 * @return the lblDailyFloorsVal
	 */
	public SLabel getLblDailyFloorsVal() {
		return lblDailyFloorsVal;
	}

	/**
	 * @param lblDailyFloorsVal the lblDailyFloorsVal to set
	 */
	public void setLblDailyFloorsVal(SLabel lblDailyFloorsVal) {
		this.lblDailyFloorsVal = lblDailyFloorsVal;
	}

	/**
	 * @return the lblDailySedenteryMinVal
	 */
	public SLabel getLblDailySedenteryMinVal() {
		return lblDailySedenteryMinVal;
	}

	/**
	 * @param lblDailySedenteryMinVal the lblDailySedenteryMinVal to set
	 */
	public void setLblDailySedenteryMinVal(SLabel lblDailySedenteryMinVal) {
		this.lblDailySedenteryMinVal = lblDailySedenteryMinVal;
	}

	/**
	 * @return the lblDailyVeryActMinVal
	 */
	public SLabel getLblDailyVeryActMinVal() {
		return lblDailyVeryActMinVal;
	}

	/**
	 * @param lblDailyVeryActMinVal the lblDailyVeryActMinVal to set
	 */
	public void setLblDailyVeryActMinVal(SLabel lblDailyVeryActMinVal) {
		this.lblDailyVeryActMinVal = lblDailyVeryActMinVal;
	}

	/**
	 * @return the dailyCaloriesPanel
	 */
	public SPanel getDailyCaloriesPanel() {
		return dailyCaloriesPanel;
	}

	/**
	 * @param dailyCaloriesPanel the dailyCaloriesPanel to set
	 */
	public void setDailyCaloriesPanel(SPanel dailyCaloriesPanel) {
		this.dailyCaloriesPanel = dailyCaloriesPanel;
	}

	/**
	 * @return the dailyTotalDistPanel
	 */
	public SPanel getDailyTotalDistPanel() {
		return dailyTotalDistPanel;
	}

	/**
	 * @param dailyTotalDistPanel the dailyTotalDistPanel to set
	 */
	public void setDailyTotalDistPanel(SPanel dailyTotalDistPanel) {
		this.dailyTotalDistPanel = dailyTotalDistPanel;
	}

	/**
	 * @return the dailyActiveMinPanel
	 */
	public SPanel getDailyActiveMinPanel() {
		return dailyActiveMinPanel;
	}

	/**
	 * @param dailyActiveMinPanel the dailyActiveMinPanel to set
	 */
	public void setDailyActiveMinPanel(SPanel dailyActiveMinPanel) {
		this.dailyActiveMinPanel = dailyActiveMinPanel;
	}

	/**
	 * @return the dailySedMinPanel
	 */
	public SPanel getDailySedMinPanel() {
		return dailySedMinPanel;
	}

	/**
	 * @param dailySedMinPanel the dailySedMinPanel to set
	 */
	public void setDailySedMinPanel(SPanel dailySedMinPanel) {
		this.dailySedMinPanel = dailySedMinPanel;
	}

	/**
	 * @return the dailyFloorsPanel
	 */
	public SPanel getDailyFloorsPanel() {
		return dailyFloorsPanel;
	}

	/**
	 * @param dailyFloorsPanel the dailyFloorsPanel to set
	 */
	public void setDailyFloorsPanel(SPanel dailyFloorsPanel) {
		this.dailyFloorsPanel = dailyFloorsPanel;
	}

	/**
	 * @return the dailyStepsPanel
	 */
	public SPanel getDailyStepsPanel() {
		return dailyStepsPanel;
	}

	/**
	 * @param dailyStepsPanel the dailyStepsPanel to set
	 */
	public void setDailyStepsPanel(SPanel dailyStepsPanel) {
		this.dailyStepsPanel = dailyStepsPanel;
	}

	/**
	 * @return the count
	 */
	public int getCount() {
		return count;
	}

	/**
	 * @param count the count to set
	 */
	public void setCount(int count) {
		this.count = count;
	}

	/**
	 * @return the panelArray
	 */
	public SPanel[] getPanelArray() {
		return panelArray;
	}

	/**
	 * @param panelArray the panelArray to set
	 */
	public void setPanelArray(SPanel[] panelArray) {
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
