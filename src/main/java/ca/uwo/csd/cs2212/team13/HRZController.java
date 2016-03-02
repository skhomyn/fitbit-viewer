package ca.uwo.csd.cs2212.team13;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ca.uwo.csd.cs2212.team13.LifetimeController.clickListener;

/**
 * Controller for the Heart Rate Zones page
 * @author Jennifer
 */

public class HRZController {

	/**properties
	 * HRZone is a model for only the heart rate zones
	 * HRZmodel models the entire page (minutes, resting 
	 * heart rate, and the zones)
	 */

		private HeartRateRecord model;
		private InterfaceView view;
		
		/** constructor
		 * Creates a controller object using model and view
		 * @param mod
		 * @param vw
		 */
		public HRZController(HeartRateRecord mod, InterfaceView vw) {
			this.model = mod;
			this.view = vw;
			
			//call method in view to add an event listener to the lifetime totals button 
			view.addClickListenerHeartRateZones(new clickListener());
		}
		
		class clickListener implements ActionListener{
			/**clickListener class
			 * used to make our buttons 'clickable'
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				view.setHeartRateZonesFields(model.getMinuteTotal(), model.getRestingHR(), model.getCardioZone().getMax(), model.getFatBurnZone().getMax(), model.getPeakZone().getMax(), model.getCardioZone().getMin(), model.getFatBurnZone().getMin(), model.getPeakZone().getMin() );
			}
			
			/**
			 * TODO: error handling
			 */
		}
}