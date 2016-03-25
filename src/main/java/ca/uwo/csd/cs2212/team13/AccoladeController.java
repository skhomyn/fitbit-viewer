package ca.uwo.csd.cs2212.team13;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.Date;

import org.jdatepicker.impl.UtilDateModel;

import ca.uwo.csd.cs2212.team13.GoalsController.clickListener;

/**
 * Java Object which passes information a lot of records plus an array of
 * AccoladeRecord[] to the <code>InterfaceView</code> object.
 * <p>
 * <code>AccoladeController</code> contains references to the array with model
 * object {@link AccoladeRecord}, which contains the data for the accolades, and
 * the view object {@link InterfaceView}, which implements the user interface
 * for all pages. Also checks accolades to see if they're done right
 * <p>
 * The purpose of this class is to pass the data contained in the model
 * <code>AccoladeRecord</code> and a bunch of other accoldaes to the view
 * <code>InterfaceView</code>, so that it can be displayed to the user.
 */
public class AccoladeController {

	/**
	 * Records/Models that Accolade controller needs
	 */
	private AccoladeRecord[] ar;
	private ActivitiesRecord acR;
	private DailyRecord dr;
	private HeartRateRecord hr;

	/**
	 * View as that is the view for entire page.
	 */
	private InterfaceView view;

	/**
	 * Constructor, initializes the model and view fields with pointers to
	 * various records and <code>InterfaceView</code> object respectively, and
	 * calls method
	 * {@link InterfaceView#addClickListenerAccolades(ActionListener)} to add a
	 * click listener to the Accolades button.
	 * 
	 * @param ar
	 * @param acR
	 * @param dr
	 * @param hr
	 * @param view
	 */
	AccoladeController(AccoladeRecord[] ar, ActivitiesRecord acR,
			DailyRecord dr, HeartRateRecord hr, InterfaceView view) {
		this.ar = ar;
		this.acR = acR;
		this.dr = dr;
		this.view = view;
		this.hr = hr;

		view.addClickListenerAccolades(new clickListener());
	}

	/**
	 * Local class accessible only by the <code>AccoladeController</code>
	 * object. Its purpose is to define which actions should be performed when
	 * the Accolades button in <code>InterfaceView</code> is clicked by the user
	 *
	 * @see java.awt.event.ActionListener
	 */
	class clickListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			checkAchieved();
			view.setAccoladeFields(ar);
			save();
		}
	}

	/**
	 * Sets the Accolades page display fields in <code>InterfaceView</code> with
	 * values from the appropriate model <code>AccoladesRecord</code> fields.
	 */
	public void accoladesInitialize() {
		checkAchieved();
		view.setAccoladeFields(ar);
		save();
	}

	/**
	 * Checks if accolades achieved
	 */
	private void checkAchieved() {
		LifetimeRecord lr = acR.getLifetime();
		BestDaysRecord br = acR.getBest();
		HeartZoneRecord cardio = hr.getCardioZone();
		HeartZoneRecord fat = hr.getFatBurnZone();
		HeartZoneRecord outRange = hr.getOutRangeZone();
		HeartZoneRecord peak = hr.getPeakZone();

		Date date1 = new Date(116, Calendar.DECEMBER, 24);
		Date date2 = new Date(117, Calendar.JANUARY, 1);
		Date currentDate = new Date();

		int counter = 0;

		for (int i = 0; i < ar.length; i++) {
			String[] typeSplit = ar[i].getType().split("/");

			if ((ar[i].getImage().equals("hanukkahAcc"))
					&& (currentDate.after(date1) && currentDate.before(date2))) {
				ar[i].setAchieved(true);
				counter++;
			} else if ((currentDate.getDay() == 25 && currentDate.getMonth() == 11)
					&& (ar[i].getImage().equals("christmasAcc"))) {
				ar[i].setAchieved(true);
				counter++;
			} else if (typeSplit[1].equals("null")) {
				if (ar[i].getImage().equals("metNoGoalsAcc")) {
					if (GoalCheck() == 0) {
						ar[i].setAchieved(true);
						counter++;
					}
				} else if (ar[i].getImage().equals("metAllGoalsAcc")) {
					if (GoalCheck() == 5) {
						ar[i].setAchieved(true);
						counter++;
					}
				}
			} else {

				Class thisClass;
				try {
					thisClass = Class.forName(typeSplit[0]);

					Method m;
					try {
						m = thisClass.getDeclaredMethod(typeSplit[1]);

						if (typeSplit[0]
								.equals("ca.uwo.csd.cs2212.team13.LifetimeRecord")) {
							{
								if (checkValues(m, lr, i))
									counter++;
							}
						} else if (typeSplit[0]
								.equals("ca.uwo.csd.cs2212.team13.HeartZoneRecord")) {
							if (ar[i].getImage().equals("CardioHeartAcc")) {
								if (checkValues(m, cardio, i))
									counter++;
							} else if (ar[i].getImage().equals(
									"FatburnHeartAcc")) {
								if (checkValues(m, fat, i))
									counter++;
							} else if (ar[i].getImage().equals(
									"outofRangeHeartAcc")) {
								if (checkValues(m, outRange, i))
									counter++;
							} else if (ar[i].getImage().equals("peakHeartAcc")) {
								if (checkValues(m, peak, i))
									counter++;
							} else if (ar[i].getImage().equals(
									"StayedInBoundsAcc")) {
								if (checkValuesNegate(m, outRange, i))
									counter++;
							}
						} else if (typeSplit[0]
								.equals("ca.uwo.csd.cs2212.team13.BestDaysRecord")) {

							if (ar[i].getImage().equals("zeroSteps")) {
								if (checkValuesNegate(m, br, i))
									counter++;
							} else {
								if (checkValues(m, br, i))
									counter++;
							}

						} else if (typeSplit[0]
								.equals("ca.uwo.csd.cs2212.team13.DailyRecord")) {
							if (ar[i].getImage().equals("tooManyCalsAcc")) {
								if (checkValuesNegate(m, dr, i))
									counter++;
							} else {
								if (checkValues(m, dr, i))
									counter++;
							}
						} else if (typeSplit[0]
								.equals("ca.uwo.csd.cs2212.team13.HeartRateRecord")) {
							if (checkValues(m, hr, i))
								counter++;
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

		if (counter >= 10)
			ar[18].setAchieved(true);
		if (counter >= 19)
			ar[19].setAchieved(true);

	}

	/**
	 * Check if values are fine
	 * 
	 * @param m
	 * @param standard
	 * @param i
	 * @return
	 * @throws NumberFormatException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	private boolean checkValues(Method m, Object standard, int i)
			throws NumberFormatException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {

		if (Double.parseDouble(m.invoke(standard).toString()) >= ar[i]
				.getValue()) {
			ar[i].setAchieved(true);
			return true;
		}
		return false;

	}

	/**
	 * Check if values are fine -> negation version (to check 0)
	 * 
	 * @param m
	 * @param standard
	 * @param i
	 * @return
	 * @throws NumberFormatException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	private boolean checkValuesNegate(Method m, Object standard, int i)
			throws NumberFormatException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {

		if (Double.parseDouble(m.invoke(standard).toString()) == ar[i]
				.getValue()) {
			ar[i].setAchieved(true);
			return true;
		}
		return false;

	}

	/**
	 * Check how many goals are complete
	 * 
	 * @return int num of goals complete
	 */
	private int GoalCheck() {
		GoalsRecord gr = dr.getGoals();

		int total = 0;
		total = compareDouble(gr.getActiveMinutes(), dr.getVeryActiveMinutes())
				+ compareDoubleInt(gr.getCaloriesOut(), dr.getCalories())
				+ compareDouble(gr.getDistance(), dr.getDistance())
				+ compareInt(gr.getFloors(), dr.getFloors())
				+ compareInt(gr.getSteps(), dr.getSteps());
		return total;
	}

	/**
	 * Checks if goal is complete.
	 * 
	 * @param goal
	 * @param actual
	 * @return 1 if complete, 0 otherwise
	 */
	private int compareInt(int goal, int actual) {
		if (actual > goal || actual == goal)
			return 1;
		else
			return 0;
	}

	/**
	 * Checks if goal is complete.
	 * 
	 * @param goal
	 * @param actual
	 * @return 1 if complete, 0 otherwise
	 */
	private int compareDoubleInt(double goal, int actual) {
		if (actual > goal || actual == goal)
			return 1;
		else
			return 0;
	}

	/**
	 * Checks if goal is complete.
	 * 
	 * @param goal
	 * @param actual
	 * @return 1 if complete, 0 otherwise
	 */
	private int compareDouble(double goal, double actual) {
		if (actual > goal || actual == goal)
			return 1;
		else
			return 0;
	}

	/**
	 * Saves accolade record to file
	 */
	private void save() {
		WriterReader wr = new WriterReader();

		try {
			wr.writeRecord(ar, "accoladerecords");

		} catch (Exception e) {
			System.out.println("Could not write to file");
		}
	}
}
