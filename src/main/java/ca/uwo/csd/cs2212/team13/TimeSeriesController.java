package ca.uwo.csd.cs2212.team13;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Java Object which passes information from the the <code>LifetimeRecord</code>
 * object to the <code>InterfaceView</code> object.
 * <p>
 * <code>LifetimeController</code> contains references to the model object
 * {@link LifetimeRecord}, which contains the data for the Lifetime Totals page,
 * and the view object {@link InterfaceView}, which implements the user
 * interface for all pages.
 * <p>
 * The purpose of this class is to pass the data contained in the model
 * <code>LifetimeRecord</code> to the view <code>InterfaceView</code>, so that
 * it can be displayed to the user.
 */
public class TimeSeriesController {

	/**
	 * Records for model
	 */
	private DistanceTSRecord distance_model;
	private StepsTSRecord steps_model;
	private CaloriesTSRecord calories_model;
	private HeartRateRecord rate_model;


	/**
	 * Interface view for view
	 */
	private InterfaceView view;

	/**
	 * Constructor, initializes the model and view fields with pointers to
	 * <code>LifetimeRecord</code> object and <code>InterfaceView</code> object
	 * respectively, and calls method
	 * {@link InterfaceView#addClickListenerLifetimeTotals(ActionListener)} to
	 * add a click listener to the Lifetime Totals button.
	 * 
	 * @param model
	 *            the <code>LifetimeRecord</code> model containing the Best Days
	 *            data to be displayed
	 * @param view
	 *            the <code>InterfaceView</code> view containing the user
	 *            interface implementation
	 * 
	 * @see InterfaceView#addClickListenerLifetimeTotals(ActionListener)
	 */
	public TimeSeriesController(DistanceTSRecord distance_model, StepsTSRecord steps_model, CaloriesTSRecord calories_model, HeartRateRecord rate_model, InterfaceView view) {
		this.distance_model = distance_model;
		this.steps_model = steps_model;
		this.calories_model = calories_model;
		this.rate_model = rate_model;

		this.view = view;

		// call method in view to add an event listener to the lifetime totals
		// button
		view.addClickListenerTimeSeries(new clickListener());
	}

	/**
	 * Local class accessible only by the <code>LifetimeController</code>
	 * object. It's purpose is to define which actions should be performed when
	 * the Lifetime Totals button in <code>InterfaceView</code> is clicked by
	 * the user
	 *
	 * @see java.awt.event.ActionListener
	 */
	class clickListener implements ActionListener {

		/**
		 * 
		 * Sets the Lifetime Totals display fields in <code>InterfaceView</code>
		 * with values from the appropriate model <code>LifetimeRecord</code>
		 * fields upon the click of a button.
		 * 
		 * @param e click action on button
		 * 
		 * @see
		 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			view.setTimeSeriesGraph(distance_model, steps_model, calories_model, rate_model);
		}

		// TODO: error handling for lifetime totals controller
	}

}