package de.hs_kl.staab.planner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Vehicle {

	protected String brand;
	protected String model;
	protected LocalDate DateOfAdmission;
	protected int yearOfConstruction;
	protected String licensePlate;
	protected List<WorkingAppointment> listOfWorkingAppointmentForVehicle;

	public Vehicle(String licensePlate, String brand, String model, int yearOfConstruction, int yearOfAdmission,
			int monthOfAdmission, int dayOfAdmission) {
		this.licensePlate = licensePlate;
		this.brand = brand;
		this.model = model;
		this.yearOfConstruction = yearOfConstruction;
		this.DateOfAdmission = LocalDate.of(yearOfAdmission, monthOfAdmission, dayOfAdmission);
		this.listOfWorkingAppointmentForVehicle = new ArrayList<>();
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
