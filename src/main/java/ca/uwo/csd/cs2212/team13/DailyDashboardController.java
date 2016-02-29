package ca.uwo.csd.cs2212.team13;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DailyDashboardController {
	
	private DailyDashboardModel model;
	private InterfaceView view;
	
	public DailyDashboardController(DailyDashboardModel model, InterfaceView view){
		this.model = model;
		this.view = view;
		view.addClickListenerLifetimeTotals(new clickListener());
	}
	
	class clickListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			view.setDailyDashboardTotalsFields(model.getCalories(), model.getActiveMin(), model.getSedenteryMin(), model.getDistance(), model.getFloors(), model.getSteps());
		}
		
	}
}
