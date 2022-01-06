package de.hs_kl.staab.planner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PlanningCalendar {

	private List<Appointment> listOfAppointments = new ArrayList<>();

	private final static float MAX_WORKING_TIME_PER_WORKING_PLATFORM_IN_MIN = 420; // Bzw. 7 Stunden

	/* ******************************************************** */
	/* * HIER KÖNNEN SIE IHREN PLANUNGSKALENDER PROGRAMMIEREN * */
	/* * Der Planungskalender enthält den Kern ************** * */
	/* * Ihrer Anwendung, und hält die Daten des Kalenders ** * */
	/* * mit den Terminen, etc. ***************************** * */
	/* ******************************************************** */

	public void createNewAppointment(Appointment appointment) {
		List<WorkingAppointment> listOfFoundWorkingAppointments = new ArrayList<>();
		List<CleaningAppointment> listOfFoundCleaningApointments = new ArrayList<>();

		if (appointment != null) {
			if (!listOfAppointments.contains(appointment)) {
				if (appointment.isAppointmentInWorkingTime()) {
					for (Appointment cappointment : listOfAppointments) {
						if (cappointment instanceof WorkingAppointment) {

							// Cast the object appointment to working appointment
							WorkingAppointment castTheObject = ((WorkingAppointment) appointment);
							WorkingPlatform getWorkingPlatform = castTheObject.getWorkingPlatform();

							// All elements from the appointments list are filtered with the date and with
							// the working platform from the appointment.
							// The found elements are saved in the list with working appointments.
							if (cappointment.getDay().equals(appointment.getDay())
									&& ((WorkingAppointment) cappointment).getWorkingPlatform()
											.equals(getWorkingPlatform)) {
								listOfFoundWorkingAppointments.add(((WorkingAppointment) cappointment));
							}
						} else if (cappointment instanceof CleaningAppointment) {

							// Cast the object appointment to cleaning appointment
							CleaningAppointment castTheObjectToCleaningAppointment = ((CleaningAppointment) appointment);
							WorkingPlatform getWorkingPlatformFromAppointment = castTheObjectToCleaningAppointment
									.getWorkingPlatform();

							CleaningAppointment castTheObjectFromListToCleaningAppointment = ((CleaningAppointment) cappointment);
							WorkingPlatform getWorkingPlatformFromList = castTheObjectFromListToCleaningAppointment
									.getWorkingPlatform();

							// All elements from the appointments list are filtered with the date and with
							// the working platform from the appointment.
							// The found elements are saved in the list with cleaning appointments.
							if (cappointment.getDay().equals(appointment.getDay())
									&& getWorkingPlatformFromList.equals(getWorkingPlatformFromAppointment)) {
								listOfFoundCleaningApointments.add(castTheObjectFromListToCleaningAppointment);
							}
						}
					}

					if (appointment instanceof WorkingAppointment) {
						// The list with working appointments is sorted
						Collections.sort(listOfFoundWorkingAppointments, new Comparator<WorkingAppointment>() {

							@Override
							public int compare(WorkingAppointment firstAppointment,
									WorkingAppointment secondAppointment) {
								return firstAppointment.getDayWithEndTime()
										.compareTo(secondAppointment.getDayWithEndTime());
							}
						});
					} else if (appointment instanceof CleaningAppointment) {
						// The list with cleaning appointments is sorted
						Collections.sort(listOfFoundCleaningApointments, new Comparator<CleaningAppointment>() {

							@Override
							public int compare(CleaningAppointment firstAppointment,
									CleaningAppointment secondAppointment) {
								return firstAppointment.getDayWithEndTime()
										.compareTo(secondAppointment.getDayWithEndTime());
							}
						});
					}
					listOfAppointments.add(appointment);
					System.out.println("The Appointment " + appointment + " was successfully added.");
				} else {
					System.err.println("The appointment is outside of working hours.");
				}
			} else {
				System.err.println("The appointment can't be added, because the appointment " + appointment
						+ " already exists in the list.");
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

}