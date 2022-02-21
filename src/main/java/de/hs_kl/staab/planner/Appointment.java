package de.hs_kl.staab.planner;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.IsoFields;

public abstract class Appointment implements Terminable {

	protected final static LocalTime OPENING_TIME_START = LocalTime.of(8, 00);
	protected final static LocalTime OPENING_TIME_END = LocalTime.of(16, 00);

	protected final static int TIME_CONVERSION_FAKTOR_IN_MINUTES = 60;

	protected static final String APPOINTMENT_PREFIX = "AP-";
	protected static int APPOINTMENT_ID_COUNTER = 1;

	protected String idOfAppointment;

	protected final LocalDateTime startOfAppointment;
	protected LocalDateTime endOfAppointment;
	protected final int calenderWeekOfAppointment;
	protected final LocalDate dayOfAppointment;

	public Appointment(int year, int month, int day, int hour, int minute) {
		this.idOfAppointment = APPOINTMENT_PREFIX + APPOINTMENT_ID_COUNTER;
		APPOINTMENT_ID_COUNTER++;

		this.startOfAppointment = LocalDateTime.of(year, month, day, hour, minute);
		this.calenderWeekOfAppointment = startOfAppointment.get(IsoFields.WEEK_OF_WEEK_BASED_YEAR);
		this.dayOfAppointment = LocalDate.of(year, month, day);
	}

	public String getId() {
		return idOfAppointment;
	}

	public void setId(String idOfAppointment) {
		this.idOfAppointment = idOfAppointment;
	}

	public LocalTime getStart() {
		return startOfAppointment.toLocalTime();
	}

	public LocalTime getEnd() {
		return endOfAppointment.toLocalTime();
	}

	public int getCalendarWeek() {
		return calenderWeekOfAppointment;
	}

	public LocalDate getDay() {
		return dayOfAppointment;
	}

	public LocalDateTime getDayWithStartTime() {
		return startOfAppointment;
	}

	public LocalDateTime getDayWithEndTime() {
		return endOfAppointment;
	}

	public abstract WorkingPlatform getWorkingPlatform();

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(" [appointmentId=");
		builder.append(idOfAppointment);
		builder.append(", startOfAppointment=");
		builder.append(this.getStart());
		builder.append(", endOfAppointment=");
		builder.append(this.getEnd());
		builder.append(", calenderWeekOfAppointment=");
		builder.append(calenderWeekOfAppointment);
		builder.append(", dayOfAppointment=");
		builder.append(dayOfAppointment);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public long getDurationInMin() {
		LocalTime startTime = this.getStart();
		LocalTime endTime = this.getEnd();
		long duration = 0;

		duration = Duration.between(startTime, endTime).toMinutes();
		return duration;
	}

	@Override
	public boolean isAppointmentInWorkingTime() {
		LocalTime timePeriod = OPENING_TIME_END.minusMinutes(this.getDurationInMin());

		if (this.getStart().isAfter(OPENING_TIME_START.minusSeconds(1))
				&& this.getStart().isBefore(timePeriod.plusSeconds(1))) {
			return true;
		}
		return false;
	}
}