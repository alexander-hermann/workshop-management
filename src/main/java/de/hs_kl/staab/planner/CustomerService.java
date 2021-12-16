package de.hs_kl.staab.planner;

import java.util.ArrayList;
import java.util.List;

/**
 * Verwaltet die Kunden mit ihren Fahrzeugen
 */
public class CustomerService {

	private List<Customer> listOfCustomers = new ArrayList<>();
	private List<Vehicle> listOfVehicles = new ArrayList<>();

	// MVP/030

	// Return all vehicles

	public List<Vehicle> getListOfVehicles() {
		if (!listOfVehicles.isEmpty()) {
			System.out.println(listOfVehicles);
			return listOfVehicles;
		} else {

			throw new IllegalArgumentException("The list of vehicles is empty");

		}
	}

	// create a new vehicle

	public void createNewVehicle(Vehicle newVehicle) {

		for (Vehicle vehicle : listOfVehicles) {
			if (newVehicle.getLicensePlate().equals(vehicle.getLicensePlate())) {
				throw new IllegalArgumentException("Vehicle with the license plate " + newVehicle.getLicensePlate()
						+ " already exist. Search for the vehicle with license plate or update the vehicle.");
			}
		}
		listOfVehicles.add(newVehicle);
		System.out.println("New vehicle " + newVehicle.getLicensePlate() + " added.");

	}

	// return the vehicle with the specific license plate

	public Vehicle getVehicleByLicensePlate(String licensePlate) {
		if (!listOfVehicles.isEmpty()) {
			for (Vehicle vehicle : listOfVehicles) {
				if (vehicle.getLicensePlate().equals(licensePlate)) {
					System.out.println(vehicle + " found.");
					return vehicle;
				}

			}
		} else {
			throw new IllegalArgumentException(
					"The list of vehicles for this license plate " + licensePlate + " is empty.");
		}
		throw new IllegalArgumentException("The vehicle with the license plate " + licensePlate + " is not found.");
	}

	// update a vehicle when entering the specific license plate and the new
	// instance

	public void updateVehicle(String licensePlate, Vehicle updateVehicle) {
		if (!listOfVehicles.isEmpty()) {
			List<Vehicle> listOfUpdatedVehicle = new ArrayList<>();
			for (Vehicle vehicle : listOfVehicles) {
				if (licensePlate.equals(vehicle.getLicensePlate())) {
					listOfUpdatedVehicle.add(vehicle);
					System.out.println("Old object: " + vehicle);
					listOfVehicles.set(listOfVehicles.indexOf(vehicle), updateVehicle);
					System.out.println("New object: " + updateVehicle);
				}
			}
			if (listOfUpdatedVehicle.isEmpty()) {
				throw new IllegalArgumentException("No vehicle with license plate " + licensePlate + " found");
			}

		} else {

			throw new IllegalArgumentException(
					"The vehilce can not be updated, because the list for the vehicle with the license plate "
							+ licensePlate + " is empty.");
		}
	}

	// remove a vehicle when entering the instance

	public void removeVehicle(Vehicle removeVehicle) {

		if (!listOfVehicles.isEmpty()) {

			listOfVehicles.remove(removeVehicle);
			System.out.println("Vehicle with license plate " + removeVehicle.getLicensePlate() + " has been removed. ");
		}

		else {
			throw new IllegalArgumentException(

					"The vehicle can not be updated, because the list for the vehicles is empty.");

		}
	}

	// MVP/040

	// Return all customers

	public List<Customer> getListOfCustomers() {
		if (!listOfCustomers.isEmpty()) {

			System.out.println(listOfCustomers);
			return listOfCustomers;
		} else {
			throw new IllegalArgumentException("The list of customers is empty.");
		}
	}

	// create a new customer

	public void createNewCustomer(Customer newCustomer) {
		for (Customer customer : listOfCustomers) {
			if (customer.getCustomerId().equals(newCustomer.getCustomerId())) {
				throw new IllegalArgumentException("Customer with the Customer Id " + newCustomer.getCustomerId()
						+ " already exist. Search for Customer with Id or update Customer");
			}

		}
		listOfCustomers.add(newCustomer);
		System.out.println(newCustomer + " added.");

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

	// update a customer when entering the specific customer ID and the new instance

	public void updateCustomer(String customerId, Customer updateCustomer) {
		if (!listOfCustomers.isEmpty()) {
			List<Customer> listOfUpdatedCustomer = new ArrayList<>();
			for (Customer customer : listOfCustomers) {
				if (customerId.equals(customer.getCustomerId())) {
					updateCustomer.setCustomerId(customerId);
					System.out.println("Old object: " + customer);
					listOfCustomers.set(listOfCustomers.indexOf(customer), updateCustomer);
					listOfUpdatedCustomer.add(customer);
					System.out.println("New object: " + updateCustomer);

				}

			}
			if (listOfUpdatedCustomer.isEmpty()) {
				throw new IllegalArgumentException("No customer with customer ID " + customerId + " found");
			}

		} else {
			throw new IllegalArgumentException(
					"The customer can not be updated, because the list for the customer with the customer ID "
							+ updateCustomer.getCustomerId() + " is empty.");
		}
	}

	// remove a customer when entering the instance

	public void removeCustomer(Customer removeCustomer) {
		if (!listOfCustomers.isEmpty()) {

			listOfCustomers.remove(removeCustomer);
			System.out.println("Customer with customer ID " + removeCustomer.getCustomerId() + " has been removed ");
		}

		else {
			throw new IllegalArgumentException(

					"The customer can not be updated, because the list for the customer with the customer ID "
							+ removeCustomer.getCustomerId() + " is empty.");
		}
	}

	// add new vehicle to customer
	public void addVehicleForCustomer(Customer customer, Vehicle vehicleToAdd) {

		for (Vehicle vehicle : customer.getListOfVehiclesForCustomer()) {
			if (vehicle.getLicensePlate().equals(vehicleToAdd.getLicensePlate())) {
				throw new IllegalArgumentException("Vehicle with license plate " + vehicleToAdd.getLicensePlate()
						+ " already exist in list of vehicles for customer with ID " + customer.getCustomerId());
			}
		}

		customer.addVehicleToCustomer(vehicleToAdd);
		System.out.println("Customer " + customer.getCustomerId() + " add the vehicle: " + vehicleToAdd);
	}

	// get List of vehicles for a specific customer
	public List<Vehicle> getListOfVehiclesForCustomer(Customer customer) {
		if (!customer.getListOfVehiclesForCustomer().isEmpty()) {
			System.out.println("Customer with customer ID " + customer.getCustomerId() + " owns the vehicles: "
					+ customer.getListOfVehiclesForCustomer());
			return customer.getListOfVehiclesForCustomer();
		} else {
			throw new IllegalArgumentException(
					"List of vehicles for customer with ID " + customer.getCustomerId() + " is empty");
		}
	}

	// remove specific vehicle from list of vehicle for a specific customer

	public void removeVehicleForCustomer(Customer customer, Vehicle vehicleToRemove) {
		if (!customer.getListOfVehiclesForCustomer().isEmpty()) {

			customer.removeVehicleForCustomer(vehicleToRemove);

			System.out.println("Vehicle with license plate " + vehicleToRemove.getLicensePlate()
					+ " removed from customer " + customer.getCustomerId());
		}

		else {
			throw new IllegalArgumentException(
					"List of vehicles for customer with ID " + customer.getCustomerId() + " is empty");
		}

	}

	public void getVehicleForCustomer(Customer customer, Vehicle vehicleToSearch) {
		if (!customer.getListOfVehiclesForCustomer().isEmpty()) {
			List<Vehicle> listOfSearchedVehicle = new ArrayList<>();
			for (Vehicle vehicle : customer.getListOfVehiclesForCustomer()) {
				if (vehicle.equals(vehicleToSearch)) {
					listOfSearchedVehicle.add(vehicleToSearch);
					System.out.println("Found " + vehicleToSearch + " for customer " + customer);
				}
			}

			if (listOfSearchedVehicle.isEmpty()) {
				throw new IllegalArgumentException(
						vehicleToSearch + " not found in list of vehicles for customer" + customer);
			}
		} else {

			throw new IllegalArgumentException(
					"The list of vehicles for customer " + customer.getCustomerId() + " is empty");
		}
	}
}
