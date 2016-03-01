package ca.uwo.csd.cs2212.team13;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ca.uwo.csd.cs2212.team13.LifetimeController.clickListener;

public class HRZController {

	/**properties
	 * HRZone is a model for only the heart rate zones
	 * HRZmodel models the entire page (minutes, resting 
	 * heart rate, and the zones)
	 */
		private HeartZoneRecord zoneModel;
		private HeartRateRecord model;
		private InterfaceView view;
		
		//constructor; the controller is initialized with a call from Main.java
		public HRZController(HeartZoneRecord zMod, HeartRateRecord mod, InterfaceView vw) {
			this.model = mod;
			this.zoneModel = zMod;
			this.view = vw;
			
			//call method in view to add an event listener to the lifetime totals button 
			view.addClickListenerLifetimeTotals(new clickListener());
		}
		
		class clickListener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				view.setHeartRateZonesFields(HeartZoneRecord.getMinutes(), HeartZoneRecord.getMax());
			}
			
			//error handling will go here
		}
}
