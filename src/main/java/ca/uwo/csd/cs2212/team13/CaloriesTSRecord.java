package ca.uwo.csd.cs2212.team13;

/**
 * Model class for time series
 * calories
 * @author Andy
 *
 */
public class CaloriesTSRecord {

    private String dateTime;
    private double value;
    private CaloriesRecord[] cRecords;
    private int datasetInterval;
    private String datasetType;

    /**
     * @param dateTime
     * @param value
     * @param cRecords
     * @param datasetInterval
     * @param datasetType
     */
    public CaloriesTSRecord(String dateTime, double value,
                            CaloriesRecord[] cRecords, int datasetInterval, String datasetType) {
        super();
        this.dateTime = dateTime;
        this.value = value;
        this.cRecords = cRecords;
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
    public CaloriesRecord[] getdRecords() {
        return cRecords;
    }

    /**
     * @param dRecords
     *            the dRecords to set
     */
    public void setdRecords(CaloriesRecord[] dRecords) {
        this.cRecords = cRecords;
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
        for (int i = 0; i<cRecords.length;i++)
            formatted.append(cRecords[i].toString() + "\n");
        formatted.append(datasetInterval + "\n");
        formatted.append(datasetType + "\n");
        return formatted.toString();
    }
}
