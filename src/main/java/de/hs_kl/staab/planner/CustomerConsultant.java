package de.hs_kl.staab.planner;

public class CustomerConsultant extends User {

	public CustomerConsultant(String fullName, String phoneNumber, String emailAddress) {
		super(fullName, phoneNumber, emailAddress);

	}

	@Override
	public String toString() {
		return "CustomerConsultant= " + super.toString();
	}

}
