package de.hs_kl.staab.planner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Vehicle {

	protected final static String VEHICLE_PREFIX = "VH-";
	protected static int VEHICLE_ID_COUNTER = 1;

	protected String idOfVehicle;
	protected String brand;
	protected String model;
	protected LocalDate DateOfAdmission;
	protected int yearOfConstruction;
	protected String licensePlate;
	protected List<WorkingAppointment> listOfWorkingAppointmentForVehicle;

	public Vehicle(String licensePlate, String brand, String model, int yearOfConstruction, int yearOfAdmission,
			int monthOfAdmission, int dayOfAdmission) {
		this.idOfVehicle = VEHICLE_PREFIX + VEHICLE_ID_COUNTER;
		VEHICLE_ID_COUNTER++;

		this.licensePlate = licensePlate;
		this.brand = brand;
		this.model = model;
		this.yearOfConstruction = yearOfConstruction;
		this.DateOfAdmission = LocalDate.of(yearOfAdmission, monthOfAdmission, dayOfAdmission);
		this.listOfWorkingAppointmentForVehicle = new ArrayList<>();
	}

	public String getId() {
		return idOfVehicle;
	}

	public String getBrand() {
		return brand;
	}

	public String getModel() {
		return model;
	}

	public LocalDate getDateOfAdmission() {
		return DateOfAdmission;
	}

	public int getYearOfConstruction() {
		return yearOfConstruction;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Vehicle [idOfVehicle=");
		builder.append(idOfVehicle);
		builder.append(", brand=");
		builder.append(brand);
		builder.append(", model=");
		builder.append(model);
		builder.append(", DateOfAdmission=");
		builder.append(DateOfAdmission);
		builder.append(", yearOfConstruction=");
		builder.append(yearOfConstruction);
		builder.append(", licensePlate=");
		builder.append(licensePlate);
		builder.append("]");
		return builder.toString();
	}
}