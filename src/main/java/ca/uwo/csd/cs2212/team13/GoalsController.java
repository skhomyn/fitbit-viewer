package ca.uwo.csd.cs2212.team13;

/**
 * Class that serves as model
 * for Daily Goals page
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GoalsController {
	
	/**
	 * Records and view
	 */
	private DailyRecord dailyModel;
	private GoalsRecord goalsModel;
	private InterfaceView view;
	
	/**
	 * This is the constructor for goals
	 * 
	 * @param dailyModel
	 * 		daily record model
	 * @param goalsModel
	 * 		goals record model
	 * @param view
	 * 		interface view 
	 */
	public GoalsController(DailyRecord dailyModel, GoalsRecord goalsModel, InterfaceView view){
		this.dailyModel = dailyModel;
		this.goalsModel = goalsModel;
		this.view = view;
		
		view.addClickListenerGoals(new clickListener());
	}
	
	/**
	 * This updates goals controller.
	 * 
	 * @param dailyModel
	 * 		daily record model
	 * @param goalsModel
	 * 		goals record model
	 * @param view
	 * 		interface view
	 */
	public void updateDGC(DailyRecord dailyModel, GoalsRecord goalsModel, InterfaceView view){
		this.dailyModel = dailyModel;
		this.goalsModel = goalsModel;
		this.view = view;
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

	/**
	 * Local class accessible only by the <code>GoalsController</code> object. Its
	 * purpose is to define which actions should be performed when the Goals
	 * button in <code>InterfaceView</code> is clicked by the user
	 *
	 * @see java.awt.event.ActionListener
	 */
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

	/**
	 * compare method for integers
	 * @param goal
	 * 		the goal
	 * @param actual
	 * 		the actual value
     * @return y or n
     */
	private String compareInt(int goal, int actual){
		if (actual>goal || actual==goal) return "Y";
		else return "N";
	}

	/**
	 * compare method for double
	 * @param goal
	 * 		the goal
	 * @param actual
	 * 		the actual value
     * @return y or n
     */
	private String compareDoubleInt(double goal, int actual){
		if (actual>goal || actual==goal) return "Y";
		else return "N";
	}

	/**
	 * compare method for doubles
	 * @param goal
	 * 		the goal
	 * @param actual
	 * 		the actual value
     * @return y or n
     */
	private String compareDouble(double goal, double actual){
		if (actual>goal || actual==goal) return "Y";
		else return "N";
	}
}