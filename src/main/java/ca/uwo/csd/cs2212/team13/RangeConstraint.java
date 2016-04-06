package ca.uwo.csd.cs2212.team13;

import java.util.Calendar;
import java.util.Date;

/**
 * Class to format the calendar
 * @author Robin
 *
 */
public class RangeConstraint implements DateSelectionConstraint {

	/**
	 * variables used for calender
	 */
	private final Calendar after;
	private final Calendar before;

	/**
	 * @param after
	 * @param before
	 * 		parameters used for constraint
	 */
	public RangeConstraint(Calendar after, Calendar before) {
		this.after = after;
		this.before = before;

		// remove hours / minutes / seconds from dates
		cleanTime();
	}

	/**
	 * Constraints for the calender
	 * @param after used for constraint
	 * @param before used for constraint
     */
	public RangeConstraint(Date after, Date before) {
		Calendar _after = Calendar.getInstance();
		Calendar _before = Calendar.getInstance();

		_after.setTime(after);
		_before.setTime(before);

		this.after = _after;
		this.before = _before;

		// remove hours / minutes / seconds from dates
		cleanTime();
	}

	/**
	 * Clear the time
	 */
	private void cleanTime() {
		if (after != null) {
			after.set(Calendar.HOUR_OF_DAY, 0);
			after.set(Calendar.MINUTE, 0);
			after.set(Calendar.SECOND, 0);
			after.set(Calendar.MILLISECOND, 0);
		}

		if (before != null) {
			before.set(Calendar.HOUR_OF_DAY, 23);
			before.set(Calendar.MINUTE, 59);
			before.set(Calendar.SECOND, 59);
			before.set(Calendar.MILLISECOND, 999);
		}
	}

	/**
	 * Method to validate
	 * calendar selection
	 */
	public boolean isValidSelection(CalendarModel model) {

		boolean result = true;

		if (model.isSelected() && after != null) {
            Calendar value = Calendar.getInstance();
            value.set(model.getYear(), model.getMonth(), model.getDay());
            value.set(Calendar.HOUR, 0);
            value.set(Calendar.MINUTE, 0);
            value.set(Calendar.SECOND, 0);
            value.set(Calendar.MILLISECOND, 0);
			result &= value.after(after);
		}
		if (model.isSelected() && before != null) {
            Calendar value = Calendar.getInstance();
            value.set(model.getYear(), model.getMonth(), model.getDay());
            value.set(Calendar.HOUR, 0);
            value.set(Calendar.MINUTE, 0);
            value.set(Calendar.SECOND, 0);
            value.set(Calendar.MILLISECOND, 0);
			result &= value.before(before);
		}

		return result;
	}
	
	/**
	 * Method to allow us to move
	 * forward in the calendar
	 * @param model the calender model
	 * @return
	 */
	public boolean isUpper(CalendarModel model) {
		if (model.isSelected() && after != null) {
            Calendar value = Calendar.getInstance();
            value.set(model.getYear(), model.getMonth(), model.getDay());
            value.set(Calendar.HOUR_OF_DAY, 23);
            value.set(Calendar.MINUTE, 59);
            value.set(Calendar.SECOND, 59);
            value.set(Calendar.MILLISECOND, 999);
            if (value.equals(before))
            	return true;
		}
		return false;
	}

	/**
	 * Method to allow us to
	 * move backwards in the
	 * calendar
	 * @param model
	 * @return
	 */
	public boolean isLower(CalendarModel model) {
		if (model.isSelected() && before != null) {
            Calendar value = Calendar.getInstance();
            value.set(model.getYear(), model.getMonth(), model.getDay());
            value.set(Calendar.HOUR_OF_DAY, 0);
            value.set(Calendar.MINUTE, 0);
            value.set(Calendar.SECOND, 0);
            value.set(Calendar.MILLISECOND, 0);
            if (value.equals(after))
            	return true;
		}
		return false;
	}
	
	@Override
	// Generated with eclipse depending on: after, before
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((after == null) ? 0 : after.hashCode());
		result = prime * result + ((before == null) ? 0 : before.hashCode());
		return result;
	}

	@Override
	// Generated with eclipse depending on: after, before
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;

		RangeConstraint other = (RangeConstraint) obj;
		if (after == null) {
			if (other.after != null)
				return false;
		} else if (!after.equals(other.after))
			return false;
		if (before == null) {
			if (other.before != null)
				return false;
		} else if (!before.equals(other.before))
			return false;
		return true;
	}

}