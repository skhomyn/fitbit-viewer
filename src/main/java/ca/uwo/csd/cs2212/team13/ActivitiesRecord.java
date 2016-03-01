package ca.uwo.csd.cs2212.team13;

public class ActivitiesRecord {
	
	private BestDaysRecord best;
	private LifetimeRecord lifetime;
	
	/**
	 * @param best
	 * @param lifetime
	 */
	public ActivitiesRecord(BestDaysRecord best, LifetimeRecord lifetime) {
		super();
		this.best = best;
		this.lifetime = lifetime;
	}
	/**
	 * @return the best
	 */
	public BestDaysRecord getBest() {
		return best;
	}
	/**
	 * @param best the best to set
	 */
	public void setBest(BestDaysRecord best) {
		this.best = best;
	}
	/**
	 * @return the lifetime
	 */
	public LifetimeRecord getLifetime() {
		return lifetime;
	}
	/**
	 * @param lifetime the lifetime to set
	 */
	public void setLifetime(LifetimeRecord lifetime) {
		this.lifetime = lifetime;
	}
	  @Override
	  public String toString() {
		  final StringBuilder formatted = new StringBuilder();
		    formatted.append(best);
		    formatted.append(lifetime);
		    return formatted.toString();
		  }
}
