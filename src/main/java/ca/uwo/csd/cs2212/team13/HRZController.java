package ca.uwo.csd.cs2212.team13;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 
 * @author Jenni
 * based off of LifetimeController class
 */

public class HRZController {
	
	//attributes
	private HeartRateRecord model;
	private HeartZoneRecord zoneModel;
	private InterfaceView view;
	
	//constructor
	public HRZController(HeartRateRecord mod, HeartZoneRecord zoneMod, InterfaceView v) {
		this.model = mod;
		this.zoneModel = zoneMod;
		this.view = v;
		
		//call method in view to add an event listener to the lifetime totals button 
		//clickListener not recognized??
				//view.addClickListenerHeartRateZones(new clickListener());
	}
	
	class clickListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			//need to add this to InterfaceView
			//view.setHeartRateZoneFields(model.getHeart_zones(), model.getDate());
		}
		
		//TODO: error handling
	}
}
