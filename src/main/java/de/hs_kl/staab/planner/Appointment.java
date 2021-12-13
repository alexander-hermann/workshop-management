package de.hs_kl.staab.planner;

import java.time.LocalDateTime;
import java.time.temporal.IsoFields;
import java.util.ArrayList;

public class Appointment {
	protected static int APPOINTMENT_NUMBER_COUNTER = 0;
	protected static final String APPOINTMENT_PREFIX = "AP-";
	protected String appointmentId;

	protected LocalDateTime DateOfAppointment;
	protected int calenderWeekOfAppointment;

	protected static ArrayList<Appointment> listOfAppointment = new ArrayList();

	public Appointment(int year, int month, int day, int hour, int minute) {
		this.DateOfAppointment = LocalDateTime.of(year, month, day, hour, minute);
		this.calenderWeekOfAppointment = DateOfAppointment.get(IsoFields.WEEK_OF_WEEK_BASED_YEAR);

	}

	public static void createNewAppointment(Appointment appointment) {

		listOfAppointment.add(appointment);
	}

	public static ArrayList<Appointment> listOfAppointment() {
		return listOfAppointment;
	}

	@Override
	public String toString() {
		return "Appointment [appointmentId=" + appointmentId + ", DateOfAppointment=" + DateOfAppointment
				+ ", calenderWeekOfAppointment=" + calenderWeekOfAppointment;
	}

}
