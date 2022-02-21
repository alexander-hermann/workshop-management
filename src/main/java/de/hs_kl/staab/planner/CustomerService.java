package de.hs_kl.staab.planner;

import java.util.ArrayList;
import java.util.List;

/**
 * Verwaltet die Kunden mit ihren Fahrzeugen
 */
public class CustomerService {

	private static CustomerService INSTANCE;

	private final PlanningCalendar planningCalendar;

	private CustomerService() {
		planningCalendar = new PlanningCalendar();
	}

	public static CustomerService getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new CustomerService();
		}
		return INSTANCE;
	}

	public PlanningCalendar getPlanningCalendar() {
		return planningCalendar;
	}

	private List<Customer> listOfCustomers = new ArrayList<>();
	private List<Vehicle> listOfVehicles = new ArrayList<>();

	public List<Customer> getAllCustomers() {
		return listOfCustomers;
	}

	public List<Vehicle> getListOfVehicles() {
		return listOfVehicles;
	}

	// create a new vehicle
	public void createNewVehicle(Vehicle newVehicle) {
		if (newVehicle != null) {

			// if vehicle not in the listofvehicles add vehicle to list
			if (!listOfVehicles.contains(newVehicle)) {
				listOfVehicles.add(newVehicle);
				System.out.println("New vehicle succesfully added -> " + newVehicle);
			} else {
				System.err.println("Vehicle with the license plate " + newVehicle.getLicensePlate()
						+ " already exist. Search for the vehicle with license plate or update the vehicle.");
			}
		} else {
			System.err.println("You have not entered a vehicle.");
		}
	}

	public void getVehicleByLicensePlate(String licensePlate) {
		if (!listOfVehicles.isEmpty()) {

			// output is the vehicle if the license plate which was entered in the method
			// equals the license plate of a vehicle in the listofvehicles
			for (Vehicle vehicle : listOfVehicles) {
				if (vehicle.getLicensePlate().equals(licensePlate)) {
					System.out.println(vehicle + " found.");
					return;
				}
			}

		} else {
			System.err.println("The list of vehicles for this license plate " + licensePlate + " is empty.");
		}

		System.err.println("The vehicle for this license plate " + licensePlate + " is not found.");

	}

	// Return all vehicles
	public void getVehicles() {
		if (!listOfVehicles.isEmpty()) {
			for (Vehicle vehicle : listOfVehicles) {
				System.out.println(vehicle);
			}

		} else {
			System.err.println("The list of vehicles is empty.");
		}
	}

	// update a vehicle when entering the specific vehicle and the new instance
	public void updateVehicle(Vehicle oldVehicle, Vehicle newVehicle) {
		List<Vehicle> listOfUpdatedVehicle = new ArrayList<>();

		if (!listOfVehicles.isEmpty()) {

			// if the new object equals the old object
			for (Vehicle currentVehicle : listOfVehicles) {
				if (currentVehicle.equals(oldVehicle)) {
					listOfUpdatedVehicle.add(currentVehicle);

					// Assigns the id of the old object to the new object
					int indexOfOldVehicleInTheList = listOfVehicles.indexOf(oldVehicle);
					listOfVehicles.set(indexOfOldVehicleInTheList, newVehicle);
				}
			}
			if (listOfUpdatedVehicle.isEmpty()) {
				System.err.println("The vehicle " + oldVehicle + " could not be found in the list of vehicles.");
			}
		} else {
			System.err.println("The vehicle can`t be updated because the list of vehicles is empty.");
		}
	}

	// remove a vehicle when entering the instance

	public void removeVehicle(Vehicle removeVehicle) {
		if (!listOfVehicles.isEmpty()) {
			if (listOfVehicles.contains(removeVehicle)) {
				listOfVehicles.remove(removeVehicle);
				System.out.println(
						"Vehicle with license plate " + removeVehicle.getLicensePlate() + " has been removed. ");
			} else {
				System.err.println("The vehicle can not be removed, because the vehicle with the license plate "
						+ removeVehicle.getLicensePlate() + " does not exist int the lsit for vehicles");
			}
		} else {
			System.err.println("The vehicle can not be removed, because the list for the vehicles is empty.");
		}
	}

	// create a new customer
	public void createNewCustomer(Customer newCustomer) {
		if (newCustomer != null) {

			// if customer not in the listofcustomers add customer to list
			if (!listOfCustomers.contains(newCustomer)) {
				listOfCustomers.add(newCustomer);
				System.out.println("New customer successfully added -> " + newCustomer);
			} else {
				System.err.println("Customer with the Customer Id " + newCustomer.getId()
						+ " already exist. Search for Customer with Id or update Customer");
			}
		} else {
			System.err.println("You have not entered a customer.");
		}
	}

	// return the customer with the specific customer ID
	public void getCustomerById(String customerId) {
		if (!listOfCustomers.isEmpty()) {

			Customer foundCustomerById = null;

			// output is the customer if the customer Id which was entered in the method
			// equals the customer Id in the listofcustomers
			for (Customer customer : listOfCustomers) {
				if (customer.getId().equals(customerId)) {
					foundCustomerById = customer;
				}
			}

			if (foundCustomerById != null) {
				System.out.println("The customer " + foundCustomerById.getId() + " was successfully founded. "
						+ foundCustomerById);
			} else {
				System.err.println("The customer with the id " + customerId + " is not found.");
			}
		} else {
			System.err.println("The list of customers for this customer ID " + customerId + " is empty.");
		}
	}

	// Return all customers
	public void getCustomers() {
		if (!listOfCustomers.isEmpty()) {
			System.out.println(listOfCustomers);
		} else {
			System.err.println("The list of customers is empty.");
		}
	}

	// update a customer when entering the specific customer and the new instance
	public void updateCustomer(Customer oldCustomer, Customer newCustomer) {
		List<Customer> listOfUpdatedCustomer = new ArrayList<>();

		if (!listOfCustomers.isEmpty()) {

			// if the new object equals the old object
			for (Customer currentCustomer : listOfCustomers) {
				if (currentCustomer.equals(oldCustomer)) {
					listOfUpdatedCustomer.add(currentCustomer);

					// Assigns the id of the old object to the new object
					newCustomer.setCustomerId(oldCustomer.getId());

					int indexOfOldCustomerInTheList = listOfCustomers.indexOf(oldCustomer);
					listOfCustomers.set(indexOfOldCustomerInTheList, newCustomer);
				}
			}
			if (listOfUpdatedCustomer.isEmpty()) {
				System.err.println("No customer with customer ID " + oldCustomer + " found");
			}

		} else {
			System.err
					.println("The customer can not be updated, because the list for the customer with the customer ID "
							+ oldCustomer + " is empty.");
		}
	}

	// remove a customer when entering the instance
	public void removeCustomer(Customer removeCustomer) {
		if (!listOfCustomers.isEmpty()) {
			if (listOfCustomers.contains(removeCustomer)) {
				listOfCustomers.remove(removeCustomer);
				System.out.println("Customer with customer ID " + removeCustomer.getId() + " has been removed ");
			} else {
				System.err.println("The customer can not be removed, because the " + "customer with the customer ID "
						+ removeCustomer.getId() + " does not exist in the list of customers.");
			}
		} else {
			System.err.println(

					"The customer can not be removed, because the list of customers is empty.");
		}
	}

	// update customer for vehicle
	public void updateCustomerForVehicle(Customer customer, Vehicle vehicleToAdd) {
		// Avoid NullPointerException
		String checkCustomerHasValue = (customer != null) ? customer.getId() : "null";

		if (!listOfCustomers.isEmpty()) {
			if (listOfCustomers.contains(customer) && customer != null) {
				if (vehicleToAdd != null) {

					// if the license plate of the vehicle which was entered in the method equals a
					// license plate of a vehicle in the listofvehicles change customer for vehicle
					for (Vehicle vehicle : listOfVehicles) {
						if (vehicle.getLicensePlate().equals(vehicleToAdd.getLicensePlate())) {
							vehicle.setCustomer(customer);

						}
					}

					System.out.println("Customer " + customer.getId() + " add the vehicle: " + vehicleToAdd);
				} else {
					System.err.println("The vehicle cannot be added to the customer " + customer.getId()
							+ " because you have not entered a vehicle.");
				}
			} else {
				System.err.println("The customer with the ID " + checkCustomerHasValue
						+ " does not exist in the list for customers or you have not entered a customer.");
			}
		} else {
			System.err.println("The list of customers is empty.");
		}
	}

	// get List of vehicles for a specific customer
	public void getListOfVehiclesForCustomer(Customer customer) {
		if (customer != null) {
			if (!listOfCustomers.isEmpty()) {

				if (listOfCustomers.contains(customer)) {
					if (!listOfVehicles.isEmpty()) {

						List<Vehicle> foundVehicles = new ArrayList<>();
						int counterOfVehicle = 0;

						// output is the customer id and the license plate of the vehicle if the
						// customer which was entered in the method equals the customer for a car
						for (Vehicle currentVehicle : listOfVehicles) {
							if (currentVehicle.getCustomer().equals(customer)) {
								counterOfVehicle++;
								foundVehicles.add(currentVehicle);
							}
						}

						if (!foundVehicles.isEmpty()) {
							System.out.println("The customer " + customer.getFullName() + " has " + counterOfVehicle
									+ " vehicle(s). " + foundVehicles);
						} else {
							System.err.println("The customer " + customer.getId() + " has no vehicles.");
						}
					}
				} else {
					System.err.println(
							"The customer with ID " + customer.getId() + " does not exist in the list of customers.");
				}
			} else {
				System.err.println("The list of customers is empty.");

			}
		} else {
			System.err.println("You have not entered a customer.");
		}
	}

	// MMP/050
	public void getServiceHistoryForVehicle(Vehicle vehicle) {
		// Avoid NullPointerException
		String checkVehicleHasValue = (vehicle != null) ? vehicle.getId() : "null";
		int counterServiceHistory = 0;

		List<WorkingAppointment> listOfFoundWorkingAppointmentsForVehicle = new ArrayList<>();

		// add completed working appointment for vehicle to
		// listOfFoundWorkingAppointmentsForVehicle
		if (listOfVehicles.contains(vehicle) && vehicle != null) {
			for (WorkingAppointment currentWorkingAppointment : vehicle.listOfWorkingAppointmentForVehicle) {
				if (currentWorkingAppointment.isCompleted() == true) {
					counterServiceHistory++;
					listOfFoundWorkingAppointmentsForVehicle.add(currentWorkingAppointment);
				}
			}

			// output is the service and the start of the completed working appointment from
			// listOfFoundWorkingAppointmentsForVehicle or the error message
			if (!listOfFoundWorkingAppointmentsForVehicle.isEmpty()) {
				System.out.println("The vehicle " + vehicle.getId() + " has " + counterServiceHistory
						+ " collection of services:");
				for (WorkingAppointment currentWorkingAppointment : listOfFoundWorkingAppointmentsForVehicle) {
					System.out.println(currentWorkingAppointment.getService() + " on the date "
							+ currentWorkingAppointment.getDayWithStartTime());
				}
			} else {
				System.err.println("There are no working appointments in the history of the vehicle with the id "
						+ vehicle.getId());
			}
		} else {
			System.err.println("The history of the vehicle " + checkVehicleHasValue
					+ " cannot be viewed because it is not in the vehicle list or you have not entered a vehicle.");
		}
	}
}
