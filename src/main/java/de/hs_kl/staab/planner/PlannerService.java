package de.hs_kl.staab.planner;

import java.util.ArrayList;
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
		listOfWorkingPlatforms.add(newWorkingPlatform);
		System.out.println("The workingplatform " + newWorkingPlatform.getId() + "  was successfully added.");
	}

	/*
	 * public void updateWorkingPlatform(WorkingPlatform updateWorkingPlatform) { if
	 * (!listOfWorkingPlatforms.isEmpty()) { for (WorkingPlatform workingPlatform :
	 * listOfWorkingPlatforms) { if (workingPlatform.equals(this)) { // New object
	 * gets the id from the old object //updateWorkingPlatform.set(this.getId());
	 * 
	 * System.out.println("Old object: " + workingPlatform);
	 * listOfWorkingPlatforms.set(listOfWorkingPlatforms.indexOf(this),
	 * updateWorkingPlatform); System.out.println("New object: " +
	 * updateWorkingPlatform); } } } else { throw new
	 * IllegalArgumentException("The workingplatform " + this +
	 * " can not be updated, because the list of workingplatforms is empty."); } }
	 */

	public void updateWorkingPlatform(WorkingPlatform oldWorkingPlatform, WorkingPlatform newWorkingPlatform) {
		if (!listOfWorkingPlatforms.isEmpty()) {

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
		listOfServices.add(newService);
		System.out.println("The service " + newService.getId() + "  was successfully added.");
	}

	/*
	 * public void updateService(Service updateService) { if
	 * (!listOfServices.isEmpty()) { for (Service service : listOfServices) { if
	 * (service.equals(this)) { // New object gets the id from the old object
	 * updateService.idOfService = this.idOfService;
	 * listOfServices.set(listOfServices.indexOf(this), updateService);
	 * 
	 * System.out.println("Old object: " + service);
	 * System.out.println("New object: " + updateService); } } } else { throw new
	 * IllegalArgumentException( "The service " + this.getId() +
	 * " can not be updated, because the list of services is empty."); } }
	 */

	public void removeService(Service removeService) {
		if (!listOfServices.isEmpty()) {
			listOfServices.remove(removeService);
			System.out.println("The service " + removeService.getId() + "  was successfully deleted.");
		} else {
			throw new IllegalArgumentException("The service " + removeService.getId()
					+ " can't be deleted, because the list of services is empty.");
		}
	}
}
