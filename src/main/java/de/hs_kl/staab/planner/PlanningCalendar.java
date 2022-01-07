package de.hs_kl.staab.planner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class PlanningCalendar {

	private List<Appointment> listOfAppointments = new ArrayList<>();

	/* ******************************************************** */
	/* * HIER KÖNNEN SIE IHREN PLANUNGSKALENDER PROGRAMMIEREN * */
	/* * Der Planungskalender enthält den Kern ************** * */
	/* * Ihrer Anwendung, und hält die Daten des Kalenders ** * */
	/* * mit den Terminen, etc. ***************************** * */
	/* ******************************************************** */

	public void createNewAppointment(Appointment appointment) {
		List<Appointment> listOfFoundAppointments = new ArrayList<>();
		if (appointment != null) {
			if (!listOfAppointments.contains(appointment)) {
				listOfAppointments.add(appointment);
				for (Appointment cappointment : listOfAppointments) {
					if ((appointment instanceof WorkingAppointment || appointment instanceof CleaningAppointment)
							&& (cappointment instanceof WorkingAppointment
									|| cappointment instanceof CleaningAppointment)) {

						if (!appointment.getId().equals(cappointment.getId()))

							if ((appointment.getWorkingPlatform().equals(cappointment.getWorkingPlatform())
									&& appointment.getDayWithStartTime().isAfter(cappointment.getDayWithStartTime())
									&& appointment.getDayWithStartTime().isBefore(cappointment.getDayWithEndTime()))
									|| ((appointment.getWorkingPlatform().equals(cappointment.getWorkingPlatform()))
											&& (appointment.getDayWithEndTime()
													.isAfter(cappointment.getDayWithStartTime()))
											&& appointment.getDayWithEndTime()
													.isBefore(cappointment.getDayWithEndTime()))
									|| (appointment.getWorkingPlatform().equals(cappointment.getWorkingPlatform())
											&& appointment.getDayWithStartTime()
													.equals(cappointment.getDayWithStartTime()))) {

								System.err.println(" The appointment " + appointment.getId() + " "
										+ appointment.getWorkingPlatform() + " " + appointment.getDayWithStartTime()
										+ " collides with the appointment " + cappointment.getId() + " "
										+ cappointment.getWorkingPlatform() + " " + cappointment.getDayWithStartTime());
							}

					}
				}
			}
		} else {
			System.err.println("You must entered an appointment.");
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
			Collections.sort(listOfAppointments, new Comparator<Appointment>() {

				@Override
				public int compare(Appointment firstAppointment, Appointment secondAppointment) {
					return firstAppointment.getDayWithStartTime().compareTo(secondAppointment.getDayWithStartTime());
				}

			});
			for (Appointment appointment : listOfAppointments) {
				System.out.println(appointment);
			}
		} else {
			System.err.println("The list of appointments is empty.");
		}
	}

	public void updateAppointment(Appointment oldAppointment, Appointment newAppointment) {
		if (!listOfAppointments.isEmpty()) {
			for (Appointment currentAppointment : listOfAppointments) {
				if (currentAppointment.equals(oldAppointment)) {

					// Assigns the id of the old object to the new object
					newAppointment.setId(oldAppointment.getId());

					int indexOfOldAppointmentInTheList = listOfAppointments.indexOf(oldAppointment);
					listOfAppointments.set(indexOfOldAppointmentInTheList, newAppointment);
				}
			}
		} else {
			System.err.println("The appointment cannot be updated because the list of appointments is empty.");
		}
	}

	public void removeAppointment(Appointment removeAppointment) {
		if (!listOfAppointments.isEmpty()) {
			if (listOfAppointments.contains(removeAppointment)) {
				listOfAppointments.remove(removeAppointment);
				System.out.println("The appointment " + removeAppointment.getId() + " was successfully deleted.");
			} else {
				System.err
						.println("The appointment could not be deleted because the object was not found in the list.");
			}
		} else {
			System.err.println("The appointment can't be deleted because the list of appointments is empty.");
		}
	}

	public void getWeekOverview(int calenderWeekOfAppointment, int year) {

		List<Appointment> listOfFoundAppointmentsInWeekAndYear = new ArrayList<>();

		if ((calenderWeekOfAppointment >= 1 && calenderWeekOfAppointment <= 52) && (year > 0)) {
			for (Appointment appointment : listOfAppointments) {
				if (appointment.getCalendarWeek() == calenderWeekOfAppointment
						&& appointment.getDay().getYear() == year) {
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
			System.err.println(
					"The number of week must be between 1 and 52 and the number of year must be greater than 0");
		}
	}

	public void getYesterdayWorkingAppointments() {
		LocalDate yesterdayDay = LocalDate.now().minusDays(1);
		List<WorkingAppointment> listOfFoundWorkingAppointments = new ArrayList<>();

		for (Appointment appointment : listOfAppointments) {
			if (appointment instanceof WorkingAppointment) {
				boolean searchCondition = ((WorkingAppointment) appointment).isCompleted()
						&& appointment.getDay().equals(yesterdayDay);

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

	public long getTotalHoursOfDay(Appointment appointment, WorkingPlatform workingPlatform) {
		long totalHoursOfDay = 0;

		if (appointment instanceof WorkingAppointment)
			for (Appointment currentAppointment : listOfAppointments) {
				if (appointment.getDay().equals(appointment.getDay())
						&& ((WorkingAppointment) appointment).getWorkingPlatform().equals(workingPlatform)) {
					totalHoursOfDay += currentAppointment.getDurationInMin();
				}
			}
		else if (appointment instanceof CleaningAppointment) {
			for (Appointment currentAppointment : listOfAppointments) {
				if (appointment.getDay().equals(appointment.getDay())
						&& ((CleaningAppointment) appointment).getWorkingPlatform().equals(workingPlatform)) {
					totalHoursOfDay += currentAppointment.getDurationInMin();
				}
			}
		}
		return totalHoursOfDay;
	}

	public void setAutomaticallyCleaningAppointment(WorkingPlatform workingPlatform, CLEANINGPROGRAMM cleaningProgram,
			Dispatcher dispatcher) {
		// Methode für die nächstbeste Zeit finden

		LocalDateTime timeAfterDuration = LocalDateTime.now().plusMinutes(100);

		Appointment nextAppointmentForWorkingPlatform = workingPlatform.getListOfPlannedWorks().get(0);

		if (timeAfterDuration.isBefore(nextAppointmentForWorkingPlatform.getDayWithStartTime())) {

			Date date = new Date();

			Calendar calendar = Calendar.getInstance();

			calendar.setTime(date);
			int dateYear = calendar.get(Calendar.YEAR);
			int dateMonth = calendar.get(Calendar.MONTH);
			int dateDay = calendar.get(Calendar.DAY_OF_MONTH);
			int dateHour = calendar.get(Calendar.HOUR);
			int dateMinute = calendar.get(Calendar.MINUTE);

			CleaningAppointment automaticAppointment = new CleaningAppointment(dateYear, dateMonth, dateDay, dateHour,
					dateMinute, workingPlatform, cleaningProgram, dispatcher);
			createNewAppointment(automaticAppointment);

		} else {
			Iterator<Appointment> iterator = workingPlatform.getListOfPlannedWorks().iterator();

			while (iterator.hasNext()) // überprüfen, ob noch ein Element folgt
			{
				Appointment nextAppointment = iterator.next(); // nächstes Element
				// Appointment thisAppointment = this;
				// if(nextAppointment.getDayWithStartTime() - appointment.getDayWithEndTime()) {

			}

		}

	}

}