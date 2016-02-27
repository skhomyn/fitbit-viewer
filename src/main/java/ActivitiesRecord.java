
public class ActivitiesRecord {
	
	private BestRecord best;
	private LifetimeRecord lifetime;
	
	/**
	 * @param best
	 * @param lifetime
	 */
	public ActivitiesRecord(BestRecord best, LifetimeRecord lifetime) {
		super();
		this.best = best;
		this.lifetime = lifetime;
	}
	/**
	 * @return the best
	 */
	public BestRecord getBest() {
		return best;
	}
	/**
	 * @param best the best to set
	 */
	public void setBest(BestRecord best) {
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
