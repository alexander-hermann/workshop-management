package de.hs_kl.staab.planner;

import java.util.ArrayList;
import java.util.List;

public class CarMechanic extends User {
	protected List<WorkingAppointment> listOfWorkingAppointmentForCarMechanic;

	public CarMechanic(String fullName, String phoneNumber, String emailAddress) {
		super(fullName, phoneNumber, emailAddress);
		this.listOfWorkingAppointmentForCarMechanic = new ArrayList<>();
	}

	@Override
	public String toString() {
		return "CarMechanic= " + super.toString();
	}

}
