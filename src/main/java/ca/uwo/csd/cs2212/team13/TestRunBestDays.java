package ca.uwo.csd.cs2212.team13;

public class TestRunBestDays {
	
	public static void main(String[] args){
		
		BestDaysView ltView = new BestDaysView();
		BestDaysModel ltModel = new BestDaysModel();
		BestDaysController ltController = new BestDaysController(ltModel, ltView);
		
		ltView.setVisible(true);
		
	}
	

}
