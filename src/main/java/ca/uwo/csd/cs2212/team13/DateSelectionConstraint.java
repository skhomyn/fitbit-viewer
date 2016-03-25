package ca.uwo.csd.cs2212.team13;

/**
 * Class to check if date being selected
 * is valid (a real date)
 * @author Johnny
 *
 */
public interface DateSelectionConstraint {

	boolean isValidSelection(CalendarModel model);

}
