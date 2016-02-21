package sharkzilla;

public class TestRun {
	
	public static void main(String[] args){
		
		LifetimeView ltView = new LifetimeView();
		LifetimeRecord ltModel = new LifetimeRecord();
		LifetimeController ltController = new LifetimeController(ltModel, ltView);
		
		ltView.setVisible(true);
		
		//called manually here for initial testing purposes,
		//but will be triggered upon the page loading
		ltController.updateView();
		
	}
	

}
