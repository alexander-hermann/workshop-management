package de.hs_kl.staab.planner;

import java.util.ArrayList;
import java.util.List;

/**
 * Verwaltet die Kunden mit ihren Fahrzeugen
 */
public class CustomerService {

	private List<Customer> listOfCustomers = new ArrayList<>();
	private List<Vehicle> listOfVehicles = new ArrayList<>();
	private List<Vehicle> listOfVehiclesForCustomer = new ArrayList<>();

	// MVP/030

	// Return all vehicles

	public List<Vehicle> getListOfVehicles() {
		return listOfVehicles;
	}

	// Return vehicles for specific customer

	public List<Vehicle> getListOfVehiclesForCustomer() {
		return listOfVehiclesForCustomer;
	}

	// create a new vehicle

	public void createNewVehicle(Vehicle newVehicle) {

		listOfVehicles.add(newVehicle);

	}

	// return the vehicle with the specific license plate

	public Vehicle getVehicleByLicensePlate(String licensePlate) {
		if (!listOfVehicles.isEmpty()) {
			for (Vehicle vehicle : listOfVehicles) {
				if (vehicle.getLicensePlate().equals(licensePlate)) {
					System.out.println("Gefunden");
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
			for (Vehicle vehicle : listOfVehicles) {
				if (vehicle.licensePlate.equals(updateVehicle.getLicensePlate())) {
					updateVehicle.setLicensePlate(vehicle.licensePlate);

				}
				System.out.println("Old object: " + vehicle);
				listOfVehicles.set(listOfVehicles.indexOf(vehicle), updateVehicle);
				System.out.println("New object: " + updateVehicle);
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
			System.out.println("Vehicle with license plate " + removeVehicle.getLicensePlate() + " has been removed ");
		} else {
			throw new IllegalArgumentException(

					"The vehicle can not be updated, because the list for the vehicles with the license plate "
							+ removeVehicle.getLicensePlate() + " is empty.");
		}
	}

	// MVP/040

	// Return all customers

	public List<Customer> getListOfCustomers() {
		return listOfCustomers;
	}

	// create a new customer

	public void createNewCustomer(Customer newCustomer) {

		listOfCustomers.add(newCustomer);
	}

	// return the customer with the specific customer ID

	public Customer getCustomerById(String customerId) {
		if (!listOfCustomers.isEmpty()) {
			for (Person customer : listOfCustomers) {
				if (customer.getCustomerId().equals(customerId)) {
					System.out.println("Gefunden");
					return (Customer) customer;
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
			for (Person customer : listOfCustomers) {
				if (customerId.equals(customer.getCustomerId())) {
					updateCustomer.setCustomerId(customerId);
					System.out.println("Old object: " + customer);
					System.out.println("New object: " + updateCustomer);
					listOfCustomers.set(listOfCustomers.indexOf(customer), updateCustomer);

				}

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
		} else {
			throw new IllegalArgumentException(

					"The customer can not be updated, because the list for the customer with the customer ID "
							+ removeCustomer.getCustomerId() + " is empty.");
		}
	}

}
