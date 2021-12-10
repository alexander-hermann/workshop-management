package de.hs_kl.staab.planner;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Appointment {
	protected LocalDateTime DateOfAppointment;
	private int calenderWeekOfAppointment;
	private static ArrayList<Appointment> listOfAppointment = new ArrayList();

	public Appointment(LocalDateTime DateOfAppointment, int calenderWeekOfAppointment) {
		this.DateOfAppointment = DateOfAppointment;

	}

	public static void createNewAppointment(Appointment appointment) {

		listOfAppointment.add(appointment);
	}

	public static ArrayList<Appointment> listOfAppointment() {
		return listOfAppointment;
	}

}
