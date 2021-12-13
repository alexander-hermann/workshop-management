package de.hs_kl.staab.planner;

import java.time.LocalDateTime;
import java.util.ArrayList;

abstract class Appointment {
	protected static int APPOINTMENT_NUMBER_COUNTER = 0;
	protected static final String APPOINTMENT_PREFIX = "AP-";
	protected String appointmentId;
	protected String dateOfAppointment;
	protected LocalDateTime DateOfAppointment;
	protected int calenderWeekOfAppointment;
	protected int test;
	protected static ArrayList<Appointment> listOfAppointment = new ArrayList();

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
