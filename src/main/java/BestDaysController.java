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
		// refresh (or lifetime totals) button in the side menu
		view.addRefreshListener(new RefreshListener());
	}
	
	//action methods
	public void updateView() {
		view.setDistance(model.getDistance());
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