package de.hs_kl.staab.planner;

import java.util.ArrayList;
import java.util.List;

/**
 * Verwaltet den Planungskalender
 */
public class PlannerService {

	private static PlannerService INSTANCE;

	private final PlanningCalendar planningCalendar;

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

	private List<WorkingPlatform> listOfWorkingPlatforms = new ArrayList<>();
	private List<Service> listOfServices = new ArrayList<>();

	public List<WorkingPlatform> getListOfWorkingPlatforms() {
		return listOfWorkingPlatforms;
	}

	public List<Service> getListOfServices() {
		return listOfServices;
	}

	public void getWorkingPlatformById(String workingPlatformId) {
		if (!listOfWorkingPlatforms.isEmpty()) {

			// get the working platform if the working platform Id which was entered in the
			// method
			// equals the working platform Id in the listofworkingplatforms
			for (WorkingPlatform workingPlatform : listOfWorkingPlatforms) {
				if (workingPlatform.getId().equals(workingPlatformId)) {
					System.out.println(workingPlatform);
				}
			}
		} else {
			System.err.println("The list of workingplatforms is empty.");
		}
		System.err.println("The workingplatform with the id " + workingPlatformId + " was not found.");
	}

	public void getWorkingPlatforms() {
		if (!listOfWorkingPlatforms.isEmpty()) {
			for (WorkingPlatform workingPlatform : listOfWorkingPlatforms) {
				System.out.println(workingPlatform);
			}
		} else {
			System.err.println("The list of workingplatforms is empty.");
		}
	}

	public void createNewWorkingPlatform(WorkingPlatform newWorkingPlatform) {

		// if working platform not in the listofworkingplatforms add workingplatform to
		// list

		if (!listOfWorkingPlatforms.contains(newWorkingPlatform)) {
			listOfWorkingPlatforms.add(newWorkingPlatform);
			System.out.println("The workingplatform " + newWorkingPlatform.getId() + "  was successfully added.");
		} else {
			System.err.println("The working platform cannot be added because it already exists in the list");
		}
	}

	public void updateWorkingPlatform(WorkingPlatform oldWorkingPlatform, WorkingPlatform newWorkingPlatform) {
		if (!listOfWorkingPlatforms.isEmpty()) {

			// if the new object equals the old object
			for (WorkingPlatform actualWorkingPlatform : listOfWorkingPlatforms) {
				if (actualWorkingPlatform.equals(oldWorkingPlatform)) {

					// Assigns the id of the old object to the new object
					newWorkingPlatform.setId(oldWorkingPlatform.getId());
					listOfWorkingPlatforms.set(listOfWorkingPlatforms.indexOf(oldWorkingPlatform), newWorkingPlatform);
				}
			}
		} else {
			System.err.println("The working platform cannot be updated because the list of workingplatforms is empty.");
		}
	}

	public void removeWorkingPlatform(WorkingPlatform removeWorkingPlatform) {
		if (!listOfWorkingPlatforms.isEmpty()) {
			listOfWorkingPlatforms.remove(removeWorkingPlatform);
			System.out.println("The workingplatform " + removeWorkingPlatform.getId() + "  was successfully deleted.");
		} else {
			System.err.println("The workingplatform " + removeWorkingPlatform.getId()
					+ " can't be deleted, because the list of workingplatforms is empty.");
		}
	}

	public void getServiceById(String serviceId) {
		if (!listOfServices.isEmpty()) {

			// get the service if the service Id which was entered in the method
			// equals the service Id in the listofservices

			for (Service service : listOfServices) {
				if (service.getId().equals(serviceId)) {
					System.out.println(service);
				}
			}
		} else {
			System.err.println("The list of services is empty.");
		}
		System.err.println("The service with the id " + serviceId + " was not found.");
	}

	public void getServices() {
		if (!listOfServices.isEmpty()) {
			for (Service service : listOfServices) {
				System.out.println(service);
			}
		} else {
			System.err.println("The list of services is empty.");
		}
	}

	public void createNewService(Service newService) {

		// if the service not in the listofservices add service to list
		if (!listOfServices.contains(newService)) {
			listOfServices.add(newService);
			System.out.println("The service " + newService.getId() + "  was successfully added.");
		} else {
			System.err.println("The service cannot be added because it already exists in the list");
		}
	}

	public void updateService(Service oldService, Service newService) {
		if (!listOfServices.isEmpty()) {

			// if the new object equals the old object
			for (Service actualService : listOfServices) {
				if (actualService.equals(oldService)) {

					// Assigns the id of the old object to the new object
					newService.setId(oldService.getId());
					listOfServices.set(listOfServices.indexOf(oldService), newService);
				}
			}
		} else {
			System.err.println("The service cannot be updated because the list of services is empty.");
		}
	}

	public void removeService(Service removeService) {
		if (!listOfServices.isEmpty()) {
			listOfServices.remove(removeService);
			System.out.println("The service " + removeService.getId() + "  was successfully deleted.");
		} else {
			System.err.println("The service " + removeService.getId()
					+ " can't be deleted, because the list of services is empty.");
		}
	}
}