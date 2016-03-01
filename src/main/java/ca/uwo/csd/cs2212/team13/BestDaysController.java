package ca.uwo.csd.cs2212.team13;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BestDaysController {
	
	//properties
	BestDaysRecord model;
	private InterfaceView view;

	//constructor; the controller is initialized with a call from Main.java
	public BestDaysController(BestDaysRecord model, InterfaceView view) {
		this.model = model;
		this.view = view;
		
		//call method in view to add an event listener to the lifetime totals button 
		view.addClickListenerBestDays(new clickListener());
	}
	
	//this is the class definition for the action listener object that we pass to the above method;
	//it says that whenever an action is observed (click), set the view fields with the model info;
	// this class is instantiated in the call above, when the controller is initialized
	class clickListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			view.setBestDaysFields(model.getDis_value(), model.getFloors_value(), model.getSteps_value(), model.getDis_date(), model.getFloors_date(), model.getSteps_date());
			
		}
	}
	
	//error handling to be added
 }	
	