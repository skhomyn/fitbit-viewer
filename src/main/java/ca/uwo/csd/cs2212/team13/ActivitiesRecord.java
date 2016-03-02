/*
 * Copyright (c) 2016, Team Sharkzilla (13)
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *  * Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *
 *  * Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 *  * Neither the name of JSR-310 nor the names of its contributors
 *    may be used to endorse or promote products derived from this software
 *    without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package ca.uwo.csd.cs2212.team13;

/**
 * <code>ActivitiesRecord</code> is a simple Java object that contains the
 * models for both {@link BestDaysRecord} and {@link LifetimeRecord}
 * <p>
 * <ul>
 * <li>Is necessary because JSON call, for activities, contains both best days
 * and lifetime info i.e. JSON file has multiple objects!
 * <li>Basically, this Java object holds the combined activity record listed in
 * JSON object from API call
 * </ul>
 */
public class ActivitiesRecord {

	/**
	 * The Record for the Best Days
	 */
	private BestDaysRecord best;

	/**
	 * The Record for the Lifetime Totals
	 */
	private LifetimeRecord lifetime;

	/**
	 * Constructor, previously validated
	 * 
	 * @param best
	 *            the best days record from JSON file
	 * @param lifetime
	 *            the lifetime record from JSON file
	 */
	public ActivitiesRecord(BestDaysRecord best, LifetimeRecord lifetime) {
		super();
		this.best = best;
		this.lifetime = lifetime;
	}

	/**
	 * Gets the best field.
	 * <p>
	 * This method returns the {@code BestDaysRecord} value for the best days
	 * record.
	 * 
	 * @return the best day record
	 */
	public BestDaysRecord getBest() {
		return best;
	}

	/**
	 * Sets the best field.
	 * <p>
	 * This method sets the {@code BestDaysRecord} value for the field best.
	 * 
	 * @param best
	 *            the new value of the field best for the best days record
	 */
	public void setBest(BestDaysRecord best) {
		this.best = best;
	}

	/**
	 * Gets the lifetime field.
	 * <p>
	 * This method returns the {@code LifetimeRecord} value for the lifetime
	 * record.
	 * 
	 * @return the lifetime record
	 */
	public LifetimeRecord getLifetime() {
		return lifetime;
	}

	/**
	 * Sets the lifetime field.
	 * <p>
	 * This method sets the {@code LifetimeRecord} value for the field lifetime.
	 * 
	 * @param lifetime
	 *            the new value of the field lifetime for the lifetime record
	 */
	public void setLifetime(LifetimeRecord lifetime) {
		this.lifetime = lifetime;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		final StringBuilder formatted = new StringBuilder();
		formatted.append(best);
		formatted.append(lifetime);
		return formatted.toString();
	}
}
