package de.hs_kl.staab.planner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Verwaltet den Planungskalender
 */
public class PlannerService {

	private static PlannerService INSTANCE;

	private final PlanningCalendar planningCalendar;

	private List<WorkingPlatform> listOfWorkingPlatforms = new ArrayList<>();
	private List<Service> listOfServices = new ArrayList<>();

	/**
	 * Singleton-Pattern: Der Konstruktor kann nicht aufgerufen werden, sondern
	 * {@link #getInstance()} muss aufgerufen werden. So kann sichergestellt werden,
	 * dass nur eine einzige Instanz dieser Klasse erstellt wird.
	 */
	private PlannerService() {
		planningCalendar = new PlanningCalendar();
	}

	/**
	 * Teil des Singleton-Patterns
	 * 
	 * @return Die einzige Instanz des PlannerService.
	 */
	public static PlannerService getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new PlannerService();
		}
		return INSTANCE;
	}

	public PlanningCalendar getPlanningCalendar() {
		return planningCalendar;
	}

	/* ******************************************* */
	/* * HIER KÖNNEN SIE IHRE METHODEN SCHREIBEN * */
	/* * Dieser Service bietet alle Funktionen *** */
	/* * an, die Ihre Anwendung bietet. So ******* */
	/* * können beispielsweise Anfragen validiert* */
	/* * werden, bevor Sie diese an den Kalender * */
	/* * weitergeben. **************************** */
	/* ******************************************* */

	public WorkingPlatform getWorkingPlatformById(String workingPlatformId) {
		if (!listOfWorkingPlatforms.isEmpty()) {
			for (WorkingPlatform workingPlatform : listOfWorkingPlatforms) {
				if (workingPlatform.getId().equals(workingPlatformId)) {
					return workingPlatform;
				}
			}
		} else {
			throw new IllegalArgumentException("The list of workingplatforms is empty.");
		}
		throw new IllegalArgumentException("The workingplatform with the id " + workingPlatformId + " was not found.");
	}

	public void getWorkingPlatforms() {
		if (!listOfWorkingPlatforms.isEmpty()) {
			for (WorkingPlatform workingPlatform : listOfWorkingPlatforms) {
				System.out.println(workingPlatform);
			}
		} else {
			throw new IllegalArgumentException("The list of workingplatforms is empty.");
		}
	}

	public void createNewWorkingPlatform(WorkingPlatform newWorkingPlatform) {
		if (!listOfWorkingPlatforms.contains(newWorkingPlatform)) {
			listOfWorkingPlatforms.add(newWorkingPlatform);
			System.out.println("The workingplatform " + newWorkingPlatform.getId() + "  was successfully added.");
		} else {
			throw new IllegalArgumentException(
					"The working platform cannot be added because it already exists in the list");
		}
	}

	public void updateWorkingPlatform(WorkingPlatform oldWorkingPlatform, WorkingPlatform newWorkingPlatform) {
		if (!listOfWorkingPlatforms.isEmpty()) {
			for (WorkingPlatform actualWorkingPlatform : listOfWorkingPlatforms) {
				if (actualWorkingPlatform.equals(oldWorkingPlatform)) {

					// Assigns the id of the old object to the new object
					newWorkingPlatform.setId(oldWorkingPlatform.getId());
					listOfWorkingPlatforms.set(listOfWorkingPlatforms.indexOf(oldWorkingPlatform), newWorkingPlatform);
				}
			}
		} else {
			throw new IllegalArgumentException(
					"The working platform cannot be updated because the list of workingplatforms is empty.");
		}
	}

	public void removeWorkingPlatform(WorkingPlatform removeWorkingPlatform) {
		if (!listOfWorkingPlatforms.isEmpty()) {
			listOfWorkingPlatforms.remove(removeWorkingPlatform);
			System.out.println("The workingplatform " + removeWorkingPlatform.getId() + "  was successfully deleted.");
		} else {
			throw new IllegalArgumentException("The workingplatform " + removeWorkingPlatform.getId()
					+ " can't be deleted, because the list of workingplatforms is empty.");
		}
	}

	public Service getServiceById(String serviceId) {
		if (!listOfServices.isEmpty()) {
			for (Service service : listOfServices) {
				if (service.getId().equals(serviceId)) {
					return service;
				}
			}
		} else {
			throw new IllegalArgumentException("The list of services is empty.");
		}
		throw new IllegalArgumentException("The service with the id " + serviceId + " was not found.");
	}

	public void getServices() {
		if (!listOfServices.isEmpty()) {
			for (Service service : listOfServices) {
				System.out.println(service);
			}
		} else {
			throw new IllegalArgumentException("The list of services is empty.");
		}
	}

	public void createNewService(Service newService) {
		if (!listOfServices.contains(newService)) {
			listOfServices.add(newService);
			System.out.println("The service " + newService.getId() + "  was successfully added.");
		} else {
			throw new IllegalArgumentException("The service cannot be added because it already exists in the list");
		}
	}

	public void updateService(Service oldService, Service newService) {
		if (!listOfServices.isEmpty()) {
			for (Service actualService : listOfServices) {
				if (actualService.equals(oldService)) {

					// Assigns the id of the old object to the new object
					newService.setId(oldService.getId());
					listOfServices.set(listOfServices.indexOf(oldService), newService);
				}
			}
		} else {
			throw new IllegalArgumentException("The service cannot be updated because the list of services is empty.");
		}
	}

	public void removeService(Service removeService) {
		if (!listOfServices.isEmpty()) {
			listOfServices.remove(removeService);
			System.out.println("The service " + removeService.getId() + "  was successfully deleted.");
		} else {
			throw new IllegalArgumentException("The service " + removeService.getId()
					+ " can't be deleted, because the list of services is empty.");
		}
	}

	public void getOverviewOfPlannedWorks(WorkingPlatform workingPlatform) {
		LocalDate todayDay = LocalDate.now();
		List<WorkingAppointment> listOfFoundPlannedWorks = new ArrayList<>();

		if (workingPlatform != null) {
			if (listOfWorkingPlatforms.contains(workingPlatform)) {
				for (WorkingAppointment currentWorkingAppointment : workingPlatform.getListOfPlannedWorks()) {
					if (currentWorkingAppointment.getDay().equals(todayDay)
							&& currentWorkingAppointment.isCompleted() == false) {
						listOfFoundPlannedWorks.add(currentWorkingAppointment);
					}
				}
			} else {
				System.err.println("You have not entered a working platform.");
			}

			if (listOfFoundPlannedWorks.size() > 0) {
				Collections.sort(listOfFoundPlannedWorks, new Comparator<Appointment>() {

					@Override
					public int compare(Appointment firstAppointment, Appointment secondAppointment) {
						return firstAppointment.getStart().compareTo(secondAppointment.getStart());
					}
				});

				for (WorkingAppointment workingAppointment : listOfFoundPlannedWorks) {
					System.out.println(workingAppointment);
				}
			} else {
				System.err.println(
						"The working platform " + workingPlatform.getId() + " has no services for today: " + todayDay);
			}
		} else {
			System.err.println("You have not entered a working platform.");
		}
	}

	public void getServiceForCarMechanicForToday(CarMechanic carMechanic) {
		// Avoid NullPointerException
		String checkVehicleHasValue = (carMechanic != null) ? carMechanic.getId() : "null";

		LocalDateTime today = LocalDateTime.now();

		List<WorkingAppointment> listOfCompletedWorkingAppointmentsForCarMechanic = new ArrayList<>();

		if (carMechanic != null) {
			for (Appointment currentWorkingAppointment : carMechanic.listOfWorkingAppointmentForCarMechanic) {
				if (currentWorkingAppointment.getDayWithStartTime().compareTo(today) > 0) {
					listOfCompletedWorkingAppointmentsForCarMechanic
							.add((WorkingAppointment) currentWorkingAppointment);
				}
			}

			if (listOfCompletedWorkingAppointmentsForCarMechanic.size() > 0) {
				for (WorkingAppointment currentWorkingAppointment : listOfCompletedWorkingAppointmentsForCarMechanic) {
					System.out.println("The " + carMechanic + " has the " + currentWorkingAppointment.getService()
							+ " on the date and time " + currentWorkingAppointment.startOfAppointment
							+ " and on the working platform " + currentWorkingAppointment.getWorkingPlatform());
				}
			} else {
				System.err.println("There are no working appointments for the car mechanic with the id "
						+ carMechanic.getId() + " of today");
			}
		} else {
			System.err.println("The working appointments for the car mechanic " + checkVehicleHasValue
					+ " cannot be viewed because it is not in the list of working appointments for the car mechanic or you have not entered a car mechanic.");
		}
	}
}