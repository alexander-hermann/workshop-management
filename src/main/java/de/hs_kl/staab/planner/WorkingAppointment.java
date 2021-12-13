package de.hs_kl.staab.planner;

public class WorkingAppointment extends Appointment {
	WorkingPlatform workingPlatform;
	Vehicle vehicle;
	Service service;

	public WorkingAppointment(int year, int month, int day, int hour, int minute, WorkingPlatform workingPlatform,
			Vehicle vehicle, Service service) {
		super(year, month, day, hour, minute);
		this.workingPlatform = workingPlatform;
		this.vehicle = vehicle;
		this.service = service;

		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "WorkingAppointment [workingPlatform=" + workingPlatform + ", vehicle=" + vehicle + ", service="
				+ service + "]" + super.toString();
	}

}
