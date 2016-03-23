package ca.uwo.csd.cs2212.team13;

public class StepsTSRecord {

	private String dateTime;
	private double value;
	private StepsRecord[] sRecords;
	private int datasetInterval;
	private String datasetType;

	/**
	 * @param dateTime
	 * @param value
	 * @param sRecords
	 * @param datasetInterval
	 * @param datasetType
	 */
	public StepsTSRecord(String dateTime, double value,
			StepsRecord[] sRecords, int datasetInterval, String datasetType) {
		super();
		this.dateTime = dateTime;
		this.value = value;
		this.sRecords = sRecords;
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
	public StepsRecord[] getsRecords() {
		return sRecords;
	}

	/**
	 * @param dRecords
	 *            the dRecords to set
	 */
	public void setsRecords(StepsRecord[] sRecords) {
		this.sRecords = sRecords;
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
		for (int i = 0; i<sRecords.length;i++)
			formatted.append(sRecords[i].toString() + "\n");
		formatted.append(datasetInterval + "\n");
		formatted.append(datasetType + "\n");
		return formatted.toString();
	}
}