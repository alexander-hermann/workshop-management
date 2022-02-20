package de.hs_kl.staab.planner;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.PathVariable;
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

	// @formatter:off
	private final PlannerService plannerService = PlannerService.getInstance();
	private final PlanningCalendar planningCalendar = PlanningCalendar.getInstance();
	private final CustomerService customerService = CustomerService.getInstance();
	private final UserService userService = UserService.getInstance();

	/* ************************************************ */
	/* * HIER KÖNNEN SIE IHRE REST-METHODEN SCHREIBEN * */
	/* * Siehe RestSandbox für Beispiele ************** */
	/* ************************************************ */

	@RequestMapping(value = "/services", method = RequestMethod.GET)
	public List<Service> getAllServices() {
		return plannerService.getListOfServices();
	}
	
	@RequestMapping(value = "/services/{idOfService}")
	public List<Service> getServiceById(@PathVariable int idOfService) {
		String idWithPrefix = "SE-" + idOfService;
		List<Service> service = plannerService.getListOfServices().stream().filter(s -> s.getId().equals(idWithPrefix)).collect(Collectors.toList());
		return service;
	}

	@RequestMapping(value = "/workingplatforms", method = RequestMethod.GET)
	public List<WorkingPlatform> getAllWorkingPlatforms() {
		return plannerService.getListOfWorkingPlatforms();
	}
	
	@RequestMapping(value = "/workingplatforms/{idOfWorkingPlatform}")
	public List<WorkingPlatform> getWorkingPlatformById(@PathVariable int idOfWorkingPlatform) {
		String idWithPrefix = "WKP-" + idOfWorkingPlatform;
		List<WorkingPlatform> workingPlatform = plannerService.getListOfWorkingPlatforms().stream().filter(w -> w.getId().equals(idWithPrefix)).collect(Collectors.toList());
		return workingPlatform;
	}

	// ###############################################
	@RequestMapping(value = "/appointments", method = RequestMethod.GET)
	public List<Appointment> getAllAppointments() {
		return planningCalendar.getListOfAppointments();
	}
	
	@RequestMapping(value = "/appointments/{idOfAppointment}")
	public List<Appointment> getAppointmentById(@PathVariable int idOfAppointment) {
		String idWithPrefix = "AP-" + idOfAppointment;
		List<Appointment> appointmentById = planningCalendar.getListOfAppointments().stream().filter(a -> a.getId().equals(idWithPrefix)).collect(Collectors.toList());
		return appointmentById;
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
	
	@RequestMapping(value = "/workingappointments/{idOfWorkingAppointment}")
	public List<Appointment> getWorkingAppointmentById(@PathVariable int idOfWorkingAppointment) {
		String idWithPrefix = "AP-" + idOfWorkingAppointment;
		List<Appointment> workingAppointmentById = planningCalendar.getListOfAppointments().stream().filter(a -> a.getId().equals(idWithPrefix)).collect(Collectors.toList());
		return workingAppointmentById;
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

	// ###############################################
	// CUSTOMER-SERVICE
	@RequestMapping(value = "/customers", method = RequestMethod.GET)
	public List<Customer> getAllCustomers() {
		return customerService.getAllCustomers();
	}
	
	@RequestMapping(value = "/customers/{idOfCustomer}")
	public List<Customer> getCustomerById(@PathVariable String idOfCustomer) {
		List<Customer> customer = customerService.getAllCustomers().stream().filter(c -> c.getId().equals(idOfCustomer)).collect(Collectors.toList());
		return customer;
	}

	@RequestMapping(value = "/vehicles", method = RequestMethod.GET)
	public List<Vehicle> getAllVehicles() {
		return customerService.getListOfVehicles();
	}
	
	@RequestMapping(value = "/vehicles/{idOfVehicle}")
	public List<Vehicle> getVehicleById(@PathVariable String idOfVehicle) {
		List<Vehicle> vehicle = customerService.getListOfVehicles().stream().filter(v -> v.getId().equals(idOfVehicle)).collect(Collectors.toList());
		return vehicle;
	}

	// ###############################################
	// USER-SERVICE
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public List<User> getAllUsers() {
		return userService.getUsers();
	}

	@RequestMapping(value = "/users/{idOfUser}")
	public List<User> getUserById(@PathVariable String idOfUser) {
		List<User> user = userService.getUsers().stream().filter(u -> u.getId().equals(idOfUser)).collect(Collectors.toList());
		return user;
	}
}
