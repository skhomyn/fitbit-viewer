package ca.uwo.csd.cs2212.team13;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GoalsController {
	
	private DailyRecord dailyModel;
	private GoalsRecord goalsModel;
	private InterfaceView view;
	
	GoalsController(DailyRecord dailyModel, GoalsRecord goalsModel, InterfaceView view){
		this.dailyModel = dailyModel;
		this.goalsModel = goalsModel;
		this.view = view;
		
		view.addClickListenerGoals(new clickListener());
		
	}
	/**
	 * Sets the Daily Dashboard page display fields in
	 * <code>InterfaceView</code> with values from the appropriate model
	 * <code>DailyRecord</code> fields.
	 */
	public void goalsInitialize() {
		view.setDailyGoalsFields(goalsModel.getActiveMinutes(), goalsModel.getCaloriesOut(), 
				goalsModel.getDistance(), goalsModel.getFloors(), goalsModel.getSteps(),
				compareDouble(goalsModel.getActiveMinutes(), dailyModel.getVeryActiveMinutes()),
				compareDoubleInt(goalsModel.getCaloriesOut(), dailyModel.getCalories()),
				compareDouble(goalsModel.getDistance(), dailyModel.getDistance()),
				compareInt(goalsModel.getFloors(), dailyModel.getFloors()),
				compareInt(goalsModel.getSteps(), dailyModel.getSteps())
				);
	}
	
	class clickListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			view.setDailyGoalsFields(goalsModel.getActiveMinutes(), goalsModel.getCaloriesOut(), 
					goalsModel.getDistance(), goalsModel.getFloors(), goalsModel.getSteps(),
					compareDouble(goalsModel.getActiveMinutes(), dailyModel.getVeryActiveMinutes()),
					compareDoubleInt(goalsModel.getCaloriesOut(), dailyModel.getCalories()),
					compareDouble(goalsModel.getDistance(), dailyModel.getDistance()),
					compareInt(goalsModel.getFloors(), dailyModel.getFloors()),
					compareInt(goalsModel.getSteps(), dailyModel.getSteps())
					);
			
		}
	}
	
	private String compareInt(int goal, int actual){
		if (actual>goal || actual==goal) return "YAY :D";
		else return ":(";
	}
	
	private String compareDoubleInt(double goal, int actual){
		if (actual>goal || actual==goal) return "YAY :D";
		else return ":(";
	}
	
	private String compareDouble(double goal, double actual){
		if (actual>goal || actual==goal) return "YAY :D";
		else return ":(";
	}
}