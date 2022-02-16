package de.hs_kl.staab.planner;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PlanningCalendar {

	private static PlanningCalendar INSTANCE;

	public static PlanningCalendar getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new PlanningCalendar();
		}
		return INSTANCE;
	}

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

	public void createAppointmentWithLocalDateTime(LocalDateTime localDateTime, WorkingPlatform workingPlatform,
			CLEANINGPROGRAMM cleaningProgram, Dispatcher dispatcher) {
		int year = (int) localDateTime.plusMinutes(10).getYear();
		int month = (int) localDateTime.plusMinutes(10).getMonthValue();
		int day = (int) localDateTime.plusMinutes(10).getDayOfMonth();
		int hour = (int) localDateTime.plusMinutes(10).getHour();
		int minute = (int) localDateTime.plusMinutes(10).getMinute();

		CleaningAppointment newAppointment = new CleaningAppointment(year, month, day, hour, minute, workingPlatform,
				cleaningProgram, dispatcher);

		createNewAppointment(newAppointment);

	}

	public void createAppointmentWhenIsInWorkingHours(LocalDateTime localDateTime, WorkingPlatform workingPlatform,
			CLEANINGPROGRAMM cleaningProgram, Dispatcher dispatcher) {

		int year = (int) localDateTime.plusMinutes(10).getYear();
		int month = (int) localDateTime.plusMinutes(10).getMonthValue();
		int day = (int) localDateTime.plusMinutes(10).getDayOfMonth();
		int hour = (int) localDateTime.plusMinutes(10).getHour();
		int minute = (int) localDateTime.plusMinutes(10).getMinute();
		CleaningAppointment newAppointment = new CleaningAppointment(year, month, day, hour, minute, workingPlatform,
				cleaningProgram, dispatcher);

		if (newAppointment.isAppointmentInWorkingTime()) {

			createNewAppointment(newAppointment);

		} else if (localDateTime.plusMinutes(10).getHour() >= 15) {

			// create appointment for next day 8:00 because not in working hours and last
			// appointment for list is before the new
			// appointment

			int year2 = (int) localDateTime.getYear();
			int month2 = (int) localDateTime.getMonthValue();
			int day2 = (int) localDateTime.plusDays(1).getDayOfMonth();
			int hour2 = 8;
			int minute2 = 0;
			CleaningAppointment newAppointment2 = new CleaningAppointment(year2, month2, day2, hour2, minute2,
					workingPlatform, cleaningProgram, dispatcher);
			createNewAppointment(newAppointment2);

		} else if (localDateTime.plusMinutes(10).getHour() < 8) {

			// create appointment for next day 8:00 because not in working hours and last
			// appointment for list is before the new
			// appointment

			int year2 = (int) localDateTime.getYear();
			int month2 = (int) localDateTime.getMonthValue();
			int day2 = (int) localDateTime.getDayOfMonth();
			int hour2 = 8;
			int minute2 = 0;
			CleaningAppointment newAppointment2 = new CleaningAppointment(year2, month2, day2, hour2, minute2,
					workingPlatform, cleaningProgram, dispatcher);
			createNewAppointment(newAppointment2);

		}
	}

	public void setAutomaticallyCleaningAppointment(WorkingPlatform workingPlatform, CLEANINGPROGRAMM cleaningProgram,
			Dispatcher dispatcher) {

		LocalDateTime timeAfterDuration = LocalDateTime.now().plusMinutes(80);
		LocalDateTime now = LocalDateTime.now();

		List<Appointment> listOfPlannedWorksForWorkingPlatformAfterNow = new ArrayList<>();

		for (Appointment appointment : listOfAppointments) {
			if (appointment instanceof WorkingAppointment || appointment instanceof CleaningAppointment) {
				if (appointment.getDayWithEndTime().isAfter(now)
						&& appointment.getWorkingPlatform().equals(workingPlatform)) {
					listOfPlannedWorksForWorkingPlatformAfterNow.add(appointment);
				}
			}
		}
		// if list is empty create new appointment
		if (!listOfPlannedWorksForWorkingPlatformAfterNow.isEmpty()) {

			// appointments sorting by start time
			Collections.sort(listOfPlannedWorksForWorkingPlatformAfterNow, new Comparator<Appointment>() {

				@Override
				public int compare(Appointment firstAppointment, Appointment secondAppointment) {
					return firstAppointment.getDayWithStartTime().compareTo(secondAppointment.getDayWithStartTime());
				}
			});

			int sizeListAppointmentsAfterNow = listOfPlannedWorksForWorkingPlatformAfterNow.size();
			Appointment nextAppointmentForWorkingPlatform = listOfPlannedWorksForWorkingPlatformAfterNow.get(0);

			// if there is more than one appointment its possible to compare to appointments
			if (sizeListAppointmentsAfterNow >= 2) {

				int listAppointmentCounter;
				for (listAppointmentCounter = 0; listAppointmentCounter < sizeListAppointmentsAfterNow; listAppointmentCounter++) {

					Appointment thisAppointmentFromList = listOfPlannedWorksForWorkingPlatformAfterNow
							.get(listAppointmentCounter);
					Appointment nextAppointmentFromList = listOfPlannedWorksForWorkingPlatformAfterNow
							.get(listAppointmentCounter + 1);
					Appointment firstAppointmentFromList = listOfPlannedWorksForWorkingPlatformAfterNow.get(0);
					Appointment lastAppointmentFromList = listOfPlannedWorksForWorkingPlatformAfterNow
							.get(sizeListAppointmentsAfterNow - 1);

					// difference the end time of the this appointment with the start time of the
					// next appointment thats
					// the difference between appointments

					int differenceBetweenAppointments = (int) ChronoUnit.MINUTES.between(
							thisAppointmentFromList.getDayWithEndTime(), nextAppointmentFromList.getDayWithStartTime());

					if (nextAppointmentFromList.getId().equals(lastAppointmentFromList.getId())) {
						if (differenceBetweenAppointments > 50 && cleaningProgram.equals(CLEANINGPROGRAMM.FAST)) {

							int year = (int) thisAppointmentFromList.getDayWithEndTime().plusMinutes(10).getYear();
							int month = (int) thisAppointmentFromList.getDayWithEndTime().plusMinutes(10)
									.getMonthValue();
							int day = (int) thisAppointmentFromList.getDayWithEndTime().plusMinutes(10).getDayOfMonth();
							int hour = (int) thisAppointmentFromList.getDayWithEndTime().plusMinutes(10).getHour();
							int minute = (int) thisAppointmentFromList.getDayWithEndTime().plusMinutes(10).getMinute();

							CleaningAppointment newAppointment = new CleaningAppointment(year, month, day, hour, minute,
									workingPlatform, cleaningProgram, dispatcher);

							if (newAppointment.isAppointmentInWorkingTime()) {
								createNewAppointment(newAppointment);
								return;
							}

						} else if (differenceBetweenAppointments > 80
								&& cleaningProgram.equals(CLEANINGPROGRAMM.INTENSE)) {
							int year = (int) thisAppointmentFromList.getDayWithEndTime().plusMinutes(10).getYear();
							int month = (int) thisAppointmentFromList.getDayWithEndTime().plusMinutes(10)
									.getMonthValue();
							int day = (int) thisAppointmentFromList.getDayWithEndTime().plusMinutes(10).getDayOfMonth();
							int hour = (int) thisAppointmentFromList.getDayWithEndTime().plusMinutes(10).getHour();
							int minute = (int) thisAppointmentFromList.getDayWithEndTime().plusMinutes(10).getMinute();

							CleaningAppointment newAppointment = new CleaningAppointment(year, month, day, hour, minute,
									workingPlatform, cleaningProgram, dispatcher);

							if (newAppointment.isAppointmentInWorkingTime()) {
								createNewAppointment(newAppointment);
								return;
							}

						}
						createAppointmentWhenIsInWorkingHours(lastAppointmentFromList.getDayWithEndTime(),
								workingPlatform, cleaningProgram, dispatcher);

						return;

					}
					// if the next appointment is after 80 minutes and in the working hours
					else if (timeAfterDuration.isBefore(firstAppointmentFromList.getDayWithStartTime())) {

						int year = (int) firstAppointmentFromList.getDayWithStartTime().minusMinutes(80).getYear();
						int month = (int) firstAppointmentFromList.getDayWithStartTime().minusMinutes(80)
								.getMonthValue();
						int day = (int) firstAppointmentFromList.getDayWithStartTime().minusMinutes(80).getDayOfMonth();
						int hour = (int) firstAppointmentFromList.getDayWithStartTime().minusMinutes(80).getHour();
						int minute = (int) firstAppointmentFromList.getDayWithStartTime().minusMinutes(80).getMinute();

						CleaningAppointment newAppointment = new CleaningAppointment(year, month, day, hour, minute,
								workingPlatform, cleaningProgram, dispatcher);

						if (newAppointment.isAppointmentInWorkingTime()) {
							createNewAppointment(newAppointment);
							return;
						}

					} else if (differenceBetweenAppointments > 50 && cleaningProgram.equals(CLEANINGPROGRAMM.FAST)) {

						int year = (int) thisAppointmentFromList.getDayWithEndTime().plusMinutes(10).getYear();
						int month = (int) thisAppointmentFromList.getDayWithEndTime().plusMinutes(10).getMonthValue();
						int day = (int) thisAppointmentFromList.getDayWithEndTime().plusMinutes(10).getDayOfMonth();
						int hour = (int) thisAppointmentFromList.getDayWithEndTime().plusMinutes(10).getHour();
						int minute = (int) thisAppointmentFromList.getDayWithEndTime().plusMinutes(10).getMinute();

						CleaningAppointment newAppointment = new CleaningAppointment(year, month, day, hour, minute,
								workingPlatform, cleaningProgram, dispatcher);

						if (newAppointment.isAppointmentInWorkingTime()) {
							createNewAppointment(newAppointment);
							return;
						}

					} else if (differenceBetweenAppointments > 80 && cleaningProgram.equals(CLEANINGPROGRAMM.INTENSE)) {

						int year = (int) thisAppointmentFromList.getDayWithEndTime().plusMinutes(10).getYear();
						int month = (int) thisAppointmentFromList.getDayWithEndTime().plusMinutes(10).getMonthValue();
						int day = (int) thisAppointmentFromList.getDayWithEndTime().plusMinutes(10).getDayOfMonth();
						int hour = (int) thisAppointmentFromList.getDayWithEndTime().plusMinutes(10).getHour();
						int minute = (int) thisAppointmentFromList.getDayWithEndTime().plusMinutes(10).getMinute();

						CleaningAppointment newAppointment = new CleaningAppointment(year, month, day, hour, minute,
								workingPlatform, cleaningProgram, dispatcher);

						if (newAppointment.isAppointmentInWorkingTime()) {
							createNewAppointment(newAppointment);
							return;
						}

					}

				}

			}

			else if (sizeListAppointmentsAfterNow == 1) {

				if (timeAfterDuration.isBefore(nextAppointmentForWorkingPlatform.getDayWithStartTime())
						&& now.getHour() >= 8 && now.getHour() < 16) {

					createAppointmentWithLocalDateTime(now, workingPlatform, cleaningProgram, dispatcher);

				} else {
					createAppointmentWhenIsInWorkingHours(nextAppointmentForWorkingPlatform.getDayWithEndTime(),
							workingPlatform, cleaningProgram, dispatcher);

				}
			}
		}
		// If there is no scheduled appointment for this working platform
		else

		{

			createAppointmentWhenIsInWorkingHours(now, workingPlatform, cleaningProgram, dispatcher);
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
							+ ((WorkingAppointment) currentWorkingAppointment).getService() + " on the date and time "
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
	
	public void setAutomaticallyCleaningAppointment2(WorkingPlatform workingPlatform, CLEANINGPROGRAMM cleaningProgram,
			Dispatcher dispatcher) {
		
		if(workingPlatform != null && cleaningProgram != null && dispatcher != null) {
			final int PREPARATION_TIME_IN_DAY = 2;
			
			// Today + Preparation time to prepare the work on the vehicle (2 day)
			final LocalDate planningTime = LocalDate.now().plusDays(PREPARATION_TIME_IN_DAY);
			
			final LocalTime START_TIME_OF_DAY = Appointment.OPENING_TIME_START;
			final LocalTime END_TIME_OF_DAY = Appointment.OPENING_TIME_END;
			
			List<LocalDate> workingDays = this.getWorkingDays(planningTime, planningTime.plusWeeks(1));
			List<SuggestionDate> listOfSuggestionDates = new ArrayList<>();
			List<SuggestionDate> listOfRemoveSuggestionDates = new ArrayList<>();
			
			LocalTime startTimeOfService;
			LocalTime endTimeOfService;
			int cleaningDurationInMin = 0;
			
			switch(cleaningProgram) {
			case FAST: cleaningDurationInMin = (int) (0.5 * Appointment.TIME_CONVERSION_FAKTOR_IN_MINUTES); break;
			case INTENSE: cleaningDurationInMin = (int) (1.0 * Appointment.TIME_CONVERSION_FAKTOR_IN_MINUTES); break;
			}
			
			LocalTime lastPossibleAppointmentOfDay = END_TIME_OF_DAY.minusMinutes((long) cleaningDurationInMin);
			long durationInMinutes = ChronoUnit.MINUTES.between(START_TIME_OF_DAY, lastPossibleAppointmentOfDay);
			
			// 1. Creates future appointments for the customer
			for(LocalDate localDate : workingDays) {
				for(long minutes = 0; minutes <= durationInMinutes; minutes += cleaningDurationInMin) {
								
					startTimeOfService = START_TIME_OF_DAY.plusMinutes(minutes);
					endTimeOfService = startTimeOfService.plusMinutes((long) (cleaningDurationInMin));
								
					LocalDateTime startOfSuggestionDate = localDate.atTime(startTimeOfService);
					LocalDateTime endOfSuggestionDate = localDate.atTime(endTimeOfService);
								
					listOfSuggestionDates.add(new SuggestionDate(startOfSuggestionDate, endOfSuggestionDate));
				}
			}
			
			// 2.
			for(SuggestionDate suggestionDate : listOfSuggestionDates) {
				for(Appointment appointment : listOfAppointments) {
					// Filters out all cleaning appointments
					if(appointment instanceof CleaningAppointment) {
						if(appointment.getDay().compareTo(planningTime) >= 0) {
							
							if(appointment.getWorkingPlatform().equals(workingPlatform)) {
								
								// @formatter:off
								boolean cond01 = suggestionDate.getStart().equals(appointment.getDayWithStartTime());
								boolean cond02 = suggestionDate.getEnd().equals(appointment.getDayWithEndTime());

								boolean cond03 = suggestionDate.getStart().isAfter(appointment.getDayWithStartTime());
								boolean cond04 = suggestionDate.getStart().isBefore(appointment.getDayWithEndTime());

								boolean cond05 = suggestionDate.getEnd().isAfter(appointment.getDayWithStartTime());
								boolean cond06 = suggestionDate.getEnd().isBefore(appointment.getDayWithEndTime());

								boolean cond07 = appointment.getDayWithStartTime().isAfter(suggestionDate.getStart());

								boolean cond08 = appointment.getDayWithStartTime().isBefore(suggestionDate.getEnd());

								boolean cond09 = appointment.getDayWithEndTime().isBefore(suggestionDate.getEnd());

								boolean cond10 = appointment.getDayWithEndTime().isAfter(suggestionDate.getStart());
								
								if(cond01 && cond02) { listOfRemoveSuggestionDates.add(suggestionDate);
								} else if(cond03 && cond04) {	listOfRemoveSuggestionDates.add(suggestionDate); 
								} else if(cond05 && cond06) {	listOfRemoveSuggestionDates.add(suggestionDate); 
								} else if(cond07 && cond08) {	listOfRemoveSuggestionDates.add(suggestionDate); 
								} else if(cond09 && cond10) {	listOfRemoveSuggestionDates.add(suggestionDate); 
								}
							}
						}
					}
				}
			}
			
			// 3.
			listOfSuggestionDates.removeAll(listOfRemoveSuggestionDates);
			
			// 4.
			if(!listOfSuggestionDates.isEmpty()) {
				SuggestionDate suggestionDate = listOfSuggestionDates.get(0);
				int year = suggestionDate.getStart().getYear();
				int month = suggestionDate.getStart().getMonthValue();
				int day = suggestionDate.getStart().getDayOfMonth();
				int hour = suggestionDate.getStart().getHour();
				int minutes = suggestionDate.getStart().getMinute();

				listOfAppointments.add(new CleaningAppointment(year, month, day, hour, minutes, workingPlatform, cleaningProgram, dispatcher));
				System.out.println("Es wurde erfolgreich ein Termin angelegt.");
			} else {
				System.err.println("KEIN TERMIN FREI; DER ZEITRAUM IST AUSGEBUCHT.");
			}
		} else {
			System.err.println("ERROR");
		}
	}
	
	public void getSuggestThreeWorkingAppointments(Service service, WorkingPlatform workingPlatform) {
		
		if(service != null && workingPlatform != null) {
			final int PREPARATION_TIME_IN_DAY = 2;
			final int APPOINTMENT_NUMBER_FAKTOR = 3;
			
			// Today + Preparation time to prepare the work on the vehicle (2 day)
			final LocalDate planningTime = LocalDate.now().plusDays(PREPARATION_TIME_IN_DAY);
			
			final LocalTime START_TIME_OF_DAY = Appointment.OPENING_TIME_START;
			final LocalTime END_TIME_OF_DAY = Appointment.OPENING_TIME_END;
			
			List<LocalDate> workingDays = this.getWorkingDays(planningTime, planningTime.plusWeeks(1));
			List<SuggestionDate> listOfSuggestionDates = new ArrayList<>();
			List<SuggestionDate> listOfRemoveSuggestionDates = new ArrayList<>();
			
			LocalTime startTimeOfService;
			LocalTime endTimeOfService;
			int serviceDurationInMin = (int) (service.getDurationInH() * 60);
			LocalTime lastPossibleAppointmentOfDay = END_TIME_OF_DAY.minusMinutes((long) serviceDurationInMin);
			long durationInMinutes = ChronoUnit.MINUTES.between(START_TIME_OF_DAY, lastPossibleAppointmentOfDay);
			
			// 1. Creates future appointments for the customer
			for(LocalDate localDate : workingDays) {
				for(long minutes = 0; minutes <= durationInMinutes; minutes += serviceDurationInMin) {
					
					startTimeOfService = START_TIME_OF_DAY.plusMinutes(minutes);
					endTimeOfService = startTimeOfService.plusMinutes((long) (service.getDurationInH() * 60));
					
					LocalDateTime startOfSuggestionDate = localDate.atTime(startTimeOfService);
					LocalDateTime endOfSuggestionDate = localDate.atTime(endTimeOfService);
					
					listOfSuggestionDates.add(new SuggestionDate(startOfSuggestionDate, endOfSuggestionDate));
				}
			}
			
			// 2. Checks if there is an appointment on that day and removes the existing suggestion date
			for(SuggestionDate suggestionDate : listOfSuggestionDates) {
				for(Appointment appointment : listOfAppointments) {
					// Filters out all working appointments
					if(appointment instanceof WorkingAppointment) {
						if(appointment.getDay().compareTo(planningTime) >= 0) {
							if(appointment.getWorkingPlatform().equals(workingPlatform)) {
								
								// @formatter:off
								boolean cond01 = suggestionDate.getStart().equals(appointment.getDayWithStartTime());
								boolean cond02 = suggestionDate.getEnd().equals(appointment.getDayWithEndTime());

								boolean cond03 = suggestionDate.getStart().isAfter(appointment.getDayWithStartTime());
								boolean cond04 = suggestionDate.getStart().isBefore(appointment.getDayWithEndTime());

								boolean cond05 = suggestionDate.getEnd().isAfter(appointment.getDayWithStartTime());
								boolean cond06 = suggestionDate.getEnd().isBefore(appointment.getDayWithEndTime());

								boolean cond07 = appointment.getDayWithStartTime().isAfter(suggestionDate.getStart());

								boolean cond08 = appointment.getDayWithStartTime().isBefore(suggestionDate.getEnd());

								boolean cond09 = appointment.getDayWithEndTime().isBefore(suggestionDate.getEnd());

								boolean cond10 = appointment.getDayWithEndTime().isAfter(suggestionDate.getStart());
								
								if(cond01 && cond02) { listOfRemoveSuggestionDates.add(suggestionDate);
								} else if(cond03 && cond04) {	listOfRemoveSuggestionDates.add(suggestionDate); 
								} else if(cond05 && cond06) {	listOfRemoveSuggestionDates.add(suggestionDate); 
								} else if(cond07 && cond08) {	listOfRemoveSuggestionDates.add(suggestionDate); 
								} else if(cond09 && cond10) {	listOfRemoveSuggestionDates.add(suggestionDate); 
								} 
							}
						}
					}
				}
			}
			listOfSuggestionDates.removeAll(listOfRemoveSuggestionDates);
			//listOfSuggestionDates.stream().forEach(s -> System.out.println(s));
			int counter = 0;
			
			for (SuggestionDate suggestionDate : listOfSuggestionDates) {
				System.out.println(suggestionDate);
				counter++;
				if(counter == APPOINTMENT_NUMBER_FAKTOR) break;
			}
		} else {
			System.err.println("Du musst ein Service eintippen.");
		}
	}
	
	public List<LocalDate> getWorkingDays(LocalDate start, LocalDate end) {
		// Monday until Saturday, without Sunday
		Predicate<LocalDate> isNotSunday = day -> day.getDayOfWeek() != DayOfWeek.SUNDAY;
		
		List<LocalDate> allDay = start.datesUntil(end).filter(isNotSunday).collect(Collectors.toList());
		return allDay;
	}
}