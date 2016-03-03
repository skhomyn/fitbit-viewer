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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ca.uwo.csd.cs2212.team13.LifetimeController.clickListener;

/**
 * Java Object which passes information from the the
 * <code>HeartRateRecord</code> object to the <code>InterfaceView</code> object.
 * <p>
 * <code>HRZController</code> contains references to the model object
 * {@link HeartRateRecord}, which contains the data for the Heart Rate page (and
 * heart zones), and the view object {@link InterfaceView}, which implements the
 * user interface for all pages.
 * <p>
 * The purpose of this class is to pass the data contained in the model
 * <code>HeartRateRecord</code> and <code>HeartZoneRecord</code> to the view
 * <code>InterfaceView</code>, so that it can be displayed to the user.
 */
public class HRZController {

	/**
	 * HeartRateRecord model for the whole heart rate page (minutes, resting
	 * heart rate, and the zones)
	 */
	private HeartRateRecord model;
	/**
	 * View as that is the view for entire page.
	 */
	private InterfaceView view;

	/**
	 * Constructor, initializes the model and view fields with pointers to
	 * <code>HeartRateRecord</code> object and <code>InterfaceView</code> object
	 * respectively, and calls method
	 * {@link InterfaceView#addClickListenerHeartRateZones(ActionListener)} to
	 * add a click listener to the HeartRate Zones button.
	 * 
	 * @param mod
	 *            the <code>HeartRateRecord</code> model containing the heart
	 *            rate data to be displayed
	 * @param vw
	 *            the <code>InterfaceView</code> view containing the user
	 *            interface implementation
	 * 
	 * @see InterfaceView#addClickListenerHeartRateZones(ActionListener)
	 */
	public HRZController(HeartRateRecord mod, InterfaceView vw) {
		this.model = mod;
		this.view = vw;

		// call method in view to add an event listener to the lifetime totals
		// button
		view.addClickListenerHeartRateZones(new clickListener());
	}

	/**
	 * Local class accessible only by the <code>HRZController</code> object. Its
	 * purpose is to define which actions should be performed when the Heart
	 * Zones button in <code>InterfaceView</code> is clicked by the user
	 *
	 * @see java.awt.event.ActionListener
	 */
	class clickListener implements ActionListener {

		/*
		 * (non-Java doc) as override
		 * 
		 * Sets the Heart Rate zones display fields in
		 * <code>InterfaceView</code> with values from the appropriate model
		 * <code>HeartRateRecord</code> fields upon the click of a button.
		 * 
		 * @param e click action on button
		 * 
		 * @see
		 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent
		 * )
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			view.setHeartRateZonesFields(model.getMinuteTotal(), model
					.getRestingHR(), model.getCardioZone().getMax(), model
					.getFatBurnZone().getMax(), model.getPeakZone().getMax(),
					model.getCardioZone().getMin(), model.getFatBurnZone()
							.getMin(), model.getPeakZone().getMin());
		}

		// TODO: error handling
	}
}