
public class TestRun {
	
	public static void main(String[] args){
		
		LifetimeView ltView = new LifetimeView();
		LifetimeRecord ltModel = new LifetimeRecord();
		LifetimeController ltController = new LifetimeController(ltModel, ltView);
		
		ltView.setVisible(true);
		
	}
	

}
