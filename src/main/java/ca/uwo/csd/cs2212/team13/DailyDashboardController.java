package ca.uwo.csd.cs2212.team13;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Java Object which passes information from the the <code>DailyRecord</code> object to the 
 * <code>InterfaceView</code> object.
 * <p>
 * <code>DailyDashboardController</code> contains references to the model object {@link DailyRecord}, 
 * which contains the data for the Best Days page, and the view object {@link InterfaceView}, 
 * which implements the user interface for all pages.
 * <p>
 * The purpose of this class is to pass the data contained in the model <code>DailyRecord</code>
 * to the view <code>InterfaceView</code>, so that it can be displayed to the user.
 */
public class DailyDashboardController {
	
	private DailyRecord model;
	private InterfaceView view;
	
	/**
	 * Constructor, initializes the model and view fields with pointers to <code>DailyRecord</code>
	 * object and <code>InterfaceView</code> object respectively, and calls method 
	 * {@link InterfaceView#addClickListenerDashboard(ActionListener)} to add a click listener to the 
	 * Daily Dashboard button.
	 * 
	 * @param model
	 * 			the <code>DailyRecord</code> model containing the Best Days data to be displayed
	 * @param view
	 * 			the <code>InterfaceView</code> view containing the user interface implementation
	 * 
	 * @see InterfaceView#addClickListenerDashboard(ActionListener)
	 */
	public DailyDashboardController(DailyRecord model, InterfaceView view){
		this.model = model;
		this.view = view;
		view.addClickListenerDashboard(new clickListener());
	}
	
	/** 
	 * Sets the Daily Dashboard page display fields in <code>InterfaceView</code> with values from the
	 * appropriate model <code>DailyRecord</code> fields upon initial load of the application,
	 * since the Daily Dashboard is the first page to be displayed.
	 */
	public void DailyDashboardInitialize()
	{
		view.setDailyDashFields(model.getDate(), model.getDistance(), model.getCalories(), model.getFloors(), model.getSteps(), model.getVeryActiveMinutes(), model.getSedentaryMinutes());
	}
	
	/**
	 * Local class accessible only by the <code>DailyDashboardController</code> object.
	 * It's purpose is to define which actions should be performed when the Daily Dashboard button
	 * in <code>InterfaceView</code> is clicked by the user
	 *
	 * @see java.awt.event.ActionListener
	 */
	class clickListener implements ActionListener{
		
		/** 
		 * Sets the Daily Dashboard page display fields in <code>InterfaceView</code> with values from the
		 * appropriate model <code>DailyRecord</code> fields upon the click of a button.
		 * 
		 * @param e click action on button
		 * 
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			view.setDailyDashFields(model.getDate(), model.getDistance(), model.getCalories(), model.getFloors(), model.getSteps(), model.getVeryActiveMinutes(), model.getSedentaryMinutes());
		}
		
	}
}
