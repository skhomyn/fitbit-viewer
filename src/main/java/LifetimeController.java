package sharkzilla;

public class LifetimeController {
	
	//properties
	private LifetimeRecord model;
	LifetimeView view;
	
	//constructor
	public LifetimeController(LifetimeRecord model, LifetimeView view) {
		this.model = model;
		this.view = view;
	}
	
	//access methods
	public float getDistance(){
		return model.getDistance();
	}
	
	//action methods
	public void updateView() {
		view.setDistance(model.getDistance());
	}
	
	//error handling to be added
 }	
	
