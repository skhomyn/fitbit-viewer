import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BestDaysController {
	
	//properties
	private BestDaysModel model;
	BestDaysView view;
	
	//constructor
	public BestDaysController(BestDaysModel model, BestDaysView view) {
		this.model = model;
		this.view = view;
		
		//call method in view to add an event listener to the
		// refresh (or Best Days) button in the side menu
		view.addRefreshListener(new RefreshListener());
	}
	
	//action methods
	public void updateView() {
		view.setDistance(model.getDistance());
		view.setFloors(model.getFloors());
		view.setSteps(model.getSteps());
	} 
	
	
	//refresh listener implementation (Best Days button in side menu)
	class RefreshListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			updateView();	
		}
		
	}
	
	//error handling to be added
 }	