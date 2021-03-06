package ca.uwo.csd.cs2212.team13;

import java.io.Serializable;


/**
 * <code>DistanceTS</code> is a simple Java object that represents the
 * DistanceTS and the rules that govern access to and updates of this data.
 */
public class DistanceTSRecord implements Serializable {

	/**
	 * date and time, value of the DistanceTS, array of records, the dataset interval and the dataset type
	 */
	private String dateTime;
	private double value;
	private DistanceRecord[] dRecords;
	private int datasetInterval;
	private String datasetType;

	/**
	 * @param dateTime
	 * 		the date's time
	 * @param value
	 * 		the value of the time
	 * @param dRecords
	 * 		the recorded times
	 * @param datasetInterval
	 * 		the intervals of time
	 * @param datasetType
	 * 		the data set type
	 */
	public DistanceTSRecord(String dateTime, double value,
			DistanceRecord[] dRecords, int datasetInterval, String datasetType) {
		super();
		this.dateTime = dateTime;
		this.value = value;
		this.dRecords = dRecords;
		this.datasetInterval = datasetInterval;
		this.datasetType = datasetType;
	}

	/**
	 * @return the dateTime
	 */
	public String getDateTime() {
		return dateTime;
	}

	/**
	 * @param dateTime
	 *            the dateTime to set
	 */
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	/**
	 * @return the value
	 */
	public double getValue() {
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(double value) {
		this.value = value;
	}

	/**
	 * @return the dRecords
	 */
	public DistanceRecord[] getdRecords() {
		return dRecords;
	}

	/**
	 * @param dRecords
	 *            the dRecords to set
	 */
	public void setdRecords(DistanceRecord[] dRecords) {
		this.dRecords = dRecords;
	}

	/**
	 * @return the datasetInterval
	 */
	public int getDatasetInterval() {
		return datasetInterval;
	}

	/**
	 * @param datasetInterval
	 *            the datasetInterval to set
	 */
	public void setDatasetInterval(int datasetInterval) {
		this.datasetInterval = datasetInterval;
	}

	/**
	 * @return the datasetType
	 */
	public String getDatasetType() {
		return datasetType;
	}

	/**
	 * @param datasetType
	 *            the datasetType to set
	 */
	public void setDatasetType(String datasetType) {
		this.datasetType = datasetType;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		final StringBuilder formatted = new StringBuilder();		
		formatted.append(dateTime + "\n");
		formatted.append(value + "\n");
		for (int i = 0; i<dRecords.length;i++)
			formatted.append(dRecords[i].toString() + "\n");
		formatted.append(datasetInterval + "\n");
		formatted.append(datasetType + "\n");
		return formatted.toString();
	}
}
