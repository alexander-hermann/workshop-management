package de.hs_kl.staab.planner;

public class CleaningAppointment extends Appointment {

	private double durationOfCleaningInH;
	private final WorkingPlatform workingPlatform;

	public CleaningAppointment(int year, int month, int day, int hour, int minute, WorkingPlatform workingPlatform,
			CLEANINGPROGRAMM cleaningProgramm) {
		super(year, month, day, hour, minute);
		this.workingPlatform = workingPlatform;
		switch (cleaningProgramm) {
		case FAST:
			this.durationOfCleaningInH = 0.5;
		case INTENSE:
			this.durationOfCleaningInH = 1.0;
		}
	}

	public double getDurationOfCleaningInH() {
		return durationOfCleaningInH;
	}

	public WorkingPlatform getWorkingPlatform() {
		return workingPlatform;
	}

	@Override
	public String toString() {
		return "CleaningAppointment [durationOfCleaningInH=" + durationOfCleaningInH + ", workingPlatform="
				+ workingPlatform + "]" + super.toString();
	}

}
