package de.hs_kl.staab.planner;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Klasse, die das REST-Interface für den Werkstattplaner zur Verfügung stellt
 * (optional!).
 * 
 * @author Staab
 *
 */
@RestController
@RequestMapping(path = "/planner")
public class PlannerController {

	private final PlannerService plannerService = PlannerService.getInstance();
	private final PlanningCalendar planningCalendar = PlanningCalendar.getInstance();
	private final CustomerService customerService = CustomerService.getInstance();

	/* ************************************************ */
	/* * HIER KÖNNEN SIE IHRE REST-METHODEN SCHREIBEN * */
	/* * Siehe RestSandbox für Beispiele ************** */
	/* ************************************************ */

	@RequestMapping(value = "/services", method = RequestMethod.GET)
	public List<Service> getAllServices() {
		return plannerService.getListOfServices();
	}

	@RequestMapping(value = "/workingplatforms", method = RequestMethod.GET)
	public List<WorkingPlatform> getAllWorkingPlatforms() {
		return plannerService.getListOfWorkingPlatforms();
	}

	@RequestMapping(value = "/appointments", method = RequestMethod.GET)
	public List<Appointment> getAllAppointments() {
		return planningCalendar.getListOfAppointments();
	}

	@RequestMapping(value = "/workingappointments", method = RequestMethod.GET)
	public List<Appointment> getAllWorkingAppointments() {
		List<Appointment> foundOfWorkingAppointments = new ArrayList<>();

		for (Appointment appointment : planningCalendar.getListOfAppointments()) {
			if (appointment instanceof WorkingAppointment) {
				foundOfWorkingAppointments.add(appointment);
			}
		}
		return foundOfWorkingAppointments;
	}

	@RequestMapping(value = "/consultingappointments", method = RequestMethod.GET)
	public List<Appointment> getAllConsultingAppointments() {
		List<Appointment> foundOfConsultingAppointments = new ArrayList<>();

		for (Appointment appointment : planningCalendar.getListOfAppointments()) {
			if (appointment instanceof ConsultingAppointment) {
				foundOfConsultingAppointments.add(appointment);
			}
		}
		return foundOfConsultingAppointments;
	}

	@RequestMapping(value = "/cleaningappointments", method = RequestMethod.GET)
	public List<Appointment> getAllCleaningAppointments() {
		List<Appointment> foundOfCleaningAppointments = new ArrayList<>();

		for (Appointment appointment : planningCalendar.getListOfAppointments()) {
			if (appointment instanceof CleaningAppointment) {
				foundOfCleaningAppointments.add(appointment);
			}
		}
		return foundOfCleaningAppointments;
	}

	@RequestMapping(value = "/customers", method = RequestMethod.GET)
	public List<Customer> getAllCustomers() {
		return customerService.getAllCustomers();
	}
}
