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

	public void getAppointmentById(String appointmentId) {
		if (!listOfAppointments.isEmpty()) {
			for (Appointment appointment : listOfAppointments) {
				if (appointment.getId().equals(appointmentId)) {
					System.out.println(appointment);
					return;
				}
			}
		} else {
			throw new IllegalArgumentException("The list of appointments is empty.");
		}
		System.err.println("The appointment with the id " + appointmentId + " was not found.");
	}

	public void getAppointments() {
		if (!listOfAppointments.isEmpty()) {
			for (Appointment appointment : listOfAppointments) {
				System.out.println(appointment);
			}
		} else {
			System.err.println("The list of appointments is empty.");
		}
	}

	public void getWeekOverview(int calenderWeekOfAppointment, int year) {

		List<Appointment> listOfFoundAppointmentsInWeekAndYear = new ArrayList<>();

		if ((calenderWeekOfAppointment >= 1 && calenderWeekOfAppointment <= 52) && (year > 0)) {
			for (Appointment appointment : listOfAppointments) {
				if (appointment.getCalendarWeek() == calenderWeekOfAppointment && appointment.getYear() == year) {
					listOfFoundAppointmentsInWeekAndYear.add(appointment);
				}
			}

			if (listOfFoundAppointmentsInWeekAndYear.size() > 0) {
				for (Appointment appointment : listOfFoundAppointmentsInWeekAndYear) {
					System.out.println(appointment);
				}
			} else {
				System.err.printf("There are no appointments in the calendar week: %d and the year: %d.%n",
						calenderWeekOfAppointment, year);
			}
		} else {
			throw new IllegalArgumentException(
					"The number of week must be between 1 and 52 and the number of year must be greater than 0");
		}
	}

	public void getYesterdayWorkingAppointments() {
		LocalDate yesterdayDay = LocalDate.now().minusDays(1);
		List<WorkingAppointment> listOfFoundWorkingAppointments = new ArrayList<>();

		for (Appointment appointment : listOfAppointments) {
			if (appointment instanceof WorkingAppointment) {
				boolean searchCondition = ((WorkingAppointment) appointment).isCompleted()
						&& ((WorkingAppointment) appointment).getDayOfAppointment().equals(yesterdayDay);

				if (searchCondition) {
					listOfFoundWorkingAppointments.add((WorkingAppointment) appointment);
				}
			}
		}

		if (listOfFoundWorkingAppointments.size() > 0) {
			for (WorkingAppointment workingAppointment : listOfFoundWorkingAppointments) {
				System.out.println(workingAppointment);
			}
		} else {
			System.err.println("The day " + yesterdayDay + " has no working appointments.");
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
