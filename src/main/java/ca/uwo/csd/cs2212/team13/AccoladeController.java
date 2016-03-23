package ca.uwo.csd.cs2212.team13;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ca.uwo.csd.cs2212.team13.GoalsController.clickListener;

public class AccoladeController {

	private AccoladeRecord[] ar;
	private InterfaceView view;

	AccoladeController(AccoladeRecord[] ar, InterfaceView view) {
		this.ar = ar;
		this.view = view;

		view.addClickListenerAccolades(new clickListener());
	}

	class clickListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			view.setAccoladeFields(ar);
	}
}
