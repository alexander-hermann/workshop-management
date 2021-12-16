package de.hs_kl.staab.planner;

public class CarMechanic extends User {

	public CarMechanic(String fullName, String phoneNumber, String emailAddress) {
		super(fullName, phoneNumber, emailAddress);

	}

	@Override
	public String toString() {
		return "CarMechanic= " + super.toString();
	}

}
