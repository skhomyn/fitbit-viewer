package ca.uwo.csd.cs2212.team13;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import ca.uwo.csd.cs2212.team13.GoalsController.clickListener;

public class AccoladeController {

	private AccoladeRecord[] ar;
	private ActivitiesRecord acR;

	private InterfaceView view;

	AccoladeController(AccoladeRecord[] ar, ActivitiesRecord acR,
			InterfaceView view) {
		this.ar = ar;
		this.acR = acR;
		this.view = view;

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

	private void checkAchieved() {
		LifetimeRecord lr = acR.getLifetime();

		for (int i = 0; i < ar.length; i++) {
			String[] typeSplit = ar[i].getType().split("/");

			if (typeSplit[0].equals("ca.uwo.csd.cs2212.team13.LifetimeRecord")) {
				Class thisClass;
				try {
					thisClass = Class.forName(typeSplit[0]);

					Method m;
					try {
						m = thisClass.getDeclaredMethod(typeSplit[1]);
						// check = (double) m.invoke(lr);
						if (Double.parseDouble(m.invoke(lr).toString()) >= ar[i]
								.getValue()) {
							ar[i].setAchieved(true);
							System.out.println(Double.parseDouble(m.invoke(lr)
									.toString())
									+ " "
									+ ar[i].getValue()
									+ "\n");
						}

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

	private void save() {
		WriterReader wr = new WriterReader();

		try {
			wr.writeRecord(ar, "accoladerecords");

		} catch (Exception e) {
			System.out.println("Could not write to file");
		}
	}
}
