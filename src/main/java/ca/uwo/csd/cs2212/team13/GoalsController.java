package ca.uwo.csd.cs2212.team13;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GoalsController {
	
	private GoalsRecord model;
	private InterfaceView view;
	
	GoalsController(GoalsRecord model, InterfaceView view){
		this.model = model;
		this.view = view;
		
		view.addClickListenerGoals(new clickListener());
		
	}
	
	class clickListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			view.setDailyGoalsFields(model.getActiveMinutes(), model.getCaloriesOut(), 
					model.getDistance(), model.getFloors(), model.getSteps());	
		}
		
	}
	
}