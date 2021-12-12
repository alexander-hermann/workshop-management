package de.hs_kl.staab.planner;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Vehicle {

	protected String brand;
	protected String model;
	protected int yearOfConstruction;
	protected LocalDate DateOfAdmission;
	protected String licensePlate;
	private ArrayList<Vehicle> listOfVehicles = new ArrayList<>();

	public Vehicle(String licensePlate, String brand, String model, int yearOfConstruction, LocalDate DateOfAdmission) {
		this.licensePlate = licensePlate;
		this.brand = brand;
		this.model = model;
		this.yearOfConstruction = yearOfConstruction;
		this.DateOfAdmission = DateOfAdmission;

	}

	public void createNewVehicle(Vehicle newVehicle) {

		this.listOfVehicles.add(newVehicle);

	}

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

	public void updateVehicle(Vehicle updateVehicle) {
		if (!listOfVehicles.isEmpty()) {
			for (Vehicle vehicle : listOfVehicles) {
				if (updateVehicle.equals(this)) {
					updateVehicle.licensePlate = this.licensePlate;

					System.out.println("Old object: " + vehicle);
					listOfVehicles.set(listOfVehicles.indexOf(this), updateVehicle);
					System.out.println("New object: " + updateVehicle);
				}
			}
		} else {
			throw new IllegalArgumentException(
					"The vehilce can not be updated, because the list for the vehicle with the license plate "
							+ licensePlate + " is empty.");
		}
	}

	public void removeVehicle(Vehicle removeVehicle) {
		if (!listOfVehicles.isEmpty()) {
			removeVehicle.licensePlate = this.licensePlate;
			listOfVehicles.remove(removeVehicle);
			System.out.println("Vehicle with license plate " + licensePlate + " has been removed ");
		} else {
			throw new IllegalArgumentException(

					"The vehicle can not be updated, because the list for the vehicles with the license plate "
							+ licensePlate + " is empty.");
		}
	}

	@Override
	public String toString() {
		return "Vehicle [brand=" + brand + ", model=" + model + ", yearOfConstruction=" + yearOfConstruction
				+ ", DateOfAdmission=" + DateOfAdmission + ", licensePlate=" + licensePlate + "]";
	}

	public String getBrand() {
		return brand;
	}

	public String getModel() {
		return model;
	}

	public int getYearOfConstruction() {
		return yearOfConstruction;
	}

	public LocalDate getDateOfAdmission() {
		return DateOfAdmission;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

}
