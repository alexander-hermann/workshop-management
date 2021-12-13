package de.hs_kl.staab.planner;

public class CleaningAppointment extends Appointment {

	double durationOfCleaningInH;
	WorkingPlatform workingPlatform;

	public CleaningAppointment(int year, int month, int day, int hour, int minute, WorkingPlatform workingPlatform,
			CLEANINGPROGRAMM cleaningProgramm) {
		super(year, month, day, hour, minute);
		this.workingPlatform = workingPlatform;
		if (cleaningProgramm.equals(cleaningProgramm.FAST)) {
			this.durationOfCleaningInH = 0.5;
		} else if (cleaningProgramm.equals(cleaningProgramm.INTENSE)) {
			this.durationOfCleaningInH = 1.0;
		}
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "CleaningAppointment [durationOfCleaningInH=" + durationOfCleaningInH + ", workingPlatform="
				+ workingPlatform + "]" + super.toString();
	}

}
