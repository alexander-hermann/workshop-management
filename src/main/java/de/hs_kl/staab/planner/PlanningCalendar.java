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

	public void getWeekOverview(int calenderWeekOfAppointment) {

		for (Appointment appointment : listOfAppointments) {
			if (appointment.getCalenderWeekOfAppointment() == calenderWeekOfAppointment) {
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
