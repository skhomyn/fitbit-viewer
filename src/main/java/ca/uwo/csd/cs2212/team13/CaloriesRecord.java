package ca.uwo.csd.cs2212.team13;

public class CaloriesRecord {
	
	/**
	 * Model class for the Calories
	 */

    private String time;
    private double value;
    private int mets;

    /**
     * @return the time
     */
    public String getTime() {
        return time;
    }

    /**
     * @param time (the time to set)
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * get Mets
     * @return
     */
    public int getMets() {
        return mets;
    }

    /**
     * @param mets (the mets to set)
     */
    public void setMets(int mets) {
        this.mets = mets;
    }

    /**
     * @return the value
     */
    public double getValue() {
        return value;
    }

    /**
     * @param value (the value to set)
     */
    public void setValue(double value) {
        this.value = value;
    }

    /**
     * Constructor
     * @param time
     * @param value
     */
    public CaloriesRecord(String time, double value, int mets) {
        super();
        this.time = time;
        this.value = value;
        this.mets = mets;
    }

    public CaloriesRecord() {

    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    /**
     * toString method to convert attributes 
     * into a string
     */
    public String toString() {
        final StringBuilder formatted = new StringBuilder();
        formatted.append(mets + "\n");
        formatted.append(time + "\n");
        formatted.append(value + "\n");
        return formatted.toString();
    }
}
