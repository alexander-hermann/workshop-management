package de.hs_kl.staab.planner;

public class Car extends Vehicle {

	public Car(String licensePlate, String brand, String model, int yearOfConstruction, int yearOfAdmission,
			int monthOfAdmission, int dayOfAdmission, Customer customer) {
		super(licensePlate, brand, model, yearOfConstruction, yearOfAdmission, monthOfAdmission, dayOfAdmission,
				customer);

	}

	@Override
	public String toString() {
		return super.toString();
	}

}
