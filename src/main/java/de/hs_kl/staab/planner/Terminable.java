package de.hs_kl.staab.planner;

public interface Terminable {

	public int getDuration();

	public boolean isAppointmentAvailableInPeriode(Appointment appointment);

	public boolean isAppointmentInWorkingTime(Appointment appointment);
}
