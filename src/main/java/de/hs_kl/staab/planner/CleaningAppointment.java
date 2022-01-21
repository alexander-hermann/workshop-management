package de.hs_kl.staab.planner;

public class CleaningAppointment extends Appointment {

	private double durationOfCleaningInH;
	private final WorkingPlatform workingPlatform;
	private final Dispatcher dispatcher;

	public CleaningAppointment(int year, int month, int day, int hour, int minute, WorkingPlatform workingPlatform,
			CLEANINGPROGRAMM cleaningProgramm, Dispatcher dispatcher) {
		super(year, month, day, hour, minute);
		this.workingPlatform = workingPlatform;
		this.dispatcher = dispatcher;

		switch (cleaningProgramm) {
		case FAST:
			this.durationOfCleaningInH = 0.5;
			break;
		case INTENSE:
			this.durationOfCleaningInH = 1.0;
			break;
		}
		this.endOfAppointment = this.startOfAppointment
				.plusMinutes((long) (this.durationOfCleaningInH * TIME_CONVERSION_FAKTOR_IN_MINUTES));
	}

	public Dispatcher getDispatcher() {
		return dispatcher;
	}

	public double getDurationOfCleaningInH() {
		return durationOfCleaningInH;
	}

	public WorkingPlatform getWorkingPlatform() {
		return workingPlatform;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CleaningAppointment");
		builder.append(super.toString());
		builder.append(", [durationOfCleaningInH");
		builder.append(durationOfCleaningInH);
		builder.append(", workingPlatform=");
		builder.append(workingPlatform);
		builder.append(", dispatcher=");
		builder.append(dispatcher);
		builder.append("]");
		return builder.toString();
	}
}
