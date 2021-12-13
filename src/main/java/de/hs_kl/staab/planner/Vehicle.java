package de.hs_kl.staab.planner;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Vehicle {

	protected String brand;
	protected String model;
	protected LocalDate DateOfAdmission;
	protected int yearOfConstruction;
	protected String licensePlate;
	private ArrayList<Vehicle> listOfVehicles;

	public Vehicle(String licensePlate, String brand, String model, int yearOfConstruction, int yearDateOfAdmission,
			int monthDateOfAdmission, int dayDateOfAdmission) {
		this.licensePlate = licensePlate;
		this.brand = brand;
		this.model = model;
		this.yearOfConstruction = yearOfConstruction;
		this.DateOfAdmission = LocalDate.of(yearDateOfAdmission, monthDateOfAdmission, dayDateOfAdmission);
	}

	public void createNewVehicle(Vehicle vehicle) {
		listOfVehicles = new ArrayList<>();
		listOfVehicles.add(vehicle);

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
