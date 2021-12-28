package de.hs_kl.staab.planner;

import java.time.LocalDateTime;
import java.time.temporal.IsoFields;

public class Appointment {

	protected final static int TIME_CONVERSION_FAKTOR_IN_MINUTES = 60;

	protected static final String APPOINTMENT_PREFIX = "AP-";
	protected static int APPOINTMENT_ID_COUNTER = 1;

	protected String idOfAppointment;

	protected LocalDateTime startOfAppointment;
	protected LocalDateTime endOfAppointment;
	protected int calenderWeekOfAppointment;

	public Appointment(int year, int month, int day, int hour, int minute) {
		this.idOfAppointment = APPOINTMENT_PREFIX + APPOINTMENT_ID_COUNTER;
		APPOINTMENT_ID_COUNTER++;

		this.startOfAppointment = LocalDateTime.of(year, month, day, hour, minute);
		this.calenderWeekOfAppointment = startOfAppointment.get(IsoFields.WEEK_OF_WEEK_BASED_YEAR);
	}

	public String getId() {
		return idOfAppointment;
	}

	public void setId(String idOfAppointment) {
		this.idOfAppointment = idOfAppointment;
	}

	public int getCalendarWeek() {
		return calenderWeekOfAppointment;
	}

	public int getDay() {
		return startOfAppointment.getDayOfYear();
	}

	public int getMonth() {
		return startOfAppointment.getMonthValue();
	}

	public int getYear() {
		return startOfAppointment.getYear();
	}

	public LocalDateTime getStartOfAppointment() {
		return startOfAppointment;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(" [appointmentId=");
		builder.append(idOfAppointment);
		builder.append(", startOfAppointment=");
		builder.append(startOfAppointment);
		builder.append(", endOfAppointment=");
		builder.append(endOfAppointment);
		builder.append(", calenderWeekOfAppointment=");
		builder.append(calenderWeekOfAppointment);
		builder.append("]");
		return builder.toString();
	}
}