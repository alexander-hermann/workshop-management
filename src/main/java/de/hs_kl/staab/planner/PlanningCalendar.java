package de.hs_kl.staab.planner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PlanningCalendar {

	private List<Appointment> listOfAppointments = new ArrayList<>();

	/* ******************************************************** */
	/* * HIER KÖNNEN SIE IHREN PLANUNGSKALENDER PROGRAMMIEREN * */
	/* * Der Planungskalender enthält den Kern ************** * */
	/* * Ihrer Anwendung, und hält die Daten des Kalenders ** * */
	/* * mit den Terminen, etc. ***************************** * */
	/* ******************************************************** */

	public List<Appointment> getListOfAppointments() {
		Collections.sort(listOfAppointments, new Comparator<Appointment>() {

			@Override
			public int compare(Appointment firstAppointment, Appointment secondAppointment) {
				return firstAppointment.getDayWithStartTime().compareTo(secondAppointment.getDayWithStartTime());
			}
		});

		return listOfAppointments;
	}

	public void createNewAppointment(Appointment inputAppointment) {
		List<Appointment> listOfFoundAppointments = new ArrayList<>();

		if (inputAppointment != null) {
			// 1. Search all elements
			for (Appointment searchAppointment : listOfAppointments) {
				if (searchAppointment.getDay().equals(inputAppointment.getDay())) {

					if (searchAppointment instanceof WorkingAppointment
							|| searchAppointment instanceof CleaningAppointment) {
						if (searchAppointment.getWorkingPlatform().equals(inputAppointment.getWorkingPlatform())) {
							listOfFoundAppointments.add(searchAppointment);
						}
					} else if (searchAppointment instanceof ConsultingAppointment) {
						if (((ConsultingAppointment) searchAppointment).getCustomerConsultant()
								.equals(((ConsultingAppointment) inputAppointment).getCustomerConsultant())) {
							listOfFoundAppointments.add(searchAppointment);
						}
					}
				}
			}

			if (!listOfAppointments.contains(inputAppointment)) {
				if (inputAppointment.isAppointmentInWorkingTime()) {

					if (!listOfFoundAppointments.isEmpty()) {
						boolean conditionAddAppointment = false;
						for (Appointment appointment : listOfFoundAppointments) {

							boolean cond1 = inputAppointment.getDayWithStartTime()
									.equals(appointment.getDayWithStartTime());

							boolean cond3 = inputAppointment.getDayWithStartTime()
									.isAfter(appointment.getDayWithStartTime());
							boolean cond4 = inputAppointment.getDayWithStartTime()
									.isBefore(appointment.getDayWithEndTime());

							boolean cond5 = inputAppointment.getDayWithEndTime()
									.isAfter(appointment.getDayWithStartTime());
							boolean cond6 = inputAppointment.getDayWithEndTime()
									.isBefore(appointment.getDayWithEndTime());

							boolean cond7 = appointment.getDayWithStartTime()
									.isAfter(inputAppointment.getDayWithStartTime());

							boolean cond8 = appointment.getDayWithStartTime()
									.isBefore(inputAppointment.getDayWithEndTime());

							boolean cond9 = appointment.getDayWithEndTime()
									.isBefore(inputAppointment.getDayWithEndTime());

							boolean cond10 = appointment.getDayWithEndTime()
									.isAfter(inputAppointment.getDayWithStartTime());

							if (cond1) {
								System.err.println("The start time " + appointment.getDayWithStartTime()
										+ " of the appointment " + appointment.getId() + " equals with the start time "
										+ inputAppointment.getDayWithStartTime() + " of the appointment "
										+ inputAppointment.getId() + ". Appointment " + inputAppointment.getId()
										+ " can´t be added.");
								return;
							} else if (cond3 && cond4) {
								System.err.println("The start time " + inputAppointment.getDayWithStartTime()
										+ " of the appointment " + inputAppointment.getId()
										+ " is between the start time " + appointment.getDayWithStartTime()
										+ " and end time " + appointment.getDayWithEndTime() + " of the appointment "
										+ appointment.getId() + ". Appointment " + inputAppointment.getId()
										+ " can´t be added.");
								return;
							} else if (cond5 && cond6) {
								System.err.println("The end time " + inputAppointment.getDayWithEndTime()
										+ " of the appointment " + inputAppointment.getId()
										+ " is between the start time " + appointment.getDayWithStartTime()
										+ " and end time " + appointment.getDayWithEndTime() + " of the appointment "
										+ appointment.getId() + ". Appointment " + inputAppointment.getId()
										+ " can´t be added.");
								return;
							} else if (cond7 && cond8) {
								System.err.println("The start time " + appointment.getDayWithStartTime()
										+ " of the appointment " + appointment.getId() + " is between the start time "
										+ inputAppointment.getDayWithStartTime() + " and end time "
										+ inputAppointment.getDayWithEndTime() + " of the appointment "
										+ inputAppointment.getId() + ". Appointment " + inputAppointment.getId()
										+ " can´t be added.");
								return;
							} else if (cond9 && cond10) {
								System.err.println("The end time " + appointment.getDayWithEndTime()
										+ " of the appointment " + appointment.getId() + " is between the start time "
										+ inputAppointment.getDayWithStartTime() + " and end time "
										+ inputAppointment.getDayWithEndTime() + " of the appointment "
										+ inputAppointment.getId() + ". Appointment " + inputAppointment.getId()
										+ " can´t be added.");
								return;
							}
							conditionAddAppointment = true;
						}
						if (conditionAddAppointment) {
							listOfAppointments.add(inputAppointment);
							System.out.println(
									"The Appointment " + inputAppointment.getId() + " was successfully added.");
						}
					} else {
						listOfAppointments.add(inputAppointment);
						System.out.println("The Appointment " + inputAppointment.getId() + " was successfully added.");
					}

				} else {
					System.err.println("The appointment is outside of working hours.");
				}
			} else {
				System.err.println("The appointment can't be added, because the appointment " + inputAppointment.getId()
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

	public void setAutomaticallyCleaningAppointment(WorkingPlatform workingPlatform, CLEANINGPROGRAMM cleaningProgram,
			Dispatcher dispatcher) {
		// Methode für die nächstbeste Zeit finden

		LocalDateTime timeAfterDuration = LocalDateTime.now().plusMinutes(100);
		LocalDateTime now = LocalDateTime.now();

		List<Appointment> listOfPlannedWorksForWorkingPlatformAfterNow = new ArrayList<>();

		for (Appointment appointment : workingPlatform.getListOfPlannedWorks()) {
			if (appointment.getDayWithEndTime().isAfter(now)) {
				listOfPlannedWorksForWorkingPlatformAfterNow.add(appointment);
			}
		}

		Collections.sort(listOfPlannedWorksForWorkingPlatformAfterNow, new Comparator<Appointment>() {

			@Override
			public int compare(Appointment firstAppointment, Appointment secondAppointment) {
				return firstAppointment.getDayWithStartTime().compareTo(secondAppointment.getDayWithStartTime());
			}
		});

		if (!listOfPlannedWorksForWorkingPlatformAfterNow.isEmpty()) {
			Appointment nextAppointmentForWorkingPlatform = listOfPlannedWorksForWorkingPlatformAfterNow.get(0);

			if (timeAfterDuration.isBefore(nextAppointmentForWorkingPlatform.getDayWithStartTime())) {

				int year = (int) now.plusMinutes(10).getYear();
				int month = (int) now.plusMinutes(10).getMonthValue();
				int day = (int) now.plusMinutes(10).getDayOfMonth();
				int hour = (int) now.plusMinutes(10).getHour();
				int minute = (int) now.plusMinutes(10).getMinute();

				CleaningAppointment automaticAppointment = new CleaningAppointment(year, month, day, hour, minute,
						workingPlatform, cleaningProgram, dispatcher);
				createNewAppointment(automaticAppointment);

			} else {

				int lengthOfList = listOfPlannedWorksForWorkingPlatformAfterNow.size();
				int listElementCounter;
				for (listElementCounter = 0; listElementCounter < lengthOfList; listElementCounter++) {

					Appointment thisObjectFromList = listOfPlannedWorksForWorkingPlatformAfterNow
							.get(listElementCounter);
					Appointment nextObjectFromList = listOfPlannedWorksForWorkingPlatformAfterNow
							.get(listElementCounter + 1);

					int sizeList = listOfPlannedWorksForWorkingPlatformAfterNow.size();
					Appointment lastObjectFromList = listOfPlannedWorksForWorkingPlatformAfterNow.get(sizeList - 1);

					int differenceBetweenAppointments = (int) ChronoUnit.MINUTES
							.between(thisObjectFromList.getDayWithEndTime(), nextObjectFromList.getDayWithStartTime());

					System.err.println("Difference between the end of appointment " + thisObjectFromList.getId()
							+ " and next appointment " + nextObjectFromList.getId() + " is "
							+ differenceBetweenAppointments + " Minutes.");

					if (differenceBetweenAppointments > 50 && cleaningProgram.equals(CLEANINGPROGRAMM.FAST)) {
						int year = (int) thisObjectFromList.getDayWithEndTime().plusMinutes(10).getYear();
						int month = (int) thisObjectFromList.getDayWithEndTime().plusMinutes(10).getMonthValue();
						int day = (int) thisObjectFromList.getDayWithEndTime().plusMinutes(10).getDayOfMonth();
						int hour = (int) thisObjectFromList.getDayWithEndTime().plusMinutes(10).getHour();
						int minute = (int) thisObjectFromList.getDayWithEndTime().plusMinutes(10).getMinute();

						CleaningAppointment automaticAppointment = new CleaningAppointment(year, month, day, hour,
								minute, workingPlatform, cleaningProgram, dispatcher);
						createNewAppointment(automaticAppointment);
						System.err.println("1");
						return;
					} else if (differenceBetweenAppointments > 80 && cleaningProgram.equals(CLEANINGPROGRAMM.INTENSE)) {
						int year = (int) thisObjectFromList.getDayWithEndTime().plusMinutes(10).getYear();
						int month = (int) thisObjectFromList.getDayWithEndTime().plusMinutes(10).getMonthValue();
						int day = (int) thisObjectFromList.getDayWithEndTime().plusMinutes(10).getDayOfMonth();
						int hour = (int) thisObjectFromList.getDayWithEndTime().plusMinutes(10).getHour();
						int minute = (int) thisObjectFromList.getDayWithEndTime().plusMinutes(10).getMinute();

						CleaningAppointment automaticAppointment = new CleaningAppointment(year, month, day, hour,
								minute, workingPlatform, cleaningProgram, dispatcher);
						createNewAppointment(automaticAppointment);
						System.err.println("2");
						return;

					} else if (nextObjectFromList.getId().equals(lastObjectFromList.getId())) {
						int year = (int) lastObjectFromList.getDayWithEndTime().plusMinutes(5).getYear();
						int month = (int) lastObjectFromList.getDayWithEndTime().plusMinutes(5).getMonthValue();
						int day = (int) lastObjectFromList.getDayWithEndTime().plusMinutes(5).getDayOfMonth();
						int hour = (int) lastObjectFromList.getDayWithEndTime().plusMinutes(5).getHour();
						int minute = (int) lastObjectFromList.getDayWithEndTime().plusMinutes(5).getMinute();
						CleaningAppointment automaticAppointment = new CleaningAppointment(year, month, day, hour,
								minute, workingPlatform, cleaningProgram, dispatcher);
						createNewAppointment(automaticAppointment);
						System.err.println("4");
						return;

					} else if (differenceBetweenAppointments <= 50 && cleaningProgram.equals(CLEANINGPROGRAMM.FAST)
							|| differenceBetweenAppointments <= 80
									&& cleaningProgram.equals(CLEANINGPROGRAMM.INTENSE)) {

						System.err.println("check for the next appointments in the list");
						System.err.println("5");

					}

				}

			}

		} else {

			int year = (int) now.plusMinutes(5).getYear();
			int month = (int) now.plusMinutes(5).getMonthValue();
			int day = (int) now.plusMinutes(5).getDayOfMonth();
			int hour = (int) now.plusMinutes(5).getHour();
			int minute = (int) now.plusMinutes(5).getMinute();

			CleaningAppointment automaticAppointment = new CleaningAppointment(year, month, day, hour, minute,
					workingPlatform, cleaningProgram, dispatcher);
			createNewAppointment(automaticAppointment);

		}
	}

	public void getOverviewOfTodayWorks(CarMechanic carMechanic, WorkingPlatform workingPlatform) {

		// text
		LocalDateTime todayWithTime = LocalDateTime.now();
		List<Appointment> listOfFoundPlannedWorks = new ArrayList<>();

		if (carMechanic != null && workingPlatform != null) {
			for (Appointment currentWorkingAppointment : listOfAppointments) {
				if (currentWorkingAppointment instanceof WorkingAppointment) {

					// @formatter:off
					boolean greaterOrEqualTime = currentWorkingAppointment.getDayWithStartTime().compareTo(todayWithTime) > 0;
					boolean equalWorkingPlatform = currentWorkingAppointment.getWorkingPlatform().equals(workingPlatform);
					boolean equalCarMechanic = ((WorkingAppointment) currentWorkingAppointment).getCarMechanic().equals(carMechanic);
					boolean equalStatus = ((WorkingAppointment) currentWorkingAppointment).isCompleted() == false;
					
					if (greaterOrEqualTime && equalWorkingPlatform && equalCarMechanic && equalStatus) {
						listOfFoundPlannedWorks.add(currentWorkingAppointment);
					}	
				}
			}
			if (listOfFoundPlannedWorks.size() > 0) {
				for (Appointment currentWorkingAppointment : listOfFoundPlannedWorks) {
					System.out.println("The " + carMechanic.getId() + " has the "
							+ ((WorkingAppointment) currentWorkingAppointment).getService().getId() + " on the date and time "
							+ currentWorkingAppointment.startOfAppointment + " and on the working platform "
							+ currentWorkingAppointment.getWorkingPlatform().getId());
				}
			} else {
				System.err.println("The car mechanic " + carMechanic.getId() + " has on the working platform "
						+ workingPlatform.getId() + " no services for today: " + todayWithTime);
			}
		} else {
			System.err.println("You have not entered a car mechanic or working platform.");
		}
	}
	
	public void getSuggestThreeWorkingAppointments() {
		
	}
}