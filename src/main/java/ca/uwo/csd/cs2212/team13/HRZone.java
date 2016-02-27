package ca.uwo.csd.cs2212.team13;

//this class is for the 4 different zones
public class HRZone {

	//heart rate zone
	private HRZmodel cardioZone = new HRZmodel(HRZmodel.getHRMinutes(), "Cardio", HRZmodel.getHRRate());
	private HRZmodel fatBurnZone = new HRZmodel(HRZmodel.getHRMinutes(), "Fat Burn", HRZmodel.getHRRate());
	private HRZmodel OutOfRangeZone = new HRZmodel(HRZmodel.getHRMinutes(), "Out of Range", HRZmodel.getHRRate());
	private HRZmodel peakZone = new HRZmodel(HRZmodel.getHRMinutes(), "Peak", HRZmodel.getHRRate());

	//constructor which populates fields with data from API call
	HRZone() {
		super();
	}

	public HRZmodel getCardioZone() {
		return cardioZone;
	}

	public void setCardioZone(HRZmodel cardioZone) {
		this.cardioZone = cardioZone;
	}

	public HRZmodel getFatBurnZone() {
		return fatBurnZone;
	}

	public void setFatBurnZone(HRZmodel fatBurnZone) {
		this.fatBurnZone = fatBurnZone;
	}

	public HRZmodel getOutOfRangeZone() {
		return OutOfRangeZone;
	}

	public void setOutOfRangeZone(HRZmodel outOfRangeZone) {
		OutOfRangeZone = outOfRangeZone;
	}

	public HRZmodel getPeakZone() {
		return peakZone;
	}

	public void setPeakZone(HRZmodel peakZone) {
		this.peakZone = peakZone;
	}

	//toString method 
	  public String toString() {
		    return String.format("[%s] [%s] [%s] [%s]", cardioZone, fatBurnZone, OutOfRangeZone, peakZone);
		  }
}