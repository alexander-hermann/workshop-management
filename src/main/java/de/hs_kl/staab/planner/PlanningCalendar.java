package de.hs_kl.staab.planner;

import java.util.ArrayList;
import java.util.List;

public class PlanningCalendar {

	private List<Appointment> listOfAppointments = new ArrayList<>();

	public void createNewAppointment(Appointment appointment) {

		if (!listOfAppointments.contains(appointment)) {
			listOfAppointments.add(appointment);
		} else {
			throw new IllegalArgumentException("bad");
		}

	}

	public void getWeekOverview(int calenderWeekOfAppointment, int year) {

		for (Appointment appointment : listOfAppointments) {
			if (appointment.getCalendarWeek() == calenderWeekOfAppointment && appointment.getYear() == year) {
				System.out.println(appointment);

			}

		}

	}

	/* ******************************************************** */
	/* * HIER KÖNNEN SIE IHREN PLANUNGSKALENDER PROGRAMMIEREN * */
	/* * Der Planungskalender enthält den Kern ************** * */
	/* * Ihrer Anwendung, und hält die Daten des Kalenders ** * */
	/* * mit den Terminen, etc. ***************************** * */
	/* ******************************************************** */

}
