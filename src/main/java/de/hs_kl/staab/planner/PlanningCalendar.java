package de.hs_kl.staab.planner;

import java.time.LocalDate;
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

		if ((calenderWeekOfAppointment >= 1 && calenderWeekOfAppointment <= 52) && (year > 0)) {
			for (Appointment appointment : listOfAppointments) {
				if (appointment.getCalendarWeek() == calenderWeekOfAppointment && appointment.getYear() == year) {
					System.out.println(appointment);

				} else {
					System.err.println("There are no appointments in the calendar week: " + calenderWeekOfAppointment);
				}
			}
		} else {
			throw new IllegalArgumentException(
					"The number of week must be between 1 and 52 and the number of year must be greater than 0");
		}
	}

	public void getYesterdayWorkingAppointments() {
		// LocalDateTime yesterday = LocalDateTime.now().minusDays(1);
		List<WorkingAppointment> listOfWorkingAppointments = new ArrayList<>();
		for (Appointment appointment : listOfAppointments) {

			if (appointment instanceof WorkingAppointment) {
				listOfWorkingAppointments.add((WorkingAppointment) appointment);
			}
		}
		for (WorkingAppointment workingAppointment : listOfWorkingAppointments) {
			if (((WorkingAppointment) workingAppointment).isCompleted() == true
					&& LocalDate.now().minusDays(1).equals(workingAppointment.getDayOfAppointment())) {
				System.out.println(workingAppointment);
			}
		}
	}

	public void setWorkingAppoinmentToCompleted(WorkingAppointment workingAppointment) {
		for (Appointment appointment : listOfAppointments) {
			if (appointment instanceof WorkingAppointment) {
				if (appointment.equals(workingAppointment)) {
					workingAppointment.setCompleted(true);

					listOfAppointments.set(listOfAppointments.indexOf(appointment), workingAppointment);
				}
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
