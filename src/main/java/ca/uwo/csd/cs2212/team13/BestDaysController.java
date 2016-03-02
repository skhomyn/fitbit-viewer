package ca.uwo.csd.cs2212.team13;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Java Object which passes information from the the <code>BestDaysRecord</code> object to the 
 * <code>InterfaceView</code> object.
 * <p>
 * <code>BestDaysController</code> contains references to the model object {@link BestDaysRecord}, 
 * which contains the data for the Best Days page, and the view object {@link InterfaceView}, 
 * which implements the user interface for all pages.
 * <p>
 * The purpose of this class is to pass the data contained in the model <code>BestDaysRecord</code>
 * to the view <code>InterfaceView</code>, so that it can be displayed to the user.
 */
public class BestDaysController {
	
	private BestDaysRecord model;
	private InterfaceView view;

	public BestDaysController(BestDaysRecord model, InterfaceView view) {
		this.model = model;
		this.view = view;
		
		//call method in view to add an event listener to the best days button 
		view.addClickListenerBestDays(new clickListener());
	}
	
	/**
	 * Local class accessible only by the <code>BestDaysController</code> object.
	 * It's purpose is to define which actions should be performed when the Best Days button
	 * in <code>InterfaceView</code> is clicked by the user
	 *
	 * @see java.awt.event.ActionListener
	 */
	class clickListener implements ActionListener{
		/** 
		 * Sets the Lifetime Totals display fields in <code>InterfaceView</code> with values from the
		 * appropriate model <code>BestDaysRecord</code> fields upon the click of a button.
		 * 
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 * 
		 * @param click action on button
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			view.setBestDaysFields(model.getDis_value(), model.getFloors_value(), model.getSteps_value(), model.getDis_date(), model.getFloors_date(), model.getSteps_date());
			
		}
	}
	
	/**
	 * TODO: error handling
	 */
 }	
	