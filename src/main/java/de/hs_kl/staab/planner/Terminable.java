package de.hs_kl.staab.planner;

import java.time.LocalDate;

public interface Terminable {

	long getDurationInMin();

	long getTotalHoursOfDay(LocalDate day);

	boolean isAppointmentAvailableInPeriode(Appointment appointment);

	boolean isAppointmentInWorkingTime();
}
