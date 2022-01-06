package de.hs_kl.staab.planner;

public interface Terminable {

	long getDurationInMin();

	boolean isAppointmentInWorkingTime();
}
