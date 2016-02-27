package ca.uwo.csd.cs2212.team13;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LifetimeController {
	
	//properties
	private LifetimeRecord model;
	private LifetimeView view;

	//constructor
	public LifetimeController(LifetimeRecord model, LifetimeView view) {
		this.model = model;
		this.view = view;
		
		//call method in view to add an event listener to the
		// refresh (or lifetime totals) button in the side menu
		view.addRefreshListener(new RefreshListener());
	}
	
	//action methods
	public void updateView() {
		view.setDistance(model.getDistance());
		view.setFloors(model.getFloors());
		view.setSteps(model.getSteps());
	}
	
	//refresh listener implementation (lifetime totals button in side menu)
	class RefreshListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			updateView();	
		}
		
	}
	
	//error handling to be added
 }	
	
