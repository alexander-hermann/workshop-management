package de.hs_kl.staab.planner;

import java.util.ArrayList;
import java.util.List;

/**
 * Verwaltet die Kunden mit ihren Fahrzeugen
 */
public class CustomerService {

	private List<Customer> listOfCustomers = new ArrayList<>();
	private List<Vehicle> listOfVehicles = new ArrayList<>();

	// create a new vehicle
	public void createNewVehicle(Vehicle newVehicle) {
		if (!listOfVehicles.contains(newVehicle)) {
			listOfVehicles.add(newVehicle);
			System.out.println("New vehicle " + newVehicle.getLicensePlate() + " added.");
		} else {
			System.err.println("Vehicle with the license plate " + newVehicle.getLicensePlate()
					+ " already exist. Search for the vehicle with license plate or update the vehicle.");
		}
	}

	public void getVehicleByLicensePlate(String licensePlate) {
		if (!listOfVehicles.isEmpty()) {
			for (Vehicle vehicle : listOfVehicles) {
				if (vehicle.getLicensePlate().equals(licensePlate)) {
					System.out.println(vehicle + " found.");
					return;
				}
			}
		} else {
			throw new IllegalArgumentException(
					"The list of vehicles for this license plate " + licensePlate + " is empty.");
		}
		System.err.println("The vehicle with the license plate " + licensePlate + " is not found.");
	}

	// Return all vehicles
	public void getVehicles() {
		if (!listOfVehicles.isEmpty()) {
			for (Vehicle vehicle : listOfVehicles) {
				System.out.println(vehicle);
			}
			System.out.println(listOfVehicles);
		} else {
			System.err.println("The list of vehicles is empty.");
		}
	}

	public void updateVehicle(Vehicle oldVehicle, Vehicle newVehicle) {
		List<Vehicle> listOfUpdatedVehicle = new ArrayList<>();

		if (!listOfVehicles.isEmpty()) {
			for (Vehicle currentVehicle : listOfVehicles) {
				if (currentVehicle.equals(oldVehicle)) {
					listOfUpdatedVehicle.add(currentVehicle);

					int indexOfOldVehicleInTheList = listOfVehicles.indexOf(oldVehicle);
					listOfVehicles.set(indexOfOldVehicleInTheList, newVehicle);
				}
			}
			if (listOfUpdatedVehicle.isEmpty()) {
				System.err.println("The vehicle " + oldVehicle + " could not be found in the list of vehicles.");
			}
		} else {
			System.err.println("The vehicle can#t be updated because the list of vehicles is empty.");
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
				throw new IllegalArgumentException(
						"The vehicle can not be removed, because the vehicle with the license plate "
								+ removeVehicle.getLicensePlate() + " does not exist int the lsit for vehicles");
			}
		} else {
			throw new IllegalArgumentException(
					"The vehicle can not be removed, because the list for the vehicles is empty.");
		}
	}

	// create a new customer
	public void createNewCustomer(Customer newCustomer) {
		if (!listOfCustomers.contains(newCustomer)) {
			listOfCustomers.add(newCustomer);
			System.out.println(newCustomer + " added.");
		} else {
			throw new IllegalArgumentException("Customer with the Customer Id " + newCustomer.getCustomerId()
					+ " already exist. Search for Customer with Id or update Customer");
		}
	}

	// return the customer with the specific customer ID
	public Customer getCustomerById(String customerId) {
		if (!listOfCustomers.isEmpty()) {
			for (Customer customer : listOfCustomers) {
				if (customer.getCustomerId().equals(customerId)) {
					System.out.println("Customer with customer ID " + customerId + "found.");
					return customer;
				}

			}
		} else {
			throw new IllegalArgumentException(
					"The list of customers for this customer ID " + customerId + " is empty.");
		}
		throw new IllegalArgumentException("The customer with the id " + customerId + " is not found.");
	}

	// Return all customers
	public List<Customer> getListOfCustomers() {
		if (!listOfCustomers.isEmpty()) {
			System.out.println(listOfCustomers);
			return listOfCustomers;
		} else {
			throw new IllegalArgumentException("The list of customers is empty.");
		}
	}

	// update a customer when entering the specific customer ID and the new instance
	public void updateCustomer(Customer oldCustomer, Customer newCustomer) {
		List<Customer> listOfUpdatedCustomer = new ArrayList<>();

		if (!listOfCustomers.isEmpty()) {
			for (Customer currentCustomer : listOfCustomers) {
				if (currentCustomer.equals(oldCustomer)) {
					listOfUpdatedCustomer.add(currentCustomer);

					// Assigns the id of the old object to the new object
					newCustomer.setCustomerId(oldCustomer.getCustomerId());

					int indexOfOldCustomerInTheList = listOfCustomers.indexOf(oldCustomer);
					listOfCustomers.set(indexOfOldCustomerInTheList, newCustomer);
				}
			}
			if (listOfUpdatedCustomer.isEmpty()) {
				throw new IllegalArgumentException("No customer with customer ID " + oldCustomer + " found");
			}

		} else {
			throw new IllegalArgumentException(
					"The customer can not be updated, because the list for the customer with the customer ID "
							+ oldCustomer + " is empty.");
		}
	}

	// remove a customer when entering the instance

	public void removeCustomer(Customer removeCustomer) {
		if (!listOfCustomers.isEmpty()) {
			if (listOfCustomers.contains(removeCustomer)) {

				listOfCustomers.remove(removeCustomer);
				System.out
						.println("Customer with customer ID " + removeCustomer.getCustomerId() + " has been removed ");
			} else {
				throw new IllegalArgumentException(

						"The customer can not be removed, because the customer with the customer ID "
								+ removeCustomer.getCustomerId() + " does not exist in the list of customers.");
			}
		} else {
			throw new IllegalArgumentException(

					"The customer can not be removed, because the list of customers is empty.");
		}

	}

	// add new vehicle to customer
	public void addVehicleForCustomer(Customer customer, Vehicle vehicleToAdd) {
		if (!listOfCustomers.isEmpty()) {
			if (listOfCustomers.contains(customer)) {
				for (Vehicle vehicle : customer.getListOfVehiclesForCustomer()) {
					if (vehicle.getLicensePlate().equals(vehicleToAdd.getLicensePlate())) {
						throw new IllegalArgumentException(
								"Vehicle with license plate " + vehicleToAdd.getLicensePlate()
										+ " already exist in list of vehicles for customer with ID "
										+ customer.getCustomerId());
					}
				}

				customer.addVehicleToCustomer(vehicleToAdd);
				System.out.println("Customer " + customer.getCustomerId() + " add the vehicle: " + vehicleToAdd);
			} else {
				throw new IllegalArgumentException("The customer with the ID" + customer.getCustomerId()
						+ " does not exist in the list for customers.");
			}
		} else {
			throw new IllegalArgumentException(

					"The list of customers is empty.");
		}
	}

	// get List of vehicles for a specific customer
	public List<Vehicle> getListOfVehiclesForCustomer(Customer customer) {
		if (!listOfCustomers.isEmpty()) {
			if (listOfCustomers.contains(customer)) {
				if (!customer.getListOfVehiclesForCustomer().isEmpty()) {
					System.out.println("Customer with customer ID " + customer.getCustomerId() + " owns the vehicles: "
							+ customer.getListOfVehiclesForCustomer());
					return customer.getListOfVehiclesForCustomer();
				} else {
					throw new IllegalArgumentException(
							"List of vehicles for customer with ID " + customer.getCustomerId() + " is empty");
				}
			} else {
				throw new IllegalArgumentException("The customer with ID " + customer.getCustomerId()
						+ " does not exist in the list of customers.");
			}
		} else {
			throw new IllegalArgumentException(

					"The list of customers is empty.");
		}

	}

	// remove specific vehicle from list of vehicle for a specific customer

	public void removeVehicleForCustomer(Customer customer, Vehicle vehicleToRemove) {
		if (!listOfCustomers.isEmpty()) {
			if (listOfCustomers.contains(customer)) {
				if (!customer.getListOfVehiclesForCustomer().isEmpty()) {

					customer.removeVehicleForCustomer(vehicleToRemove);

					System.out.println("Vehicle with license plate " + vehicleToRemove.getLicensePlate()
							+ " removed from customer " + customer.getCustomerId());
				}

				else {
					throw new IllegalArgumentException(
							"List of vehicles for customer with ID " + customer.getCustomerId() + " is empty");
				}
			} else {
				throw new IllegalArgumentException("The customer with the ID " + customer.getCustomerId()
						+ " does not exist in the list of customers.");
			}
		} else {
			throw new IllegalArgumentException(

					"The list of customers is empty.");
		}

	}

	public void getVehicleForCustomer(Customer customer, Vehicle vehicleToSearch) {
		if (!listOfCustomers.isEmpty()) {
			if (listOfCustomers.contains(customer)) {
				if (!customer.getListOfVehiclesForCustomer().isEmpty()) {
					if (customer.getListOfVehiclesForCustomer().contains(vehicleToSearch)) {
						System.out.println("Found " + vehicleToSearch + " for customer " + customer);
					}

					else {
						throw new IllegalArgumentException(vehicleToSearch.getLicensePlate()
								+ " not found in list of vehicles for customer " + customer.getCustomerId());
					}
				} else {

					throw new IllegalArgumentException(
							"The list of vehicles for customer " + customer.getCustomerId() + " is empty");
				}
			} else {

				throw new IllegalArgumentException(
						"The customer " + customer.getCustomerId() + " does not exist in the list of customers.");
			}
		} else {
			throw new IllegalArgumentException(

					"The list of customers is empty.");
		}

	}

	// MMP/050
	public void getVehicleHistory(Vehicle vehicle) {

		for (WorkingAppointment workingAppointment : vehicle.listOfWorkingAppointmentForVehicle) {

			if (((WorkingAppointment) workingAppointment).isCompleted() == true)
				System.out.println("Vehicle with the license plate " + vehicle.getLicensePlate() + " got the service "
						+ workingAppointment.getService() + ", start of appointment: "
						+ workingAppointment.getStartOfAppointment());

		}
	}
}
