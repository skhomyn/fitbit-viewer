public class TestRunBestDays {
	
	public static void main(String[] args){
		
		BestDaysView ltView = new BestDaysView();
		BestDaysModel ltModel = new BestDaysModel();
		BestDaysController ltController = new BestDaysController(ltModel, ltView);
		
		ltView.setVisible(true);
		
	}
	

}
