package ca.uwo.csd.cs2212.team13;

/**
 * Class to check if date being selected
 * is valid (a real date)
 * @author Johnny
 *
 */
public interface DateSelectionConstraint {

	/**
	 * boolean method to confirm the date is correct or not
	 * @param model the calander
	 * @return t or f
     */
	boolean isValidSelection(CalendarModel model);

}
