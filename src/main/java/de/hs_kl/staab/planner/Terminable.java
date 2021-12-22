package de.hs_kl.staab.planner;

public interface Terminable {

	int getDuration();

	boolean isAppointmentAvailableInPeriode(Appointment appointment);

	boolean isAppointmentInWorkingTime(Appointment appointment);
}
