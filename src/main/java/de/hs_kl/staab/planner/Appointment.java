package de.hs_kl.staab.planner;

import java.time.LocalDateTime;
import java.time.temporal.IsoFields;

public class Appointment {
	protected static int APPOINTMENT_NUMBER_COUNTER = 0;
	protected static final String APPOINTMENT_PREFIX = "AP-";
	protected String appointmentId;

	protected LocalDateTime dateOfAppointment;
	protected int calenderWeekOfAppointment;

	public Appointment(int year, int month, int day, int hour, int minute) {
		this.dateOfAppointment = LocalDateTime.of(year, month, day, hour, minute);
		this.calenderWeekOfAppointment = dateOfAppointment.get(IsoFields.WEEK_OF_WEEK_BASED_YEAR);

	}

	public int getCalendarWeek() {
		return calenderWeekOfAppointment;
	}

	public int getDay() {
		return dateOfAppointment.getDayOfYear();
	}

	public int getMonth() {
		return dateOfAppointment.getMonthValue();
	}

	public int getYear() {
		return dateOfAppointment.getYear();
	}

	@Override
	public String toString() {
		return "[appointmentId=" + appointmentId + ", DateOfAppointment=" + dateOfAppointment
				+ ", calenderWeekOfAppointment=" + calenderWeekOfAppointment + "]";
	}

}
