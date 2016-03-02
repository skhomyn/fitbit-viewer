package ca.uwo.csd.cs2212.team13;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Java Object which passes information from the the <code>LifetimeRecord</code> object to the 
 * <code>InterfaceView</code> object.
 * <p>
 * <code>LifetimeController</code> contains references to the model object {@link LifetimeRecord}, 
 * which contains the data for the Lifetime Totals page, and the view object {@link InterfaceView}, 
 * which implements the user interface for all pages.
 * <p>
 * The purpose of this class is to pass the data contained in the model <code>LifetimeRecord</code>
 * to the view <code>InterfaceView</code>, so that it can be displayed to the user.
 */
public class LifetimeController {
	
	private LifetimeRecord model;
	private InterfaceView view;
	
	
	public LifetimeController(LifetimeRecord model, InterfaceView view) {
		this.model = model;
		this.view = view;
		
		//call method in view to add an event listener to the lifetime totals button 
		view.addClickListenerLifetimeTotals(new clickListener());
	}
	
	/**
	 * Local class accessible only by the <code>LifetimeController</code> object.
	 * It's purpose is to define which actions should be performed when the Lifetime Totals button
	 * in <code>InterfaceView</code> is clicked by the user
	 *
	 * @see java.awt.event.ActionListener
	 */
	class clickListener implements ActionListener{
		
		/** 
		 * Sets the Lifetime Totals display fields in <code>InterfaceView</code> with values from the
		 * appropriate model <code>LifetimeRecord</code> fields upon the click of a button.
		 * 
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 * 
		 * @param click action on button
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			view.setLifetimeTotalsFields(model.getDistance(), model.getFloors(), model.getSteps());
		}
		
		/**
		 * TODO: error handling
		 */
	}
	
 }	
	
