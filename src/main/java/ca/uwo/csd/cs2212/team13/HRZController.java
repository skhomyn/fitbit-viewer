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
		//private HeartZoneRecord zoneModel;
		private HeartRateRecord model;
		private InterfaceView view;
		
		//constructor; the controller is initialized with a call from Main.java
		public HRZController(HeartRateRecord mod, InterfaceView vw) {
			this.model = mod;
			//this.zoneModel = mod.getCardioZone();
			this.view = vw;
			
		//	System.out.println(zoneModel.getMinutes());
			
			//call method in view to add an event listener to the lifetime totals button 
			view.addClickListenerHeartRateZones(new clickListener());
		}
		
		class clickListener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				//
				view.setHeartRateZonesFields(model.getMinuteTotal(), model.getRestingHR(), model.getCardioZone().getMin(), model.getFatBurnZone().getMin(), model.getPeakZone().getMin() );
			}
			
			//error handling will go here
		}
}
