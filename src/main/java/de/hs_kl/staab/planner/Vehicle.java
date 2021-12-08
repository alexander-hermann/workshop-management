package de.hs_kl.staab.planner;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Vehicle {

	protected String brand;
	protected String model;
	protected int yearOfConstruction;
	protected LocalDate DateOfAdmission;
	protected String licensePlate;
	private static ArrayList<Vehicle> listOfVehicles = new ArrayList<>();

	public Vehicle(String licensePlate, String brand, String model, int yearOfConstruction, LocalDate DateOfAdmission) {
		this.licensePlate = licensePlate;
		this.brand = brand;
		this.model = model;
		this.yearOfConstruction = yearOfConstruction;
		this.DateOfAdmission = DateOfAdmission;

	}

	public static void createNewVehicle(Vehicle vehicle) {

		listOfVehicles.add(vehicle);

	}

	public static Vehicle getVehicleByLicensePlate(String licensePlate) {

		for (Vehicle vehicle : listOfVehicles) {
			if (vehicle.getLicensePlate().equals(licensePlate)) {
				System.out.println("Gefunden");
				return vehicle;
			}

		}
		System.out.println("Nichts gefunden");
		return null;
		// continue
	}

	public static ArrayList<Vehicle> getListOfVehicles() {
		return listOfVehicles;
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

}
