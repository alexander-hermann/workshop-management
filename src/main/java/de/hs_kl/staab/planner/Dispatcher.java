package de.hs_kl.staab.planner;

public class Dispatcher extends User {

	public Dispatcher(String fullName, String phoneNumber, String emailAddress) {
		super(fullName, phoneNumber, emailAddress);

	}

	@Override
	public String toString() {
		return "Dispatcher= " + super.toString();
	}

	public void setUserName(String userName) {

	}

}
