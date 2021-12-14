package de.hs_kl.staab.planner;

import java.time.LocalDate;

public abstract class Vehicle {

	protected String brand;
	protected String model;
	protected LocalDate DateOfAdmission;
	protected int yearOfConstruction;
	protected String licensePlate;

	public Vehicle(String licensePlate, String brand, String model, int yearOfConstruction, int yearOfAdmission,
			int monthOfAdmission, int dayOfAdmission) {
		this.licensePlate = licensePlate;
		this.brand = brand;
		this.model = model;
		this.yearOfConstruction = yearOfConstruction;
		this.DateOfAdmission = LocalDate.of(yearOfAdmission, monthOfAdmission, dayOfAdmission);
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
