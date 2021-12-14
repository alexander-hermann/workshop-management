package de.hs_kl.staab.planner;

public class WorkingAppointment extends Appointment {
	private final WorkingPlatform workingPlatform;
	private final Vehicle vehicle;
	private final Service service;
	private final double durationInH;

	public WorkingAppointment(int year, int month, int day, int hour, int minute, WorkingPlatform workingPlatform,
			Vehicle vehicle, Service service) {
		super(year, month, day, hour, minute);
		this.workingPlatform = workingPlatform;
		this.vehicle = vehicle;
		this.service = service;
		this.durationInH = service.getDurationInH();
	}

	public WorkingPlatform getWorkingPlatform() {
		return workingPlatform;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public Service getService() {
		return service;
	}

	public double getDurationInH() {
		return durationInH;
	}

	@Override
	public String toString() {
		return "WorkingAppointment [workingPlatform=" + workingPlatform + ", vehicle=" + vehicle + ", service="
				+ service + "]" + super.toString();
	}

}
