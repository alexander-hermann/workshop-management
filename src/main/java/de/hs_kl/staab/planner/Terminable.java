package de.hs_kl.staab.planner;

public interface Terminable {

	long getDurationInMin(Appointment appointment);

	long getTotalHoursOfDay(int year, int month, int day);

	boolean isAppointmentAvailableInPeriode(Appointment appointment);

	boolean isAppointmentInWorkingTime(Appointment appointment);
}
