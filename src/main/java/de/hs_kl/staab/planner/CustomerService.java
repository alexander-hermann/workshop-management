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
		if (newVehicle != null) {
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
	public List<Vehicle> getVehicles() {
		if (!listOfVehicles.isEmpty()) {
			for (Vehicle vehicle : listOfVehicles) {
				System.out.println(vehicle);
			}
			return listOfVehicles;
		} else {
			throw new IllegalStateException("The list of vehicles is empty.");
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
			if (!listOfCustomers.contains(newCustomer)) {
				listOfCustomers.add(newCustomer);
				System.out.println(newCustomer + " added.");
			} else {
				System.err.println("Customer with the Customer Id " + newCustomer.getId()
						+ " already exist. Search for Customer with Id or update Customer");
			}
		} else {
			System.err.println("You have not entered a customer.");
		}
	}

	// return the customer with the specific customer ID
	public Customer getCustomerById(String customerId) {
		if (!listOfCustomers.isEmpty()) {
			for (Customer customer : listOfCustomers) {
				if (customer.getId().equals(customerId)) {
					System.out.println("Customer with customer ID " + customerId + "found.");
					return customer;
				}

			}
		} else {
			System.err.println("The list of customers for this customer ID " + customerId + " is empty.");
		}
		throw new IllegalStateException("The customer with the id " + customerId + " is not found.");
	}

	// Return all customers
	public List<Customer> getListOfCustomers() {
		if (!listOfCustomers.isEmpty()) {
			System.out.println(listOfCustomers);
			return listOfCustomers;
		} else {
			throw new IllegalStateException("The list of customers is empty.");
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
					newCustomer.setCustomerId(oldCustomer.getId());

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
				System.out.println("Customer with customer ID " + removeCustomer.getId() + " has been removed ");
			} else {
				throw new IllegalArgumentException(
						"The customer can not be removed, because the " + "customer with the customer ID "
								+ removeCustomer.getId() + " does not exist in the list of customers.");
			}
		} else {
			throw new IllegalArgumentException(

					"The customer can not be removed, because the list of customers is empty.");
		}
	}

	// add new vehicle to customer
	public void addVehicleForCustomer(Customer customer, Vehicle vehicleToAdd) {
		// Avoid NullPointerException
		String checkCustomerHasValue = (customer != null) ? customer.getId() : "null";

		if (!listOfCustomers.isEmpty()) {
			if (listOfCustomers.contains(customer) && customer != null) {
				if (vehicleToAdd != null) {

					for (Vehicle vehicle : customer.getListOfVehiclesForCustomer()) {
						if (vehicle.getLicensePlate().equals(vehicleToAdd.getLicensePlate())) {
							throw new IllegalArgumentException("Vehicle with license plate "
									+ vehicleToAdd.getLicensePlate()
									+ " already exist in list of vehicles for customer with ID " + customer.getId());
						}
					}

					customer.addVehicleToCustomer(vehicleToAdd);
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
			throw new IllegalArgumentException(

					"The list of customers is empty.");
		}
	}

	// get List of vehicles for a specific customer
	public void getListOfVehiclesForCustomer(Customer customer) {
		if (!listOfCustomers.isEmpty() && customer != null) {
			if (listOfCustomers.contains(customer)) {
				if (!customer.getListOfVehiclesForCustomer().isEmpty()) {
					for (Vehicle currentVehicle : customer.getListOfVehiclesForCustomer()) {
						System.out.println("The customer " + customer.getId() + " is the owner of vehicle "
								+ currentVehicle.getLicensePlate());
					}

				} else {
					System.err.println("The customer " + customer.getId() + " has no vehicles.");
				}
			} else {
				System.err.println(
						"The customer with ID " + customer.getId() + " does not exist in the list of customers.");
			}
		} else {
			System.err.println("The list of customers is empty or you have not entered a customer.");
		}
	}

	// remove specific vehicle from list of vehicle for a specific customer
	public void removeVehicleForCustomer(Customer customer, Vehicle vehicleToRemove) {
		if (!listOfCustomers.isEmpty()) {
			if (listOfCustomers.contains(customer)) {
				if (!customer.getListOfVehiclesForCustomer().isEmpty()) {

					customer.removeVehicleForCustomer(vehicleToRemove);

					System.out.println("Vehicle with license plate " + vehicleToRemove.getLicensePlate()
							+ " removed from customer " + customer.getId());
				}

				else {
					throw new IllegalArgumentException(
							"List of vehicles for customer with ID " + customer.getId() + " is empty");
				}
			} else {
				throw new IllegalArgumentException(
						"The customer with the ID " + customer.getId() + " does not exist in the list of customers.");
			}
		} else {
			throw new IllegalArgumentException(

					"The list of customers is empty.");
		}

	}

	public void getVehicleForCustomer(Customer searchedCustomer, Vehicle searchedVehicle) {
		// Avoid NullPointerException
		String checkCustomerHasValue = (searchedCustomer != null) ? searchedCustomer.getId() : "null";

		List<Vehicle> listWithFoundCustomerVehicles = new ArrayList<>();

		if (listOfCustomers.contains(searchedCustomer) && searchedCustomer != null) {
			if (!searchedCustomer.getListOfVehiclesForCustomer().isEmpty() && searchedVehicle != null) {
				for (Vehicle currentVehicle : searchedCustomer.getListOfVehiclesForCustomer()) {
					if (currentVehicle.equals(searchedVehicle)) {
						listWithFoundCustomerVehicles.add(currentVehicle);
					}
				}

				if (!listWithFoundCustomerVehicles.isEmpty()) {
					for (Vehicle vehicle : listWithFoundCustomerVehicles) {
						System.out.println(vehicle);
					}
				} else {
					System.err.println("The customer " + searchedCustomer.getId() + " does not have the vehicle "
							+ searchedVehicle);
				}
			} else {
				System.err.println("The customer " + checkCustomerHasValue
						+ " has no vehicles or you have not entered a vehicle.");
			}
		} else {
			System.err.println("The costumer " + checkCustomerHasValue
					+ " was not found in the list of costumers or you have not entered a customer.");
		}
	}

	// MMP/050
	public void getServiceHistoryForVehicle(Vehicle vehicle) {
		// Avoid NullPointerException
		String checkVehicleHasValue = (vehicle != null) ? vehicle.getId() : "null";

		List<WorkingAppointment> listOfFoundWorkingAppointmentsForVehicle = new ArrayList<>();

		if (listOfVehicles.contains(vehicle) && vehicle != null) {
			for (WorkingAppointment currentWorkingAppointment : vehicle.listOfWorkingAppointmentForVehicle) {
				if (currentWorkingAppointment.isCompleted() == true) {
					listOfFoundWorkingAppointmentsForVehicle.add(currentWorkingAppointment);
				}
			}

			if (listOfFoundWorkingAppointmentsForVehicle.size() > 0) {
				for (WorkingAppointment currentWorkingAppointment : listOfFoundWorkingAppointmentsForVehicle) {
					System.out.println(currentWorkingAppointment.getService() + " on the date "
							+ currentWorkingAppointment.startOfAppointment);
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
