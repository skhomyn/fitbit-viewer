package ca.uwo.csd.cs2212.team13;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import ca.uwo.csd.cs2212.team13.GoalsController.clickListener;

public class AccoladeController {

	private AccoladeRecord[] ar;
	private ActivitiesRecord acR;
	private DailyRecord dr;
	private HeartRateRecord hr;

	private InterfaceView view;

	AccoladeController(AccoladeRecord[] ar, ActivitiesRecord acR,
			DailyRecord dr, HeartRateRecord hr, InterfaceView view) {
		this.ar = ar;
		this.acR = acR;
		this.dr = dr;
		this.view = view;
		this.hr = hr;

		view.addClickListenerAccolades(new clickListener());
	}

	class clickListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			checkAchieved();
			view.setAccoladeFields(ar);
			save();
		}
	}

	/**
	 * Sets the Accolades page display fields in
	 * <code>InterfaceView</code> with values from the appropriate model
	 * <code>AccoladesRecord</code> fields.
	 */
	public void accoladesInitialize() {
		checkAchieved();
		view.setAccoladeFields(ar);
		save();
	}
	private void checkAchieved() {
		LifetimeRecord lr = acR.getLifetime();
		BestDaysRecord br = acR.getBest();
		GoalsRecord gr = dr.getGoals();
		

		for (int i = 0; i < ar.length; i++) {
			String[] typeSplit = ar[i].getType().split("/");

			if (typeSplit[1].equals("null") || typeSplit[0].equals("ca.uwo.csd.cs2212.team13.HeartRateRecord")) {

			} else {

				Class thisClass;
				try {
					thisClass = Class.forName(typeSplit[0]);

					Method m;
					try {
						m = thisClass.getDeclaredMethod(typeSplit[1]);

						if (typeSplit[0]
								.equals("ca.uwo.csd.cs2212.team13.LifetimeRecord"))
							checkValues(m, lr, i);

						else if (typeSplit[0]
								.equals("ca.uwo.csd.cs2212.team13.BestDaysRecord"))
							checkValues(m, br, i);

						else if (typeSplit[0]
								.equals("ca.uwo.csd.cs2212.team13.DailyRecord"))
							checkValues(m, dr, i);
						else if (typeSplit[0]
								.equals("ca.uwo.csd.cs2212.team13.HeartRateRecord"))
							checkValues(m, hr, i);

					} catch (NoSuchMethodException | SecurityException
							| IllegalArgumentException | IllegalAccessException
							| InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}

	}

	private void checkValues(Method m, Object standard, int i)
			throws NumberFormatException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {

		if (Double.parseDouble(m.invoke(standard).toString()) >= ar[i]
				.getValue()) {
			ar[i].setAchieved(true);
		}

		System.out.println(Double.parseDouble(m.invoke(standard).toString())
				+ " " + ar[i].getValue() + "\n");

	}

	private void save() {
		WriterReader wr = new WriterReader();

		try {
			wr.writeRecord(ar, "accoladerecords");

		} catch (Exception e) {
			System.out.println("Could not write to file");
		}
	}
}
