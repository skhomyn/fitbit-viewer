package ca.uwo.csd.cs2212.team13;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DailyDashboardController {
	
	private DailyRecord model;
	private InterfaceView view;
	
	public DailyDashboardController(DailyRecord model, InterfaceView view){
		this.model = model;
		this.view = view;
		view.addClickListenerDashboard(new clickListener());
	}
	
	class clickListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			view.setDailyDashFields(model.getDistance(), model.getCalories(), model.getFloors(), model.getSteps(), model.getVeryActiveMinutes(), model.getSedentaryMinutes());
		}
		
	}
}
